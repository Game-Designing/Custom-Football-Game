package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.La */
class C6967La implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12913a;

    /* renamed from: b */
    final /* synthetic */ Boolean f12914b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12915c;

    C6967La(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f12915c = ga;
        this.f12913a = webSettings;
        this.f12914b = bool;
    }

    public void run() {
        this.f12913a.setSaveFormData(this.f12914b.booleanValue());
    }
}
