package p026rx.p390c.p391a;

import p026rx.C14508U;

/* renamed from: rx.c.a.Ta */
/* compiled from: OperatorSwitch */
class C14625Ta implements C14508U {

    /* renamed from: a */
    final /* synthetic */ C14621d f43563a;

    C14625Ta(C14621d dVar) {
        this.f43563a = dVar;
    }

    public void request(long n) {
        if (n > 0) {
            this.f43563a.mo45782a(n);
        } else if (n < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("n >= 0 expected but it was ");
            sb.append(n);
            throw new IllegalArgumentException(sb.toString());
        }
    }
}
