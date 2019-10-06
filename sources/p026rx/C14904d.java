package p026rx;

/* renamed from: rx.d */
/* compiled from: Completable */
class C14904d extends C14972ha<Object> {

    /* renamed from: b */
    final /* synthetic */ C14503O f44210b;

    /* renamed from: c */
    final /* synthetic */ C14910e f44211c;

    C14904d(C14910e eVar, C14503O o) {
        this.f44211c = eVar;
        this.f44210b = o;
    }

    public void onError(Throwable e) {
        this.f44210b.onError(e);
    }

    /* renamed from: a */
    public void mo45712a(Object value) {
        this.f44210b.onCompleted();
    }
}
