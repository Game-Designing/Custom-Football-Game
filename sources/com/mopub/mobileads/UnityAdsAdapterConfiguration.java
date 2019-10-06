package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.unity3d.ads.UnityAds;
import java.util.Map;

public class UnityAdsAdapterConfiguration extends BaseAdapterConfiguration {

    /* renamed from: b */
    private static final String f34944b = UnityAdsAdapterConfiguration.class.getSimpleName();

    public String getAdapterVersion() {
        return "3.0.1.0";
    }

    public String getBiddingToken(Context context) {
        return null;
    }

    public String getMoPubNetworkName() {
        return "unity";
    }

    public String getNetworkSdkVersion() {
        String sdkVersion = UnityAds.getVersion();
        if (!TextUtils.isEmpty(sdkVersion)) {
            return sdkVersion;
        }
        String adapterVersion = getAdapterVersion();
        return adapterVersion.substring(0, adapterVersion.lastIndexOf(46));
    }

    public void initializeNetwork(Context context, Map<String, String> configuration, OnNetworkInitializationFinishedListener listener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(listener);
        boolean networkInitializationSucceeded = false;
        synchronized (UnityAdsAdapterConfiguration.class) {
            try {
                if (UnityAds.isInitialized()) {
                    networkInitializationSucceeded = true;
                } else if (configuration == null || !(context instanceof Activity)) {
                    MoPubLog.log(AdapterLogEvent.CUSTOM, f34944b, "Unity Ads initialization not started. Context is not an Activity. Note that initialization on the first app launch is a no-op.");
                } else {
                    UnityRouter.m37551a(configuration, (Activity) context);
                    networkInitializationSucceeded = true;
                }
            } catch (Exception e) {
                MoPubLog.log(AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initializing Unity Ads has encountered an exception.", e);
            }
        }
        if (networkInitializationSucceeded) {
            listener.onNetworkInitializationFinished(UnityAdsAdapterConfiguration.class, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
        } else {
            listener.onNetworkInitializationFinished(UnityAdsAdapterConfiguration.class, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }
}
