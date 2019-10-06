package android.support.p001v7.widget;

import android.view.View;

/* renamed from: android.support.v7.widget.Gb */
/* compiled from: ViewBoundsCheck */
class C0933Gb {

    /* renamed from: a */
    final C0935b f2986a;

    /* renamed from: b */
    C0934a f2987b = new C0934a();

    /* renamed from: android.support.v7.widget.Gb$a */
    /* compiled from: ViewBoundsCheck */
    static class C0934a {

        /* renamed from: a */
        int f2988a = 0;

        /* renamed from: b */
        int f2989b;

        /* renamed from: c */
        int f2990c;

        /* renamed from: d */
        int f2991d;

        /* renamed from: e */
        int f2992e;

        C0934a() {
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7237a(int rvStart, int rvEnd, int childStart, int childEnd) {
            this.f2989b = rvStart;
            this.f2990c = rvEnd;
            this.f2991d = childStart;
            this.f2992e = childEnd;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo7236a(int flags) {
            this.f2988a |= flags;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo7239b() {
            this.f2988a = 0;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public int mo7235a(int x, int y) {
            if (x > y) {
                return 1;
            }
            if (x == y) {
                return 2;
            }
            return 4;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo7238a() {
            int i = this.f2988a;
            if ((i & 7) != 0 && (i & (mo7235a(this.f2991d, this.f2989b) << 0)) == 0) {
                return false;
            }
            int i2 = this.f2988a;
            if ((i2 & 112) != 0 && (i2 & (mo7235a(this.f2991d, this.f2990c) << 4)) == 0) {
                return false;
            }
            int i3 = this.f2988a;
            if ((i3 & 1792) != 0 && (i3 & (mo7235a(this.f2992e, this.f2989b) << 8)) == 0) {
                return false;
            }
            int i4 = this.f2988a;
            if ((i4 & 28672) == 0 || (i4 & (mo7235a(this.f2992e, this.f2990c) << 12)) != 0) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: android.support.v7.widget.Gb$b */
    /* compiled from: ViewBoundsCheck */
    interface C0935b {
        /* renamed from: a */
        int mo7240a();

        /* renamed from: a */
        int mo7241a(View view);

        /* renamed from: a */
        View mo7242a(int i);

        /* renamed from: b */
        int mo7243b();

        /* renamed from: b */
        int mo7244b(View view);
    }

    C0933Gb(C0935b callback) {
        this.f2986a = callback;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public View mo7233a(int fromIndex, int toIndex, int preferredBoundFlags, int acceptableBoundFlags) {
        int start = this.f2986a.mo7240a();
        int end = this.f2986a.mo7243b();
        int next = toIndex > fromIndex ? 1 : -1;
        View acceptableMatch = null;
        for (int i = fromIndex; i != toIndex; i += next) {
            View child = this.f2986a.mo7242a(i);
            this.f2987b.mo7237a(start, end, this.f2986a.mo7241a(child), this.f2986a.mo7244b(child));
            if (preferredBoundFlags != 0) {
                this.f2987b.mo7239b();
                this.f2987b.mo7236a(preferredBoundFlags);
                if (this.f2987b.mo7238a()) {
                    return child;
                }
            }
            if (acceptableBoundFlags != 0) {
                this.f2987b.mo7239b();
                this.f2987b.mo7236a(acceptableBoundFlags);
                if (this.f2987b.mo7238a()) {
                    acceptableMatch = child;
                }
            }
        }
        return acceptableMatch;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo7234a(View child, int boundsFlags) {
        this.f2987b.mo7237a(this.f2986a.mo7240a(), this.f2986a.mo7243b(), this.f2986a.mo7241a(child), this.f2986a.mo7244b(child));
        if (boundsFlags == 0) {
            return false;
        }
        this.f2987b.mo7239b();
        this.f2987b.mo7236a(boundsFlags);
        return this.f2987b.mo7238a();
    }
}
