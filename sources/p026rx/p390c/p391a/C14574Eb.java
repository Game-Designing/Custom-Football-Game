package p026rx.p390c.p391a;

import p026rx.C14972ha;
import p026rx.Single;
import p026rx.Single.C0124a;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.OnErrorThrowable;
import p026rx.p027b.C0132p;
import p026rx.p400f.C14948s;
import rx.internal.operators.SingleOnSubscribeMap.MapSubscriber;

/* renamed from: rx.c.a.Eb */
/* compiled from: SingleOnSubscribeMap */
public final class C14574Eb<T, R> implements C0124a<R> {

    /* renamed from: a */
    final Single<T> f43420a;

    /* renamed from: b */
    final C0132p<? super T, ? extends R> f43421b;

    /* renamed from: rx.c.a.Eb$a */
    /* compiled from: SingleOnSubscribeMap */
    static final class C14575a<T, R> extends C14972ha<T> {

        /* renamed from: b */
        final C14972ha<? super R> f43422b;

        /* renamed from: c */
        final C0132p<? super T, ? extends R> f43423c;

        /* renamed from: d */
        boolean f43424d;

        public C14575a(C14972ha<? super R> actual, C0132p<? super T, ? extends R> mapper) {
            this.f43422b = actual;
            this.f43423c = mapper;
        }

        /* renamed from: a */
        public void mo45712a(T t) {
            try {
                this.f43422b.mo45712a(this.f43423c.call(t));
            } catch (Throwable ex) {
                C14927a.m46678c(ex);
                unsubscribe();
                onError(OnErrorThrowable.m46666a(ex, t));
            }
        }

        public void onError(Throwable e) {
            if (this.f43424d) {
                C14948s.m46719b(e);
                return;
            }
            this.f43424d = true;
            this.f43422b.onError(e);
        }
    }

    public C14574Eb(Single<T> source, C0132p<? super T, ? extends R> transformer) {
        this.f43420a = source;
        this.f43421b = transformer;
    }

    /* renamed from: a */
    public void call(C14972ha<? super R> o) {
        MapSubscriber<T, R> parent = new C14575a<>(o, this.f43421b);
        o.mo46195b(parent);
        this.f43420a.mo3691a((C14972ha<? super T>) parent);
    }
}
