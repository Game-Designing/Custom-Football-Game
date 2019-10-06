package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;

/* renamed from: com.ironsource.sdk.controller.ca */
/* compiled from: IronSourceWebView */
class C10843ca implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33088a;

    /* renamed from: b */
    final /* synthetic */ String f33089b;

    /* renamed from: c */
    final /* synthetic */ C10880c f33090c;

    C10843ca(C10880c this$1, String str, String str2) {
        this.f33090c = this$1;
        this.f33088a = str;
        this.f33089b = str2;
    }

    public void run() {
        String toSend = this.f33088a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        String z = C10877y.this.f33192o;
        StringBuilder sb = new StringBuilder();
        sb.append("onRVShowFail(message:");
        sb.append(this.f33088a);
        sb.append(")");
        Log.d(z, sb.toString());
        C10877y.this.f33170N.mo41849d(this.f33089b, toSend);
    }
}
