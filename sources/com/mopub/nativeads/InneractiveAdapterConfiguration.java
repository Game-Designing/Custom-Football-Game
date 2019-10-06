package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.MoPubErrorCode;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

public class InneractiveAdapterConfiguration extends BaseAdapterConfiguration {

    /* renamed from: b */
    private static transient /* synthetic */ boolean[] f130b;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m558a() {
        boolean[] zArr = f130b;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6136291530089287586L, "com/mopub/nativeads/InneractiveAdapterConfiguration", 20);
        f130b = probes;
        return probes;
    }

    public InneractiveAdapterConfiguration() {
        m558a()[0] = true;
    }

    public String getAdapterVersion() {
        boolean[] a = m558a();
        StringBuilder sb = new StringBuilder();
        sb.append(InneractiveAdManager.getVersion());
        sb.append(".0");
        String sb2 = sb.toString();
        a[1] = true;
        return sb2;
    }

    public String getBiddingToken(Context context) {
        m558a()[2] = true;
        return null;
    }

    public String getMoPubNetworkName() {
        m558a()[3] = true;
        return "inneractive";
    }

    public String getNetworkSdkVersion() {
        boolean[] a = m558a();
        String version = InneractiveAdManager.getVersion();
        a[4] = true;
        return version;
    }

    public void initializeNetwork(Context context, Map<String, String> configuration, OnNetworkInitializationFinishedListener listener) {
        boolean[] a = m558a();
        Preconditions.checkNotNull(context);
        a[5] = true;
        Preconditions.checkNotNull(listener);
        boolean initializeNetworkSuccess = false;
        synchronized (InneractiveAdapterConfiguration.class) {
            try {
                a[6] = true;
                if (configuration == null) {
                    a[7] = true;
                } else if (TextUtils.isEmpty((CharSequence) configuration.get(InneractiveMediationDefs.REMOTE_KEY_APP_ID))) {
                    a[8] = true;
                } else {
                    a[9] = true;
                    String appId = (String) configuration.get(InneractiveMediationDefs.REMOTE_KEY_APP_ID);
                    a[10] = true;
                    InneractiveAdManager.initialize(context, appId);
                    initializeNetworkSuccess = true;
                    a[11] = true;
                }
                a[12] = true;
            } catch (Exception e) {
                a[13] = true;
                MoPubLog.log(AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initializing Inneractive has encountered an exception.", e);
                a[14] = true;
            } catch (Throwable th) {
                while (true) {
                    a[15] = true;
                    throw th;
                }
            }
        }
        if (initializeNetworkSuccess) {
            a[16] = true;
            listener.onNetworkInitializationFinished(InneractiveAdapterConfiguration.class, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
            a[17] = true;
        } else {
            listener.onNetworkInitializationFinished(InneractiveAdapterConfiguration.class, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            a[18] = true;
        }
        a[19] = true;
    }
}
