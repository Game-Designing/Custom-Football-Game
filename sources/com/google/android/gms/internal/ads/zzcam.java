package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import java.util.concurrent.Executor;

public final class zzcam implements zzdti<zzbuz<VideoLifecycleCallbacks>> {

    /* renamed from: a */
    private final zzcag f26270a;

    /* renamed from: b */
    private final zzdtu<zzccw> f26271b;

    /* renamed from: c */
    private final zzdtu<Executor> f26272c;

    public zzcam(zzcag zzcag, zzdtu<zzccw> zzdtu, zzdtu<Executor> zzdtu2) {
        this.f26270a = zzcag;
        this.f26271b = zzdtu;
        this.f26272c = zzdtu2;
    }

    public final /* synthetic */ Object get() {
        zzbuz zzbuz = new zzbuz((zzccw) this.f26271b.get(), (Executor) this.f26272c.get());
        zzdto.m30114a(zzbuz, "Cannot return null from a non-@Nullable @Provides method");
        return zzbuz;
    }
}
