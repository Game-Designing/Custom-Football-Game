package com.smaato.soma.interstitial;

import android.app.Activity;
import com.smaato.soma.C12398ha;
import java.lang.ref.WeakReference;

/* renamed from: com.smaato.soma.interstitial.o */
/* compiled from: InterstitialBannerView */
class C12425o extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ Activity f38793a;

    /* renamed from: b */
    final /* synthetic */ C12428r f38794b;

    C12425o(C12428r this$0, Activity activity) {
        this.f38794b = this$0;
        this.f38793a = activity;
    }

    public Void process() throws Exception {
        if (this.f38793a != null) {
            this.f38794b.f38635f.mo39350b(new WeakReference<>(this.f38793a));
        }
        return null;
    }
}
