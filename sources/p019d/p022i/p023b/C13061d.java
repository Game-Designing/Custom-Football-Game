package p019d.p022i.p023b;

import p026rx.C0125T;

/* renamed from: d.i.b.d */
/* compiled from: NotificationLite */
final class C13061d {

    /* renamed from: a */
    private static final Object f40046a = new C13060c();

    /* renamed from: a */
    public static <T> Object m42512a(T t) {
        if (t == null) {
            return f40046a;
        }
        return t;
    }

    /* renamed from: a */
    public static <T> boolean m42513a(C0125T<? super T> o, Object n) {
        if (n == f40046a) {
            o.onNext(null);
            return false;
        } else if (n != null) {
            o.onNext(n);
            return false;
        } else {
            throw new IllegalArgumentException("The lite notification can not be null");
        }
    }
}
