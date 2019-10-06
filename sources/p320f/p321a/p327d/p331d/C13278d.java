package p320f.p321a.p327d.p331d;

import java.util.concurrent.CountDownLatch;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p340j.C13743e;
import p320f.p321a.p327d.p340j.C13748j;

/* renamed from: f.a.d.d.d */
/* compiled from: BlockingBaseObserver */
public abstract class C13278d<T> extends CountDownLatch implements C13804t<T>, C13194b {

    /* renamed from: a */
    T f40359a;

    /* renamed from: b */
    Throwable f40360b;

    /* renamed from: c */
    C13194b f40361c;

    /* renamed from: d */
    volatile boolean f40362d;

    public C13278d() {
        super(1);
    }

    public final void onSubscribe(C13194b d) {
        this.f40361c = d;
        if (this.f40362d) {
            d.dispose();
        }
    }

    public final void onComplete() {
        countDown();
    }

    public final void dispose() {
        this.f40362d = true;
        C13194b d = this.f40361c;
        if (d != null) {
            d.dispose();
        }
    }

    /* renamed from: a */
    public final T mo42322a() {
        if (getCount() != 0) {
            try {
                C13743e.m43752a();
                await();
            } catch (InterruptedException ex) {
                dispose();
                throw C13748j.m43761a((Throwable) ex);
            }
        }
        Throwable e = this.f40360b;
        if (e == null) {
            return this.f40359a;
        }
        throw C13748j.m43761a(e);
    }
}
