package android.support.p001v7.app;

import android.support.p000v4.view.C0590K;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.widget.ActionBarOverlayLayout;
import android.view.View;

/* renamed from: android.support.v7.app.M */
/* compiled from: WindowDecorActionBar */
class C0755M extends C0590K {

    /* renamed from: a */
    final /* synthetic */ C0758P f2271a;

    C0755M(C0758P this$0) {
        this.f2271a = this$0;
    }

    public void onAnimationEnd(View view) {
        C0758P p = this.f2271a;
        if (p.f2303w) {
            View view2 = p.f2291k;
            if (view2 != null) {
                view2.setTranslationY(0.0f);
                this.f2271a.f2288h.setTranslationY(0.0f);
            }
        }
        this.f2271a.f2288h.setVisibility(8);
        this.f2271a.f2288h.setTransitioning(false);
        C0758P p2 = this.f2271a;
        p2.f2277B = null;
        p2.mo6182l();
        ActionBarOverlayLayout actionBarOverlayLayout = this.f2271a.f2287g;
        if (actionBarOverlayLayout != null) {
            C0646w.m2991y(actionBarOverlayLayout);
        }
    }
}
