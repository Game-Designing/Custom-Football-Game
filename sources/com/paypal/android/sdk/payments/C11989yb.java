package com.paypal.android.sdk.payments;

import android.content.Intent;
import android.util.Log;

/* renamed from: com.paypal.android.sdk.payments.yb */
abstract class C11989yb {

    /* renamed from: a */
    Intent f37646a;

    /* renamed from: b */
    PayPalConfiguration f37647b;

    C11989yb(Intent intent, PayPalConfiguration payPalConfiguration) {
        this.f37646a = intent;
        this.f37647b = payPalConfiguration;
        if (!this.f37646a.hasExtra("com.paypal.android.sdk.paypalConfiguration")) {
            Log.w(mo39063a(), "Please add PayPalService.EXTRA_PAYPAL_CONFIGURATION to this activity for restart resiliency.");
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public abstract String mo39063a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo39167a(boolean z, String str) {
        if (!z) {
            String a = mo39063a();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" is invalid.  Please see the docs.");
            Log.e(a, sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final boolean mo39168b() {
        if (this.f37647b.mo38903o()) {
            return true;
        }
        Log.e(mo39063a(), "Service extra invalid.");
        return false;
    }
}
