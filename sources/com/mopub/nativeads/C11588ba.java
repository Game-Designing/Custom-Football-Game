package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import java.util.List;

/* renamed from: com.mopub.nativeads.ba */
/* compiled from: MoPubRecyclerAdapter */
class C11588ba implements VisibilityTrackerListener {

    /* renamed from: a */
    final /* synthetic */ MoPubRecyclerAdapter f36121a;

    C11588ba(MoPubRecyclerAdapter this$0) {
        this.f36121a = this$0;
    }

    public void onVisibilityChanged(List<View> visibleViews, List<View> invisibleViews) {
        this.f36121a.m38284a(visibleViews, invisibleViews);
    }
}
