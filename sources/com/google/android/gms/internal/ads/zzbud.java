package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbud implements zzdti<Set<zzbuz<zzbro>>> {

    /* renamed from: a */
    private final zzbtv f25884a;

    private zzbud(zzbtv zzbtv) {
        this.f25884a = zzbtv;
    }

    /* renamed from: a */
    public static zzbud m27807a(zzbtv zzbtv) {
        return new zzbud(zzbtv);
    }

    public final /* synthetic */ Object get() {
        Set c = this.f25884a.mo30902c();
        zzdto.m30114a(c, "Cannot return null from a non-@Nullable @Provides method");
        return c;
    }
}
