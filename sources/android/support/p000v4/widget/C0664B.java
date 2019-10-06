package android.support.p000v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: android.support.v4.widget.B */
/* compiled from: SwipeRefreshLayout */
class C0664B extends Animation {

    /* renamed from: a */
    final /* synthetic */ SwipeRefreshLayout f1877a;

    C0664B(SwipeRefreshLayout this$0) {
        this.f1877a = this$0;
    }

    public void applyTransformation(float interpolatedTime, Transformation t) {
        SwipeRefreshLayout swipeRefreshLayout = this.f1877a;
        float f = swipeRefreshLayout.f1980z;
        swipeRefreshLayout.setAnimationProgress(f + ((-f) * interpolatedTime));
        this.f1877a.mo5856a(interpolatedTime);
    }
}
