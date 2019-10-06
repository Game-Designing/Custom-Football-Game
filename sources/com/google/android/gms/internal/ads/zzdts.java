package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;

public final class zzdts<T> {

    /* renamed from: a */
    private final List<zzdtu<T>> f28312a;

    /* renamed from: b */
    private final List<zzdtu<Collection<T>>> f28313b;

    private zzdts(int i, int i2) {
        this.f28312a = zzdtf.m30102a(i);
        this.f28313b = zzdtf.m30102a(i2);
    }

    /* renamed from: a */
    public final zzdts<T> mo31705a(zzdtu<? extends T> zzdtu) {
        this.f28312a.add(zzdtu);
        return this;
    }

    /* renamed from: b */
    public final zzdts<T> mo31706b(zzdtu<? extends Collection<? extends T>> zzdtu) {
        this.f28313b.add(zzdtu);
        return this;
    }

    /* renamed from: a */
    public final zzdtq<T> mo31704a() {
        return new zzdtq<>(this.f28312a, this.f28313b);
    }
}
