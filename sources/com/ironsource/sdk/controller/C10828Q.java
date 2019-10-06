package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.Q */
/* compiled from: IronSourceWebView */
class C10828Q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33043a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33044b;

    C10828Q(C10880c this$1, String str) {
        this.f33044b = this$1;
        this.f33043a = str;
    }

    public void run() {
        String toSend = this.f33043a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        C10877y.this.f33173Q.onGetOWCreditsFailed(toSend);
    }
}
