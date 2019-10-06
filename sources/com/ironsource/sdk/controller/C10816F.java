package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.F */
/* compiled from: IronSourceWebView */
class C10816F implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33006a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33007b;

    C10816F(C10880c this$1, String str) {
        this.f33007b = this$1;
        this.f33006a = str;
    }

    public void run() {
        String toSend = this.f33006a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        String z = C10877y.this.f33192o;
        StringBuilder sb = new StringBuilder();
        sb.append("onOfferWallInitFail(message:");
        sb.append(toSend);
        sb.append(")");
        Log.d(z, sb.toString());
        C10877y.this.f33173Q.onOfferwallInitFail(toSend);
    }
}
