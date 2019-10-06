package p026rx.p390c.p395e.p397b;

/* renamed from: rx.c.e.b.j */
/* compiled from: Pow2 */
public final class C14849j {
    /* renamed from: b */
    public static int m46569b(int value) {
        return 1 << (32 - Integer.numberOfLeadingZeros(value - 1));
    }

    /* renamed from: a */
    public static boolean m46568a(int value) {
        return ((value + -1) & value) == 0;
    }
}
