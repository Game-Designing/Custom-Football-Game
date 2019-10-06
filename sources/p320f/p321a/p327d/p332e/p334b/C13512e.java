package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Notification;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import p320f.p321a.C13795k;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p327d.p340j.C13743e;
import p320f.p321a.p327d.p340j.C13748j;
import p320f.p321a.p342f.C13767c;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.e */
/* compiled from: BlockingObservableNext */
public final class C13512e<T> implements Iterable<T> {

    /* renamed from: a */
    final C13802r<T> f41097a;

    /* renamed from: f.a.d.e.b.e$a */
    /* compiled from: BlockingObservableNext */
    static final class C13513a<T> implements Iterator<T> {

        /* renamed from: a */
        private final C13514b<T> f41098a;

        /* renamed from: b */
        private final C13802r<T> f41099b;

        /* renamed from: c */
        private T f41100c;

        /* renamed from: d */
        private boolean f41101d = true;

        /* renamed from: e */
        private boolean f41102e = true;

        /* renamed from: f */
        private Throwable f41103f;

        /* renamed from: g */
        private boolean f41104g;

        C13513a(C13802r<T> items, C13514b<T> observer) {
            this.f41099b = items;
            this.f41098a = observer;
        }

        public boolean hasNext() {
            Throwable th = this.f41103f;
            if (th == null) {
                boolean z = false;
                if (!this.f41101d) {
                    return false;
                }
                if (!this.f41102e || m43486a()) {
                    z = true;
                }
                return z;
            }
            throw C13748j.m43761a(th);
        }

        /* renamed from: a */
        private boolean m43486a() {
            if (!this.f41104g) {
                this.f41104g = true;
                this.f41098a.mo42556b();
                new C13682za(this.f41099b).subscribe((C13804t<? super T>) this.f41098a);
            }
            try {
                Notification<T> nextNotification = this.f41098a.mo42557c();
                if (nextNotification.mo42820f()) {
                    this.f41102e = false;
                    this.f41100c = nextNotification.mo42816c();
                    return true;
                }
                this.f41101d = false;
                if (nextNotification.mo42817d()) {
                    return false;
                }
                this.f41103f = nextNotification.mo42815b();
                throw C13748j.m43761a(this.f41103f);
            } catch (InterruptedException e) {
                this.f41098a.dispose();
                this.f41103f = e;
                throw C13748j.m43761a((Throwable) e);
            }
        }

        public T next() {
            Throwable th = this.f41103f;
            if (th != null) {
                throw C13748j.m43761a(th);
            } else if (hasNext()) {
                this.f41102e = true;
                return this.f41100c;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* renamed from: f.a.d.e.b.e$b */
    /* compiled from: BlockingObservableNext */
    static final class C13514b<T> extends C13767c<C13795k<T>> {

        /* renamed from: b */
        private final BlockingQueue<C13795k<T>> f41105b = new ArrayBlockingQueue(1);

        /* renamed from: c */
        final AtomicInteger f41106c = new AtomicInteger();

        C13514b() {
        }

        public void onComplete() {
        }

        public void onError(Throwable e) {
            C13774a.m43836b(e);
        }

        /* renamed from: a */
        public void onNext(C13795k<T> args) {
            if (this.f41106c.getAndSet(0) == 1 || !args.mo42820f()) {
                C13795k<T> kVar = args;
                while (!this.f41105b.offer(kVar)) {
                    C13795k<T> kVar2 = (C13795k) this.f41105b.poll();
                    if (kVar2 != null && !kVar2.mo42820f()) {
                        kVar = kVar2;
                    }
                }
            }
        }

        /* renamed from: c */
        public C13795k<T> mo42557c() throws InterruptedException {
            mo42556b();
            C13743e.m43752a();
            return (C13795k) this.f41105b.take();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42556b() {
            this.f41106c.set(1);
        }
    }

    public C13512e(C13802r<T> source) {
        this.f41097a = source;
    }

    public Iterator<T> iterator() {
        return new C13513a(this.f41097a, new C13514b<>());
    }
}
