package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.Ia */
class C6961Ia implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12900a;

    /* renamed from: b */
    final /* synthetic */ Boolean f12901b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12902c;

    C6961Ia(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f12902c = ga;
        this.f12900a = webSettings;
        this.f12901b = bool;
    }

    public void run() {
        this.f12900a.setAllowContentAccess(this.f12901b.booleanValue());
    }
}
