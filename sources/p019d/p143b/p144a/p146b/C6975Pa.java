package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.Pa */
class C6975Pa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12932a;

    /* renamed from: b */
    final /* synthetic */ Boolean f12933b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12934c;

    C6975Pa(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f12934c = ga;
        this.f12932a = webSettings;
        this.f12933b = bool;
    }

    public void run() {
        this.f12932a.setAllowUniversalAccessFromFileURLs(this.f12933b.booleanValue());
    }
}
