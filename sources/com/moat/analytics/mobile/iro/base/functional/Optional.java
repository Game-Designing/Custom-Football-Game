package com.moat.analytics.mobile.iro.base.functional;

import java.util.NoSuchElementException;

public final class Optional<T> {

    /* renamed from: ˏ */
    private static final Optional<?> f33645 = new Optional<>();

    /* renamed from: ˋ */
    private final T f33646;

    private Optional() {
        this.f33646 = null;
    }

    public static <T> Optional<T> empty() {
        return f33645;
    }

    private Optional(T t) {
        if (t != null) {
            this.f33646 = t;
            return;
        }
        throw new NullPointerException("Optional of null value.");
    }

    /* renamed from: of */
    public static <T> Optional<T> m36239of(T t) {
        return new Optional<>(t);
    }

    public static <T> Optional<T> ofNullable(T t) {
        return t == null ? empty() : m36239of(t);
    }

    public final T get() {
        T t = this.f33646;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean isPresent() {
        return this.f33646 != null;
    }

    public final T orElse(T t) {
        T t2 = this.f33646;
        return t2 != null ? t2 : t;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }
        Optional optional = (Optional) obj;
        T t = this.f33646;
        T t2 = optional.f33646;
        if (t == t2 || (t != null && t2 != null && t.equals(t2))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        T t = this.f33646;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public final String toString() {
        T t = this.f33646;
        if (t == null) {
            return "Optional.empty";
        }
        return String.format("Optional[%s]", new Object[]{t});
    }
}
