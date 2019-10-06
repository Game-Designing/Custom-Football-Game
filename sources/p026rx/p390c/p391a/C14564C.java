package p026rx.p390c.p391a;

import java.util.concurrent.atomic.AtomicLong;
import p026rx.C0120S.C0122a;
import p026rx.C14508U;
import p026rx.C14980ia;
import rx.Subscriber;

/* renamed from: rx.c.a.C */
/* compiled from: OnSubscribeFromArray */
public final class C14564C<T> implements C0122a<T> {

    /* renamed from: a */
    final T[] f43403a;

    /* renamed from: rx.c.a.C$a */
    /* compiled from: OnSubscribeFromArray */
    static final class C14565a<T> extends AtomicLong implements C14508U {

        /* renamed from: a */
        final C14980ia<? super T> f43404a;

        /* renamed from: b */
        final T[] f43405b;

        /* renamed from: c */
        int f43406c;

        public C14565a(C14980ia<? super T> child, T[] array) {
            this.f43404a = child;
            this.f43405b = array;
        }

        public void request(long n) {
            if (n < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("n >= 0 required but it was ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            } else if (n == Long.MAX_VALUE) {
                if (C14640a.m46283a((AtomicLong) this, n) == 0) {
                    mo45743a();
                }
            } else if (n != 0 && C14640a.m46283a((AtomicLong) this, n) == 0) {
                mo45744a(n);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45743a() {
            Subscriber<? super T> child = this.f43404a;
            T[] arr$ = this.f43405b;
            int len$ = arr$.length;
            int i$ = 0;
            while (i$ < len$) {
                T t = arr$[i$];
                if (!child.isUnsubscribed()) {
                    child.onNext(t);
                    i$++;
                } else {
                    return;
                }
            }
            if (!child.isUnsubscribed()) {
                child.onCompleted();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo45744a(long r) {
            Subscriber<? super T> child = this.f43404a;
            T[] array = this.f43405b;
            int n = array.length;
            long e = 0;
            int i = this.f43406c;
            while (true) {
                if (r == 0 || i == n) {
                    r = get() + e;
                    if (r == 0) {
                        this.f43406c = i;
                        r = addAndGet(e);
                        if (r != 0) {
                            e = 0;
                        } else {
                            return;
                        }
                    } else {
                        continue;
                    }
                } else if (!child.isUnsubscribed()) {
                    child.onNext(array[i]);
                    i++;
                    if (i == n) {
                        if (!child.isUnsubscribed()) {
                            child.onCompleted();
                        }
                        return;
                    }
                    r--;
                    e--;
                } else {
                    return;
                }
            }
        }
    }

    public C14564C(T[] array) {
        this.f43403a = array;
    }

    /* renamed from: a */
    public void call(C14980ia<? super T> child) {
        child.setProducer(new C14565a(child, this.f43403a));
    }
}
