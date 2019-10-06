package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C0117M;
import p026rx.C0117M.C0118a;
import p026rx.C14503O;
import p026rx.p029i.C0136c;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.a.i */
/* compiled from: CompletableOnSubscribeMergeArray */
public final class C14672i implements C0118a {

    /* renamed from: a */
    final C0117M[] f43677a;

    public C14672i(C0117M[] sources) {
        this.f43677a = sources;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        C0136c set = new C0136c();
        AtomicInteger wip = new AtomicInteger(this.f43677a.length + 1);
        AtomicBoolean once = new AtomicBoolean();
        s.mo45688a(set);
        C0117M[] arr$ = this.f43677a;
        int len$ = arr$.length;
        int i$ = 0;
        while (i$ < len$) {
            C0117M c = arr$[i$];
            if (!set.isUnsubscribed()) {
                if (c == null) {
                    set.unsubscribe();
                    NullPointerException npe = new NullPointerException("A completable source is null");
                    if (once.compareAndSet(false, true)) {
                        s.onError(npe);
                        return;
                    }
                    C14948s.m46719b((Throwable) npe);
                }
                C14669h hVar = new C14669h(this, set, once, s, wip);
                c.mo3599b((C14503O) hVar);
                i$++;
            } else {
                return;
            }
        }
        if (wip.decrementAndGet() == 0 && once.compareAndSet(false, true)) {
            s.onCompleted();
        }
    }
}
