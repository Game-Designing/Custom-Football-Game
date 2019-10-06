package com.moat.analytics.mobile.vng.p233a.p235b;

import java.util.NoSuchElementException;

/* renamed from: com.moat.analytics.mobile.vng.a.b.a */
public final class C11147a<T> {

    /* renamed from: a */
    private static final C11147a<?> f34038a = new C11147a<>();

    /* renamed from: b */
    private final T f34039b;

    private C11147a() {
        this.f34039b = null;
    }

    private C11147a(T t) {
        if (t != null) {
            this.f34039b = t;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }

    /* renamed from: a */
    public static <T> C11147a<T> m36682a() {
        return f34038a;
    }

    /* renamed from: a */
    public static <T> C11147a<T> m36683a(T t) {
        return new C11147a<>(t);
    }

    /* renamed from: b */
    public static <T> C11147a<T> m36684b(T t) {
        return t == null ? m36682a() : m36683a(t);
    }

    /* renamed from: b */
    public T mo36305b() {
        T t = this.f34039b;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: c */
    public T mo36306c(T t) {
        T t2 = this.f34039b;
        return t2 != null ? t2 : t;
    }

    /* renamed from: c */
    public boolean mo36307c() {
        return this.f34039b != null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11147a)) {
            return false;
        }
        C11147a aVar = (C11147a) obj;
        T t = this.f34039b;
        T t2 = aVar.f34039b;
        if (t != t2 && (t == null || t2 == null || !t.equals(t2))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        T t = this.f34039b;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        T t = this.f34039b;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }
}
