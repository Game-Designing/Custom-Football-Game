package com.mopub.nativeads;

public class IntInterval implements Comparable<IntInterval> {

    /* renamed from: a */
    private int f35753a;

    /* renamed from: b */
    private int f35754b;

    public IntInterval(int start, int length) {
        this.f35753a = start;
        this.f35754b = length;
    }

    public int getStart() {
        return this.f35753a;
    }

    public int getLength() {
        return this.f35754b;
    }

    public void setStart(int start) {
        this.f35753a = start;
    }

    public void setLength(int length) {
        this.f35754b = length;
    }

    public boolean equals(int start, int length) {
        return this.f35753a == start && this.f35754b == length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{start : ");
        sb.append(this.f35753a);
        sb.append(", length : ");
        sb.append(this.f35754b);
        sb.append("}");
        return sb.toString();
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof IntInterval)) {
            return false;
        }
        IntInterval other = (IntInterval) o;
        if (!(this.f35753a == other.f35753a && this.f35754b == other.f35754b)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((29 * 31) + this.f35753a) * 31) + this.f35754b;
    }

    public int compareTo(IntInterval another) {
        int i = this.f35753a;
        int i2 = another.f35753a;
        if (i == i2) {
            return this.f35754b - another.f35754b;
        }
        return i - i2;
    }
}
