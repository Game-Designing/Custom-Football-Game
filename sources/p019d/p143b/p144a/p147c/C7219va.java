package p019d.p143b.p144a.p147c;

import com.applovin.adview.C5856b;
import com.applovin.adview.C5858d;
import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.va */
final class C7219va implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C5858d f13995a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13996b;

    /* renamed from: c */
    final /* synthetic */ C5856b f13997c;

    /* renamed from: d */
    final /* synthetic */ C7267q f13998d;

    C7219va(C5858d dVar, C7251a aVar, C5856b bVar, C7267q qVar) {
        this.f13995a = dVar;
        this.f13996b = aVar;
        this.f13997c = bVar;
        this.f13998d = qVar;
    }

    public void run() {
        try {
            this.f13995a.adOpenedFullscreen(C7171ja.m15282b(this.f13996b), this.f13997c);
        } catch (Throwable th) {
            this.f13998d.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
        }
    }
}
