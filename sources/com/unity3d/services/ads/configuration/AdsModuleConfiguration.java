package com.unity3d.services.ads.configuration;

import android.os.ConditionVariable;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.services.ads.adunit.VideoPlayerHandler;
import com.unity3d.services.ads.adunit.WebPlayerHandler;
import com.unity3d.services.ads.adunit.WebViewHandler;
import com.unity3d.services.ads.api.AdUnit;
import com.unity3d.services.ads.api.AdsProperties;
import com.unity3d.services.ads.api.Listener;
import com.unity3d.services.ads.api.Placement;
import com.unity3d.services.ads.api.Purchasing;
import com.unity3d.services.ads.api.VideoPlayer;
import com.unity3d.services.ads.api.WebPlayer;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class AdsModuleConfiguration implements IAdsModuleConfiguration {
    /* access modifiers changed from: private */
    public InetAddress _address;

    public Class[] getWebAppApiClassList() {
        return new Class[]{AdUnit.class, Listener.class, VideoPlayer.class, Placement.class, WebPlayer.class, Purchasing.class, AdsProperties.class};
    }

    public boolean resetState(Configuration configuration) {
        com.unity3d.services.ads.placement.Placement.reset();
        return true;
    }

    public boolean initModuleState(Configuration configuration) {
        DeviceLog.debug("Unity Ads init: checking for ad blockers");
        try {
            final String configHost = new URL(configuration.getConfigUrl()).getHost();
            final ConditionVariable cv = new ConditionVariable();
            new Thread() {
                public void run() {
                    try {
                        AdsModuleConfiguration.this._address = InetAddress.getByName(configHost);
                        cv.open();
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Couldn't get address. Host: ");
                        sb.append(configHost);
                        DeviceLog.exception(sb.toString(), e);
                        cv.open();
                    }
                }
            }.start();
            if (cv.block(2000)) {
                InetAddress inetAddress = this._address;
                if (inetAddress != null && inetAddress.isLoopbackAddress()) {
                    DeviceLog.error("Unity Ads init: halting init because Unity Ads config resolves to loopback address (due to ad blocker?)");
                    final IUnityAdsListener listener = com.unity3d.services.ads.properties.AdsProperties.getListener();
                    if (listener != null) {
                        Utilities.runOnUiThread(new Runnable() {
                            public void run() {
                                listener.onUnityAdsError(UnityAdsError.AD_BLOCKER_DETECTED, "Unity Ads config server resolves to loopback address (due to ad blocker?)");
                            }
                        });
                    }
                    return false;
                }
            }
            return true;
        } catch (MalformedURLException e) {
            return true;
        }
    }

    public boolean initErrorState(Configuration configuration, String state, String errorMessage) {
        final IUnityAdsListener listener = UnityAds.getListener();
        StringBuilder sb = new StringBuilder();
        sb.append("Init failed in ");
        sb.append(state);
        final String message = sb.toString();
        if (com.unity3d.services.ads.properties.AdsProperties.getListener() != null) {
            Utilities.runOnUiThread(new Runnable() {
                public void run() {
                    listener.onUnityAdsError(UnityAdsError.INITIALIZE_FAILED, message);
                }
            });
        }
        return true;
    }

    public boolean initCompleteState(Configuration configuration) {
        return true;
    }

    public Map<String, Class> getAdUnitViewHandlers() {
        Map<String, Class> handlers = new HashMap<>();
        handlers.put("videoplayer", VideoPlayerHandler.class);
        handlers.put("webplayer", WebPlayerHandler.class);
        handlers.put("webview", WebViewHandler.class);
        return handlers;
    }
}
