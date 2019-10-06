package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.DataKeys;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.WebViewCacheService.Config;
import com.mopub.mraid.MraidBridge.MraidWebView;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;
import com.mopub.mraid.RewardedMraidController;

public class RewardedMraidActivity extends MraidActivity {
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RewardedMraidController f34921g;

    /* renamed from: h */
    private MraidWebViewDebugListener f34922h;

    public static void preRenderHtml(Interstitial mraidInterstitial, Context context, CustomEventInterstitialListener customEventInterstitialListener, Long broadcastIdentifier, AdReport adReport, int rewardedDuration) {
        Preconditions.checkNotNull(mraidInterstitial);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(customEventInterstitialListener);
        Preconditions.checkNotNull(broadcastIdentifier);
        String a = C11459v.m37903a(adReport);
        Context context2 = context;
        MraidWebView mraidWebView = new MraidWebView(context);
        RewardedMraidController rewardedMraidController = new RewardedMraidController(context, adReport, PlacementType.INTERSTITIAL, rewardedDuration, broadcastIdentifier.longValue());
        MraidActivity.m37506a(mraidInterstitial, customEventInterstitialListener, a, mraidWebView, broadcastIdentifier, rewardedMraidController);
    }

    public static void start(Context context, AdReport adreport, long broadcastIdentifier, int rewardedDuration, boolean shouldRewardOnClick) {
        try {
            Intents.startActivity(context, m37534a(context, adreport, broadcastIdentifier, rewardedDuration, shouldRewardOnClick));
        } catch (IntentNotResolvableException e) {
            Log.d("RewardedMraidActivity", "RewardedMraidActivity.class not found. Did you declare RewardedMraidActivity in your manifest?");
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    protected static Intent m37534a(Context context, AdReport adReport, long broadcastIdentifier, int rewardedDuration, boolean shouldRewardOnClick) {
        Intent intent = new Intent(context, RewardedMraidActivity.class);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, broadcastIdentifier);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.putExtra(DataKeys.REWARDED_AD_DURATION_KEY, rewardedDuration);
        intent.putExtra(DataKeys.SHOULD_REWARD_ON_CLICK_KEY, shouldRewardOnClick);
        return intent;
    }

    public View getAdView() {
        Config config;
        Intent intent = getIntent();
        String htmlData = mo37564c();
        if (TextUtils.isEmpty(htmlData)) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "RewardedMraidActivity received a null HTML body. Finishing the activity.");
            finish();
            return new View(this);
        } else if (mo37562a() == null) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "RewardedMraidActivity received a null broadcast id. Finishing the activity.");
            finish();
            return new View(this);
        } else {
            int rewardedDurationInSeconds = intent.getIntExtra(DataKeys.REWARDED_AD_DURATION_KEY, 30);
            boolean shouldRewardOnClick = intent.getBooleanExtra(DataKeys.SHOULD_REWARD_ON_CLICK_KEY, false);
            boolean preloaded = false;
            Long broadcastIdentifier = mo37562a();
            if (broadcastIdentifier != null) {
                config = WebViewCacheService.popWebViewConfig(broadcastIdentifier);
            } else {
                config = null;
            }
            if (config == null || !(config.getController() instanceof RewardedMraidController)) {
                RewardedMraidController rewardedMraidController = new RewardedMraidController(this, this.f35423a, PlacementType.INTERSTITIAL, rewardedDurationInSeconds, mo37562a().longValue());
                this.f34921g = rewardedMraidController;
            } else {
                preloaded = true;
                this.f34921g = (RewardedMraidController) config.getController();
            }
            this.f34921g.setDebugListener(this.f34922h);
            this.f34921g.setMraidListener(new C11450sa(this, shouldRewardOnClick));
            if (preloaded) {
                this.f34881f = config.getViewabilityManager();
            } else {
                this.f34921g.fillContent(htmlData, new C11452ta(this));
            }
            this.f34921g.onShow(this);
            return this.f34921g.getAdContainer();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RewardedMraidController rewardedMraidController = this.f34921g;
        if (rewardedMraidController != null) {
            rewardedMraidController.create(this, mo37563b());
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        RewardedMraidController rewardedMraidController = this.f34921g;
        if (rewardedMraidController != null) {
            rewardedMraidController.pause();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        RewardedMraidController rewardedMraidController = this.f34921g;
        if (rewardedMraidController != null) {
            rewardedMraidController.resume();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        RewardedMraidController rewardedMraidController = this.f34921g;
        if (rewardedMraidController != null) {
            rewardedMraidController.destroy();
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        RewardedMraidController rewardedMraidController = this.f34921g;
        if (rewardedMraidController == null || rewardedMraidController.backButtonEnabled()) {
            super.onBackPressed();
        }
    }

    @VisibleForTesting
    public void setDebugListener(MraidWebViewDebugListener debugListener) {
        this.f34922h = debugListener;
        RewardedMraidController rewardedMraidController = this.f34921g;
        if (rewardedMraidController != null) {
            rewardedMraidController.setDebugListener(debugListener);
        }
    }

    @Deprecated
    @VisibleForTesting
    public RewardedMraidController getRewardedMraidController() {
        return this.f34921g;
    }
}
