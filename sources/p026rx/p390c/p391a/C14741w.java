package p026rx.p390c.p391a;

import java.util.Arrays;
import java.util.Collection;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.C0125T;
import p026rx.C14980ia;
import p026rx.exceptions.C14927a;
import p026rx.exceptions.CompositeException;
import p026rx.p400f.C14948s;

/* renamed from: rx.c.a.w */
/* compiled from: OnSubscribeDoOnEach */
public class C14741w<T> implements C0122a<T> {

    /* renamed from: a */
    private final C0125T<? super T> f43850a;

    /* renamed from: b */
    private final C0120S<T> f43851b;

    /* renamed from: rx.c.a.w$a */
    /* compiled from: OnSubscribeDoOnEach */
    private static final class C14742a<T> extends C14980ia<T> {

        /* renamed from: a */
        private final C0125T<? super T> f43852a;

        /* renamed from: b */
        private boolean f43853b;
        private final C14980ia<? super T> subscriber;

        C14742a(C14980ia<? super T> subscriber2, C0125T<? super T> doOnEachObserver) {
            super(subscriber2);
            this.subscriber = subscriber2;
            this.f43852a = doOnEachObserver;
        }

        public void onCompleted() {
            if (!this.f43853b) {
                try {
                    this.f43852a.onCompleted();
                    this.f43853b = true;
                    this.subscriber.onCompleted();
                } catch (Throwable e) {
                    C14927a.m46672a(e, (C0125T<?>) this);
                }
            }
        }

        public void onError(Throwable e) {
            if (this.f43853b) {
                C14948s.m46719b(e);
                return;
            }
            this.f43853b = true;
            try {
                this.f43852a.onError(e);
                this.subscriber.onError(e);
            } catch (Throwable e2) {
                C14927a.m46678c(e2);
                this.subscriber.onError(new CompositeException((Collection<? extends Throwable>) Arrays.asList(new Throwable[]{e, e2})));
            }
        }

        public void onNext(T value) {
            if (!this.f43853b) {
                try {
                    this.f43852a.onNext(value);
                    this.subscriber.onNext(value);
                } catch (Throwable e) {
                    C14927a.m46673a(e, (C0125T<?>) this, (Object) value);
                }
            }
        }
    }

    public C14741w(C0120S<T> source, C0125T<? super T> doOnEachObserver) {
        this.f43851b = source;
        this.f43850a = doOnEachObserver;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> subscriber) {
        this.f43851b.mo3640b((C14980ia<? super T>) new C14742a<Object>(subscriber, this.f43850a));
    }
}
