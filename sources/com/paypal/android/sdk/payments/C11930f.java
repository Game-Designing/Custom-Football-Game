package com.paypal.android.sdk.payments;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;

/* renamed from: com.paypal.android.sdk.payments.f */
final class C11930f {

    /* renamed from: a */
    final IntentFilter f37546a;

    /* renamed from: b */
    final BroadcastReceiver f37547b;

    /* renamed from: c */
    boolean f37548c;

    C11930f(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f37546a = intentFilter;
        this.f37547b = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("Receiver{");
        sb.append(this.f37547b);
        sb.append(" filter=");
        sb.append(this.f37546a);
        sb.append("}");
        return sb.toString();
    }
}
