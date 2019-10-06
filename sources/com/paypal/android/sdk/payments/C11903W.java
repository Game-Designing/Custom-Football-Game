package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.Calendar;

/* renamed from: com.paypal.android.sdk.payments.W */
final class C11903W implements ServiceConnection {

    /* renamed from: a */
    private /* synthetic */ PayPalProfileSharingActivity f37487a;

    C11903W(PayPalProfileSharingActivity payPalProfileSharingActivity) {
        this.f37487a = payPalProfileSharingActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder sb = new StringBuilder();
        sb.append(PayPalProfileSharingActivity.class.getSimpleName());
        sb.append(".onServiceConnected");
        if (this.f37487a.isFinishing()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PayPalProfileSharingActivity.class.getSimpleName());
            sb2.append(".onServiceConnected exit - isFinishing");
            return;
        }
        this.f37487a.f37406d = ((C11934ga) iBinder).f37551a;
        if (this.f37487a.f37406d.mo38979d() == null) {
            Log.e(PayPalProfileSharingActivity.f37403a, "Service state invalid.  Did you start the PayPalService?");
            this.f37487a.setResult(2);
            this.f37487a.finish();
            return;
        }
        C11909Z z = new C11909Z(this.f37487a.getIntent(), this.f37487a.f37406d.mo38979d(), true);
        if (!z.mo39168b()) {
            Log.e(PayPalProfileSharingActivity.f37403a, "Service extras invalid.  Please see the docs.");
            this.f37487a.setResult(2);
            this.f37487a.finish();
        } else if (!z.mo39064c()) {
            Log.e(PayPalProfileSharingActivity.f37403a, "Extras invalid.  Please see the docs.");
            this.f37487a.setResult(2);
            this.f37487a.finish();
        } else if (this.f37487a.f37406d.mo38984i()) {
            ProfileSharingConsentActivity.m39502a(this.f37487a, 1, this.f37487a.f37406d.mo38979d());
        } else {
            Calendar instance = Calendar.getInstance();
            instance.add(13, 1);
            this.f37487a.f37404b = instance.getTime();
            this.f37487a.f37406d.mo38964a(PayPalProfileSharingActivity.m39359a(this.f37487a), false);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f37487a.f37406d = null;
        PayPalProfileSharingActivity.f37403a;
    }
}
