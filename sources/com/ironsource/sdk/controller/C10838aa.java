package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.aa */
/* compiled from: IronSourceWebView */
class C10838aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33074a;

    /* renamed from: b */
    final /* synthetic */ int f33075b;

    /* renamed from: c */
    final /* synthetic */ C10880c f33076c;

    C10838aa(C10880c this$1, String str, int i) {
        this.f33076c = this$1;
        this.f33074a = str;
        this.f33075b = i;
    }

    public void run() {
        C10877y.this.f33172P.onInterstitialAdRewarded(this.f33074a, this.f33075b);
    }
}
