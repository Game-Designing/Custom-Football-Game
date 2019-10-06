package com.google.android.gms.internal.ads;

public final class zzbuk implements zzdti<zzbtv> {

    /* renamed from: a */
    private final zzbtv f25891a;

    private zzbuk(zzbtv zzbtv) {
        this.f25891a = zzbtv;
    }

    /* renamed from: a */
    public static zzbuk m27814a(zzbtv zzbtv) {
        return new zzbuk(zzbtv);
    }

    public final /* synthetic */ Object get() {
        zzbtv zzbtv = this.f25891a;
        if (zzbtv != null) {
            zzdto.m30114a(zzbtv, "Cannot return null from a non-@Nullable @Provides method");
            return zzbtv;
        }
        throw null;
    }
}
