package com.crashlytics.android.p126c;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* renamed from: com.crashlytics.android.c.d */
/* compiled from: ByteString */
final class C6481d {

    /* renamed from: a */
    public static final C6481d f11641a = new C6481d(new byte[0]);

    /* renamed from: b */
    private final byte[] f11642b;

    /* renamed from: c */
    private volatile int f11643c = 0;

    private C6481d(byte[] bytes) {
        this.f11642b = bytes;
    }

    /* renamed from: b */
    public int mo19535b() {
        return this.f11642b.length;
    }

    /* renamed from: a */
    public static C6481d m12661a(byte[] bytes, int offset, int size) {
        byte[] copy = new byte[size];
        System.arraycopy(bytes, offset, copy, 0, size);
        return new C6481d(copy);
    }

    /* renamed from: a */
    public static C6481d m12660a(String text) {
        try {
            return new C6481d(text.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    /* renamed from: a */
    public void mo19534a(byte[] target, int sourceOffset, int targetOffset, int size) {
        System.arraycopy(this.f11642b, sourceOffset, target, targetOffset, size);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof C6481d)) {
            return false;
        }
        C6481d other = (C6481d) o;
        int size = this.f11642b.length;
        if (size != other.f11642b.length) {
            return false;
        }
        byte[] thisBytes = this.f11642b;
        byte[] otherBytes = other.f11642b;
        for (int i = 0; i < size; i++) {
            if (thisBytes[i] != otherBytes[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int h = this.f11643c;
        if (h == 0) {
            byte[] thisBytes = this.f11642b;
            int size = this.f11642b.length;
            h = size;
            for (int i = 0; i < size; i++) {
                h = (h * 31) + thisBytes[i];
            }
            if (h == 0) {
                h = 1;
            }
            this.f11643c = h;
        }
        return h;
    }

    /* renamed from: a */
    public InputStream mo19533a() {
        return new ByteArrayInputStream(this.f11642b);
    }
}
