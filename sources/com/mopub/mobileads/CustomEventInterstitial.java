package com.mopub.mobileads;

import android.content.Context;
import java.util.Map;

public abstract class CustomEventInterstitial implements Interstitial {

    /* renamed from: a */
    private boolean f34729a = true;

    public interface CustomEventInterstitialListener {
        void onInterstitialClicked();

        void onInterstitialDismissed();

        void onInterstitialFailed(MoPubErrorCode moPubErrorCode);

        void onInterstitialImpression();

        void onInterstitialLoaded();

        void onInterstitialShown();

        void onLeaveApplication();
    }

    /* access modifiers changed from: protected */
    public abstract void loadInterstitial(Context context, CustomEventInterstitialListener customEventInterstitialListener, Map<String, Object> map, Map<String, String> map2);

    /* access modifiers changed from: protected */
    public abstract void onInvalidate();

    /* access modifiers changed from: protected */
    public abstract void showInterstitial();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36971a(boolean autoTrack) {
        this.f34729a = autoTrack;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: e */
    public boolean mo36972e() {
        return this.f34729a;
    }
}
