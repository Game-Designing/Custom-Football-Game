package p019d.p273h.p276c.p282f;

import p019d.p273h.p276c.p281e.C12820l;

/* renamed from: d.h.c.f.K */
/* compiled from: ListenersWrapper */
class C12844K implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39564a;

    /* renamed from: b */
    final /* synthetic */ C12820l f39565b;

    /* renamed from: c */
    final /* synthetic */ C12858Z f39566c;

    C12844K(C12858Z this$0, String str, C12820l lVar) {
        this.f39566c = this$0;
        this.f39564a = str;
        this.f39565b = lVar;
    }

    public void run() {
        this.f39566c.f39594b.onRewardedVideoAdClicked(this.f39564a, this.f39565b);
    }
}
