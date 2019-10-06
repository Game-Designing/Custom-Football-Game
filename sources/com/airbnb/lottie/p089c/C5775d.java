package com.airbnb.lottie.p089c;

import com.airbnb.lottie.p089c.p091b.C5751n;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.d */
/* compiled from: FontCharacter */
public class C5775d {

    /* renamed from: a */
    private final List<C5751n> f10056a;

    /* renamed from: b */
    private final char f10057b;

    /* renamed from: c */
    private final double f10058c;

    /* renamed from: d */
    private final double f10059d;

    /* renamed from: e */
    private final String f10060e;

    /* renamed from: f */
    private final String f10061f;

    /* renamed from: a */
    public static int m10381a(char character, String fontFamily, String style) {
        return (((((0 * 31) + character) * 31) + fontFamily.hashCode()) * 31) + style.hashCode();
    }

    public C5775d(List<C5751n> shapes, char character, double size, double width, String style, String fontFamily) {
        this.f10056a = shapes;
        this.f10057b = character;
        this.f10058c = size;
        this.f10059d = width;
        this.f10060e = style;
        this.f10061f = fontFamily;
    }

    /* renamed from: a */
    public List<C5751n> mo18115a() {
        return this.f10056a;
    }

    /* renamed from: b */
    public double mo18116b() {
        return this.f10059d;
    }

    public int hashCode() {
        return m10381a(this.f10057b, this.f10061f, this.f10060e);
    }
}
