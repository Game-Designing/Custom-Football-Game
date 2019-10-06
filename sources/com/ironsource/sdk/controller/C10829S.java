package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10895h;
import p019d.p273h.p285d.p292f.p293a.C12982a;

/* renamed from: com.ironsource.sdk.controller.S */
/* compiled from: IronSourceWebView */
class C10829S implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C10895h f33045a;

    /* renamed from: b */
    final /* synthetic */ String f33046b;

    /* renamed from: c */
    final /* synthetic */ C10880c f33047c;

    C10829S(C10880c this$1, C10895h hVar, String str) {
        this.f33047c = this$1;
        this.f33045a = hVar;
        this.f33046b = str;
    }

    public void run() {
        C10895h hVar = this.f33045a;
        if (hVar == C10895h.RewardedVideo || hVar == C10895h.Interstitial) {
            C12982a listener = C10877y.this.m35476a(this.f33045a);
            if (listener != null) {
                listener.mo41840b(this.f33045a, this.f33046b);
            }
        } else if (hVar == C10895h.OfferWall) {
            C10877y.this.f33173Q.onOWAdClosed();
        }
    }
}
