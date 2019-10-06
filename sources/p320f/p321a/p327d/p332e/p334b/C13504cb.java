package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p342f.C13770f;

/* renamed from: f.a.d.e.b.cb */
/* compiled from: ObservableSerialized */
public final class C13504cb<T> extends C13485a<T, T> {
    public C13504cb(C13797m<T> upstream) {
        super(upstream);
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f41005a.subscribe(new C13770f(observer));
    }
}
