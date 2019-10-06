package android.support.p000v4.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

/* renamed from: android.support.v4.view.H */
/* compiled from: ViewPropertyAnimatorCompat */
class C0586H implements AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ C0591L f1800a;

    /* renamed from: b */
    final /* synthetic */ View f1801b;

    /* renamed from: c */
    final /* synthetic */ C0587I f1802c;

    C0586H(C0587I this$0, C0591L l, View view) {
        this.f1802c = this$0;
        this.f1800a = l;
        this.f1801b = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f1800a.mo5483a(this.f1801b);
    }
}
