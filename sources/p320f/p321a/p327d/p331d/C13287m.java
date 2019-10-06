package p320f.p321a.p327d.p331d;

import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p340j.C13743e;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.d.m */
/* compiled from: FutureObserver */
public final class C13287m<T> extends CountDownLatch implements C13804t<T>, Future<T>, C13194b {

    /* renamed from: a */
    T f40381a;

    /* renamed from: b */
    Throwable f40382b;

    /* renamed from: c */
    final AtomicReference<C13194b> f40383c = new AtomicReference<>();

    public C13287m() {
        super(1);
    }

    public boolean cancel(boolean mayInterruptIfRunning) {
        C13194b a;
        C13218c cVar;
        do {
            a = (C13194b) this.f40383c.get();
            if (a != this) {
                cVar = C13218c.DISPOSED;
                if (a == cVar) {
                }
            }
            return false;
        } while (!this.f40383c.compareAndSet(a, cVar));
        if (a != null) {
            a.dispose();
        }
        countDown();
        return true;
    }

    public boolean isCancelled() {
        return C13218c.m43148a((C13194b) this.f40383c.get());
    }

    public boolean isDone() {
        return getCount() == 0;
    }

    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            C13743e.m43752a();
            await();
        }
        if (!isCancelled()) {
            Throwable ex = this.f40382b;
            if (ex == null) {
                return this.f40381a;
            }
            throw new ExecutionException(ex);
        }
        throw new CancellationException();
    }

    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            C13743e.m43752a();
            if (!await(timeout, unit)) {
                throw new TimeoutException();
            }
        }
        if (!isCancelled()) {
            Throwable ex = this.f40382b;
            if (ex == null) {
                return this.f40381a;
            }
            throw new ExecutionException(ex);
        }
        throw new CancellationException();
    }

    public void onSubscribe(C13194b s) {
        C13218c.m43153c(this.f40383c, s);
    }

    public void onNext(T t) {
        if (this.f40381a != null) {
            ((C13194b) this.f40383c.get()).dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f40381a = t;
    }

    public void onError(Throwable t) {
        C13194b a;
        if (this.f40382b == null) {
            this.f40382b = t;
            do {
                a = (C13194b) this.f40383c.get();
                if (a == this || a == C13218c.DISPOSED) {
                    C13774a.m43836b(t);
                    return;
                }
            } while (!this.f40383c.compareAndSet(a, this));
            countDown();
            return;
        }
        C13774a.m43836b(t);
    }

    public void onComplete() {
        C13194b a;
        if (this.f40381a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            a = (C13194b) this.f40383c.get();
            if (a == this || a == C13218c.DISPOSED) {
                return;
            }
        } while (!this.f40383c.compareAndSet(a, this));
        countDown();
    }

    public void dispose() {
    }
}
