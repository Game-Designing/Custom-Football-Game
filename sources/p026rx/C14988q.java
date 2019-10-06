package p026rx;

import p026rx.p027b.C0128a;

/* renamed from: rx.q */
/* compiled from: Completable */
class C14988q implements C0128a {

    /* renamed from: a */
    final /* synthetic */ Throwable f44348a;

    /* renamed from: b */
    final /* synthetic */ C14989r f44349b;

    C14988q(C14989r rVar, Throwable th) {
        this.f44349b = rVar;
        this.f44348a = th;
    }

    public void call() {
        try {
            this.f44349b.f44351b.onError(this.f44348a);
        } finally {
            this.f44349b.f44352c.unsubscribe();
        }
    }
}
