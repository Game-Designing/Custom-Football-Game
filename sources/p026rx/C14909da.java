package p026rx;

/* renamed from: rx.da */
/* compiled from: Single */
class C14909da extends C14972ha<Single<? extends T>> {

    /* renamed from: b */
    final /* synthetic */ C14972ha f44222b;

    /* renamed from: c */
    final /* synthetic */ C14921ea f44223c;

    C14909da(C14921ea eaVar, C14972ha haVar) {
        this.f44223c = eaVar;
        this.f44222b = haVar;
    }

    /* renamed from: a */
    public void mo45712a(Single<? extends T> innerSingle) {
        innerSingle.mo3691a(this.f44222b);
    }

    public void onError(Throwable error) {
        this.f44222b.onError(error);
    }
}
