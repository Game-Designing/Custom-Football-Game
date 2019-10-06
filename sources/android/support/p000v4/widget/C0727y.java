package android.support.p000v4.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: android.support.v4.widget.y */
/* compiled from: SwipeRefreshLayout */
class C0727y implements AnimationListener {

    /* renamed from: a */
    final /* synthetic */ SwipeRefreshLayout f2079a;

    C0727y(SwipeRefreshLayout this$0) {
        this.f2079a = this$0;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f2079a;
        if (!swipeRefreshLayout.f1974t) {
            swipeRefreshLayout.mo5857a((AnimationListener) null);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
