package p002b.p003c.p053g.p061f;

/* renamed from: b.c.g.f.e */
/* compiled from: ContainerHelpers */
class C1256e {

    /* renamed from: a */
    static final int[] f4036a = new int[0];

    /* renamed from: b */
    static final long[] f4037b = new long[0];

    /* renamed from: c */
    static final Object[] f4038c = new Object[0];

    /* renamed from: b */
    public static int m5911b(int need) {
        return m5907a(need * 4) / 4;
    }

    /* renamed from: c */
    public static int m5912c(int need) {
        return m5907a(need * 8) / 8;
    }

    /* renamed from: a */
    public static int m5907a(int need) {
        for (int i = 4; i < 32; i++) {
            if (need <= (1 << i) - 12) {
                return (1 << i) - 12;
            }
        }
        return need;
    }

    /* renamed from: a */
    public static boolean m5910a(Object a, Object b) {
        return a == b || (a != null && a.equals(b));
    }

    /* renamed from: a */
    static int m5908a(int[] array, int size, int value) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal <= value) {
                return mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo ^ -1;
    }

    /* renamed from: a */
    static int m5909a(long[] array, int size, long value) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            long midVal = array[mid];
            if (midVal < value) {
                lo = mid + 1;
            } else if (midVal <= value) {
                return mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo ^ -1;
    }
}
