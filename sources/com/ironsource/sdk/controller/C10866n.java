package com.ironsource.sdk.controller;

import android.content.Context;
import android.widget.Toast;
import com.ironsource.sdk.data.C10894g;

/* renamed from: com.ironsource.sdk.controller.n */
/* compiled from: IronSourceWebView */
class C10866n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f33129a;

    /* renamed from: b */
    final /* synthetic */ String f33130b;

    /* renamed from: c */
    final /* synthetic */ C10877y f33131c;

    C10866n(C10877y this$0, String str, String str2) {
        this.f33131c = this$0;
        this.f33129a = str;
        this.f33130b = str2;
    }

    public void run() {
        if (this.f33131c.getDebugMode() == C10894g.MODE_3.mo35660e()) {
            Context currentActivityContext = this.f33131c.getCurrentActivityContext();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f33129a);
            sb.append(" : ");
            sb.append(this.f33130b);
            Toast.makeText(currentActivityContext, sb.toString(), 1).show();
        }
    }
}
