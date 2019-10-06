package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.N */
/* compiled from: IronSourceWebView */
class C10824N implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33025a;

    /* renamed from: b */
    final /* synthetic */ String f33026b;

    /* renamed from: c */
    final /* synthetic */ C10880c f33027c;

    C10824N(C10880c this$1, String str, String str2) {
        this.f33027c = this$1;
        this.f33025a = str;
        this.f33026b = str2;
    }

    public void run() {
        Log.d(C10877y.this.f33192o, "onLoadBannerFail()");
        String toSend = this.f33025a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        C10877y.this.f33174R.mo41846c(this.f33026b, toSend);
    }
}
