package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0132p;
import rx.internal.operators.OperatorTakeUntilPredicate.ParentSubscriber;

/* renamed from: rx.c.a.ab */
/* compiled from: OperatorTakeUntilPredicate */
public final class C14644ab<T> implements C0123b<T, T> {

    /* renamed from: a */
    final C0132p<? super T, Boolean> f43611a;

    /* renamed from: rx.c.a.ab$a */
    /* compiled from: OperatorTakeUntilPredicate */
    final class C14645a extends C14980ia<T> {

        /* renamed from: a */
        private final C14980ia<? super T> f43612a;

        /* renamed from: b */
        private boolean f43613b;

        C14645a(C14980ia<? super T> child) {
            this.f43612a = child;
        }

        public void onNext(T t) {
            this.f43612a.onNext(t);
            try {
                if (((Boolean) C14644ab.this.f43611a.call(t)).booleanValue()) {
                    this.f43613b = true;
                    this.f43612a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable e) {
                this.f43613b = true;
                C14927a.m46673a(e, (C0125T<?>) this.f43612a, (Object) t);
                unsubscribe();
            }
        }

        public void onCompleted() {
            if (!this.f43613b) {
                this.f43612a.onCompleted();
            }
        }

        public void onError(Throwable e) {
            if (!this.f43613b) {
                this.f43612a.onError(e);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45805a(long n) {
            request(n);
        }
    }

    public C14644ab(C0132p<? super T, Boolean> stopPredicate) {
        this.f43611a = stopPredicate;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super T> child) {
        ParentSubscriber parent = new C14645a<>(child);
        child.add(parent);
        child.setProducer(new C14639_a(this, parent));
        return parent;
    }
}
