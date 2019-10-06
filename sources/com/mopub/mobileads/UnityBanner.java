package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import com.unity3d.ads.metadata.MetaData;
import com.unity3d.services.banners.IUnityBannerListener;
import com.unity3d.services.banners.UnityBanners;
import java.util.Map;

public class UnityBanner extends CustomEventBanner implements IUnityBannerListener, IUnityAdsExtendedListener {

    /* renamed from: b */
    private static final String f34945b = UnityBanner.class.getSimpleName();

    /* renamed from: c */
    private Context f34946c;

    /* renamed from: d */
    private String f34947d = "banner";

    /* renamed from: e */
    private CustomEventBannerListener f34948e;

    /* renamed from: f */
    private View f34949f;

    /* renamed from: g */
    private UnityAdsAdapterConfiguration f34950g = new UnityAdsAdapterConfiguration();

    /* access modifiers changed from: protected */
    public void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> serverExtras) {
        if (!(context instanceof Activity)) {
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34945b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            customEventBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
            return;
        }
        m37541a(context);
        this.f34950g.setCachedInitializationParameters(context, serverExtras);
        this.f34947d = UnityRouter.m37548a(serverExtras, this.f34947d);
        this.f34948e = customEventBannerListener;
        this.f34946c = context;
        UnityRouter.m37547a().setCurrentPlacementId(this.f34947d);
        if (UnityRouter.m37551a(serverExtras, (Activity) context)) {
            UnityRouter.m37547a().addListener(this.f34947d, this);
            UnityRouter.m37552b().addListener(this.f34947d, this);
            if (UnityAds.isReady(this.f34947d)) {
                UnityBanners.loadBanner((Activity) context, this.f34947d);
                MoPubLog.log(this.f34947d, AdapterLogEvent.LOAD_ATTEMPTED, f34945b);
            }
        } else {
            MoPubLog.log(AdapterLogEvent.CUSTOM, f34945b, "Failed to initialize Unity Ads");
            MoPubLog.log(AdapterLogEvent.LOAD_FAILED, f34945b, Integer.valueOf(MoPubErrorCode.NETWORK_NO_FILL.getIntCode()), MoPubErrorCode.NETWORK_NO_FILL);
            if (customEventBannerListener != null) {
                customEventBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
            }
        }
    }

    /* renamed from: a */
    private void m37541a(Context context) {
        MetaData metaData = new MetaData(context);
        metaData.set("banner.refresh", Boolean.valueOf(false));
        metaData.commit();
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
        UnityRouter.m37547a().removeListener(this.f34947d);
        UnityRouter.m37552b().removeListener(this.f34947d);
        UnityBanners.destroy();
        this.f34949f = null;
        this.f34948e = null;
    }

    public void onUnityBannerLoaded(String placementId, View view) {
        MoPubLog.log(AdapterLogEvent.LOAD_SUCCESS, f34945b);
        MoPubLog.log(AdapterLogEvent.SHOW_ATTEMPTED, f34945b);
        MoPubLog.log(AdapterLogEvent.SHOW_SUCCESS, f34945b);
        CustomEventBannerListener customEventBannerListener = this.f34948e;
        if (customEventBannerListener != null) {
            customEventBannerListener.onBannerLoaded(view);
            this.f34949f = view;
        }
    }

    public void onUnityBannerUnloaded(String placementId) {
        MoPubLog.log(AdapterLogEvent.CUSTOM, f34945b, String.format("Banner did unload for placement %s", new Object[]{placementId}));
    }

    public void onUnityBannerShow(String placementId) {
        MoPubLog.log(AdapterLogEvent.CUSTOM, f34945b, String.format("Banner did show for placement %s", new Object[]{placementId}));
        CustomEventBannerListener customEventBannerListener = this.f34948e;
        if (customEventBannerListener != null) {
            customEventBannerListener.onBannerImpression();
        }
    }

    public void onUnityBannerClick(String placementId) {
        MoPubLog.log(AdapterLogEvent.CLICKED, f34945b);
        CustomEventBannerListener customEventBannerListener = this.f34948e;
        if (customEventBannerListener != null) {
            customEventBannerListener.onBannerClicked();
        }
    }

    public void onUnityBannerHide(String placementIds) {
        MoPubLog.log(AdapterLogEvent.CUSTOM, f34945b, String.format("Banner did hide for placement %s", new Object[]{placementIds}));
    }

    public void onUnityBannerError(String message) {
        MoPubLog.log(AdapterLogEvent.CUSTOM, f34945b, String.format("Banner did error for placement %s with error %s", new Object[]{this.f34947d, message}));
        CustomEventBannerListener customEventBannerListener = this.f34948e;
        if (customEventBannerListener != null) {
            customEventBannerListener.onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public void onUnityAdsClick(String placementId) {
    }

    public void onUnityAdsPlacementStateChanged(String placementId, PlacementState placementState, PlacementState placementState1) {
    }

    public void onUnityAdsReady(String placementId) {
        if (this.f34949f == null) {
            UnityBanners.loadBanner((Activity) this.f34946c, placementId);
            MoPubLog.log(placementId, AdapterLogEvent.LOAD_ATTEMPTED, f34945b);
        }
    }

    public void onUnityAdsStart(String s) {
    }

    public void onUnityAdsFinish(String s, FinishState finishState) {
    }

    public void onUnityAdsError(UnityAdsError unityAdsError, String s) {
    }
}
