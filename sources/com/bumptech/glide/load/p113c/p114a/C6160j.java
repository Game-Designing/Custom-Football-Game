package com.bumptech.glide.load.p113c.p114a;

import com.bumptech.glide.load.C6347j;

/* renamed from: com.bumptech.glide.load.c.a.j */
/* compiled from: DownsampleStrategy */
public abstract class C6160j {

    /* renamed from: a */
    public static final C6160j f10866a = new C6165e();

    /* renamed from: b */
    public static final C6160j f10867b = new C6164d();

    /* renamed from: c */
    public static final C6160j f10868c = new C6161a();

    /* renamed from: d */
    public static final C6160j f10869d = new C6162b();

    /* renamed from: e */
    public static final C6160j f10870e = new C6163c();

    /* renamed from: f */
    public static final C6160j f10871f = new C6166f();

    /* renamed from: g */
    public static final C6160j f10872g = f10867b;

    /* renamed from: h */
    public static final C6347j<C6160j> f10873h = C6347j.m12245a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", f10872g);

    /* renamed from: com.bumptech.glide.load.c.a.j$a */
    /* compiled from: DownsampleStrategy */
    private static class C6161a extends C6160j {
        C6161a() {
        }

        /* renamed from: b */
        public float mo18993b(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            int minIntegerFactor = Math.min(sourceHeight / requestedHeight, sourceWidth / requestedWidth);
            if (minIntegerFactor == 0) {
                return 1.0f;
            }
            return 1.0f / ((float) Integer.highestOneBit(minIntegerFactor));
        }

        /* renamed from: a */
        public C6167g mo18992a(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return C6167g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.j$b */
    /* compiled from: DownsampleStrategy */
    private static class C6162b extends C6160j {
        C6162b() {
        }

        /* renamed from: b */
        public float mo18993b(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            int maxIntegerFactor = (int) Math.ceil((double) Math.max(((float) sourceHeight) / ((float) requestedHeight), ((float) sourceWidth) / ((float) requestedWidth)));
            int i = 1;
            int lesserOrEqualSampleSize = Math.max(1, Integer.highestOneBit(maxIntegerFactor));
            if (lesserOrEqualSampleSize >= maxIntegerFactor) {
                i = 0;
            }
            return 1.0f / ((float) (lesserOrEqualSampleSize << i));
        }

        /* renamed from: a */
        public C6167g mo18992a(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return C6167g.MEMORY;
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.j$c */
    /* compiled from: DownsampleStrategy */
    private static class C6163c extends C6160j {
        C6163c() {
        }

        /* renamed from: b */
        public float mo18993b(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return Math.min(1.0f, C6160j.f10866a.mo18993b(sourceWidth, sourceHeight, requestedWidth, requestedHeight));
        }

        /* renamed from: a */
        public C6167g mo18992a(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return C6167g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.j$d */
    /* compiled from: DownsampleStrategy */
    private static class C6164d extends C6160j {
        C6164d() {
        }

        /* renamed from: b */
        public float mo18993b(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return Math.max(((float) requestedWidth) / ((float) sourceWidth), ((float) requestedHeight) / ((float) sourceHeight));
        }

        /* renamed from: a */
        public C6167g mo18992a(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return C6167g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.j$e */
    /* compiled from: DownsampleStrategy */
    private static class C6165e extends C6160j {
        C6165e() {
        }

        /* renamed from: b */
        public float mo18993b(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return Math.min(((float) requestedWidth) / ((float) sourceWidth), ((float) requestedHeight) / ((float) sourceHeight));
        }

        /* renamed from: a */
        public C6167g mo18992a(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return C6167g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.j$f */
    /* compiled from: DownsampleStrategy */
    private static class C6166f extends C6160j {
        C6166f() {
        }

        /* renamed from: b */
        public float mo18993b(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return 1.0f;
        }

        /* renamed from: a */
        public C6167g mo18992a(int sourceWidth, int sourceHeight, int requestedWidth, int requestedHeight) {
            return C6167g.QUALITY;
        }
    }

    /* renamed from: com.bumptech.glide.load.c.a.j$g */
    /* compiled from: DownsampleStrategy */
    public enum C6167g {
        MEMORY,
        QUALITY
    }

    /* renamed from: a */
    public abstract C6167g mo18992a(int i, int i2, int i3, int i4);

    /* renamed from: b */
    public abstract float mo18993b(int i, int i2, int i3, int i4);
}
