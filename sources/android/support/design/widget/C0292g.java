package android.support.design.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: android.support.design.widget.g */
/* compiled from: BaseTransientBottomBar */
class C0292g implements AnimationListener {

    /* renamed from: a */
    final /* synthetic */ int f1095a;

    /* renamed from: b */
    final /* synthetic */ C0307r f1096b;

    C0292g(C0307r this$0, int i) {
        this.f1096b = this$0;
        this.f1095a = i;
    }

    public void onAnimationEnd(Animation animation) {
        this.f1096b.mo4684c(this.f1095a);
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
