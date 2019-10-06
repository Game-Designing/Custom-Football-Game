package p320f.p321a.p327d.p332e.p334b;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p320f.p321a.C13761e;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;
import p320f.p321a.C13805u;
import p320f.p321a.C13814z;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13200b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p327d.p329b.C13226a;
import p320f.p321a.p327d.p329b.C13264b;
import p320f.p321a.p327d.p332e.p335c.C13697g;
import p320f.p321a.p341e.C13762a;
import p320f.p321a.p343g.C13774a;

/* renamed from: f.a.d.e.b.pa */
/* compiled from: ObservableInternalHelper */
public final class C13595pa {

    /* renamed from: f.a.d.e.b.pa$a */
    /* compiled from: ObservableInternalHelper */
    static final class C13596a<T> implements Callable<C13762a<T>> {

        /* renamed from: a */
        private final C13797m<T> f41390a;

        /* renamed from: b */
        private final int f41391b;

        C13596a(C13797m<T> parent, int bufferSize) {
            this.f41390a = parent;
            this.f41391b = bufferSize;
        }

        public C13762a<T> call() {
            return this.f41390a.replay(this.f41391b);
        }
    }

    /* renamed from: f.a.d.e.b.pa$b */
    /* compiled from: ObservableInternalHelper */
    static final class C13597b<T> implements Callable<C13762a<T>> {

        /* renamed from: a */
        private final C13797m<T> f41392a;

        /* renamed from: b */
        private final int f41393b;

        /* renamed from: c */
        private final long f41394c;

        /* renamed from: d */
        private final TimeUnit f41395d;

        /* renamed from: e */
        private final C13805u f41396e;

        C13597b(C13797m<T> parent, int bufferSize, long time, TimeUnit unit, C13805u scheduler) {
            this.f41392a = parent;
            this.f41393b = bufferSize;
            this.f41394c = time;
            this.f41395d = unit;
            this.f41396e = scheduler;
        }

        public C13762a<T> call() {
            return this.f41392a.replay(this.f41393b, this.f41394c, this.f41395d, this.f41396e);
        }
    }

    /* renamed from: f.a.d.e.b.pa$c */
    /* compiled from: ObservableInternalHelper */
    static final class C13598c<T, U> implements C13212n<T, C13802r<U>> {

        /* renamed from: a */
        private final C13212n<? super T, ? extends Iterable<? extends U>> f41397a;

        C13598c(C13212n<? super T, ? extends Iterable<? extends U>> mapper) {
            this.f41397a = mapper;
        }

        public C13802r<U> apply(T t) throws Exception {
            Object apply = this.f41397a.apply(t);
            C13264b.m43226a(apply, "The mapper returned a null Iterable");
            return new C13525ga((Iterable) apply);
        }
    }

    /* renamed from: f.a.d.e.b.pa$d */
    /* compiled from: ObservableInternalHelper */
    static final class C13599d<U, R, T> implements C13212n<U, R> {

        /* renamed from: a */
        private final C13201c<? super T, ? super U, ? extends R> f41398a;

        /* renamed from: b */
        private final T f41399b;

        C13599d(C13201c<? super T, ? super U, ? extends R> combiner, T t) {
            this.f41398a = combiner;
            this.f41399b = t;
        }

        public R apply(U w) throws Exception {
            return this.f41398a.apply(this.f41399b, w);
        }
    }

    /* renamed from: f.a.d.e.b.pa$e */
    /* compiled from: ObservableInternalHelper */
    static final class C13600e<T, R, U> implements C13212n<T, C13802r<R>> {

        /* renamed from: a */
        private final C13201c<? super T, ? super U, ? extends R> f41400a;

        /* renamed from: b */
        private final C13212n<? super T, ? extends C13802r<? extends U>> f41401b;

        C13600e(C13201c<? super T, ? super U, ? extends R> combiner, C13212n<? super T, ? extends C13802r<? extends U>> mapper) {
            this.f41400a = combiner;
            this.f41401b = mapper;
        }

        public C13802r<R> apply(T t) throws Exception {
            Object apply = this.f41401b.apply(t);
            C13264b.m43226a(apply, "The mapper returned a null ObservableSource");
            return new C13666xa((C13802r) apply, new C13599d(this.f41400a, t));
        }
    }

    /* renamed from: f.a.d.e.b.pa$f */
    /* compiled from: ObservableInternalHelper */
    static final class C13601f<T, U> implements C13212n<T, C13802r<T>> {

        /* renamed from: a */
        final C13212n<? super T, ? extends C13802r<U>> f41402a;

        C13601f(C13212n<? super T, ? extends C13802r<U>> itemDelay) {
            this.f41402a = itemDelay;
        }

        public C13802r<T> apply(T v) throws Exception {
            Object apply = this.f41402a.apply(v);
            C13264b.m43226a(apply, "The itemDelay returned a null ObservableSource");
            return new C13580nb((C13802r) apply, 1).map(C13226a.m43198c(v)).defaultIfEmpty(v);
        }
    }

    /* renamed from: f.a.d.e.b.pa$g */
    /* compiled from: ObservableInternalHelper */
    static final class C13602g<T, R> implements C13212n<T, C13797m<R>> {

        /* renamed from: a */
        final C13212n<? super T, ? extends C13814z<? extends R>> f41403a;

        C13602g(C13212n<? super T, ? extends C13814z<? extends R>> mapper) {
            this.f41403a = mapper;
        }

        public C13797m<R> apply(T t) throws Exception {
            Object apply = this.f41403a.apply(t);
            C13264b.m43226a(apply, "The mapper returned a null SingleSource");
            return C13774a.m43821a((C13797m<T>) new C13697g<T>((C13814z) apply));
        }
    }

    /* renamed from: f.a.d.e.b.pa$h */
    /* compiled from: ObservableInternalHelper */
    static final class C13603h<T> implements C13199a {

        /* renamed from: a */
        final C13804t<T> f41404a;

        C13603h(C13804t<T> observer) {
            this.f41404a = observer;
        }

        public void run() throws Exception {
            this.f41404a.onComplete();
        }
    }

    /* renamed from: f.a.d.e.b.pa$i */
    /* compiled from: ObservableInternalHelper */
    static final class C13604i<T> implements C13204f<Throwable> {

        /* renamed from: a */
        final C13804t<T> f41405a;

        C13604i(C13804t<T> observer) {
            this.f41405a = observer;
        }

        /* renamed from: a */
        public void accept(Throwable v) throws Exception {
            this.f41405a.onError(v);
        }
    }

    /* renamed from: f.a.d.e.b.pa$j */
    /* compiled from: ObservableInternalHelper */
    static final class C13605j<T> implements C13204f<T> {

        /* renamed from: a */
        final C13804t<T> f41406a;

        C13605j(C13804t<T> observer) {
            this.f41406a = observer;
        }

        public void accept(T v) throws Exception {
            this.f41406a.onNext(v);
        }
    }

    /* renamed from: f.a.d.e.b.pa$k */
    /* compiled from: ObservableInternalHelper */
    static final class C13606k<T> implements Callable<C13762a<T>> {

        /* renamed from: a */
        private final C13797m<T> f41407a;

        C13606k(C13797m<T> parent) {
            this.f41407a = parent;
        }

        public C13762a<T> call() {
            return this.f41407a.replay();
        }
    }

    /* renamed from: f.a.d.e.b.pa$l */
    /* compiled from: ObservableInternalHelper */
    static final class C13607l<T, R> implements C13212n<C13797m<T>, C13802r<R>> {

        /* renamed from: a */
        private final C13212n<? super C13797m<T>, ? extends C13802r<R>> f41408a;

        /* renamed from: b */
        private final C13805u f41409b;

        C13607l(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector, C13805u scheduler) {
            this.f41408a = selector;
            this.f41409b = scheduler;
        }

        /* renamed from: a */
        public C13802r<R> apply(C13797m<T> t) throws Exception {
            Object apply = this.f41408a.apply(t);
            C13264b.m43226a(apply, "The selector returned a null ObservableSource");
            return C13797m.wrap((C13802r) apply).observeOn(this.f41409b);
        }
    }

    /* renamed from: f.a.d.e.b.pa$m */
    /* compiled from: ObservableInternalHelper */
    static final class C13608m<T, S> implements C13201c<S, C13761e<T>, S> {

        /* renamed from: a */
        final C13200b<S, C13761e<T>> f41410a;

        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            mo42615a(obj, (C13761e) obj2);
            return obj;
        }

        C13608m(C13200b<S, C13761e<T>> consumer) {
            this.f41410a = consumer;
        }

        /* renamed from: a */
        public S mo42615a(S t1, C13761e<T> t2) throws Exception {
            this.f41410a.accept(t1, t2);
            return t1;
        }
    }

    /* renamed from: f.a.d.e.b.pa$n */
    /* compiled from: ObservableInternalHelper */
    static final class C13609n<T, S> implements C13201c<S, C13761e<T>, S> {

        /* renamed from: a */
        final C13204f<C13761e<T>> f41411a;

        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            mo42616a(obj, (C13761e) obj2);
            return obj;
        }

        C13609n(C13204f<C13761e<T>> consumer) {
            this.f41411a = consumer;
        }

        /* renamed from: a */
        public S mo42616a(S t1, C13761e<T> t2) throws Exception {
            this.f41411a.accept(t2);
            return t1;
        }
    }

    /* renamed from: f.a.d.e.b.pa$o */
    /* compiled from: ObservableInternalHelper */
    static final class C13610o<T> implements Callable<C13762a<T>> {

        /* renamed from: a */
        private final C13797m<T> f41412a;

        /* renamed from: b */
        private final long f41413b;

        /* renamed from: c */
        private final TimeUnit f41414c;

        /* renamed from: d */
        private final C13805u f41415d;

        C13610o(C13797m<T> parent, long time, TimeUnit unit, C13805u scheduler) {
            this.f41412a = parent;
            this.f41413b = time;
            this.f41414c = unit;
            this.f41415d = scheduler;
        }

        public C13762a<T> call() {
            return this.f41412a.replay(this.f41413b, this.f41414c, this.f41415d);
        }
    }

    /* renamed from: f.a.d.e.b.pa$p */
    /* compiled from: ObservableInternalHelper */
    static final class C13611p<T, R> implements C13212n<List<C13802r<? extends T>>, C13802r<? extends R>> {

        /* renamed from: a */
        private final C13212n<? super Object[], ? extends R> f41416a;

        C13611p(C13212n<? super Object[], ? extends R> zipper) {
            this.f41416a = zipper;
        }

        /* renamed from: a */
        public C13802r<? extends R> apply(List<C13802r<? extends T>> list) {
            return C13797m.zipIterable(list, this.f41416a, false, C13797m.bufferSize());
        }
    }

    /* renamed from: a */
    public static <T, S> C13201c<S, C13761e<T>, S> m43560a(C13204f<C13761e<T>> consumer) {
        return new C13609n(consumer);
    }

    /* renamed from: a */
    public static <T, S> C13201c<S, C13761e<T>, S> m43559a(C13200b<S, C13761e<T>> consumer) {
        return new C13608m(consumer);
    }

    /* renamed from: b */
    public static <T, U> C13212n<T, C13802r<T>> m43570b(C13212n<? super T, ? extends C13802r<U>> itemDelay) {
        return new C13601f(itemDelay);
    }

    /* renamed from: c */
    public static <T> C13204f<T> m43572c(C13804t<T> observer) {
        return new C13605j(observer);
    }

    /* renamed from: b */
    public static <T> C13204f<Throwable> m43569b(C13804t<T> observer) {
        return new C13604i(observer);
    }

    /* renamed from: a */
    public static <T> C13199a m43558a(C13804t<T> observer) {
        return new C13603h(observer);
    }

    /* renamed from: a */
    public static <T, U, R> C13212n<T, C13802r<R>> m43562a(C13212n<? super T, ? extends C13802r<? extends U>> mapper, C13201c<? super T, ? super U, ? extends R> combiner) {
        return new C13600e(combiner, mapper);
    }

    /* renamed from: a */
    public static <T, U> C13212n<T, C13802r<U>> m43561a(C13212n<? super T, ? extends Iterable<? extends U>> mapper) {
        return new C13598c(mapper);
    }

    /* renamed from: a */
    public static <T> Callable<C13762a<T>> m43565a(C13797m<T> parent) {
        return new C13606k(parent);
    }

    /* renamed from: a */
    public static <T> Callable<C13762a<T>> m43566a(C13797m<T> parent, int bufferSize) {
        return new C13596a(parent, bufferSize);
    }

    /* renamed from: a */
    public static <T> Callable<C13762a<T>> m43567a(C13797m<T> parent, int bufferSize, long time, TimeUnit unit, C13805u scheduler) {
        C13597b bVar = new C13597b(parent, bufferSize, time, unit, scheduler);
        return bVar;
    }

    /* renamed from: a */
    public static <T> Callable<C13762a<T>> m43568a(C13797m<T> parent, long time, TimeUnit unit, C13805u scheduler) {
        C13610o oVar = new C13610o(parent, time, unit, scheduler);
        return oVar;
    }

    /* renamed from: a */
    public static <T, R> C13212n<C13797m<T>, C13802r<R>> m43563a(C13212n<? super C13797m<T>, ? extends C13802r<R>> selector, C13805u scheduler) {
        return new C13607l(selector, scheduler);
    }

    /* renamed from: c */
    public static <T, R> C13212n<List<C13802r<? extends T>>, C13802r<? extends R>> m43573c(C13212n<? super Object[], ? extends R> zipper) {
        return new C13611p(zipper);
    }

    /* renamed from: a */
    public static <T, R> C13797m<R> m43564a(C13797m<T> source, C13212n<? super T, ? extends C13814z<? extends R>> mapper) {
        return source.switchMap(m43574d(mapper), 1);
    }

    /* renamed from: b */
    public static <T, R> C13797m<R> m43571b(C13797m<T> source, C13212n<? super T, ? extends C13814z<? extends R>> mapper) {
        return source.switchMapDelayError(m43574d(mapper), 1);
    }

    /* renamed from: d */
    private static <T, R> C13212n<T, C13797m<R>> m43574d(C13212n<? super T, ? extends C13814z<? extends R>> mapper) {
        C13264b.m43226a(mapper, "mapper is null");
        return new C13602g(mapper);
    }
}
