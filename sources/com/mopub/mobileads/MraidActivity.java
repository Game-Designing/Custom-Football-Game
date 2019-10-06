package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.mopub.common.AdReport;
import com.mopub.common.Constants;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.IntentActions;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.CustomEventInterstitial.CustomEventInterstitialListener;
import com.mopub.mobileads.WebViewCacheService.Config;
import com.mopub.mraid.MraidBridge.MraidWebView;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;
import com.mopub.network.Networking;
import java.io.Serializable;

public class MraidActivity extends C11459v {
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MraidController f34879d;

    /* renamed from: e */
    private MraidWebViewDebugListener f34880e;

    /* renamed from: f */
    protected ExternalViewabilitySessionManager f34881f;

    public static void preRenderHtml(Interstitial mraidInterstitial, Context context, CustomEventInterstitialListener customEventInterstitialListener, Long broadcastIdentifier, AdReport adReport) {
        Preconditions.checkNotNull(mraidInterstitial);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(customEventInterstitialListener);
        Preconditions.checkNotNull(broadcastIdentifier);
        m37506a(mraidInterstitial, customEventInterstitialListener, C11459v.m37903a(adReport), new MraidWebView(context), broadcastIdentifier, new MraidController(context, adReport, PlacementType.INTERSTITIAL));
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m37506a(Interstitial mraidInterstitial, CustomEventInterstitialListener customEventInterstitialListener, String htmlData, BaseWebView mraidWebView, Long broadcastIdentifier, MraidController mraidController) {
        MoPubLog.log(AdLogEvent.LOAD_ATTEMPTED, new Object[0]);
        Preconditions.checkNotNull(mraidInterstitial);
        Preconditions.checkNotNull(customEventInterstitialListener);
        Preconditions.checkNotNull(mraidWebView);
        Preconditions.checkNotNull(broadcastIdentifier);
        Preconditions.checkNotNull(mraidController);
        mraidWebView.enablePlugins(false);
        mraidWebView.mo36943a();
        Context context = mraidWebView.getContext();
        mraidWebView.setWebViewClient(new C11428na(customEventInterstitialListener, mraidController, mraidWebView));
        ExternalViewabilitySessionManager externalViewabilitySessionManager = new ExternalViewabilitySessionManager(context);
        externalViewabilitySessionManager.createDisplaySession(context, mraidWebView, true);
        StringBuilder sb = new StringBuilder();
        sb.append(Networking.getBaseUrlScheme());
        sb.append("://");
        sb.append(Constants.HOST);
        sb.append("/");
        mraidWebView.loadDataWithBaseURL(sb.toString(), htmlData, "text/html", "UTF-8", null);
        WebViewCacheService.storeWebViewConfig(broadcastIdentifier, mraidInterstitial, mraidWebView, externalViewabilitySessionManager, mraidController);
    }

    public static void start(Context context, AdReport adreport, long broadcastIdentifier, CreativeOrientation orientation) {
        MoPubLog.log(AdLogEvent.SHOW_ATTEMPTED, new Object[0]);
        try {
            context.startActivity(m37504a(context, adreport, broadcastIdentifier, orientation));
        } catch (ActivityNotFoundException e) {
            MoPubLog.log(AdLogEvent.SHOW_FAILED, Integer.valueOf(MoPubErrorCode.INTERNAL_ERROR.getIntCode()), MoPubErrorCode.INTERNAL_ERROR);
            Log.d("MraidInterstitial", "MraidActivity.class not found. Did you declare MraidActivity in your manifest?");
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    protected static Intent m37504a(Context context, AdReport adReport, long broadcastIdentifier, CreativeOrientation orientation) {
        Intent intent = new Intent(context, MraidActivity.class);
        intent.putExtra(DataKeys.BROADCAST_IDENTIFIER_KEY, broadcastIdentifier);
        intent.putExtra(DataKeys.AD_REPORT_KEY, adReport);
        intent.putExtra(DataKeys.CREATIVE_ORIENTATION_KEY, orientation);
        intent.addFlags(268435456);
        return intent;
    }

    public View getAdView() {
        String htmlData = mo37564c();
        if (TextUtils.isEmpty(htmlData)) {
            MoPubLog.log(AdLogEvent.CUSTOM, "MraidActivity received a null HTML body. Finishing the activity.");
            finish();
            return new View(this);
        }
        Long broadcastIdentifier = mo37562a();
        Config config = null;
        if (broadcastIdentifier != null) {
            config = WebViewCacheService.popWebViewConfig(broadcastIdentifier);
        }
        if (config == null || config.getController() == null) {
            this.f34879d = new MraidController(this, this.f35423a, PlacementType.INTERSTITIAL);
        } else {
            this.f34879d = config.getController();
        }
        this.f34879d.setDebugListener(this.f34880e);
        this.f34879d.setMraidListener(new C11435oa(this));
        this.f34879d.setUseCustomCloseListener(new C11438pa(this));
        if (config != null) {
            this.f34881f = config.getViewabilityManager();
        } else {
            this.f34879d.fillContent(htmlData, new C11440qa(this));
        }
        return this.f34879d.getAdContainer();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MoPubLog.log(AdLogEvent.SHOW_SUCCESS, new Object[0]);
        Serializable orientationExtra = getIntent().getSerializableExtra(DataKeys.CREATIVE_ORIENTATION_KEY);
        CreativeOrientation requestedOrientation = CreativeOrientation.DEVICE;
        if (orientationExtra instanceof CreativeOrientation) {
            requestedOrientation = (CreativeOrientation) orientationExtra;
        }
        DeviceUtils.lockOrientation(this, requestedOrientation);
        ExternalViewabilitySessionManager externalViewabilitySessionManager = this.f34881f;
        if (externalViewabilitySessionManager != null) {
            externalViewabilitySessionManager.startDeferredDisplaySession(this);
        }
        if (mo37562a() != null) {
            BaseBroadcastReceiver.broadcastAction(this, mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_SHOW);
        }
        getWindow().setFlags(16777216, 16777216);
        MraidController mraidController = this.f34879d;
        if (mraidController != null) {
            mraidController.onShow(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        MraidController mraidController = this.f34879d;
        if (mraidController != null) {
            mraidController.pause(isFinishing());
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        MraidController mraidController = this.f34879d;
        if (mraidController != null) {
            mraidController.resume();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        ExternalViewabilitySessionManager externalViewabilitySessionManager = this.f34881f;
        if (externalViewabilitySessionManager != null) {
            externalViewabilitySessionManager.endDisplaySession();
            this.f34881f = null;
        }
        MraidController mraidController = this.f34879d;
        if (mraidController != null) {
            mraidController.destroy();
        }
        if (mo37562a() != null) {
            BaseBroadcastReceiver.broadcastAction(this, mo37562a().longValue(), IntentActions.ACTION_INTERSTITIAL_DISMISS);
        }
        super.onDestroy();
    }

    @VisibleForTesting
    public void setDebugListener(MraidWebViewDebugListener debugListener) {
        this.f34880e = debugListener;
        MraidController mraidController = this.f34879d;
        if (mraidController != null) {
            mraidController.setDebugListener(debugListener);
        }
    }
}
