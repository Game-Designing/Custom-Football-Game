package p026rx.p390c.p391a;

import p026rx.C14972ha;
import p026rx.C14980ia;
import p026rx.p029i.C14977e;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.a.Cb */
/* compiled from: SingleOnSubscribeDelaySubscriptionOther */
class C14567Cb extends C14980ia<Object> {

    /* renamed from: a */
    boolean f43408a;

    /* renamed from: b */
    final /* synthetic */ C14972ha f43409b;

    /* renamed from: c */
    final /* synthetic */ C14977e f43410c;

    /* renamed from: d */
    final /* synthetic */ C14570Db f43411d;

    C14567Cb(C14570Db db, C14972ha haVar, C14977e eVar) {
        this.f43411d = db;
        this.f43409b = haVar;
        this.f43410c = eVar;
    }

    public void onNext(Object t) {
        onCompleted();
    }

    public void onError(Throwable e) {
        if (this.f43408a) {
            C14948s.m46719b(e);
            return;
        }
        this.f43408a = true;
        this.f43409b.onError(e);
    }

    public void onCompleted() {
        if (!this.f43408a) {
            this.f43408a = true;
            this.f43410c.mo46198a(this.f43409b);
            this.f43411d.f43414a.mo3691a(this.f43409b);
        }
    }
}
