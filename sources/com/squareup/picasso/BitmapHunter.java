package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import com.squareup.picasso.Downloader.ResponseException;
import com.squareup.picasso.Picasso.LoadedFrom;
import com.squareup.picasso.Picasso.Priority;
import com.squareup.picasso.RequestHandler.Result;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

class BitmapHunter implements Runnable {
    private static final Object DECODE_LOCK = new Object();
    private static final RequestHandler ERRORING_HANDLER = new RequestHandler() {
        public boolean canHandleRequest(Request data) {
            return true;
        }

        public Result load(Request request, int networkPolicy) throws IOException {
            StringBuilder sb = new StringBuilder();
            sb.append("Unrecognized type of request: ");
            sb.append(request);
            throw new IllegalStateException(sb.toString());
        }
    };
    private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
        /* access modifiers changed from: protected */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();
    Action action;
    List<Action> actions;
    final Cache cache;
    final Request data;
    final Dispatcher dispatcher;
    Exception exception;
    int exifRotation;
    Future<?> future;
    final String key;
    LoadedFrom loadedFrom;
    final int memoryPolicy;
    int networkPolicy;
    final Picasso picasso;
    Priority priority;
    final RequestHandler requestHandler;
    Bitmap result;
    int retryCount;
    final int sequence = SEQUENCE_GENERATOR.incrementAndGet();
    final Stats stats;

    BitmapHunter(Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action2, RequestHandler requestHandler2) {
        this.picasso = picasso2;
        this.dispatcher = dispatcher2;
        this.cache = cache2;
        this.stats = stats2;
        this.action = action2;
        this.key = action2.getKey();
        this.data = action2.getRequest();
        this.priority = action2.getPriority();
        this.memoryPolicy = action2.getMemoryPolicy();
        this.networkPolicy = action2.getNetworkPolicy();
        this.requestHandler = requestHandler2;
        this.retryCount = requestHandler2.getRetryCount();
    }

    static Bitmap decodeStream(InputStream stream, Request request) throws IOException {
        MarkableInputStream markStream = new MarkableInputStream(stream);
        MarkableInputStream markableInputStream = markStream;
        long mark = markStream.savePosition(65536);
        Options options = RequestHandler.createBitmapOptions(request);
        boolean calculateSize = RequestHandler.requiresInSampleSize(options);
        boolean isWebPFile = Utils.isWebPFile(markableInputStream);
        markStream.reset(mark);
        if (isWebPFile) {
            byte[] bytes = Utils.toByteArray(markableInputStream);
            if (calculateSize) {
                BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
                RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, options, request);
            }
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length, options);
        }
        if (calculateSize) {
            BitmapFactory.decodeStream(markableInputStream, null, options);
            RequestHandler.calculateInSampleSize(request.targetWidth, request.targetHeight, options, request);
            markStream.reset(mark);
        }
        Bitmap bitmap = BitmapFactory.decodeStream(markableInputStream, null, options);
        if (bitmap != null) {
            return bitmap;
        }
        throw new IOException("Failed to decode stream.");
    }

    public void run() {
        String str = "Picasso-Idle";
        try {
            updateThreadName(this.data);
            if (this.picasso.loggingEnabled) {
                Utils.log("Hunter", "executing", Utils.getLogIdsForHunter(this));
            }
            this.result = hunt();
            if (this.result == null) {
                this.dispatcher.dispatchFailed(this);
            } else {
                this.dispatcher.dispatchComplete(this);
            }
        } catch (ResponseException e) {
            if (!e.localCacheOnly || e.responseCode != 504) {
                this.exception = e;
            }
            this.dispatcher.dispatchFailed(this);
        } catch (ContentLengthException e2) {
            this.exception = e2;
            this.dispatcher.dispatchRetry(this);
        } catch (IOException e3) {
            this.exception = e3;
            this.dispatcher.dispatchRetry(this);
        } catch (OutOfMemoryError e4) {
            StringWriter writer = new StringWriter();
            this.stats.createSnapshot().dump(new PrintWriter(writer));
            this.exception = new RuntimeException(writer.toString(), e4);
            this.dispatcher.dispatchFailed(this);
        } catch (Exception e5) {
            this.exception = e5;
            this.dispatcher.dispatchFailed(this);
        } catch (Throwable th) {
            Thread.currentThread().setName(str);
            throw th;
        }
        Thread.currentThread().setName(str);
    }

    /* access modifiers changed from: 0000 */
    public Bitmap hunt() throws IOException {
        Bitmap bitmap = null;
        if (MemoryPolicy.shouldReadFromMemoryCache(this.memoryPolicy)) {
            bitmap = this.cache.get(this.key);
            if (bitmap != null) {
                this.stats.dispatchCacheHit();
                this.loadedFrom = LoadedFrom.MEMORY;
                if (this.picasso.loggingEnabled) {
                    Utils.log("Hunter", "decoded", this.data.logId(), "from cache");
                }
                return bitmap;
            }
        }
        this.data.networkPolicy = this.retryCount == 0 ? NetworkPolicy.OFFLINE.index : this.networkPolicy;
        Result result2 = this.requestHandler.load(this.data, this.networkPolicy);
        if (result2 != null) {
            this.loadedFrom = result2.getLoadedFrom();
            this.exifRotation = result2.getExifOrientation();
            bitmap = result2.getBitmap();
            if (bitmap == null) {
                InputStream is = result2.getStream();
                try {
                    bitmap = decodeStream(is, this.data);
                } finally {
                    Utils.closeQuietly(is);
                }
            }
        }
        if (bitmap != null) {
            if (this.picasso.loggingEnabled) {
                Utils.log("Hunter", "decoded", this.data.logId());
            }
            this.stats.dispatchBitmapDecoded(bitmap);
            if (this.data.needsTransformation() || this.exifRotation != 0) {
                synchronized (DECODE_LOCK) {
                    if (this.data.needsMatrixTransform() || this.exifRotation != 0) {
                        bitmap = transformResult(this.data, bitmap, this.exifRotation);
                        if (this.picasso.loggingEnabled) {
                            Utils.log("Hunter", "transformed", this.data.logId());
                        }
                    }
                    if (this.data.hasCustomTransformations()) {
                        bitmap = applyCustomTransformations(this.data.transformations, bitmap);
                        if (this.picasso.loggingEnabled) {
                            Utils.log("Hunter", "transformed", this.data.logId(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.stats.dispatchBitmapTransformed(bitmap);
                }
            }
        }
        return bitmap;
    }

    /* access modifiers changed from: 0000 */
    public void attach(Action action2) {
        boolean loggingEnabled = this.picasso.loggingEnabled;
        Request request = action2.request;
        String str = "to ";
        String str2 = "joined";
        String str3 = "Hunter";
        if (this.action == null) {
            this.action = action2;
            if (loggingEnabled) {
                List<Action> list = this.actions;
                if (list == null || list.isEmpty()) {
                    Utils.log(str3, str2, request.logId(), "to empty hunter");
                } else {
                    Utils.log(str3, str2, request.logId(), Utils.getLogIdsForHunter(this, str));
                }
            }
            return;
        }
        if (this.actions == null) {
            this.actions = new ArrayList(3);
        }
        this.actions.add(action2);
        if (loggingEnabled) {
            Utils.log(str3, str2, request.logId(), Utils.getLogIdsForHunter(this, str));
        }
        Priority actionPriority = action2.getPriority();
        if (actionPriority.ordinal() > this.priority.ordinal()) {
            this.priority = actionPriority;
        }
    }

    /* access modifiers changed from: 0000 */
    public void detach(Action action2) {
        boolean detached = false;
        if (this.action == action2) {
            this.action = null;
            detached = true;
        } else {
            List<Action> list = this.actions;
            if (list != null) {
                detached = list.remove(action2);
            }
        }
        if (detached && action2.getPriority() == this.priority) {
            this.priority = computeNewPriority();
        }
        if (this.picasso.loggingEnabled) {
            Utils.log("Hunter", "removed", action2.request.logId(), Utils.getLogIdsForHunter(this, "from "));
        }
    }

    private Priority computeNewPriority() {
        Priority newPriority = Priority.LOW;
        List<Action> list = this.actions;
        boolean hasAny = false;
        boolean hasMultiple = list != null && !list.isEmpty();
        if (this.action != null || hasMultiple) {
            hasAny = true;
        }
        if (!hasAny) {
            return newPriority;
        }
        Action action2 = this.action;
        if (action2 != null) {
            newPriority = action2.getPriority();
        }
        if (hasMultiple) {
            int n = this.actions.size();
            for (int i = 0; i < n; i++) {
                Priority actionPriority = ((Action) this.actions.get(i)).getPriority();
                if (actionPriority.ordinal() > newPriority.ordinal()) {
                    newPriority = actionPriority;
                }
            }
        }
        return newPriority;
    }

    /* access modifiers changed from: 0000 */
    public boolean cancel() {
        if (this.action != null) {
            return false;
        }
        List<Action> list = this.actions;
        if (list != null && !list.isEmpty()) {
            return false;
        }
        Future<?> future2 = this.future;
        if (future2 == null || !future2.cancel(false)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public boolean isCancelled() {
        Future<?> future2 = this.future;
        return future2 != null && future2.isCancelled();
    }

    /* access modifiers changed from: 0000 */
    public boolean shouldRetry(boolean airplaneMode, NetworkInfo info) {
        if (!(this.retryCount > 0)) {
            return false;
        }
        this.retryCount--;
        return this.requestHandler.shouldRetry(airplaneMode, info);
    }

    /* access modifiers changed from: 0000 */
    public boolean supportsReplay() {
        return this.requestHandler.supportsReplay();
    }

    /* access modifiers changed from: 0000 */
    public Bitmap getResult() {
        return this.result;
    }

    /* access modifiers changed from: 0000 */
    public String getKey() {
        return this.key;
    }

    /* access modifiers changed from: 0000 */
    public int getMemoryPolicy() {
        return this.memoryPolicy;
    }

    /* access modifiers changed from: 0000 */
    public Request getData() {
        return this.data;
    }

    /* access modifiers changed from: 0000 */
    public Action getAction() {
        return this.action;
    }

    /* access modifiers changed from: 0000 */
    public Picasso getPicasso() {
        return this.picasso;
    }

    /* access modifiers changed from: 0000 */
    public List<Action> getActions() {
        return this.actions;
    }

    /* access modifiers changed from: 0000 */
    public Exception getException() {
        return this.exception;
    }

    /* access modifiers changed from: 0000 */
    public LoadedFrom getLoadedFrom() {
        return this.loadedFrom;
    }

    /* access modifiers changed from: 0000 */
    public Priority getPriority() {
        return this.priority;
    }

    static void updateThreadName(Request data2) {
        String name = data2.getName();
        StringBuilder builder = (StringBuilder) NAME_BUILDER.get();
        String str = "Picasso-";
        builder.ensureCapacity(str.length() + name.length());
        builder.replace(str.length(), builder.length(), name);
        Thread.currentThread().setName(builder.toString());
    }

    static BitmapHunter forRequest(Picasso picasso2, Dispatcher dispatcher2, Cache cache2, Stats stats2, Action action2) {
        Request request = action2.getRequest();
        List<RequestHandler> requestHandlers = picasso2.getRequestHandlers();
        int count = requestHandlers.size();
        for (int i = 0; i < count; i++) {
            RequestHandler requestHandler2 = (RequestHandler) requestHandlers.get(i);
            if (requestHandler2.canHandleRequest(request)) {
                BitmapHunter bitmapHunter = new BitmapHunter(picasso2, dispatcher2, cache2, stats2, action2, requestHandler2);
                return bitmapHunter;
            }
        }
        BitmapHunter bitmapHunter2 = new BitmapHunter(picasso2, dispatcher2, cache2, stats2, action2, ERRORING_HANDLER);
        return bitmapHunter2;
    }

    static Bitmap applyCustomTransformations(List<Transformation> transformations, Bitmap result2) {
        int i = 0;
        int count = transformations.size();
        while (i < count) {
            final Transformation transformation = (Transformation) transformations.get(i);
            try {
                Bitmap newResult = transformation.transform(result2);
                if (newResult == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Transformation ");
                    sb.append(transformation.key());
                    sb.append(" returned null after ");
                    sb.append(i);
                    final StringBuilder builder = sb.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (Transformation t : transformations) {
                        builder.append(t.key());
                        builder.append(10);
                    }
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(builder.toString());
                        }
                    });
                    return null;
                } else if (newResult == result2 && result2.isRecycled()) {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Transformation ");
                            sb.append(transformation.key());
                            sb.append(" returned input Bitmap but recycled it.");
                            throw new IllegalStateException(sb.toString());
                        }
                    });
                    return null;
                } else if (newResult == result2 || result2.isRecycled()) {
                    result2 = newResult;
                    i++;
                } else {
                    Picasso.HANDLER.post(new Runnable() {
                        public void run() {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Transformation ");
                            sb.append(transformation.key());
                            sb.append(" mutated input Bitmap but failed to recycle the original.");
                            throw new IllegalStateException(sb.toString());
                        }
                    });
                    return null;
                }
            } catch (RuntimeException e) {
                Picasso.HANDLER.post(new Runnable() {
                    public void run() {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Transformation ");
                        sb.append(transformation.key());
                        sb.append(" crashed with exception.");
                        throw new RuntimeException(sb.toString(), e);
                    }
                });
                return null;
            }
        }
        return result2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Bitmap transformResult(com.squareup.picasso.Request r19, android.graphics.Bitmap r20, int r21) {
        /*
            r0 = r19
            r1 = r21
            int r2 = r20.getWidth()
            int r3 = r20.getHeight()
            boolean r4 = r0.onlyScaleDown
            r5 = 0
            r6 = 0
            r7 = r2
            r8 = r3
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>()
            boolean r10 = r19.needsMatrixTransform()
            if (r10 == 0) goto L_0x00d3
            int r10 = r0.targetWidth
            int r11 = r0.targetHeight
            float r12 = r0.rotationDegrees
            r13 = 0
            int r13 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r13 == 0) goto L_0x0037
            boolean r13 = r0.hasRotationPivot
            if (r13 == 0) goto L_0x0034
            float r13 = r0.rotationPivotX
            float r14 = r0.rotationPivotY
            r9.setRotate(r12, r13, r14)
            goto L_0x0037
        L_0x0034:
            r9.setRotate(r12)
        L_0x0037:
            boolean r13 = r0.centerCrop
            if (r13 == 0) goto L_0x0090
            float r13 = (float) r10
            float r14 = (float) r2
            float r13 = r13 / r14
            float r14 = (float) r11
            float r15 = (float) r3
            float r14 = r14 / r15
            int r15 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
            if (r15 <= 0) goto L_0x0064
            float r15 = (float) r3
            float r16 = r14 / r13
            float r15 = r15 * r16
            r16 = r5
            r17 = r6
            double r5 = (double) r15
            double r5 = java.lang.Math.ceil(r5)
            int r5 = (int) r5
            int r6 = r3 - r5
            int r6 = r6 / 2
            r8 = r5
            r15 = r13
            r18 = r5
            float r5 = (float) r11
            r17 = r6
            float r6 = (float) r8
            float r5 = r5 / r6
            r6 = r17
            goto L_0x0082
        L_0x0064:
            r16 = r5
            r17 = r6
            float r5 = (float) r2
            float r6 = r13 / r14
            float r5 = r5 * r6
            double r5 = (double) r5
            double r5 = java.lang.Math.ceil(r5)
            int r5 = (int) r5
            int r6 = r2 - r5
            int r6 = r6 / 2
            r7 = r5
            float r15 = (float) r10
            r18 = r5
            float r5 = (float) r7
            float r15 = r15 / r5
            r5 = r14
            r16 = r6
            r6 = r17
        L_0x0082:
            boolean r17 = shouldResize(r4, r2, r3, r10, r11)
            if (r17 == 0) goto L_0x008b
            r9.preScale(r15, r5)
        L_0x008b:
            r17 = r6
            r5 = r16
            goto L_0x00d9
        L_0x0090:
            r16 = r5
            r17 = r6
            boolean r5 = r0.centerInside
            if (r5 == 0) goto L_0x00af
            float r5 = (float) r10
            float r6 = (float) r2
            float r5 = r5 / r6
            float r6 = (float) r11
            float r13 = (float) r3
            float r6 = r6 / r13
            int r13 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a4
            r13 = r5
            goto L_0x00a5
        L_0x00a4:
            r13 = r6
        L_0x00a5:
            boolean r14 = shouldResize(r4, r2, r3, r10, r11)
            if (r14 == 0) goto L_0x00b4
            r9.preScale(r13, r13)
            goto L_0x00b4
        L_0x00af:
            if (r10 != 0) goto L_0x00b5
            if (r11 == 0) goto L_0x00b4
            goto L_0x00b5
        L_0x00b4:
            goto L_0x00d7
        L_0x00b5:
            if (r10 != r2) goto L_0x00b9
            if (r11 == r3) goto L_0x00b4
        L_0x00b9:
            if (r10 == 0) goto L_0x00be
            float r5 = (float) r10
            float r6 = (float) r2
            goto L_0x00c0
        L_0x00be:
            float r5 = (float) r11
            float r6 = (float) r3
        L_0x00c0:
            float r5 = r5 / r6
            if (r11 == 0) goto L_0x00c6
            float r6 = (float) r11
            float r13 = (float) r3
            goto L_0x00c8
        L_0x00c6:
            float r6 = (float) r10
            float r13 = (float) r2
        L_0x00c8:
            float r6 = r6 / r13
            boolean r13 = shouldResize(r4, r2, r3, r10, r11)
            if (r13 == 0) goto L_0x00d7
            r9.preScale(r5, r6)
            goto L_0x00d7
        L_0x00d3:
            r16 = r5
            r17 = r6
        L_0x00d7:
            r5 = r16
        L_0x00d9:
            if (r1 == 0) goto L_0x00df
            float r6 = (float) r1
            r9.preRotate(r6)
        L_0x00df:
            r16 = 1
            r10 = r20
            r11 = r5
            r12 = r17
            r13 = r7
            r14 = r8
            r15 = r9
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r10, r11, r12, r13, r14, r15, r16)
            if (r6 == r10) goto L_0x00f3
            r20.recycle()
            r10 = r6
        L_0x00f3:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.BitmapHunter.transformResult(com.squareup.picasso.Request, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    private static boolean shouldResize(boolean onlyScaleDown, int inWidth, int inHeight, int targetWidth, int targetHeight) {
        return !onlyScaleDown || inWidth > targetWidth || inHeight > targetHeight;
    }
}
