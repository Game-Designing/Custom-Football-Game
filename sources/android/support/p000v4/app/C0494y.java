package android.support.p000v4.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.app.y */
/* compiled from: FragmentManager */
class C0494y extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ ViewGroup f1628a;

    /* renamed from: b */
    final /* synthetic */ View f1629b;

    /* renamed from: c */
    final /* synthetic */ Fragment f1630c;

    /* renamed from: d */
    final /* synthetic */ C0409A f1631d;

    C0494y(C0409A this$0, ViewGroup viewGroup, View view, Fragment fragment) {
        this.f1631d = this$0;
        this.f1628a = viewGroup;
        this.f1629b = view;
        this.f1630c = fragment;
    }

    public void onAnimationEnd(Animator animation) {
        this.f1628a.endViewTransition(this.f1629b);
        animation.removeListener(this);
        View view = this.f1630c.mView;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}
