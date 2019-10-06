package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.BlockingObservableMostRecent.MostRecentObserver;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p320f.p321a.C13802r;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p327d.p340j.C13753n;
import p320f.p321a.p342f.C13766b;

/* renamed from: f.a.d.e.b.d */
/* compiled from: BlockingObservableMostRecent */
public final class C13505d<T> implements Iterable<T> {

    /* renamed from: a */
    final C13802r<T> f41081a;

    /* renamed from: b */
    final T f41082b;

    /* renamed from: f.a.d.e.b.d$a */
    /* compiled from: BlockingObservableMostRecent */
    static final class C13506a<T> extends C13766b<T> {

        /* renamed from: b */
        volatile Object f41083b;

        /* renamed from: f.a.d.e.b.d$a$a */
        /* compiled from: BlockingObservableMostRecent */
        final class C13507a implements Iterator<T> {

            /* renamed from: a */
            private Object f41084a;

            C13507a() {
            }

            public boolean hasNext() {
                this.f41084a = C13506a.this.f41083b;
                return !C13753n.m43781d(this.f41084a);
            }

            public T next() {
                Object obj = null;
                try {
                    if (this.f41084a == null) {
                        obj = C13506a.this.f41083b;
                    }
                    if (C13753n.m43781d(this.f41084a)) {
                        throw new NoSuchElementException();
                    } else if (!C13753n.m43784f(this.f41084a)) {
                        T t = this.f41084a;
                        C13753n.m43780c(t);
                        this.f41084a = obj;
                        return t;
                    } else {
                        throw C13748j.m43761a(C13753n.m43778b(this.f41084a));
                    }
                } finally {
                    this.f41084a = obj;
                }
            }

            public void remove() {
                throw new UnsupportedOperationException("Read only iterator");
            }
        }

        C13506a(T value) {
            C13753n.m43785g(value);
            this.f41083b = value;
        }

        public void onComplete() {
            this.f41083b = C13753n.m43782e();
        }

        public void onError(Throwable e) {
            this.f41083b = C13753n.m43776a(e);
        }

        public void onNext(T args) {
            C13753n.m43785g(args);
            this.f41083b = args;
        }

        /* renamed from: b */
        public C13507a mo42545b() {
            return new C13507a<>();
        }
    }

    public C13505d(C13802r<T> source, T initialValue) {
        this.f41081a = source;
        this.f41082b = initialValue;
    }

    public Iterator<T> iterator() {
        MostRecentObserver<T> mostRecentObserver = new C13506a<>(this.f41082b);
        this.f41081a.subscribe(mostRecentObserver);
        return mostRecentObserver.mo42545b();
    }
}
