package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicBoolean;
import p026rx.C0117M.C0118a;
import p026rx.C0137ja;
import p026rx.C14502N;
import p026rx.C14503O;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0129b;
import p026rx.p390c.p394d.C14821b;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.a.f */
/* compiled from: CompletableFromEmitter */
public final class C14661f implements C0118a {

    /* renamed from: a */
    final C0129b<C14502N> f43646a;

    /* renamed from: rx.c.a.f$a */
    /* compiled from: CompletableFromEmitter */
    static final class C14662a extends AtomicBoolean implements C14502N, C0137ja {

        /* renamed from: a */
        final C14503O f43647a;

        /* renamed from: b */
        final C14821b f43648b = new C14821b();

        public C14662a(C14503O actual) {
            this.f43647a = actual;
        }

        public void onCompleted() {
            if (compareAndSet(false, true)) {
                try {
                    this.f43647a.onCompleted();
                } finally {
                    this.f43648b.unsubscribe();
                }
            }
        }

        public void onError(Throwable t) {
            if (compareAndSet(false, true)) {
                try {
                    this.f43647a.onError(t);
                } finally {
                    this.f43648b.unsubscribe();
                }
            } else {
                C14948s.m46719b(t);
            }
        }

        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f43648b.unsubscribe();
            }
        }

        public boolean isUnsubscribed() {
            return get();
        }
    }

    public C14661f(C0129b<C14502N> producer) {
        this.f43646a = producer;
    }

    /* renamed from: a */
    public void call(C14503O t) {
        C14662a emitter = new C14662a(t);
        t.mo45688a(emitter);
        try {
            this.f43646a.call(emitter);
        } catch (Throwable ex) {
            C14927a.m46678c(ex);
            emitter.onError(ex);
        }
    }
}
