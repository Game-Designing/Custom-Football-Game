package p019d.p273h.p276c.p282f;

import p019d.p273h.p276c.p281e.C12820l;

/* renamed from: d.h.c.f.I */
/* compiled from: ListenersWrapper */
class C12842I implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f39558a;

    /* renamed from: b */
    final /* synthetic */ C12820l f39559b;

    /* renamed from: c */
    final /* synthetic */ C12858Z f39560c;

    C12842I(C12858Z this$0, String str, C12820l lVar) {
        this.f39560c = this$0;
        this.f39558a = str;
        this.f39559b = lVar;
    }

    public void run() {
        this.f39560c.f39594b.onRewardedVideoAdRewarded(this.f39558a, this.f39559b);
    }
}
