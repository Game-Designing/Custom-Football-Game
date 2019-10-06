package p019d.p273h.p276c.p281e;

/* renamed from: d.h.c.e.n */
/* compiled from: PlacementAvailabilitySettings */
public class C12822n {

    /* renamed from: a */
    private boolean f39480a;

    /* renamed from: b */
    private boolean f39481b;

    /* renamed from: c */
    private boolean f39482c;

    /* renamed from: d */
    private C12824o f39483d;

    /* renamed from: e */
    private int f39484e;

    /* renamed from: f */
    private int f39485f;

    /* renamed from: d.h.c.e.n$a */
    /* compiled from: PlacementAvailabilitySettings */
    public static class C12823a {

        /* renamed from: a */
        private boolean f39486a = true;

        /* renamed from: b */
        private boolean f39487b = false;

        /* renamed from: c */
        private boolean f39488c = false;

        /* renamed from: d */
        private C12824o f39489d = null;

        /* renamed from: e */
        private int f39490e = 0;

        /* renamed from: f */
        private int f39491f = 0;

        /* renamed from: a */
        public C12823a mo41515a(boolean isDeliveryEnabled) {
            this.f39486a = isDeliveryEnabled;
            return this;
        }

        /* renamed from: a */
        public C12823a mo41517a(boolean isCappingEnabled, C12824o cappingType, int cappingValue) {
            this.f39487b = isCappingEnabled;
            this.f39489d = cappingType == null ? C12824o.PER_DAY : cappingType;
            this.f39490e = cappingValue;
            return this;
        }

        /* renamed from: a */
        public C12823a mo41516a(boolean isPacingEnabled, int pacingValue) {
            this.f39488c = isPacingEnabled;
            this.f39491f = pacingValue;
            return this;
        }

        /* renamed from: a */
        public C12822n mo41518a() {
            C12822n nVar = new C12822n(this.f39486a, this.f39487b, this.f39488c, this.f39489d, this.f39490e, this.f39491f);
            return nVar;
        }
    }

    private C12822n(boolean isDeliveryEnabled, boolean isCappingEnabled, boolean isPacingEnabled, C12824o cappingType, int cappingValue, int pacingValue) {
        this.f39480a = isDeliveryEnabled;
        this.f39481b = isCappingEnabled;
        this.f39482c = isPacingEnabled;
        this.f39483d = cappingType;
        this.f39484e = cappingValue;
        this.f39485f = pacingValue;
    }

    /* renamed from: e */
    public boolean mo41513e() {
        return this.f39480a;
    }

    /* renamed from: d */
    public boolean mo41512d() {
        return this.f39481b;
    }

    /* renamed from: f */
    public boolean mo41514f() {
        return this.f39482c;
    }

    /* renamed from: a */
    public C12824o mo41509a() {
        return this.f39483d;
    }

    /* renamed from: b */
    public int mo41510b() {
        return this.f39484e;
    }

    /* renamed from: c */
    public int mo41511c() {
        return this.f39485f;
    }
}
