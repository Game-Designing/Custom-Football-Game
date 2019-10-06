package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.BaseAdapterConfiguration;
import com.mopub.common.OnNetworkInitializationFinishedListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.logging.MoPubLog.LogLevel;
import com.mopub.mobileads.ironsource.BuildConfig;
import java.util.Map;
import p019d.p273h.p276c.C12741D;
import p019d.p273h.p276c.C12741D.C12742a;
import p019d.p273h.p276c.p284h.C12916j;
import p019d.p273h.p285d.p295h.C13003f;

public class IronSourceAdapterConfiguration extends BaseAdapterConfiguration {

    /* renamed from: b */
    private static final String f34795b = IronSourceAdapterConfiguration.class.getSimpleName();

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
        String sdkVersion = C12916j.m41971b();
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
        synchronized (IronSourceAdapterConfiguration.class) {
            if (configuration != null) {
                try {
                    if (context instanceof Activity) {
                        String appKey = (String) configuration.get("applicationKey");
                        if (TextUtils.isEmpty(appKey)) {
                            MoPubLog.log(AdapterLogEvent.CUSTOM, "ironSource's initialization not started. Ensure ironSource's applicationKey is populated on the MoPub dashboard.");
                        } else {
                            C12741D.m41164d("mopub300");
                            C12741D.m41160b((Activity) context, appKey, C12742a.REWARDED_VIDEO);
                            C12741D.m41160b((Activity) context, appKey, C12742a.INTERSTITIAL);
                            networkInitializationSucceeded = true;
                        }
                    }
                } catch (Exception e) {
                    MoPubLog.log(AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Initializing ironSource has encountered an exception.", e);
                }
            }
            if (!(context instanceof Activity)) {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("IronSource's initialization via ");
                sb.append(f34795b);
                sb.append(" not started. An Activity Context is needed.");
                MoPubLog.log(adapterLogEvent, f34795b, sb.toString());
            }
        }
        if (networkInitializationSucceeded) {
            listener.onNetworkInitializationFinished(IronSourceAdapterConfiguration.class, MoPubErrorCode.ADAPTER_INITIALIZATION_SUCCESS);
        } else {
            listener.onNetworkInitializationFinished(IronSourceAdapterConfiguration.class, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
        if (MoPubLog.getLogLevel() == LogLevel.NONE) {
            C13003f.m42435a(0);
        } else {
            C13003f.m42435a(1);
        }
    }
}
