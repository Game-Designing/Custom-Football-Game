package com.ironsource.adapters.ris;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.sdk.data.C10888a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p019d.p273h.p276c.C12775b;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p282f.C12869ea;
import p019d.p273h.p276c.p282f.C12885ma;
import p019d.p273h.p276c.p282f.C12889p;
import p019d.p273h.p276c.p284h.C12913g;
import p019d.p273h.p276c.p284h.C12916j;
import p019d.p273h.p276c.p284h.C12919m;
import p019d.p273h.p285d.C12976d;
import p019d.p273h.p285d.C12978e;
import p019d.p273h.p285d.p292f.C12990f;
import p019d.p273h.p285d.p295h.C13004g;

public class RISAdapter extends C12775b implements C12990f {
    private final String AD_VISIBLE_EVENT_NAME = "impressions";
    private final String DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private boolean hasAdAvailable = false;
    /* access modifiers changed from: private */
    public boolean mConsent;
    private boolean mDidReportInitStatus = false;
    /* access modifiers changed from: private */
    public boolean mDidSetConsent;
    /* access modifiers changed from: private */
    public C12978e mSSAPublisher;

    public static RISAdapter startAdapter(String providerName) {
        return new RISAdapter(providerName);
    }

    private RISAdapter(String providerName) {
        super(providerName);
    }

    public String getVersion() {
        return C12916j.m41971b();
    }

    public String getCoreSDKVersion() {
        return C13004g.m42466i();
    }

    public void onResume(Activity activity) {
        C12978e eVar = this.mSSAPublisher;
        if (eVar != null) {
            eVar.onResume(activity);
        }
    }

    public void onPause(Activity activity) {
        C12978e eVar = this.mSSAPublisher;
        if (eVar != null) {
            eVar.onPause(activity);
        }
    }

    public void initRewardedVideo(Activity activity, String appKey, String userId, JSONObject config, C12885ma listener) {
    }

    public void fetchRewardedVideo(JSONObject config) {
    }

    public boolean isRewardedVideoAvailable(JSONObject config) {
        return false;
    }

    public void showRewardedVideo(JSONObject config, C12885ma listener) {
    }

    public void initInterstitial(final Activity activity, final String appKey, final String userId, JSONObject config, C12889p listener) {
        C13004g.m42463f(config.optString("controllerUrl"));
        if (isAdaptersDebugEnabled()) {
            C13004g.m42449a(3);
        } else {
            C13004g.m42449a(config.optInt("debugMode", 0));
        }
        C13004g.m42461e(config.optString("controllerConfig", ""));
        activity.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    RISAdapter.this.mSSAPublisher = C12976d.m42322a(activity);
                    if (RISAdapter.this.mDidSetConsent) {
                        RISAdapter.this.applyConsent(RISAdapter.this.mConsent);
                    }
                    C12976d.m42322a(activity).mo41835a(appKey, userId, RISAdapter.this.getProviderName(), (Map<String, String>) new HashMap<String,String>(), (C12990f) RISAdapter.this);
                } catch (Exception e) {
                    RISAdapter.this.onRVInitFail(e.getMessage());
                }
            }
        });
    }

    public void loadInterstitial(JSONObject config, C12889p listener) {
        if (this.hasAdAvailable) {
            Iterator it = this.mAllInterstitialSmashes.iterator();
            while (it.hasNext()) {
                C12889p smash = (C12889p) it.next();
                if (smash != null) {
                    smash.mo41171a();
                }
            }
            return;
        }
        Iterator it2 = this.mAllInterstitialSmashes.iterator();
        while (it2.hasNext()) {
            C12889p smash2 = (C12889p) it2.next();
            if (smash2 != null) {
                smash2.mo41173a(C12913g.m41922b("No Ads to Load"));
            }
        }
    }

    public void showInterstitial(JSONObject config, C12889p listener) {
        this.mActiveInterstitialSmash = listener;
        if (this.mSSAPublisher != null) {
            int sessionDepth = C12919m.m42012a().mo41701a(2);
            JSONObject showParams = new JSONObject();
            try {
                showParams.put("demandSourceName", getProviderName());
                showParams.put("sessionDepth", sessionDepth);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mSSAPublisher.mo41851e(showParams);
            return;
        }
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41177b(new C12799b(509, "Please call init before calling showRewardedVideo"));
        }
    }

    public boolean isInterstitialReady(JSONObject config) {
        return this.hasAdAvailable;
    }

    public void onRVInitSuccess(C10888a adUnitsReady) {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(":onRVInitSuccess()");
        log(aVar, sb.toString(), 1);
        int numOfAdUnits = 0;
        try {
            numOfAdUnits = Integer.parseInt(adUnitsReady.mo35637b());
        } catch (NumberFormatException e) {
            C12802d.m41613c().mo41426a(C12801a.NATIVE, "onRVInitSuccess:parseInt()", (Throwable) e);
        }
        this.hasAdAvailable = numOfAdUnits > 0;
        if (!this.mDidReportInitStatus) {
            this.mDidReportInitStatus = true;
            Iterator it = this.mAllInterstitialSmashes.iterator();
            while (it.hasNext()) {
                C12889p smash = (C12889p) it.next();
                if (smash != null) {
                    smash.onInterstitialInitSuccess();
                }
            }
        }
    }

    public void onRVInitFail(String description) {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(":onRVInitFail()");
        log(aVar, sb.toString(), 1);
        this.hasAdAvailable = false;
        if (!this.mDidReportInitStatus) {
            this.mDidReportInitStatus = true;
            Iterator it = this.mAllInterstitialSmashes.iterator();
            while (it.hasNext()) {
                C12889p smash = (C12889p) it.next();
                if (smash != null) {
                    smash.mo41180d(C12913g.m41923b(description, "Interstitial"));
                }
            }
        }
    }

    public void onRVNoMoreOffers() {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(":onRVNoMoreOffers()");
        log(aVar, sb.toString(), 1);
        if (!this.mDidReportInitStatus) {
            this.mDidReportInitStatus = true;
            Iterator it = this.mAllInterstitialSmashes.iterator();
            while (it.hasNext()) {
                C12889p smash = (C12889p) it.next();
                if (smash != null) {
                    smash.onInterstitialInitSuccess();
                }
            }
        }
    }

    public void onRVAdCredited(int credits) {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(":onRVAdCredited()");
        log(aVar, sb.toString(), 1);
        C12869ea eaVar = this.mRewardedInterstitial;
        if (eaVar != null) {
            eaVar.mo41183j();
        }
    }

    public void onRVAdClosed() {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(":onRVAdClosed()");
        log(aVar, sb.toString(), 1);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41176b();
        }
    }

    public void onRVAdOpened() {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(":onRVAdOpened()");
        log(aVar, sb.toString(), 1);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41181e();
            this.mActiveInterstitialSmash.mo41179d();
        }
    }

    public void onRVShowFail(String description) {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(":onRVShowFail()");
        log(aVar, sb.toString(), 1);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41177b(new C12799b(509, "Show Failed"));
        }
    }

    public void onRVAdClicked() {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(":onRVAdClicked()");
        log(aVar, sb.toString(), 1);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41178c();
        }
    }

    public void onRVEventNotificationReceived(String eventName, JSONObject extData) {
        if (extData != null) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append(getProviderName());
            sb.append(" :onRISEventNotificationReceived: ");
            sb.append(eventName);
            sb.append(" extData: ");
            sb.append(extData.toString());
            c.mo41427b(aVar, sb.toString(), 1);
            if (!TextUtils.isEmpty(eventName) && "impressions".equals(eventName)) {
                C12889p pVar = this.mActiveInterstitialSmash;
                if (pVar != null) {
                    pVar.mo41182f();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setMediationState(C12792a state, String adUnit) {
        if (this.mSSAPublisher != null) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append(getProviderName());
            sb.append(" :setMediationState(RIS:(rewardedvideo)):");
            sb.append(adUnit);
            String str = " , ";
            sb.append(str);
            sb.append(getProviderName());
            sb.append(str);
            sb.append(state.mo41410e());
            sb.append(")");
            c.mo41427b(aVar, sb.toString(), 1);
            this.mSSAPublisher.mo41831a("rewardedvideo", getProviderName(), state.mo41410e());
        }
    }

    /* access modifiers changed from: protected */
    public void setConsent(boolean consent) {
        this.mConsent = consent;
        this.mDidSetConsent = true;
        applyConsent(consent);
    }

    /* access modifiers changed from: private */
    public void applyConsent(boolean consent) {
        if (this.mSSAPublisher != null) {
            JSONObject consentParams = new JSONObject();
            try {
                consentParams.put("gdprConsentStatus", String.valueOf(consent));
                consentParams.put("demandSourceName", getProviderName());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mSSAPublisher.mo41847c(consentParams);
        }
    }
}
