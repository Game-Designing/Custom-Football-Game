package android.support.p001v7.app;

import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0590K;
import android.support.p000v4.view.C0646w;
import android.view.View;

/* renamed from: android.support.v7.app.C */
/* compiled from: AppCompatDelegateImplV9 */
class C0736C extends C0590K {

    /* renamed from: a */
    final /* synthetic */ C0737D f2182a;

    C0736C(C0737D this$0) {
        this.f2182a = this$0;
    }

    public void onAnimationStart(View view) {
        this.f2182a.f2208z.setVisibility(0);
        this.f2182a.f2208z.sendAccessibilityEvent(32);
        if (this.f2182a.f2208z.getParent() instanceof View) {
            C0646w.m2991y((View) this.f2182a.f2208z.getParent());
        }
    }

    public void onAnimationEnd(View view) {
        this.f2182a.f2208z.setAlpha(1.0f);
        this.f2182a.f2186C.mo5472a((C0589J) null);
        this.f2182a.f2186C = null;
    }
}
