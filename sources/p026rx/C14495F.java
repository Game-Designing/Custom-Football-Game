package p026rx;

/* renamed from: rx.F */
/* compiled from: Completable */
class C14495F implements C14503O {

    /* renamed from: a */
    final /* synthetic */ C14972ha f43294a;

    /* renamed from: b */
    final /* synthetic */ C14496G f43295b;

    C14495F(C14496G g, C14972ha haVar) {
        this.f43295b = g;
        this.f43294a = haVar;
    }

    public void onCompleted() {
        try {
            T v = this.f43295b.f43296a.call();
            if (v == null) {
                this.f43294a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.f43294a.mo45712a(v);
            }
        } catch (Throwable e) {
            this.f43294a.onError(e);
        }
    }

    public void onError(Throwable e) {
        this.f43294a.onError(e);
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f43294a.mo46195b(d);
    }
}
