package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

public final class zzbuj implements zzdti<Set<zzbuz<AppEventListener>>> {

    /* renamed from: a */
    private final zzbtv f25890a;

    private zzbuj(zzbtv zzbtv) {
        this.f25890a = zzbtv;
    }

    /* renamed from: a */
    public static zzbuj m27813a(zzbtv zzbtv) {
        return new zzbuj(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set f = this.f25890a.mo30905f();
        zzdto.m30114a(f, "Cannot return null from a non-@Nullable @Provides method");
        return f;
    }
}
