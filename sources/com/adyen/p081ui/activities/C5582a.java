package com.adyen.p081ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.adyen.ui.activities.a */
/* compiled from: CheckoutActivity */
class C5582a extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CheckoutActivity f9409a;

    C5582a(CheckoutActivity this$0) {
        this.f9409a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        this.f9409a.finish();
    }
}
