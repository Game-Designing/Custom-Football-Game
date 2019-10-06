package android.support.p001v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: android.support.v7.widget.Y */
/* compiled from: DefaultItemAnimator */
class C1030Y extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C1000w f3436a;

    /* renamed from: b */
    final /* synthetic */ ViewPropertyAnimator f3437b;

    /* renamed from: c */
    final /* synthetic */ View f3438c;

    /* renamed from: d */
    final /* synthetic */ C1047da f3439d;

    C1030Y(C1047da this$0, C1000w wVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f3439d = this$0;
        this.f3436a = wVar;
        this.f3437b = viewPropertyAnimator;
        this.f3438c = view;
    }

    public void onAnimationStart(Animator animator) {
        this.f3439d.mo8422m(this.f3436a);
    }

    public void onAnimationEnd(Animator animator) {
        this.f3437b.setListener(null);
        this.f3438c.setAlpha(1.0f);
        this.f3439d.mo8421l(this.f3436a);
        this.f3439d.f3487r.remove(this.f3436a);
        this.f3439d.mo8406j();
    }
}
