package android.support.p001v7.app;

import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0590K;
import android.view.View;

/* renamed from: android.support.v7.app.A */
/* compiled from: AppCompatDelegateImplV9 */
class C0729A extends C0590K {

    /* renamed from: a */
    final /* synthetic */ C0735B f2081a;

    C0729A(C0735B this$1) {
        this.f2081a = this$1;
    }

    public void onAnimationStart(View view) {
        this.f2081a.f2181a.f2208z.setVisibility(0);
    }

    public void onAnimationEnd(View view) {
        this.f2081a.f2181a.f2208z.setAlpha(1.0f);
        this.f2081a.f2181a.f2186C.mo5472a((C0589J) null);
        this.f2081a.f2181a.f2186C = null;
    }
}
