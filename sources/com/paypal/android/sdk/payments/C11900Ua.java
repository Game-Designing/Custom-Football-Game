package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.paypal.android.sdk.payments.Ua */
final class C11900Ua implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ PaymentMethodActivity f37484a;

    C11900Ua(PaymentMethodActivity paymentMethodActivity) {
        this.f37484a = paymentMethodActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentMethodActivity.f37454a);
        sb.append(".onServiceConnected");
        if (this.f37484a.isFinishing()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PaymentMethodActivity.f37454a);
            sb2.append(".onServiceConnected exit - isFinishing");
            return;
        }
        this.f37484a.f37462i = ((C11934ga) iBinder).f37551a;
        if (this.f37484a.f37462i.mo38975a((C11946ka) new C11902Va(this))) {
            PaymentMethodActivity.m39501i(this.f37484a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f37484a.f37462i = null;
    }
}
