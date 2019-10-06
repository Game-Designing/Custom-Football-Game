package com.vungle.warren.presenter;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.WebViewClient;
import android.widget.VideoView;
import com.google.gson.C10188s;
import com.google.gson.C10191u;
import com.google.gson.C10192v;
import com.moat.analytics.mobile.vng.MoatAdEvent;
import com.moat.analytics.mobile.vng.MoatAdEventType;
import com.moat.analytics.mobile.vng.MoatFactory;
import com.moat.analytics.mobile.vng.MoatOptions;
import com.moat.analytics.mobile.vng.ReactiveVideoTracker;
import com.moat.analytics.mobile.vng.ReactiveVideoTrackerPlugin;
import com.vungle.warren.DirectDownloadAdapter;
import com.vungle.warren.Storage;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.model.Advertisement.Checkpoint;
import com.vungle.warren.model.Cookie;
import com.vungle.warren.model.Placement;
import com.vungle.warren.model.Report;
import com.vungle.warren.network.VungleApiClient;
import com.vungle.warren.p267ui.AdView;
import com.vungle.warren.p267ui.VungleWebClient;
import com.vungle.warren.presenter.AdvertisementPresenter.EventListener;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment.BundleCons;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocalAdPresenter implements AdvertisementPresenter {
    private static final String EXTRA_INCENTIVIZED_SENT = "incentivized_sent";
    private static final String EXTRA_IN_POST = "in_post_roll";
    private static final String EXTRA_REPORT = "saved_report";
    private static final String TAG = "LocalAdPresenter";
    private HashMap<String, String> adIds;
    /* access modifiers changed from: private */
    public AdView adView;
    /* access modifiers changed from: private */
    public Advertisement advertisement;
    private File assetDir;
    private EventListener bus;
    private Checkpoint checkpoint;
    private byte checkpointReached;
    private String dialogBody = "If you exit now, you will not get your reward";
    private String dialogClose = "Close";
    private String dialogContinue = "Continue";
    private String dialogTitle = "Are you sure?";
    private boolean directDownloadApkEnabled;
    private int duration;
    private Handler handler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public boolean inPost;
    private AtomicBoolean isDestroying = new AtomicBoolean(false);
    private Queue<Pair<Integer, MoatAdEventType>> moatQuartileTrackers;
    private boolean muted;
    private Placement placement;
    private Report report;
    private AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public Storage storage;
    /* access modifiers changed from: private */
    public boolean userExitEnabled;
    private String userID;
    private ReactiveVideoTracker videoTracker;
    private VideoView videoView;
    private VungleWebClient webClient;

    public LocalAdPresenter(Advertisement advertisement2, Placement placement2, Storage storage2, File assetDir2, String userId) {
        this.advertisement = advertisement2;
        this.placement = placement2;
        this.storage = storage2;
        this.userID = userId;
        this.assetDir = assetDir2;
    }

    public void setEventListener(EventListener listener) {
        this.bus = listener;
    }

    public void setDirectDownloadAdapter(DirectDownloadAdapter directDownloadAdapter) {
    }

    public void reportError(String error) {
        this.report.recordError(error);
        this.storage.save(this.report);
        if (this.inPost || !this.advertisement.hasPostroll()) {
            EventListener eventListener = this.bus;
            if (eventListener != null) {
                eventListener.onError(new Throwable(error));
            }
            this.adView.close();
            return;
        }
        playPost();
    }

    public void reportAction(String action, String value) {
        if (action.equals("videoLength")) {
            this.duration = Integer.parseInt(value);
            this.report.setAdDuration(this.duration);
            this.storage.save(this.report);
            return;
        }
        String str = "mute";
        if (action.equals(str)) {
            for (String url : this.advertisement.getTpatUrls(str)) {
                VungleApiClient.pingTPAT(url);
            }
        }
        String str2 = "unmute";
        if (action.equals(str2)) {
            for (String url2 : this.advertisement.getTpatUrls(str2)) {
                VungleApiClient.pingTPAT(url2);
            }
        }
        String str3 = "video_close";
        if (action.equals(str3)) {
            for (String url3 : this.advertisement.getTpatUrls(str3)) {
                VungleApiClient.pingTPAT(url3);
            }
        }
        this.report.recordAction(action, value, System.currentTimeMillis());
        this.storage.save(this.report);
    }

    public WebViewClient getWebViewClient() {
        if (this.webClient == null) {
            this.webClient = new VungleWebClient(this.advertisement, this.placement, null);
        }
        return this.webClient;
    }

    public void notifyPropertiesChanged() {
    }

    public void initializeViewabilityTracker(int videoDuration, VideoView videoView2) {
        if (this.advertisement.getMoatEnabled() && VungleApiClient.getMoatEnabled() && this.videoTracker != null && this.adIds != null) {
            this.videoView = videoView2;
            Log.d(TAG, "initializeViewabilityTracker");
            this.videoTracker.trackVideoAd(this.adIds, Integer.valueOf(videoDuration), videoView2);
        }
    }

    public void stopViewabilityTracker() {
        if (this.advertisement.getMoatEnabled() && VungleApiClient.getMoatEnabled() && this.videoTracker != null) {
            VideoView videoView2 = this.videoView;
            int currentVideoPosition = videoView2 != null ? videoView2.getCurrentPosition() : 0;
            StringBuilder sb = new StringBuilder();
            sb.append("stopViewabilityTracker: ");
            sb.append(currentVideoPosition);
            String sb2 = sb.toString();
            String str = TAG;
            Log.d(str, sb2);
            this.videoTracker.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_STOPPED, Integer.valueOf(currentVideoPosition)));
            this.videoTracker.stopTracking();
            Log.d(str, "stopViewabilityTracker: Success !!");
        }
    }

    public void attach(AdView adView2) {
        boolean z = false;
        this.isDestroying.set(false);
        this.adView = adView2;
        int settings = this.advertisement.getAdConfig().getSettings();
        if (settings > 0) {
            this.muted = (settings & 1) == 1;
            this.userExitEnabled = (settings & 2) == 2;
            if ((settings & 32) == 32) {
                z = true;
            }
            this.directDownloadApkEnabled = z;
        }
        int requestedOrientation = -1;
        if ((this.advertisement.getAdConfig().getSettings() & 16) != 16) {
            int orientation = this.advertisement.getOrientation();
            if (orientation == 0) {
                requestedOrientation = 1;
            } else if (orientation == 1) {
                requestedOrientation = 0;
            } else if (orientation == 2) {
                requestedOrientation = 4;
            }
        } else {
            requestedOrientation = 4;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("requested orientation ");
        sb.append(requestedOrientation);
        Log.d(TAG, sb.toString());
        adView2.setOrientation(requestedOrientation);
    }

    /* access modifiers changed from: private */
    public void playPost() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.assetDir.getPath());
        sb.append(File.separator);
        sb.append(Advertisement.POSTROLL_UNZIP);
        File post = new File(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(post.getPath());
        sb2.append(File.separator);
        sb2.append("index.html");
        File indexHtml = new File(sb2.toString());
        if (!indexHtml.exists()) {
            EventListener eventListener = this.bus;
            if (eventListener != null) {
                eventListener.onError(new VungleException(10));
            }
            closeAndReport();
            return;
        }
        AdView adView2 = this.adView;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("file://");
        sb3.append(indexHtml.getPath());
        adView2.showWebsite(sb3.toString());
        for (String url : this.advertisement.getTpatUrls("postroll_view")) {
            VungleApiClient.pingTPAT(url);
        }
        this.inPost = true;
    }

    public void prepare(Bundle savedState) {
        String str = BundleCons.APP_ID;
        EventListener eventListener = this.bus;
        String str2 = null;
        if (eventListener != null) {
            eventListener.onNext("start", null);
        }
        Cookie incentivizedCookie = (Cookie) this.storage.load(Cookie.INCENTIVIZED_TEXT_COOKIE, Cookie.class);
        Report report2 = new Report(this.advertisement, this.placement, System.currentTimeMillis(), incentivizedCookie == null ? null : incentivizedCookie.getString("userID"));
        this.report = report2;
        if (this.advertisement.getCheckpoints() != null && !this.advertisement.getCheckpoints().isEmpty()) {
            this.checkpoint = (Checkpoint) this.advertisement.getCheckpoints().get(0);
        }
        if (this.advertisement.getMoatEnabled() && VungleApiClient.getMoatEnabled()) {
            MoatOptions options = new MoatOptions();
            options.disableAdIdCollection = true;
            options.disableLocationServices = true;
            options.loggingEnabled = false;
            this.moatQuartileTrackers = new LinkedList();
            this.moatQuartileTrackers.add(new Pair(Integer.valueOf(0), MoatAdEventType.AD_EVT_START));
            this.moatQuartileTrackers.add(new Pair(Integer.valueOf(25), MoatAdEventType.AD_EVT_FIRST_QUARTILE));
            this.moatQuartileTrackers.add(new Pair(Integer.valueOf(50), MoatAdEventType.AD_EVT_MID_POINT));
            this.moatQuartileTrackers.add(new Pair(Integer.valueOf(75), MoatAdEventType.AD_EVT_THIRD_QUARTILE));
            this.adIds = new HashMap<>();
            if (!this.advertisement.getMoatVastExtra().isEmpty()) {
                this.adIds.put("zMoatVASTIDs", this.advertisement.getMoatVastExtra());
            }
            String advertiserAppId = this.advertisement.getAppID();
            String rawAppIdJson = this.advertisement.getAppID();
            if (rawAppIdJson != null) {
                try {
                    JSONObject appIdJson = new JSONObject(rawAppIdJson.substring(3));
                    if (!appIdJson.isNull(str)) {
                        str2 = appIdJson.optString(str, null);
                    }
                    advertiserAppId = str2;
                } catch (JSONException e) {
                    Log.e(TAG, "JsonException : ", e);
                }
            }
            String campaignId = null;
            String creativeId = null;
            String campaign = this.advertisement.getCampaign();
            int firstBar = campaign.indexOf(Opcodes.IUSHR);
            if (firstBar != -1) {
                int secondBar = campaign.indexOf(Opcodes.IUSHR, firstBar + 1);
                campaignId = campaign.substring(0, firstBar);
                if (secondBar != -1) {
                    creativeId = campaign.substring(firstBar + 1, secondBar);
                }
            }
            this.adIds.put("level1", (advertiserAppId == null || advertiserAppId.isEmpty()) ? this.advertisement.getId() : advertiserAppId);
            this.adIds.put("level2", (campaignId == null || campaignId.isEmpty()) ? this.advertisement.getId() : campaignId);
            this.adIds.put("level3", (creativeId == null || creativeId.isEmpty()) ? this.advertisement.getId() : creativeId);
            this.adIds.put("level4", this.placement.getId());
            String str3 = "appId";
            Cookie appIdCookie = (Cookie) this.storage.load(str3, Cookie.class);
            if (appIdCookie != null && !TextUtils.isEmpty(appIdCookie.getString(str3))) {
                this.adIds.put("slicer1", appIdCookie.getString(str3));
            }
            this.videoTracker = (ReactiveVideoTracker) MoatFactory.create().createCustomTracker(new ReactiveVideoTrackerPlugin("vunglenativevideo893259554489"));
        }
        this.adView.updateWindow(false);
        if (this.advertisement.isCtaOverlayEnabled()) {
            if (this.advertisement.isCtaShowOnClick()) {
                this.adView.showCTAOverlay(this.advertisement.isCtaShowOnClick(), true, this.advertisement.getCtaClickArea());
            } else {
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        LocalAdPresenter.this.adView.showCTAOverlay(LocalAdPresenter.this.advertisement.isCtaShowOnClick(), false, LocalAdPresenter.this.advertisement.getCtaClickArea());
                    }
                }, (long) this.advertisement.getCtaTimeShow());
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        LocalAdPresenter.this.adView.showCTAOverlay(LocalAdPresenter.this.advertisement.isCtaShowOnClick(), true, LocalAdPresenter.this.advertisement.getCtaClickArea());
                    }
                }, (long) this.advertisement.getCtaTimeEnabled());
            }
        }
        Cookie gdprConsent = (Cookie) this.storage.load(Cookie.CONSENT_COOKIE, Cookie.class);
        if (gdprConsent != null && gdprConsent.getBoolean("is_country_data_protected").booleanValue()) {
            String str4 = "consent_status";
            if ("unknown".equals(gdprConsent.getString(str4))) {
                final Cookie finalGdpr = gdprConsent;
                OnClickListener listener = new OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String consented = "opted_out_by_timeout";
                        if (i == -2) {
                            consented = "opted_out";
                        } else if (i == -1) {
                            consented = "opted_in";
                        }
                        finalGdpr.putValue("consent_status", consented);
                        finalGdpr.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                        finalGdpr.putValue("consent_source", "vungle_modal");
                        LocalAdPresenter.this.storage.save(finalGdpr);
                        LocalAdPresenter.this.play();
                    }
                };
                gdprConsent.putValue(str4, "opted_out_by_timeout");
                finalGdpr.putValue("timestamp", Long.valueOf(System.currentTimeMillis() / 1000));
                finalGdpr.putValue("consent_source", "vungle_modal");
                this.storage.save(finalGdpr);
                this.adView.showDialog(gdprConsent.getString("consent_title"), gdprConsent.getString("consent_message"), gdprConsent.getString("button_accept"), gdprConsent.getString("button_deny"), listener);
                return;
            }
        }
        play();
    }

    public boolean handleExit(String flexViewCloseApiPlacementID) {
        if (this.inPost) {
            closeAndReport();
            return true;
        } else if (!this.userExitEnabled) {
            return false;
        } else {
            if (this.placement.isIncentivized()) {
                Cookie incentivizedText = (Cookie) this.storage.load(Cookie.INCENTIVIZED_TEXT_COOKIE, Cookie.class);
                String titleText = this.dialogTitle;
                String bodyText = this.dialogBody;
                String continueText = this.dialogContinue;
                String closeText = this.dialogClose;
                if (incentivizedText != null) {
                    String str = "title";
                    titleText = incentivizedText.getString(str) == null ? this.dialogTitle : incentivizedText.getString(str);
                    String str2 = "body";
                    bodyText = incentivizedText.getString(str2) == null ? this.dialogBody : incentivizedText.getString(str2);
                    String str3 = "continue";
                    continueText = incentivizedText.getString(str3) == null ? this.dialogContinue : incentivizedText.getString(str3);
                    String str4 = "close";
                    closeText = incentivizedText.getString(str4) == null ? this.dialogClose : incentivizedText.getString(str4);
                }
                this.adView.showDialog(titleText, bodyText, continueText, closeText, new OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == -2) {
                            LocalAdPresenter.this.reportAction("video_close", null);
                            if (LocalAdPresenter.this.advertisement.hasPostroll()) {
                                LocalAdPresenter.this.playPost();
                            } else {
                                LocalAdPresenter.this.closeAndReport();
                            }
                        }
                    }
                });
                return false;
            }
            reportAction("video_close", null);
            if (this.advertisement.hasPostroll()) {
                playPost();
                return false;
            }
            closeAndReport();
            return true;
        }
    }

    private boolean isWebPageBlank() {
        String url = this.adView.getWebsiteUrl();
        return TextUtils.isEmpty(url) || "about:blank".equalsIgnoreCase(url);
    }

    public void play() {
        if (!this.inPost) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.assetDir.getPath());
            sb.append(File.separator);
            sb.append(Advertisement.KEY_VIDEO);
            this.adView.playVideo(Uri.fromFile(new File(sb.toString())), this.muted);
            int delayInMillis = this.advertisement.getShowCloseDelay(this.placement.isIncentivized());
            if (delayInMillis > 0) {
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        LocalAdPresenter.this.userExitEnabled = true;
                        if (!LocalAdPresenter.this.inPost) {
                            LocalAdPresenter.this.adView.showCloseButton();
                        }
                    }
                }, (long) delayInMillis);
                return;
            }
            this.userExitEnabled = true;
            this.adView.showCloseButton();
        } else if (isWebPageBlank()) {
            playPost();
        }
    }

    public void stop(boolean isChangingConfigurations, boolean isFinishing) {
        if (isChangingConfigurations || !isFinishing) {
            if (this.inPost || isFinishing) {
                this.adView.showWebsite("about:blank");
            }
        } else if (!this.isDestroying.getAndSet(true)) {
            String str = null;
            reportAction("close", null);
            this.handler.removeCallbacksAndMessages(null);
            EventListener eventListener = this.bus;
            if (eventListener != null) {
                if (this.report.isCTAClicked()) {
                    str = "isCTAClicked";
                }
                eventListener.onNext("end", str);
            }
            this.adView.close();
        }
    }

    public void setAdVisibility(boolean isViewable) {
    }

    public void reportMute(boolean muted2) {
        if (muted2) {
            if (this.advertisement.getMoatEnabled() && VungleApiClient.getMoatEnabled()) {
                this.videoTracker.setPlayerVolume(MoatAdEvent.VOLUME_UNMUTED);
            }
        } else if (this.advertisement.getMoatEnabled() && VungleApiClient.getMoatEnabled()) {
            this.videoTracker.setPlayerVolume(MoatAdEvent.VOLUME_MUTED);
        }
    }

    public void onProgressUpdate(int progress) {
        EventListener eventListener = this.bus;
        if (eventListener != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("percentViewed:");
            sb.append(progress);
            eventListener.onNext(sb.toString(), null);
        }
        List<Checkpoint> checkpoints = this.advertisement.getCheckpoints();
        if (progress == 100) {
            int checkPointIndex = checkpoints.size() - 1;
            if (checkPointIndex > 0) {
                Checkpoint checkpoint2 = (Checkpoint) checkpoints.get(checkPointIndex);
                if (checkpoint2.getPercentage() == 100) {
                    for (String url : checkpoint2.getUrls()) {
                        VungleApiClient.pingTPAT(url);
                    }
                }
            }
            if (this.advertisement.getMoatEnabled() && VungleApiClient.getMoatEnabled()) {
                VideoView videoView2 = this.videoView;
                if (videoView2 != null) {
                    this.videoTracker.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE, Integer.valueOf(videoView2.getCurrentPosition())));
                }
                this.videoTracker.stopTracking();
            }
            if (this.advertisement.hasPostroll()) {
                playPost();
            } else {
                closeAndReport();
            }
        }
        this.report.recordProgress((int) (((float) this.duration) * (((float) progress) / 100.0f)));
        this.storage.save(this.report);
        Checkpoint checkpoint3 = this.checkpoint;
        if (checkpoint3 != null && progress > checkpoint3.getPercentage()) {
            for (String url2 : this.checkpoint.getUrls()) {
                VungleApiClient.pingTPAT(url2);
            }
            this.checkpoint = null;
            if (this.checkpointReached < checkpoints.size() - 1) {
                byte b = (byte) (this.checkpointReached + 1);
                this.checkpointReached = b;
                this.checkpoint = (Checkpoint) checkpoints.get(b);
            }
        }
        if (this.advertisement.getMoatEnabled() && VungleApiClient.getMoatEnabled() && !this.moatQuartileTrackers.isEmpty() && progress >= ((Integer) ((Pair) this.moatQuartileTrackers.peek()).first).intValue()) {
            this.videoTracker.dispatchEvent(new MoatAdEvent((MoatAdEventType) ((Pair) this.moatQuartileTrackers.poll()).second, Integer.valueOf(progress)));
        }
        Cookie configCookie = (Cookie) this.storage.load(Cookie.CONFIG_COOKIE, Cookie.class);
        if (this.placement.isIncentivized() && progress > 75 && configCookie != null && configCookie.getBoolean("isReportIncentivizedEnabled").booleanValue() && !this.sendReportIncentivized.getAndSet(true)) {
            C10191u body = new C10191u();
            body.mo33467a("placement_reference_id", (C10188s) new C10192v(this.placement.getId()));
            body.mo33467a(BundleCons.APP_ID, (C10188s) new C10192v(this.advertisement.getAppID()));
            body.mo33467a("adStartTime", (C10188s) new C10192v((Number) Long.valueOf(this.report.getAdStartTime())));
            body.mo33467a("user", (C10188s) new C10192v(this.report.getUserID()));
            VungleApiClient.m41060ri(body).enqueue(new Callback<C10191u>() {
                public void onResponse(Call<C10191u> call, Response<C10191u> response) {
                    Log.d(LocalAdPresenter.TAG, "send RI success");
                }

                public void onFailure(Call<C10191u> call, Throwable t) {
                    Log.d(LocalAdPresenter.TAG, "send RI Failure");
                }
            });
        }
    }

    public void generateSaveState(Bundle savedState) {
        if (savedState != null) {
            this.storage.save(this.report);
            savedState.putString(EXTRA_REPORT, this.report.getId());
            savedState.putBoolean(EXTRA_INCENTIVIZED_SENT, this.sendReportIncentivized.get());
            savedState.putBoolean(EXTRA_IN_POST, this.inPost);
        }
    }

    public void restoreFromSave(Bundle savedState) {
        if (savedState != null) {
            if (savedState.getBoolean(EXTRA_INCENTIVIZED_SENT, false)) {
                this.sendReportIncentivized.set(true);
            }
            String reportId = savedState.getString(EXTRA_REPORT);
            this.report = TextUtils.isEmpty(reportId) ? null : (Report) this.storage.load(reportId, Report.class);
            if (this.report == null) {
                this.adView.close();
            } else {
                this.inPost = savedState.getBoolean(EXTRA_IN_POST, false);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleAction(java.lang.String r9) {
        /*
            r8 = this;
            int r0 = r9.hashCode()
            r1 = -314498168(0xffffffffed412388, float:-3.7358476E27)
            java.lang.String r2 = "download"
            r3 = 2
            r4 = 0
            r5 = 1
            if (r0 == r1) goto L_0x002b
            r1 = 94756344(0x5a5ddf8, float:1.5598064E-35)
            if (r0 == r1) goto L_0x0021
            r1 = 1427818632(0x551ac888, float:1.06366291E13)
            if (r0 == r1) goto L_0x0019
        L_0x0018:
            goto L_0x0035
        L_0x0019:
            boolean r0 = r9.equals(r2)
            if (r0 == 0) goto L_0x0018
            r0 = 1
            goto L_0x0036
        L_0x0021:
            java.lang.String r0 = "close"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0018
            r0 = 0
            goto L_0x0036
        L_0x002b:
            java.lang.String r0 = "privacy"
            boolean r0 = r9.equals(r0)
            if (r0 == 0) goto L_0x0018
            r0 = 2
            goto L_0x0036
        L_0x0035:
            r0 = -1
        L_0x0036:
            if (r0 == 0) goto L_0x00cf
            if (r0 == r5) goto L_0x0055
            if (r0 != r3) goto L_0x003e
            goto L_0x00d3
        L_0x003e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown action "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0055:
            r0 = 0
            com.vungle.warren.model.Advertisement r1 = r8.advertisement     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            java.lang.String r3 = "postroll_click"
            java.lang.String[] r1 = r1.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            int r3 = r1.length     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            r6 = 0
        L_0x0060:
            if (r6 >= r3) goto L_0x006a
            r7 = r1[r6]     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            com.vungle.warren.network.VungleApiClient.pingTPAT(r7)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            int r6 = r6 + 1
            goto L_0x0060
        L_0x006a:
            com.vungle.warren.model.Advertisement r1 = r8.advertisement     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            java.lang.String r3 = "click_url"
            java.lang.String[] r1 = r1.getTpatUrls(r3)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            int r3 = r1.length     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            r6 = 0
        L_0x0074:
            if (r6 >= r3) goto L_0x007e
            r7 = r1[r6]     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            com.vungle.warren.network.VungleApiClient.pingTPAT(r7)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            int r6 = r6 + 1
            goto L_0x0074
        L_0x007e:
            r8.reportAction(r2, r0)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            r8.closeAndReport()     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            com.vungle.warren.model.Advertisement r1 = r8.advertisement     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            java.lang.String r1 = r1.getCTAURL(r4)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            com.vungle.warren.model.Advertisement r2 = r8.advertisement     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            java.lang.String r2 = r2.getCTAURL(r5)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            if (r3 != 0) goto L_0x0099
            com.vungle.warren.network.VungleApiClient.pingTPAT(r2)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
        L_0x0099:
            boolean r3 = r8.directDownloadApkEnabled     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            com.vungle.warren.model.Advertisement r5 = r8.advertisement     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            boolean r5 = r5.isRequiresNonMarketInstall()     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            boolean r3 = com.vungle.warren.download.APKDirectDownloadManager.isDirectDownloadEnabled(r3, r5)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            if (r3 == 0) goto L_0x00ab
            com.vungle.warren.download.APKDirectDownloadManager.download(r1)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            goto L_0x00c2
        L_0x00ab:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            java.lang.String r5 = "android.intent.action.VIEW"
            r3.<init>(r5)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            android.net.Uri r5 = android.net.Uri.parse(r1)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            r3.setData(r5)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            com.vungle.warren.ui.AdView r5 = r8.adView     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            java.lang.String r4 = r3.toUri(r4)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
            r5.open(r4)     // Catch:{ ActivityNotFoundException -> 0x00c3 }
        L_0x00c2:
            goto L_0x00d3
        L_0x00c3:
            r1 = move-exception
            android.os.Handler r2 = r8.handler
            r2.removeCallbacksAndMessages(r0)
            com.vungle.warren.ui.AdView r0 = r8.adView
            r0.close()
            goto L_0x00d3
        L_0x00cf:
            r8.closeAndReport()
        L_0x00d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.warren.presenter.LocalAdPresenter.handleAction(java.lang.String):void");
    }

    /* access modifiers changed from: private */
    public void closeAndReport() {
        reportAction("close", null);
        this.handler.removeCallbacksAndMessages(null);
        this.adView.close();
    }
}
