package com.ironsource.sdk.controller;

import android.os.CountDownTimer;
import p019d.p273h.p285d.p295h.C13003f;

/* renamed from: com.ironsource.sdk.controller.ea */
/* compiled from: IronSourceWebView */
class C10847ea extends CountDownTimer {

    /* renamed from: a */
    final /* synthetic */ C10885g f33095a;

    C10847ea(C10885g this$1, long x0, long x1) {
        this.f33095a = this$1;
        super(x0, x1);
    }

    public void onTick(long millisUntilFinished) {
        String z = C10877y.this.f33192o;
        StringBuilder sb = new StringBuilder();
        sb.append("Close Event Timer Tick ");
        sb.append(millisUntilFinished);
        C13003f.m42438c(z, sb.toString());
    }

    public void onFinish() {
        C13003f.m42438c(C10877y.this.f33192o, "Close Event Timer Finish");
        if (C10877y.this.f33202y) {
            C10877y.this.f33202y = false;
        } else {
            C10877y.this.mo35475b("forceClose");
        }
    }
}
