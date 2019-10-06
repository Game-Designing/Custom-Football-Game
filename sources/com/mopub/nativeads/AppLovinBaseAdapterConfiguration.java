package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p143b.p150d.C7267q;

public class AppLovinBaseAdapterConfiguration extends BaseAdapterConfiguration {

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f128b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m556a() {
        boolean[] zArr = f128b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-9215104353894391824L, "com/mopub/nativeads/AppLovinBaseAdapterConfiguration", 7);
        f128b = probes;
        return probes;
    }

    public AppLovinBaseAdapterConfiguration() {
        m556a()[0] = true;
    }

    public String getAdapterVersion() {
        m556a()[1] = true;
        return BuildConfig.APPLOVIN_ADAPTER_VERSION;
    }

    public String getBiddingToken(Context context) {
        m556a()[2] = true;
        return null;
    }

    public String getMoPubNetworkName() {
        m556a()[3] = true;
        return "applovin";
    }

    public String getNetworkSdkVersion() {
        m556a()[4] = true;
        return BuildConfig.APPLOVIN_SDK_VERSION;
    }

    public void initializeNetwork(Context context, Map<String, String> map, OnNetworkInitializationFinishedListener listener) {
        boolean[] a = m556a();
        C7267q.m15796b(context);
        a[5] = true;
        listener.onNetworkInitializationFinished(getClass(), MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
        a[6] = true;
    }
}
