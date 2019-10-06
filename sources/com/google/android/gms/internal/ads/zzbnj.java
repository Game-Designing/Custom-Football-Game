package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

public final class zzbnj implements zzdti<C9168Uf> {

    /* renamed from: a */
    private final zzdtu<Context> f25601a;

    /* renamed from: b */
    private final zzdtu<zzcxn> f25602b;

    /* renamed from: c */
    private final zzdtu<View> f25603c;

    /* renamed from: d */
    private final zzdtu<zzbgz> f25604d;

    /* renamed from: e */
    private final zzdtu<zzbpb> f25605e;

    /* renamed from: f */
    private final zzdtu<zzbzc> f25606f;

    /* renamed from: g */
    private final zzdtu<zzbvd> f25607g;

    /* renamed from: h */
    private final zzdtu<zzcpm> f25608h;

    /* renamed from: i */
    private final zzdtu<Executor> f25609i;

    /* renamed from: j */
    private final zzdtu<zzcxu> f25610j;

    /* renamed from: k */
    private final zzdtu<zzcxm> f25611k;

    /* renamed from: l */
    private final zzdtu<zzbry> f25612l;

    /* renamed from: m */
    private final zzdtu<zzbso> f25613m;

    /* renamed from: n */
    private final zzdtu<String> f25614n;

    public zzbnj(zzdtu<Context> zzdtu, zzdtu<zzcxn> zzdtu2, zzdtu<View> zzdtu3, zzdtu<zzbgz> zzdtu4, zzdtu<zzbpb> zzdtu5, zzdtu<zzbzc> zzdtu6, zzdtu<zzbvd> zzdtu7, zzdtu<zzcpm> zzdtu8, zzdtu<Executor> zzdtu9, zzdtu<zzcxu> zzdtu10, zzdtu<zzcxm> zzdtu11, zzdtu<zzbry> zzdtu12, zzdtu<zzbso> zzdtu13, zzdtu<String> zzdtu14) {
        this.f25601a = zzdtu;
        this.f25602b = zzdtu2;
        this.f25603c = zzdtu3;
        this.f25604d = zzdtu4;
        this.f25605e = zzdtu5;
        this.f25606f = zzdtu6;
        this.f25607g = zzdtu7;
        this.f25608h = zzdtu8;
        this.f25609i = zzdtu9;
        this.f25610j = zzdtu10;
        this.f25611k = zzdtu11;
        this.f25612l = zzdtu12;
        this.f25613m = zzdtu13;
        this.f25614n = zzdtu14;
    }

    /* renamed from: a */
    public static C9168Uf m27294a(Context context, zzcxn zzcxn, View view, zzbgz zzbgz, zzbpb zzbpb, zzbzc zzbzc, zzbvd zzbvd, zzdte<zzcpm> zzdte, Executor executor) {
        C9168Uf uf = new C9168Uf(context, zzcxn, view, zzbgz, zzbpb, zzbzc, zzbvd, zzdte, executor);
        return uf;
    }

    public final /* synthetic */ Object get() {
        C9168Uf uf = new C9168Uf((Context) this.f25601a.get(), (zzcxn) this.f25602b.get(), (View) this.f25603c.get(), (zzbgz) this.f25604d.get(), (zzbpb) this.f25605e.get(), (zzbzc) this.f25606f.get(), (zzbvd) this.f25607g.get(), zzdth.m30108b(this.f25608h), (Executor) this.f25609i.get());
        zzbql.m27693a((zzbpc) uf, (zzcxu) this.f25610j.get());
        zzbql.m27692a((zzbpc) uf, (zzcxm) this.f25611k.get());
        zzbql.m27690a((zzbpc) uf, (zzbry) this.f25612l.get());
        zzbql.m27691a((zzbpc) uf, (zzbso) this.f25613m.get());
        zzbql.m27694a((zzbpc) uf, (String) this.f25614n.get());
        return uf;
    }
}
