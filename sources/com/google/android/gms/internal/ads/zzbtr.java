package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

public final class zzbtr implements zzdti<zzbtp> {

    /* renamed from: a */
    private final zzdtu<Set<zzbuz<AppEventListener>>> f25857a;

    private zzbtr(zzdtu<Set<zzbuz<AppEventListener>>> zzdtu) {
        this.f25857a = zzdtu;
    }

    /* renamed from: a */
    public static zzbtr m27766a(zzdtu<Set<zzbuz<AppEventListener>>> zzdtu) {
        return new zzbtr(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbtp((Set) this.f25857a.get());
    }
}
