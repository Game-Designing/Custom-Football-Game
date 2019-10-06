package com.smaato.soma.p238b;

/* renamed from: com.smaato.soma.b.e */
/* compiled from: LogMessage */
public class C12147e {

    /* renamed from: a */
    private String f38077a;

    /* renamed from: b */
    private String f38078b;

    /* renamed from: c */
    private int f38079c;

    /* renamed from: d */
    private C12143a f38080d;

    /* renamed from: e */
    private Throwable f38081e;

    public C12147e(String tag, String msg, int level, C12143a category) {
        this.f38077a = tag;
        this.f38078b = msg;
        this.f38079c = level;
        this.f38080d = category;
    }

    public C12147e(String tag, String msg, int level, C12143a category, Throwable exception) {
        this.f38077a = tag;
        this.f38078b = msg;
        this.f38079c = level;
        this.f38080d = category;
        this.f38081e = exception;
    }

    /* renamed from: e */
    public final String mo39385e() {
        return this.f38077a;
    }

    /* renamed from: d */
    public final String mo39384d() {
        return this.f38078b;
    }

    /* renamed from: c */
    public final int mo39383c() {
        return this.f38079c;
    }

    /* renamed from: a */
    public final C12143a mo39381a() {
        return this.f38080d;
    }

    /* renamed from: b */
    public Throwable mo39382b() {
        return this.f38081e;
    }
}
