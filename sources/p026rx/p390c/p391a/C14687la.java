package p026rx.p390c.p391a;

import p026rx.C0126V.C0127a;
import p026rx.C14980ia;
import p026rx.p029i.C14977e;
import p026rx.p399e.C14917f;

/* renamed from: rx.c.a.la */
/* compiled from: OperatorDebounceWithTime */
class C14687la extends C14980ia<T> {

    /* renamed from: a */
    final C14692a<T> f43701a = new C14692a<>();

    /* renamed from: b */
    final C14980ia<?> f43702b = this;

    /* renamed from: c */
    final /* synthetic */ C14977e f43703c;

    /* renamed from: d */
    final /* synthetic */ C0127a f43704d;

    /* renamed from: e */
    final /* synthetic */ C14917f f43705e;

    /* renamed from: f */
    final /* synthetic */ C14691ma f43706f;

    C14687la(C14691ma maVar, C14980ia x0, C14977e eVar, C0127a aVar, C14917f fVar) {
        this.f43706f = maVar;
        this.f43703c = eVar;
        this.f43704d = aVar;
        this.f43705e = fVar;
        super(x0);
    }

    public void onStart() {
        request(Long.MAX_VALUE);
    }

    public void onNext(T t) {
        int index = this.f43701a.mo45830a(t);
        C14977e eVar = this.f43703c;
        C0127a aVar = this.f43704d;
        C14684ka kaVar = new C14684ka(this, index);
        C14691ma maVar = this.f43706f;
        eVar.mo46198a(aVar.mo3709a(kaVar, maVar.f43715a, maVar.f43716b));
    }

    public void onError(Throwable e) {
        this.f43705e.onError(e);
        unsubscribe();
        this.f43701a.mo45831a();
    }

    public void onCompleted() {
        this.f43701a.mo45833a(this.f43705e, this);
    }
}
