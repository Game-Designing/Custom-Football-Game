package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.Ja */
class C6963Ja implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12904a;

    /* renamed from: b */
    final /* synthetic */ Boolean f12905b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12906c;

    C6963Ja(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f12906c = ga;
        this.f12904a = webSettings;
        this.f12905b = bool;
    }

    public void run() {
        this.f12904a.setBuiltInZoomControls(this.f12905b.booleanValue());
    }
}
