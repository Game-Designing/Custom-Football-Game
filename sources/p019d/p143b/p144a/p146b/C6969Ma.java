package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.Ma */
class C6969Ma implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12918a;

    /* renamed from: b */
    final /* synthetic */ Boolean f12919b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12920c;

    C6969Ma(C6957Ga ga, WebSettings webSettings, Boolean bool) {
        this.f12920c = ga;
        this.f12918a = webSettings;
        this.f12919b = bool;
    }

    public void run() {
        this.f12918a.setGeolocationEnabled(this.f12919b.booleanValue());
    }
}
