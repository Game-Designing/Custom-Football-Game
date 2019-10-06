package p019d.p273h.p276c;

import android.os.CountDownTimer;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;

/* renamed from: d.h.c.L */
/* compiled from: MediationInitializer */
class C12751L extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ C12752M f39145a;

    C12751L(C12752M this$1, long x0, long x1) {
        this.f39145a = this$1;
        super(x0, x1);
    }

    public void onTick(long millisUntilFinished) {
        if (millisUntilFinished <= 45000) {
            this.f39145a.f39146a.f39173z = true;
            for (C12756c listener : this.f39145a.f39146a.f39165r) {
                listener.mo41204a();
            }
        }
    }

    public void onFinish() {
        if (!this.f39145a.f39146a.f39158k) {
            this.f39145a.f39146a.f39158k = true;
            for (C12756c listener : this.f39145a.f39146a.f39165r) {
                listener.mo41212a("noInternetConnection");
            }
            C12802d.m41613c().mo41427b(C12801a.API, "Mediation availability false reason: No internet connection", 1);
        }
    }
}
