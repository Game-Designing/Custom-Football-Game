package android.support.p000v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

/* renamed from: android.support.v4.widget.x */
/* compiled from: SwipeRefreshLayout */
class C0726x extends Animation {

    /* renamed from: a */
    final /* synthetic */ int f2076a;

    /* renamed from: b */
    final /* synthetic */ int f2077b;

    /* renamed from: c */
    final /* synthetic */ SwipeRefreshLayout f2078c;

    C0726x(SwipeRefreshLayout this$0, int i, int i2) {
        this.f2078c = this$0;
        this.f2076a = i;
        this.f2077b = i2;
    }

    public void applyTransformation(float interpolatedTime, Transformation t) {
        C0692f fVar = this.f2078c.f1944C;
        int i = this.f2076a;
        fVar.setAlpha((int) (((float) i) + (((float) (this.f2077b - i)) * interpolatedTime)));
    }
}
