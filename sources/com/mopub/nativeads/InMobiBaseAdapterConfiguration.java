package com.mopub.nativeads;

import android.content.Context;
import com.inmobi.sdk.InMobiSdk;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;

public class InMobiBaseAdapterConfiguration extends BaseAdapterConfiguration {

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f129b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m557a() {
        boolean[] zArr = f129b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8702268332415403367L, "com/mopub/nativeads/InMobiBaseAdapterConfiguration", 6);
        f129b = probes;
        return probes;
    }

    public InMobiBaseAdapterConfiguration() {
        m557a()[0] = true;
    }

    public String getAdapterVersion() {
        m557a()[1] = true;
        return "7.2.6.0";
    }

    public String getBiddingToken(Context context) {
        m557a()[2] = true;
        return null;
    }

    public String getMoPubNetworkName() {
        m557a()[3] = true;
        return "InMobi";
    }

    public String getNetworkSdkVersion() {
        m557a()[4] = true;
        return "7.2.6";
    }

    public void initializeNetwork(Context context, Map<String, String> map, OnNetworkInitializationFinishedListener listener) {
        boolean[] a = m557a();
        InMobiSdk.init(context, BuildConfig.MOPUB_INMOBI_ACCOUNT_ID);
        a[5] = true;
    }
}
