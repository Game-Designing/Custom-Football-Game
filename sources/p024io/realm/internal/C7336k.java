package p024io.realm.internal;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p024io.realm.internal.C7336k.C7338b;

/* renamed from: io.realm.internal.k */
/* compiled from: ObserverPairList */
public class C7336k<T extends C7338b> {

    /* renamed from: a */
    private List<T> f14316a = new CopyOnWriteArrayList();

    /* renamed from: b */
    private boolean f14317b = false;

    /* renamed from: io.realm.internal.k$a */
    /* compiled from: ObserverPairList */
    public interface C7337a<T extends C7338b> {
        /* renamed from: a */
        void mo23567a(T t, Object obj);
    }

    /* renamed from: io.realm.internal.k$b */
    /* compiled from: ObserverPairList */
    public static abstract class C7338b<T, S> {

        /* renamed from: a */
        final WeakReference<T> f14318a;

        /* renamed from: b */
        protected final S f14319b;

        /* renamed from: c */
        boolean f14320c = false;

        C7338b(T observer, S listener) {
            this.f14319b = listener;
            this.f14318a = new WeakReference<>(observer);
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C7338b)) {
                return false;
            }
            C7338b anotherPair = (C7338b) obj;
            if (!this.f14319b.equals(anotherPair.f14319b) || this.f14318a.get() != anotherPair.f14318a.get()) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            T observer = this.f14318a.get();
            int i = 0;
            int result = ((17 * 31) + (observer != null ? observer.hashCode() : 0)) * 31;
            S s = this.f14319b;
            if (s != null) {
                i = s.hashCode();
            }
            return result + i;
        }
    }

    /* renamed from: a */
    public void mo23780a(C7337a<T> callback) {
        for (T pair : this.f14316a) {
            if (!this.f14317b) {
                Object observer = pair.f14318a.get();
                if (observer == null) {
                    this.f14316a.remove(pair);
                } else if (!pair.f14320c) {
                    callback.mo23567a(pair, observer);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public boolean mo23784b() {
        return this.f14316a.isEmpty();
    }

    /* renamed from: a */
    public void mo23779a() {
        this.f14317b = true;
        this.f14316a.clear();
    }

    /* renamed from: a */
    public void mo23781a(T pair) {
        if (!this.f14316a.contains(pair)) {
            this.f14316a.add(pair);
            pair.f14320c = false;
        }
        if (this.f14317b) {
            this.f14317b = false;
        }
    }

    /* renamed from: a */
    public <S, U> void mo23783a(S observer, U listener) {
        for (T pair : this.f14316a) {
            if (observer == pair.f14318a.get() && listener.equals(pair.f14319b)) {
                pair.f14320c = true;
                this.f14316a.remove(pair);
                return;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo23782a(Object observer) {
        for (T pair : this.f14316a) {
            Object object = pair.f14318a.get();
            if (object == null || object == observer) {
                pair.f14320c = true;
                this.f14316a.remove(pair);
            }
        }
    }

    /* renamed from: c */
    public int mo23785c() {
        return this.f14316a.size();
    }
}
