package com.ironsource.sdk.controller;

import android.os.Build.VERSION;
import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.X */
/* compiled from: IronSourceWebView */
class C10834X implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f33058a;

    /* renamed from: b */
    final /* synthetic */ C10880c f33059b;

    C10834X(C10880c this$1, boolean z) {
        this.f33059b = this$1;
        this.f33058a = z;
    }

    public void run() {
        if (VERSION.SDK_INT >= 16) {
            try {
                C10877y.this.getSettings().setAllowFileAccessFromFileURLs(this.f33058a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
