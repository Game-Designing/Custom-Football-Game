package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.Ka */
class C6965Ka implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12908a;

    /* renamed from: b */
    final /* synthetic */ Boolean f12909b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12910c;

    C6965Ka(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f12910c = ga;
        this.f12908a = webSettings;
        this.f12909b = bool;
    }

    public void run() {
        this.f12908a.setDisplayZoomControls(this.f12909b.booleanValue());
    }
}
