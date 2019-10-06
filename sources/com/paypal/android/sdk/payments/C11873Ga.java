package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.paypal.android.sdk.C11708Bb;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;

/* renamed from: com.paypal.android.sdk.payments.Ga */
final class C11873Ga implements C11931fa {

    /* renamed from: a */
    private /* synthetic */ PaymentConfirmActivity f37309a;

    C11873Ga(PaymentConfirmActivity paymentConfirmActivity) {
        this.f37309a = paymentConfirmActivity;
    }

    /* renamed from: a */
    public final void mo38854a(C11940ia iaVar) {
        this.f37309a.f37447k.mo38978c().mo38590a();
        this.f37309a.m39482j();
        if (iaVar.mo39120a()) {
            if (!"UNAUTHORIZED_PAYMENT".equals(iaVar.f37560b)) {
                int i = C11985xa.f37623a[this.f37309a.f37445i.ordinal()];
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        this.f37309a.showDialog(2);
                        PaymentConfirmActivity.f37437a;
                        new StringBuilder("server thinks token is expired, get new one. AccessToken: ").append(this.f37309a.f37447k.mo38978c().f36742b);
                        this.f37309a.f37447k.mo38964a(this.f37309a.m39478h(), true);
                    }
                    return;
                }
                C11867Da.m39241a((Activity) this.f37309a, C11756Pb.m38949a(C11761Rb.SESSION_EXPIRED_MESSAGE), 4);
            }
        }
        int i2 = C11985xa.f37623a[this.f37309a.f37445i.ordinal()];
        if (i2 == 1) {
            this.f37309a.f37442f = false;
            Bundle bundle = new Bundle();
            bundle.putString("BUNDLE_ERROR_CODE", iaVar.f37560b);
            this.f37309a.showDialog(5, bundle);
        } else if (i2 == 2 || i2 == 3) {
            this.f37309a.f37443g.mo38682b(true);
            C11867Da.m39241a((Activity) this.f37309a, C11756Pb.m38950a(iaVar.f37560b), 1);
        }
    }

    /* renamed from: a */
    public final void mo38855a(Object obj) {
        if (obj instanceof ProofOfPayment) {
            PaymentConfirmation paymentConfirmation = new PaymentConfirmation(this.f37309a.f37447k.mo38980e(), this.f37309a.f37444h.mo39150a(), (ProofOfPayment) obj);
            Intent intent = this.f37309a.getIntent();
            intent.putExtra("com.paypal.android.sdk.paymentConfirmation", paymentConfirmation);
            this.f37309a.m39469c();
            this.f37309a.setResult(-1, intent);
            this.f37309a.finish();
            return;
        }
        if (obj instanceof C11708Bb) {
            this.f37309a.f37442f = false;
            PaymentConfirmActivity.m39457a(this.f37309a, (C11708Bb) obj);
        }
    }
}
