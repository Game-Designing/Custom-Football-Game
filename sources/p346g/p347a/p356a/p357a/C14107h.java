package p346g.p347a.p356a.p357a;

/* renamed from: g.a.a.a.h */
/* compiled from: DNSState */
public enum C14107h {
    PROBING_1("probing 1", C14108a.f42888a),
    PROBING_2("probing 2", C14108a.f42888a),
    PROBING_3("probing 3", C14108a.f42888a),
    ANNOUNCING_1("announcing 1", C14108a.f42889b),
    ANNOUNCING_2("announcing 2", C14108a.f42889b),
    ANNOUNCED("announced", C14108a.f42890c),
    CANCELING_1("canceling 1", C14108a.f42891d),
    CANCELING_2("canceling 2", C14108a.f42891d),
    CANCELING_3("canceling 3", C14108a.f42891d),
    CANCELED("canceled", C14108a.f42892e),
    CLOSING("closing", C14108a.f42893f),
    CLOSED("closed", C14108a.f42894g);
    

    /* renamed from: n */
    private final String f42886n;

    /* renamed from: o */
    private final C14108a f42887o;

    /* renamed from: g.a.a.a.h$a */
    /* compiled from: DNSState */
    private enum C14108a {

        /* renamed from: a */
        public static final C14108a f42888a = null;

        /* renamed from: b */
        public static final C14108a f42889b = null;

        /* renamed from: c */
        public static final C14108a f42890c = null;

        /* renamed from: d */
        public static final C14108a f42891d = null;

        /* renamed from: e */
        public static final C14108a f42892e = null;

        /* renamed from: f */
        public static final C14108a f42893f = null;

        /* renamed from: g */
        public static final C14108a f42894g = null;

        /* renamed from: h */
        private static final /* synthetic */ C14108a[] f42895h = null;

        private C14108a(String str, int i) {
        }

        public static C14108a valueOf(String name) {
            return (C14108a) Enum.valueOf(C14108a.class, name);
        }

        public static C14108a[] values() {
            return (C14108a[]) f42895h.clone();
        }

        static {
            f42888a = new C14108a("probing", 0);
            f42889b = new C14108a("announcing", 1);
            f42890c = new C14108a("announced", 2);
            f42891d = new C14108a("canceling", 3);
            f42892e = new C14108a("canceled", 4);
            f42893f = new C14108a("closing", 5);
            f42894g = new C14108a("closed", 6);
            f42895h = new C14108a[]{f42888a, f42889b, f42890c, f42891d, f42892e, f42893f, f42894g};
        }
    }

    private C14107h(String name, C14108a state) {
        this.f42886n = name;
        this.f42887o = state;
    }

    public final String toString() {
        return this.f42886n;
    }

    /* renamed from: e */
    public final C14107h mo43839e() {
        switch (C14106g.f42872a[ordinal()]) {
            case 1:
                return PROBING_2;
            case 2:
                return PROBING_3;
            case 3:
                return ANNOUNCING_1;
            case 4:
                return ANNOUNCING_2;
            case 5:
                return ANNOUNCED;
            case 6:
                return ANNOUNCED;
            case 7:
                return CANCELING_2;
            case 8:
                return CANCELING_3;
            case 9:
                return CANCELED;
            case 10:
                return CANCELED;
            case 11:
                return CLOSED;
            case 12:
                return CLOSED;
            default:
                return this;
        }
    }

    /* renamed from: v */
    public final C14107h mo43848v() {
        switch (C14106g.f42872a[ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return PROBING_1;
            case 7:
            case 8:
            case 9:
                return CANCELING_1;
            case 10:
                return CANCELED;
            case 11:
                return CLOSING;
            case 12:
                return CLOSED;
            default:
                return this;
        }
    }

    /* renamed from: u */
    public final boolean mo43847u() {
        return this.f42887o == C14108a.f42888a;
    }

    /* renamed from: g */
    public final boolean mo43841g() {
        return this.f42887o == C14108a.f42889b;
    }

    /* renamed from: f */
    public final boolean mo43840f() {
        return this.f42887o == C14108a.f42890c;
    }

    /* renamed from: j */
    public final boolean mo43843j() {
        return this.f42887o == C14108a.f42891d;
    }

    /* renamed from: i */
    public final boolean mo43842i() {
        return this.f42887o == C14108a.f42892e;
    }

    /* renamed from: t */
    public final boolean mo43845t() {
        return this.f42887o == C14108a.f42893f;
    }

    /* renamed from: s */
    public final boolean mo43844s() {
        return this.f42887o == C14108a.f42894g;
    }
}
