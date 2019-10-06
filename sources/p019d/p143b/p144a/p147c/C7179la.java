package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.la */
final class C7179la implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7253c f13613a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13614b;

    /* renamed from: c */
    final /* synthetic */ C7267q f13615c;

    C7179la(C7253c cVar, C7251a aVar, C7267q qVar) {
        this.f13613a = cVar;
        this.f13614b = aVar;
        this.f13615c = qVar;
    }

    public void run() {
        try {
            this.f13613a.adDisplayed(C7171ja.m15282b(this.f13614b));
        } catch (Throwable th) {
            this.f13615c.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
        }
    }
}
