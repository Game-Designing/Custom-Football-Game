package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.E */
/* compiled from: IronSourceWebView */
class C10815E implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C10880c f33005a;

    C10815E(C10880c this$1) {
        this.f33005a = this$1;
    }

    public void run() {
        Log.d(C10877y.this.f33192o, "onOfferWallInitSuccess()");
        C10877y.this.f33173Q.onOfferwallInitSuccess();
    }
}
