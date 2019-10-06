package com.bumptech.glide.load.p113c.p114a;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.C6347j;
import com.bumptech.glide.load.C6349k;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.engine.C6236E;
import com.bumptech.glide.load.engine.p120a.C6250e;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.c.a.z */
/* compiled from: VideoDecoder */
public class C6188z<T> implements C6350l<T, Bitmap> {

    /* renamed from: a */
    public static final C6347j<Long> f10920a = C6347j.m12246a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", Long.valueOf(-1), new C6186x());

    /* renamed from: b */
    public static final C6347j<Integer> f10921b = C6347j.m12246a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", Integer.valueOf(2), new C6187y());

    /* renamed from: c */
    private static final C6190b f10922c = new C6190b();

    /* renamed from: d */
    private final C6191c<T> f10923d;

    /* renamed from: e */
    private final C6250e f10924e;

    /* renamed from: f */
    private final C6190b f10925f;

    /* renamed from: com.bumptech.glide.load.c.a.z$a */
    /* compiled from: VideoDecoder */
    private static final class C6189a implements C6191c<AssetFileDescriptor> {
        private C6189a() {
        }

        /* synthetic */ C6189a(C6186x x0) {
            this();
        }

        /* renamed from: a */
        public void mo19029a(MediaMetadataRetriever retriever, AssetFileDescriptor data) {
            retriever.setDataSource(data.getFileDescriptor(), data.getStartOffset(), data.getLength());
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.z$b */
    /* compiled from: VideoDecoder */
    static class C6190b {
        C6190b() {
        }

        /* renamed from: a */
        public MediaMetadataRetriever mo19030a() {
            return new MediaMetadataRetriever();
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.z$c */
    /* compiled from: VideoDecoder */
    interface C6191c<T> {
        /* renamed from: a */
        void mo19029a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* renamed from: com.bumptech.glide.load.c.a.z$d */
    /* compiled from: VideoDecoder */
    static final class C6192d implements C6191c<ParcelFileDescriptor> {
        C6192d() {
        }

        /* renamed from: a */
        public void mo19029a(MediaMetadataRetriever retriever, ParcelFileDescriptor data) {
            retriever.setDataSource(data.getFileDescriptor());
        }
    }

    /* renamed from: a */
    public static C6350l<AssetFileDescriptor, Bitmap> m11750a(C6250e bitmapPool) {
        return new C6188z(bitmapPool, new C6189a(null));
    }

    /* renamed from: b */
    public static C6350l<ParcelFileDescriptor, Bitmap> m11752b(C6250e bitmapPool) {
        return new C6188z(bitmapPool, new C6192d());
    }

    C6188z(C6250e bitmapPool, C6191c<T> initializer) {
        this(bitmapPool, initializer, f10922c);
    }

    C6188z(C6250e bitmapPool, C6191c<T> initializer, C6190b factory) {
        this.f10924e = bitmapPool;
        this.f10923d = initializer;
        this.f10925f = factory;
    }

    /* renamed from: a */
    public boolean mo18973a(T t, C6349k options) {
        return true;
    }

    /* renamed from: a */
    public C6236E<Bitmap> mo18972a(T resource, int outWidth, int outHeight, C6349k options) throws IOException {
        Integer frameOption;
        C6160j downsampleStrategy;
        C6349k kVar = options;
        long frameTimeMicros = ((Long) kVar.mo19310a(f10920a)).longValue();
        if (frameTimeMicros >= 0 || frameTimeMicros == -1) {
            Integer frameOption2 = (Integer) kVar.mo19310a(f10921b);
            if (frameOption2 == null) {
                frameOption = Integer.valueOf(2);
            } else {
                frameOption = frameOption2;
            }
            C6160j downsampleStrategy2 = (C6160j) kVar.mo19310a(C6160j.f10873h);
            if (downsampleStrategy2 == null) {
                downsampleStrategy = C6160j.f10872g;
            } else {
                downsampleStrategy = downsampleStrategy2;
            }
            MediaMetadataRetriever mediaMetadataRetriever = this.f10925f.mo19030a();
            try {
                try {
                    this.f10923d.mo19029a(mediaMetadataRetriever, resource);
                    Bitmap result = m11749a(mediaMetadataRetriever, frameTimeMicros, frameOption.intValue(), outWidth, outHeight, downsampleStrategy);
                    mediaMetadataRetriever.release();
                    return C6150d.m11623a(result, this.f10924e);
                } catch (RuntimeException e) {
                    e = e;
                    try {
                        throw new IOException(e);
                    } catch (Throwable th) {
                        e = th;
                        mediaMetadataRetriever.release();
                        throw e;
                    }
                }
            } catch (RuntimeException e2) {
                e = e2;
                T t = resource;
                throw new IOException(e);
            } catch (Throwable th2) {
                e = th2;
                T t2 = resource;
                mediaMetadataRetriever.release();
                throw e;
            }
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
            sb.append(frameTimeMicros);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: a */
    private static Bitmap m11749a(MediaMetadataRetriever mediaMetadataRetriever, long frameTimeMicros, int frameOption, int outWidth, int outHeight, C6160j strategy) {
        Bitmap result = null;
        if (!(VERSION.SDK_INT < 27 || outWidth == Integer.MIN_VALUE || outHeight == Integer.MIN_VALUE || strategy == C6160j.f10871f)) {
            result = m11751b(mediaMetadataRetriever, frameTimeMicros, frameOption, outWidth, outHeight, strategy);
        }
        if (result == null) {
            return m11748a(mediaMetadataRetriever, frameTimeMicros, frameOption);
        }
        return result;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    @android.annotation.TargetApi(27)
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap m11751b(android.media.MediaMetadataRetriever r14, long r15, int r17, int r18, int r19, com.bumptech.glide.load.p113c.p114a.C6160j r20) {
        /*
            r7 = r14
            r0 = 18
            java.lang.String r0 = r14.extractMetadata(r0)     // Catch:{ Throwable -> 0x0054 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Throwable -> 0x0054 }
            r1 = 19
            java.lang.String r1 = r14.extractMetadata(r1)     // Catch:{ Throwable -> 0x0054 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ Throwable -> 0x0054 }
            r2 = 24
            java.lang.String r2 = r14.extractMetadata(r2)     // Catch:{ Throwable -> 0x0054 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Throwable -> 0x0054 }
            r8 = r2
            r2 = 90
            if (r8 == r2) goto L_0x002b
            r2 = 270(0x10e, float:3.78E-43)
            if (r8 != r2) goto L_0x0029
            goto L_0x002b
        L_0x0029:
            r9 = r1
            goto L_0x002f
        L_0x002b:
            r2 = r0
            r0 = r1
            r1 = r2
            r9 = r1
        L_0x002f:
            r10 = r18
            r11 = r19
            r12 = r20
            float r1 = r12.mo18993b(r0, r9, r10, r11)     // Catch:{ Throwable -> 0x0052 }
            r13 = r1
            float r1 = (float) r0     // Catch:{ Throwable -> 0x0052 }
            float r1 = r1 * r13
            int r5 = java.lang.Math.round(r1)     // Catch:{ Throwable -> 0x0052 }
            float r1 = (float) r9     // Catch:{ Throwable -> 0x0052 }
            float r1 = r1 * r13
            int r6 = java.lang.Math.round(r1)     // Catch:{ Throwable -> 0x0052 }
            r1 = r14
            r2 = r15
            r4 = r17
            android.graphics.Bitmap r1 = r1.getScaledFrameAtTime(r2, r4, r5, r6)     // Catch:{ Throwable -> 0x0052 }
            return r1
        L_0x0052:
            r0 = move-exception
            goto L_0x005b
        L_0x0054:
            r0 = move-exception
            r10 = r18
            r11 = r19
            r12 = r20
        L_0x005b:
            r1 = 3
            java.lang.String r2 = "VideoDecoder"
            boolean r1 = android.util.Log.isLoggable(r2, r1)
            if (r1 == 0) goto L_0x0069
            java.lang.String r1 = "Exception trying to decode frame on oreo+"
            android.util.Log.d(r2, r1, r0)
        L_0x0069:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.p113c.p114a.C6188z.m11751b(android.media.MediaMetadataRetriever, long, int, int, int, com.bumptech.glide.load.c.a.j):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private static Bitmap m11748a(MediaMetadataRetriever mediaMetadataRetriever, long frameTimeMicros, int frameOption) {
        return mediaMetadataRetriever.getFrameAtTime(frameTimeMicros, frameOption);
    }
}
