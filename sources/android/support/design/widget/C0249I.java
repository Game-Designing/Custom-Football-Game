package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.design.widget.I */
/* compiled from: FloatingActionButtonImpl */
class C0249I extends AnimatorListenerAdapter {

    /* renamed from: a */
    final /* synthetic */ boolean f972a;

    /* renamed from: b */
    final /* synthetic */ C0254c f973b;

    /* renamed from: c */
    final /* synthetic */ C0251K f974c;

    C0249I(C0251K this$0, boolean z, C0254c cVar) {
        this.f974c = this$0;
        this.f972a = z;
        this.f973b = cVar;
    }

    public void onAnimationStart(Animator animation) {
        this.f974c.f991p.mo4666a(0, this.f972a);
    }

    public void onAnimationEnd(Animator animation) {
        this.f974c.f981f = 0;
        C0254c cVar = this.f973b;
        if (cVar != null) {
            cVar.mo4492a();
        }
    }
}
