package p026rx;

import p026rx.C0117M.C0118a;
import p026rx.p027b.C0128a;
import p026rx.p029i.C14975b;

/* renamed from: rx.K */
/* compiled from: Completable */
class C14500K implements C0118a {

    /* renamed from: a */
    final /* synthetic */ C0128a f43302a;

    C14500K(C0128a aVar) {
        this.f43302a = aVar;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        C14975b bs = new C14975b();
        s.mo45688a(bs);
        try {
            this.f43302a.call();
            if (!bs.isUnsubscribed()) {
                s.onCompleted();
            }
        } catch (Throwable e) {
            if (!bs.isUnsubscribed()) {
                s.onError(e);
            }
        }
    }
}
