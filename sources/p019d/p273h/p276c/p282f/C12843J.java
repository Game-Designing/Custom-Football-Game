package p019d.p273h.p276c.p282f;

import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.f.J */
/* compiled from: ListenersWrapper */
class C12843J implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39561a;

    /* renamed from: b */
    final /* synthetic */ C12799b f39562b;

    /* renamed from: c */
    final /* synthetic */ C12858Z f39563c;

    C12843J(C12858Z this$0, String str, C12799b bVar) {
        this.f39563c = this$0;
        this.f39561a = str;
        this.f39562b = bVar;
    }

    public void run() {
        this.f39563c.f39594b.onRewardedVideoAdShowFailed(this.f39561a, this.f39562b);
    }
}
