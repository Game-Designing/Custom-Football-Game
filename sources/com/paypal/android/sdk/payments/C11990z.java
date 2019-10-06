package com.paypal.android.sdk.payments;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.z */
final class C11990z implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ LoginActivity f37648a;

    C11990z(LoginActivity loginActivity) {
        this.f37648a = loginActivity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37648a.onBackPressed();
    }
}
