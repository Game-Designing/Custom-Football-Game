package com.fyber.inneractive.sdk.util;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/* renamed from: com.fyber.inneractive.sdk.util.ab */
public final class C7987ab extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    private String f16303a;

    /* renamed from: b */
    private C7988a f16304b;

    /* renamed from: com.fyber.inneractive.sdk.util.ab$a */
    public interface C7988a {
        /* renamed from: a */
        void mo24562a();

        /* renamed from: a */
        void mo24563a(Bitmap bitmap);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m18030b();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        C7988a aVar = this.f16304b;
        if (aVar != null) {
            if (bitmap != null) {
                aVar.mo24563a(bitmap);
                return;
            }
            aVar.mo24562a();
        }
    }

    public C7987ab(String str, C7988a aVar) {
        this.f16303a = str;
        this.f16304b = aVar;
    }

    /* renamed from: a */
    public final void mo24831a() {
        this.f16304b = null;
        super.cancel(true);
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r5v0, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r4v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r5v4, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r4v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r5v5 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r5v6, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r6v5, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r5v8, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r4v11, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r4v14 */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v19 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* JADX WARNING: type inference failed for: r6v7, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r5v12, types: [java.io.BufferedInputStream] */
    /* JADX WARNING: type inference failed for: r2v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v13 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r4v28, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r5v16 */
    /* JADX WARNING: type inference failed for: r5v17 */
    /* JADX WARNING: type inference failed for: r5v18 */
    /* JADX WARNING: type inference failed for: r5v19, types: [java.io.BufferedInputStream, java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r6v9 */
    /* JADX WARNING: type inference failed for: r6v10, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r5v20 */
    /* JADX WARNING: type inference failed for: r4v29 */
    /* JADX WARNING: type inference failed for: r5v21 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r4v30 */
    /* JADX WARNING: type inference failed for: r4v31 */
    /* JADX WARNING: type inference failed for: r4v32 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: type inference failed for: r4v33 */
    /* JADX WARNING: type inference failed for: r4v34 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r5v25 */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* JADX WARNING: type inference failed for: r4v37 */
    /* JADX WARNING: type inference failed for: r4v38 */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: type inference failed for: r4v39 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: type inference failed for: r4v40 */
    /* JADX WARNING: type inference failed for: r4v41 */
    /* JADX WARNING: type inference failed for: r4v42 */
    /* JADX WARNING: type inference failed for: r4v43 */
    /* JADX WARNING: type inference failed for: r4v44 */
    /* JADX WARNING: type inference failed for: r4v45 */
    /* JADX WARNING: type inference failed for: r4v46 */
    /* JADX WARNING: type inference failed for: r4v47 */
    /* JADX WARNING: type inference failed for: r4v48 */
    /* JADX WARNING: type inference failed for: r4v49 */
    /* JADX WARNING: type inference failed for: r4v50 */
    /* JADX WARNING: type inference failed for: r4v51 */
    /* JADX WARNING: type inference failed for: r4v52 */
    /* JADX WARNING: type inference failed for: r5v29 */
    /* JADX WARNING: type inference failed for: r5v30 */
    /* JADX WARNING: type inference failed for: r5v31 */
    /* JADX WARNING: type inference failed for: r5v32 */
    /* JADX WARNING: type inference failed for: r5v33 */
    /* JADX WARNING: type inference failed for: r5v34 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
        r0 = e;
        r4 = r4;
        r5 = r5;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0062, code lost:
        r0 = e;
        r4 = r4;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0065, code lost:
        r0 = e;
        r4 = r4;
        r5 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0068, code lost:
        r0 = e;
        r4 = r4;
        r5 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r5v1
      assigns: []
      uses: []
      mth insns count: 203
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x016e A[SYNTHETIC, Splitter:B:109:0x016e] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x017f A[SYNTHETIC, Splitter:B:117:0x017f] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0062 A[ExcHandler: Exception (e java.lang.Exception), Splitter:B:10:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0065 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:10:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0068 A[ExcHandler: MalformedURLException (e java.net.MalformedURLException), Splitter:B:10:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00e2 A[Catch:{ all -> 0x017c }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00e7 A[SYNTHETIC, Splitter:B:73:0x00e7] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x011c A[SYNTHETIC, Splitter:B:85:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0145 A[SYNTHETIC, Splitter:B:97:0x0145] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:106:0x0157=Splitter:B:106:0x0157, B:82:0x00f9=Splitter:B:82:0x00f9, B:68:0x00cb=Splitter:B:68:0x00cb, B:94:0x012e=Splitter:B:94:0x012e} */
    /* JADX WARNING: Unknown variable types count: 32 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m18030b() {
        /*
            r9 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 0
            com.fyber.inneractive.sdk.f.b r3 = new com.fyber.inneractive.sdk.f.b     // Catch:{ MalformedURLException -> 0x0153, IOException -> 0x012a, Exception -> 0x00f5, OutOfMemoryError -> 0x00c6, all -> 0x00c0 }
            java.lang.String r4 = r9.f16303a     // Catch:{ MalformedURLException -> 0x0153, IOException -> 0x012a, Exception -> 0x00f5, OutOfMemoryError -> 0x00c6, all -> 0x00c0 }
            r3.<init>(r4)     // Catch:{ MalformedURLException -> 0x0153, IOException -> 0x012a, Exception -> 0x00f5, OutOfMemoryError -> 0x00c6, all -> 0x00c0 }
            r4 = 5000(0x1388, float:7.006E-42)
            r3.f15437c = r4     // Catch:{ MalformedURLException -> 0x00bc, IOException -> 0x00b8, Exception -> 0x00b5, OutOfMemoryError -> 0x00b2, all -> 0x00af }
            r4 = 3000(0xbb8, float:4.204E-42)
            boolean r4 = r3.mo24296a(r4, r2)     // Catch:{ MalformedURLException -> 0x00bc, IOException -> 0x00b8, Exception -> 0x00b5, OutOfMemoryError -> 0x00b2, all -> 0x00af }
            if (r4 == 0) goto L_0x007f
            java.lang.Object r4 = r3.mo24294a()     // Catch:{ MalformedURLException -> 0x00bc, IOException -> 0x00b8, Exception -> 0x00b5, OutOfMemoryError -> 0x00b2, all -> 0x00af }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ MalformedURLException -> 0x00bc, IOException -> 0x00b8, Exception -> 0x00b5, OutOfMemoryError -> 0x00b2, all -> 0x00af }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ MalformedURLException -> 0x007b, IOException -> 0x0077, Exception -> 0x0073, OutOfMemoryError -> 0x006f, all -> 0x006b }
            r5.<init>(r4)     // Catch:{ MalformedURLException -> 0x007b, IOException -> 0x0077, Exception -> 0x0073, OutOfMemoryError -> 0x006f, all -> 0x006b }
            android.graphics.Bitmap r6 = android.graphics.BitmapFactory.decodeStream(r5)     // Catch:{ MalformedURLException -> 0x0068, IOException -> 0x0065, Exception -> 0x0062, OutOfMemoryError -> 0x005e }
            boolean r7 = m18029a(r6)     // Catch:{ MalformedURLException -> 0x0068, IOException -> 0x0065, Exception -> 0x0062, OutOfMemoryError -> 0x005b }
            if (r7 != 0) goto L_0x0046
            java.lang.String r0 = "SimpleImageLoader: Got an invalid bitmap"
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)     // Catch:{ MalformedURLException -> 0x0068, IOException -> 0x0065, Exception -> 0x0062, OutOfMemoryError -> 0x005b }
            if (r4 == 0) goto L_0x0042
            r4.close()     // Catch:{ IOException -> 0x0041 }
            r5.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0042
        L_0x0041:
            r0 = move-exception
        L_0x0042:
            r3.mo24301e()
            return r2
        L_0x0046:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0068, IOException -> 0x0065, Exception -> 0x0062, OutOfMemoryError -> 0x005b }
            java.lang.String r8 = "SimpleImageLoader: Got a valid bitmap "
            r7.<init>(r8)     // Catch:{ MalformedURLException -> 0x0068, IOException -> 0x0065, Exception -> 0x0062, OutOfMemoryError -> 0x005b }
            java.lang.String r8 = r9.f16303a     // Catch:{ MalformedURLException -> 0x0068, IOException -> 0x0065, Exception -> 0x0062, OutOfMemoryError -> 0x005b }
            r7.append(r8)     // Catch:{ MalformedURLException -> 0x0068, IOException -> 0x0065, Exception -> 0x0062, OutOfMemoryError -> 0x005b }
            java.lang.String r7 = r7.toString()     // Catch:{ MalformedURLException -> 0x0068, IOException -> 0x0065, Exception -> 0x0062, OutOfMemoryError -> 0x005b }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r7)     // Catch:{ MalformedURLException -> 0x0068, IOException -> 0x0065, Exception -> 0x0062, OutOfMemoryError -> 0x005b }
            r2 = r4
            goto L_0x0086
        L_0x005b:
            r0 = move-exception
            goto L_0x00cb
        L_0x005e:
            r0 = move-exception
            r6 = r2
            goto L_0x00cb
        L_0x0062:
            r0 = move-exception
            goto L_0x00f9
        L_0x0065:
            r0 = move-exception
            goto L_0x012e
        L_0x0068:
            r0 = move-exception
            goto L_0x0157
        L_0x006b:
            r0 = move-exception
            r5 = r2
            goto L_0x017d
        L_0x006f:
            r0 = move-exception
            r5 = r2
            goto L_0x00ca
        L_0x0073:
            r0 = move-exception
            r5 = r2
            goto L_0x00f9
        L_0x0077:
            r0 = move-exception
            r5 = r2
            goto L_0x012e
        L_0x007b:
            r0 = move-exception
            r5 = r2
            goto L_0x0157
        L_0x007f:
            java.lang.String r4 = "SimpleImageLoader: Connection timeout or failure"
            com.fyber.inneractive.sdk.util.IAlog.m18022c(r4)     // Catch:{ MalformedURLException -> 0x00bc, IOException -> 0x00b8, Exception -> 0x00b5, OutOfMemoryError -> 0x00b2, all -> 0x00af }
            r5 = r2
            r6 = r5
        L_0x0086:
            if (r2 == 0) goto L_0x0090
            r2.close()     // Catch:{ IOException -> 0x008f }
            r5.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0090
        L_0x008f:
            r2 = move-exception
        L_0x0090:
            r3.mo24301e()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "SimpleImageLoader: fetch + validate took "
            r2.<init>(r3)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r0
            r2.append(r3)
            java.lang.String r0 = " millis"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)
            return r6
        L_0x00af:
            r0 = move-exception
            r4 = r2
            goto L_0x00c3
        L_0x00b2:
            r0 = move-exception
            r4 = r2
            goto L_0x00c9
        L_0x00b5:
            r0 = move-exception
            r4 = r2
            goto L_0x00f8
        L_0x00b8:
            r0 = move-exception
            r4 = r2
            goto L_0x012d
        L_0x00bc:
            r0 = move-exception
            r4 = r2
            goto L_0x0156
        L_0x00c0:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x00c3:
            r5 = r4
            goto L_0x017d
        L_0x00c6:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x00c9:
            r5 = r4
        L_0x00ca:
            r6 = r5
        L_0x00cb:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            java.lang.String r7 = "SimpleImageLoader: OutOfMemoryError on load image"
            r1.<init>(r7)     // Catch:{ all -> 0x017c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x017c }
            r1.append(r0)     // Catch:{ all -> 0x017c }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x017c }
            com.fyber.inneractive.sdk.util.IAlog.m18022c(r0)     // Catch:{ all -> 0x017c }
            if (r6 == 0) goto L_0x00e5
            r6.recycle()     // Catch:{ all -> 0x017c }
        L_0x00e5:
            if (r4 == 0) goto L_0x00ef
            r4.close()     // Catch:{ IOException -> 0x00ee }
            r5.close()     // Catch:{ IOException -> 0x00ee }
            goto L_0x00ef
        L_0x00ee:
            r0 = move-exception
        L_0x00ef:
            if (r3 == 0) goto L_0x00f4
            r3.mo24301e()
        L_0x00f4:
            return r2
        L_0x00f5:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x00f8:
            r5 = r4
        L_0x00f9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            java.lang.String r6 = "SimpleImageLoader: Exception on load image "
            r1.<init>(r6)     // Catch:{ all -> 0x017c }
            java.lang.String r6 = r0.getMessage()     // Catch:{ all -> 0x017c }
            r1.append(r6)     // Catch:{ all -> 0x017c }
            java.lang.String r6 = " "
            r1.append(r6)     // Catch:{ all -> 0x017c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x017c }
            r1.append(r0)     // Catch:{ all -> 0x017c }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x017c }
            com.fyber.inneractive.sdk.util.IAlog.m18022c(r0)     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x0124
            r4.close()     // Catch:{ IOException -> 0x0123 }
            r5.close()     // Catch:{ IOException -> 0x0123 }
            goto L_0x0124
        L_0x0123:
            r0 = move-exception
        L_0x0124:
            if (r3 == 0) goto L_0x0129
            r3.mo24301e()
        L_0x0129:
            return r2
        L_0x012a:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x012d:
            r5 = r4
        L_0x012e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            java.lang.String r6 = "SimpleImageLoader: IOException on load image"
            r1.<init>(r6)     // Catch:{ all -> 0x017c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x017c }
            r1.append(r0)     // Catch:{ all -> 0x017c }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x017c }
            com.fyber.inneractive.sdk.util.IAlog.m18022c(r0)     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x014d
            r4.close()     // Catch:{ IOException -> 0x014c }
            r5.close()     // Catch:{ IOException -> 0x014c }
            goto L_0x014d
        L_0x014c:
            r0 = move-exception
        L_0x014d:
            if (r3 == 0) goto L_0x0152
            r3.mo24301e()
        L_0x0152:
            return r2
        L_0x0153:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x0156:
            r5 = r4
        L_0x0157:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x017c }
            java.lang.String r6 = "SimpleImageLoader: MalformedURLException"
            r1.<init>(r6)     // Catch:{ all -> 0x017c }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x017c }
            r1.append(r0)     // Catch:{ all -> 0x017c }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x017c }
            com.fyber.inneractive.sdk.util.IAlog.m18022c(r0)     // Catch:{ all -> 0x017c }
            if (r4 == 0) goto L_0x0176
            r4.close()     // Catch:{ IOException -> 0x0175 }
            r5.close()     // Catch:{ IOException -> 0x0175 }
            goto L_0x0176
        L_0x0175:
            r0 = move-exception
        L_0x0176:
            if (r3 == 0) goto L_0x017b
            r3.mo24301e()
        L_0x017b:
            return r2
        L_0x017c:
            r0 = move-exception
        L_0x017d:
            if (r4 == 0) goto L_0x0187
            r4.close()     // Catch:{ IOException -> 0x0186 }
            r5.close()     // Catch:{ IOException -> 0x0186 }
            goto L_0x0187
        L_0x0186:
            r1 = move-exception
        L_0x0187:
            if (r3 == 0) goto L_0x018c
            r3.mo24301e()
        L_0x018c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C7987ab.m18030b():android.graphics.Bitmap");
    }

    /* renamed from: a */
    private static boolean m18029a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = -1;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            if (i3 == 0) {
                i2 = i4;
            } else if (i4 != i2) {
                return true;
            }
        }
        return false;
    }
}
