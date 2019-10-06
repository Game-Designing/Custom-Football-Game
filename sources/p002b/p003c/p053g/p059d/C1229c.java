package p002b.p003c.p053g.p059d;

import android.os.Handler;
import android.support.p000v4.content.p036a.C0507d.C0508a;
import p002b.p003c.p053g.p059d.C1240k.C1241a;

/* renamed from: b.c.g.d.c */
/* compiled from: FontsContractCompat */
class C1229c implements C1241a<C1235c> {

    /* renamed from: a */
    final /* synthetic */ C0508a f3969a;

    /* renamed from: b */
    final /* synthetic */ Handler f3970b;

    C1229c(C0508a aVar, Handler handler) {
        this.f3969a = aVar;
        this.f3970b = handler;
    }

    /* renamed from: a */
    public void mo8996a(C1235c typeface) {
        if (typeface == null) {
            this.f3969a.mo5287a(1, this.f3970b);
            return;
        }
        int i = typeface.f3985b;
        if (i == 0) {
            this.f3969a.mo5289a(typeface.f3984a, this.f3970b);
        } else {
            this.f3969a.mo5287a(i, this.f3970b);
        }
    }
}
