package android.support.design.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.design.widget.AppBarLayout.Behavior;

/* renamed from: android.support.design.widget.c */
/* compiled from: AppBarLayout */
class C0284c implements AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ CoordinatorLayout f1083a;

    /* renamed from: b */
    final /* synthetic */ AppBarLayout f1084b;

    /* renamed from: c */
    final /* synthetic */ Behavior f1085c;

    C0284c(Behavior this$0, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.f1085c = this$0;
        this.f1083a = coordinatorLayout;
        this.f1084b = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator animation) {
        this.f1085c.mo4533c(this.f1083a, this.f1084b, ((Integer) animation.getAnimatedValue()).intValue());
    }
}
