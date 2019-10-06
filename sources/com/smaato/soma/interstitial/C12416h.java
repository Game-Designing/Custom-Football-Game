package com.smaato.soma.interstitial;

import android.content.Intent;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.interstitial.h */
/* compiled from: Interstitial */
class C12416h extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ C12420l f38772a;

    C12416h(C12420l this$0) {
        this.f38772a = this$0;
    }

    public Void process() throws Exception {
        if (!this.f38772a.mo39917d() || this.f38772a.f38779c) {
            if (!this.f38772a.mo39917d() || !this.f38772a.f38779c) {
                C12146d.m39965a(new C12147e(C12420l.f38777a, "Interstitial Banner not ready", 1, C12143a.DEBUG));
                this.f38772a.mo39919e();
            } else {
                this.f38772a.m40827j();
                this.f38772a.mo39916c().mo39486f();
                this.f38772a.mo39919e();
            }
            return null;
        }
        this.f38772a.mo39916c().mo39486f();
        this.f38772a.mo39919e();
        Intent intent = new Intent(this.f38772a.f38783g, InterstitialActivity.class);
        intent.addFlags(343932928);
        long interstitialViewCacheId = System.currentTimeMillis();
        intent.putExtra("interstitialViewCacheId", interstitialViewCacheId);
        C12430s.m40856a(Long.valueOf(interstitialViewCacheId), this.f38772a.f38781e);
        this.f38772a.f38783g.getApplicationContext().startActivity(intent);
        return null;
    }
}
