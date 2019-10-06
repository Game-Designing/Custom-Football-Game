package p026rx.p390c.p391a;

import p026rx.C0117M;
import p026rx.C0117M.C0118a;
import p026rx.C0137ja;
import p026rx.C14503O;
import p026rx.C14972ha;
import p026rx.Single;
import p026rx.exceptions.C14927a;
import p026rx.p027b.C0132p;
import rx.internal.operators.CompletableFlatMapSingleToCompletable.SourceSubscriber;

/* renamed from: rx.c.a.e */
/* compiled from: CompletableFlatMapSingleToCompletable */
public final class C14657e<T> implements C0118a {

    /* renamed from: a */
    final Single<T> f43635a;

    /* renamed from: b */
    final C0132p<? super T, ? extends C0117M> f43636b;

    /* renamed from: rx.c.a.e$a */
    /* compiled from: CompletableFlatMapSingleToCompletable */
    static final class C14658a<T> extends C14972ha<T> implements C14503O {

        /* renamed from: b */
        final C14503O f43637b;

        /* renamed from: c */
        final C0132p<? super T, ? extends C0117M> f43638c;

        public C14658a(C14503O actual, C0132p<? super T, ? extends C0117M> mapper) {
            this.f43637b = actual;
            this.f43638c = mapper;
        }

        /* renamed from: a */
        public void mo45712a(T value) {
            try {
                C0117M c = (C0117M) this.f43638c.call(value);
                if (c == null) {
                    onError(new NullPointerException("The mapper returned a null Completable"));
                } else {
                    c.mo3590a((C14503O) this);
                }
            } catch (Throwable ex) {
                C14927a.m46678c(ex);
                onError(ex);
            }
        }

        public void onError(Throwable error) {
            this.f43637b.onError(error);
        }

        public void onCompleted() {
            this.f43637b.onCompleted();
        }

        /* renamed from: a */
        public void mo45688a(C0137ja d) {
            mo46195b(d);
        }
    }

    public C14657e(Single<T> source, C0132p<? super T, ? extends C0117M> mapper) {
        this.f43635a = source;
        this.f43636b = mapper;
    }

    /* renamed from: a */
    public void call(C14503O t) {
        SourceSubscriber<T> parent = new C14658a<>(t, this.f43636b);
        t.mo45688a(parent);
        this.f43635a.mo3691a((C14972ha<? super T>) parent);
    }
}
