package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.ta */
final class C7211ta implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7260j f13962a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13963b;

    /* renamed from: c */
    final /* synthetic */ C7267q f13964c;

    C7211ta(C7260j jVar, C7251a aVar, C7267q qVar) {
        this.f13962a = jVar;
        this.f13963b = aVar;
        this.f13964c = qVar;
    }

    public void run() {
        try {
            this.f13962a.videoPlaybackBegan(C7171ja.m15282b(this.f13963b));
        } catch (Throwable th) {
            this.f13964c.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
        }
    }
}
