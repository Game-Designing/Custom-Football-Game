package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7253c;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.ra */
final class C7203ra implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7253c f13932a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13933b;

    /* renamed from: c */
    final /* synthetic */ C7267q f13934c;

    C7203ra(C7253c cVar, C7251a aVar, C7267q qVar) {
        this.f13932a = cVar;
        this.f13933b = aVar;
        this.f13934c = qVar;
    }

    public void run() {
        try {
            this.f13932a.adHidden(C7171ja.m15282b(this.f13933b));
        } catch (Throwable th) {
            this.f13934c.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
        }
    }
}
