package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.BlockingObservableIterable.BlockingObservableIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p327d.p340j.C13743e;
import p320f.p321a.p327d.p340j.C13748j;

/* renamed from: f.a.d.e.b.b */
/* compiled from: BlockingObservableIterable */
public final class C13492b<T> implements Iterable<T> {

    /* renamed from: a */
    final C13802r<? extends T> f41036a;

    /* renamed from: b */
    final int f41037b;

    /* renamed from: f.a.d.e.b.b$a */
    /* compiled from: BlockingObservableIterable */
    static final class C13493a<T> extends AtomicReference<C13194b> implements C13804t<T>, Iterator<T>, C13194b {

        /* renamed from: a */
        final C13706c<T> f41038a;

        /* renamed from: b */
        final Lock f41039b = new ReentrantLock();

        /* renamed from: c */
        final Condition f41040c = this.f41039b.newCondition();

        /* renamed from: d */
        volatile boolean f41041d;

        /* renamed from: e */
        Throwable f41042e;

        C13493a(int batchSize) {
            this.f41038a = new C13706c<>(batchSize);
        }

        public boolean hasNext() {
            while (true) {
                boolean d = this.f41041d;
                boolean empty = this.f41038a.isEmpty();
                if (d) {
                    Throwable e = this.f41042e;
                    if (e != null) {
                        throw C13748j.m43761a(e);
                    } else if (empty) {
                        return false;
                    }
                }
                if (!empty) {
                    return true;
                }
                C13743e.m43752a();
                this.f41039b.lock();
                while (!this.f41041d && this.f41038a.isEmpty()) {
                    try {
                        this.f41040c.await();
                    } catch (InterruptedException ex) {
                        C13218c.m43150a((AtomicReference<C13194b>) this);
                        mo42525a();
                        throw C13748j.m43761a((Throwable) ex);
                    } catch (Throwable th) {
                        this.f41039b.unlock();
                        throw th;
                    }
                }
                this.f41039b.unlock();
            }
        }

        public T next() {
            if (hasNext()) {
                return this.f41038a.poll();
            }
            throw new NoSuchElementException();
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this, s);
        }

        public void onNext(T t) {
            this.f41038a.offer(t);
            mo42525a();
        }

        public void onError(Throwable t) {
            this.f41042e = t;
            this.f41041d = true;
            mo42525a();
        }

        public void onComplete() {
            this.f41041d = true;
            mo42525a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42525a() {
            this.f41039b.lock();
            try {
                this.f41040c.signalAll();
            } finally {
                this.f41039b.unlock();
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        public void dispose() {
            C13218c.m43150a((AtomicReference<C13194b>) this);
        }
    }

    public C13492b(C13802r<? extends T> source, int bufferSize) {
        this.f41036a = source;
        this.f41037b = bufferSize;
    }

    public Iterator<T> iterator() {
        BlockingObservableIterator<T> it = new C13493a<>(this.f41037b);
        this.f41036a.subscribe(it);
        return it;
    }
}
