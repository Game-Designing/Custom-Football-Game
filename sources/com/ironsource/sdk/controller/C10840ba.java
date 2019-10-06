package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10895h;

/* renamed from: com.ironsource.sdk.controller.ba */
/* compiled from: IronSourceWebView */
class C10840ba implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33080a;

    /* renamed from: b */
    final /* synthetic */ String f33081b;

    /* renamed from: c */
    final /* synthetic */ C10880c f33082c;

    C10840ba(C10880c this$1, String str, String str2) {
        this.f33082c = this$1;
        this.f33080a = str;
        this.f33081b = str2;
    }

    public void run() {
        String toSend = this.f33080a;
        if (toSend == null) {
            toSend = "We're sorry, some error occurred. we will investigate it";
        }
        String z = C10877y.this.f33192o;
        StringBuilder sb = new StringBuilder();
        sb.append("onRVInitFail(message:");
        sb.append(toSend);
        sb.append(")");
        Log.d(z, sb.toString());
        C10877y.this.f33170N.mo41826a(C10895h.RewardedVideo, this.f33081b, toSend);
    }
}
