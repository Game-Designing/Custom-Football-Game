package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.vungle.BuildConfig;
import com.vungle.warren.Vungle;
import java.util.Map;

public class VungleAdapterConfiguration extends BaseAdapterConfiguration {

    /* renamed from: b */
    private static final String f35121b = VungleAdapterConfiguration.class.getSimpleName();

    /* renamed from: c */
    private static VungleRouter f35122c;

    public VungleAdapterConfiguration() {
        f35122c = VungleRouter.getInstance();
    }

    public String getAdapterVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public String getBiddingToken(Context context) {
        return null;
    }

    public String getMoPubNetworkName() {
        return BuildConfig.NETWORK_NAME;
    }

    public String getNetworkSdkVersion() {
        return com.vungle.warren.BuildConfig.VERSION_NAME;
    }

    public void initializeNetwork(Context context, Map<String, String> configuration, OnNetworkInitializationFinishedListener listener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(listener);
        boolean networkInitializationSucceeded = false;
        synchronized (VungleAdapterConfiguration.class) {
            try {
                if (Vungle.isInitialized()) {
                    networkInitializationSucceeded = true;
                } else if (!(configuration == null || f35122c == null)) {
                    String mAppId = (String) configuration.get("appId");
                    if (TextUtils.isEmpty(mAppId)) {
                        MoPubLog.log(AdapterLogEvent.CUSTOM, f35121b, "Vungle's initialization not started. Ensure Vungle's appId is populated");
                        listener.onNetworkInitializationFinished(getClass(), MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                        return;
                    } else if (!f35122c.isVungleInitialized()) {
                        f35122c.initVungle(context, mAppId);
                        networkInitializationSucceeded = true;
                    }
                }
            } catch (Exception e) {
                MoPubLog.log(AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initializing Vungle has encounteredan exception.", e);
            }
        }
        if (networkInitializationSucceeded) {
            listener.onNetworkInitializationFinished(getClass(), MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
        } else {
            listener.onNetworkInitializationFinished(getClass(), MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }
}
