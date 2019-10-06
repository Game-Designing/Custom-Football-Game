package p320f.p321a.p327d.p340j;

import p320f.p321a.C13198c;
import p320f.p321a.C13773g;
import p320f.p321a.C13787i;
import p320f.p321a.C13804t;
import p320f.p321a.C13812x;
import p320f.p321a.p325b.C13194b;
import p320f.p321a.p343g.C13774a;
import p363i.p368b.C14230c;

/* renamed from: f.a.d.j.g */
/* compiled from: EmptyComponent */
public enum C13745g implements C13773g<Object>, C13804t<Object>, C13787i<Object>, C13812x<Object>, C13198c, C14230c, C13194b {
    INSTANCE;

    /* renamed from: e */
    public static <T> C13804t<T> m43755e() {
        return INSTANCE;
    }

    public void dispose() {
    }

    public void request(long n) {
    }

    public void cancel() {
    }

    public void onSubscribe(C13194b d) {
        d.dispose();
    }

    /* renamed from: a */
    public void mo42355a(C14230c s) {
        s.cancel();
    }

    public void onNext(Object t) {
    }

    public void onError(Throwable t) {
        C13774a.m43836b(t);
    }

    public void onComplete() {
    }

    public void onSuccess(Object value) {
    }
}
