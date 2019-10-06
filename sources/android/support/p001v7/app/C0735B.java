package android.support.p001v7.app;

import android.support.p000v4.view.C0587I;
import android.support.p000v4.view.C0589J;
import android.support.p000v4.view.C0646w;

/* renamed from: android.support.v7.app.B */
/* compiled from: AppCompatDelegateImplV9 */
class C0735B implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0737D f2181a;

    C0735B(C0737D this$0) {
        this.f2181a = this$0;
    }

    public void run() {
        C0737D d = this.f2181a;
        d.f2184A.showAtLocation(d.f2208z, 55, 0, 0);
        this.f2181a.mo6114t();
        if (this.f2181a.mo6116v()) {
            this.f2181a.f2208z.setAlpha(0.0f);
            C0737D d2 = this.f2181a;
            C0587I a = C0646w.m2945a(d2.f2208z);
            a.mo5470a(1.0f);
            d2.f2186C = a;
            this.f2181a.f2186C.mo5472a((C0589J) new C0729A(this));
            return;
        }
        this.f2181a.f2208z.setAlpha(1.0f);
        this.f2181a.f2208z.setVisibility(0);
    }
}
