package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p143b.p150d.C7264n;

/* renamed from: com.mopub.nativeads.c */
/* compiled from: AppLovinCustomEventNative */
class C11590c implements C7264n {

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f36124a;

    /* renamed from: b */
    final /* synthetic */ C11513a f36125b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m38415a() {
        boolean[] zArr = f36124a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3548248019790176614L, "com/mopub/nativeads/AppLovinCustomEventNative$AppLovinMopubNativeAd$1", 4);
        f36124a = probes;
        return probes;
    }

    C11590c(C11513a this$1) {
        boolean[] a = m38415a();
        this.f36125b = this$1;
        a[0] = true;
    }

    public void onPostbackSuccess(String url) {
        boolean[] a = m38415a();
        AppLovinCustomEventNative.m38095a(3, "Native ad impression successfully executed.");
        a[1] = true;
        this.f36125b.mo37750d();
        a[2] = true;
    }

    public void onPostbackFailure(String url, int errorCode) {
        boolean[] a = m38415a();
        AppLovinCustomEventNative.m38095a(6, "Native ad impression failed to execute.");
        a[3] = true;
    }
}
