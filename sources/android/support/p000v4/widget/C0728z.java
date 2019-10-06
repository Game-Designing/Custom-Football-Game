package android.support.p000v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: android.support.v4.widget.z */
/* compiled from: SwipeRefreshLayout */
class C0728z extends Animation {

    /* renamed from: a */
    final /* synthetic */ SwipeRefreshLayout f2080a;

    C0728z(SwipeRefreshLayout this$0) {
        this.f2080a = this$0;
    }

    public void applyTransformation(float interpolatedTime, Transformation t) {
        int endTarget;
        SwipeRefreshLayout swipeRefreshLayout = this.f2080a;
        if (!swipeRefreshLayout.f1952K) {
            endTarget = swipeRefreshLayout.f1943B - Math.abs(swipeRefreshLayout.f1942A);
        } else {
            endTarget = swipeRefreshLayout.f1943B;
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.f2080a;
        int i = swipeRefreshLayout2.f1979y;
        this.f2080a.setTargetOffsetTopAndBottom((i + ((int) (((float) (endTarget - i)) * interpolatedTime))) - swipeRefreshLayout2.f1977w.getTop());
        this.f2080a.f1944C.mo5935a(1.0f - interpolatedTime);
    }
}
