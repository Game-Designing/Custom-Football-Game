package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.os.Bundle;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;

public final class FuturePaymentInfoActivity extends Activity {

    /* renamed from: a */
    private C11942j f37307a;

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C11939i iVar = (C11939i) getIntent().getExtras().getSerializable("com.paypal.details.scope");
        setTheme(16973934);
        requestWindowFeature(8);
        this.f37307a = new C11942j(this, iVar);
        setContentView(this.f37307a.f37564a);
        C11867Da.m39239a((Activity) this, this.f37307a.f37565b, (C11761Rb) null);
        this.f37307a.f37569f.setText(C11756Pb.m38949a(C11761Rb.BACK_BUTTON));
        this.f37307a.f37569f.setOnClickListener(new C11936h(this));
    }
}
