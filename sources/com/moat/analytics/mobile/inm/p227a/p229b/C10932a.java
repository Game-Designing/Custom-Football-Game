package com.moat.analytics.mobile.inm.p227a.p229b;

import java.util.NoSuchElementException;

/* renamed from: com.moat.analytics.mobile.inm.a.b.a */
public final class C10932a<T> {

    /* renamed from: a */
    private static final C10932a<?> f33418a = new C10932a<>();

    /* renamed from: b */
    private final T f33419b;

    private C10932a() {
        this.f33419b = null;
    }

    private C10932a(T t) {
        if (t != null) {
            this.f33419b = t;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }

    /* renamed from: a */
    public static <T> C10932a<T> m35953a() {
        return f33418a;
    }

    /* renamed from: a */
    public static <T> C10932a<T> m35954a(T t) {
        return new C10932a<>(t);
    }

    /* renamed from: b */
    public static <T> C10932a<T> m35955b(T t) {
        return t == null ? m35953a() : m35954a(t);
    }

    /* renamed from: b */
    public final T mo35880b() {
        T t = this.f33419b;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: c */
    public final T mo35881c(T t) {
        T t2 = this.f33419b;
        return t2 != null ? t2 : t;
    }

    /* renamed from: c */
    public final boolean mo35882c() {
        return this.f33419b != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C10932a)) {
            return false;
        }
        C10932a aVar = (C10932a) obj;
        T t = this.f33419b;
        T t2 = aVar.f33419b;
        return t == t2 || !(t == null || t2 == null || !t.equals(t2));
    }

    public final int hashCode() {
        T t = this.f33419b;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public final String toString() {
        T t = this.f33419b;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }
}
