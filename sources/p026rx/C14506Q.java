package p026rx;

/* renamed from: rx.Q */
/* compiled from: Notification */
public final class C14506Q<T> {

    /* renamed from: a */
    private static final C14506Q<Void> f43310a = new C14506Q<>(C14507a.OnCompleted, null, null);

    /* renamed from: b */
    private final C14507a f43311b;

    /* renamed from: c */
    private final Throwable f43312c;

    /* renamed from: d */
    private final T f43313d;

    /* renamed from: rx.Q$a */
    /* compiled from: Notification */
    public enum C14507a {
        OnNext,
        OnError,
        OnCompleted
    }

    /* renamed from: a */
    public static <T> C14506Q<T> m46148a(T t) {
        return new C14506Q<>(C14507a.OnNext, t, null);
    }

    /* renamed from: a */
    public static <T> C14506Q<T> m46149a(Throwable e) {
        return new C14506Q<>(C14507a.OnError, null, e);
    }

    /* renamed from: a */
    public static <T> C14506Q<T> m46147a() {
        return f43310a;
    }

    private C14506Q(C14507a kind, T value, Throwable e) {
        this.f43313d = value;
        this.f43312c = e;
        this.f43311b = kind;
    }

    /* renamed from: c */
    public Throwable mo45702c() {
        return this.f43312c;
    }

    /* renamed from: d */
    public T mo45703d() {
        return this.f43313d;
    }

    /* renamed from: f */
    public boolean mo45706f() {
        return mo45710i() && this.f43313d != null;
    }

    /* renamed from: e */
    public boolean mo45704e() {
        return mo45708h() && this.f43312c != null;
    }

    /* renamed from: b */
    public C14507a mo45701b() {
        return this.f43311b;
    }

    /* renamed from: h */
    public boolean mo45708h() {
        return mo45701b() == C14507a.OnError;
    }

    /* renamed from: g */
    public boolean mo45707g() {
        return mo45701b() == C14507a.OnCompleted;
    }

    /* renamed from: i */
    public boolean mo45710i() {
        return mo45701b() == C14507a.OnNext;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append('[');
        sb.append(super.toString());
        sb.append(' ');
        StringBuilder str = sb.append(mo45701b());
        if (mo45706f()) {
            str.append(' ');
            str.append(mo45703d());
        }
        if (mo45704e()) {
            str.append(' ');
            str.append(mo45702c().getMessage());
        }
        str.append(']');
        return str.toString();
    }

    public int hashCode() {
        int hash = mo45701b().hashCode();
        if (mo45706f()) {
            hash = (hash * 31) + mo45703d().hashCode();
        }
        if (mo45704e()) {
            return (hash * 31) + mo45702c().hashCode();
        }
        return hash;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Notification<?> notification = (C14506Q) obj;
        if (notification.mo45701b() == mo45701b()) {
            T t = this.f43313d;
            T t2 = notification.f43313d;
            if (t == t2 || (t != null && t.equals(t2))) {
                Throwable th = this.f43312c;
                Throwable th2 = notification.f43312c;
                if (th == th2 || (th != null && th.equals(th2))) {
                    z = true;
                }
            }
        }
        return z;
    }
}
