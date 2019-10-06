package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.j */
class C7006j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f13013a;

    /* renamed from: b */
    final /* synthetic */ Boolean f13014b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f13015c;

    C7006j(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f13015c = ga;
        this.f13013a = webSettings;
        this.f13014b = bool;
    }

    public void run() {
        this.f13013a.setLoadWithOverviewMode(this.f13014b.booleanValue());
    }
}
