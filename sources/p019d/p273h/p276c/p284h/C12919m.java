package p019d.p273h.p276c.p284h;

/* renamed from: d.h.c.h.m */
/* compiled from: SessionDepthManager */
public class C12919m {

    /* renamed from: a */
    private static C12919m f39751a;

    /* renamed from: b */
    private int f39752b = 1;

    /* renamed from: c */
    private int f39753c = 1;

    /* renamed from: d */
    private int f39754d = 1;

    /* renamed from: e */
    private int f39755e = 1;

    /* renamed from: a */
    public static synchronized C12919m m42012a() {
        C12919m mVar;
        synchronized (C12919m.class) {
            if (f39751a == null) {
                f39751a = new C12919m();
            }
            mVar = f39751a;
        }
        return mVar;
    }

    /* renamed from: b */
    public synchronized void mo41702b(int adUnit) {
        if (adUnit == 0) {
            this.f39754d++;
        } else if (adUnit == 1) {
            this.f39752b++;
        } else if (adUnit == 2) {
            this.f39753c++;
        } else if (adUnit == 3) {
            this.f39755e++;
        }
    }

    /* renamed from: a */
    public synchronized int mo41701a(int adUnit) {
        if (adUnit == 0) {
            return this.f39754d;
        } else if (adUnit == 1) {
            return this.f39752b;
        } else if (adUnit == 2) {
            return this.f39753c;
        } else if (adUnit != 3) {
            return -1;
        } else {
            return this.f39755e;
        }
    }
}
