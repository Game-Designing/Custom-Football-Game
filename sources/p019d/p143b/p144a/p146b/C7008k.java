package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.k */
class C7008k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f13031a;

    /* renamed from: b */
    final /* synthetic */ Boolean f13032b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f13033c;

    C7008k(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f13033c = ga;
        this.f13031a = webSettings;
        this.f13032b = bool;
    }

    public void run() {
        this.f13031a.setUseWideViewPort(this.f13032b.booleanValue());
    }
}
