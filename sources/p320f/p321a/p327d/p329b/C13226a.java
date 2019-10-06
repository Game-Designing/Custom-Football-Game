package p320f.p321a.p327d.p329b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import p024io.reactivex.exceptions.OnErrorNotImplementedException;
import p320f.p321a.C13795k;
import p320f.p321a.C13805u;
import p320f.p321a.p326c.C13199a;
import p320f.p321a.p326c.C13200b;
import p320f.p321a.p326c.C13201c;
import p320f.p321a.p326c.C13203e;
import p320f.p321a.p326c.C13204f;
import p320f.p321a.p326c.C13205g;
import p320f.p321a.p326c.C13206h;
import p320f.p321a.p326c.C13207i;
import p320f.p321a.p326c.C13208j;
import p320f.p321a.p326c.C13209k;
import p320f.p321a.p326c.C13210l;
import p320f.p321a.p326c.C13211m;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p326c.C13213o;
import p320f.p321a.p326c.C13214p;
import p320f.p321a.p343g.C13774a;
import p320f.p321a.p344h.C13786c;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.b.a */
/* compiled from: Functions */
public final class C13226a {

    /* renamed from: a */
    static final C13212n<Object, Object> f40310a = new C13259v();

    /* renamed from: b */
    public static final Runnable f40311b = new C13254q();

    /* renamed from: c */
    public static final C13199a f40312c = new C13251n();

    /* renamed from: d */
    static final C13204f<Object> f40313d = new C13252o();

    /* renamed from: e */
    public static final C13204f<Throwable> f40314e = new C13256s();

    /* renamed from: f */
    public static final C13204f<Throwable> f40315f = new C13232F();

    /* renamed from: g */
    public static final C13213o f40316g = new C13253p();

    /* renamed from: h */
    static final C13214p<Object> f40317h = new C13237K();

    /* renamed from: i */
    static final C13214p<Object> f40318i = new C13257t();

    /* renamed from: j */
    static final Callable<Object> f40319j = new C13231E();

    /* renamed from: k */
    static final Comparator<Object> f40320k = new C13227A();

    /* renamed from: l */
    public static final C13204f<C14230c> f40321l = new C13262y();

    /* renamed from: f.a.d.b.a$A */
    /* compiled from: Functions */
    static final class C13227A implements Comparator<Object> {
        C13227A() {
        }

        public int compare(Object a, Object b) {
            return ((Comparable) a).compareTo(b);
        }
    }

    /* renamed from: f.a.d.b.a$B */
    /* compiled from: Functions */
    static final class C13228B<T> implements C13199a {

        /* renamed from: a */
        final C13204f<? super C13795k<T>> f40322a;

        C13228B(C13204f<? super C13795k<T>> onNotification) {
            this.f40322a = onNotification;
        }

        public void run() throws Exception {
            this.f40322a.accept(C13795k.m43872a());
        }
    }

    /* renamed from: f.a.d.b.a$C */
    /* compiled from: Functions */
    static final class C13229C<T> implements C13204f<Throwable> {

        /* renamed from: a */
        final C13204f<? super C13795k<T>> f40323a;

        C13229C(C13204f<? super C13795k<T>> onNotification) {
            this.f40323a = onNotification;
        }

        /* renamed from: a */
        public void accept(Throwable v) throws Exception {
            this.f40323a.accept(C13795k.m43874a(v));
        }
    }

    /* renamed from: f.a.d.b.a$D */
    /* compiled from: Functions */
    static final class C13230D<T> implements C13204f<T> {

        /* renamed from: a */
        final C13204f<? super C13795k<T>> f40324a;

        C13230D(C13204f<? super C13795k<T>> onNotification) {
            this.f40324a = onNotification;
        }

        public void accept(T v) throws Exception {
            this.f40324a.accept(C13795k.m43873a(v));
        }
    }

    /* renamed from: f.a.d.b.a$E */
    /* compiled from: Functions */
    static final class C13231E implements Callable<Object> {
        C13231E() {
        }

        public Object call() {
            return null;
        }
    }

    /* renamed from: f.a.d.b.a$F */
    /* compiled from: Functions */
    static final class C13232F implements C13204f<Throwable> {
        C13232F() {
        }

        /* renamed from: a */
        public void accept(Throwable error) {
            C13774a.m43836b((Throwable) new OnErrorNotImplementedException(error));
        }
    }

    /* renamed from: f.a.d.b.a$G */
    /* compiled from: Functions */
    static final class C13233G<T> implements C13212n<T, C13786c<T>> {

        /* renamed from: a */
        final TimeUnit f40325a;

        /* renamed from: b */
        final C13805u f40326b;

        C13233G(TimeUnit unit, C13805u scheduler) {
            this.f40325a = unit;
            this.f40326b = scheduler;
        }

        public C13786c<T> apply(T t) throws Exception {
            return new C13786c<>(t, this.f40326b.mo43147a(this.f40325a), this.f40325a);
        }
    }

    /* renamed from: f.a.d.b.a$H */
    /* compiled from: Functions */
    static final class C13234H<K, T> implements C13200b<Map<K, T>, T> {

        /* renamed from: a */
        private final C13212n<? super T, ? extends K> f40327a;

        C13234H(C13212n<? super T, ? extends K> keySelector) {
            this.f40327a = keySelector;
        }

        /* renamed from: a */
        public void accept(Map<K, T> m, T t) throws Exception {
            m.put(this.f40327a.apply(t), t);
        }
    }

    /* renamed from: f.a.d.b.a$I */
    /* compiled from: Functions */
    static final class C13235I<K, V, T> implements C13200b<Map<K, V>, T> {

        /* renamed from: a */
        private final C13212n<? super T, ? extends V> f40328a;

        /* renamed from: b */
        private final C13212n<? super T, ? extends K> f40329b;

        C13235I(C13212n<? super T, ? extends V> valueSelector, C13212n<? super T, ? extends K> keySelector) {
            this.f40328a = valueSelector;
            this.f40329b = keySelector;
        }

        /* renamed from: a */
        public void accept(Map<K, V> m, T t) throws Exception {
            m.put(this.f40329b.apply(t), this.f40328a.apply(t));
        }
    }

    /* renamed from: f.a.d.b.a$J */
    /* compiled from: Functions */
    static final class C13236J<K, V, T> implements C13200b<Map<K, Collection<V>>, T> {

        /* renamed from: a */
        private final C13212n<? super K, ? extends Collection<? super V>> f40330a;

        /* renamed from: b */
        private final C13212n<? super T, ? extends V> f40331b;

        /* renamed from: c */
        private final C13212n<? super T, ? extends K> f40332c;

        C13236J(C13212n<? super K, ? extends Collection<? super V>> collectionFactory, C13212n<? super T, ? extends V> valueSelector, C13212n<? super T, ? extends K> keySelector) {
            this.f40330a = collectionFactory;
            this.f40331b = valueSelector;
            this.f40332c = keySelector;
        }

        /* renamed from: a */
        public void accept(Map<K, Collection<V>> m, T t) throws Exception {
            K key = this.f40332c.apply(t);
            Collection<V> coll = (Collection) m.get(key);
            if (coll == null) {
                coll = (Collection) this.f40330a.apply(key);
                m.put(key, coll);
            }
            coll.add(this.f40331b.apply(t));
        }
    }

    /* renamed from: f.a.d.b.a$K */
    /* compiled from: Functions */
    static final class C13237K implements C13214p<Object> {
        C13237K() {
        }

        public boolean test(Object o) {
            return true;
        }
    }

    /* renamed from: f.a.d.b.a$a */
    /* compiled from: Functions */
    static final class C13238a<T> implements C13204f<T> {

        /* renamed from: a */
        final C13199a f40333a;

        C13238a(C13199a action) {
            this.f40333a = action;
        }

        public void accept(T t) throws Exception {
            this.f40333a.run();
        }
    }

    /* renamed from: f.a.d.b.a$b */
    /* compiled from: Functions */
    static final class C13239b<T1, T2, R> implements C13212n<Object[], R> {

        /* renamed from: a */
        final C13201c<? super T1, ? super T2, ? extends R> f40334a;

        C13239b(C13201c<? super T1, ? super T2, ? extends R> f) {
            this.f40334a = f;
        }

        /* renamed from: a */
        public R apply(Object[] a) throws Exception {
            if (a.length == 2) {
                return this.f40334a.apply(a[0], a[1]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 2 expected but got ");
            sb.append(a.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f.a.d.b.a$c */
    /* compiled from: Functions */
    static final class C13240c<T1, T2, T3, R> implements C13212n<Object[], R> {

        /* renamed from: a */
        final C13205g<T1, T2, T3, R> f40335a;

        C13240c(C13205g<T1, T2, T3, R> f) {
            this.f40335a = f;
        }

        /* renamed from: a */
        public R apply(Object[] a) throws Exception {
            if (a.length == 3) {
                return this.f40335a.mo42265a(a[0], a[1], a[2]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 3 expected but got ");
            sb.append(a.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f.a.d.b.a$d */
    /* compiled from: Functions */
    static final class C13241d<T1, T2, T3, T4, R> implements C13212n<Object[], R> {

        /* renamed from: a */
        final C13206h<T1, T2, T3, T4, R> f40336a;

        C13241d(C13206h<T1, T2, T3, T4, R> f) {
            this.f40336a = f;
        }

        /* renamed from: a */
        public R apply(Object[] a) throws Exception {
            if (a.length == 4) {
                return this.f40336a.mo42266a(a[0], a[1], a[2], a[3]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 4 expected but got ");
            sb.append(a.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f.a.d.b.a$e */
    /* compiled from: Functions */
    static final class C13242e<T1, T2, T3, T4, T5, R> implements C13212n<Object[], R> {

        /* renamed from: a */
        private final C13207i<T1, T2, T3, T4, T5, R> f40337a;

        C13242e(C13207i<T1, T2, T3, T4, T5, R> f) {
            this.f40337a = f;
        }

        /* renamed from: a */
        public R apply(Object[] a) throws Exception {
            if (a.length == 5) {
                return this.f40337a.mo42267a(a[0], a[1], a[2], a[3], a[4]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 5 expected but got ");
            sb.append(a.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f.a.d.b.a$f */
    /* compiled from: Functions */
    static final class C13243f<T1, T2, T3, T4, T5, T6, R> implements C13212n<Object[], R> {

        /* renamed from: a */
        final C13208j<T1, T2, T3, T4, T5, T6, R> f40338a;

        C13243f(C13208j<T1, T2, T3, T4, T5, T6, R> f) {
            this.f40338a = f;
        }

        /* renamed from: a */
        public R apply(Object[] a) throws Exception {
            if (a.length == 6) {
                return this.f40338a.mo42268a(a[0], a[1], a[2], a[3], a[4], a[5]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 6 expected but got ");
            sb.append(a.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f.a.d.b.a$g */
    /* compiled from: Functions */
    static final class C13244g<T1, T2, T3, T4, T5, T6, T7, R> implements C13212n<Object[], R> {

        /* renamed from: a */
        final C13209k<T1, T2, T3, T4, T5, T6, T7, R> f40339a;

        C13244g(C13209k<T1, T2, T3, T4, T5, T6, T7, R> f) {
            this.f40339a = f;
        }

        /* renamed from: a */
        public R apply(Object[] a) throws Exception {
            if (a.length == 7) {
                return this.f40339a.mo42269a(a[0], a[1], a[2], a[3], a[4], a[5], a[6]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 7 expected but got ");
            sb.append(a.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f.a.d.b.a$h */
    /* compiled from: Functions */
    static final class C13245h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements C13212n<Object[], R> {

        /* renamed from: a */
        final C13210l<T1, T2, T3, T4, T5, T6, T7, T8, R> f40340a;

        C13245h(C13210l<T1, T2, T3, T4, T5, T6, T7, T8, R> f) {
            this.f40340a = f;
        }

        /* renamed from: a */
        public R apply(Object[] a) throws Exception {
            if (a.length == 8) {
                return this.f40340a.mo42270a(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 8 expected but got ");
            sb.append(a.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f.a.d.b.a$i */
    /* compiled from: Functions */
    static final class C13246i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements C13212n<Object[], R> {

        /* renamed from: a */
        final C13211m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f40341a;

        C13246i(C13211m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f) {
            this.f40341a = f;
        }

        /* renamed from: a */
        public R apply(Object[] a) throws Exception {
            if (a.length == 9) {
                return this.f40341a.mo42271a(a[0], a[1], a[2], a[3], a[4], a[5], a[6], a[7], a[8]);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Array of size 9 expected but got ");
            sb.append(a.length);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: f.a.d.b.a$j */
    /* compiled from: Functions */
    static final class C13247j<T> implements Callable<List<T>> {

        /* renamed from: a */
        final int f40342a;

        C13247j(int capacity) {
            this.f40342a = capacity;
        }

        public List<T> call() throws Exception {
            return new ArrayList(this.f40342a);
        }
    }

    /* renamed from: f.a.d.b.a$k */
    /* compiled from: Functions */
    static final class C13248k<T> implements C13214p<T> {

        /* renamed from: a */
        final C13203e f40343a;

        C13248k(C13203e supplier) {
            this.f40343a = supplier;
        }

        public boolean test(T t) throws Exception {
            return !this.f40343a.getAsBoolean();
        }
    }

    /* renamed from: f.a.d.b.a$l */
    /* compiled from: Functions */
    static final class C13249l<T, U> implements C13212n<T, U> {

        /* renamed from: a */
        final Class<U> f40344a;

        C13249l(Class<U> clazz) {
            this.f40344a = clazz;
        }

        public U apply(T t) throws Exception {
            return this.f40344a.cast(t);
        }
    }

    /* renamed from: f.a.d.b.a$m */
    /* compiled from: Functions */
    static final class C13250m<T, U> implements C13214p<T> {

        /* renamed from: a */
        final Class<U> f40345a;

        C13250m(Class<U> clazz) {
            this.f40345a = clazz;
        }

        public boolean test(T t) throws Exception {
            return this.f40345a.isInstance(t);
        }
    }

    /* renamed from: f.a.d.b.a$n */
    /* compiled from: Functions */
    static final class C13251n implements C13199a {
        C13251n() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* renamed from: f.a.d.b.a$o */
    /* compiled from: Functions */
    static final class C13252o implements C13204f<Object> {
        C13252o() {
        }

        public void accept(Object v) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* renamed from: f.a.d.b.a$p */
    /* compiled from: Functions */
    static final class C13253p implements C13213o {
        C13253p() {
        }
    }

    /* renamed from: f.a.d.b.a$q */
    /* compiled from: Functions */
    static final class C13254q implements Runnable {
        C13254q() {
        }

        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* renamed from: f.a.d.b.a$r */
    /* compiled from: Functions */
    static final class C13255r<T> implements C13214p<T> {

        /* renamed from: a */
        final T f40346a;

        C13255r(T value) {
            this.f40346a = value;
        }

        public boolean test(T t) throws Exception {
            return C13264b.m43227a((Object) t, (Object) this.f40346a);
        }
    }

    /* renamed from: f.a.d.b.a$s */
    /* compiled from: Functions */
    static final class C13256s implements C13204f<Throwable> {
        C13256s() {
        }

        /* renamed from: a */
        public void accept(Throwable error) {
            C13774a.m43836b(error);
        }
    }

    /* renamed from: f.a.d.b.a$t */
    /* compiled from: Functions */
    static final class C13257t implements C13214p<Object> {
        C13257t() {
        }

        public boolean test(Object o) {
            return false;
        }
    }

    /* renamed from: f.a.d.b.a$u */
    /* compiled from: Functions */
    enum C13258u implements Callable<Set<Object>> {
        INSTANCE;

        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* renamed from: f.a.d.b.a$v */
    /* compiled from: Functions */
    static final class C13259v implements C13212n<Object, Object> {
        C13259v() {
        }

        public Object apply(Object v) {
            return v;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* renamed from: f.a.d.b.a$w */
    /* compiled from: Functions */
    static final class C13260w<T, U> implements Callable<U>, C13212n<T, U> {

        /* renamed from: a */
        final U f40349a;

        C13260w(U value) {
            this.f40349a = value;
        }

        public U call() throws Exception {
            return this.f40349a;
        }

        public U apply(T t) throws Exception {
            return this.f40349a;
        }
    }

    /* renamed from: f.a.d.b.a$x */
    /* compiled from: Functions */
    static final class C13261x<T> implements C13212n<List<T>, List<T>> {

        /* renamed from: a */
        final Comparator<? super T> f40350a;

        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            List list = (List) obj;
            mo42313a(list);
            return list;
        }

        C13261x(Comparator<? super T> comparator) {
            this.f40350a = comparator;
        }

        /* renamed from: a */
        public List<T> mo42313a(List<T> v) {
            Collections.sort(v, this.f40350a);
            return v;
        }
    }

    /* renamed from: f.a.d.b.a$y */
    /* compiled from: Functions */
    static final class C13262y implements C13204f<C14230c> {
        C13262y() {
        }

        /* renamed from: a */
        public void accept(C14230c t) throws Exception {
            t.request(Long.MAX_VALUE);
        }
    }

    /* renamed from: f.a.d.b.a$z */
    /* compiled from: Functions */
    enum C13263z implements Comparator<Object> {
        INSTANCE;

        public int compare(Object o1, Object o2) {
            return ((Comparable) o1).compareTo(o2);
        }
    }

    /* renamed from: a */
    public static <T1, T2, R> C13212n<Object[], R> m43178a(C13201c<? super T1, ? super T2, ? extends R> f) {
        C13264b.m43226a(f, "f is null");
        return new C13239b(f);
    }

    /* renamed from: a */
    public static <T1, T2, T3, R> C13212n<Object[], R> m43179a(C13205g<T1, T2, T3, R> f) {
        C13264b.m43226a(f, "f is null");
        return new C13240c(f);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, R> C13212n<Object[], R> m43180a(C13206h<T1, T2, T3, T4, R> f) {
        C13264b.m43226a(f, "f is null");
        return new C13241d(f);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, R> C13212n<Object[], R> m43181a(C13207i<T1, T2, T3, T4, T5, R> f) {
        C13264b.m43226a(f, "f is null");
        return new C13242e(f);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, R> C13212n<Object[], R> m43182a(C13208j<T1, T2, T3, T4, T5, T6, R> f) {
        C13264b.m43226a(f, "f is null");
        return new C13243f(f);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, R> C13212n<Object[], R> m43183a(C13209k<T1, T2, T3, T4, T5, T6, T7, R> f) {
        C13264b.m43226a(f, "f is null");
        return new C13244g(f);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> C13212n<Object[], R> m43184a(C13210l<T1, T2, T3, T4, T5, T6, T7, T8, R> f) {
        C13264b.m43226a(f, "f is null");
        return new C13245h(f);
    }

    /* renamed from: a */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> C13212n<Object[], R> m43185a(C13211m<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f) {
        C13264b.m43226a(f, "f is null");
        return new C13246i(f);
    }

    /* renamed from: e */
    public static <T> C13212n<T, T> m43201e() {
        return f40310a;
    }

    /* renamed from: d */
    public static <T> C13204f<T> m43200d() {
        return f40313d;
    }

    /* renamed from: b */
    public static <T> C13214p<T> m43194b() {
        return f40317h;
    }

    /* renamed from: a */
    public static <T> C13214p<T> m43189a() {
        return f40318i;
    }

    /* renamed from: h */
    public static <T> Callable<T> m43204h() {
        return f40319j;
    }

    /* renamed from: g */
    public static <T> Comparator<T> m43203g() {
        return f40320k;
    }

    /* renamed from: b */
    public static <T> Callable<T> m43196b(T value) {
        return new C13260w(value);
    }

    /* renamed from: c */
    public static <T, U> C13212n<T, U> m43198c(U value) {
        return new C13260w(value);
    }

    /* renamed from: a */
    public static <T, U> C13212n<T, U> m43186a(Class<U> target) {
        return new C13249l(target);
    }

    /* renamed from: a */
    public static <T> Callable<List<T>> m43192a(int capacity) {
        return new C13247j(capacity);
    }

    /* renamed from: a */
    public static <T> C13214p<T> m43191a(T value) {
        return new C13255r(value);
    }

    /* renamed from: c */
    public static <T> Callable<Set<T>> m43199c() {
        return C13258u.INSTANCE;
    }

    /* renamed from: c */
    public static <T> C13204f<T> m43197c(C13204f<? super C13795k<T>> onNotification) {
        return new C13230D(onNotification);
    }

    /* renamed from: b */
    public static <T> C13204f<Throwable> m43193b(C13204f<? super C13795k<T>> onNotification) {
        return new C13229C(onNotification);
    }

    /* renamed from: a */
    public static <T> C13199a m43173a(C13204f<? super C13795k<T>> onNotification) {
        return new C13228B(onNotification);
    }

    /* renamed from: a */
    public static <T> C13204f<T> m43177a(C13199a action) {
        return new C13238a(action);
    }

    /* renamed from: b */
    public static <T, U> C13214p<T> m43195b(Class<U> clazz) {
        return new C13250m(clazz);
    }

    /* renamed from: a */
    public static <T> C13214p<T> m43190a(C13203e supplier) {
        return new C13248k(supplier);
    }

    /* renamed from: a */
    public static <T> C13212n<T, C13786c<T>> m43188a(TimeUnit unit, C13805u scheduler) {
        return new C13233G(unit, scheduler);
    }

    /* renamed from: a */
    public static <T, K> C13200b<Map<K, T>, T> m43174a(C13212n<? super T, ? extends K> keySelector) {
        return new C13234H(keySelector);
    }

    /* renamed from: a */
    public static <T, K, V> C13200b<Map<K, V>, T> m43175a(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector) {
        return new C13235I(valueSelector, keySelector);
    }

    /* renamed from: a */
    public static <T, K, V> C13200b<Map<K, Collection<V>>, T> m43176a(C13212n<? super T, ? extends K> keySelector, C13212n<? super T, ? extends V> valueSelector, C13212n<? super K, ? extends Collection<? super V>> collectionFactory) {
        return new C13236J(collectionFactory, valueSelector, keySelector);
    }

    /* renamed from: f */
    public static <T> Comparator<T> m43202f() {
        return C13263z.INSTANCE;
    }

    /* renamed from: a */
    public static <T> C13212n<List<T>, List<T>> m43187a(Comparator<? super T> comparator) {
        return new C13261x(comparator);
    }
}
