package com.google.zxing;

/* renamed from: com.google.zxing.b */
/* compiled from: Dimension */
public final class C10207b {

    /* renamed from: a */
    private final int f30925a;

    /* renamed from: b */
    private final int f30926b;

    /* renamed from: b */
    public int mo33515b() {
        return this.f30925a;
    }

    /* renamed from: a */
    public int mo33514a() {
        return this.f30926b;
    }

    public boolean equals(Object other) {
        boolean z = false;
        if (!(other instanceof C10207b)) {
            return false;
        }
        C10207b d = (C10207b) other;
        if (this.f30925a == d.f30925a && this.f30926b == d.f30926b) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.f30925a * 32713) + this.f30926b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f30925a);
        sb.append("x");
        sb.append(this.f30926b);
        return sb.toString();
    }
}
