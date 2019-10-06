package com.ironsource.sdk.controller;

import android.os.Build.VERSION;
import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.V */
/* compiled from: IronSourceWebView */
class C10832V implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C10880c f33055a;

    C10832V(C10880c this$1) {
        this.f33055a = this$1;
    }

    public void run() {
        if (VERSION.SDK_INT >= 21) {
            C10877y.this.getSettings().setMixedContentMode(0);
        }
    }
}
