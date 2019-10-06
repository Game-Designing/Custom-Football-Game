package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7252b;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.sa */
final class C7207sa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7252b f13949a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13950b;

    /* renamed from: c */
    final /* synthetic */ C7267q f13951c;

    C7207sa(C7252b bVar, C7251a aVar, C7267q qVar) {
        this.f13949a = bVar;
        this.f13950b = aVar;
        this.f13951c = qVar;
    }

    public void run() {
        try {
            this.f13949a.adClicked(C7171ja.m15282b(this.f13950b));
        } catch (Throwable th) {
            this.f13951c.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
        }
    }
}
