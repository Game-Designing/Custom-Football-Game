package p019d.p143b.p144a.p146b;

import p019d.p143b.p150d.C7262l;

/* renamed from: d.b.a.b.r */
class C7022r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7026t f13103a;

    /* renamed from: b */
    final /* synthetic */ int f13104b;

    /* renamed from: c */
    final /* synthetic */ C7020q f13105c;

    C7022r(C7020q qVar, C7026t tVar, int i) {
        this.f13105c = qVar;
        this.f13103a = tVar;
        this.f13104b = i;
    }

    public void run() {
        C7024s b = this.f13103a.m14544c();
        String str = "CountdownManager";
        if (!b.mo22554b()) {
            C7262l b2 = this.f13105c.f13088a;
            StringBuilder sb = new StringBuilder();
            sb.append("Ending countdown for ");
            sb.append(this.f13103a.m14539a());
            b2.mo22918c(str, sb.toString());
        } else if (this.f13105c.f13091d.get() == this.f13104b) {
            try {
                b.mo22553a();
            } catch (Throwable th) {
                C7262l b3 = this.f13105c.f13088a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Encountered error on countdown step for: ");
                sb2.append(this.f13103a.m14539a());
                b3.mo22917b(str, sb2.toString(), th);
            }
            this.f13105c.m14519a(this.f13103a, this.f13104b);
        } else {
            C7262l b4 = this.f13105c.f13088a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Killing duplicate countdown from previous generation: ");
            sb3.append(this.f13103a.m14539a());
            b4.mo22913a(str, sb3.toString());
        }
    }
}
