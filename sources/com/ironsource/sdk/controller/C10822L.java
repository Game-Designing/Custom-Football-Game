package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10895h;

/* renamed from: com.ironsource.sdk.controller.L */
/* compiled from: IronSourceWebView */
class C10822L implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33020a;

    /* renamed from: b */
    final /* synthetic */ String f33021b;

    /* renamed from: c */
    final /* synthetic */ C10880c f33022c;

    C10822L(C10880c this$1, String str, String str2) {
        this.f33022c = this$1;
        this.f33020a = str;
        this.f33021b = str2;
    }

    public void run() {
        String toSend = this.f33020a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        String z = C10877y.this.f33192o;
        StringBuilder sb = new StringBuilder();
        sb.append("onBannerInitFail(message:");
        sb.append(toSend);
        sb.append(")");
        Log.d(z, sb.toString());
        C10877y.this.f33174R.mo41826a(C10895h.Banner, this.f33021b, toSend);
    }
}
