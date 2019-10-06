package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.qa */
final class C7199qa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7255e f13924a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13925b;

    /* renamed from: c */
    final /* synthetic */ C7267q f13926c;

    C7199qa(C7255e eVar, C7251a aVar, C7267q qVar) {
        this.f13924a = eVar;
        this.f13925b = aVar;
        this.f13926c = qVar;
    }

    public void run() {
        try {
            this.f13924a.userDeclinedToViewAd(C7171ja.m15282b(this.f13925b));
        } catch (Throwable th) {
            this.f13926c.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad reward listener about user declining to view ad", th);
        }
    }
}
