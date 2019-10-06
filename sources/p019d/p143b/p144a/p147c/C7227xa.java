package p019d.p143b.p144a.p147c;

import com.applovin.adview.C5856b;
import com.applovin.adview.C5858d;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.xa */
final class C7227xa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5858d f14019a;

    /* renamed from: b */
    final /* synthetic */ C7251a f14020b;

    /* renamed from: c */
    final /* synthetic */ C5856b f14021c;

    /* renamed from: d */
    final /* synthetic */ C7267q f14022d;

    C7227xa(C5858d dVar, C7251a aVar, C5856b bVar, C7267q qVar) {
        this.f14019a = dVar;
        this.f14020b = aVar;
        this.f14021c = bVar;
        this.f14022d = qVar;
    }

    public void run() {
        try {
            this.f14019a.adLeftApplication(C7171ja.m15282b(this.f14020b), this.f14021c);
        } catch (Throwable th) {
            this.f14022d.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
        }
    }
}
