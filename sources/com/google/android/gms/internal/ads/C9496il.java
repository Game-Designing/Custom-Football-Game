package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.ads.il */
final class C9496il implements zzcva<zzcuz<Bundle>> {

    /* renamed from: a */
    private final Set<String> f22561a;

    C9496il(Set<String> set) {
        this.f22561a = set;
    }

    /* renamed from: a */
    public final zzbbh<zzcuz<Bundle>> mo28586a() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.f22561a) {
            arrayList.add(add);
        }
        return zzbar.m26376a(new C9518jl(arrayList));
    }
}
