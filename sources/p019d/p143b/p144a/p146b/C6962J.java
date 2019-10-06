package p019d.p143b.p144a.p146b;

import android.view.animation.AlphaAnimation;

/* renamed from: d.b.a.b.J */
class C6962J implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6950D f12903a;

    C6962J(C6950D d) {
        this.f12903a = d;
    }

    public void run() {
        try {
            if (this.f12903a.f12873q) {
                this.f12903a.f12845I.setVisibility(0);
                return;
            }
            this.f12903a.f12873q = true;
            if (this.f12903a.m14256P() && this.f12903a.f12846J != null) {
                this.f12903a.f12846J.setVisibility(0);
                this.f12903a.f12846J.bringToFront();
            }
            this.f12903a.f12845I.setVisibility(0);
            this.f12903a.f12845I.bringToFront();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration((long) this.f12903a.f12863g.mo23280V());
            alphaAnimation.setRepeatCount(0);
            this.f12903a.f12845I.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            this.f12903a.mo22496c();
        }
    }
}
