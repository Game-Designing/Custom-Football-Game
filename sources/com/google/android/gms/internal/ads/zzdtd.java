package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzdtd {

    /* renamed from: a */
    public static final zzdtd f28286a;

    /* renamed from: b */
    private static final zzdtd f28287b;

    /* renamed from: c */
    private static final zzdtd f28288c;

    /* renamed from: d */
    private static final zzdtd f28289d;

    /* renamed from: e */
    private final double f28290e;

    /* renamed from: f */
    private final double f28291f;

    /* renamed from: g */
    private final double f28292g;

    /* renamed from: h */
    private final double f28293h;

    /* renamed from: i */
    private final double f28294i;

    /* renamed from: j */
    private final double f28295j;

    /* renamed from: k */
    private final double f28296k;

    /* renamed from: l */
    private final double f28297l;

    /* renamed from: m */
    private final double f28298m;

    private zzdtd(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f28290e = d5;
        this.f28291f = d6;
        this.f28292g = d7;
        this.f28293h = d;
        this.f28294i = d2;
        this.f28295j = d3;
        this.f28296k = d4;
        this.f28297l = d8;
        this.f28298m = d9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdtd.class != obj.getClass()) {
            return false;
        }
        zzdtd zzdtd = (zzdtd) obj;
        if (Double.compare(zzdtd.f28293h, this.f28293h) == 0 && Double.compare(zzdtd.f28294i, this.f28294i) == 0 && Double.compare(zzdtd.f28295j, this.f28295j) == 0 && Double.compare(zzdtd.f28296k, this.f28296k) == 0 && Double.compare(zzdtd.f28297l, this.f28297l) == 0 && Double.compare(zzdtd.f28298m, this.f28298m) == 0 && Double.compare(zzdtd.f28290e, this.f28290e) == 0 && Double.compare(zzdtd.f28291f, this.f28291f) == 0 && Double.compare(zzdtd.f28292g, this.f28292g) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f28290e);
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        long doubleToLongBits2 = Double.doubleToLongBits(this.f28291f);
        int i2 = (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
        long doubleToLongBits3 = Double.doubleToLongBits(this.f28292g);
        int i3 = (i2 * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        long doubleToLongBits4 = Double.doubleToLongBits(this.f28293h);
        int i4 = (i3 * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)));
        long doubleToLongBits5 = Double.doubleToLongBits(this.f28294i);
        int i5 = (i4 * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)));
        long doubleToLongBits6 = Double.doubleToLongBits(this.f28295j);
        int i6 = (i5 * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)));
        long doubleToLongBits7 = Double.doubleToLongBits(this.f28296k);
        int i7 = (i6 * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)));
        long doubleToLongBits8 = Double.doubleToLongBits(this.f28297l);
        int i8 = (i7 * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)));
        long doubleToLongBits9 = Double.doubleToLongBits(this.f28298m);
        return (i8 * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public final String toString() {
        if (equals(f28286a)) {
            return "Rotate 0°";
        }
        if (equals(f28287b)) {
            return "Rotate 90°";
        }
        if (equals(f28288c)) {
            return "Rotate 180°";
        }
        if (equals(f28289d)) {
            return "Rotate 270°";
        }
        double d = this.f28290e;
        double d2 = this.f28291f;
        double d3 = this.f28292g;
        double d4 = this.f28293h;
        double d5 = this.f28294i;
        double d6 = this.f28295j;
        double d7 = this.f28296k;
        double d8 = this.f28297l;
        double d9 = this.f28298m;
        double d10 = d7;
        StringBuilder sb = new StringBuilder(260);
        sb.append("Matrix{u=");
        sb.append(d);
        sb.append(", v=");
        sb.append(d2);
        sb.append(", w=");
        sb.append(d3);
        sb.append(", a=");
        sb.append(d4);
        sb.append(", b=");
        sb.append(d5);
        sb.append(", c=");
        sb.append(d6);
        sb.append(", d=");
        sb.append(d10);
        sb.append(", tx=");
        sb.append(d8);
        sb.append(", ty=");
        sb.append(d9);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    public static zzdtd m30101a(ByteBuffer byteBuffer) {
        double d = zzbc.m26414d(byteBuffer);
        double d2 = zzbc.m26414d(byteBuffer);
        double e = zzbc.m26415e(byteBuffer);
        zzdtd zzdtd = new zzdtd(d, d2, zzbc.m26414d(byteBuffer), zzbc.m26414d(byteBuffer), e, zzbc.m26415e(byteBuffer), zzbc.m26415e(byteBuffer), zzbc.m26414d(byteBuffer), zzbc.m26414d(byteBuffer));
        return zzdtd;
    }

    static {
        zzdtd zzdtd = new zzdtd(1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        f28286a = zzdtd;
        zzdtd zzdtd2 = new zzdtd(0.0d, 1.0d, -1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        f28287b = zzdtd2;
        zzdtd zzdtd3 = new zzdtd(-1.0d, 0.0d, 0.0d, -1.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        f28288c = zzdtd3;
        zzdtd zzdtd4 = new zzdtd(0.0d, -1.0d, 1.0d, 0.0d, 0.0d, 0.0d, 1.0d, 0.0d, 0.0d);
        f28289d = zzdtd4;
    }
}
