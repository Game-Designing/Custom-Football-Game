package com.smaato.soma.p258g;

import com.smaato.soma.C12064Na;
import com.smaato.soma.C12398ha;
import com.smaato.soma.C12408ia;

/* renamed from: com.smaato.soma.g.n */
/* compiled from: NativeAd */
class C12385n extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12064Na f38669a;

    /* renamed from: b */
    final /* synthetic */ C12386o f38670b;

    C12385n(C12386o this$2, C12064Na na) {
        this.f38670b = this$2;
        this.f38669a = na;
    }

    public Void process() {
        if (this.f38669a.mo39290g() == C12408ia.NO_ERROR) {
            this.f38670b.f38671a.f38672a.onAdLoaded(this.f38669a.mo39295j());
            this.f38670b.f38671a.f38673b.f38685d = this.f38669a.mo39295j();
        } else {
            this.f38670b.f38671a.f38672a.onError(this.f38669a.mo39290g(), this.f38669a.mo39277a());
        }
        return null;
    }
}
