package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.da */
/* compiled from: IronSourceWebView */
class C10845da implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33092a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33093b;

    C10845da(C10880c this$1, String str) {
        this.f33093b = this$1;
        this.f33092a = str;
    }

    public void run() {
        C10877y.this.f33173Q.onOWShowSuccess(this.f33092a);
    }
}
