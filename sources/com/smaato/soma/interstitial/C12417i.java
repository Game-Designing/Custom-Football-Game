package com.smaato.soma.interstitial;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12398ha;
import com.smaato.soma.C12431j;
import com.smaato.soma.p236a.p237a.C12111b;
import com.smaato.soma.p239c.p246f.C12239k;

/* renamed from: com.smaato.soma.interstitial.i */
/* compiled from: Interstitial */
class C12417i extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12064Na f38773a;

    /* renamed from: b */
    final /* synthetic */ C12420l f38774b;

    C12417i(C12420l this$0, C12064Na na) {
        this.f38774b = this$0;
        this.f38773a = na;
    }

    public Void process() {
        if (this.f38774b.f38782f.mo39487g() == null) {
            return null;
        }
        this.f38774b.f38780d = this.f38773a.getSessionId();
        if (this.f38773a.mo39284b() != C12431j.DISPLAY && this.f38773a.mo39284b() != C12431j.IMAGE && this.f38773a.mo39284b() != C12431j.RICH_MEDIA) {
            m40814a();
        } else if (this.f38773a.getStatus() == C12111b.f37994b && !this.f38773a.mo39288e()) {
            this.f38774b.f38781e.setShouldNotifyIdle(true);
            this.f38774b.f38779c = false;
        } else if (this.f38773a.mo39288e()) {
            this.f38774b.f38779c = true;
            ((C12239k) this.f38774b.f38781e.getAdDownloader()).mo39601a(this.f38774b.mo39916c());
            this.f38774b.f38781e.setShouldNotifyIdle(true);
        } else {
            m40814a();
        }
        return null;
    }

    /* renamed from: a */
    private void m40814a() {
        this.f38774b.f38779c = false;
        this.f38774b.f38781e.setShouldNotifyIdle(false);
        this.f38774b.mo39916c().mo39480a();
        this.f38774b.mo39919e();
    }
}
