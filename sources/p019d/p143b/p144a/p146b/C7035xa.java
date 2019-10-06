package p019d.p143b.p144a.p146b;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.b.xa */
class C7035xa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7251a f13128a;

    /* renamed from: b */
    final /* synthetic */ C6988a f13129b;

    C7035xa(C6988a aVar, C7251a aVar2) {
        this.f13129b = aVar;
        this.f13128a = aVar2;
    }

    public void run() {
        try {
            if (this.f13129b.f12982z != null) {
                this.f13129b.f12982z.adReceived(this.f13128a);
            }
        } catch (Throwable th) {
            C7262l b = this.f13129b.f12961e;
            StringBuilder sb = new StringBuilder();
            sb.append("Exception while running ad load callback: ");
            sb.append(th.getMessage());
            b.mo22921e("AppLovinSdk", sb.toString());
        }
    }
}
