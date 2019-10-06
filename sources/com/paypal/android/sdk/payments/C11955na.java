package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.paypal.android.sdk.payments.na */
final class C11955na implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ PaymentActivity f37593a;

    C11955na(PaymentActivity paymentActivity) {
        this.f37593a = paymentActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentActivity.f37431a);
        sb.append(".onServiceConnected");
        if (this.f37593a.isFinishing()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(PaymentActivity.f37431a);
            sb2.append(".onServiceConnected exit - isFinishing");
            return;
        }
        this.f37593a.f37434d = ((C11934ga) iBinder).f37551a;
        if (this.f37593a.f37434d.mo38975a((C11946ka) new C11958oa(this))) {
            PaymentActivity.m39445c(this.f37593a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f37593a.f37434d = null;
        PaymentActivity.f37431a;
    }
}
