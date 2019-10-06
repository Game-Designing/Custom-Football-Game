package com.paypal.android.sdk.payments;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/* renamed from: com.paypal.android.sdk.payments.X */
final class C11905X implements C11937ha {

    /* renamed from: a */
    final /* synthetic */ PayPalProfileSharingActivity f37489a;

    C11905X(PayPalProfileSharingActivity payPalProfileSharingActivity) {
        this.f37489a = payPalProfileSharingActivity;
    }

    /* renamed from: a */
    public final void mo38878a() {
        Date time = Calendar.getInstance().getTime();
        if (this.f37489a.f37404b.compareTo(time) > 0) {
            long time2 = this.f37489a.f37404b.getTime() - time.getTime();
            PayPalProfileSharingActivity.f37403a;
            StringBuilder sb = new StringBuilder("Delaying ");
            sb.append(time2);
            sb.append(" miliseconds so user doesn't see flicker.");
            this.f37489a.f37405c = new Timer();
            this.f37489a.f37405c.schedule(new C11907Y(this), time2);
            return;
        }
        ProfileSharingConsentActivity.m39502a(this.f37489a, 1, this.f37489a.f37406d.mo38979d());
    }

    /* renamed from: a */
    public final void mo38879a(C11940ia iaVar) {
        C11867Da.m39240a(this.f37489a, iaVar, 1, 2, 3);
    }
}
