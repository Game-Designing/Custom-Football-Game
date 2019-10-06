package com.mopub.mobileads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.MobileAds;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.admob.BuildConfig;
import java.util.Map;

public class GooglePlayServicesAdapterConfiguration extends BaseAdapterConfiguration {
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
        String adapterVersion = getAdapterVersion();
        return !TextUtils.isEmpty(adapterVersion) ? adapterVersion.substring(0, adapterVersion.lastIndexOf(46)) : "";
    }

    public void initializeNetwork(Context context, Map<String, String> configuration, OnNetworkInitializationFinishedListener listener) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(listener);
        boolean networkInitializationSucceeded = false;
        synchronized (GooglePlayServicesAdapterConfiguration.class) {
            if (configuration != null) {
                try {
                    if (!TextUtils.isEmpty((CharSequence) configuration.get("appid"))) {
                        MobileAds.initialize(context, (String) configuration.get("appid"));
                        networkInitializationSucceeded = true;
                    }
                } catch (Exception e) {
                    MoPubLog.log(AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initializing AdMob has encountered an exception.", e);
                }
            }
            MobileAds.initialize(context);
            networkInitializationSucceeded = true;
        }
        if (networkInitializationSucceeded) {
            listener.onNetworkInitializationFinished(GooglePlayServicesAdapterConfiguration.class, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
        } else {
            listener.onNetworkInitializationFinished(GooglePlayServicesAdapterConfiguration.class, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }
}
