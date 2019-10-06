package p019d.p273h.p276c;

import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.E */
/* compiled from: IronSourceBannerLayout */
class C12743E implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C12799b f39081a;

    /* renamed from: b */
    final /* synthetic */ C12745G f39082b;

    C12743E(C12745G this$0, C12799b bVar) {
        this.f39082b = this$0;
        this.f39081a = bVar;
    }

    public void run() {
        if (this.f39082b.f39090e) {
            this.f39082b.f39091f.mo41629a(this.f39081a);
            return;
        }
        try {
            if (this.f39082b.f39086a != null) {
                this.f39082b.removeView(this.f39082b.f39086a);
                this.f39082b.f39086a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f39082b.f39091f != null) {
            this.f39082b.f39091f.mo41629a(this.f39081a);
        }
    }
}
