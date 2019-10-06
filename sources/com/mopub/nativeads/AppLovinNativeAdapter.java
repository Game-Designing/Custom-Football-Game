package com.mopub.nativeads;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

public class AppLovinNativeAdapter extends AppLovinCustomEventNative {

    /* renamed from: f */
    private static transient /* synthetic */ boolean[] f35612f;

    /* renamed from: c */
    private static /* synthetic */ boolean[] m38102c() {
        boolean[] zArr = f35612f;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6031350179843555490L, "com/mopub/nativeads/AppLovinNativeAdapter", 1);
        f35612f = probes;
        return probes;
    }

    public AppLovinNativeAdapter() {
        m38102c()[0] = true;
    }
}
