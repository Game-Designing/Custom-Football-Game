package com.vungle.warren;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.google.gson.C10185p;
import com.google.gson.C10188s;
import com.google.gson.C10191u;
import com.vungle.warren.DownloadStrategy.VerificationCallback;
import com.vungle.warren.download.APKDirectDownloadManager;
import com.vungle.warren.error.VungleError;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.JsonUtil;
import com.vungle.warren.model.Placement;
import com.vungle.warren.network.Downloader;
import com.vungle.warren.network.Downloader.Listener;
import com.vungle.warren.network.FetchDownloader;
import com.vungle.warren.network.VungleApiClient;
import com.vungle.warren.p267ui.VungleActivity;
import com.vungle.warren.p267ui.VungleNativeView;
import com.vungle.warren.persistence.FilePersistor;
import com.vungle.warren.persistence.GraphicDesigner;
import com.vungle.warren.presenter.AdvertisementPresenter.EventListener;
import com.vungle.warren.tasks.CleanupJob;
import com.vungle.warren.tasks.DownloadJob;
import com.vungle.warren.tasks.ReconfigJob;
import com.vungle.warren.tasks.ReconfigJob.ReconfigCall;
import com.vungle.warren.tasks.SendReportsJob;
import com.vungle.warren.tasks.VungleJobCreator;
import com.vungle.warren.utility.FileUtility;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

public class Vungle {
    private static final String COM_VUNGLE_SDK = "com.vungle.sdk";
    /* access modifiers changed from: private */
    public static final String TAG = Vungle.class.getCanonicalName();
    static final Vungle _instance = new Vungle();
    private static Handler handler = new Handler(Looper.getMainLooper());
    private static AtomicBoolean isDepInit = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public static boolean isInitialized = false;
    /* access modifiers changed from: private */
    public static AtomicBoolean isInitializing = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public String appID;
    /* access modifiers changed from: private */
    public Context context;
    private Downloader downloader;
    /* access modifiers changed from: private */
    public HeaderBiddingCallback headerBiddingCallback;
    /* access modifiers changed from: private */
    public InitCallback initCallback;
    /* access modifiers changed from: private */
    public VungleJobRunner jobRunner;
    /* access modifiers changed from: private */
    public Map<String, Boolean> loadOperations = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public Map<String, Boolean> playOperations = new ConcurrentHashMap();
    private PublisherDirectDownload publisherDirectDownload;
    /* access modifiers changed from: private */
    public boolean shouldTransmitIMEI;
    Storage storage;
    private Consent tempConsent;
    private String tempConsentVersion;
    private String userIMEI;

    public enum Consent {
        OPTED_IN,
        OPTED_OUT
    }

    interface DownloadCallback {
        void onDownloadCompleted(File file, String str);

        void onDownloadFailed(Throwable th, String str);
    }

    private Vungle() {
    }

    @Deprecated
    public static void init(Collection<String> collection, String appId, Context context2, InitCallback callback, PublisherDirectDownload publisherDirectDownload2) throws IllegalArgumentException {
        init(appId, context2, callback, publisherDirectDownload2);
    }

    public static void init(String appId, Context context2, InitCallback callback, PublisherDirectDownload publisherDirectDownload2) throws IllegalArgumentException {
        String str = "!SDK-VERSION-STRING!:com.vungle:publisher-sdk-android:6.3.24";
        if (callback == null) {
            throw new IllegalArgumentException("A valid InitCallback required to ensure API calls are being made after initialize is successful");
        } else if (context2 == null || appId == null || appId.isEmpty()) {
            callback.onError(new VungleException(6));
        } else if (!(context2 instanceof Application)) {
            callback.onError(new VungleException(7));
        } else if (isInitialized()) {
            Log.d(TAG, "init already complete");
            callback.onSuccess();
        } else if (isInitializing.getAndSet(true)) {
            Log.d(TAG, "init ongoing");
            callback.onError(new VungleException(8));
        } else {
            if (!isDepInit.getAndSet(true)) {
                GraphicDesigner designer = new GraphicDesigner(context2.getCacheDir());
                Storage storage2 = Storage.makeInstance(new FilePersistor(context2.getFilesDir()), designer);
                Vungle vungle = _instance;
                vungle.context = context2;
                vungle.appID = appId;
                vungle.downloader = new FetchDownloader(context2);
                Vungle vungle2 = _instance;
                vungle2.storage = storage2;
                vungle2.jobRunner = new VungleJobRunner(new VungleJobCreator(vungle2.storage, designer, new ReconfigCall() {
                    public void reConfigVungle() {
                        Vungle.reConfigure();
                    }
                }));
                storage2.init(1);
                VungleApiClient.init(context2, appId, designer.getCacheDirectory().getPath(), storage2);
                if (!TextUtils.isEmpty(_instance.userIMEI)) {
                    Vungle vungle3 = _instance;
                    VungleApiClient.updateIMEI(vungle3.userIMEI, vungle3.shouldTransmitIMEI);
                }
                Vungle vungle4 = _instance;
                if (vungle4.tempConsent != null && !TextUtils.isEmpty(vungle4.tempConsentVersion)) {
                    Vungle vungle5 = _instance;
                    updateConsentStatus(vungle5.tempConsent, vungle5.tempConsentVersion);
                }
                String str2 = "appId";
                Cookie appIdCookie = (Cookie) _instance.storage.load(str2, Cookie.class);
                if (appIdCookie == null) {
                    appIdCookie = new Cookie(str2);
                }
                appIdCookie.putValue(str2, appId);
                _instance.storage.save(appIdCookie);
            }
            Vungle vungle6 = _instance;
            vungle6.initCallback = callback;
            vungle6.publisherDirectDownload = publisherDirectDownload2;
            vungle6.configure(callback);
        }
    }

    static void reConfigure() {
        if (isInitialized()) {
            Vungle vungle = _instance;
            vungle.configure(vungle.initCallback);
            return;
        }
        Vungle vungle2 = _instance;
        init(vungle2.appID, vungle2.context, vungle2.initCallback, vungle2.publisherDirectDownload);
    }

    @Deprecated
    public static void init(Collection<String> collection, String appId, Context context2, InitCallback callback) throws IllegalArgumentException {
        init(appId, context2, callback, (PublisherDirectDownload) null);
    }

    public static void init(String appId, Context context2, InitCallback callback) throws IllegalArgumentException {
        init(appId, context2, callback, (PublisherDirectDownload) null);
    }

    private void configure(final InitCallback callback) {
        VungleApiClient.config(new Callback<C10191u>() {
            public void onResponse(Call<C10191u> call, Response<C10191u> response) {
                if (response == null) {
                    callback.onError(new VungleException(2));
                    Vungle.isInitializing.set(false);
                } else if (!response.isSuccessful()) {
                    long retryAfterHeaderValue = VungleApiClient.getRetryAfterHeaderValue(response);
                    if (retryAfterHeaderValue > 0) {
                        Vungle.this.jobRunner.execute(ReconfigJob.makeJobInfo(Vungle._instance.appID).setDelay(retryAfterHeaderValue));
                        callback.onError(new VungleException(14));
                        Vungle.isInitializing.set(false);
                        return;
                    }
                    callback.onError(new VungleException(3));
                    Vungle.isInitializing.set(false);
                } else {
                    if (!Vungle.this.context.getSharedPreferences(Vungle.COM_VUNGLE_SDK, 0).getBoolean("reported", false)) {
                        VungleApiClient.reportNew().enqueue(new Callback<C10191u>() {
                            public void onResponse(Call<C10191u> call, Response<C10191u> response) {
                                if (response.isSuccessful()) {
                                    Editor editor = Vungle.this.context.getSharedPreferences(Vungle.COM_VUNGLE_SDK, 0).edit();
                                    editor.putBoolean("reported", true);
                                    editor.apply();
                                    Log.d(Vungle.TAG, "Saving reported state to shared preferences");
                                }
                            }

                            public void onFailure(Call<C10191u> call, Throwable throwable) {
                            }
                        });
                    }
                    C10191u jsonObject = (C10191u) response.body();
                    C10185p placementsData = jsonObject.mo33471b("placements");
                    if (placementsData.size() == 0) {
                        callback.onError(new VungleException(0));
                        Vungle.isInitializing.set(false);
                        return;
                    }
                    Vungle.this.playOperations.clear();
                    Vungle.this.loadOperations.clear();
                    List<Placement> newPlacements = new ArrayList<>();
                    Iterator it = placementsData.iterator();
                    while (it.hasNext()) {
                        newPlacements.add(new Placement(((C10188s) it.next()).mo33445e()));
                    }
                    Vungle._instance.storage.setValidPlacements(newPlacements);
                    String str = "gdpr";
                    if (jsonObject.mo33473d(str)) {
                        String str2 = Cookie.CONSENT_COOKIE;
                        Cookie gdprConsent = (Cookie) Vungle._instance.storage.load(str2, Cookie.class);
                        if (gdprConsent == null) {
                            gdprConsent = new Cookie(str2);
                            gdprConsent.putValue("consent_status", "unknown");
                            gdprConsent.putValue("consent_source", "no_interaction");
                            gdprConsent.putValue("timestamp", Long.valueOf(0));
                        }
                        C10191u gdprJsonObject = jsonObject.mo33472c(str);
                        String str3 = "is_country_data_protected";
                        boolean isCountryDataProtected = JsonUtil.hasNonNull(gdprJsonObject, str3) && gdprJsonObject.mo33466a(str3).mo33433a();
                        String str4 = "consent_title";
                        String str5 = "";
                        String consentTitle = JsonUtil.hasNonNull(gdprJsonObject, str4) ? gdprJsonObject.mo33466a(str4).mo33439h() : str5;
                        String str6 = "consent_message";
                        String consentMessage = JsonUtil.hasNonNull(gdprJsonObject, str6) ? gdprJsonObject.mo33466a(str6).mo33439h() : str5;
                        String str7 = "consent_message_version";
                        String consentMessageVersion = JsonUtil.hasNonNull(gdprJsonObject, str7) ? gdprJsonObject.mo33466a(str7).mo33439h() : str5;
                        String str8 = "button_accept";
                        String acceptText = JsonUtil.hasNonNull(gdprJsonObject, str8) ? gdprJsonObject.mo33466a(str8).mo33439h() : str5;
                        String str9 = "button_deny";
                        String denyText = JsonUtil.hasNonNull(gdprJsonObject, str9) ? gdprJsonObject.mo33466a(str9).mo33439h() : str5;
                        C10191u uVar = gdprJsonObject;
                        gdprConsent.putValue(str3, Boolean.valueOf(isCountryDataProtected));
                        gdprConsent.putValue(str4, TextUtils.isEmpty(consentTitle) ? "Targeted Ads" : consentTitle);
                        gdprConsent.putValue(str6, TextUtils.isEmpty(consentMessage) ? "To receive more relevant ad content based on your interactions with our ads, click \"I Consent\" below. Either way, you will see the same amount of ads." : consentMessage);
                        if (!"publisher".equalsIgnoreCase(gdprConsent.getString("consent_source"))) {
                            if (!TextUtils.isEmpty(consentMessageVersion)) {
                                str5 = consentMessageVersion;
                            }
                            gdprConsent.putValue(str7, str5);
                        }
                        gdprConsent.putValue(str8, TextUtils.isEmpty(acceptText) ? "I Consent" : acceptText);
                        gdprConsent.putValue(str9, TextUtils.isEmpty(denyText) ? "I Do Not Consent" : denyText);
                        Vungle._instance.storage.save(gdprConsent);
                    }
                    String str10 = "apk_direct_download";
                    String str11 = "enabled";
                    if (jsonObject.mo33473d(str10) && jsonObject.mo33472c(str10).mo33473d(str11)) {
                        boolean isDirectDownloadEnabled = jsonObject.mo33472c(str10).mo33466a(str11).mo33433a();
                        if (isDirectDownloadEnabled) {
                            APKDirectDownloadManager.init(Vungle.this.context);
                        }
                        APKDirectDownloadManager.setDirectDownloadStatus(isDirectDownloadEnabled);
                    }
                    String str12 = "ri";
                    if (jsonObject.mo33473d(str12)) {
                        Cookie configCookie = (Cookie) Vungle._instance.storage.load(Cookie.CONFIG_COOKIE, Cookie.class);
                        if (configCookie == null) {
                            configCookie = new Cookie(Cookie.CONFIG_COOKIE);
                        }
                        configCookie.putValue("isReportIncentivizedEnabled", Boolean.valueOf(jsonObject.mo33472c(str12).mo33466a(str11).mo33433a()));
                        Vungle._instance.storage.save(configCookie);
                    }
                    if (jsonObject.mo33473d("attribution_reporting")) {
                        C10191u attributionReporting = jsonObject.mo33472c("attribution_reporting");
                        if (attributionReporting.mo33473d("should_transmit_imei")) {
                            Vungle.this.shouldTransmitIMEI = attributionReporting.mo33466a("should_transmit_imei").mo33433a();
                        } else {
                            Vungle.this.shouldTransmitIMEI = false;
                        }
                    } else {
                        Vungle.this.shouldTransmitIMEI = false;
                    }
                    if (jsonObject.mo33473d("config")) {
                        Vungle.this.jobRunner.execute(ReconfigJob.makeJobInfo(Vungle.this.appID).setDelay(jsonObject.mo33472c("config").mo33466a("refresh_time").mo33437g()));
                    }
                    Vungle.isInitialized = true;
                    callback.onSuccess();
                    Vungle.isInitializing.set(false);
                    Collection<Placement> placements = Vungle.this.storage.loadValidPlacements();
                    Vungle.this.jobRunner.execute(CleanupJob.makeJobInfo());
                    if (placements != null) {
                        for (Placement placement : placements) {
                            if (placement.isAutoCached()) {
                                Log.d(Vungle.TAG, "starting jobs for autocached advs");
                                Vungle.this.jobRunner.execute(DownloadJob.makeJobInfo(placement.getId(), true));
                            }
                        }
                    }
                    Vungle.this.jobRunner.execute(SendReportsJob.makeJobInfo());
                }
            }

            public void onFailure(Call<C10191u> call, Throwable throwable) {
                Vungle.isInitialized = false;
                Vungle.isInitializing.set(false);
                Log.e(Vungle.TAG, Log.getStackTraceString(throwable));
                if (throwable instanceof HttpException) {
                    callback.onError(new VungleException(3));
                }
                callback.onError(new VungleException(2));
            }
        });
    }

    public static boolean isInitialized() {
        if (isInitialized) {
            Storage storage2 = _instance.storage;
            if (!(storage2 == null || storage2.getValidPlacements() == null || _instance.storage.getValidPlacements().size() <= 0 || _instance.context == null)) {
                return true;
            }
        }
        return false;
    }

    public static void setIncentivizedFields(String userID, String title, String body, String keepWatching, String close) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized");
            return;
        }
        String str = Cookie.INCENTIVIZED_TEXT_COOKIE;
        Cookie incentivizedCookie = (Cookie) _instance.storage.load(str, Cookie.class);
        if (incentivizedCookie == null) {
            incentivizedCookie = new Cookie(str);
        }
        boolean changed = false;
        if (!TextUtils.isEmpty(title)) {
            changed = true;
            incentivizedCookie.putValue("title", title);
        }
        if (!TextUtils.isEmpty(body)) {
            changed = true;
            incentivizedCookie.putValue("body", body);
        }
        if (!TextUtils.isEmpty(keepWatching)) {
            changed = true;
            incentivizedCookie.putValue("continue", keepWatching);
        }
        if (!TextUtils.isEmpty(close)) {
            changed = true;
            incentivizedCookie.putValue("close", close);
        }
        if (!TextUtils.isEmpty(userID)) {
            changed = true;
            incentivizedCookie.putValue("userID", userID);
        }
        if (changed) {
            _instance.storage.save(incentivizedCookie);
        }
    }

    public static boolean canPlayAd(String id) {
        if (isInitialized()) {
            return canPlayAd(_instance.storage.findValidAdvertisementForPlacement(id));
        }
        Log.e(TAG, "Vungle is not initialized");
        return false;
    }

    static boolean canPlayAd(Advertisement advertisement) {
        boolean canPlay = false;
        if (advertisement == null) {
            return false;
        }
        if (advertisement.getState() == 1 && _instance.storage.hasValidAssets(advertisement)) {
            canPlay = true;
        }
        return canPlay;
    }

    public static void playAd(String id, AdConfig settings, PlayAdCallback listener) {
        if (!isInitialized()) {
            if (listener != null) {
                listener.onError(id, new VungleException(9));
            }
            return;
        }
        Placement placement = (Placement) _instance.storage.load(id, Placement.class);
        Exception exception = null;
        if (Boolean.TRUE.equals(_instance.playOperations.get(id)) || Boolean.TRUE.equals(_instance.loadOperations.get(id))) {
            exception = new VungleException(8);
        }
        if (placement == null) {
            exception = new VungleException(13);
        }
        if (exception != null) {
            if (listener != null) {
                listener.onError(id, exception);
            }
            return;
        }
        boolean streamingOnly = false;
        Advertisement advertisement = _instance.storage.findValidAdvertisementForPlacement(id);
        if (!canPlayAd(advertisement)) {
            streamingOnly = true;
            if (advertisement != null && advertisement.getState() == 1) {
                _instance.storage.saveAndApplyState(advertisement, id, 4);
                if (placement.isAutoCached()) {
                    _instance.jobRunner.execute(DownloadJob.makeJobInfo(placement.getId(), true));
                }
            }
            if (listener != null) {
                listener.onError(id, new VungleException(10));
            }
        } else {
            advertisement.configure(settings);
            _instance.storage.save(advertisement);
        }
        if (_instance.context != null) {
            final boolean finalStreamingOnly = streamingOnly;
            final Advertisement finalAdvertisement = advertisement;
            Call willPlayAd = VungleApiClient.willPlayAd(placement.getId(), placement.isAutoCached(), streamingOnly ? "" : advertisement.getAdToken());
            final AdConfig adConfig = settings;
            final String str = id;
            final PlayAdCallback playAdCallback = listener;
            C126643 r4 = new Callback<C10191u>() {
                public void onResponse(Call<C10191u> call, Response<C10191u> response) {
                    String str = "Error using will_play_ad!";
                    String str2 = "Vungle";
                    Advertisement advReplace = null;
                    if (response.isSuccessful()) {
                        C10191u responseBody = (C10191u) response.body();
                        String str3 = "ad";
                        if (responseBody.mo33473d(str3)) {
                            try {
                                advReplace = new Advertisement(responseBody.mo33472c(str3));
                                advReplace.configure(adConfig);
                                Vungle._instance.storage.saveAndApplyState(advReplace, str, 0);
                            } catch (IllegalArgumentException e) {
                                Log.v(str2, "Will Play Ad did not respond with a replacement. Move on.");
                            } catch (Exception e2) {
                                Log.e(str2, str, e2);
                            } catch (VungleError vungleError) {
                                if (vungleError.getErrorCode() != 6) {
                                    Log.e(str2, str, vungleError);
                                } else {
                                    Log.e(Vungle.TAG, "will_play_ad was disabled by the configuration settings. This is expected.");
                                }
                            }
                        }
                    }
                    if (!finalStreamingOnly) {
                        String str4 = str;
                        Vungle.renderAd(str4, playAdCallback, str4, finalAdvertisement);
                    } else if (advReplace == null) {
                        PlayAdCallback playAdCallback = playAdCallback;
                        if (playAdCallback != null) {
                            playAdCallback.onError(str, new VungleException(1));
                        }
                    } else {
                        String str5 = str;
                        Vungle.renderAd(str5, playAdCallback, str5, advReplace);
                    }
                }

                public void onFailure(Call<C10191u> call, Throwable throwable) {
                    if (finalStreamingOnly) {
                        PlayAdCallback playAdCallback = playAdCallback;
                        if (playAdCallback != null) {
                            playAdCallback.onError(str, new VungleException(1));
                            return;
                        }
                        return;
                    }
                    String str = str;
                    Vungle.renderAd(str, playAdCallback, str, finalAdvertisement);
                }
            };
            willPlayAd.enqueue(r4);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0020, code lost:
        if ("flexview".equals(r7.getTemplateType()) != false) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void renderAd(final java.lang.String r4, final com.vungle.warren.PlayAdCallback r5, final java.lang.String r6, final com.vungle.warren.model.Advertisement r7) {
        /*
            com.vungle.warren.Vungle r0 = _instance
            java.util.Map<java.lang.String, java.lang.Boolean> r0 = r0.playOperations
            r1 = 1
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r1)
            r0.put(r4, r2)
            com.vungle.warren.Vungle$4 r0 = new com.vungle.warren.Vungle$4
            r0.<init>(r7, r4, r5, r6)
            com.vungle.warren.p267ui.VungleActivity.setEventListener(r0)
            if (r7 == 0) goto L_0x0023
            java.lang.String r0 = r7.getTemplateType()
            java.lang.String r2 = "flexview"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = 0
        L_0x0024:
            r0 = r1
            android.content.Intent r1 = new android.content.Intent
            com.vungle.warren.Vungle r2 = _instance
            android.content.Context r2 = r2.context
            if (r0 == 0) goto L_0x0030
            java.lang.Class<com.vungle.warren.ui.VungleFlexViewActivity> r3 = com.vungle.warren.p267ui.VungleFlexViewActivity.class
            goto L_0x0032
        L_0x0030:
            java.lang.Class<com.vungle.warren.ui.VungleActivity> r3 = com.vungle.warren.p267ui.VungleActivity.class
        L_0x0032:
            r1.<init>(r2, r3)
            r2 = 268435456(0x10000000, float:2.5243549E-29)
            r1.addFlags(r2)
            java.lang.String r2 = "placement"
            r1.putExtra(r2, r4)
            com.vungle.warren.Vungle r2 = _instance
            android.content.Context r2 = r2.context
            r2.startActivity(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.Vungle.renderAd(java.lang.String, com.vungle.warren.PlayAdCallback, java.lang.String, com.vungle.warren.model.Advertisement):void");
    }

    public static void loadAd(String id, LoadAdCallback callback) {
        loadAd(id, callback, _instance.publisherDirectDownload);
    }

    public static void loadAd(final String id, final LoadAdCallback callback, final PublisherDirectDownload pubsDownloadClient) {
        if (!isInitialized()) {
            if (callback != null) {
                callback.onError(id, new VungleException(9));
            }
            return;
        }
        Placement placement = (Placement) _instance.storage.load(id, Placement.class);
        if (placement == null) {
            if (callback != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Placement ID ");
                sb.append(id);
                sb.append(" is not valid. Please check your configuration on the vungle dashboard.");
                callback.onError(id, new IllegalArgumentException(sb.toString()));
            }
        } else if (Boolean.TRUE.equals(_instance.loadOperations.get(id))) {
            if (callback != null) {
                callback.onError(id, new VungleException(8));
            }
        } else {
            final Advertisement advertisement = _instance.storage.findValidAdvertisementForPlacement(placement.getId());
            if (canPlayAd(advertisement)) {
                String str = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("found already cached valid adv, calling onAdLoad ");
                sb2.append(id);
                sb2.append(" callback ");
                Log.i(str, sb2.toString());
                if (placement.isAutoCached()) {
                    _instance.initCallback.onAutoCacheAdAvailable(id);
                }
                if (callback != null) {
                    callback.onAdLoad(id);
                }
                return;
            }
            String str2 = TAG;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("didn't find cached adv for ");
            sb3.append(id);
            sb3.append(" downloading ");
            Log.i(str2, sb3.toString());
            if (placement.getWakeupTime() > System.currentTimeMillis()) {
                String str3 = "Placement ";
                if (callback != null) {
                    callback.onError(id, new VungleException(1));
                    String str4 = TAG;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str3);
                    sb4.append(placement.getId());
                    sb4.append(" is  snoozed");
                    Log.w(str4, sb4.toString());
                }
                if (placement.isAutoCached()) {
                    String str5 = TAG;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str3);
                    sb5.append(placement.getId());
                    sb5.append(" is sleeping rescheduling it ");
                    Log.d(str5, sb5.toString());
                    _instance.jobRunner.execute(DownloadJob.makeJobInfo(placement.getId(), true).setDelay(placement.getWakeupTime() - System.currentTimeMillis()));
                }
                return;
            }
            _instance.loadOperations.put(id, Boolean.valueOf(true));
            final DownloadCallback downloadCallback = new DownloadCallback() {
                public void onDownloadCompleted(File file, String advertisementId) {
                    Advertisement advertisement;
                    String access$400 = Vungle.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("download completed ");
                    sb.append(id);
                    Log.d(access$400, sb.toString());
                    if (advertisementId == null) {
                        advertisement = null;
                    } else {
                        advertisement = (Advertisement) Vungle._instance.storage.load(advertisementId, Advertisement.class);
                    }
                    Placement placement = (Placement) Vungle._instance.storage.load(id, Placement.class);
                    if (advertisement == null || placement == null) {
                        onDownloadFailed(new IllegalStateException("Didn't find adv"), id);
                        return;
                    }
                    Vungle._instance.storage.saveAndApplyState(advertisement, id, 1);
                    Log.d("Vungle", String.format(Locale.ENGLISH, "Downloaded assets for %s to %s", new Object[]{id, file.getAbsolutePath()}));
                    FileUtility.printDirectoryTree(file);
                    Vungle._instance.loadOperations.put(id, Boolean.valueOf(false));
                    if (Vungle._instance.headerBiddingCallback != null) {
                        Vungle._instance.headerBiddingCallback.adAvailableForBidToken(id, advertisement.getBidToken());
                    }
                    if (placement.isAutoCached()) {
                        Vungle._instance.initCallback.onAutoCacheAdAvailable(id);
                    }
                    LoadAdCallback loadAdCallback = callback;
                    if (loadAdCallback != null) {
                        loadAdCallback.onAdLoad(id);
                    }
                }

                public void onDownloadFailed(Throwable throwable, String advertisementId) {
                    Advertisement advertisement;
                    if (advertisementId == null) {
                        advertisement = null;
                    } else {
                        advertisement = (Advertisement) Vungle._instance.storage.load(advertisementId, Advertisement.class);
                    }
                    Placement placement = (Placement) Vungle._instance.storage.load(id, Placement.class);
                    if (!(advertisement == null || placement == null)) {
                        Vungle._instance.storage.saveAndApplyState(advertisement, id, 4);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to download assets for ");
                    sb.append(id);
                    sb.append(". Cause:");
                    Log.e("Vungle", sb.toString(), throwable);
                    Vungle._instance.loadOperations.put(id, Boolean.valueOf(false));
                    LoadAdCallback loadAdCallback = callback;
                    if (loadAdCallback != null) {
                        loadAdCallback.onError(id, throwable);
                    }
                }
            };
            if (advertisement == null || advertisement.getState() != 0) {
                if (advertisement != null && advertisement.getState() == 1) {
                    _instance.storage.saveAndApplyState(advertisement, id, 4);
                }
                String str6 = TAG;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("No adv for placement ");
                sb6.append(placement.getId());
                sb6.append(" getting new data ");
                Log.d(str6, sb6.toString());
                Vungle vungle = _instance;
                vungle.fetchAdMetadata(id, pubsDownloadClient, downloadCallback, vungle.headerBiddingCallback);
                return;
            }
            Log.d(TAG, "Found valid adv but not ready - downloading content");
            handler.post(new Runnable() {
                public void run() {
                    Vungle._instance.downloadAdContent(id, advertisement, pubsDownloadClient, downloadCallback);
                }
            });
        }
    }

    private static void clearCache() {
        if (isInitialized()) {
            _instance.storage.clearAllData();
            Vungle vungle = _instance;
            vungle.configure(vungle.initCallback);
            return;
        }
        Log.e(TAG, "Vungle not initialized");
    }

    private void fetchAdMetadata(String id, PublisherDirectDownload pubsDownloadClient, DownloadCallback downloadCallback, HeaderBiddingCallback bidTokenCallBack) {
        Call requestAd = VungleApiClient.requestAd(id, bidTokenCallBack != null);
        final DownloadCallback downloadCallback2 = downloadCallback;
        final String str = id;
        final HeaderBiddingCallback headerBiddingCallback2 = bidTokenCallBack;
        final PublisherDirectDownload publisherDirectDownload2 = pubsDownloadClient;
        C126687 r2 = new Callback<C10191u>() {
            public void onResponse(Call<C10191u> call, Response<C10191u> response) {
                if (response == null) {
                    downloadCallback2.onDownloadFailed(new VungleException(1), null);
                } else if (!response.isSuccessful()) {
                    long retryAfterHeaderValue = VungleApiClient.getRetryAfterHeaderValue(response);
                    Placement tempPlacement = (Placement) Vungle._instance.storage.load(str, Placement.class);
                    if (retryAfterHeaderValue <= 0 || tempPlacement == null || !tempPlacement.isAutoCached()) {
                        Log.e(Vungle.TAG, "Failed to retrieve advertisement information");
                        downloadCallback2.onDownloadFailed(new VungleException(2), null);
                        return;
                    }
                    Vungle.this.jobRunner.execute(DownloadJob.makeJobInfo(str, true).setDelay(retryAfterHeaderValue));
                    downloadCallback2.onDownloadFailed(new VungleException(14), null);
                } else {
                    Placement placement = (Placement) Vungle.this.storage.load(str, Placement.class);
                    if (placement == null) {
                        Log.e(Vungle.TAG, "Placement metadata not found for requested advertisement.");
                        downloadCallback2.onDownloadFailed(new VungleException(2), null);
                        return;
                    }
                    C10191u jsonObject = (C10191u) response.body();
                    if (jsonObject != null) {
                        String str = "ads";
                        if (jsonObject.mo33473d(str) && !jsonObject.mo33466a(str).mo33448j()) {
                            C10185p ads = jsonObject.mo33471b(str);
                            if (ads == null || ads.size() == 0) {
                                downloadCallback2.onDownloadFailed(new VungleException(1), null);
                                return;
                            }
                            C10191u ad = ads.get(0).mo33445e();
                            try {
                                Advertisement advertisement = new Advertisement(ad);
                                if (headerBiddingCallback2 != null) {
                                    headerBiddingCallback2.onBidTokenAvailable(str, advertisement.getBidToken());
                                }
                                Vungle._instance.storage.saveAndApplyState(advertisement, str, 0);
                                Vungle.this.downloadAdContent(str, advertisement, publisherDirectDownload2, downloadCallback2);
                            } catch (IllegalArgumentException e) {
                                C10191u admarkup = ad.mo33472c("ad_markup");
                                String str2 = "sleep";
                                if (admarkup.mo33473d(str2)) {
                                    int sleep = admarkup.mo33466a(str2).mo33435c();
                                    placement.snooze((long) sleep);
                                    Vungle.this.storage.save(placement);
                                    if (placement.isAutoCached()) {
                                        Vungle.this.jobRunner.execute(DownloadJob.makeJobInfo(str, true).setDelay((long) (sleep * 1000)));
                                    }
                                }
                                downloadCallback2.onDownloadFailed(new VungleException(1), null);
                            }
                        }
                    }
                    downloadCallback2.onDownloadFailed(new VungleError(0), null);
                }
            }

            public void onFailure(Call<C10191u> call, Throwable throwable) {
                downloadCallback2.onDownloadFailed(throwable, null);
            }
        };
        requestAd.enqueue(r2);
    }

    /* access modifiers changed from: private */
    public void downloadAdContent(final String placementId, final Advertisement advertisement, PublisherDirectDownload pubsDownloadClient, final DownloadCallback downloadCallback) {
        DownloadStrategy downloadStrategy = null;
        if (pubsDownloadClient != null && !TextUtils.isEmpty(advertisement.getAdMarketId())) {
            downloadStrategy = new DirectDownloadStrategy(pubsDownloadClient);
        }
        if (downloadStrategy != null) {
            downloadStrategy.isApplicationAvailable(advertisement.getAdMarketId(), new VerificationCallback() {
                public void onResult(boolean result) {
                    if (result) {
                        Log.d(Vungle.TAG, "fetchAdMetadata: downloading assets ");
                        Vungle.this.downloadAdAssets(advertisement, downloadCallback, placementId);
                        return;
                    }
                    downloadCallback.onDownloadFailed(new VungleException(5), null);
                }
            });
        } else {
            downloadAdAssets(advertisement, downloadCallback, placementId);
        }
    }

    /* access modifiers changed from: private */
    public void downloadAdAssets(Advertisement advertisement, DownloadCallback downloadCallback, String placementId) {
        for (Entry<String, String> entry : advertisement.getDownloadableUrls().entrySet()) {
            if (TextUtils.isEmpty((CharSequence) entry.getKey()) || TextUtils.isEmpty((CharSequence) entry.getValue())) {
                downloadCallback.onDownloadFailed(new VungleException(11), null);
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("Aborting, Failed to download Ad assets for: ");
                sb.append(advertisement.getId());
                Log.e(str, sb.toString());
                return;
            } else if (!URLUtil.isValidUrl((String) entry.getValue())) {
                downloadCallback.onDownloadFailed(new VungleException(11), null);
                String str2 = TAG;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Aborting, Failed to download Ad assets for: ");
                sb2.append(advertisement.getId());
                Log.e(str2, sb2.toString());
                return;
            }
        }
        File destinationDir = this.storage.getAdvertisementAssetDirectory(advertisement.getId());
        final int size = advertisement.getDownloadableUrls().size();
        final Advertisement advertisement2 = advertisement;
        final DownloadCallback downloadCallback2 = downloadCallback;
        final String str3 = placementId;
        C126709 r2 = new Listener() {
            private AtomicInteger downloadsComplete = new AtomicInteger(0);

            public void onComplete(File file) {
                if (this.downloadsComplete.incrementAndGet() == size) {
                    if (advertisement2.getAdType() == 1) {
                        String access$400 = Vungle.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("saving MRAID for ");
                        sb.append(advertisement2.getId());
                        Log.d(access$400, sb.toString());
                        advertisement2.setMraidAssetDir(file);
                        Vungle._instance.storage.save(advertisement2);
                    }
                    downloadCallback2.onDownloadCompleted(file.getParentFile(), advertisement2.getId());
                }
            }

            public void onProgress(int progress, int status) {
            }

            public void onError(long id, Throwable throwable) {
                Log.e(Vungle.TAG, "Download Failed");
                Vungle._instance.storage.saveAndApplyState(advertisement2, str3, 4);
                downloadCallback2.onDownloadFailed(throwable, advertisement2.getId());
            }
        };
        try {
            for (Entry<String, String> entry2 : advertisement.getDownloadableUrls().entrySet()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(destinationDir.getPath());
                sb3.append(File.separator);
                sb3.append((String) entry2.getKey());
                File dest = new File(sb3.toString());
                if (!URLUtil.isHttpsUrl((String) entry2.getValue())) {
                    if (!URLUtil.isHttpUrl((String) entry2.getValue())) {
                        downloadCallback.onDownloadFailed(new VungleError(10), advertisement.getId());
                    }
                }
                this.downloader.download((String) entry2.getValue(), dest, r2);
            }
        } catch (IOException e) {
            downloadCallback.onDownloadFailed(new VungleError(8), advertisement.getId());
            Log.e(TAG, Log.getStackTraceString(e));
        } catch (IllegalStateException e2) {
            downloadCallback.onDownloadFailed(new VungleError(8), advertisement.getId());
            Log.e(TAG, Log.getStackTraceString(e2));
        }
    }

    public static VungleNativeAd getNativeAd(String placementId, PlayAdCallback playAdCallback) {
        return getNativeAd(placementId, playAdCallback, null);
    }

    public static VungleNativeAd getNativeAd(final String placementId, final PlayAdCallback playAdCallback, PublisherDirectDownload pubsDownloadClient) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, returned VungleNativeAd = null");
            return null;
        }
        Placement placement = (Placement) _instance.storage.load(placementId, Placement.class);
        if (placement == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("No placement for ID ");
            sb.append(placementId);
            sb.append(" found. Please use a valid placement ID");
            playAdCallback.onError(placementId, new Throwable(sb.toString()));
            return null;
        }
        final Advertisement advertisement = _instance.storage.findValidAdvertisementForPlacement(placementId);
        if (advertisement == null) {
            Log.e(TAG, "No Advertisement for ID");
            return null;
        } else if (!canPlayAd(advertisement)) {
            if (advertisement != null && advertisement.getState() == 1) {
                _instance.storage.saveAndApplyState(advertisement, placementId, 4);
                if (placement.isAutoCached()) {
                    _instance.jobRunner.execute(DownloadJob.makeJobInfo(placement.getId(), true));
                }
            }
            return null;
        } else if (Boolean.TRUE.equals(_instance.playOperations.get(placementId)) || Boolean.TRUE.equals(_instance.loadOperations.get(placementId))) {
            playAdCallback.onError(placementId, new VungleException(8));
            return null;
        } else if (advertisement.getAdType() != 1) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(placementId);
            sb2.append(" is not an MRAID compatible placement. Please use a valid placement ID");
            playAdCallback.onError(placementId, new Throwable(sb2.toString()));
            return null;
        } else {
            DirectDownloadAdapter directDownloadAdapter = null;
            if (pubsDownloadClient != null) {
                directDownloadAdapter = new DirectDownloadAdapter(pubsDownloadClient, advertisement.getAdMarketId());
            }
            _instance.playOperations.put(placementId, Boolean.valueOf(true));
            return new VungleNativeView(_instance.context.getApplicationContext(), placementId, directDownloadAdapter, new EventListener() {
                int percentViewed = -1;
                boolean succesfulView = false;

                public void onNext(String s, String value) {
                    boolean z = false;
                    if (s.equals("start")) {
                        Vungle._instance.storage.saveAndApplyState(advertisement, placementId, 2);
                        PlayAdCallback playAdCallback = playAdCallback;
                        if (playAdCallback != null) {
                            playAdCallback.onAdStart(placementId);
                        }
                        this.percentViewed = 0;
                        Placement placement = (Placement) Vungle._instance.storage.load(placementId, Placement.class);
                        if (placement != null && placement.isAutoCached()) {
                            Vungle._instance.jobRunner.execute(DownloadJob.makeJobInfo(placementId, true));
                        }
                    } else if (s.equals("end")) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Cleaning up metadata and assets for placement ");
                        sb.append(placementId);
                        sb.append(" and advertisement ");
                        sb.append(advertisement.getId());
                        Log.d("Vungle", sb.toString());
                        Vungle._instance.storage.saveAndApplyState(advertisement, placementId, 3);
                        Vungle._instance.jobRunner.execute(SendReportsJob.makeJobInfo());
                        Vungle._instance.playOperations.put(placementId, Boolean.valueOf(false));
                        PlayAdCallback playAdCallback2 = playAdCallback;
                        if (playAdCallback2 != null) {
                            String str = placementId;
                            boolean z2 = this.succesfulView || this.percentViewed >= 80;
                            if (value != null && value.equals("isCTAClicked")) {
                                z = true;
                            }
                            playAdCallback2.onAdEnd(str, z2, z);
                        }
                    } else if (s.equals("successfulView")) {
                        this.succesfulView = true;
                    } else if (s.startsWith("percentViewed")) {
                        String[] tokens = s.split(":");
                        if (tokens.length == 2) {
                            this.percentViewed = Integer.parseInt(tokens[1]);
                        }
                    }
                }

                public void onError(Throwable throwable) {
                    Vungle._instance.playOperations.put(placementId, Boolean.valueOf(false));
                    Vungle._instance.storage.saveAndApplyState(advertisement, placementId, 4);
                    PlayAdCallback playAdCallback = playAdCallback;
                    if (playAdCallback != null) {
                        playAdCallback.onError(placementId, throwable);
                    }
                }
            });
        }
    }

    public static Collection<String> getValidPlacements() {
        if (isInitialized()) {
            return _instance.storage.getValidPlacements();
        }
        Log.e(TAG, "Vungle is not initialized return empty placemetns list");
        return Collections.emptyList();
    }

    static void handleApkDirectDownloads(Context context2) {
        APKDirectDownloadManager.handleDownload(context2);
    }

    public static void updateConsentStatus(Consent status, String consentMessageVersion) {
        if (!isDepInit.get()) {
            Vungle vungle = _instance;
            vungle.tempConsent = status;
            vungle.tempConsentVersion = consentMessageVersion;
            return;
        }
        String str = Cookie.CONSENT_COOKIE;
        Cookie gdprConsent = (Cookie) _instance.storage.load(str, Cookie.class);
        if (gdprConsent == null) {
            gdprConsent = new Cookie(str);
        }
        gdprConsent.putValue("consent_status", status == Consent.OPTED_IN ? "opted_in" : "opted_out");
        gdprConsent.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
        gdprConsent.putValue("consent_source", "publisher");
        gdprConsent.putValue("consent_message_version", consentMessageVersion == null ? "" : consentMessageVersion);
        _instance.storage.save(gdprConsent);
        Vungle vungle2 = _instance;
        vungle2.tempConsent = null;
        vungle2.tempConsentVersion = null;
    }

    public static Consent getConsentStatus() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, consent is null");
            return null;
        }
        Cookie gdprConsent = (Cookie) _instance.storage.load(Cookie.CONSENT_COOKIE, Cookie.class);
        if (gdprConsent == null) {
            return null;
        }
        return "opted_in".equals(gdprConsent.getString("consent_status")) ? Consent.OPTED_IN : Consent.OPTED_OUT;
    }

    public static String getConsentMessageVersion() {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, please wait initialize or wait until Vungle is intialized to get Consent Message Version");
            return null;
        }
        Cookie gdprConsent = (Cookie) _instance.storage.load(Cookie.CONSENT_COOKIE, Cookie.class);
        if (gdprConsent == null) {
            return null;
        }
        return gdprConsent.getString("consent_message_version");
    }

    public static boolean closeFlexViewAd(String placementReferenceId) {
        if (!isInitialized()) {
            Log.e(TAG, "Vungle is not initialized, can't close flex view ad");
            return false;
        }
        Intent broadcast = new Intent("AdvertisementBus");
        broadcast.putExtra(VungleActivity.PLACEMENT_EXTRA, placementReferenceId);
        broadcast.putExtra("command", "closeFlex");
        _instance.context.sendBroadcast(broadcast);
        return true;
    }

    public static void setUserLegacyID(String legacyId) {
        if (isInitialized() || isInitializing.get()) {
            VungleApiClient.updateIMEI(legacyId, _instance.shouldTransmitIMEI);
        } else {
            _instance.userIMEI = legacyId;
        }
    }

    public static void setHeaderBiddingCallback(HeaderBiddingCallback headerBiddingCallback2) {
        _instance.headerBiddingCallback = headerBiddingCallback2;
    }
}
