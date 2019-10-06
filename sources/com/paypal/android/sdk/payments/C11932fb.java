package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.fb */
final class C11932fb implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ Activity f37549a;

    C11932fb(Activity activity) {
        this.f37549a = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37549a.finish();
    }
}
