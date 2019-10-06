package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

public final class zzbyl implements zzdti<zzbmy> {

    /* renamed from: a */
    private final zzdtu<zzty> f26080a;

    /* renamed from: b */
    private final zzdtu<Executor> f26081b;

    /* renamed from: c */
    private final zzdtu<Context> f26082c;

    /* renamed from: d */
    private final zzdtu<Clock> f26083d;

    public zzbyl(zzdtu<zzty> zzdtu, zzdtu<Executor> zzdtu2, zzdtu<Context> zzdtu3, zzdtu<Clock> zzdtu4) {
        this.f26080a = zzdtu;
        this.f26081b = zzdtu2;
        this.f26082c = zzdtu3;
        this.f26083d = zzdtu4;
    }

    public final /* synthetic */ Object get() {
        Executor executor = (Executor) this.f26081b.get();
        Context context = (Context) this.f26082c.get();
        Clock clock = (Clock) this.f26083d.get();
        zzbmy zzbmy = new zzbmy(executor, new zzbml(context, (zzty) this.f26080a.get()), clock);
        zzdto.m30114a(zzbmy, "Cannot return null from a non-@Nullable @Provides method");
        return zzbmy;
    }
}
