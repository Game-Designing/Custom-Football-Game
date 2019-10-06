package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbsu implements zzdti<zzbss> {

    /* renamed from: a */
    private final zzdtu<Set<zzbuz<AdMetadataListener>>> f25847a;

    private zzbsu(zzdtu<Set<zzbuz<AdMetadataListener>>> zzdtu) {
        this.f25847a = zzdtu;
    }

    /* renamed from: a */
    public static zzbsu m27750a(zzdtu<Set<zzbuz<AdMetadataListener>>> zzdtu) {
        return new zzbsu(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbss((Set) this.f25847a.get());
    }
}
