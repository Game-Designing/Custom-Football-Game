package p019d.p143b.p144a.p146b;

import android.view.animation.AlphaAnimation;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.b.K */
class C6964K implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C6950D f12907a;

    C6964K(C6950D d) {
        this.f12907a = d;
    }

    public void run() {
        try {
            if (!this.f12907a.f12874r && this.f12907a.f12847K != null) {
                this.f12907a.f12874r = true;
                this.f12907a.f12847K.setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration((long) this.f12907a.f12863g.mo23280V());
                alphaAnimation.setRepeatCount(0);
                this.f12907a.f12847K.startAnimation(alphaAnimation);
                if (this.f12907a.m14256P() && this.f12907a.f12848L != null) {
                    this.f12907a.f12848L.setVisibility(0);
                    this.f12907a.f12848L.bringToFront();
                }
            }
        } catch (Throwable th) {
            C7262l lVar = this.f12907a.f12862f;
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to show skip button: ");
            sb.append(th);
            lVar.mo22913a("InterActivity", sb.toString());
        }
    }
}
