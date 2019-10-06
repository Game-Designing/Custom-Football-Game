package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import java.util.Set;

public final class zzbvw implements zzdti<zzbvq> {

    /* renamed from: a */
    private final zzdtu<Set<zzbuz<VideoLifecycleCallbacks>>> f25916a;

    private zzbvw(zzdtu<Set<zzbuz<VideoLifecycleCallbacks>>> zzdtu) {
        this.f25916a = zzdtu;
    }

    /* renamed from: a */
    public static zzbvw m27847a(zzdtu<Set<zzbuz<VideoLifecycleCallbacks>>> zzdtu) {
        return new zzbvw(zzdtu);
    }

    public final /* synthetic */ Object get() {
        return new zzbvq((Set) this.f25916a.get());
    }
}
