package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mraid.MraidController;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class WebViewCacheService {
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: a */
    private static final Map<Long, Config> f35174a = Collections.synchronizedMap(new HashMap());
    @VisibleForTesting

    /* renamed from: b */
    static final C11368a f35175b = new C11368a();

    /* renamed from: c */
    private static Handler f35176c = new Handler();

    public static class Config {

        /* renamed from: a */
        private final BaseWebView f35177a;

        /* renamed from: b */
        private final WeakReference<Interstitial> f35178b;

        /* renamed from: c */
        private final ExternalViewabilitySessionManager f35179c;

        /* renamed from: d */
        private final MraidController f35180d;

        Config(BaseWebView baseWebView, Interstitial baseInterstitial, ExternalViewabilitySessionManager viewabilityManager, MraidController controller) {
            this.f35177a = baseWebView;
            this.f35178b = new WeakReference<>(baseInterstitial);
            this.f35179c = viewabilityManager;
            this.f35180d = controller;
        }

        public BaseWebView getWebView() {
            return this.f35177a;
        }

        public WeakReference<Interstitial> getWeakInterstitial() {
            return this.f35178b;
        }

        public ExternalViewabilitySessionManager getViewabilityManager() {
            return this.f35179c;
        }

        public MraidController getController() {
            return this.f35180d;
        }
    }

    /* renamed from: com.mopub.mobileads.WebViewCacheService$a */
    private static class C11368a implements Runnable {
        private C11368a() {
        }

        public void run() {
            WebViewCacheService.m37733a();
        }
    }

    private WebViewCacheService() {
    }

    @VisibleForTesting
    public static void storeWebViewConfig(Long broadcastIdentifier, Interstitial baseInterstitial, BaseWebView baseWebView, ExternalViewabilitySessionManager viewabilityManager, MraidController controller) {
        Preconditions.checkNotNull(broadcastIdentifier);
        Preconditions.checkNotNull(baseInterstitial);
        Preconditions.checkNotNull(baseWebView);
        m37733a();
        if (f35174a.size() >= 50) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "Unable to cache web view. Please destroy some via MoPubInterstitial#destroy() and try again.");
            return;
        }
        f35174a.put(broadcastIdentifier, new Config(baseWebView, baseInterstitial, viewabilityManager, controller));
    }

    public static Config popWebViewConfig(Long broadcastIdentifier) {
        Preconditions.checkNotNull(broadcastIdentifier);
        return (Config) f35174a.remove(broadcastIdentifier);
    }

    @VisibleForTesting
    /* renamed from: a */
    static synchronized void m37733a() {
        synchronized (WebViewCacheService.class) {
            Iterator<Entry<Long, Config>> iterator = f35174a.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<Long, Config> entry = (Entry) iterator.next();
                if (((Config) entry.getValue()).getWeakInterstitial().get() == null) {
                    ((Config) entry.getValue()).getViewabilityManager().endDisplaySession();
                    iterator.remove();
                }
            }
            if (!f35174a.isEmpty()) {
                f35176c.removeCallbacks(f35175b);
                f35176c.postDelayed(f35175b, 900000);
            }
        }
    }

    @Deprecated
    @VisibleForTesting
    public static void clearAll() {
        f35174a.clear();
        f35176c.removeCallbacks(f35175b);
    }
}
