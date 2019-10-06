package p320f.p321a.p327d.p331d;

import java.util.concurrent.CountDownLatch;
import p320f.p321a.C13198c;
import p320f.p321a.C13787i;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p340j.C13743e;
import p320f.p321a.p327d.p340j.C13748j;

/* renamed from: f.a.d.d.g */
/* compiled from: BlockingMultiObserver */
public final class C13281g<T> extends CountDownLatch implements C13812x<T>, C13198c, C13787i<T> {

    /* renamed from: a */
    T f40363a;

    /* renamed from: b */
    Throwable f40364b;

    /* renamed from: c */
    C13194b f40365c;

    /* renamed from: d */
    volatile boolean f40366d;

    public C13281g() {
        super(1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo42324b() {
        this.f40366d = true;
        C13194b d = this.f40365c;
        if (d != null) {
            d.dispose();
        }
    }

    public void onSubscribe(C13194b d) {
        this.f40365c = d;
        if (this.f40366d) {
            d.dispose();
        }
    }

    public void onSuccess(T value) {
        this.f40363a = value;
        countDown();
    }

    public void onError(Throwable e) {
        this.f40364b = e;
        countDown();
    }

    public void onComplete() {
        countDown();
    }

    /* renamed from: a */
    public T mo42323a() {
        if (getCount() != 0) {
            try {
                C13743e.m43752a();
                await();
            } catch (InterruptedException ex) {
                mo42324b();
                throw C13748j.m43761a((Throwable) ex);
            }
        }
        Throwable ex2 = this.f40364b;
        if (ex2 == null) {
            return this.f40363a;
        }
        throw C13748j.m43761a(ex2);
    }
}
