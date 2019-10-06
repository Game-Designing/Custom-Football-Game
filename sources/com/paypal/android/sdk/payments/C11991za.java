package com.paypal.android.sdk.payments;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* renamed from: com.paypal.android.sdk.payments.za */
final class C11991za implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ PaymentConfirmActivity f37649a;

    C11991za(PaymentConfirmActivity paymentConfirmActivity) {
        this.f37649a = paymentConfirmActivity;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        StringBuilder sb = new StringBuilder();
        sb.append(PaymentConfirmActivity.f37437a);
        sb.append(".onServiceConnected");
        this.f37649a.f37447k = ((C11934ga) iBinder).f37551a;
        if (this.f37649a.f37447k.mo38975a((C11946ka) new C11861Aa(this))) {
            PaymentConfirmActivity.m39465b(this.f37649a);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.f37649a.f37447k = null;
    }
}
