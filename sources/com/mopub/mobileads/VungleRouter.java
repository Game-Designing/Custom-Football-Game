package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.LifecycleListener;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.vungle.warren.AdConfig;
import com.vungle.warren.BuildConfig;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.Vungle.Consent;
import com.vungle.warren.network.VungleApiClient;
import com.vungle.warren.network.VungleApiClient.WrapperFramework;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class VungleRouter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f35161a = VungleRouter.class.getSimpleName();

    /* renamed from: b */
    private static VungleRouter f35162b = new VungleRouter();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static C11365a f35163c = C11365a.NOTINITIALIZED;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static Map<String, VungleRouterListener> f35164d = new HashMap();

    /* renamed from: e */
    private static Map<String, VungleRouterListener> f35165e = new HashMap();

    /* renamed from: f */
    private static final LifecycleListener f35166f = new C11417jb();

    /* renamed from: g */
    private final PlayAdCallback f35167g = new C11423lb(this);

    /* renamed from: h */
    private final LoadAdCallback f35168h = new C11426mb(this);

    /* renamed from: com.mopub.mobileads.VungleRouter$a */
    private enum C11365a {
        NOTINITIALIZED,
        INITIALIZING,
        INITIALIZED
    }

    private VungleRouter() {
        VungleApiClient.addWrapperInfo(WrapperFramework.mopub, BuildConfig.VERSION_NAME.replace('.', '_'));
    }

    public static VungleRouter getInstance() {
        return f35162b;
    }

    public LifecycleListener getLifecycleListener() {
        return f35166f;
    }

    public void initVungle(Context context, String vungleAppId) {
        Vungle.init(vungleAppId, context.getApplicationContext(), new C11420kb(this));
        f35163c = C11365a.INITIALIZING;
    }

    public void setIncentivizedFields(String userID, String title, String body, String keepWatching, String close) {
        Vungle.setIncentivizedFields(userID, title, body, keepWatching, close);
    }

    public boolean isVungleInitialized() {
        if (f35163c == C11365a.NOTINITIALIZED) {
            return false;
        }
        if (f35163c == C11365a.INITIALIZING || f35163c == C11365a.INITIALIZED) {
            return true;
        }
        return Vungle.isInitialized();
    }

    public void loadAdForPlacement(String placementId, VungleRouterListener routerListener) {
        int i = C11433nb.f35346a[f35163c.ordinal()];
        if (i == 1) {
            MoPubLog.log(AdapterLogEvent.CUSTOM, f35161a, "loadAdForPlacement is called before initialization starts. This is not an expect case.");
        } else if (i == 2) {
            f35165e.put(placementId, routerListener);
        } else if (i == 3) {
            if (isValidPlacement(placementId)) {
                m37730a(placementId, routerListener);
                Vungle.loadAd(placementId, this.f35168h);
                return;
            }
            routerListener.onUnableToPlayAd(placementId, "Invalid/Inactive Placement Id");
        }
    }

    /* renamed from: a */
    private void m37730a(String placementId, VungleRouterListener routerListener) {
        f35164d.put(placementId, routerListener);
    }

    public void removeRouterListener(String placementId) {
        f35164d.remove(placementId);
    }

    public boolean isAdPlayableForPlacement(String placementId) {
        return Vungle.canPlayAd(placementId);
    }

    public void playAdForPlacement(String placementId, AdConfig adConfig) {
        if (Vungle.canPlayAd(placementId)) {
            Vungle.playAd(placementId, adConfig, this.f35167g);
            return;
        }
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("There should not be this case. playAdForPlacement is called before an ad is loaded for Placement ID: ");
        sb.append(placementId);
        MoPubLog.log(adapterLogEvent, f35161a, sb.toString());
    }

    public boolean isValidPlacement(String placementId) {
        return Vungle.isInitialized() && Vungle.getValidPlacements().contains(placementId);
    }

    public void updateConsentStatus(Consent status) {
        Vungle.updateConsentStatus(status, "");
    }

    public Consent getConsentStatus() {
        return Vungle.getConsentStatus();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m37732c() {
        for (Entry<String, VungleRouterListener> entry : f35165e.entrySet()) {
            Vungle.loadAd((String) entry.getKey(), this.f35168h);
            f35164d.put(entry.getKey(), entry.getValue());
        }
        f35165e.clear();
    }
}
