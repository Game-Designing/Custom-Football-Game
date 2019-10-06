package p026rx.p390c.p391a;

import p026rx.C14980ia;
import p026rx.p029i.C14977e;
import p026rx.p029i.C14978f;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.a.u */
/* compiled from: OnSubscribeDelaySubscriptionOther */
class C14730u extends C14980ia<U> {

    /* renamed from: a */
    boolean f43821a;

    /* renamed from: b */
    final /* synthetic */ C14980ia f43822b;

    /* renamed from: c */
    final /* synthetic */ C14977e f43823c;

    /* renamed from: d */
    final /* synthetic */ C14737v f43824d;

    C14730u(C14737v vVar, C14980ia iaVar, C14977e eVar) {
        this.f43824d = vVar;
        this.f43822b = iaVar;
        this.f43823c = eVar;
    }

    public void onNext(U u) {
        onCompleted();
    }

    public void onError(Throwable e) {
        if (this.f43821a) {
            C14948s.m46719b(e);
            return;
        }
        this.f43821a = true;
        this.f43822b.onError(e);
    }

    public void onCompleted() {
        if (!this.f43821a) {
            this.f43821a = true;
            this.f43823c.mo46198a(C14978f.m46782b());
            this.f43824d.f43841a.mo3640b(this.f43822b);
        }
    }
}
