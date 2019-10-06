package com.ironsource.sdk.controller;

import android.util.Log;
import com.ironsource.sdk.controller.C10877y.C10880c;
import com.ironsource.sdk.data.C10888a;
import com.ironsource.sdk.data.C10895h;

/* renamed from: com.ironsource.sdk.controller.Y */
/* compiled from: IronSourceWebView */
class C10835Y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C10888a f33060a;

    /* renamed from: b */
    final /* synthetic */ String f33061b;

    /* renamed from: c */
    final /* synthetic */ C10880c f33062c;

    C10835Y(C10880c this$1, C10888a aVar, String str) {
        this.f33062c = this$1;
        this.f33060a = aVar;
        this.f33061b = str;
    }

    public void run() {
        if (Integer.parseInt(this.f33060a.mo35637b()) > 0) {
            Log.d(C10877y.this.f33192o, "onRVInitSuccess()");
            C10877y.this.f33170N.mo41825a(C10895h.RewardedVideo, this.f33061b, this.f33060a);
            return;
        }
        C10877y.this.f33170N.mo41841b(this.f33061b);
    }
}
