package android.support.p001v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: android.support.v7.widget.aa */
/* compiled from: DefaultItemAnimator */
class C1038aa extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C1000w f3458a;

    /* renamed from: b */
    final /* synthetic */ int f3459b;

    /* renamed from: c */
    final /* synthetic */ View f3460c;

    /* renamed from: d */
    final /* synthetic */ int f3461d;

    /* renamed from: e */
    final /* synthetic */ ViewPropertyAnimator f3462e;

    /* renamed from: f */
    final /* synthetic */ C1047da f3463f;

    C1038aa(C1047da this$0, C1000w wVar, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.f3463f = this$0;
        this.f3458a = wVar;
        this.f3459b = i;
        this.f3460c = view;
        this.f3461d = i2;
        this.f3462e = viewPropertyAnimator;
    }

    public void onAnimationStart(Animator animator) {
        this.f3463f.mo8420k(this.f3458a);
    }

    public void onAnimationCancel(Animator animator) {
        if (this.f3459b != 0) {
            this.f3460c.setTranslationX(0.0f);
        }
        if (this.f3461d != 0) {
            this.f3460c.setTranslationY(0.0f);
        }
    }

    public void onAnimationEnd(Animator animator) {
        this.f3462e.setListener(null);
        this.f3463f.mo8419j(this.f3458a);
        this.f3463f.f3486q.remove(this.f3458a);
        this.f3463f.mo8406j();
    }
}
