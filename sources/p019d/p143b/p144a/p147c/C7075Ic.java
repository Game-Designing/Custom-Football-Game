package p019d.p143b.p144a.p147c;

import android.net.Uri;
import com.applovin.adview.C5856b;
import p019d.p143b.p144a.p146b.C6988a;
import p019d.p143b.p150d.C7264n;

/* renamed from: d.b.a.c.Ic */
class C7075Ic implements C7264n {

    /* renamed from: a */
    final /* synthetic */ C6988a f13250a;

    /* renamed from: b */
    final /* synthetic */ Uri f13251b;

    /* renamed from: c */
    final /* synthetic */ C7234z f13252c;

    /* renamed from: d */
    final /* synthetic */ C5856b f13253d;

    /* renamed from: e */
    final /* synthetic */ C7134a f13254e;

    C7075Ic(C7134a aVar, C6988a aVar2, Uri uri, C7234z zVar, C5856b bVar) {
        this.f13254e = aVar;
        this.f13250a = aVar2;
        this.f13251b = uri;
        this.f13252c = zVar;
        this.f13253d = bVar;
    }

    public void onPostbackFailure(String str, int i) {
        this.f13254e.f13436g.post(new C7083Kc(this));
    }

    public void onPostbackSuccess(String str) {
        this.f13254e.f13436g.post(new C7079Jc(this));
    }
}
