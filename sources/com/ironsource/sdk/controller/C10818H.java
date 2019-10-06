package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.H */
/* compiled from: IronSourceWebView */
class C10818H implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33010a;

    /* renamed from: b */
    final /* synthetic */ String f33011b;

    /* renamed from: c */
    final /* synthetic */ C10880c f33012c;

    C10818H(C10880c this$1, String str, String str2) {
        this.f33012c = this$1;
        this.f33010a = str;
        this.f33011b = str2;
    }

    public void run() {
        String toSend = this.f33010a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        C10877y.this.f33172P.mo41842b(this.f33011b, toSend);
    }
}
