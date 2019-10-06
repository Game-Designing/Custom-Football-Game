package com.paypal.android.sdk.payments;

import android.os.AsyncTask;

/* renamed from: com.paypal.android.sdk.payments.Wa */
final class C11904Wa extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ PaymentMethodActivity f37488a;

    private C11904Wa(PaymentMethodActivity paymentMethodActivity) {
        this.f37488a = paymentMethodActivity;
    }

    /* synthetic */ C11904Wa(PaymentMethodActivity paymentMethodActivity, byte b) {
        this(paymentMethodActivity);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        long currentTimeMillis = System.currentTimeMillis();
        PaymentMethodActivity.f37454a;
        this.f37488a.f37458e = C11867Da.m39248e();
        PaymentMethodActivity.f37454a;
        StringBuilder sb = new StringBuilder("cameraAvailable:");
        sb.append(this.f37488a.f37458e);
        sb.append(" time elapsed = ");
        sb.append(Long.toString(System.currentTimeMillis() - currentTimeMillis));
        this.f37488a.runOnUiThread(new C11906Xa(this));
        return null;
    }
}
