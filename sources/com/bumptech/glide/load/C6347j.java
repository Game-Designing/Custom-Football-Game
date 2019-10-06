package com.bumptech.glide.load;

import com.bumptech.glide.p107h.C6024i;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.j */
/* compiled from: Option */
public final class C6347j<T> {

    /* renamed from: a */
    private static final C6348a<Object> f11320a = new C6346i();

    /* renamed from: b */
    private final T f11321b;

    /* renamed from: c */
    private final C6348a<T> f11322c;

    /* renamed from: d */
    private final String f11323d;

    /* renamed from: e */
    private volatile byte[] f11324e;

    /* renamed from: com.bumptech.glide.load.j$a */
    /* compiled from: Option */
    public interface C6348a<T> {
        /* renamed from: a */
        void mo19026a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    /* renamed from: a */
    public static <T> C6347j<T> m12244a(String key) {
        return new C6347j<>(key, null, m12247b());
    }

    /* renamed from: a */
    public static <T> C6347j<T> m12245a(String key, T defaultValue) {
        return new C6347j<>(key, defaultValue, m12247b());
    }

    /* renamed from: a */
    public static <T> C6347j<T> m12246a(String key, T defaultValue, C6348a<T> cacheKeyUpdater) {
        return new C6347j<>(key, defaultValue, cacheKeyUpdater);
    }

    private C6347j(String key, T defaultValue, C6348a<T> cacheKeyUpdater) {
        C6024i.m11266a(key);
        this.f11323d = key;
        this.f11321b = defaultValue;
        C6024i.m11264a(cacheKeyUpdater);
        this.f11322c = cacheKeyUpdater;
    }

    /* renamed from: a */
    public T mo19304a() {
        return this.f11321b;
    }

    /* renamed from: a */
    public void mo19305a(T value, MessageDigest messageDigest) {
        this.f11322c.mo19026a(m12248c(), value, messageDigest);
    }

    /* renamed from: c */
    private byte[] m12248c() {
        if (this.f11324e == null) {
            this.f11324e = this.f11323d.getBytes(C6344g.f11318a);
        }
        return this.f11324e;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C6347j)) {
            return false;
        }
        return this.f11323d.equals(((C6347j) o).f11323d);
    }

    public int hashCode() {
        return this.f11323d.hashCode();
    }

    /* renamed from: b */
    private static <T> C6348a<T> m12247b() {
        return f11320a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Option{key='");
        sb.append(this.f11323d);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
}
