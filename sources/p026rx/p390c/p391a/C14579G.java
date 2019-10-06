package p026rx.p390c.p391a;

import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.OnErrorThrowable;
import p026rx.p027b.C0132p;
import p026rx.p400f.C14948s;
import rx.internal.operators.OnSubscribeMap.MapSubscriber;

/* renamed from: rx.c.a.G */
/* compiled from: OnSubscribeMap */
public final class C14579G<T, R> implements C0122a<R> {

    /* renamed from: a */
    final C0120S<T> f43435a;

    /* renamed from: b */
    final C0132p<? super T, ? extends R> f43436b;

    /* renamed from: rx.c.a.G$a */
    /* compiled from: OnSubscribeMap */
    static final class C14580a<T, R> extends C14980ia<T> {

        /* renamed from: a */
        final C14980ia<? super R> f43437a;

        /* renamed from: b */
        final C0132p<? super T, ? extends R> f43438b;

        /* renamed from: c */
        boolean f43439c;

        public C14580a(C14980ia<? super R> actual, C0132p<? super T, ? extends R> mapper) {
            this.f43437a = actual;
            this.f43438b = mapper;
        }

        public void onNext(T t) {
            try {
                this.f43437a.onNext(this.f43438b.call(t));
            } catch (Throwable ex) {
                C14927a.m46678c(ex);
                unsubscribe();
                onError(OnErrorThrowable.m46666a(ex, t));
            }
        }

        public void onError(Throwable e) {
            if (this.f43439c) {
                C14948s.m46719b(e);
                return;
            }
            this.f43439c = true;
            this.f43437a.onError(e);
        }

        public void onCompleted() {
            if (!this.f43439c) {
                this.f43437a.onCompleted();
            }
        }

        public void setProducer(C14508U p) {
            this.f43437a.setProducer(p);
        }
    }

    public C14579G(C0120S<T> source, C0132p<? super T, ? extends R> transformer) {
        this.f43435a = source;
        this.f43436b = transformer;
    }

    /* renamed from: a */
    public void call(C14980ia<? super R> o) {
        MapSubscriber<T, R> parent = new C14580a<>(o, this.f43436b);
        o.add(parent);
        this.f43435a.mo3640b((C14980ia<? super T>) parent);
    }
}
