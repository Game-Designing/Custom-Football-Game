package com.ironsource.sdk.controller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.ironsource.sdk.data.C10893f;
import p019d.p273h.p274a.C12724b;

/* renamed from: com.ironsource.sdk.controller.o */
/* compiled from: IronSourceWebView */
class C10867o extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C10877y f33132a;

    C10867o(C10877y this$0) {
        this.f33132a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f33132a.f33175S == C10893f.Ready) {
            String networkType = "none";
            if (C12724b.m41080h(context)) {
                networkType = "wifi";
            } else if (C12724b.m41079g(context)) {
                networkType = "3g";
            }
            this.f33132a.mo35462a(networkType);
        }
    }
}
