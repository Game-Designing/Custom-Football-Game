package com.inmobi.ads;

import android.graphics.Point;
import java.util.Locale;

/* renamed from: com.inmobi.ads.al */
/* compiled from: NativeAssetStyle */
public class C10401al {

    /* renamed from: a */
    public Point f31633a;

    /* renamed from: b */
    Point f31634b;

    /* renamed from: c */
    Point f31635c;

    /* renamed from: d */
    Point f31636d;

    /* renamed from: e */
    protected String f31637e;

    /* renamed from: f */
    protected String f31638f;

    /* renamed from: g */
    protected String f31639g;

    /* renamed from: h */
    protected float f31640h;

    /* renamed from: i */
    protected String f31641i;

    /* renamed from: j */
    protected String f31642j;

    /* renamed from: k */
    protected C10441ba f31643k;

    C10401al() {
        this.f31633a = new Point(0, 0);
        this.f31635c = new Point(0, 0);
        this.f31634b = new Point(0, 0);
        this.f31636d = new Point(0, 0);
        this.f31637e = "none";
        this.f31638f = "straight";
        this.f31640h = 10.0f;
        this.f31641i = "#ff000000";
        this.f31642j = "#00000000";
        this.f31639g = "fill";
        this.f31643k = null;
    }

    public C10401al(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, String str4, C10441ba baVar) {
        this(i, i2, i3, i4, i5, i6, i7, i8, "fill", str, str2, str3, str4, baVar);
    }

    public C10401al(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, String str, String str2, String str3, String str4, String str5, C10441ba baVar) {
        this.f31633a = new Point(i3, i4);
        this.f31634b = new Point(i7, i8);
        this.f31635c = new Point(i, i2);
        this.f31636d = new Point(i5, i6);
        this.f31637e = str2;
        this.f31638f = str3;
        this.f31640h = 10.0f;
        this.f31639g = str;
        if (str4.length() == 0) {
            str4 = "#ff000000";
        }
        this.f31641i = str4;
        if (str5.length() == 0) {
            str5 = "#00000000";
        }
        this.f31642j = str5;
        this.f31643k = baVar;
    }

    /* renamed from: a */
    public final String mo34091a() {
        return this.f31637e;
    }

    /* renamed from: b */
    public final String mo34092b() {
        return this.f31638f;
    }

    /* renamed from: c */
    public final float mo34093c() {
        return this.f31640h;
    }

    /* renamed from: d */
    public final String mo34094d() {
        return this.f31641i.toLowerCase(Locale.US);
    }

    /* renamed from: e */
    public String mo34095e() {
        return this.f31642j.toLowerCase(Locale.US);
    }

    /* renamed from: f */
    public final String mo34096f() {
        return this.f31639g;
    }

    /* renamed from: g */
    public final C10441ba mo34097g() {
        return this.f31643k;
    }
}
