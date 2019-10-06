package p026rx;

import java.util.concurrent.Callable;
import p026rx.C0117M.C0118a;
import p026rx.p029i.C14975b;

/* renamed from: rx.L */
/* compiled from: Completable */
class C14501L implements C0118a {

    /* renamed from: a */
    final /* synthetic */ Callable f43303a;

    C14501L(Callable callable) {
        this.f43303a = callable;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        C14975b bs = new C14975b();
        s.mo45688a(bs);
        try {
            this.f43303a.call();
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
