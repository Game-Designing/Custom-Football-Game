package com.paypal.android.sdk.payments;

import android.app.Activity;
import com.paypal.android.sdk.C11756Pb;

/* renamed from: com.paypal.android.sdk.payments.wa */
final class C11982wa implements C11937ha {

    /* renamed from: a */
    private /* synthetic */ PaymentConfirmActivity f37620a;

    C11982wa(PaymentConfirmActivity paymentConfirmActivity) {
        this.f37620a = paymentConfirmActivity;
    }

    /* renamed from: a */
    public final void mo38878a() {
        PaymentConfirmActivity.f37437a;
        this.f37620a.m39477g();
    }

    /* renamed from: a */
    public final void mo38879a(C11940ia iaVar) {
        this.f37620a.m39482j();
        C11867Da.m39241a((Activity) this.f37620a, C11756Pb.m38950a(iaVar.f37560b), 1);
        if (this.f37620a.f37445i != C11883La.PayPal) {
            this.f37620a.f37443g.mo38682b(true);
        }
    }
}
