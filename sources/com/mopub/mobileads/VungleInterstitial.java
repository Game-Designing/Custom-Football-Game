package com.mopub.mobileads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.vungle.warren.AdConfig;
import com.vungle.warren.BuildConfig;
import java.util.Map;

public class VungleInterstitial extends CustomEventInterstitial {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f35123b = VungleInterstitial.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static VungleRouter f35124c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final Handler f35125d = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CustomEventInterstitialListener f35126e;

    /* renamed from: f */
    private C11363a f35127f;

    /* renamed from: g */
    private VungleAdapterConfiguration f35128g;

    /* renamed from: h */
    private String f35129h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f35130i;

    /* renamed from: j */
    private AdConfig f35131j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f35132k;

    /* renamed from: com.mopub.mobileads.VungleInterstitial$a */
    private class C11363a implements VungleRouterListener {
        private C11363a() {
        }

        /* synthetic */ C11363a(VungleInterstitial x0, C11389bb x1) {
            this();
        }

        public void onAdEnd(String placementReferenceId, boolean wasSuccessfulView, boolean wasCallToActionClicked) {
            if (VungleInterstitial.this.f35130i.equals(placementReferenceId)) {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("onAdEnd - Placement ID: ");
                sb.append(placementReferenceId);
                sb.append(", wasSuccessfulView: ");
                sb.append(wasSuccessfulView);
                sb.append(", wasCallToActionClicked: ");
                sb.append(wasCallToActionClicked);
                MoPubLog.log(adapterLogEvent, VungleInterstitial.f35123b, sb.toString());
                VungleInterstitial.this.f35132k = false;
                VungleInterstitial.this.f35125d.post(new C11395db(this, wasCallToActionClicked));
                VungleInterstitial.f35124c.removeRouterListener(VungleInterstitial.this.f35130i);
            }
        }

        public void onAdStart(String placementReferenceId) {
            if (VungleInterstitial.this.f35130i.equals(placementReferenceId)) {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("onAdStart - Placement ID: ");
                sb.append(placementReferenceId);
                MoPubLog.log(adapterLogEvent, VungleInterstitial.f35123b, sb.toString());
                VungleInterstitial.this.f35132k = true;
                VungleInterstitial.this.f35125d.post(new C11398eb(this));
            }
        }

        public void onUnableToPlayAd(String placementReferenceId, String reason) {
            if (VungleInterstitial.this.f35130i.equals(placementReferenceId)) {
                AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                StringBuilder sb = new StringBuilder();
                sb.append("onUnableToPlayAd - Placement ID: ");
                sb.append(placementReferenceId);
                sb.append(", reason: ");
                sb.append(reason);
                MoPubLog.log(adapterLogEvent, VungleInterstitial.f35123b, sb.toString());
                VungleInterstitial.this.f35132k = false;
                VungleInterstitial.this.f35125d.post(new C11401fb(this));
            }
        }

        public void onAdAvailabilityUpdate(String placementReferenceId, boolean isAdAvailable) {
            if (VungleInterstitial.this.f35130i.equals(placementReferenceId) && !VungleInterstitial.this.f35132k) {
                if (isAdAvailable) {
                    AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
                    StringBuilder sb = new StringBuilder();
                    sb.append("interstitial ad successfully loaded - Placement ID: ");
                    sb.append(placementReferenceId);
                    MoPubLog.log(adapterLogEvent, VungleInterstitial.f35123b, sb.toString());
                    VungleInterstitial.this.f35125d.post(new C11404gb(this));
                    return;
                }
                AdapterLogEvent adapterLogEvent2 = AdapterLogEvent.CUSTOM;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("interstitial ad is not loaded - Placement ID: ");
                sb2.append(placementReferenceId);
                MoPubLog.log(adapterLogEvent2, VungleInterstitial.f35123b, sb2.toString());
                VungleInterstitial.this.f35125d.post(new C11407hb(this));
            }
        }
    }

    public VungleInterstitial() {
        f35124c = VungleRouter.getInstance();
        this.f35128g = new VungleAdapterConfiguration();
    }

    /* access modifiers changed from: protected */
    public void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> localExtras, Map<String, String> serverExtras) {
        this.f35126e = customEventInterstitialListener;
        this.f35132k = false;
        if (context == null) {
            this.f35125d.post(new C11389bb(this));
        } else if (!m37695a(serverExtras)) {
            this.f35125d.post(new C11392cb(this));
        } else {
            if (this.f35127f == null) {
                this.f35127f = new C11363a(this, null);
            }
            if (!f35124c.isVungleInitialized()) {
                f35124c.initVungle(context, this.f35129h);
                this.f35128g.setCachedInitializationParameters(context, serverExtras);
            }
            if (localExtras != null) {
                this.f35131j = new AdConfig();
                Object isSoundEnabled = localExtras.get("vungleSoundEnabled");
                if (isSoundEnabled instanceof Boolean) {
                    this.f35131j.setMuted(!((Boolean) isSoundEnabled).booleanValue());
                }
                Object flexViewCloseTimeInSec = localExtras.get("vungleFlexViewCloseTimeInSec");
                if (flexViewCloseTimeInSec instanceof Integer) {
                    this.f35131j.setFlexViewCloseTime(((Integer) flexViewCloseTimeInSec).intValue());
                }
                Object ordinalViewCount = localExtras.get("vungleOrdinalViewCount");
                if (ordinalViewCount instanceof Integer) {
                    this.f35131j.setOrdinal(((Integer) ordinalViewCount).intValue());
                }
            }
            f35124c.loadAdForPlacement(this.f35130i, this.f35127f);
            MoPubLog.log(this.f35130i, AdapterLogEvent.LOAD_ATTEMPTED, f35123b);
        }
    }

    /* access modifiers changed from: protected */
    public void showInterstitial() {
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f35123b);
        if (f35124c.isAdPlayableForPlacement(this.f35130i)) {
            f35124c.playAdForPlacement(this.f35130i, this.f35131j);
            this.f35132k = true;
            return;
        }
        MoPubLog.log(AdapterLogEvent.CUSTOM, f35123b, "SDK tried to show a Vungle interstitial ad before it finished loading. Please try again.");
        this.f35126e.onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        MoPubLog.log(AdapterLogEvent.SHOW_FAILED, f35123b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
        StringBuilder sb = new StringBuilder();
        sb.append("onInvalidate is called for Placement ID:");
        sb.append(this.f35130i);
        MoPubLog.log(adapterLogEvent, f35123b, sb.toString());
        f35124c.removeRouterListener(this.f35130i);
        this.f35127f = null;
        this.f35131j = null;
    }

    /* renamed from: a */
    private boolean m37695a(Map<String, String> serverExtras) {
        boolean isAllDataValid = true;
        String str = "appId";
        if (serverExtras.containsKey(str)) {
            this.f35129h = (String) serverExtras.get(str);
            String str2 = this.f35129h;
            if (str2 != null && str2.isEmpty()) {
                MoPubLog.log(AdapterLogEvent.CUSTOM, f35123b, "App ID is empty.");
                isAllDataValid = false;
            }
        } else {
            MoPubLog.log(AdapterLogEvent.CUSTOM, f35123b, "AppID is not in serverExtras.");
            isAllDataValid = false;
        }
        String str3 = "pid";
        if (serverExtras.containsKey(str3)) {
            this.f35130i = (String) serverExtras.get(str3);
            String str4 = this.f35130i;
            if (str4 != null && str4.isEmpty()) {
                MoPubLog.log(AdapterLogEvent.CUSTOM, f35123b, "Placement ID for this Ad Unit is empty.");
                isAllDataValid = false;
            }
        } else {
            MoPubLog.log(AdapterLogEvent.CUSTOM, f35123b, "Placement ID for this Ad Unit is not in serverExtras.");
            isAllDataValid = false;
        }
        if (serverExtras.containsKey("pids")) {
            AdapterLogEvent adapterLogEvent = AdapterLogEvent.CUSTOM;
            StringBuilder sb = new StringBuilder();
            sb.append(f35123b);
            sb.append("No need to set placement IDs in MoPub dashboard with Vungle SDK version ");
            sb.append(BuildConfig.VERSION_NAME);
            MoPubLog.log(adapterLogEvent, sb.toString());
        }
        return isAllDataValid;
    }
}
