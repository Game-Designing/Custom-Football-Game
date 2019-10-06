package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.z */
/* compiled from: IronSourceWebView */
class C10887z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33216a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33217b;

    C10887z(C10880c this$1, String str) {
        this.f33217b = this$1;
        this.f33216a = str;
    }

    public void run() {
        String toSend = this.f33216a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        C10877y.this.f33173Q.onOWShowFail(toSend);
    }
}
