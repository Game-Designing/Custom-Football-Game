package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* renamed from: android.support.transition.ra */
/* compiled from: Visibility */
class C0391ra extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C0351Z f1295a;

    /* renamed from: b */
    final /* synthetic */ View f1296b;

    /* renamed from: c */
    final /* synthetic */ C0393sa f1297c;

    C0391ra(C0393sa this$0, C0351Z z, View view) {
        this.f1297c = this$0;
        this.f1295a = z;
        this.f1296b = view;
    }

    public void onAnimationEnd(Animator animation) {
        this.f1295a.mo4802b(this.f1296b);
    }
}
