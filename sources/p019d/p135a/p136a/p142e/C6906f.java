package p019d.p135a.p136a.p142e;

import android.content.Context;
import android.graphics.Bitmap;
import p002b.p003c.p053g.p061f.C1268l;
import p320f.p321a.C13799o;
import p320f.p321a.C13800p;

/* renamed from: d.a.a.e.f */
/* compiled from: AsyncImageDownloader */
class C6906f implements C13800p<C1268l<Bitmap, String>> {

    /* renamed from: a */
    final /* synthetic */ Context f12685a;

    /* renamed from: b */
    final /* synthetic */ String f12686b;

    /* renamed from: c */
    final /* synthetic */ Bitmap f12687c;

    C6906f(Context context, String str, Bitmap bitmap) {
        this.f12685a = context;
        this.f12686b = str;
        this.f12687c = bitmap;
    }

    /* renamed from: a */
    public void mo22289a(C13799o<C1268l<Bitmap, String>> subscriber) {
        if (!subscriber.mo42373a()) {
            Bitmap icon = C6907g.m14050c(this.f12685a, this.f12686b, this.f12687c);
            if (icon != null) {
                subscriber.onNext(new C1268l(icon, this.f12686b));
            }
            subscriber.onComplete();
        }
    }
}
