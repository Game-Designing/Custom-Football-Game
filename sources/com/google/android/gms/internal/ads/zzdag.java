package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzdag implements zzdti<zzdae> {

    /* renamed from: a */
    private final zzdtu<Executor> f27736a;

    /* renamed from: b */
    private final zzdtu<zzbah> f27737b;

    /* renamed from: c */
    private final zzdtu<zzcmu> f27738c;

    /* renamed from: d */
    private final zzdtu<zzbai> f27739d;

    /* renamed from: e */
    private final zzdtu<String> f27740e;

    /* renamed from: f */
    private final zzdtu<String> f27741f;

    /* renamed from: g */
    private final zzdtu<Context> f27742g;

    /* renamed from: h */
    private final zzdtu<Clock> f27743h;

    private zzdag(zzdtu<Executor> zzdtu, zzdtu<zzbah> zzdtu2, zzdtu<zzcmu> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<String> zzdtu5, zzdtu<String> zzdtu6, zzdtu<Context> zzdtu7, zzdtu<Clock> zzdtu8) {
        this.f27736a = zzdtu;
        this.f27737b = zzdtu2;
        this.f27738c = zzdtu3;
        this.f27739d = zzdtu4;
        this.f27740e = zzdtu5;
        this.f27741f = zzdtu6;
        this.f27742g = zzdtu7;
        this.f27743h = zzdtu8;
    }

    /* renamed from: a */
    public static zzdag m29079a(zzdtu<Executor> zzdtu, zzdtu<zzbah> zzdtu2, zzdtu<zzcmu> zzdtu3, zzdtu<zzbai> zzdtu4, zzdtu<String> zzdtu5, zzdtu<String> zzdtu6, zzdtu<Context> zzdtu7, zzdtu<Clock> zzdtu8) {
        zzdag zzdag = new zzdag(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5, zzdtu6, zzdtu7, zzdtu8);
        return zzdag;
    }

    public final /* synthetic */ Object get() {
        zzdae zzdae = new zzdae((Executor) this.f27736a.get(), (zzbah) this.f27737b.get(), (zzcmu) this.f27738c.get(), (zzbai) this.f27739d.get(), (String) this.f27740e.get(), (String) this.f27741f.get(), (Context) this.f27742g.get(), (Clock) this.f27743h.get());
        return zzdae;
    }
}
