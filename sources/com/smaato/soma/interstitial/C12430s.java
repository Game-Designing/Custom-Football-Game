package com.smaato.soma.interstitial;

import android.annotation.SuppressLint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.smaato.soma.interstitial.s */
/* compiled from: InterstitialViewCache */
class C12430s {
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: a */
    private static final Map<Long, C12428r> f38806a = Collections.synchronizedMap(new HashMap());

    /* renamed from: a */
    static void m40856a(Long interstitialViewCacheId, C12428r interstitialBannerView) {
        f38806a.put(interstitialViewCacheId, interstitialBannerView);
    }

    /* renamed from: a */
    static C12428r m40855a(Long interstitialViewCacheId) {
        return (C12428r) f38806a.remove(interstitialViewCacheId);
    }
}
