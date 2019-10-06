package p019d.p143b.p144a.p147c;

import java.util.Map;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.ma */
final class C7183ma implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7255e f13620a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13621b;

    /* renamed from: c */
    final /* synthetic */ Map f13622c;

    /* renamed from: d */
    final /* synthetic */ C7267q f13623d;

    C7183ma(C7255e eVar, C7251a aVar, Map map, C7267q qVar) {
        this.f13620a = eVar;
        this.f13621b = aVar;
        this.f13622c = map;
        this.f13623d = qVar;
    }

    public void run() {
        try {
            this.f13620a.userRewardVerified(C7171ja.m15282b(this.f13621b), this.f13622c);
        } catch (Throwable th) {
            this.f13623d.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
        }
    }
}
