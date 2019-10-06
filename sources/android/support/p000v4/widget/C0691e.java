package android.support.p000v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* renamed from: android.support.v4.widget.e */
/* compiled from: CircularProgressDrawable */
class C0691e implements AnimatorListener {

    /* renamed from: a */
    final /* synthetic */ C0693a f2019a;

    /* renamed from: b */
    final /* synthetic */ C0692f f2020b;

    C0691e(C0692f this$0, C0693a aVar) {
        this.f2020b = this$0;
        this.f2019a = aVar;
    }

    public void onAnimationStart(Animator animator) {
        this.f2020b.f2028h = 0.0f;
    }

    public void onAnimationEnd(Animator animator) {
    }

    public void onAnimationCancel(Animator animation) {
    }

    public void onAnimationRepeat(Animator animator) {
        this.f2020b.m3269a(1.0f, this.f2019a, true);
        this.f2019a.mo5976l();
        this.f2019a.mo5974j();
        if (this.f2020b.f2029i) {
            this.f2020b.f2029i = false;
            animator.cancel();
            animator.setDuration(1332);
            animator.start();
            this.f2019a.mo5957a(false);
            return;
        }
        C0692f fVar = this.f2020b;
        fVar.f2028h = fVar.f2028h + 1.0f;
    }
}
