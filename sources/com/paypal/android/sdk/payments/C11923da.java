package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* renamed from: com.paypal.android.sdk.payments.da */
final class C11923da extends BroadcastReceiver {

    /* renamed from: a */
    private /* synthetic */ PayPalService f37526a;

    C11923da(PayPalService payPalService) {
        this.f37526a = payPalService;
    }

    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("com.paypal.android.sdk.clearAllUserData")) {
            this.f37526a.mo38982g();
            Log.w("paypal.sdk", "active service user data cleared");
        }
    }
}
