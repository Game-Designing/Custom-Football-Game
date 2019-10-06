package android.support.p001v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: android.support.v7.widget.Z */
/* compiled from: DefaultItemAnimator */
class C1032Z extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C1000w f3441a;

    /* renamed from: b */
    final /* synthetic */ View f3442b;

    /* renamed from: c */
    final /* synthetic */ ViewPropertyAnimator f3443c;

    /* renamed from: d */
    final /* synthetic */ C1047da f3444d;

    C1032Z(C1047da this$0, C1000w wVar, View view, ViewPropertyAnimator viewPropertyAnimator) {
        this.f3444d = this$0;
        this.f3441a = wVar;
        this.f3442b = view;
        this.f3443c = viewPropertyAnimator;
    }

    public void onAnimationStart(Animator animator) {
        this.f3444d.mo8418i(this.f3441a);
    }

    public void onAnimationCancel(Animator animator) {
        this.f3442b.setAlpha(1.0f);
    }

    public void onAnimationEnd(Animator animator) {
        this.f3443c.setListener(null);
        this.f3444d.mo8417h(this.f3441a);
        this.f3444d.f3485p.remove(this.f3441a);
        this.f3444d.mo8406j();
    }
}
