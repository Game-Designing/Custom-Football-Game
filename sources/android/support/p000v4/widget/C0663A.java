package android.support.p000v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: android.support.v4.widget.A */
/* compiled from: SwipeRefreshLayout */
class C0663A extends Animation {

    /* renamed from: a */
    final /* synthetic */ SwipeRefreshLayout f1876a;

    C0663A(SwipeRefreshLayout this$0) {
        this.f1876a = this$0;
    }

    public void applyTransformation(float interpolatedTime, Transformation t) {
        this.f1876a.mo5856a(interpolatedTime);
    }
}
