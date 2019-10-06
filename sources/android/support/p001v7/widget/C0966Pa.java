package android.support.p001v7.widget;

/* renamed from: android.support.v7.widget.Pa */
/* compiled from: RtlSpacingHelper */
class C0966Pa {

    /* renamed from: a */
    private int f3081a = 0;

    /* renamed from: b */
    private int f3082b = 0;

    /* renamed from: c */
    private int f3083c = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: d */
    private int f3084d = LinearLayoutManager.INVALID_OFFSET;

    /* renamed from: e */
    private int f3085e = 0;

    /* renamed from: f */
    private int f3086f = 0;

    /* renamed from: g */
    private boolean f3087g = false;

    /* renamed from: h */
    private boolean f3088h = false;

    C0966Pa() {
    }

    /* renamed from: b */
    public int mo7513b() {
        return this.f3081a;
    }

    /* renamed from: c */
    public int mo7515c() {
        return this.f3082b;
    }

    /* renamed from: d */
    public int mo7516d() {
        return this.f3087g ? this.f3082b : this.f3081a;
    }

    /* renamed from: a */
    public int mo7510a() {
        return this.f3087g ? this.f3081a : this.f3082b;
    }

    /* renamed from: b */
    public void mo7514b(int start, int end) {
        this.f3083c = start;
        this.f3084d = end;
        this.f3088h = true;
        if (this.f3087g) {
            if (end != Integer.MIN_VALUE) {
                this.f3081a = end;
            }
            if (start != Integer.MIN_VALUE) {
                this.f3082b = start;
                return;
            }
            return;
        }
        if (start != Integer.MIN_VALUE) {
            this.f3081a = start;
        }
        if (end != Integer.MIN_VALUE) {
            this.f3082b = end;
        }
    }

    /* renamed from: a */
    public void mo7511a(int left, int right) {
        this.f3088h = false;
        if (left != Integer.MIN_VALUE) {
            this.f3085e = left;
            this.f3081a = left;
        }
        if (right != Integer.MIN_VALUE) {
            this.f3086f = right;
            this.f3082b = right;
        }
    }

    /* renamed from: a */
    public void mo7512a(boolean isRtl) {
        if (isRtl != this.f3087g) {
            this.f3087g = isRtl;
            if (!this.f3088h) {
                this.f3081a = this.f3085e;
                this.f3082b = this.f3086f;
            } else if (isRtl) {
                int i = this.f3084d;
                if (i == Integer.MIN_VALUE) {
                    i = this.f3085e;
                }
                this.f3081a = i;
                int i2 = this.f3083c;
                if (i2 == Integer.MIN_VALUE) {
                    i2 = this.f3086f;
                }
                this.f3082b = i2;
            } else {
                int i3 = this.f3083c;
                if (i3 == Integer.MIN_VALUE) {
                    i3 = this.f3085e;
                }
                this.f3081a = i3;
                int i4 = this.f3084d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = this.f3086f;
                }
                this.f3082b = i4;
            }
        }
    }
}
