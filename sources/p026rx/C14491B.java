package p026rx;

/* renamed from: rx.B */
/* compiled from: Completable */
class C14491B implements C14503O {

    /* renamed from: a */
    final /* synthetic */ C14980ia f43286a;

    /* renamed from: b */
    final /* synthetic */ C0117M f43287b;

    C14491B(C0117M m, C14980ia iaVar) {
        this.f43287b = m;
        this.f43286a = iaVar;
    }

    public void onCompleted() {
        this.f43286a.onCompleted();
    }

    public void onError(Throwable e) {
        this.f43286a.onError(e);
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f43286a.add(d);
    }
}
