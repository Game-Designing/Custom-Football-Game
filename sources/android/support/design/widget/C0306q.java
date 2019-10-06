package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: android.support.design.widget.q */
/* compiled from: BaseTransientBottomBar */
class C0306q implements AnimationListener {

    /* renamed from: a */
    final /* synthetic */ C0307r f1114a;

    C0306q(C0307r this$0) {
        this.f1114a = this$0;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1114a.mo4688f();
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
