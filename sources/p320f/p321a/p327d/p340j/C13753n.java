package p320f.p321a.p327d.p340j;

import java.io.Serializable;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p329b.C13264b;

/* renamed from: f.a.d.j.n */
/* compiled from: NotificationLite */
public enum C13753n {
    COMPLETE;

    /* renamed from: f.a.d.j.n$a */
    /* compiled from: NotificationLite */
    static final class C13754a implements Serializable {

        /* renamed from: a */
        final C13194b f41867a;

        C13754a(C13194b d) {
            this.f41867a = d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Disposable[");
            sb.append(this.f41867a);
            sb.append("]");
            return sb.toString();
        }
    }

    /* renamed from: f.a.d.j.n$b */
    /* compiled from: NotificationLite */
    static final class C13755b implements Serializable {

        /* renamed from: a */
        final Throwable f41868a;

        C13755b(Throwable e) {
            this.f41868a = e;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("NotificationLite.Error[");
            sb.append(this.f41868a);
            sb.append("]");
            return sb.toString();
        }

        public int hashCode() {
            return this.f41868a.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C13755b)) {
                return false;
            }
            return C13264b.m43227a((Object) this.f41868a, (Object) ((C13755b) obj).f41868a);
        }
    }

    /* renamed from: g */
    public static <T> Object m43785g(T value) {
        return value;
    }

    /* renamed from: e */
    public static Object m43782e() {
        return COMPLETE;
    }

    /* renamed from: a */
    public static Object m43776a(Throwable e) {
        return new C13755b(e);
    }

    /* renamed from: a */
    public static Object m43775a(C13194b d) {
        return new C13754a(d);
    }

    /* renamed from: d */
    public static boolean m43781d(Object o) {
        return o == COMPLETE;
    }

    /* renamed from: f */
    public static boolean m43784f(Object o) {
        return o instanceof C13755b;
    }

    /* renamed from: e */
    public static boolean m43783e(Object o) {
        return o instanceof C13754a;
    }

    /* renamed from: c */
    public static <T> T m43780c(Object o) {
        return o;
    }

    /* renamed from: b */
    public static Throwable m43778b(Object o) {
        return ((C13755b) o).f41868a;
    }

    /* renamed from: a */
    public static C13194b m43774a(Object o) {
        return ((C13754a) o).f41867a;
    }

    /* renamed from: a */
    public static <T> boolean m43777a(Object o, C13804t<? super T> s) {
        if (o == COMPLETE) {
            s.onComplete();
            return true;
        } else if (o instanceof C13755b) {
            s.onError(((C13755b) o).f41868a);
            return true;
        } else {
            s.onNext(o);
            return false;
        }
    }

    /* renamed from: b */
    public static <T> boolean m43779b(Object o, C13804t<? super T> s) {
        if (o == COMPLETE) {
            s.onComplete();
            return true;
        } else if (o instanceof C13755b) {
            s.onError(((C13755b) o).f41868a);
            return true;
        } else if (o instanceof C13754a) {
            s.onSubscribe(((C13754a) o).f41867a);
            return false;
        } else {
            s.onNext(o);
            return false;
        }
    }

    public String toString() {
        return "NotificationLite.Complete";
    }
}
