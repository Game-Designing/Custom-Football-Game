package android.support.p000v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: android.support.v4.widget.w */
/* compiled from: SwipeRefreshLayout */
class C0725w extends Animation {

    /* renamed from: a */
    final /* synthetic */ SwipeRefreshLayout f2075a;

    C0725w(SwipeRefreshLayout this$0) {
        this.f2075a = this$0;
    }

    public void applyTransformation(float interpolatedTime, Transformation t) {
        this.f2075a.setAnimationProgress(1.0f - interpolatedTime);
    }
}
