package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.Na */
class C6971Na implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12922a;

    /* renamed from: b */
    final /* synthetic */ Boolean f12923b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12924c;

    C6971Na(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f12924c = ga;
        this.f12922a = webSettings;
        this.f12923b = bool;
    }

    public void run() {
        this.f12922a.setNeedInitialFocus(this.f12923b.booleanValue());
    }
}
