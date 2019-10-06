package com.mopub.nativeads;

import com.mopub.nativeads.NativeImageHelper.ImageListener;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.eb */
/* compiled from: SomaMopubNativeCustomEvent */
class C11598eb implements ImageListener {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36136a;

    /* renamed from: b */
    final /* synthetic */ C11601fb f36137b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38419a() {
        boolean[] zArr = f36136a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7263143683445295335L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$3$1", 3);
        f36136a = probes;
        return probes;
    }

    C11598eb(C11601fb this$1) {
        boolean[] a = m38419a();
        this.f36137b = this$1;
        a[0] = true;
    }

    public void onImagesCached() {
        boolean[] a = m38419a();
        C11568a.m38382b(this.f36137b.f36143c).onNativeAdLoaded(this.f36137b.f36143c);
        a[1] = true;
    }

    public void onImagesFailedToCache(NativeErrorCode errorCode) {
        boolean[] a = m38419a();
        C11568a.m38382b(this.f36137b.f36143c).onNativeAdFailed(errorCode);
        a[2] = true;
    }
}
