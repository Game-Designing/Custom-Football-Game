package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicInteger;
import p026rx.C0117M;
import p026rx.C0117M.C0118a;
import p026rx.C0137ja;
import p026rx.C14503O;
import p026rx.p029i.C14977e;

/* renamed from: rx.c.a.g */
/* compiled from: CompletableOnSubscribeConcatArray */
public final class C14665g implements C0118a {

    /* renamed from: a */
    final C0117M[] f43655a;

    /* renamed from: rx.c.a.g$a */
    /* compiled from: CompletableOnSubscribeConcatArray */
    static final class C14666a extends AtomicInteger implements C14503O {

        /* renamed from: a */
        final C14503O f43656a;

        /* renamed from: b */
        final C0117M[] f43657b;

        /* renamed from: c */
        int f43658c;

        /* renamed from: d */
        final C14977e f43659d = new C14977e();

        public C14666a(C14503O actual, C0117M[] sources) {
            this.f43656a = actual;
            this.f43657b = sources;
        }

        /* renamed from: a */
        public void mo45688a(C0137ja d) {
            this.f43659d.mo46198a(d);
        }

        public void onError(Throwable e) {
            this.f43656a.onError(e);
        }

        public void onCompleted() {
            mo45817a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45817a() {
            if (!this.f43659d.isUnsubscribed() && getAndIncrement() == 0) {
                C0117M[] a = this.f43657b;
                while (!this.f43659d.isUnsubscribed()) {
                    int idx = this.f43658c;
                    this.f43658c = idx + 1;
                    if (idx == a.length) {
                        this.f43656a.onCompleted();
                        return;
                    }
                    a[idx].mo3599b((C14503O) this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }
    }

    public C14665g(C0117M[] sources) {
        this.f43655a = sources;
    }

    /* renamed from: a */
    public void call(C14503O s) {
        C14666a inner = new C14666a(s, this.f43655a);
        s.mo45688a(inner.f43659d);
        inner.mo45817a();
    }
}
