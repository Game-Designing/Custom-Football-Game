package p019d.p135a.p136a.p142e;

import android.graphics.Bitmap;
import p002b.p003c.p053g.p061f.C1268l;
import p019d.p135a.p136a.p142e.C6907g.C6908a;
import p320f.p321a.C13804t;
import p320f.p321a.p325b.C13194b;

/* renamed from: d.a.a.e.e */
/* compiled from: AsyncImageDownloader */
class C6905e implements C13804t<C1268l<Bitmap, String>> {

    /* renamed from: a */
    final /* synthetic */ C6908a f12684a;

    C6905e(C6908a aVar) {
        this.f12684a = aVar;
    }

    public void onSubscribe(C13194b d) {
    }

    public void onComplete() {
    }

    public void onError(Throwable e) {
    }

    /* renamed from: a */
    public void onNext(C1268l<Bitmap, String> bitmapStringPair) {
        this.f12684a.mo17708a((Bitmap) bitmapStringPair.f4069a, (String) bitmapStringPair.f4070b);
    }
}
