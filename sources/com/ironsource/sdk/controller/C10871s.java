package com.ironsource.sdk.controller;

import android.os.CountDownTimer;
import com.ironsource.sdk.data.C10890c;
import com.ironsource.sdk.data.C10895h;
import java.util.Iterator;
import p019d.p273h.p285d.p295h.C13003f;

/* renamed from: com.ironsource.sdk.controller.s */
/* compiled from: IronSourceWebView */
class C10871s extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ int f33136a;

    /* renamed from: b */
    final /* synthetic */ C10877y f33137b;

    C10871s(C10877y this$0, long x0, long x1, int i) {
        this.f33137b = this$0;
        this.f33136a = i;
        super(x0, x1);
    }

    public void onTick(long millisUntilFinished) {
        String z = this.f33137b.f33192o;
        StringBuilder sb = new StringBuilder();
        sb.append("Loading Controller Timer Tick ");
        sb.append(millisUntilFinished);
        C13003f.m42438c(z, sb.toString());
    }

    public void onFinish() {
        C13003f.m42438c(this.f33137b.f33192o, "Loading Controller Timer Finish");
        if (this.f33136a == 3) {
            this.f33137b.f33159C.cancel();
            Iterator it = this.f33137b.f33184ea.mo35439a(C10895h.RewardedVideo).iterator();
            while (it.hasNext()) {
                C10890c demandSource = (C10890c) it.next();
                if (demandSource.mo35650b() == 1) {
                    this.f33137b.m35505c(C10895h.RewardedVideo, demandSource);
                }
            }
            Iterator it2 = this.f33137b.f33184ea.mo35439a(C10895h.Interstitial).iterator();
            while (it2.hasNext()) {
                C10890c demandSource2 = (C10890c) it2.next();
                if (demandSource2.mo35650b() == 1) {
                    this.f33137b.m35505c(C10895h.Interstitial, demandSource2);
                }
            }
            Iterator it3 = this.f33137b.f33184ea.mo35439a(C10895h.Banner).iterator();
            while (it3.hasNext()) {
                C10890c demandSource3 = (C10890c) it3.next();
                if (demandSource3.mo35650b() == 1) {
                    this.f33137b.m35505c(C10895h.Banner, demandSource3);
                }
            }
            if (this.f33137b.f33199v) {
                this.f33137b.m35505c(C10895h.OfferWall, (C10890c) null);
            }
            if (this.f33137b.f33200w) {
                this.f33137b.m35505c(C10895h.OfferWallCredits, (C10890c) null);
                return;
            }
            return;
        }
        this.f33137b.mo35454a(2);
    }
}
