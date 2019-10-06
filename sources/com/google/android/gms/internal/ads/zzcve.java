package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcve<T> implements zzdti<zzcvb<T>> {

    /* renamed from: a */
    private final zzdtu<Executor> f27435a;

    /* renamed from: b */
    private final zzdtu<Set<zzcva<? extends zzcuz<T>>>> f27436b;

    private zzcve(zzdtu<Executor> zzdtu, zzdtu<Set<zzcva<? extends zzcuz<T>>>> zzdtu2) {
        this.f27435a = zzdtu;
        this.f27436b = zzdtu2;
    }

    /* renamed from: a */
    public static <T> zzcve<T> m28904a(zzdtu<Executor> zzdtu, zzdtu<Set<zzcva<? extends zzcuz<T>>>> zzdtu2) {
        return new zzcve<>(zzdtu, zzdtu2);
    }

    public final /* synthetic */ Object get() {
        return new zzcvb((Executor) this.f27435a.get(), (Set) this.f27436b.get());
    }
}
