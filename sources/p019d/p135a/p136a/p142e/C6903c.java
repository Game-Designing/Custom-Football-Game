package p019d.p135a.p136a.p142e;

import android.util.Log;
import java.util.Map;
import p019d.p135a.p136a.p138b.C6856a;
import p320f.p321a.C13799o;
import p320f.p321a.C13800p;

/* renamed from: d.a.a.e.c */
/* compiled from: AsyncHttpClient */
class C6903c implements C13800p<byte[]> {

    /* renamed from: a */
    final /* synthetic */ C6856a f12679a;

    /* renamed from: b */
    final /* synthetic */ String f12680b;

    /* renamed from: c */
    final /* synthetic */ Map f12681c;

    /* renamed from: d */
    final /* synthetic */ String f12682d;

    C6903c(C6856a aVar, String str, Map map, String str2) {
        this.f12679a = aVar;
        this.f12680b = str;
        this.f12681c = map;
        this.f12682d = str2;
    }

    /* renamed from: a */
    public void mo22289a(C13799o<byte[]> subscriber) {
        if (!subscriber.mo42373a()) {
            byte[] response = null;
            try {
                response = this.f12679a.mo22288a(this.f12680b, this.f12681c, this.f12682d);
            } catch (Exception e) {
                Log.e(C6904d.f12683a, "Post failed", e);
                subscriber.onError(e);
            }
            if (response != null) {
                subscriber.onNext(response);
            }
            subscriber.onComplete();
        }
    }
}
