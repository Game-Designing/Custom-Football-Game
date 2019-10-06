package com.paypal.android.sdk.payments;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.paypal.android.sdk.payments.d */
final class C11922d extends Handler {

    /* renamed from: a */
    private /* synthetic */ C11919c f37525a;

    C11922d(C11919c cVar, Looper looper) {
        this.f37525a = cVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message.what != 1) {
            super.handleMessage(message);
        } else {
            C11919c.m39522a(this.f37525a);
        }
    }
}
