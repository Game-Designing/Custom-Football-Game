package p026rx.p390c.p391a;

import p026rx.C0120S.C0123b;
import p026rx.C14508U;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.OnErrorThrowable;
import p026rx.p400f.C14948s;
import rx.internal.operators.OperatorCast.CastSubscriber;

/* renamed from: rx.c.a.ja */
/* compiled from: OperatorCast */
public class C14677ja<T, R> implements C0123b<R, T> {

    /* renamed from: a */
    final Class<R> f43682a;

    /* renamed from: rx.c.a.ja$a */
    /* compiled from: OperatorCast */
    static final class C14678a<T, R> extends C14980ia<T> {

        /* renamed from: a */
        final C14980ia<? super R> f43683a;

        /* renamed from: b */
        final Class<R> f43684b;

        /* renamed from: c */
        boolean f43685c;

        public C14678a(C14980ia<? super R> actual, Class<R> castClass) {
            this.f43683a = actual;
            this.f43684b = castClass;
        }

        public void onNext(T t) {
            try {
                this.f43683a.onNext(this.f43684b.cast(t));
            } catch (Throwable ex) {
                C14927a.m46678c(ex);
                unsubscribe();
                onError(OnErrorThrowable.m46666a(ex, t));
            }
        }

        public void onError(Throwable e) {
            if (this.f43685c) {
                C14948s.m46719b(e);
                return;
            }
            this.f43685c = true;
            this.f43683a.onError(e);
        }

        public void onCompleted() {
            if (!this.f43685c) {
                this.f43683a.onCompleted();
            }
        }

        public void setProducer(C14508U p) {
            this.f43683a.setProducer(p);
        }
    }

    public C14677ja(Class<R> castClass) {
        this.f43682a = castClass;
    }

    /* renamed from: a */
    public C14980ia<? super T> call(C14980ia<? super R> o) {
        CastSubscriber<T, R> parent = new C14678a<>(o, this.f43682a);
        o.add(parent);
        return parent;
    }
}
