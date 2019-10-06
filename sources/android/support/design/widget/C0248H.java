package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.design.widget.H */
/* compiled from: FloatingActionButtonImpl */
class C0248H extends AnimatorListenerAdapter {

    /* renamed from: a */
    private boolean f968a;

    /* renamed from: b */
    final /* synthetic */ boolean f969b;

    /* renamed from: c */
    final /* synthetic */ C0254c f970c;

    /* renamed from: d */
    final /* synthetic */ C0251K f971d;

    C0248H(C0251K this$0, boolean z, C0254c cVar) {
        this.f971d = this$0;
        this.f969b = z;
        this.f970c = cVar;
    }

    public void onAnimationStart(Animator animation) {
        this.f971d.f991p.mo4666a(0, this.f969b);
        this.f968a = false;
    }

    public void onAnimationCancel(Animator animation) {
        this.f968a = true;
    }

    public void onAnimationEnd(Animator animation) {
        C0251K k = this.f971d;
        k.f981f = 0;
        if (!this.f968a) {
            k.f991p.mo4666a(this.f969b ? 8 : 4, this.f969b);
            C0254c cVar = this.f970c;
            if (cVar != null) {
                cVar.mo4493b();
            }
        }
    }
}
