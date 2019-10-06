package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.I */
/* compiled from: IronSourceWebView */
class C10819I implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33013a;

    /* renamed from: b */
    final /* synthetic */ String f33014b;

    /* renamed from: c */
    final /* synthetic */ C10880c f33015c;

    C10819I(C10880c this$1, String str, String str2) {
        this.f33015c = this$1;
        this.f33013a = str;
        this.f33014b = str2;
    }

    public void run() {
        String toSend = this.f33013a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        C10877y.this.f33172P.mo41830a(this.f33014b, toSend);
    }
}
