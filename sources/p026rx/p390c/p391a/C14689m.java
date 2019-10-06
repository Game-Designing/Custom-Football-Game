package p026rx.p390c.p391a;

import java.io.Serializable;
import p026rx.C0125T;

/* renamed from: rx.c.a.m */
/* compiled from: NotificationLite */
public final class C14689m {

    /* renamed from: a */
    private static final Object f43712a = new C14683k();

    /* renamed from: b */
    private static final Object f43713b = new C14686l();

    /* renamed from: rx.c.a.m$a */
    /* compiled from: NotificationLite */
    static final class C14690a implements Serializable {

        /* renamed from: a */
        final Throwable f43714a;

        public C14690a(Throwable e) {
            this.f43714a = e;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Notification=>Error:");
            sb.append(this.f43714a);
            return sb.toString();
        }
    }

    /* renamed from: d */
    public static <T> Object m46326d(T t) {
        if (t == null) {
            return f43713b;
        }
        return t;
    }

    /* renamed from: a */
    public static Object m46320a() {
        return f43712a;
    }

    /* renamed from: a */
    public static Object m46321a(Throwable e) {
        return new C14690a(e);
    }

    /* renamed from: a */
    public static <T> boolean m46323a(C0125T<? super T> o, Object n) {
        if (n == f43712a) {
            o.onCompleted();
            return true;
        } else if (n == f43713b) {
            o.onNext(null);
            return false;
        } else if (n == null) {
            throw new IllegalArgumentException("The lite notification can not be null");
        } else if (n.getClass() == C14690a.class) {
            o.onError(((C14690a) n).f43714a);
            return true;
        } else {
            o.onNext(n);
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m46325c(Object n) {
        return n == f43712a;
    }

    /* renamed from: b */
    public static <T> T m46324b(Object n) {
        if (n == f43713b) {
            return null;
        }
        return n;
    }

    /* renamed from: a */
    public static Throwable m46322a(Object n) {
        return ((C14690a) n).f43714a;
    }
}
