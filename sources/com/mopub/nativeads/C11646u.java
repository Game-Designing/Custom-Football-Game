package com.mopub.nativeads;

import com.mopub.nativeads.InMobiNativeCustomEvent.InMobiNativeAd;
import com.mopub.nativeads.NativeImageHelper.ImageListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.u */
/* compiled from: InMobiNativeCustomEvent */
class C11646u implements ImageListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36241a;

    /* renamed from: b */
    final /* synthetic */ InMobiNativeAd f36242b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38470a() {
        boolean[] zArr = f36241a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8388961941596973774L, "com/mopub/nativeads/InMobiNativeCustomEvent$InMobiNativeAd$3", 3);
        f36241a = probes;
        return probes;
    }

    C11646u(InMobiNativeAd this$0) {
        boolean[] a = m38470a();
        this.f36242b = this$0;
        a[0] = true;
    }

    public void onImagesCached() {
        boolean[] a = m38470a();
        InMobiNativeAd.m38175b(this.f36242b).onNativeAdLoaded(this.f36242b);
        a[1] = true;
    }

    public void onImagesFailedToCache(NativeErrorCode errorCode) {
        boolean[] a = m38470a();
        InMobiNativeAd.m38175b(this.f36242b).onNativeAdFailed(errorCode);
        a[2] = true;
    }
}
