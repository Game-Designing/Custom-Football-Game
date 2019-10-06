package android.support.p001v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* renamed from: android.support.v7.widget.ca */
/* compiled from: DefaultItemAnimator */
class C1044ca extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C1048a f3471a;

    /* renamed from: b */
    final /* synthetic */ ViewPropertyAnimator f3472b;

    /* renamed from: c */
    final /* synthetic */ View f3473c;

    /* renamed from: d */
    final /* synthetic */ C1047da f3474d;

    C1044ca(C1047da this$0, C1048a aVar, ViewPropertyAnimator viewPropertyAnimator, View view) {
        this.f3474d = this$0;
        this.f3471a = aVar;
        this.f3472b = viewPropertyAnimator;
        this.f3473c = view;
    }

    public void onAnimationStart(Animator animator) {
        this.f3474d.mo8414b(this.f3471a.f3490b, false);
    }

    public void onAnimationEnd(Animator animator) {
        this.f3472b.setListener(null);
        this.f3473c.setAlpha(1.0f);
        this.f3473c.setTranslationX(0.0f);
        this.f3473c.setTranslationY(0.0f);
        this.f3474d.mo8412a(this.f3471a.f3490b, false);
        this.f3474d.f3488s.remove(this.f3471a.f3490b);
        this.f3474d.mo8406j();
    }
}
