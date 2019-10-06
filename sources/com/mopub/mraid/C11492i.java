package com.mopub.mraid;

import android.view.View;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import com.mopub.mraid.MraidBridge.MraidWebView;
import java.util.List;

/* renamed from: com.mopub.mraid.i */
/* compiled from: MraidBridge */
class C11492i implements VisibilityTrackerListener {

    /* renamed from: a */
    final /* synthetic */ MraidWebView f35570a;

    C11492i(MraidWebView this$0) {
        this.f35570a = this$0;
    }

    public void onVisibilityChanged(List<View> visibleViews, List<View> invisibleViews) {
        Preconditions.checkNotNull(visibleViews);
        Preconditions.checkNotNull(invisibleViews);
        MraidWebView mraidWebView = this.f35570a;
        mraidWebView.setMraidViewable(visibleViews.contains(mraidWebView));
    }
}
