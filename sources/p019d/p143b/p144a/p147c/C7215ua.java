package p019d.p143b.p144a.p147c;

import p019d.p143b.p150d.C7251a;
import p019d.p143b.p150d.C7260j;
import p019d.p143b.p150d.C7267q;

/* renamed from: d.b.a.c.ua */
final class C7215ua implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7260j f13969a;

    /* renamed from: b */
    final /* synthetic */ C7251a f13970b;

    /* renamed from: c */
    final /* synthetic */ double f13971c;

    /* renamed from: d */
    final /* synthetic */ boolean f13972d;

    /* renamed from: e */
    final /* synthetic */ C7267q f13973e;

    C7215ua(C7260j jVar, C7251a aVar, double d, boolean z, C7267q qVar) {
        this.f13969a = jVar;
        this.f13970b = aVar;
        this.f13971c = d;
        this.f13972d = z;
        this.f13973e = qVar;
    }

    public void run() {
        try {
            this.f13969a.videoPlaybackEnded(C7171ja.m15282b(this.f13970b), this.f13971c, this.f13972d);
        } catch (Throwable th) {
            this.f13973e.mo23049b().mo22919c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
        }
    }
}
