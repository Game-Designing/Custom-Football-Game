package p026rx;

import p026rx.p027b.C0128a;

/* renamed from: rx.g */
/* compiled from: Completable */
class C14957g implements C0128a {

    /* renamed from: a */
    final /* synthetic */ C14973i f44283a;

    C14957g(C14973i iVar) {
        this.f44283a = iVar;
    }

    public void call() {
        try {
            this.f44283a.f44323c.onCompleted();
        } finally {
            this.f44283a.f44322b.unsubscribe();
        }
    }
}
