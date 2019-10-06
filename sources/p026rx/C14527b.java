package p026rx;

/* renamed from: rx.b */
/* compiled from: Completable */
class C14527b extends C14980ia<Object> {

    /* renamed from: a */
    final /* synthetic */ C14503O f43349a;

    /* renamed from: b */
    final /* synthetic */ C14551c f43350b;

    C14527b(C14551c cVar, C14503O o) {
        this.f43350b = cVar;
        this.f43349a = o;
    }

    public void onCompleted() {
        this.f43349a.onCompleted();
    }

    public void onError(Throwable t) {
        this.f43349a.onError(t);
    }

    public void onNext(Object t) {
    }
}
