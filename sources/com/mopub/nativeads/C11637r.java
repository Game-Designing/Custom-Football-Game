package com.mopub.nativeads;

import com.mopub.nativeads.InMobiNativeCustomEvent.InMobiNativeAd;
import com.mopub.nativeads.NativeImageHelper.ImageListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.r */
/* compiled from: InMobiNativeCustomEvent */
class C11637r implements ImageListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36223a;

    /* renamed from: b */
    final /* synthetic */ C11640s f36224b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38464a() {
        boolean[] zArr = f36223a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6509175291812591962L, "com/mopub/nativeads/InMobiNativeCustomEvent$InMobiNativeAd$1$1", 3);
        f36223a = probes;
        return probes;
    }

    C11637r(C11640s this$1) {
        boolean[] a = m38464a();
        this.f36224b = this$1;
        a[0] = true;
    }

    public void onImagesCached() {
        boolean[] a = m38464a();
        InMobiNativeAd.m38175b(this.f36224b.f36231b).onNativeAdLoaded(this.f36224b.f36231b);
        a[1] = true;
    }

    public void onImagesFailedToCache(NativeErrorCode errorCode) {
        boolean[] a = m38464a();
        InMobiNativeAd.m38175b(this.f36224b.f36231b).onNativeAdFailed(errorCode);
        a[2] = true;
    }
}
