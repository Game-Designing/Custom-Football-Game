package p026rx.p390c.p391a;

import p026rx.C14972ha;
import p026rx.Single;
import p026rx.Single.C0124a;
import p026rx.p027b.C0132p;
import rx.SingleSubscriber;

/* renamed from: rx.c.a.Gb */
/* compiled from: SingleOperatorOnErrorResumeNext */
public final class C14582Gb<T> implements C0124a<T> {

    /* renamed from: a */
    private final Single<? extends T> f43441a;

    /* renamed from: b */
    final C0132p<Throwable, ? extends Single<? extends T>> f43442b;

    private C14582Gb(Single<? extends T> originalSingle, C0132p<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError) {
        if (originalSingle == null) {
            throw new NullPointerException("originalSingle must not be null");
        } else if (resumeFunctionInCaseOfError != null) {
            this.f43441a = originalSingle;
            this.f43442b = resumeFunctionInCaseOfError;
        } else {
            throw new NullPointerException("resumeFunctionInCaseOfError must not be null");
        }
    }

    /* renamed from: a */
    public static <T> C14582Gb<T> m46221a(Single<? extends T> originalSingle, C0132p<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError) {
        return new C14582Gb<>(originalSingle, resumeFunctionInCaseOfError);
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> child) {
        SingleSubscriber<? super T> parent = new C14578Fb<>(this, child);
        child.mo46195b(parent);
        this.f43441a.mo3691a((C14972ha<? super T>) parent);
    }
}
