package p019d.p135a.p136a.p142e;

import p019d.p135a.p136a.p137a.C6845a;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;

/* renamed from: d.a.a.e.b */
/* compiled from: AsyncHttpClient */
class C6902b implements C13804t<byte[]> {

    /* renamed from: a */
    final /* synthetic */ C6845a f12678a;

    C6902b(C6845a aVar) {
        this.f12678a = aVar;
    }

    public void onSubscribe(C13194b d) {
    }

    public void onComplete() {
    }

    public void onError(Throwable e) {
        this.f12678a.mo22277a(e);
    }

    /* renamed from: a */
    public void onNext(byte[] response) {
        this.f12678a.mo22278a(response);
    }
}
