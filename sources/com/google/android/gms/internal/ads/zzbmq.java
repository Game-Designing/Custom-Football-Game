package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzbmq implements zzdti<zzbmn> {

    /* renamed from: a */
    private final zzdtu<zzaly> f25564a;

    /* renamed from: b */
    private final zzdtu<zzbml> f25565b;

    /* renamed from: c */
    private final zzdtu<Executor> f25566c;

    /* renamed from: d */
    private final zzdtu<zzbmg> f25567d;

    /* renamed from: e */
    private final zzdtu<Clock> f25568e;

    private zzbmq(zzdtu<zzaly> zzdtu, zzdtu<zzbml> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzbmg> zzdtu4, zzdtu<Clock> zzdtu5) {
        this.f25564a = zzdtu;
        this.f25565b = zzdtu2;
        this.f25566c = zzdtu3;
        this.f25567d = zzdtu4;
        this.f25568e = zzdtu5;
    }

    /* renamed from: a */
    public static zzbmq m27265a(zzdtu<zzaly> zzdtu, zzdtu<zzbml> zzdtu2, zzdtu<Executor> zzdtu3, zzdtu<zzbmg> zzdtu4, zzdtu<Clock> zzdtu5) {
        zzbmq zzbmq = new zzbmq(zzdtu, zzdtu2, zzdtu3, zzdtu4, zzdtu5);
        return zzbmq;
    }

    public final /* synthetic */ Object get() {
        zzbmn zzbmn = new zzbmn((zzaly) this.f25564a.get(), (zzbml) this.f25565b.get(), (Executor) this.f25566c.get(), (zzbmg) this.f25567d.get(), (Clock) this.f25568e.get());
        return zzbmn;
    }
}
