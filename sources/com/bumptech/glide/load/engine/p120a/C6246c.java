package com.bumptech.glide.load.engine.p120a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.bumptech.glide.p107h.C6026k;

/* renamed from: com.bumptech.glide.load.engine.a.c */
/* compiled from: AttributeStrategy */
class C6246c implements C6262l {

    /* renamed from: a */
    private final C6248b f11050a = new C6248b();

    /* renamed from: b */
    private final C6253h<C6247a, Bitmap> f11051b = new C6253h<>();

    /* renamed from: com.bumptech.glide.load.engine.a.c$a */
    /* compiled from: AttributeStrategy */
    static class C6247a implements C6263m {

        /* renamed from: a */
        private final C6248b f11052a;

        /* renamed from: b */
        private int f11053b;

        /* renamed from: c */
        private int f11054c;

        /* renamed from: d */
        private Config f11055d;

        public C6247a(C6248b pool) {
            this.f11052a = pool;
        }

        /* renamed from: a */
        public void mo19140a(int width, int height, Config config) {
            this.f11053b = width;
            this.f11054c = height;
            this.f11055d = config;
        }

        public boolean equals(Object o) {
            boolean z = false;
            if (!(o instanceof C6247a)) {
                return false;
            }
            C6247a other = (C6247a) o;
            if (this.f11053b == other.f11053b && this.f11054c == other.f11054c && this.f11055d == other.f11055d) {
                z = true;
            }
            return z;
        }

        public int hashCode() {
            int result = ((this.f11053b * 31) + this.f11054c) * 31;
            Config config = this.f11055d;
            return result + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return C6246c.m11927c(this.f11053b, this.f11054c, this.f11055d);
        }

        /* renamed from: a */
        public void mo19139a() {
            this.f11052a.mo19146a(this);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.a.c$b */
    /* compiled from: AttributeStrategy */
    static class C6248b extends C6249d<C6247a> {
        C6248b() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public C6247a mo19145a(int width, int height, Config config) {
            C6247a result = (C6247a) mo19147b();
            result.mo19140a(width, height, config);
            return result;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public C6247a m11938a() {
            return new C6247a(this);
        }
    }

    C6246c() {
    }

    /* renamed from: a */
    public void mo19133a(Bitmap bitmap) {
        this.f11051b.mo19155a(this.f11050a.mo19145a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    /* renamed from: a */
    public Bitmap mo19132a(int width, int height, Config config) {
        return (Bitmap) this.f11051b.mo19154a(this.f11050a.mo19145a(width, height, config));
    }

    public Bitmap removeLast() {
        return (Bitmap) this.f11051b.mo19153a();
    }

    /* renamed from: b */
    public String mo19135b(Bitmap bitmap) {
        return m11928d(bitmap);
    }

    /* renamed from: b */
    public String mo19134b(int width, int height, Config config) {
        return m11927c(width, height, config);
    }

    /* renamed from: c */
    public int mo19136c(Bitmap bitmap) {
        return C6026k.m11274a(bitmap);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AttributeStrategy:\n  ");
        sb.append(this.f11051b);
        return sb.toString();
    }

    /* renamed from: d */
    private static String m11928d(Bitmap bitmap) {
        return m11927c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    /* renamed from: c */
    static String m11927c(int width, int height, Config config) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(width);
        sb.append("x");
        sb.append(height);
        sb.append("], ");
        sb.append(config);
        return sb.toString();
    }
}
