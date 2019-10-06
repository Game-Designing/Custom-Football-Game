package kotlin.p375b;

/* renamed from: kotlin.b.a */
/* compiled from: progressionUtil.kt */
public final class C14269a {
    /* renamed from: a */
    private static final int m45902a(int a, int b) {
        int mod = a % b;
        return mod >= 0 ? mod : mod + b;
    }

    /* renamed from: b */
    private static final int m45904b(int a, int b, int c) {
        return m45902a(m45902a(a, c) - m45902a(b, c), c);
    }

    /* renamed from: a */
    public static final int m45903a(int start, int end, int step) {
        if (step > 0) {
            if (start < end) {
                return end - m45904b(end, start, step);
            }
        } else if (step >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (start > end) {
            return m45904b(start, end, -step) + end;
        }
        return end;
    }
}
