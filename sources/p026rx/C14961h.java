package p026rx;

import p026rx.p027b.C0128a;

/* renamed from: rx.h */
/* compiled from: Completable */
class C14961h implements C0128a {

    /* renamed from: a */
    final /* synthetic */ Throwable f44290a;

    /* renamed from: b */
    final /* synthetic */ C14973i f44291b;

    C14961h(C14973i iVar, Throwable th) {
        this.f44291b = iVar;
        this.f44290a = th;
    }

    public void call() {
        try {
            this.f44291b.f44323c.onError(this.f44290a);
        } finally {
            this.f44291b.f44322b.unsubscribe();
        }
    }
}
