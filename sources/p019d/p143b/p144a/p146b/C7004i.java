package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.i */
class C7004i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f13009a;

    /* renamed from: b */
    final /* synthetic */ Boolean f13010b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f13011c;

    C7004i(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f13011c = ga;
        this.f13009a = webSettings;
        this.f13010b = bool;
    }

    public void run() {
        this.f13009a.setAllowFileAccess(this.f13010b.booleanValue());
    }
}
