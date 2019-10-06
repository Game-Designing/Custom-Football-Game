package p019d.p143b.p144a.p146b;

import android.view.animation.AlphaAnimation;
import p019d.p143b.p144a.p147c.C7212tb;

/* renamed from: d.b.a.b.B */
class C6946B implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7030v f12832a;

    C6946B(C7030v vVar) {
        this.f12832a = vVar;
    }

    public void run() {
        try {
            if (this.f12832a.f13119h == null) {
                this.f12832a.m14555c();
            }
            this.f12832a.f13119h.setVisibility(0);
            this.f12832a.f13119h.bringToFront();
            C7212tb tbVar = new C7212tb(this.f12832a.f13113b);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(tbVar.mo23319r());
            alphaAnimation.setAnimationListener(new C6948C(this));
            this.f12832a.f13119h.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            this.f12832a.f13114c.mo22917b("ExpandedAdDialog", "Unable to fade in close button", th);
            this.f12832a.m14555c();
        }
    }
}
