package p019d.p143b.p144a.p147c;

import java.util.Map;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.oa */
final class C7191oa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7255e f13652a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13653b;

    /* renamed from: c */
    final /* synthetic */ Map f13654c;

    /* renamed from: d */
    final /* synthetic */ C7267q f13655d;

    C7191oa(C7255e eVar, C7251a aVar, Map map, C7267q qVar) {
        this.f13652a = eVar;
        this.f13653b = aVar;
        this.f13654c = map;
        this.f13655d = qVar;
    }

    public void run() {
        try {
            this.f13652a.userRewardRejected(C7171ja.m15282b(this.f13653b), this.f13654c);
        } catch (Throwable th) {
            this.f13655d.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
        }
    }
}
