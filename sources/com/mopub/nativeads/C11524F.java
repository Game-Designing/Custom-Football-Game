package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import java.util.List;

/* renamed from: com.mopub.nativeads.F */
/* compiled from: MoPubAdAdapter */
class C11524F implements VisibilityTrackerListener {

    /* renamed from: a */
    final /* synthetic */ MoPubAdAdapter f35640a;

    C11524F(MoPubAdAdapter this$0) {
        this.f35640a = this$0;
    }

    public void onVisibilityChanged(List<View> visibleViews, List<View> list) {
        this.f35640a.m38212a(visibleViews);
    }
}
