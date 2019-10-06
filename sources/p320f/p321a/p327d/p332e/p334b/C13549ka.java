package p320f.p321a.p327d.p332e.p334b;

import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.ObservableGroupBy.GroupedUnicast;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p024io.reactivex.exceptions.C13980a;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p328a.C13218c;
import p320f.p321a.p327d.p328a.C13219d;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p336f.C13706c;
import p320f.p321a.p341e.C13763b;

/* renamed from: f.a.d.e.b.ka */
/* compiled from: ObservableGroupBy */
public final class C13549ka<T, K, V> extends C13485a<T, C13763b<K, V>> {

    /* renamed from: b */
    final C13212n<? super T, ? extends K> f41209b;

    /* renamed from: c */
    final C13212n<? super T, ? extends V> f41210c;

    /* renamed from: d */
    final int f41211d;

    /* renamed from: e */
    final boolean f41212e;

    /* renamed from: f.a.d.e.b.ka$a */
    /* compiled from: ObservableGroupBy */
    public static final class C13550a<T, K, V> extends AtomicInteger implements C13804t<T>, C13194b {

        /* renamed from: a */
        static final Object f41213a = new Object();

        /* renamed from: b */
        final C13804t<? super C13763b<K, V>> f41214b;

        /* renamed from: c */
        final C13212n<? super T, ? extends K> f41215c;

        /* renamed from: d */
        final C13212n<? super T, ? extends V> f41216d;

        /* renamed from: e */
        final int f41217e;

        /* renamed from: f */
        final boolean f41218f;

        /* renamed from: g */
        final Map<Object, C13551b<K, V>> f41219g;

        /* renamed from: h */
        C13194b f41220h;

        /* renamed from: i */
        final AtomicBoolean f41221i = new AtomicBoolean();

        public C13550a(C13804t<? super C13763b<K, V>> actual, C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector, int bufferSize, boolean delayError) {
            this.f41214b = actual;
            this.f41215c = keySelector;
            this.f41216d = valueSelector;
            this.f41217e = bufferSize;
            this.f41218f = delayError;
            this.f41219g = new ConcurrentHashMap();
            lazySet(1);
        }

        public void onSubscribe(C13194b s) {
            if (C13218c.m43149a(this.f41220h, s)) {
                this.f41220h = s;
                this.f41214b.onSubscribe(this);
            }
        }

        public void onNext(T t) {
            try {
                K key = this.f41215c.apply(t);
                Object mapKey = key != null ? key : f41213a;
                GroupedUnicast<K, V> group = (C13551b) this.f41219g.get(mapKey);
                if (group == null) {
                    if (!this.f41221i.get()) {
                        group = C13551b.m43509a(key, this.f41217e, this, this.f41218f);
                        this.f41219g.put(mapKey, group);
                        getAndIncrement();
                        this.f41214b.onNext(group);
                    } else {
                        return;
                    }
                }
                try {
                    V v = this.f41216d.apply(t);
                    C13264b.m43226a(v, "The value supplied is null");
                    group.onNext(v);
                } catch (Throwable e) {
                    C13980a.m44462b(e);
                    this.f41220h.dispose();
                    onError(e);
                }
            } catch (Throwable e2) {
                C13980a.m44462b(e2);
                this.f41220h.dispose();
                onError(e2);
            }
        }

        public void onError(Throwable t) {
            List<GroupedUnicast<K, V>> list = new ArrayList<>(this.f41219g.values());
            this.f41219g.clear();
            for (GroupedUnicast<K, V> e : list) {
                e.onError(t);
            }
            this.f41214b.onError(t);
        }

        public void onComplete() {
            List<GroupedUnicast<K, V>> list = new ArrayList<>(this.f41219g.values());
            this.f41219g.clear();
            for (GroupedUnicast<K, V> e : list) {
                e.onComplete();
            }
            this.f41214b.onComplete();
        }

        public void dispose() {
            if (this.f41221i.compareAndSet(false, true) && decrementAndGet() == 0) {
                this.f41220h.dispose();
            }
        }

        /* renamed from: a */
        public void mo42566a(K key) {
            this.f41219g.remove(key != null ? key : f41213a);
            if (decrementAndGet() == 0) {
                this.f41220h.dispose();
            }
        }
    }

    /* renamed from: f.a.d.e.b.ka$b */
    /* compiled from: ObservableGroupBy */
    static final class C13551b<K, T> extends C13763b<K, T> {

        /* renamed from: b */
        final C13552c<T, K> f41222b;

        /* renamed from: a */
        public static <T, K> C13551b<K, T> m43509a(K key, int bufferSize, C13550a<?, K, T> parent, boolean delayError) {
            return new C13551b<>(key, new C13552c<>(bufferSize, parent, key, delayError));
        }

        protected C13551b(K key, C13552c<T, K> state) {
            super(key);
            this.f41222b = state;
        }

        /* access modifiers changed from: protected */
        public void subscribeActual(C13804t<? super T> observer) {
            this.f41222b.subscribe(observer);
        }

        public void onNext(T t) {
            this.f41222b.mo42571a(t);
        }

        public void onError(Throwable e) {
            this.f41222b.mo42572a(e);
        }

        public void onComplete() {
            this.f41222b.mo42574b();
        }
    }

    /* renamed from: f.a.d.e.b.ka$c */
    /* compiled from: ObservableGroupBy */
    static final class C13552c<T, K> extends AtomicInteger implements C13194b, C13802r<T> {

        /* renamed from: a */
        final K f41223a;

        /* renamed from: b */
        final C13706c<T> f41224b;

        /* renamed from: c */
        final C13550a<?, K, T> f41225c;

        /* renamed from: d */
        final boolean f41226d;

        /* renamed from: e */
        volatile boolean f41227e;

        /* renamed from: f */
        Throwable f41228f;

        /* renamed from: g */
        final AtomicBoolean f41229g = new AtomicBoolean();

        /* renamed from: h */
        final AtomicBoolean f41230h = new AtomicBoolean();

        /* renamed from: i */
        final AtomicReference<C13804t<? super T>> f41231i = new AtomicReference<>();

        C13552c(int bufferSize, C13550a<?, K, T> parent, K key, boolean delayError) {
            this.f41224b = new C13706c<>(bufferSize);
            this.f41225c = parent;
            this.f41223a = key;
            this.f41226d = delayError;
        }

        public void dispose() {
            if (this.f41229g.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f41231i.lazySet(null);
                this.f41225c.mo42566a(this.f41223a);
            }
        }

        public void subscribe(C13804t<? super T> s) {
            if (this.f41230h.compareAndSet(false, true)) {
                s.onSubscribe(this);
                this.f41231i.lazySet(s);
                if (this.f41229g.get()) {
                    this.f41231i.lazySet(null);
                } else {
                    mo42570a();
                }
            } else {
                C13219d.m43157a((Throwable) new IllegalStateException("Only one Observer allowed!"), s);
            }
        }

        /* renamed from: a */
        public void mo42571a(T t) {
            this.f41224b.offer(t);
            mo42570a();
        }

        /* renamed from: a */
        public void mo42572a(Throwable e) {
            this.f41228f = e;
            this.f41227e = true;
            mo42570a();
        }

        /* renamed from: b */
        public void mo42574b() {
            this.f41227e = true;
            mo42570a();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo42570a() {
            if (getAndIncrement() == 0) {
                int missed = 1;
                SpscLinkedArrayQueue<T> q = this.f41224b;
                boolean delayError = this.f41226d;
                Observer<? super T> a = (C13804t) this.f41231i.get();
                while (true) {
                    if (a != null) {
                        while (true) {
                            boolean d = this.f41227e;
                            T v = q.poll();
                            boolean empty = v == null;
                            if (!mo42573a(d, empty, a, delayError)) {
                                if (empty) {
                                    break;
                                }
                                a.onNext(v);
                            } else {
                                return;
                            }
                        }
                    }
                    missed = addAndGet(-missed);
                    if (missed != 0) {
                        if (a == null) {
                            a = (C13804t) this.f41231i.get();
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public boolean mo42573a(boolean d, boolean empty, C13804t<? super T> a, boolean delayError) {
            if (this.f41229g.get()) {
                this.f41224b.clear();
                this.f41225c.mo42566a(this.f41223a);
                this.f41231i.lazySet(null);
                return true;
            }
            if (d) {
                if (!delayError) {
                    Throwable e = this.f41228f;
                    if (e != null) {
                        this.f41224b.clear();
                        this.f41231i.lazySet(null);
                        a.onError(e);
                        return true;
                    } else if (empty) {
                        this.f41231i.lazySet(null);
                        a.onComplete();
                        return true;
                    }
                } else if (empty) {
                    Throwable e2 = this.f41228f;
                    this.f41231i.lazySet(null);
                    if (e2 != null) {
                        a.onError(e2);
                    } else {
                        a.onComplete();
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public C13549ka(C13802r<T> source, C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector, int bufferSize, boolean delayError) {
        super(source);
        this.f41209b = keySelector;
        this.f41210c = valueSelector;
        this.f41211d = bufferSize;
        this.f41212e = delayError;
    }

    public void subscribeActual(C13804t<? super C13763b<K, V>> t) {
        C13802r<T> rVar = this.f41005a;
        C13550a aVar = new C13550a(t, this.f41209b, this.f41210c, this.f41211d, this.f41212e);
        rVar.subscribe(aVar);
    }
}
