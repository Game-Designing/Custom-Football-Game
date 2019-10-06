package com.airbnb.lottie.p089c;

/* renamed from: com.airbnb.lottie.c.b */
/* compiled from: DocumentData */
public class C5734b {

    /* renamed from: a */
    public final String f9844a;

    /* renamed from: b */
    public final String f9845b;

    /* renamed from: c */
    public final double f9846c;

    /* renamed from: d */
    final int f9847d;

    /* renamed from: e */
    public final int f9848e;

    /* renamed from: f */
    final double f9849f;

    /* renamed from: g */
    public final double f9850g;

    /* renamed from: h */
    public final int f9851h;

    /* renamed from: i */
    public final int f9852i;

    /* renamed from: j */
    public final double f9853j;

    /* renamed from: k */
    public final boolean f9854k;

    public C5734b(String text, String fontName, double size, int justification, int tracking, double lineHeight, double baselineShift, int color, int strokeColor, double strokeWidth, boolean strokeOverFill) {
        this.f9844a = text;
        this.f9845b = fontName;
        this.f9846c = size;
        this.f9847d = justification;
        this.f9848e = tracking;
        this.f9849f = lineHeight;
        this.f9850g = baselineShift;
        this.f9851h = color;
        this.f9852i = strokeColor;
        this.f9853j = strokeWidth;
        this.f9854k = strokeOverFill;
    }

    public int hashCode() {
        double hashCode = (double) (((this.f9844a.hashCode() * 31) + this.f9845b.hashCode()) * 31);
        double d = this.f9846c;
        Double.isNaN(hashCode);
        int result = (((((int) (hashCode + d)) * 31) + this.f9847d) * 31) + this.f9848e;
        long temp = Double.doubleToLongBits(this.f9849f);
        return (((result * 31) + ((int) ((temp >>> 32) ^ temp))) * 31) + this.f9851h;
    }
}
