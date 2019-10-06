package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbui implements zzdti<Set<zzbuz<AdMetadataListener>>> {

    /* renamed from: a */
    private final zzbtv f25889a;

    private zzbui(zzbtv zzbtv) {
        this.f25889a = zzbtv;
    }

    /* renamed from: a */
    public static zzbui m27812a(zzbtv zzbtv) {
        return new zzbui(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set e = this.f25889a.mo30904e();
        zzdto.m30114a(e, "Cannot return null from a non-@Nullable @Provides method");
        return e;
    }
}
