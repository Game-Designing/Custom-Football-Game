package android.support.p001v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: android.support.v7.widget.ba */
/* compiled from: DefaultItemAnimator */
class C1041ba extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C1048a f3466a;

    /* renamed from: b */
    final /* synthetic */ ViewPropertyAnimator f3467b;

    /* renamed from: c */
    final /* synthetic */ View f3468c;

    /* renamed from: d */
    final /* synthetic */ C1047da f3469d;

    C1041ba(C1047da this$0, C1048a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f3469d = this$0;
        this.f3466a = aVar;
        this.f3467b = viewPropertyAnimator;
        this.f3468c = view;
    }

    public void onAnimationStart(Animator animator) {
        this.f3469d.mo8414b(this.f3466a.f3489a, true);
    }

    public void onAnimationEnd(Animator animator) {
        this.f3467b.setListener(null);
        this.f3468c.setAlpha(1.0f);
        this.f3468c.setTranslationX(0.0f);
        this.f3468c.setTranslationY(0.0f);
        this.f3469d.mo8412a(this.f3466a.f3489a, true);
        this.f3469d.f3488s.remove(this.f3466a.f3489a);
        this.f3469d.mo8406j();
    }
}
