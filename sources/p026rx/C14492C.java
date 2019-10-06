package p026rx;

import p026rx.C0126V.C0127a;
import p026rx.p027b.C0128a;

/* renamed from: rx.C */
/* compiled from: Completable */
class C14492C implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14503O f43288a;

    /* renamed from: b */
    final /* synthetic */ C0127a f43289b;

    /* renamed from: c */
    final /* synthetic */ C14493D f43290c;

    C14492C(C14493D d, C14503O o, C0127a aVar) {
        this.f43290c = d;
        this.f43288a = o;
        this.f43289b = aVar;
    }

    public void call() {
        try {
            this.f43290c.f43292b.mo3599b(this.f43288a);
        } finally {
            this.f43289b.unsubscribe();
        }
    }
}
