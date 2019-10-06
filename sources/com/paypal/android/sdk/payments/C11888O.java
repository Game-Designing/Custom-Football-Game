package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/* renamed from: com.paypal.android.sdk.payments.O */
final class C11888O implements C11937ha {

    /* renamed from: a */
    final /* synthetic */ PayPalFuturePaymentActivity f37343a;

    C11888O(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        this.f37343a = payPalFuturePaymentActivity;
    }

    /* renamed from: a */
    public final void mo38878a() {
        Date time = Calendar.getInstance().getTime();
        if (this.f37343a.f37366b.compareTo(time) > 0) {
            long time2 = this.f37343a.f37366b.getTime() - time.getTime();
            PayPalFuturePaymentActivity.f37365a;
            StringBuilder sb = new StringBuilder("Delaying ");
            sb.append(time2);
            sb.append(" milliseconds so user doesn't see flicker.");
            this.f37343a.f37367c = new Timer();
            this.f37343a.f37367c.schedule(new C11890P(this), time2);
            return;
        }
        this.f37343a.m39323b();
    }

    /* renamed from: a */
    public final void mo38879a(C11940ia iaVar) {
        C11867Da.m39240a(this.f37343a, iaVar, 1, 2, 3);
    }
}
