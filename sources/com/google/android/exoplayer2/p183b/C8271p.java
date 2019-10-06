package com.google.android.exoplayer2.p183b;

/* renamed from: com.google.android.exoplayer2.b.p */
/* compiled from: SeekPoint */
public final class C8271p {

    /* renamed from: a */
    public static final C8271p f17515a = new C8271p(0, 0);

    /* renamed from: b */
    public final long f17516b;

    /* renamed from: c */
    public final long f17517c;

    public C8271p(long timeUs, long position) {
        this.f17516b = timeUs;
        this.f17517c = position;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[timeUs=");
        sb.append(this.f17516b);
        sb.append(", position=");
        sb.append(this.f17517c);
        sb.append("]");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C8271p other = (C8271p) obj;
        if (!(this.f17516b == other.f17516b && this.f17517c == other.f17517c)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((int) this.f17516b) * 31) + ((int) this.f17517c);
    }
}
