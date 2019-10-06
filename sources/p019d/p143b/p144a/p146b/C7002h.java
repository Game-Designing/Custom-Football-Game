package p019d.p143b.p144a.p146b;

import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;

/* renamed from: d.b.a.b.h */
class C7002h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ WebSettings f13005a;

    /* renamed from: b */
    final /* synthetic */ PluginState f13006b;

    /* renamed from: c */
    final /* synthetic */ C6957Ga f13007c;

    C7002h(C6957Ga ga, WebSettings webSettings, PluginState pluginState) {
        this.f13007c = ga;
        this.f13005a = webSettings;
        this.f13006b = pluginState;
    }

    public void run() {
        this.f13005a.setPluginState(this.f13006b);
    }
}
