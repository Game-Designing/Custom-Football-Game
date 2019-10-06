package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks;
import java.util.Collections;
import java.util.Set;

public final class zzbuo implements zzdti<Set<zzbuz<VideoLifecycleCallbacks>>> {

    /* renamed from: a */
    private final zzbtv f25896a;

    private zzbuo(zzbtv zzbtv) {
        this.f25896a = zzbtv;
    }

    /* renamed from: a */
    public static zzbuo m27818a(zzbtv zzbtv) {
        return new zzbuo(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set emptySet = Collections.emptySet();
        zzdto.m30114a(emptySet, "Cannot return null from a non-@Nullable @Provides method");
        return emptySet;
    }
}
