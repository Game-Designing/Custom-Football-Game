package com.ironsource.sdk.controller;

import android.os.Build.VERSION;
import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.J */
/* compiled from: IronSourceWebView */
class C10820J implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C10880c f33017a;

    C10820J(C10880c this$1) {
        this.f33017a = this$1;
    }

    public void run() {
        if (VERSION.SDK_INT >= 16) {
            try {
                C10877y.this.getSettings().setAllowFileAccessFromFileURLs(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
