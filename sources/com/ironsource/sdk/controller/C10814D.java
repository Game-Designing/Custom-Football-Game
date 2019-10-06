package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10895h;

/* renamed from: com.ironsource.sdk.controller.D */
/* compiled from: IronSourceWebView */
class C10814D implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33003a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33004b;

    C10814D(C10880c this$1, String str) {
        this.f33004b = this$1;
        this.f33003a = str;
    }

    public void run() {
        C10877y.this.f33172P.mo41824a(C10895h.Interstitial, this.f33003a);
        C10877y.this.f33172P.mo41848d(this.f33003a);
    }
}
