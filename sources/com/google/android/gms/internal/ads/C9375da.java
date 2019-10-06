package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* renamed from: com.google.android.gms.internal.ads.da */
final /* synthetic */ class C9375da implements Predicate {

    /* renamed from: a */
    private final zzaho f22173a;

    C9375da(zzaho zzaho) {
        this.f22173a = zzaho;
    }

    public final boolean apply(Object obj) {
        zzaho zzaho = (zzaho) obj;
        return (zzaho instanceof C9485ia) && C9485ia.m23687a((C9485ia) zzaho).equals(this.f22173a);
    }
}
