package com.ironsource.sdk.controller;

import android.os.CountDownTimer;
import p019d.p273h.p285d.p295h.C13003f;

/* renamed from: com.ironsource.sdk.controller.r */
/* compiled from: IronSourceWebView */
class C10870r extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ C10877y f33135a;

    C10870r(C10877y this$0, long x0, long x1) {
        this.f33135a = this$0;
        super(x0, x1);
    }

    public void onTick(long millisUntilFinished) {
        String z = this.f33135a.f33192o;
        StringBuilder sb = new StringBuilder();
        sb.append("Global Controller Timer Tick ");
        sb.append(millisUntilFinished);
        C13003f.m42438c(z, sb.toString());
    }

    public void onFinish() {
        C13003f.m42438c(this.f33135a.f33192o, "Global Controller Timer Finish");
        this.f33135a.f33201x = true;
    }
}
