package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.paypal.android.sdk.C11756Pb;
import com.paypal.android.sdk.C11761Rb;
import com.paypal.android.sdk.C11833ic;
import com.paypal.android.sdk.C11845lc;
import com.paypal.android.sdk.C11849mc;
import com.paypal.android.sdk.C11853nc;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public final class PaymentActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f37431a = PaymentActivity.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Timer f37432b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Date f37433c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public PayPalService f37434d;

    /* renamed from: e */
    private final ServiceConnection f37435e = new C11955na(this);

    /* renamed from: f */
    private boolean f37436f;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m39443b() {
        PaymentMethodActivity.m39488a(this, 1, this.f37434d.mo38979d());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public C11937ha m39444c() {
        return new C11961pa(this);
    }

    /* renamed from: c */
    static /* synthetic */ void m39445c(PaymentActivity paymentActivity) {
        if (paymentActivity.f37434d.mo38979d() == null) {
            Log.e(f37431a, "Service state invalid.  Did you start the PayPalService?");
            paymentActivity.setResult(2);
            paymentActivity.finish();
            return;
        }
        C11967ra raVar = new C11967ra(paymentActivity.getIntent(), paymentActivity.f37434d.mo38979d());
        if (!raVar.mo39168b()) {
            Log.e(f37431a, "Service extras invalid.  Please see the docs.");
            paymentActivity.setResult(2);
            paymentActivity.finish();
        } else if (!raVar.mo39149c()) {
            Log.e(f37431a, "Extras invalid.  Please see the docs.");
            paymentActivity.setResult(2);
            paymentActivity.finish();
        } else {
            paymentActivity.f37434d.mo38987l();
            paymentActivity.f37434d.mo38978c().mo38590a();
            if (paymentActivity.f37434d.mo38984i()) {
                paymentActivity.m39443b();
                return;
            }
            Calendar instance = Calendar.getInstance();
            instance.add(13, 1);
            paymentActivity.f37433c = instance.getTime();
            paymentActivity.f37434d.mo38964a(paymentActivity.m39444c(), false);
        }
    }

    public final void finish() {
        super.finish();
        StringBuilder sb = new StringBuilder();
        sb.append(f37431a);
        sb.append(".finish");
    }

    /* access modifiers changed from: protected */
    public final void onActivityResult(int i, int i2, Intent intent) {
        String str;
        String str2;
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append(f37431a);
        sb.append(".onActivityResult");
        if (i == 1) {
            if (i2 == -1) {
                if (intent != null) {
                    String str3 = "com.paypal.android.sdk.paymentConfirmation";
                    PaymentConfirmation paymentConfirmation = (PaymentConfirmation) intent.getParcelableExtra(str3);
                    if (paymentConfirmation != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra(str3, paymentConfirmation);
                        setResult(-1, intent2);
                    } else {
                        str2 = f37431a;
                        str = "result was OK, have data, but no payment state in bundle, oops";
                    }
                } else {
                    str2 = f37431a;
                    str = "result was OK, no intent data, oops";
                }
                Log.e(str2, str);
            } else if (i2 != 0) {
                StringBuilder sb2 = new StringBuilder("unexpected request code ");
                sb2.append(i);
                sb2.append(" call it a cancel");
                Log.wtf("paypal.sdk", sb2.toString());
            }
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        StringBuilder sb = new StringBuilder();
        sb.append(f37431a);
        sb.append(".onCreate");
        new C11853nc(this).mo38825a();
        new C11849mc(this).mo38822a();
        new C11845lc(this).mo38821a(Arrays.asList(new String[]{PaymentActivity.class.getName(), LoginActivity.class.getName(), PaymentMethodActivity.class.getName(), PaymentConfirmActivity.class.getName()}));
        this.f37436f = bindService(C11867Da.m39245b((Activity) this), this.f37435e, 1);
        setTheme(16973934);
        requestWindowFeature(8);
        C11833ic icVar = new C11833ic(this);
        setContentView(icVar.f37234a);
        icVar.f37236c.setText(C11756Pb.m38949a(C11761Rb.CHECKING_DEVICE));
        C11867Da.m39239a((Activity) this, (TextView) null, C11761Rb.CHECKING_DEVICE);
    }

    /* access modifiers changed from: protected */
    public final Dialog onCreateDialog(int i, Bundle bundle) {
        return i != 2 ? i != 3 ? C11867Da.m39229a((Activity) this, C11761Rb.UNAUTHORIZED_DEVICE_TITLE, bundle, i) : C11867Da.m39229a((Activity) this, C11761Rb.UNAUTHORIZED_MERCHANT_TITLE, bundle, i) : C11867Da.m39227a((Activity) this, (OnClickListener) new C11952ma(this));
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        StringBuilder sb = new StringBuilder();
        sb.append(f37431a);
        sb.append(".onDestroy");
        PayPalService payPalService = this.f37434d;
        if (payPalService != null) {
            payPalService.mo38990o();
            this.f37434d.mo39002u();
        }
        if (this.f37436f) {
            unbindService(this.f37435e);
            this.f37436f = false;
        }
        super.onDestroy();
    }
}
