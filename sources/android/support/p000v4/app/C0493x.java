package android.support.p000v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.app.x */
/* compiled from: FragmentManager */
class C0493x extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ ViewGroup f1624a;

    /* renamed from: b */
    final /* synthetic */ View f1625b;

    /* renamed from: c */
    final /* synthetic */ Fragment f1626c;

    /* renamed from: d */
    final /* synthetic */ C0409A f1627d;

    C0493x(C0409A this$0, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f1627d = this$0;
        this.f1624a = viewGroup;
        this.f1625b = view;
        this.f1626c = fragment;
    }

    public void onAnimationEnd(Animator anim) {
        this.f1624a.endViewTransition(this.f1625b);
        Animator animator = this.f1626c.getAnimator();
        this.f1626c.setAnimator(null);
        if (animator != null && this.f1624a.indexOfChild(this.f1625b) < 0) {
            C0409A a = this.f1627d;
            Fragment fragment = this.f1626c;
            a.mo4917a(fragment, fragment.getStateAfterAnimating(), 0, 0, false);
        }
    }
}
