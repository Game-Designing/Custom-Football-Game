package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzceo implements zzdti<Set<zzbuz<zzczz>>> {

    /* renamed from: a */
    private final zzdtu<Executor> f26489a;

    /* renamed from: b */
    private final zzdtu<zzcex> f26490b;

    private zzceo(zzdtu<Executor> zzdtu, zzdtu<zzcex> zzdtu2) {
        this.f26489a = zzdtu;
        this.f26490b = zzdtu2;
    }

    /* renamed from: a */
    public static zzceo m28336a(zzdtu<Executor> zzdtu, zzdtu<zzcex> zzdtu2) {
        return new zzceo(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        Set set;
        Executor executor = (Executor) this.f26489a.get();
        zzcex zzcex = (zzcex) this.f26490b.get();
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f23990Pd)).booleanValue()) {
            set = Collections.singleton(new zzbuz(zzcex, executor));
        } else {
            set = Collections.emptySet();
        }
        zzdto.m30114a(set, "Cannot return null from a non-@Nullable @Provides method");
        return set;
    }
}
