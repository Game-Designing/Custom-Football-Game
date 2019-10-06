package android.support.p001v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.v7.widget.e */
/* compiled from: ActionBarOverlayLayout */
class C1051e extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ ActionBarOverlayLayout f3501a;

    C1051e(ActionBarOverlayLayout this$0) {
        this.f3501a = this$0;
    }

    public void onAnimationEnd(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3501a;
        actionBarOverlayLayout.f2860y = null;
        actionBarOverlayLayout.f2847l = false;
    }

    public void onAnimationCancel(Animator animator) {
        ActionBarOverlayLayout actionBarOverlayLayout = this.f3501a;
        actionBarOverlayLayout.f2860y = null;
        actionBarOverlayLayout.f2847l = false;
    }
}
