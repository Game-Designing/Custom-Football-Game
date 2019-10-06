package com.smaato.soma.p261j;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.smaato.soma.j.E */
/* compiled from: VastViewCache */
class C12437E {
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: a */
    private static final Map<Long, C12435D> f38837a = Collections.synchronizedMap(new HashMap());

    /* renamed from: a */
    static void m40896a(Long vastViewCacheId, C12435D vastBannerView) {
        f38837a.put(vastViewCacheId, vastBannerView);
    }

    /* renamed from: a */
    static C12435D m40895a(Long vastViewCacheId) {
        return (C12435D) f38837a.remove(vastViewCacheId);
    }
}
