package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.design.widget.o */
/* compiled from: BaseTransientBottomBar */
class C0304o extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C0307r f1110a;

    C0304o(C0307r this$0) {
        this.f1110a = this$0;
    }

    public void onAnimationStart(Animator animator) {
        this.f1110a.f1120f.mo4102a(70, Opcodes.GETFIELD);
    }

    public void onAnimationEnd(Animator animator) {
        this.f1110a.mo4688f();
    }
}
