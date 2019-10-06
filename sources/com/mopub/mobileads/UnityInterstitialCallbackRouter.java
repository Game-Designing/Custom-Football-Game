package com.mopub.mobileads;

import com.unity3d.ads.UnityAds.FinishState;
import com.unity3d.ads.UnityAds.PlacementState;
import com.unity3d.ads.UnityAds.UnityAdsError;
import com.unity3d.ads.mediation.IUnityAdsExtendedListener;
import java.util.HashMap;
import java.util.Map;

public class UnityInterstitialCallbackRouter implements IUnityAdsExtendedListener {

    /* renamed from: a */
    private final Map<String, IUnityAdsExtendedListener> f34959a = new HashMap();

    /* renamed from: b */
    private String f34960b;

    public void onUnityAdsReady(String placementId) {
        IUnityAdsExtendedListener listener = (IUnityAdsExtendedListener) this.f34959a.get(placementId);
        if (listener != null) {
            listener.onUnityAdsReady(placementId);
        }
    }

    public void onUnityAdsStart(String placementId) {
        IUnityAdsExtendedListener listener = (IUnityAdsExtendedListener) this.f34959a.get(placementId);
        if (listener != null) {
            listener.onUnityAdsStart(placementId);
        }
    }

    public void onUnityAdsFinish(String placementId, FinishState finishState) {
        IUnityAdsExtendedListener listener = (IUnityAdsExtendedListener) this.f34959a.get(placementId);
        if (listener != null) {
            listener.onUnityAdsFinish(placementId, finishState);
        }
    }

    public void onUnityAdsClick(String placementId) {
        IUnityAdsExtendedListener listener = (IUnityAdsExtendedListener) this.f34959a.get(placementId);
        if (listener != null) {
            listener.onUnityAdsClick(placementId);
        }
    }

    public void onUnityAdsPlacementStateChanged(String placementId, PlacementState oldState, PlacementState newState) {
        IUnityAdsExtendedListener listener = (IUnityAdsExtendedListener) this.f34959a.get(placementId);
        if (listener != null) {
            listener.onUnityAdsPlacementStateChanged(placementId, oldState, newState);
        }
    }

    public void onUnityAdsError(UnityAdsError unityAdsError, String message) {
        IUnityAdsExtendedListener listener = (IUnityAdsExtendedListener) this.f34959a.get(this.f34960b);
        if (listener != null) {
            listener.onUnityAdsError(unityAdsError, message);
        }
    }

    public void addListener(String placementId, IUnityAdsExtendedListener listener) {
        this.f34959a.put(placementId, listener);
    }

    public void removeListener(String placementId) {
        this.f34959a.remove(placementId);
    }

    public void setCurrentPlacementId(String placementId) {
        this.f34960b = placementId;
    }
}
