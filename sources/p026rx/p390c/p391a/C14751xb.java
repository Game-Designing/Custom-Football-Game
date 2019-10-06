package p026rx.p390c.p391a;

import java.util.NoSuchElementException;
import p026rx.C0120S.C0122a;
import p026rx.C14972ha;
import p026rx.C14980ia;
import p026rx.Single.C0124a;
import p026rx.p400f.C14948s;
import rx.internal.operators.SingleFromObservable.WrapSingleIntoSubscriber;

/* renamed from: rx.c.a.xb */
/* compiled from: SingleFromObservable */
public final class C14751xb<T> implements C0124a<T> {

    /* renamed from: a */
    final C0122a<T> f43878a;

    /* renamed from: rx.c.a.xb$a */
    /* compiled from: SingleFromObservable */
    static final class C14752a<T> extends C14980ia<T> {

        /* renamed from: a */
        final C14972ha<? super T> f43879a;

        /* renamed from: b */
        T f43880b;

        /* renamed from: c */
        int f43881c;

        C14752a(C14972ha<? super T> actual) {
            this.f43879a = actual;
        }

        public void onNext(T t) {
            int s = this.f43881c;
            if (s == 0) {
                this.f43881c = 1;
                this.f43880b = t;
            } else if (s == 1) {
                this.f43881c = 2;
                this.f43879a.onError(new IndexOutOfBoundsException("The upstream produced more than one value"));
            }
        }

        public void onError(Throwable e) {
            if (this.f43881c == 2) {
                C14948s.m46719b(e);
                return;
            }
            this.f43880b = null;
            this.f43879a.onError(e);
        }

        public void onCompleted() {
            int s = this.f43881c;
            if (s == 0) {
                this.f43879a.onError(new NoSuchElementException());
            } else if (s == 1) {
                this.f43881c = 2;
                T v = this.f43880b;
                this.f43880b = null;
                this.f43879a.mo45712a(v);
            }
        }
    }

    public C14751xb(C0122a<T> source) {
        this.f43878a = source;
    }

    /* renamed from: a */
    public void call(C14972ha<? super T> t) {
        WrapSingleIntoSubscriber<T> parent = new C14752a<>(t);
        t.mo46195b(parent);
        this.f43878a.call(parent);
    }
}
