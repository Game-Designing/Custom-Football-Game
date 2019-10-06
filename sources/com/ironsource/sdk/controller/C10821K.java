package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10888a;
import com.ironsource.sdk.data.C10895h;

/* renamed from: com.ironsource.sdk.controller.K */
/* compiled from: IronSourceWebView */
class C10821K implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33018a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33019b;

    C10821K(C10880c this$1, String str) {
        this.f33019b = this$1;
        this.f33018a = str;
    }

    public void run() {
        Log.d(C10877y.this.f33192o, "onBannerInitSuccess()");
        C10877y.this.f33174R.mo41825a(C10895h.Banner, this.f33018a, (C10888a) null);
    }
}
