package com.paypal.android.sdk.payments;

import android.content.Intent;
import com.paypal.android.sdk.C11723Fa;
import com.paypal.android.sdk.C11752Oa;
import com.paypal.android.sdk.C11842l;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

/* renamed from: com.paypal.android.sdk.payments.Z */
final class C11909Z extends C11989yb {

    /* renamed from: c */
    private boolean f37492c;

    C11909Z(Intent intent, PayPalConfiguration payPalConfiguration, boolean z) {
        super(intent, payPalConfiguration);
        this.f37492c = z;
    }

    /* renamed from: a */
    private static boolean m39512a(String str) {
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final String mo39063a() {
        return PayPalFuturePaymentActivity.class.getSimpleName();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public final boolean mo39064c() {
        boolean b = C11723Fa.m38822b((CharSequence) this.f37647b.mo38900l());
        mo39167a(b, "merchantName");
        String str = "merchantPrivacyPolicyUrl";
        boolean z = this.f37647b.mo38901m() != null && C11723Fa.m38819a(PayPalFuturePaymentActivity.class.getSimpleName(), this.f37647b.mo38901m().toString(), str) && m39512a(this.f37647b.mo38901m().toString());
        mo39167a(z, str);
        String str2 = "merchantUserAgreementUrl";
        boolean z2 = this.f37647b.mo38902n() != null && C11723Fa.m38819a(PayPalFuturePaymentActivity.class.getSimpleName(), this.f37647b.mo38902n().toString(), str2) && m39512a(this.f37647b.mo38902n().toString());
        mo39167a(z2, str2);
        boolean z3 = this.f37492c;
        boolean z4 = !z3;
        if (z3) {
            PayPalOAuthScopes payPalOAuthScopes = (PayPalOAuthScopes) this.f37646a.getParcelableExtra("com.paypal.android.sdk.requested_scopes");
            if (payPalOAuthScopes != null && payPalOAuthScopes.mo38922a() != null && payPalOAuthScopes.mo38922a().size() > 0) {
                Iterator it = payPalOAuthScopes.mo38922a().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z4 = true;
                        break;
                    }
                    String str3 = (String) it.next();
                    if (!C11842l.f37267i.contains(str3) && !C11752Oa.f36867i.contains(str3)) {
                        break;
                    }
                }
            }
            z4 = false;
        }
        mo39167a(z4, "paypalScopes");
        return b && z && z2 && z4;
    }
}
