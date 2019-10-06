package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/* renamed from: com.paypal.android.sdk.payments.pa */
final class C11961pa implements C11937ha {

    /* renamed from: a */
    final /* synthetic */ PaymentActivity f37600a;

    C11961pa(PaymentActivity paymentActivity) {
        this.f37600a = paymentActivity;
    }

    /* renamed from: a */
    public final void mo38878a() {
        Date time = Calendar.getInstance().getTime();
        if (this.f37600a.f37433c.compareTo(time) > 0) {
            long time2 = this.f37600a.f37433c.getTime() - time.getTime();
            PaymentActivity.f37431a;
            StringBuilder sb = new StringBuilder("Delaying ");
            sb.append(time2);
            sb.append(" miliseconds so user doesn't see flicker.");
            this.f37600a.f37432b = new Timer();
            this.f37600a.f37432b.schedule(new C11964qa(this), time2);
            return;
        }
        this.f37600a.m39443b();
    }

    /* renamed from: a */
    public final void mo38879a(C11940ia iaVar) {
        C11867Da.m39240a(this.f37600a, iaVar, 1, 2, 3);
    }
}
