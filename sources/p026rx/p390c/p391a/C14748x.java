package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.OnErrorThrowable;
import p026rx.p027b.C0132p;
import p026rx.p400f.C14948s;
import rx.internal.operators.OnSubscribeFilter.FilterSubscriber;

/* renamed from: rx.c.a.x */
/* compiled from: OnSubscribeFilter */
public final class C14748x<T> implements C0122a<T> {

    /* renamed from: a */
    final C0120S<T> f43872a;

    /* renamed from: b */
    final C0132p<? super T, Boolean> f43873b;

    /* renamed from: rx.c.a.x$a */
    /* compiled from: OnSubscribeFilter */
    static final class C14749a<T> extends C14980ia<T> {

        /* renamed from: a */
        final C14980ia<? super T> f43874a;

        /* renamed from: b */
        final C0132p<? super T, Boolean> f43875b;

        /* renamed from: c */
        boolean f43876c;

        public C14749a(C14980ia<? super T> actual, C0132p<? super T, Boolean> predicate) {
            this.f43874a = actual;
            this.f43875b = predicate;
            request(0);
        }

        public void onNext(T t) {
            try {
                if (((Boolean) this.f43875b.call(t)).booleanValue()) {
                    this.f43874a.onNext(t);
                } else {
                    request(1);
                }
            } catch (Throwable ex) {
                C14927a.m46678c(ex);
                unsubscribe();
                onError(OnErrorThrowable.m46666a(ex, t));
            }
        }

        public void onError(Throwable e) {
            if (this.f43876c) {
                C14948s.m46719b(e);
                return;
            }
            this.f43876c = true;
            this.f43874a.onError(e);
        }

        public void onCompleted() {
            if (!this.f43876c) {
                this.f43874a.onCompleted();
            }
        }

        public void setProducer(C14508U p) {
            super.setProducer(p);
            this.f43874a.setProducer(p);
        }
    }

    public C14748x(C0120S<T> source, C0132p<? super T, Boolean> predicate) {
        this.f43872a = source;
        this.f43873b = predicate;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        FilterSubscriber<T> parent = new C14749a<>(child, this.f43873b);
        child.add(parent);
        this.f43872a.mo3640b((C14980ia<? super T>) parent);
    }
}
