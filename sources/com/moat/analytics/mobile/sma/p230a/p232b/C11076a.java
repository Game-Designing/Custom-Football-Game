package com.moat.analytics.mobile.sma.p230a.p232b;

import java.util.NoSuchElementException;

/* renamed from: com.moat.analytics.mobile.sma.a.b.a */
public final class C11076a<T> {

    /* renamed from: a */
    private static final C11076a<?> f33854a = new C11076a<>();

    /* renamed from: b */
    private final T f33855b;

    private C11076a() {
        this.f33855b = null;
    }

    private C11076a(T t) {
        if (t != null) {
            this.f33855b = t;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }

    /* renamed from: a */
    public static <T> C11076a<T> m36441a() {
        return f33854a;
    }

    /* renamed from: a */
    public static <T> C11076a<T> m36442a(T t) {
        return new C11076a<>(t);
    }

    /* renamed from: b */
    public static <T> C11076a<T> m36443b(T t) {
        return t == null ? m36441a() : m36442a(t);
    }

    /* renamed from: b */
    public T mo36175b() {
        T t = this.f33855b;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    /* renamed from: c */
    public T mo36176c(T t) {
        T t2 = this.f33855b;
        return t2 != null ? t2 : t;
    }

    /* renamed from: c */
    public boolean mo36177c() {
        return this.f33855b != null;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11076a)) {
            return false;
        }
        C11076a aVar = (C11076a) obj;
        T t = this.f33855b;
        T t2 = aVar.f33855b;
        if (t != t2 && (t == null || t2 == null || !t.equals(t2))) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        T t = this.f33855b;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public String toString() {
        T t = this.f33855b;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }
}
