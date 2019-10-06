package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.Oa */
class C6973Oa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12927a;

    /* renamed from: b */
    final /* synthetic */ Boolean f12928b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12929c;

    C6973Oa(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f12929c = ga;
        this.f12927a = webSettings;
        this.f12928b = bool;
    }

    public void run() {
        this.f12927a.setAllowFileAccessFromFileURLs(this.f12928b.booleanValue());
    }
}
