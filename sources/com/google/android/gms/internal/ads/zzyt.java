package com.google.android.gms.internal.ads;

import java.util.Random;
import java.util.WeakHashMap;

@zzard
public final class zzyt {

    /* renamed from: a */
    private static zzyt f29789a = new zzyt();

    /* renamed from: b */
    private final zzazt f29790b;

    /* renamed from: c */
    private final zzyh f29791c;

    /* renamed from: d */
    private final String f29792d;

    /* renamed from: e */
    private final zzacp f29793e;

    /* renamed from: f */
    private final zzacq f29794f;

    /* renamed from: g */
    private final zzacr f29795g;

    /* renamed from: h */
    private final zzbai f29796h;

    /* renamed from: i */
    private final Random f29797i;

    /* renamed from: j */
    private final WeakHashMap<Object, String> f29798j;

    protected zzyt() {
        zzazt zzazt = new zzazt();
        zzyh zzyh = new zzyh(new zzxx(), new zzxw(), new zzabk(), new zzagk(), new zzatf(), new zzauj(), new zzaqf(), new zzagl());
        this(zzazt, zzyh, new zzacp(), new zzacq(), new zzacr(), zzazt.m26316c(), new zzbai(0, 15000000, true), new Random(), new WeakHashMap());
    }

    private zzyt(zzazt zzazt, zzyh zzyh, zzacp zzacp, zzacq zzacq, zzacr zzacr, String str, zzbai zzbai, Random random, WeakHashMap<Object, String> weakHashMap) {
        this.f29790b = zzazt;
        this.f29791c = zzyh;
        this.f29793e = zzacp;
        this.f29794f = zzacq;
        this.f29795g = zzacr;
        this.f29792d = str;
        this.f29796h = zzbai;
        this.f29797i = random;
        this.f29798j = weakHashMap;
    }

    /* renamed from: a */
    public static zzazt m31532a() {
        return f29789a.f29790b;
    }

    /* renamed from: b */
    public static zzyh m31533b() {
        return f29789a.f29791c;
    }

    /* renamed from: c */
    public static zzacq m31534c() {
        return f29789a.f29794f;
    }

    /* renamed from: d */
    public static zzacp m31535d() {
        return f29789a.f29793e;
    }

    /* renamed from: e */
    public static zzacr m31536e() {
        return f29789a.f29795g;
    }

    /* renamed from: f */
    public static String m31537f() {
        return f29789a.f29792d;
    }

    /* renamed from: g */
    public static zzbai m31538g() {
        return f29789a.f29796h;
    }

    /* renamed from: h */
    public static Random m31539h() {
        return f29789a.f29797i;
    }
}
