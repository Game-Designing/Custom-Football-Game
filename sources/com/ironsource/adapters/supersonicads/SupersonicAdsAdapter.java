package com.ironsource.adapters.supersonicads;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.FrameLayout.LayoutParams;
import com.ironsource.sdk.data.C10888a;
import com.ironsource.sdk.data.C10895h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p019d.p273h.p276c.C12745G;
import p019d.p273h.p276c.C12747I;
import p019d.p273h.p276c.C12775b;
import p019d.p273h.p276c.C12791c.C12792a;
import p019d.p273h.p276c.C12951y;
import p019d.p273h.p276c.p280d.C12799b;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p282f.C12861aa;
import p019d.p273h.p276c.p282f.C12866d;
import p019d.p273h.p276c.p282f.C12878j;
import p019d.p273h.p276c.p282f.C12885ma;
import p019d.p273h.p276c.p282f.C12889p;
import p019d.p273h.p276c.p284h.C12913g;
import p019d.p273h.p276c.p284h.C12916j;
import p019d.p273h.p276c.p284h.C12919m;
import p019d.p273h.p285d.C12976d;
import p019d.p273h.p285d.C12978e;
import p019d.p273h.p285d.p286a.C12957d;
import p019d.p273h.p285d.p292f.C12986b;
import p019d.p273h.p285d.p292f.C12988d;
import p019d.p273h.p285d.p292f.C12989e;
import p019d.p273h.p285d.p292f.C12990f;
import p019d.p273h.p285d.p295h.C13004g;

class SupersonicAdsAdapter extends C12775b implements C12861aa, C12989e, C12988d, C12990f, C12986b {
    private static final String VERSION = "6.8.3";
    private static Handler mUIThreadHandler;
    private final String AD_VISIBLE_EVENT_NAME = "impressions";
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String APPLICATION_USER_AGE_GROUP = "applicationUserAgeGroup";
    private final String APPLICATION_USER_GENDER = "applicationUserGender";
    private final String CAMPAIGN_ID = "campaignId";
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String CUSTOM_SEGMENT = "custom_Segment";
    private final String DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String ITEM_COUNT = "itemCount";
    private final String ITEM_NAME = "itemName";
    private final String ITEM_SIGNATURE = "itemSignature";
    private final String LANGUAGE = "language";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private final String OW_PLACEMENT_ID = "placementId";
    private final String SDK_PLUGIN_TYPE = "SDKPluginType";
    private final String SUPERSONIC_ADS = "SupersonicAds";
    private final String TIMESTAMP = "timestamp";
    /* access modifiers changed from: private */
    public boolean mConsent;
    /* access modifiers changed from: private */
    public boolean mDidSetConsent;
    private boolean mDidSetInitParams = false;
    private boolean mIsRVAvailable = false;
    /* access modifiers changed from: private */
    public C12957d mIsnAdView;
    private String mMediationSegment;
    /* access modifiers changed from: private */
    public C12878j mOfferwallListener;
    /* access modifiers changed from: private */
    public C12978e mSSAPublisher;
    private String mUserAgeGroup;
    private String mUserGender;

    public static SupersonicAdsAdapter startAdapter(String providerName) {
        return new SupersonicAdsAdapter(providerName);
    }

    private SupersonicAdsAdapter(String providerName) {
        super(providerName);
    }

    public static C12951y getIntegrationData(Activity activity) {
        C12951y ret = new C12951y("SupersonicAds", VERSION);
        ret.f39859c = new String[]{"com.ironsource.sdk.controller.ControllerActivity", "com.ironsource.sdk.controller.InterstitialActivity", "com.ironsource.sdk.controller.OpenUrlActivity"};
        return ret;
    }

    public String getVersion() {
        return VERSION;
    }

    public String getCoreSDKVersion() {
        return C13004g.m42466i();
    }

    public void onPause(Activity activity) {
        C12978e eVar = this.mSSAPublisher;
        if (eVar != null) {
            eVar.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        C12978e eVar = this.mSSAPublisher;
        if (eVar != null) {
            eVar.onResume(activity);
        }
    }

    public void setAge(int age) {
        if (age >= 13 && age <= 17) {
            this.mUserAgeGroup = "1";
        } else if (age >= 18 && age <= 20) {
            this.mUserAgeGroup = "2";
        } else if (age >= 21 && age <= 24) {
            this.mUserAgeGroup = "3";
        } else if (age >= 25 && age <= 34) {
            this.mUserAgeGroup = "4";
        } else if (age >= 35 && age <= 44) {
            this.mUserAgeGroup = "5";
        } else if (age >= 45 && age <= 54) {
            this.mUserAgeGroup = "6";
        } else if (age >= 55 && age <= 64) {
            this.mUserAgeGroup = "7";
        } else if (age <= 65 || age > 120) {
            this.mUserAgeGroup = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
        } else {
            this.mUserAgeGroup = "8";
        }
    }

    public void setGender(String gender) {
        this.mUserGender = gender;
    }

    public void setMediationSegment(String segment) {
        this.mMediationSegment = segment;
    }

    public void initRewardedVideo(Activity activity, String appKey, String userId, JSONObject config, C12885ma listener) {
        if (!this.mDidSetInitParams) {
            setParamsBeforeInit(config);
        }
        final Activity activity2 = activity;
        final JSONObject jSONObject = config;
        final String str = appKey;
        final String str2 = userId;
        C108051 r1 = new Runnable() {
            public void run() {
                try {
                    SupersonicAdsAdapter.this.mSSAPublisher = C12976d.m42322a(activity2);
                    HashMap<String, String> rewardedVideoExtraParams = SupersonicAdsAdapter.this.getRewardedVideoExtraParams(jSONObject);
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                    }
                    SupersonicAdsAdapter.this.mSSAPublisher.mo41835a(str, str2, SupersonicAdsAdapter.this.getProviderName(), (Map<String, String>) rewardedVideoExtraParams, (C12990f) SupersonicAdsAdapter.this);
                } catch (Exception e) {
                    e.printStackTrace();
                    SupersonicAdsAdapter.this.onRVInitFail("initRewardedVideo");
                }
            }
        };
        activity.runOnUiThread(r1);
    }

    public void fetchRewardedVideo(JSONObject config) {
    }

    public void showRewardedVideo(JSONObject config, C12885ma listener) {
        this.mActiveRewardedVideoSmash = listener;
        if (this.mSSAPublisher != null) {
            int sessionDepth = C12919m.m42012a().mo41701a(1);
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
        this.mIsRVAvailable = false;
        C12885ma maVar = this.mActiveRewardedVideoSmash;
        if (maVar != null) {
            maVar.mo41414c(C12913g.m41924c("Rewarded Video"));
        }
        Iterator it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            C12885ma smash = (C12885ma) it.next();
            if (smash != null) {
                smash.mo41413a(false);
            }
        }
    }

    public synchronized boolean isRewardedVideoAvailable(JSONObject config) {
        return this.mIsRVAvailable;
    }

    public synchronized void preInitInterstitial(final Activity activity, final String appKey, final String userId, JSONObject config, C12889p listener) {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(": preInitInterstitial");
        log(aVar, sb.toString(), 0);
        if (!this.mDidSetInitParams) {
            setParamsBeforeInit(config);
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                synchronized (SupersonicAdsAdapter.this) {
                    try {
                        SupersonicAdsAdapter.this.mSSAPublisher = C12976d.m42322a(activity);
                        HashMap<String, String> interstitialExtraParams = SupersonicAdsAdapter.this.getInterstitialExtraParams();
                        if (SupersonicAdsAdapter.this.mDidSetConsent) {
                            SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                        }
                        SupersonicAdsAdapter.this.mSSAPublisher.mo41834a(appKey, userId, SupersonicAdsAdapter.this.getProviderName(), (Map<String, String>) interstitialExtraParams, (C12988d) null);
                    } catch (Exception e) {
                        e.printStackTrace();
                        SupersonicAdsAdapter.this.onInterstitialInitFailed(e.getMessage());
                    }
                }
            }
        });
    }

    public synchronized void initInterstitial(final Activity activity, final String appKey, final String userId, JSONObject config, C12889p listener) {
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(": initInterstitial");
        log(aVar, sb.toString(), 0);
        if (!this.mDidSetInitParams) {
            setParamsBeforeInit(config);
        }
        activity.runOnUiThread(new Runnable() {
            public void run() {
                synchronized (SupersonicAdsAdapter.this) {
                    try {
                        SupersonicAdsAdapter.this.mSSAPublisher = C12976d.m42322a(activity);
                        HashMap<String, String> interstitialExtraParams = SupersonicAdsAdapter.this.getInterstitialExtraParams();
                        if (SupersonicAdsAdapter.this.mDidSetConsent) {
                            SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                        }
                        SupersonicAdsAdapter.this.mSSAPublisher.mo41834a(appKey, userId, SupersonicAdsAdapter.this.getProviderName(), (Map<String, String>) interstitialExtraParams, (C12988d) SupersonicAdsAdapter.this);
                    } catch (Exception e) {
                        e.printStackTrace();
                        SupersonicAdsAdapter.this.onInterstitialInitFailed(e.getMessage());
                    }
                }
            }
        });
    }

    public void loadInterstitial(JSONObject config, C12889p listener) {
        if (this.mSSAPublisher != null) {
            JSONObject loadParams = new JSONObject();
            try {
                loadParams.put("demandSourceName", getProviderName());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.mSSAPublisher.mo41850d(loadParams);
            return;
        }
        log(C12801a.NATIVE, "Please call initInterstitial before calling loadInterstitial", 2);
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            C12889p smash = (C12889p) it.next();
            if (smash != null) {
                smash.mo41173a(C12913g.m41922b("Load was called before Init"));
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
            this.mSSAPublisher.mo41838a(showParams);
            return;
        }
        log(C12801a.NATIVE, "Please call loadInterstitial before calling showInterstitial", 2);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41177b(C12913g.m41924c("Interstitial"));
        }
    }

    public boolean isInterstitialReady(JSONObject config) {
        C12978e eVar = this.mSSAPublisher;
        return eVar != null && eVar.mo41852e(getProviderName());
    }

    public void setInternalOfferwallListener(C12878j listener) {
        this.mOfferwallListener = listener;
    }

    public void initOfferwall(Activity activity, String appKey, String userId, JSONObject config) {
        if (!this.mDidSetInitParams) {
            setParamsBeforeInit(config);
        }
        final JSONObject jSONObject = config;
        final Activity activity2 = activity;
        final String str = appKey;
        final String str2 = userId;
        C108084 r1 = new Runnable() {
            public void run() {
                try {
                    Map<String, String> offerwallExtraParams = SupersonicAdsAdapter.this.getOfferwallExtraParams(jSONObject);
                    SupersonicAdsAdapter.this.mSSAPublisher = C12976d.m42322a(activity2);
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                    }
                    SupersonicAdsAdapter.this.mSSAPublisher.mo41836a(str, str2, offerwallExtraParams, SupersonicAdsAdapter.this);
                } catch (Exception e) {
                    e.printStackTrace();
                    C12802d c = C12802d.m41613c();
                    C12801a aVar = C12801a.ADAPTER_API;
                    StringBuilder sb = new StringBuilder();
                    sb.append(SupersonicAdsAdapter.this.getProviderName());
                    sb.append(":initOfferwall(userId:");
                    sb.append(str2);
                    sb.append(")");
                    c.mo41426a(aVar, sb.toString(), (Throwable) e);
                    C12878j access$700 = SupersonicAdsAdapter.this.mOfferwallListener;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Adapter initialization failure - ");
                    sb2.append(SupersonicAdsAdapter.this.getProviderName());
                    sb2.append(" - ");
                    sb2.append(e.getMessage());
                    access$700.mo41254a(false, C12913g.m41923b(sb2.toString(), "Offerwall"));
                }
            }
        };
        activity.runOnUiThread(r1);
    }

    public void getOfferwallCredits() {
        if (this.mSSAPublisher != null) {
            this.mSSAPublisher.mo41832a(C12747I.m41186g().mo41232h(), C12747I.m41186g().mo41234i(), (C12989e) this);
            return;
        }
        log(C12801a.NATIVE, "Please call init before calling getOfferwallCredits", 2);
    }

    public void showOfferwall(String placementId, JSONObject config) {
        Map<String, String> offerwallExtraParams = getOfferwallExtraParams(config);
        if (offerwallExtraParams != null) {
            offerwallExtraParams.put("placementId", placementId);
        }
        C12978e eVar = this.mSSAPublisher;
        if (eVar != null) {
            eVar.mo41837a(offerwallExtraParams);
        } else {
            log(C12801a.NATIVE, "Please call init before calling showOfferwall", 2);
        }
    }

    public boolean isOfferwallAvailable() {
        return true;
    }

    public void initBanners(Activity activity, String appKey, String userId, JSONObject config, C12866d listener) {
        if (!this.mDidSetInitParams) {
            setParamsBeforeInit(config);
        }
        final JSONObject jSONObject = config;
        final Activity activity2 = activity;
        final String str = appKey;
        final String str2 = userId;
        C108095 r1 = new Runnable() {
            public void run() {
                try {
                    Map<String, String> bannerExtraParams = SupersonicAdsAdapter.this.getBannerExtraParams(jSONObject);
                    SupersonicAdsAdapter.this.mSSAPublisher = C12976d.m42322a(activity2);
                    if (SupersonicAdsAdapter.this.mDidSetConsent) {
                        SupersonicAdsAdapter.this.applyConsent(SupersonicAdsAdapter.this.mConsent);
                    }
                    SupersonicAdsAdapter.this.mSSAPublisher.mo41833a(str, str2, SupersonicAdsAdapter.this.getProviderName(), bannerExtraParams, (C12986b) SupersonicAdsAdapter.this);
                } catch (Exception e) {
                    e.printStackTrace();
                    SupersonicAdsAdapter.this.onBannerInitFailed(e.getMessage());
                }
            }
        };
        activity.runOnUiThread(r1);
    }

    public void loadBanner(final C12745G banner, JSONObject config, C12866d listener) {
        try {
            if (this.mSSAPublisher == null) {
                log(C12801a.NATIVE, "Please call initBanner before calling loadBanner", 2);
                Iterator it = this.mAllBannerSmashes.iterator();
                while (it.hasNext()) {
                    C12866d smash = (C12866d) it.next();
                    if (smash != null) {
                        smash.mo41638a(C12913g.m41922b("Load was called before Init"));
                    }
                }
            }
            if (banner == null) {
                C12802d.m41613c().mo41427b(C12801a.INTERNAL, "SupersonicAds loadBanner banner == null", 3);
                return;
            }
            this.mActiveBannerSmash = listener;
            if (this.mIsnAdView != null) {
                this.mIsnAdView.mo41794a();
                this.mIsnAdView = null;
            }
            final JSONObject loadParams = new JSONObject();
            loadParams.put("demandSourceName", getProviderName());
            loadParams.put("productType", C10895h.Banner);
            if (mUIThreadHandler == null) {
                mUIThreadHandler = new Handler(Looper.getMainLooper());
            }
            mUIThreadHandler.post(new Runnable() {
                public void run() {
                    try {
                        SupersonicAdsAdapter.this.mIsnAdView = SupersonicAdsAdapter.this.createBanner(banner.getActivity(), banner.getSize(), SupersonicAdsAdapter.this.mActiveBannerSmash);
                        if (SupersonicAdsAdapter.this.mIsnAdView != null) {
                            SupersonicAdsAdapter.this.mIsnAdView.mo41798a(loadParams);
                        }
                    } catch (Exception e) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Banner Load Fail, ");
                        sb.append(SupersonicAdsAdapter.this.getProviderName());
                        sb.append(" - ");
                        sb.append(e.getMessage());
                        C12799b error = C12913g.m41922b(sb.toString());
                        if (SupersonicAdsAdapter.this.mActiveBannerSmash != null) {
                            SupersonicAdsAdapter.this.mActiveBannerSmash.mo41638a(error);
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reloadBanner(JSONObject config) {
        try {
            if (this.mIsnAdView != null) {
                this.mIsnAdView.mo41798a(config);
            }
        } catch (Exception e) {
            e.printStackTrace();
            C12801a aVar = C12801a.NATIVE;
            StringBuilder sb = new StringBuilder();
            sb.append(getProviderName());
            sb.append(" reloadBanner Failed to reload banner ad");
            log(aVar, sb.toString(), 2);
        }
    }

    public void destroyBanner(JSONObject config) {
        C12957d dVar = this.mIsnAdView;
        if (dVar != null) {
            dVar.mo41794a();
            this.mIsnAdView = null;
        }
    }

    private synchronized void setParamsBeforeInit(JSONObject config) {
        this.mDidSetInitParams = true;
        C13004g.m42463f(config.optString("controllerUrl"));
        if (isAdaptersDebugEnabled()) {
            C13004g.m42449a(3);
        } else {
            C13004g.m42449a(config.optInt("debugMode", 0));
        }
        C13004g.m42461e(config.optString("controllerConfig", ""));
    }

    private HashMap<String, String> getGenenralExtraParams() {
        HashMap<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(this.mUserAgeGroup)) {
            params.put("applicationUserAgeGroup", this.mUserAgeGroup);
        }
        if (!TextUtils.isEmpty(this.mUserGender)) {
            params.put("applicationUserGender", this.mUserGender);
        }
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            params.put("SDKPluginType", pluginType);
        }
        return params;
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> getRewardedVideoExtraParams(JSONObject config) {
        HashMap<String, String> rvExtraParams = getGenenralExtraParams();
        String str = "language";
        String language = config.optString(str);
        if (!TextUtils.isEmpty(language)) {
            rvExtraParams.put(str, language);
        }
        String str2 = "maxVideoLength";
        String maxVideoLength = config.optString(str2);
        if (!TextUtils.isEmpty(maxVideoLength)) {
            rvExtraParams.put(str2, maxVideoLength);
        }
        String str3 = "campaignId";
        String campaignId = config.optString(str3);
        if (!TextUtils.isEmpty(campaignId)) {
            rvExtraParams.put(str3, campaignId);
        }
        if (!TextUtils.isEmpty(this.mMediationSegment)) {
            rvExtraParams.put("custom_Segment", this.mMediationSegment);
        }
        addItemNameCountSignature(rvExtraParams, config);
        Map<String, String> customParams = SupersonicConfig.getConfigObj().getRewardedVideoCustomParams();
        if (customParams != null && !customParams.isEmpty()) {
            rvExtraParams.putAll(customParams);
        }
        return rvExtraParams;
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> getInterstitialExtraParams() {
        return getGenenralExtraParams();
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> getOfferwallExtraParams(JSONObject config) {
        HashMap<String, String> owExtraParams = getGenenralExtraParams();
        String str = "language";
        String language = config.optString(str);
        if (!TextUtils.isEmpty(language)) {
            owExtraParams.put(str, language);
        }
        owExtraParams.put("useClientSideCallbacks", String.valueOf(SupersonicConfig.getConfigObj().getClientSideCallbacks()));
        Map<String, String> customParams = SupersonicConfig.getConfigObj().getOfferwallCustomParams();
        if (customParams != null && !customParams.isEmpty()) {
            owExtraParams.putAll(customParams);
        }
        addItemNameCountSignature(owExtraParams, config);
        return owExtraParams;
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> getBannerExtraParams(JSONObject config) {
        return getGenenralExtraParams();
    }

    private void addItemNameCountSignature(HashMap<String, String> params, JSONObject config) {
        String str = "itemCount";
        String str2 = "itemName";
        try {
            String itemName = config.optString(str2);
            int itemCount = config.optInt(str, -1);
            String privateKey = config.optString("privateKey");
            boolean shouldAddSignature = true;
            if (TextUtils.isEmpty(itemName)) {
                shouldAddSignature = false;
            } else {
                params.put(str2, itemName);
            }
            if (TextUtils.isEmpty(privateKey)) {
                shouldAddSignature = false;
            }
            if (itemCount == -1) {
                shouldAddSignature = false;
            } else {
                params.put(str, String.valueOf(itemCount));
            }
            if (shouldAddSignature) {
                int timestamp = C12916j.m41955a();
                params.put("timestamp", String.valueOf(timestamp));
                params.put("itemSignature", createItemSig(timestamp, itemName, itemCount, privateKey));
            }
        } catch (Exception e) {
            C12802d.m41613c().mo41426a(C12801a.ADAPTER_API, " addItemNameCountSignature", (Throwable) e);
        }
    }

    private String createItemSig(int timestamp, String itemName, int itemCount, String privateKey) {
        StringBuilder sb = new StringBuilder();
        sb.append(timestamp);
        sb.append(itemName);
        sb.append(itemCount);
        sb.append(privateKey);
        return C12916j.m41960a(sb.toString());
    }

    private String createMinimumOfferCommissionSig(double min, String privateKey) {
        StringBuilder sb = new StringBuilder();
        sb.append(min);
        sb.append(privateKey);
        return C12916j.m41960a(sb.toString());
    }

    private String createUserCreationDateSig(String userid, String uCreationDate, String privateKey) {
        StringBuilder sb = new StringBuilder();
        sb.append(userid);
        sb.append(uCreationDate);
        sb.append(privateKey);
        return C12916j.m41960a(sb.toString());
    }

    /* access modifiers changed from: private */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p019d.p273h.p285d.p286a.C12957d createBanner(android.app.Activity r21, p019d.p273h.p276c.C12939q r22, p019d.p273h.p276c.p282f.C12866d r23) {
        /*
            r20 = this;
            r0 = r21
            r1 = r23
            java.lang.String r2 = "BANNER"
            java.lang.String r3 = "LARGE"
            java.lang.String r4 = "RECTANGLE"
            java.lang.String r5 = "SMART"
            java.lang.String r6 = "CUSTOM"
            r7 = 320(0x140, float:4.48E-43)
            r8 = 50
            r9 = 728(0x2d8, float:1.02E-42)
            r10 = 90
            java.lang.String r11 = r22.mo41758a()
            r12 = 320(0x140, float:4.48E-43)
            r13 = 50
            int r14 = r11.hashCode()
            r15 = 1
            switch(r14) {
                case -387072689: goto L_0x004f;
                case 72205083: goto L_0x0045;
                case 79011241: goto L_0x003b;
                case 1951953708: goto L_0x0031;
                case 1999208305: goto L_0x0027;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x0059
        L_0x0027:
            java.lang.String r14 = "CUSTOM"
            boolean r14 = r11.equals(r14)
            if (r14 == 0) goto L_0x0026
            r14 = 3
            goto L_0x005a
        L_0x0031:
            java.lang.String r14 = "BANNER"
            boolean r14 = r11.equals(r14)
            if (r14 == 0) goto L_0x0026
            r14 = 0
            goto L_0x005a
        L_0x003b:
            java.lang.String r14 = "SMART"
            boolean r14 = r11.equals(r14)
            if (r14 == 0) goto L_0x0026
            r14 = 2
            goto L_0x005a
        L_0x0045:
            java.lang.String r14 = "LARGE"
            boolean r14 = r11.equals(r14)
            if (r14 == 0) goto L_0x0026
            r14 = 1
            goto L_0x005a
        L_0x004f:
            java.lang.String r14 = "RECTANGLE"
            boolean r14 = r11.equals(r14)
            if (r14 == 0) goto L_0x0026
            r14 = 4
            goto L_0x005a
        L_0x0059:
            r14 = -1
        L_0x005a:
            if (r14 == 0) goto L_0x00b5
            if (r14 == r15) goto L_0x00ae
            r15 = 2
            if (r14 == r15) goto L_0x0092
            java.lang.String r15 = "SupersonicAds"
            r17 = 0
            r18 = r2
            r2 = 3
            if (r14 == r2) goto L_0x0074
            if (r1 == 0) goto L_0x0073
            d.h.c.d.b r2 = p019d.p273h.p276c.p284h.C12913g.m41929f(r15)
            r1.mo41638a(r2)
        L_0x0073:
            return r17
        L_0x0074:
            int r2 = r22.mo41760c()
            int r12 = r22.mo41759b()
            r14 = 320(0x140, float:4.48E-43)
            if (r2 < r14) goto L_0x0088
            r13 = 50
            if (r12 == r13) goto L_0x00bc
            r13 = 90
            if (r12 == r13) goto L_0x00bc
        L_0x0088:
            if (r1 == 0) goto L_0x0091
            d.h.c.d.b r13 = p019d.p273h.p276c.p284h.C12913g.m41929f(r15)
            r1.mo41638a(r13)
        L_0x0091:
            return r17
        L_0x0092:
            r18 = r2
            r2 = 90
            r14 = 320(0x140, float:4.48E-43)
            r15 = 50
            boolean r16 = p019d.p273h.p276c.C12797d.m41601a(r21)
            if (r16 == 0) goto L_0x00a2
            r14 = 728(0x2d8, float:1.02E-42)
        L_0x00a2:
            r12 = r14
            if (r16 == 0) goto L_0x00a7
            r15 = 90
        L_0x00a7:
            r2 = r15
            r19 = r12
            r12 = r2
            r2 = r19
            goto L_0x00bc
        L_0x00ae:
            r18 = r2
            r2 = 320(0x140, float:4.48E-43)
            r12 = 90
            goto L_0x00bc
        L_0x00b5:
            r18 = r2
            r2 = 320(0x140, float:4.48E-43)
            r12 = 50
        L_0x00bc:
            int r13 = p019d.p273h.p276c.C12797d.m41600a(r0, r2)
            int r14 = p019d.p273h.p276c.C12797d.m41600a(r0, r12)
            d.h.d.a r15 = new d.h.d.a
            r15.<init>(r13, r14, r11)
            r1 = r20
            r16 = r2
            d.h.d.e r2 = r1.mSSAPublisher
            d.h.d.a.d r2 = r2.mo41822a(r0, r15)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.supersonicads.SupersonicAdsAdapter.createBanner(android.app.Activity, d.h.c.q, d.h.c.f.d):d.h.d.a.d");
    }

    public void onRVNoMoreOffers() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onRVNoMoreOffers ");
        c.mo41427b(aVar, sb.toString(), 1);
        this.mIsRVAvailable = false;
        Iterator it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            C12885ma smash = (C12885ma) it.next();
            if (smash != null) {
                smash.mo41413a(false);
            }
        }
    }

    public void onRVInitSuccess(C10888a aur) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onRVInitSuccess ");
        boolean z = true;
        c.mo41427b(aVar, sb.toString(), 1);
        int numOfAdUnits = 0;
        try {
            numOfAdUnits = Integer.parseInt(aur.mo35637b());
        } catch (NumberFormatException e) {
            C12802d.m41613c().mo41426a(C12801a.NATIVE, "onRVInitSuccess:parseInt()", (Throwable) e);
        }
        if (numOfAdUnits <= 0) {
            z = false;
        }
        boolean availability = z;
        this.mIsRVAvailable = availability;
        Iterator it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            C12885ma smash = (C12885ma) it.next();
            if (smash != null) {
                smash.mo41413a(availability);
            }
        }
    }

    public void onRVInitFail(String error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onRVInitFail ");
        c.mo41427b(aVar, sb.toString(), 1);
        Iterator it = this.mAllRewardedVideoSmashes.iterator();
        while (it.hasNext()) {
            C12885ma smash = (C12885ma) it.next();
            if (smash != null) {
                smash.mo41413a(false);
            }
        }
    }

    public void onRVAdClicked() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onRVAdClicked ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12885ma maVar = this.mActiveRewardedVideoSmash;
        if (maVar != null) {
            maVar.mo41416h();
        }
    }

    public void onRVEventNotificationReceived(String eventName, JSONObject extData) {
        if (extData != null) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append(getProviderName());
            sb.append(" :onRVEventNotificationReceived: ");
            sb.append(eventName);
            sb.append(" extData: ");
            sb.append(extData.toString());
            c.mo41427b(aVar, sb.toString(), 1);
        }
        if (!TextUtils.isEmpty(eventName) && "impressions".equals(eventName)) {
            C12885ma maVar = this.mActiveRewardedVideoSmash;
            if (maVar != null) {
                maVar.mo41415g();
            }
        }
    }

    public void onRVShowFail(String error) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onRVShowFail ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12885ma maVar = this.mActiveRewardedVideoSmash;
        if (maVar != null) {
            maVar.mo41414c(new C12799b(509, error));
        }
    }

    public void onRVAdCredited(int amount) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onRVAdCredited ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12885ma maVar = this.mActiveRewardedVideoSmash;
        if (maVar != null) {
            maVar.mo41417i();
        }
    }

    public void onRVAdClosed() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onRVAdClosed ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12885ma maVar = this.mActiveRewardedVideoSmash;
        if (maVar != null) {
            maVar.onRewardedVideoAdClosed();
        }
    }

    public void onRVAdOpened() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onRVAdOpened ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12885ma maVar = this.mActiveRewardedVideoSmash;
        if (maVar != null) {
            maVar.onRewardedVideoAdOpened();
        }
    }

    public void onInterstitialInitSuccess() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onInterstitialInitSuccess ");
        c.mo41427b(aVar, sb.toString(), 1);
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            C12889p smash = (C12889p) it.next();
            if (smash != null) {
                smash.onInterstitialInitSuccess();
            }
        }
    }

    public void onInterstitialInitFailed(String description) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onInterstitialInitFailed ");
        c.mo41427b(aVar, sb.toString(), 1);
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            C12889p smash = (C12889p) it.next();
            if (smash != null) {
                smash.mo41180d(C12913g.m41923b(description, "Interstitial"));
            }
        }
    }

    public void onInterstitialLoadSuccess() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onInterstitialLoadSuccess ");
        c.mo41427b(aVar, sb.toString(), 1);
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            C12889p smash = (C12889p) it.next();
            if (smash != null) {
                smash.mo41171a();
            }
        }
    }

    public void onInterstitialLoadFailed(String description) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onInterstitialAdLoadFailed ");
        c.mo41427b(aVar, sb.toString(), 1);
        Iterator it = this.mAllInterstitialSmashes.iterator();
        while (it.hasNext()) {
            C12889p smash = (C12889p) it.next();
            if (smash != null) {
                smash.mo41173a(C12913g.m41922b(description));
            }
        }
    }

    public void onInterstitialOpen() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onInterstitialAdOpened ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41179d();
        }
    }

    public void onInterstitialAdRewarded(String demandSourceId, int amount) {
    }

    public void onInterstitialClose() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onInterstitialAdClosed ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41176b();
        }
    }

    public void onInterstitialShowSuccess() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onInterstitialAdShowSucceeded ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41181e();
        }
    }

    public void onInterstitialShowFailed(String description) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onInterstitialAdShowFailed ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41177b(C12913g.m41925c("Interstitial", description));
        }
    }

    public void onInterstitialClick() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onInterstitialAdClicked ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12889p pVar = this.mActiveInterstitialSmash;
        if (pVar != null) {
            pVar.mo41178c();
        }
    }

    public void onInterstitialEventNotificationReceived(String eventName, JSONObject extData) {
        if (extData != null) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append(getProviderName());
            sb.append(" :onInterstitialEventNotificationReceived: ");
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

    public void onOfferwallInitSuccess() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onOfferwallInitSuccess ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12878j jVar = this.mOfferwallListener;
        if (jVar != null) {
            jVar.mo41256b(true);
        }
    }

    public void onOfferwallInitFail(String description) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onOfferwallInitFail ");
        c.mo41427b(aVar, sb.toString(), 1);
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.mo41254a(false, C12913g.m41919a(description));
        }
    }

    public void onOfferwallEventNotificationReceived(String eventName, JSONObject extData) {
        if (extData != null) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append(getProviderName());
            sb.append(" :onOfferwallEventNotificationReceived ");
            c.mo41427b(aVar, sb.toString(), 1);
        }
    }

    public void onOWShowSuccess(String placementId) {
        if (TextUtils.isEmpty(placementId)) {
            C12801a aVar = C12801a.ADAPTER_API;
            StringBuilder sb = new StringBuilder();
            sb.append(getProviderName());
            sb.append(":onOWShowSuccess()");
            log(aVar, sb.toString(), 1);
        } else {
            C12801a aVar2 = C12801a.ADAPTER_API;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getProviderName());
            sb2.append(":onOWShowSuccess(placementId:");
            sb2.append(placementId);
            sb2.append(")");
            log(aVar2, sb2.toString(), 1);
        }
        C12878j jVar = this.mOfferwallListener;
        if (jVar != null) {
            jVar.mo41259f();
        }
    }

    public void onOWShowFail(String desc) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onOWShowFail ");
        c.mo41427b(aVar, sb.toString(), 1);
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.mo41258e(C12913g.m41919a(desc));
        }
    }

    public void onOWGeneric(String arg0, String arg1) {
    }

    public boolean onOWAdCredited(int credits, int totalCredits, boolean totalCreditsFlag) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onOWAdCredited ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12878j jVar = this.mOfferwallListener;
        if (jVar == null || !jVar.mo41255a(credits, totalCredits, totalCreditsFlag)) {
            return false;
        }
        return true;
    }

    public void onOWAdClosed() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onOWAdClosed ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12878j jVar = this.mOfferwallListener;
        if (jVar != null) {
            jVar.mo41260g();
        }
    }

    public void onGetOWCreditsFailed(String desc) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onGetOWCreditsFailed ");
        c.mo41427b(aVar, sb.toString(), 1);
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.mo41257d(C12913g.m41919a(desc));
        }
    }

    public void onBannerInitSuccess() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onBannerInitSuccess ");
        c.mo41427b(aVar, sb.toString(), 1);
        Iterator it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            C12866d smash = (C12866d) it.next();
            if (smash != null) {
                smash.onBannerInitSuccess();
            }
        }
    }

    public void onBannerInitFailed(String description) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onBannerInitFailed ");
        c.mo41427b(aVar, sb.toString(), 1);
        Iterator it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            C12866d smash = (C12866d) it.next();
            if (smash != null) {
                smash.mo41639b(C12913g.m41923b(description, "Banner"));
            }
        }
    }

    public void onBannerClick() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onBannerAdClicked ");
        c.mo41427b(aVar, sb.toString(), 1);
        C12866d dVar = this.mActiveBannerSmash;
        if (dVar != null) {
            dVar.mo41636a();
        }
    }

    public void onBannerLoadSuccess() {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onBannerLoadSuccess ");
        c.mo41427b(aVar, sb.toString(), 1);
        Iterator it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            C12866d smash = (C12866d) it.next();
            if (smash != null) {
                C12957d dVar = this.mIsnAdView;
                if (dVar != null) {
                    LayoutParams layoutParams = new LayoutParams(dVar.getAdViewSize().mo41789b(), this.mIsnAdView.getAdViewSize().mo41788a());
                    layoutParams.gravity = 17;
                    smash.mo41637a(this.mIsnAdView, layoutParams);
                }
            }
        }
    }

    public void onBannerLoadFail(String description) {
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.INTERNAL;
        StringBuilder sb = new StringBuilder();
        sb.append(getProviderName());
        sb.append(" :onBannerLoadFail");
        c.mo41427b(aVar, sb.toString(), 1);
        Iterator it = this.mAllBannerSmashes.iterator();
        while (it.hasNext()) {
            C12866d smash = (C12866d) it.next();
            if (smash != null) {
                smash.mo41638a(C12913g.m41923b(description, "Banner"));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void addBannerListener(C12866d listener) {
        this.mAllBannerSmashes.add(listener);
    }

    /* access modifiers changed from: protected */
    public void removeBannerListener(C12866d listener) {
        this.mAllBannerSmashes.remove(listener);
    }

    /* access modifiers changed from: protected */
    public void setMediationState(C12792a state, String adUnit) {
        if (this.mSSAPublisher != null) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.INTERNAL;
            StringBuilder sb = new StringBuilder();
            sb.append(getProviderName());
            sb.append(" :setMediationState(");
            sb.append(adUnit);
            String str = " , ";
            sb.append(str);
            sb.append(getProviderName());
            sb.append(str);
            sb.append(state.mo41410e());
            sb.append(")");
            c.mo41427b(aVar, sb.toString(), 1);
            this.mSSAPublisher.mo41831a(adUnit, getProviderName(), state.mo41410e());
        }
    }

    /* access modifiers changed from: protected */
    public void setConsent(boolean consent) {
        this.mDidSetConsent = true;
        this.mConsent = consent;
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
