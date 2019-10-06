package p026rx.p390c.p391a;

import p026rx.C14972ha;
import p026rx.Single.C0124a;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0132p;
import rx.internal.operators.SingleOnErrorReturn.OnErrorReturnsSingleSubscriber;

/* renamed from: rx.c.a.Ab */
/* compiled from: SingleOnErrorReturn */
public final class C14555Ab<T> implements C0124a<T> {

    /* renamed from: a */
    final C0124a<T> f43372a;

    /* renamed from: b */
    final C0132p<Throwable, ? extends T> f43373b;

    /* renamed from: rx.c.a.Ab$a */
    /* compiled from: SingleOnErrorReturn */
    static final class C14556a<T> extends C14972ha<T> {

        /* renamed from: b */
        final C14972ha<? super T> f43374b;

        /* renamed from: c */
        final C0132p<Throwable, ? extends T> f43375c;

        public C14556a(C14972ha<? super T> actual, C0132p<Throwable, ? extends T> resumeFunction) {
            this.f43374b = actual;
            this.f43375c = resumeFunction;
        }

        /* renamed from: a */
        public void mo45712a(T value) {
            this.f43374b.mo45712a(value);
        }

        public void onError(Throwable error) {
            try {
                this.f43374b.mo45712a(this.f43375c.call(error));
            } catch (Throwable ex) {
                C14927a.m46678c(ex);
                this.f43374b.onError(ex);
            }
        }
    }

    public C14555Ab(C0124a<T> source, C0132p<Throwable, ? extends T> resumeFunction) {
        this.f43372a = source;
        this.f43373b = resumeFunction;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> t) {
        OnErrorReturnsSingleSubscriber<T> parent = new C14556a<>(t, this.f43373b);
        t.mo46195b(parent);
        this.f43372a.call(parent);
    }
}
