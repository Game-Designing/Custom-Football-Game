package p026rx.p390c.p395e;

/* renamed from: rx.c.e.g */
/* compiled from: PlatformDependent */
public final class C14879g {

    /* renamed from: a */
    private static final int f44163a = m46597c();

    /* renamed from: b */
    private static final boolean f44164b = (f44163a != 0);

    /* renamed from: b */
    public static boolean m46596b() {
        return f44164b;
    }

    /* renamed from: a */
    public static int m46595a() {
        return f44163a;
    }

    /* renamed from: c */
    private static int m46597c() {
        try {
            return ((Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null)).intValue();
        } catch (Exception e) {
            return 0;
        }
    }
}
