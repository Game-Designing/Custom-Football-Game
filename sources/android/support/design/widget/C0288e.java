package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.design.widget.e */
/* compiled from: BaseTransientBottomBar */
class C0288e extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ int f1087a;

    /* renamed from: b */
    final /* synthetic */ C0307r f1088b;

    C0288e(C0307r this$0, int i) {
        this.f1088b = this$0;
        this.f1087a = i;
    }

    public void onAnimationStart(Animator animator) {
        this.f1088b.f1120f.mo4103b(0, Opcodes.GETFIELD);
    }

    public void onAnimationEnd(Animator animator) {
        this.f1088b.mo4684c(this.f1087a);
    }
}
