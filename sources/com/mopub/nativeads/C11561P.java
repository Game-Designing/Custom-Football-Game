package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import com.mopub.nativeads.MoPubCustomEventVideoNative.MoPubVideoNativeAd;
import java.util.List;

/* renamed from: com.mopub.nativeads.P */
/* compiled from: MoPubCustomEventVideoNative */
class C11561P implements VisibilityTrackerListener {

    /* renamed from: a */
    final /* synthetic */ MoPubVideoNativeAd f36007a;

    C11561P(MoPubVideoNativeAd this$0) {
        this.f36007a = this$0;
    }

    public void onVisibilityChanged(List<View> visibleViews, List<View> invisibleViews) {
        if (!visibleViews.isEmpty() && !this.f36007a.f35838I) {
            this.f36007a.f35838I = true;
            this.f36007a.m38249i();
        } else if (!invisibleViews.isEmpty() && this.f36007a.f35838I) {
            this.f36007a.f35838I = false;
            this.f36007a.m38249i();
        }
    }
}
