package p019d.p273h.p276c;

import java.util.TimerTask;
import p019d.p273h.p276c.p280d.C12799b;

/* renamed from: d.h.c.m */
/* compiled from: BannerSmash */
class C12930m extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C12932n f39793a;

    C12930m(C12932n this$0) {
        this.f39793a = this$0;
    }

    public void run() {
        cancel();
        String str = "Timed out";
        if (this.f39793a.f39799e == C12933a.INIT_IN_PROGRESS) {
            this.f39793a.m42062a("init timed out");
            this.f39793a.f39800f.mo41631a(new C12799b(607, str), this.f39793a, false);
        } else if (this.f39793a.f39799e == C12933a.LOAD_IN_PROGRESS) {
            this.f39793a.m42062a("load timed out");
            this.f39793a.f39800f.mo41631a(new C12799b(608, str), this.f39793a, false);
        } else if (this.f39793a.f39799e == C12933a.LOADED) {
            this.f39793a.m42062a("reload timed out");
            this.f39793a.f39800f.mo41634b(new C12799b(609, str), this.f39793a, false);
        }
        this.f39793a.m42059a(C12933a.LOAD_FAILED);
    }
}
