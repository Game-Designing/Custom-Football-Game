package com.mopub.nativeads;

import android.view.View;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import java.util.List;

/* renamed from: com.mopub.nativeads.l */
/* compiled from: ImpressionTracker */
class C11617l implements VisibilityTrackerListener {

    /* renamed from: a */
    final /* synthetic */ ImpressionTracker f36173a;

    C11617l(ImpressionTracker this$0) {
        this.f36173a = this$0;
    }

    public void onVisibilityChanged(List<View> visibleViews, List<View> invisibleViews) {
        for (View view : visibleViews) {
            ImpressionInterface impressionInterface = (ImpressionInterface) this.f36173a.f35683b.get(view);
            if (impressionInterface == null) {
                this.f36173a.removeView(view);
            } else {
                TimestampWrapper<ImpressionInterface> polling = (C11516Bb) this.f36173a.f35684c.get(view);
                if (polling == null || !impressionInterface.equals(polling.f35619a)) {
                    this.f36173a.f35684c.put(view, new C11516Bb(impressionInterface));
                }
            }
        }
        for (View view2 : invisibleViews) {
            this.f36173a.f35684c.remove(view2);
        }
        this.f36173a.mo37817a();
    }
}
