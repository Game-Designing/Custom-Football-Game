package com.smaato.soma.p261j;

import com.smaato.soma.C12398ha;

/* renamed from: com.smaato.soma.j.k */
/* compiled from: VASTAdActivity */
class C12476k extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12485t f38922a;

    C12476k(C12485t this$0) {
        this.f38922a = this$0;
    }

    public Void process() throws Exception {
        if (this.f38922a.m41024i()) {
            this.f38922a.mo40015f();
            if (this.f38922a.f38932d != null) {
                this.f38922a.f38932d.setVisibility(4);
            }
        }
        if (this.f38922a.f38936h != null) {
            this.f38922a.f38936h.setVisibility(8);
        }
        this.f38922a.mo40014e();
        if (this.f38922a.f38932d == null || this.f38922a.f38935g == null || (!this.f38922a.f38932d.mo39945k() && this.f38922a.f38932d.getAutoCloseDuration() <= 0)) {
            this.f38922a.finish();
            return null;
        } else if (this.f38922a.f38932d.mo39945k() || this.f38922a.f38932d.mo39946l()) {
            return null;
        } else {
            this.f38922a.f38935g.postDelayed(new C12475j(this), (long) (this.f38922a.f38932d.getAutoCloseDuration() * 1000));
            return null;
        }
    }
}
