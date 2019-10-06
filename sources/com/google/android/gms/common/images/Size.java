package com.google.android.gms.common.images;

public final class Size {

    /* renamed from: a */
    private final int f19990a;

    /* renamed from: b */
    private final int f19991b;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.f19990a == size.f19990a && this.f19991b == size.f19991b) {
            return true;
        }
        return false;
    }

    public final String toString() {
        int i = this.f19990a;
        int i2 = this.f19991b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }

    public final int hashCode() {
        int i = this.f19991b;
        int i2 = this.f19990a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }
}
