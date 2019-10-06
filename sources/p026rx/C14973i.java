package p026rx;

import p026rx.C0126V.C0127a;
import p026rx.p029i.C0136c;

/* renamed from: rx.i */
/* compiled from: Completable */
class C14973i implements C14503O {

    /* renamed from: a */
    final /* synthetic */ C0136c f44321a;

    /* renamed from: b */
    final /* synthetic */ C0127a f44322b;

    /* renamed from: c */
    final /* synthetic */ C14503O f44323c;

    /* renamed from: d */
    final /* synthetic */ C14981j f44324d;

    C14973i(C14981j jVar, C0136c cVar, C0127a aVar, C14503O o) {
        this.f44324d = jVar;
        this.f44321a = cVar;
        this.f44322b = aVar;
        this.f44323c = o;
    }

    public void onCompleted() {
        C0136c cVar = this.f44321a;
        C0127a aVar = this.f44322b;
        C14957g gVar = new C14957g(this);
        C14981j jVar = this.f44324d;
        cVar.mo3713a(aVar.mo3709a(gVar, jVar.f44331b, jVar.f44332c));
    }

    public void onError(Throwable e) {
        if (this.f44324d.f44333d) {
            C0136c cVar = this.f44321a;
            C0127a aVar = this.f44322b;
            C14961h hVar = new C14961h(this, e);
            C14981j jVar = this.f44324d;
            cVar.mo3713a(aVar.mo3709a(hVar, jVar.f44331b, jVar.f44332c));
            return;
        }
        this.f44323c.onError(e);
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f44321a.mo3713a(d);
        this.f44323c.mo45688a(this.f44321a);
    }
}
