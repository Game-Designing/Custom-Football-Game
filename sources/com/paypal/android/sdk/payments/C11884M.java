package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.paypal.android.sdk.payments.M */
final class C11884M implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ PayPalFuturePaymentActivity f37340a;

    C11884M(PayPalFuturePaymentActivity payPalFuturePaymentActivity) {
        this.f37340a = payPalFuturePaymentActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder sb = new StringBuilder();
        sb.append(PayPalFuturePaymentActivity.f37365a);
        sb.append(".onServiceConnected");
        if (this.f37340a.isFinishing()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PayPalFuturePaymentActivity.f37365a);
            sb2.append(".onServiceConnected exit - isFinishing");
            return;
        }
        this.f37340a.f37368d = ((C11934ga) iBinder).f37551a;
        if (this.f37340a.f37368d.mo38975a((C11946ka) new C11886N(this))) {
            PayPalFuturePaymentActivity.m39325c(this.f37340a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f37340a.f37368d = null;
        PayPalFuturePaymentActivity.f37365a;
    }
}
