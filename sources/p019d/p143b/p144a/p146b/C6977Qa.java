package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;

/* renamed from: d.b.a.b.Qa */
class C6977Qa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f12938a;

    /* renamed from: b */
    final /* synthetic */ Integer f12939b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f12940c;

    C6977Qa(C6957Ga ga, WebSettings webSettings, Integer num) {
        this.f12940c = ga;
        this.f12938a = webSettings;
        this.f12939b = num;
    }

    public void run() {
        this.f12938a.setMixedContentMode(this.f12939b.intValue());
    }
}
