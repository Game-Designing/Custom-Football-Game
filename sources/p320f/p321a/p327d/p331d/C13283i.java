package p320f.p321a.p327d.p331d;

import io.reactivex.Observer;
import p320f.p321a.C13804t;

/* renamed from: f.a.d.d.i */
/* compiled from: DeferredScalarDisposable */
public class C13283i<T> extends C13276b<T> {

    /* renamed from: a */
    protected final C13804t<? super T> f40369a;

    /* renamed from: b */
    protected T f40370b;

    public C13283i(C13804t<? super T> actual) {
        this.f40369a = actual;
    }

    /* renamed from: a */
    public final int mo42274a(int mode) {
        if ((mode & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    /* renamed from: a */
    public final void mo42327a(T value) {
        int state = get();
        if ((state & 54) == 0) {
            if (state == 8) {
                this.f40370b = value;
                lazySet(16);
            } else {
                lazySet(2);
            }
            Observer<? super T> a = this.f40369a;
            a.onNext(value);
            if (get() != 4) {
                a.onComplete();
            }
        }
    }

    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T v = this.f40370b;
        this.f40370b = null;
        lazySet(32);
        return v;
    }

    public final boolean isEmpty() {
        return get() != 16;
    }

    public final void clear() {
        lazySet(32);
        this.f40370b = null;
    }

    public void dispose() {
        set(4);
        this.f40370b = null;
    }

    /* renamed from: a */
    public final boolean mo42328a() {
        return get() == 4;
    }
}
