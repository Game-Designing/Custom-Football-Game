package p002b.p003c.p053g.p060e;

import java.util.Locale;

/* renamed from: b.c.g.e.c */
/* compiled from: TextDirectionHeuristicsCompat */
public final class C1244c {

    /* renamed from: a */
    public static final C1243b f4009a = new C1249e(null, false);

    /* renamed from: b */
    public static final C1243b f4010b = new C1249e(null, true);

    /* renamed from: c */
    public static final C1243b f4011c = new C1249e(C1246b.f4018a, false);

    /* renamed from: d */
    public static final C1243b f4012d = new C1249e(C1246b.f4018a, true);

    /* renamed from: e */
    public static final C1243b f4013e = new C1249e(C1245a.f4015a, false);

    /* renamed from: f */
    public static final C1243b f4014f = C1250f.f4021b;

    /* renamed from: b.c.g.e.c$a */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C1245a implements C1247c {

        /* renamed from: a */
        static final C1245a f4015a = new C1245a(true);

        /* renamed from: b */
        static final C1245a f4016b = new C1245a(false);

        /* renamed from: c */
        private final boolean f4017c;

        /* renamed from: a */
        public int mo9014a(CharSequence cs, int start, int count) {
            boolean haveUnlookedFor = false;
            int e = start + count;
            for (int i = start; i < e; i++) {
                int a = C1244c.m5866a(Character.getDirectionality(cs.charAt(i)));
                if (a != 0) {
                    if (a != 1) {
                        continue;
                    } else if (!this.f4017c) {
                        return 1;
                    } else {
                        haveUnlookedFor = true;
                    }
                } else if (this.f4017c) {
                    return 0;
                } else {
                    haveUnlookedFor = true;
                }
            }
            if (haveUnlookedFor) {
                return this.f4017c ? 1 : 0;
            }
            return 2;
        }

        private C1245a(boolean lookForRtl) {
            this.f4017c = lookForRtl;
        }
    }

    /* renamed from: b.c.g.e.c$b */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C1246b implements C1247c {

        /* renamed from: a */
        static final C1246b f4018a = new C1246b();

        /* renamed from: a */
        public int mo9014a(CharSequence cs, int start, int count) {
            int result = 2;
            int e = start + count;
            for (int i = start; i < e && result == 2; i++) {
                result = C1244c.m5867b(Character.getDirectionality(cs.charAt(i)));
            }
            return result;
        }

        private C1246b() {
        }
    }

    /* renamed from: b.c.g.e.c$c */
    /* compiled from: TextDirectionHeuristicsCompat */
    private interface C1247c {
        /* renamed from: a */
        int mo9014a(CharSequence charSequence, int i, int i2);
    }

    /* renamed from: b.c.g.e.c$d */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static abstract class C1248d implements C1243b {

        /* renamed from: a */
        private final C1247c f4019a;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract boolean mo9015a();

        C1248d(C1247c algorithm) {
            this.f4019a = algorithm;
        }

        public boolean isRtl(CharSequence cs, int start, int count) {
            if (cs == null || start < 0 || count < 0 || cs.length() - count < start) {
                throw new IllegalArgumentException();
            } else if (this.f4019a == null) {
                return mo9015a();
            } else {
                return m5871a(cs, start, count);
            }
        }

        /* renamed from: a */
        private boolean m5871a(CharSequence cs, int start, int count) {
            int a = this.f4019a.mo9014a(cs, start, count);
            if (a == 0) {
                return true;
            }
            if (a != 1) {
                return mo9015a();
            }
            return false;
        }
    }

    /* renamed from: b.c.g.e.c$e */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C1249e extends C1248d {

        /* renamed from: b */
        private final boolean f4020b;

        C1249e(C1247c algorithm, boolean defaultIsRtl) {
            super(algorithm);
            this.f4020b = defaultIsRtl;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo9015a() {
            return this.f4020b;
        }
    }

    /* renamed from: b.c.g.e.c$f */
    /* compiled from: TextDirectionHeuristicsCompat */
    private static class C1250f extends C1248d {

        /* renamed from: b */
        static final C1250f f4021b = new C1250f();

        C1250f() {
            super(null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo9015a() {
            return C1251d.m5875a(Locale.getDefault()) == 1;
        }
    }

    /* renamed from: a */
    static int m5866a(int directionality) {
        if (directionality == 0) {
            return 1;
        }
        if (directionality == 1 || directionality == 2) {
            return 0;
        }
        return 2;
    }

    /* renamed from: b */
    static int m5867b(int directionality) {
        if (directionality != 0) {
            if (!(directionality == 1 || directionality == 2)) {
                switch (directionality) {
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                        break;
                    default:
                        return 2;
                }
            }
            return 0;
        }
        return 1;
    }
}
