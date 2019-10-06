package p019d.p273h.p276c;

/* renamed from: d.h.c.M */
/* compiled from: MediationInitializer */
class C12752M implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12753N f39146a;

    C12752M(C12753N this$0) {
        this.f39146a = this$0;
    }

    public void run() {
        C12753N n = this.f39146a;
        C12751L l = new C12751L(this, 60000, 15000);
        n.f39164q = l.start();
    }
}
