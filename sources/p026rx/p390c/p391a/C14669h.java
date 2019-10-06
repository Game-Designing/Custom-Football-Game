package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C0137ja;
import p026rx.C14503O;
import p026rx.p029i.C0136c;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.a.h */
/* compiled from: CompletableOnSubscribeMergeArray */
class C14669h implements C14503O {

    /* renamed from: a */
    final /* synthetic */ C0136c f43668a;

    /* renamed from: b */
    final /* synthetic */ AtomicBoolean f43669b;

    /* renamed from: c */
    final /* synthetic */ C14503O f43670c;

    /* renamed from: d */
    final /* synthetic */ AtomicInteger f43671d;

    /* renamed from: e */
    final /* synthetic */ C14672i f43672e;

    C14669h(C14672i iVar, C0136c cVar, AtomicBoolean atomicBoolean, C14503O o, AtomicInteger atomicInteger) {
        this.f43672e = iVar;
        this.f43668a = cVar;
        this.f43669b = atomicBoolean;
        this.f43670c = o;
        this.f43671d = atomicInteger;
    }

    /* renamed from: a */
    public void mo45688a(C0137ja d) {
        this.f43668a.mo3713a(d);
    }

    public void onError(Throwable e) {
        this.f43668a.unsubscribe();
        if (this.f43669b.compareAndSet(false, true)) {
            this.f43670c.onError(e);
        } else {
            C14948s.m46719b(e);
        }
    }

    public void onCompleted() {
        if (this.f43671d.decrementAndGet() == 0 && this.f43669b.compareAndSet(false, true)) {
            this.f43670c.onCompleted();
        }
    }
}
