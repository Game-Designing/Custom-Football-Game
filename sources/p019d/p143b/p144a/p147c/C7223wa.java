package p019d.p143b.p144a.p147c;

import com.applovin.adview.C5856b;
import com.applovin.adview.C5858d;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.wa */
final class C7223wa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5858d f14012a;

    /* renamed from: b */
    final /* synthetic */ C7251a f14013b;

    /* renamed from: c */
    final /* synthetic */ C5856b f14014c;

    /* renamed from: d */
    final /* synthetic */ C7267q f14015d;

    C7223wa(C5858d dVar, C7251a aVar, C5856b bVar, C7267q qVar) {
        this.f14012a = dVar;
        this.f14013b = aVar;
        this.f14014c = bVar;
        this.f14015d = qVar;
    }

    public void run() {
        try {
            this.f14012a.adClosedFullscreen(C7171ja.m15282b(this.f14013b), this.f14014c);
        } catch (Throwable th) {
            this.f14015d.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
        }
    }
}
