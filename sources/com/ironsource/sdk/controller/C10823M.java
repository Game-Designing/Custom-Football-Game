package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.M */
/* compiled from: IronSourceWebView */
class C10823M implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33023a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33024b;

    C10823M(C10880c this$1, String str) {
        this.f33024b = this$1;
        this.f33023a = str;
    }

    public void run() {
        Log.d(C10877y.this.f33192o, "onBannerLoadSuccess()");
        C10877y.this.f33174R.mo41828a(this.f33023a);
    }
}
