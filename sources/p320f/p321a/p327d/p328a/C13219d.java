package p320f.p321a.p327d.p328a;

import p320f.p321a.C13804t;
import p320f.p321a.C13812x;
import p320f.p321a.p327d.p330c.C13269d;

/* renamed from: f.a.d.a.d */
/* compiled from: EmptyDisposable */
public enum C13219d implements C13269d<Object> {
    INSTANCE,
    NEVER;

    public void dispose() {
    }

    /* renamed from: a */
    public static void m43156a(C13804t<?> s) {
        s.onSubscribe(INSTANCE);
        s.onComplete();
    }

    /* renamed from: a */
    public static void m43157a(Throwable e, C13804t<?> s) {
        s.onSubscribe(INSTANCE);
        s.onError(e);
    }

    /* renamed from: a */
    public static void m43158a(Throwable e, C13812x<?> s) {
        s.onSubscribe(INSTANCE);
        s.onError(e);
    }

    public boolean offer(Object value) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public Object poll() throws Exception {
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public void clear() {
    }

    /* renamed from: a */
    public int mo42274a(int mode) {
        return mode & 2;
    }
}
