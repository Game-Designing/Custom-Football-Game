package p026rx;

import p026rx.p027b.C0128a;

/* renamed from: rx.p */
/* compiled from: Completable */
class C14987p implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14989r f44347a;

    C14987p(C14989r rVar) {
        this.f44347a = rVar;
    }

    public void call() {
        try {
            this.f44347a.f44351b.onCompleted();
        } finally {
            this.f44347a.f44352c.unsubscribe();
        }
    }
}
