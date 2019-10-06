package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10888a;
import com.ironsource.sdk.data.C10895h;

/* renamed from: com.ironsource.sdk.controller.A */
/* compiled from: IronSourceWebView */
class C10811A implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f32982a;

    /* renamed from: b */
    final /* synthetic */ C10880c f32983b;

    C10811A(C10880c this$1, String str) {
        this.f32983b = this$1;
        this.f32982a = str;
    }

    public void run() {
        Log.d(C10877y.this.f33192o, "onInterstitialInitSuccess()");
        C10877y.this.f33172P.mo41825a(C10895h.Interstitial, this.f32982a, (C10888a) null);
    }
}
