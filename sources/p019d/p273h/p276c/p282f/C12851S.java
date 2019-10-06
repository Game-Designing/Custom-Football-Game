package p019d.p273h.p276c.p282f;

import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.f.S */
/* compiled from: ListenersWrapper */
class C12851S implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39579a;

    /* renamed from: b */
    final /* synthetic */ C12799b f39580b;

    /* renamed from: c */
    final /* synthetic */ C12858Z f39581c;

    C12851S(C12858Z this$0, String str, C12799b bVar) {
        this.f39581c = this$0;
        this.f39579a = str;
        this.f39580b = bVar;
    }

    public void run() {
        this.f39581c.f39596d.onInterstitialAdShowFailed(this.f39579a, this.f39580b);
    }
}
