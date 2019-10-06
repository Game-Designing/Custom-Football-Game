package p026rx.p390c.p391a;

import p026rx.C14972ha;
import p026rx.Single;
import p026rx.Single.C0124a;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.CompositeException;
import p026rx.p027b.C0129b;
import rx.internal.operators.SingleDoOnEvent.SingleDoOnEventSubscriber;

/* renamed from: rx.c.a.vb */
/* compiled from: SingleDoOnEvent */
public final class C14739vb<T> implements C0124a<T> {

    /* renamed from: a */
    final Single<T> f43844a;

    /* renamed from: b */
    final C0129b<? super T> f43845b;

    /* renamed from: c */
    final C0129b<Throwable> f43846c;

    /* renamed from: rx.c.a.vb$a */
    /* compiled from: SingleDoOnEvent */
    static final class C14740a<T> extends C14972ha<T> {

        /* renamed from: b */
        final C14972ha<? super T> f43847b;

        /* renamed from: c */
        final C0129b<? super T> f43848c;

        /* renamed from: d */
        final C0129b<Throwable> f43849d;

        C14740a(C14972ha<? super T> actual, C0129b<? super T> onSuccess, C0129b<Throwable> onError) {
            this.f43847b = actual;
            this.f43848c = onSuccess;
            this.f43849d = onError;
        }

        /* renamed from: a */
        public void mo45712a(T value) {
            try {
                this.f43848c.call(value);
                this.f43847b.mo45712a(value);
            } catch (Throwable e) {
                C14927a.m46675a(e, (C14972ha<?>) this, (Object) value);
            }
        }

        public void onError(Throwable error) {
            try {
                this.f43849d.call(error);
                this.f43847b.onError(error);
            } catch (Throwable e) {
                C14927a.m46678c(e);
                this.f43847b.onError(new CompositeException(error, e));
            }
        }
    }

    public C14739vb(Single<T> source, C0129b<? super T> onSuccess, C0129b<Throwable> onError) {
        this.f43844a = source;
        this.f43845b = onSuccess;
        this.f43846c = onError;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> actual) {
        SingleDoOnEventSubscriber<T> parent = new C14740a<>(actual, this.f43845b, this.f43846c);
        actual.mo46195b(parent);
        this.f43844a.mo3691a((C14972ha<? super T>) parent);
    }
}
