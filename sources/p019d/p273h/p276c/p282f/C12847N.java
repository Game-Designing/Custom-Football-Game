package p019d.p273h.p276c.p282f;

import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.f.N */
/* compiled from: ListenersWrapper */
class C12847N implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39570a;

    /* renamed from: b */
    final /* synthetic */ C12799b f39571b;

    /* renamed from: c */
    final /* synthetic */ C12858Z f39572c;

    C12847N(C12858Z this$0, String str, C12799b bVar) {
        this.f39572c = this$0;
        this.f39570a = str;
        this.f39571b = bVar;
    }

    public void run() {
        this.f39572c.f39596d.onInterstitialAdLoadFailed(this.f39570a, this.f39571b);
    }
}
