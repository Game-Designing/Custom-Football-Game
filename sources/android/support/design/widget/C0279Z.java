package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.design.widget.Z */
/* compiled from: TextInputLayout */
class C0279Z extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ TextInputLayout f1073a;

    C0279Z(TextInputLayout this$0) {
        this.f1073a = this$0;
    }

    public void onAnimationStart(Animator animator) {
        this.f1073a.mErrorView.setVisibility(0);
    }
}
