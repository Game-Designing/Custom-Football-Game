package p320f.p321a.p327d.p332e.p334b;

import p320f.p321a.C13797m;
import p320f.p321a.C13802r;
import p320f.p321a.C13804t;

/* renamed from: f.a.d.e.b.ia */
/* compiled from: ObservableFromUnsafeSource */
public final class C13538ia<T> extends C13797m<T> {

    /* renamed from: a */
    final C13802r<T> f41176a;

    public C13538ia(C13802r<T> source) {
        this.f41176a = source;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(C13804t<? super T> observer) {
        this.f41176a.subscribe(observer);
    }
}
