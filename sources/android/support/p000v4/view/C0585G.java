package android.support.p000v4.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: android.support.v4.view.G */
/* compiled from: ViewPropertyAnimatorCompat */
class C0585G extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C0589J f1797a;

    /* renamed from: b */
    final /* synthetic */ View f1798b;

    /* renamed from: c */
    final /* synthetic */ C0587I f1799c;

    C0585G(C0587I this$0, C0589J j, View view) {
        this.f1799c = this$0;
        this.f1797a = j;
        this.f1798b = view;
    }

    public void onAnimationCancel(Animator animation) {
        this.f1797a.onAnimationCancel(this.f1798b);
    }

    public void onAnimationEnd(Animator animation) {
        this.f1797a.onAnimationEnd(this.f1798b);
    }

    public void onAnimationStart(Animator animation) {
        this.f1797a.onAnimationStart(this.f1798b);
    }
}
