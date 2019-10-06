package p019d.p143b.p144a.p146b;

import p019d.p143b.p144a.p147c.C7234z;

/* renamed from: d.b.a.b.f */
class C6998f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7234z f13000a;

    /* renamed from: b */
    final /* synthetic */ C6957Ga f13001b;

    C6998f(C6957Ga ga, C7234z zVar) {
        this.f13001b = ga;
        this.f13000a = zVar;
    }

    public void run() {
        this.f13001b.getSettings().setMediaPlaybackRequiresUserGesture(this.f13000a.mo23418X());
    }
}
