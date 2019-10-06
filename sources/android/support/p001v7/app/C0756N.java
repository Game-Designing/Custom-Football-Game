package android.support.p001v7.app;

import android.support.p000v4.view.C0590K;
import android.view.View;

/* renamed from: android.support.v7.app.N */
/* compiled from: WindowDecorActionBar */
class C0756N extends C0590K {

    /* renamed from: a */
    final /* synthetic */ C0758P f2272a;

    C0756N(C0758P this$0) {
        this.f2272a = this$0;
    }

    public void onAnimationEnd(View view) {
        C0758P p = this.f2272a;
        p.f2277B = null;
        p.f2288h.requestLayout();
    }
}
