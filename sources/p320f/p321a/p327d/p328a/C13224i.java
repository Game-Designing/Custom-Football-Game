package p320f.p321a.p327d.p328a;

import io.reactivex.Observer;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13753n;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.a.i */
/* compiled from: ObserverFullArbiter */
public final class C13224i<T> extends C13221f implements C13194b {

    /* renamed from: b */
    final C13804t<? super T> f40305b;

    /* renamed from: c */
    final C13706c<Object> f40306c;

    /* renamed from: d */
    volatile C13194b f40307d = C13219d.INSTANCE;

    /* renamed from: e */
    C13194b f40308e;

    /* renamed from: f */
    volatile boolean f40309f;

    public C13224i(C13804t<? super T> actual, C13194b resource, int capacity) {
        this.f40305b = actual;
        this.f40308e = resource;
        this.f40306c = new C13706c<>(capacity);
    }

    public void dispose() {
        if (!this.f40309f) {
            this.f40309f = true;
            mo42280a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo42280a() {
        C13194b d = this.f40308e;
        this.f40308e = null;
        if (d != null) {
            d.dispose();
        }
    }

    /* renamed from: b */
    public boolean mo42285b(C13194b s) {
        if (this.f40309f) {
            return false;
        }
        this.f40306c.mo42689a(this.f40307d, C13753n.m43775a(s));
        mo42284b();
        return true;
    }

    /* renamed from: a */
    public boolean mo42283a(T value, C13194b s) {
        if (this.f40309f) {
            return false;
        }
        C13706c<Object> cVar = this.f40306c;
        C13753n.m43785g(value);
        cVar.mo42689a(s, value);
        mo42284b();
        return true;
    }

    /* renamed from: a */
    public void mo42282a(Throwable value, C13194b s) {
        if (this.f40309f) {
            C13774a.m43836b(value);
            return;
        }
        this.f40306c.mo42689a(s, C13753n.m43776a(value));
        mo42284b();
    }

    /* renamed from: a */
    public void mo42281a(C13194b s) {
        this.f40306c.mo42689a(s, C13753n.m43782e());
        mo42284b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42284b() {
        if (this.f40302a.getAndIncrement() == 0) {
            int missed = 1;
            SpscLinkedArrayQueue<Object> q = this.f40306c;
            Observer<? super T> a = this.f40305b;
            while (true) {
                Object o = q.poll();
                if (o == null) {
                    missed = this.f40302a.addAndGet(-missed);
                    if (missed == 0) {
                        return;
                    }
                } else {
                    Object v = q.poll();
                    if (o == this.f40307d) {
                        if (C13753n.m43783e(v)) {
                            C13194b next = C13753n.m43774a(v);
                            this.f40307d.dispose();
                            if (!this.f40309f) {
                                this.f40307d = next;
                            } else {
                                next.dispose();
                            }
                        } else if (C13753n.m43784f(v)) {
                            q.clear();
                            mo42280a();
                            Throwable ex = C13753n.m43778b(v);
                            if (!this.f40309f) {
                                this.f40309f = true;
                                a.onError(ex);
                            } else {
                                C13774a.m43836b(ex);
                            }
                        } else if (C13753n.m43781d(v)) {
                            q.clear();
                            mo42280a();
                            if (!this.f40309f) {
                                this.f40309f = true;
                                a.onComplete();
                            }
                        } else {
                            C13753n.m43780c(v);
                            a.onNext(v);
                        }
                    }
                }
            }
        }
    }
}
