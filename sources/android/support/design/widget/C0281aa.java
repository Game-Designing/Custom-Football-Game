package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.design.widget.aa */
/* compiled from: TextInputLayout */
class C0281aa extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ CharSequence f1079a;

    /* renamed from: b */
    final /* synthetic */ TextInputLayout f1080b;

    C0281aa(TextInputLayout this$0, CharSequence charSequence) {
        this.f1080b = this$0;
        this.f1079a = charSequence;
    }

    public void onAnimationEnd(Animator animator) {
        this.f1080b.mErrorView.setText(this.f1079a);
        this.f1080b.mErrorView.setVisibility(4);
    }
}
