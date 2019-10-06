package com.paypal.android.sdk.payments;

import android.content.Intent;

/* renamed from: com.paypal.android.sdk.payments.ra */
final class C11967ra extends C11989yb {
    C11967ra(Intent intent, PayPalConfiguration payPalConfiguration) {
        super(intent, payPalConfiguration);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo39063a() {
        return PaymentActivity.class.getSimpleName();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final boolean mo39149c() {
        C11970sa saVar = new C11970sa(this.f37646a);
        boolean z = saVar.mo39150a() != null && saVar.mo39150a().mo38940m();
        mo39167a(z, "PaymentActivity.EXTRA_PAYMENT");
        return z;
    }
}
