package p019d.p143b.p144a.p147c;

import java.util.Map;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7255e;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.na */
final class C7187na implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7255e f13630a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13631b;

    /* renamed from: c */
    final /* synthetic */ Map f13632c;

    /* renamed from: d */
    final /* synthetic */ C7267q f13633d;

    C7187na(C7255e eVar, C7251a aVar, Map map, C7267q qVar) {
        this.f13630a = eVar;
        this.f13631b = aVar;
        this.f13632c = map;
        this.f13633d = qVar;
    }

    public void run() {
        try {
            this.f13630a.userOverQuota(C7171ja.m15282b(this.f13631b), this.f13632c);
        } catch (Throwable th) {
            this.f13633d.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
        }
    }
}
