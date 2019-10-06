package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.pa */
final class C7195pa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7255e f13660a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13661b;

    /* renamed from: c */
    final /* synthetic */ int f13662c;

    /* renamed from: d */
    final /* synthetic */ C7267q f13663d;

    C7195pa(C7255e eVar, C7251a aVar, int i, C7267q qVar) {
        this.f13660a = eVar;
        this.f13661b = aVar;
        this.f13662c = i;
        this.f13663d = qVar;
    }

    public void run() {
        try {
            this.f13660a.validationRequestFailed(C7171ja.m15282b(this.f13661b), this.f13662c);
        } catch (Throwable th) {
            this.f13663d.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
        }
    }
}
