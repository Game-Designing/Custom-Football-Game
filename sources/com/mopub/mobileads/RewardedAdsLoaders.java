package com.mopub.mobileads;

import android.content.Context;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.network.AdLoader.Listener;
import com.mopub.network.AdResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.util.HashMap;

class RewardedAdsLoaders {

    /* renamed from: a */
    private final HashMap<String, C11383b> f34918a = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final MoPubRewardedVideoManager f34919b;

    public class RewardedVideoRequestListener implements Listener {
        public final String adUnitId;

        RewardedVideoRequestListener(String adUnitId2) {
            this.adUnitId = adUnitId2;
        }

        public void onSuccess(AdResponse response) {
            RewardedAdsLoaders.this.f34919b.mo37097a(response);
        }

        public void onErrorResponse(VolleyError volleyError) {
            RewardedAdsLoaders.this.f34919b.mo37098a(volleyError, this.adUnitId);
        }
    }

    RewardedAdsLoaders(MoPubRewardedVideoManager rewardedVideoManager) {
        this.f34919b = rewardedVideoManager;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Request<?> mo37163a(Context context, String adUnitId, String adUrlString, MoPubErrorCode errorCode) {
        Preconditions.checkNotNull(adUnitId);
        Preconditions.checkNotNull(context);
        C11383b adLoader = (C11383b) this.f34918a.get(adUnitId);
        if (adLoader == null || !adLoader.hasMoreAds()) {
            C11383b bVar = new C11383b(adUrlString, AdFormat.REWARDED_VIDEO, adUnitId, context, new RewardedVideoRequestListener(adUnitId));
            adLoader = bVar;
            this.f34918a.put(adUnitId, adLoader);
        }
        return adLoader.loadNextAd(errorCode);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public boolean mo37169d(String adUnitId) {
        return this.f34918a.containsKey(adUnitId) && ((C11383b) this.f34918a.get(adUnitId)).isRunning();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public void mo37170e(String adUnitId) {
        Preconditions.checkNotNull(adUnitId);
        if (this.f34918a.containsKey(adUnitId)) {
            this.f34918a.remove(adUnitId);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public void mo37171f(String adUnitId) {
        Preconditions.checkNotNull(adUnitId);
        if (this.f34918a.containsKey(adUnitId)) {
            this.f34918a.remove(adUnitId);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37167b(String adUnitId, Context context) {
        Preconditions.checkNotNull(adUnitId);
        Preconditions.checkNotNull(context);
        C11383b loaderRewardedVideo = (C11383b) this.f34918a.get(adUnitId);
        if (loaderRewardedVideo != null) {
            loaderRewardedVideo.mo37450b(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37164a(String adUnitId, Context context) {
        Preconditions.checkNotNull(adUnitId);
        Preconditions.checkNotNull(context);
        C11383b loaderRewardedVideo = (C11383b) this.f34918a.get(adUnitId);
        if (loaderRewardedVideo != null) {
            loaderRewardedVideo.mo37448a(context);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo37165a(String adUnitId) {
        C11383b loaderRewardedVideo = (C11383b) this.f34918a.get(adUnitId);
        boolean z = false;
        if (loaderRewardedVideo == null) {
            return false;
        }
        if (loaderRewardedVideo.mo37451c() != null) {
            z = true;
        }
        return z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo37168c(String adUnitId) {
        C11383b loaderRewardedVideo = (C11383b) this.f34918a.get(adUnitId);
        return loaderRewardedVideo != null && loaderRewardedVideo.hasMoreAds();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo37166b(String adUnitId) {
        C11383b loaderRewardedVideo = (C11383b) this.f34918a.get(adUnitId);
        if (loaderRewardedVideo != null) {
            loaderRewardedVideo.creativeDownloadSuccess();
        }
    }
}
