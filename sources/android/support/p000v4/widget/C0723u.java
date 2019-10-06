package android.support.p000v4.widget;

import android.support.p000v4.widget.SwipeRefreshLayout.C0683b;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: android.support.v4.widget.u */
/* compiled from: SwipeRefreshLayout */
class C0723u implements AnimationListener {

    /* renamed from: a */
    final /* synthetic */ SwipeRefreshLayout f2073a;

    C0723u(SwipeRefreshLayout this$0) {
        this.f2073a = this$0;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        SwipeRefreshLayout swipeRefreshLayout = this.f2073a;
        if (swipeRefreshLayout.f1959e) {
            swipeRefreshLayout.f1944C.setAlpha(255);
            this.f2073a.f1944C.start();
            SwipeRefreshLayout swipeRefreshLayout2 = this.f2073a;
            if (swipeRefreshLayout2.f1950I) {
                C0683b bVar = swipeRefreshLayout2.f1958d;
                if (bVar != null) {
                    bVar.mo5894a();
                }
            }
            SwipeRefreshLayout swipeRefreshLayout3 = this.f2073a;
            swipeRefreshLayout3.f1969o = swipeRefreshLayout3.f1977w.getTop();
            return;
        }
        swipeRefreshLayout.mo5860c();
    }
}
