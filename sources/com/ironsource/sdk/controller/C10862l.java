package com.ironsource.sdk.controller;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.sdk.data.C10890c;
import com.ironsource.sdk.data.C10895h;
import p019d.p273h.p285d.p292f.p293a.C12982a;

/* renamed from: com.ironsource.sdk.controller.l */
/* compiled from: IronSourceWebView */
class C10862l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C10895h f33122a;

    /* renamed from: b */
    final /* synthetic */ C10890c f33123b;

    /* renamed from: c */
    final /* synthetic */ String f33124c;

    /* renamed from: d */
    final /* synthetic */ C10877y f33125d;

    C10862l(C10877y this$0, C10895h hVar, C10890c cVar, String str) {
        this.f33125d = this$0;
        this.f33122a = hVar;
        this.f33123b = cVar;
        this.f33124c = str;
    }

    public void run() {
        C10895h hVar = C10895h.RewardedVideo;
        C10895h hVar2 = this.f33122a;
        if (hVar == hVar2 || C10895h.Interstitial == hVar2 || C10895h.Banner == hVar2) {
            C10890c cVar = this.f33123b;
            if (cVar != null && !TextUtils.isEmpty(cVar.mo35655e())) {
                C12982a listener = this.f33125d.m35476a(this.f33122a);
                String z = this.f33125d.f33192o;
                StringBuilder sb = new StringBuilder();
                sb.append("onAdProductInitFailed (message:");
                sb.append(this.f33124c);
                sb.append(")(");
                sb.append(this.f33122a);
                sb.append(")");
                Log.d(z, sb.toString());
                if (listener != null) {
                    listener.mo41826a(this.f33122a, this.f33123b.mo35655e(), this.f33124c);
                }
            }
        } else if (C10895h.OfferWall == hVar2) {
            this.f33125d.f33173Q.onOfferwallInitFail(this.f33124c);
        } else if (C10895h.OfferWallCredits == hVar2) {
            this.f33125d.f33173Q.onGetOWCreditsFailed(this.f33124c);
        }
    }
}
