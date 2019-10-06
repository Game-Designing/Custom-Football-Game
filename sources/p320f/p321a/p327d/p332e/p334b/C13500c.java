package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Notification;
import io.reactivex.internal.operators.observable.BlockingObservableLatest.BlockingObservableLatestIterator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13795k;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p340j.C13743e;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p342f.C13767c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.c */
/* compiled from: BlockingObservableLatest */
public final class C13500c<T> implements Iterable<T> {

    /* renamed from: a */
    final C13802r<T> f41073a;

    /* renamed from: f.a.d.e.b.c$a */
    /* compiled from: BlockingObservableLatest */
    static final class C13501a<T> extends C13767c<C13795k<T>> implements Iterator<T> {

        /* renamed from: b */
        C13795k<T> f41074b;

        /* renamed from: c */
        final Semaphore f41075c = new Semaphore(0);

        /* renamed from: d */
        final AtomicReference<C13795k<T>> f41076d = new AtomicReference<>();

        C13501a() {
        }

        /* renamed from: a */
        public void onNext(C13795k<T> args) {
            if (this.f41076d.getAndSet(args) == null) {
                this.f41075c.release();
            }
        }

        public void onError(Throwable e) {
            C13774a.m43836b(e);
        }

        public void onComplete() {
        }

        public boolean hasNext() {
            C13795k<T> kVar = this.f41074b;
            if (kVar == null || !kVar.mo42818e()) {
                if (this.f41074b == null) {
                    try {
                        C13743e.m43752a();
                        this.f41075c.acquire();
                        Notification<T> n = (C13795k) this.f41076d.getAndSet(null);
                        this.f41074b = n;
                        if (n.mo42818e()) {
                            throw C13748j.m43761a(n.mo42815b());
                        }
                    } catch (InterruptedException ex) {
                        dispose();
                        this.f41074b = C13795k.m43874a((Throwable) ex);
                        throw C13748j.m43761a((Throwable) ex);
                    }
                }
                return this.f41074b.mo42820f();
            }
            throw C13748j.m43761a(this.f41074b.mo42815b());
        }

        public T next() {
            if (hasNext()) {
                T v = this.f41074b.mo42816c();
                this.f41074b = null;
                return v;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public C13500c(C13802r<T> source) {
        this.f41073a = source;
    }

    public Iterator<T> iterator() {
        BlockingObservableLatestIterator<T> lio = new C13501a<>();
        C13797m.wrap(this.f41073a).materialize().subscribe((C13804t<? super T>) lio);
        return lio;
    }
}
