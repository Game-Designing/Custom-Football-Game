package com.mopub.mobileads;

import android.view.View;
import com.unity3d.services.banners.IUnityBannerListener;
import java.util.HashMap;
import java.util.Map;

public class UnityBannerCallbackRouter implements IUnityBannerListener {

    /* renamed from: a */
    private final Map<String, IUnityBannerListener> f34951a = new HashMap();

    /* renamed from: b */
    private String f34952b;

    public void onUnityBannerLoaded(String placementId, View view) {
        IUnityBannerListener listener = (IUnityBannerListener) this.f34951a.get(placementId);
        if (listener != null) {
            listener.onUnityBannerLoaded(placementId, view);
        }
    }

    public void onUnityBannerUnloaded(String placementId) {
        IUnityBannerListener listener = (IUnityBannerListener) this.f34951a.get(placementId);
        if (listener != null) {
            listener.onUnityBannerUnloaded(placementId);
        }
    }

    public void onUnityBannerShow(String placementId) {
        IUnityBannerListener listener = (IUnityBannerListener) this.f34951a.get(placementId);
        if (listener != null) {
            listener.onUnityBannerShow(placementId);
        }
    }

    public void onUnityBannerClick(String placementId) {
        IUnityBannerListener listener = (IUnityBannerListener) this.f34951a.get(placementId);
        if (listener != null) {
            listener.onUnityBannerClick(placementId);
        }
    }

    public void onUnityBannerHide(String placementId) {
        IUnityBannerListener listener = (IUnityBannerListener) this.f34951a.get(placementId);
        if (listener != null) {
            listener.onUnityBannerHide(placementId);
        }
    }

    public void onUnityBannerError(String message) {
        IUnityBannerListener listener = (IUnityBannerListener) this.f34951a.get(this.f34952b);
        if (listener != null) {
            listener.onUnityBannerError(message);
        }
    }

    public void addListener(String placementId, IUnityBannerListener listener) {
        this.f34951a.put(placementId, listener);
    }

    public void removeListener(String placementId) {
        this.f34951a.remove(placementId);
    }

    public void setCurrentPlacementId(String placementId) {
        this.f34952b = placementId;
    }
}
