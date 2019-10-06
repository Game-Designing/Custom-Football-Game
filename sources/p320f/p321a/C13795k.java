package p320f.p321a;

import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p340j.C13753n;

/* renamed from: f.a.k */
/* compiled from: Notification */
public final class C13795k<T> {

    /* renamed from: a */
    static final C13795k<Object> f41956a = new C13795k<>(null);

    /* renamed from: b */
    final Object f41957b;

    private C13795k(Object value) {
        this.f41957b = value;
    }

    /* renamed from: d */
    public boolean mo42817d() {
        return this.f41957b == null;
    }

    /* renamed from: e */
    public boolean mo42818e() {
        return C13753n.m43784f(this.f41957b);
    }

    /* renamed from: f */
    public boolean mo42820f() {
        Object o = this.f41957b;
        return o != null && !C13753n.m43784f(o);
    }

    /* renamed from: c */
    public T mo42816c() {
        Object o = this.f41957b;
        if (o == null || C13753n.m43784f(o)) {
            return null;
        }
        return this.f41957b;
    }

    /* renamed from: b */
    public Throwable mo42815b() {
        Object o = this.f41957b;
        if (C13753n.m43784f(o)) {
            return C13753n.m43778b(o);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C13795k)) {
            return false;
        }
        return C13264b.m43227a(this.f41957b, ((C13795k) obj).f41957b);
    }

    public int hashCode() {
        Object o = this.f41957b;
        if (o != null) {
            return o.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object o = this.f41957b;
        if (o == null) {
            return "OnCompleteNotification";
        }
        String str = "]";
        if (C13753n.m43784f(o)) {
            StringBuilder sb = new StringBuilder();
            sb.append("OnErrorNotification[");
            sb.append(C13753n.m43778b(o));
            sb.append(str);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("OnNextNotification[");
        sb2.append(this.f41957b);
        sb2.append(str);
        return sb2.toString();
    }

    /* renamed from: a */
    public static <T> C13795k<T> m43873a(T value) {
        C13264b.m43226a(value, "value is null");
        return new C13795k<>(value);
    }

    /* renamed from: a */
    public static <T> C13795k<T> m43874a(Throwable error) {
        C13264b.m43226a(error, "error is null");
        return new C13795k<>(C13753n.m43776a(error));
    }

    /* renamed from: a */
    public static <T> C13795k<T> m43872a() {
        return f41956a;
    }
}
