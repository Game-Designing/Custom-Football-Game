package com.mopub.mobileads;

import android.content.Context;
import android.view.View;
import java.util.Map;

public abstract class CustomEventBanner {

    /* renamed from: a */
    private boolean f34716a = true;

    public interface CustomEventBannerListener {
        void onBannerClicked();

        void onBannerCollapsed();

        void onBannerExpanded();

        void onBannerFailed(MoPubErrorCode moPubErrorCode);

        void onBannerImpression();

        void onBannerLoaded(View view);

        void onLeaveApplication();
    }

    /* access modifiers changed from: protected */
    public abstract void loadBanner(Context context, CustomEventBannerListener customEventBannerListener, Map<String, Object> map, Map<String, String> map2);

    /* access modifiers changed from: protected */
    public abstract void onInvalidate();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo36958b() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo36956a(boolean autoTrack) {
        this.f34716a = autoTrack;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo36957a() {
        return this.f34716a;
    }
}
