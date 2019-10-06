package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.internal.operators.observable.ObservablePublish.InnerDisposable;
import io.reactivex.internal.operators.observable.ObservablePublish.PublishObserver;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p330c.C13267b;
import p320f.p321a.p341e.C13762a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.Ha */
/* compiled from: ObservablePublish */
public final class C13364Ha<T> extends C13762a<T> implements C13267b<T> {

    /* renamed from: a */
    final C13802r<T> f40626a;

    /* renamed from: b */
    final AtomicReference<C13366b<T>> f40627b;

    /* renamed from: c */
    final C13802r<T> f40628c;

    /* renamed from: f.a.d.e.b.Ha$a */
    /* compiled from: ObservablePublish */
    static final class C13365a<T> extends AtomicReference<Object> implements C13194b {

        /* renamed from: a */
        final C13804t<? super T> f40629a;

        C13365a(C13804t<? super T> child) {
            this.f40629a = child;
        }

        public void dispose() {
            Object o = getAndSet(this);
            if (o != null && o != this) {
                ((C13366b) o).mo42412b(this);
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42409a(C13366b<T> p) {
            if (!compareAndSet(null, p)) {
                p.mo42412b(this);
            }
        }
    }

    /* renamed from: f.a.d.e.b.Ha$b */
    /* compiled from: ObservablePublish */
    static final class C13366b<T> implements C13804t<T>, C13194b {

        /* renamed from: a */
        static final C13365a[] f40630a = new C13365a[0];

        /* renamed from: b */
        static final C13365a[] f40631b = new C13365a[0];

        /* renamed from: c */
        final AtomicReference<C13366b<T>> f40632c;

        /* renamed from: d */
        final AtomicReference<C13365a<T>[]> f40633d = new AtomicReference<>(f40630a);

        /* renamed from: e */
        final AtomicBoolean f40634e;

        /* renamed from: f */
        final AtomicReference<C13194b> f40635f = new AtomicReference<>();

        C13366b(AtomicReference<C13366b<T>> current) {
            this.f40632c = current;
            this.f40634e = new AtomicBoolean();
        }

        public void dispose() {
            Object obj = this.f40633d.get();
            Object obj2 = f40631b;
            if (obj != obj2 && ((C13365a[]) this.f40633d.getAndSet(obj2)) != f40631b) {
                this.f40632c.compareAndSet(this, null);
                C13218c.m43150a(this.f40635f);
            }
        }

        /* renamed from: a */
        public boolean mo42410a() {
            return this.f40633d.get() == f40631b;
        }

        public void onSubscribe(C13194b s) {
            C13218c.m43153c(this.f40635f, s);
        }

        public void onNext(T t) {
            for (InnerDisposable<T> inner : (C13365a[]) this.f40633d.get()) {
                inner.f40629a.onNext(t);
            }
        }

        public void onError(Throwable e) {
            this.f40632c.compareAndSet(this, null);
            InnerDisposable<T>[] a = (C13365a[]) this.f40633d.getAndSet(f40631b);
            if (a.length != 0) {
                for (InnerDisposable<T> inner : a) {
                    inner.f40629a.onError(e);
                }
                return;
            }
            C13774a.m43836b(e);
        }

        public void onComplete() {
            this.f40632c.compareAndSet(this, null);
            for (InnerDisposable<T> inner : (C13365a[]) this.f40633d.getAndSet(f40631b)) {
                inner.f40629a.onComplete();
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42411a(C13365a<T> producer) {
            InnerDisposable<T>[] c;
            InnerDisposable<T>[] u;
            do {
                c = (C13365a[]) this.f40633d.get();
                if (c == f40631b) {
                    return false;
                }
                int len = c.length;
                u = new C13365a[(len + 1)];
                System.arraycopy(c, 0, u, 0, len);
                u[len] = producer;
            } while (!this.f40633d.compareAndSet(c, u));
            return true;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo42412b(C13365a<T> producer) {
            InnerDisposable<T>[] c;
            C13365a[] aVarArr;
            do {
                c = (C13365a[]) this.f40633d.get();
                int len = c.length;
                if (len != 0) {
                    int j = -1;
                    int i = 0;
                    while (true) {
                        if (i >= len) {
                            break;
                        } else if (c[i].equals(producer)) {
                            j = i;
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (j >= 0) {
                        if (len == 1) {
                            aVarArr = f40630a;
                        } else {
                            C13365a[] aVarArr2 = new C13365a[(len - 1)];
                            System.arraycopy(c, 0, aVarArr2, 0, j);
                            System.arraycopy(c, j + 1, aVarArr2, j, (len - j) - 1);
                            aVarArr = aVarArr2;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.f40633d.compareAndSet(c, aVarArr));
        }
    }

    /* renamed from: f.a.d.e.b.Ha$c */
    /* compiled from: ObservablePublish */
    static final class C13367c<T> implements C13802r<T> {

        /* renamed from: a */
        private final AtomicReference<C13366b<T>> f40636a;

        C13367c(AtomicReference<C13366b<T>> curr) {
            this.f40636a = curr;
        }

        public void subscribe(C13804t<? super T> child) {
            InnerDisposable<T> inner = new C13365a<>(child);
            child.onSubscribe(inner);
            while (true) {
                C13366b bVar = (C13366b) this.f40636a.get();
                if (bVar == null || bVar.mo42410a()) {
                    C13366b bVar2 = new C13366b(this.f40636a);
                    if (!this.f40636a.compareAndSet(bVar, bVar2)) {
                        continue;
                    } else {
                        bVar = bVar2;
                    }
                }
                if (bVar.mo42411a(inner)) {
                    inner.mo42409a(bVar);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static <T> C13762a<T> m43308a(C13802r<T> source) {
        AtomicReference<PublishObserver<T>> curr = new AtomicReference<>();
        return C13774a.m43817a((C13762a<T>) new C13364Ha<T>(new C13367c<>(curr), source, curr));
    }

    private C13364Ha(C13802r<T> onSubscribe, C13802r<T> source, AtomicReference<C13366b<T>> current) {
        this.f40628c = onSubscribe;
        this.f40626a = source;
        this.f40627b = current;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f40628c.subscribe(observer);
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo42408a(p320f.p321a.p326c.C13204f<? super p320f.p321a.p325b.C13194b> r5) {
        /*
            r4 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicReference<f.a.d.e.b.Ha$b<T>> r0 = r4.f40627b
            java.lang.Object r0 = r0.get()
            f.a.d.e.b.Ha$b r0 = (p320f.p321a.p327d.p332e.p334b.C13364Ha.C13366b) r0
            if (r0 == 0) goto L_0x0010
            boolean r1 = r0.mo42410a()
            if (r1 == 0) goto L_0x0021
        L_0x0010:
            f.a.d.e.b.Ha$b r1 = new f.a.d.e.b.Ha$b
            java.util.concurrent.atomic.AtomicReference<f.a.d.e.b.Ha$b<T>> r2 = r4.f40627b
            r1.<init>(r2)
            java.util.concurrent.atomic.AtomicReference<f.a.d.e.b.Ha$b<T>> r2 = r4.f40627b
            boolean r2 = r2.compareAndSet(r0, r1)
            if (r2 != 0) goto L_0x0020
            goto L_0x0000
        L_0x0020:
            r0 = r1
        L_0x0021:
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f40634e
            boolean r1 = r1.get()
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x0034
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.f40634e
            boolean r1 = r1.compareAndSet(r3, r2)
            if (r1 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r2 = 0
        L_0x0035:
            r1 = r2
            r5.accept(r0)     // Catch:{ Throwable -> 0x0043 }
            if (r1 == 0) goto L_0x0042
            f.a.r<T> r2 = r4.f40626a
            r2.subscribe(r0)
        L_0x0042:
            return
        L_0x0043:
            r2 = move-exception
            p024io.reactivex.exceptions.C13980a.m44462b(r2)
            java.lang.RuntimeException r3 = p320f.p321a.p327d.p340j.C13748j.m43761a(r2)
            goto L_0x004d
        L_0x004c:
            throw r3
        L_0x004d:
            goto L_0x004c
        */
        throw new UnsupportedOperationException("Method not decompiled: p320f.p321a.p327d.p332e.p334b.C13364Ha.mo42408a(f.a.c.f):void");
    }
}
