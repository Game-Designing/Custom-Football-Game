package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: android.support.transition.K */
/* compiled from: Transition */
class C0332K extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ C1253b f1156a;

    /* renamed from: b */
    final /* synthetic */ C0334M f1157b;

    C0332K(C0334M this$0, C1253b bVar) {
        this.f1157b = this$0;
        this.f1156a = bVar;
    }

    public void onAnimationStart(Animator animation) {
        this.f1157b.f1162A.add(animation);
    }

    public void onAnimationEnd(Animator animation) {
        this.f1156a.remove(animation);
        this.f1157b.f1162A.remove(animation);
    }
}
