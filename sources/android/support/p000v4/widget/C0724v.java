package android.support.p000v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: android.support.v4.widget.v */
/* compiled from: SwipeRefreshLayout */
class C0724v extends Animation {

    /* renamed from: a */
    final /* synthetic */ SwipeRefreshLayout f2074a;

    C0724v(SwipeRefreshLayout this$0) {
        this.f2074a = this$0;
    }

    public void applyTransformation(float interpolatedTime, Transformation t) {
        this.f2074a.setAnimationProgress(interpolatedTime);
    }
}
