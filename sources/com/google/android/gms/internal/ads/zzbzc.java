package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import p002b.p003c.p053g.p061f.C1273q;

public final class zzbzc {

    /* renamed from: a */
    public static final zzbzc f26157a = new zzbze().mo31042a();

    /* renamed from: b */
    private final zzafl f26158b;

    /* renamed from: c */
    private final zzafi f26159c;

    /* renamed from: d */
    private final zzafx f26160d;

    /* renamed from: e */
    private final zzafu f26161e;

    /* renamed from: f */
    private final zzaje f26162f;

    /* renamed from: g */
    private final C1273q<String, zzafr> f26163g;

    /* renamed from: h */
    private final C1273q<String, zzafo> f26164h;

    /* renamed from: a */
    public final zzafl mo31033a() {
        return this.f26158b;
    }

    /* renamed from: b */
    public final zzafi mo31035b() {
        return this.f26159c;
    }

    /* renamed from: c */
    public final zzafx mo31037c() {
        return this.f26160d;
    }

    /* renamed from: d */
    public final zzafu mo31038d() {
        return this.f26161e;
    }

    /* renamed from: e */
    public final zzaje mo31039e() {
        return this.f26162f;
    }

    /* renamed from: a */
    public final zzafr mo31034a(String str) {
        return (zzafr) this.f26163g.get(str);
    }

    /* renamed from: b */
    public final zzafo mo31036b(String str) {
        return (zzafo) this.f26164h.get(str);
    }

    /* renamed from: f */
    public final ArrayList<String> mo31040f() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.f26160d != null) {
            arrayList.add(Integer.toString(6));
        }
        if (this.f26158b != null) {
            arrayList.add(Integer.toString(1));
        }
        if (this.f26159c != null) {
            arrayList.add(Integer.toString(2));
        }
        if (this.f26163g.size() > 0) {
            arrayList.add(Integer.toString(3));
        }
        if (this.f26162f != null) {
            arrayList.add(Integer.toString(7));
        }
        return arrayList;
    }

    /* renamed from: g */
    public final ArrayList<String> mo31041g() {
        ArrayList<String> arrayList = new ArrayList<>(this.f26163g.size());
        for (int i = 0; i < this.f26163g.size(); i++) {
            arrayList.add((String) this.f26163g.mo9157b(i));
        }
        return arrayList;
    }

    private zzbzc(zzbze zzbze) {
        this.f26158b = zzbze.f26165a;
        this.f26159c = zzbze.f26166b;
        this.f26160d = zzbze.f26167c;
        this.f26163g = new C1273q<>(zzbze.f26170f);
        this.f26164h = new C1273q<>(zzbze.f26171g);
        this.f26161e = zzbze.f26168d;
        this.f26162f = zzbze.f26169e;
    }
}
