package com.ironsource.sdk.controller;

import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10895h;
import org.json.JSONObject;
import p019d.p273h.p285d.p292f.p293a.C12982a;

/* renamed from: com.ironsource.sdk.controller.T */
/* compiled from: IronSourceWebView */
class C10830T implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C10895h f33048a;

    /* renamed from: b */
    final /* synthetic */ String f33049b;

    /* renamed from: c */
    final /* synthetic */ String f33050c;

    /* renamed from: d */
    final /* synthetic */ JSONObject f33051d;

    /* renamed from: e */
    final /* synthetic */ C10880c f33052e;

    C10830T(C10880c this$1, C10895h hVar, String str, String str2, JSONObject jSONObject) {
        this.f33052e = this$1;
        this.f33048a = hVar;
        this.f33049b = str;
        this.f33050c = str2;
        this.f33051d = jSONObject;
    }

    public void run() {
        C10895h hVar = this.f33048a;
        if (hVar == C10895h.Interstitial || hVar == C10895h.RewardedVideo) {
            C12982a listener = C10877y.this.m35476a(this.f33048a);
            if (listener != null) {
                listener.mo41827a(this.f33048a, this.f33049b, this.f33050c, this.f33051d);
            }
        } else if (hVar == C10895h.OfferWall) {
            C10877y.this.f33173Q.onOfferwallEventNotificationReceived(this.f33050c, this.f33051d);
        }
    }
}
