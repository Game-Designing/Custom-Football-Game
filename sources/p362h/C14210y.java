package p362h;

/* renamed from: h.y */
/* compiled from: SegmentPool */
final class C14210y {

    /* renamed from: a */
    static C14209x f43116a;

    /* renamed from: b */
    static long f43117b;

    private C14210y() {
    }

    /* renamed from: a */
    static C14209x m45724a() {
        synchronized (C14210y.class) {
            if (f43116a == null) {
                return new C14209x();
            }
            C14209x result = f43116a;
            f43116a = result.f43114f;
            result.f43114f = null;
            f43117b -= 8192;
            return result;
        }
    }

    /* renamed from: a */
    static void m45725a(C14209x segment) {
        if (segment.f43114f != null || segment.f43115g != null) {
            throw new IllegalArgumentException();
        } else if (!segment.f43112d) {
            synchronized (C14210y.class) {
                if (f43117b + 8192 <= 65536) {
                    f43117b += 8192;
                    segment.f43114f = f43116a;
                    segment.f43111c = 0;
                    segment.f43110b = 0;
                    f43116a = segment;
                }
            }
        }
    }
}
