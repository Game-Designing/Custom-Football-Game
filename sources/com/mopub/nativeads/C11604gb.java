package com.mopub.nativeads;

import com.smaato.soma.C12398ha;
import com.smaato.soma.C12408ia;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: com.mopub.nativeads.gb */
/* compiled from: SomaMopubNativeCustomEvent */
class C11604gb extends C12398ha<Void> {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36146a;

    /* renamed from: b */
    final /* synthetic */ C12408ia f36147b;

    /* renamed from: c */
    final /* synthetic */ C11568a f36148c;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38422a() {
        boolean[] zArr = f36146a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6895902346389524303L, "com/mopub/nativeads/SomaMopubNativeCustomEvent$SmaatoForwardingNativeAd$4", 11);
        f36146a = probes;
        return probes;
    }

    C11604gb(C11568a this$0, C12408ia iaVar) {
        boolean[] a = m38422a();
        this.f36148c = this$0;
        this.f36147b = iaVar;
        a[0] = true;
    }

    public Void process() {
        boolean[] a = m38422a();
        C12408ia iaVar = this.f36147b;
        if (iaVar == null) {
            a[1] = true;
        } else if (iaVar == C12408ia.UNSPECIFIED) {
            a[2] = true;
        } else {
            if (iaVar == C12408ia.NO_AD_AVAILABLE) {
                a[4] = true;
                C11568a.m38382b(this.f36148c).onNativeAdFailed(NativeErrorCode.NETWORK_NO_FILL);
                a[5] = true;
            } else if (iaVar == C12408ia.f38748c) {
                a[6] = true;
                C11568a.m38382b(this.f36148c).onNativeAdFailed(NativeErrorCode.NETWORK_INVALID_STATE);
                a[7] = true;
            } else {
                C11568a.m38382b(this.f36148c).onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
                a[8] = true;
            }
            a[9] = true;
            return null;
        }
        C11568a.m38382b(this.f36148c).onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
        a[3] = true;
        a[9] = true;
        return null;
    }
}
