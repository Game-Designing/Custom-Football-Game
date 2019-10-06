package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.Ra */
class C6978Ra implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12941a;

    /* renamed from: b */
    final /* synthetic */ Boolean f12942b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12943c;

    C6978Ra(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f12943c = ga;
        this.f12941a = webSettings;
        this.f12942b = bool;
    }

    public void run() {
        this.f12941a.setOffscreenPreRaster(this.f12942b.booleanValue());
    }
}
