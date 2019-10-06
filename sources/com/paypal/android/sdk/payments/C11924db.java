package com.paypal.android.sdk.payments;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: com.paypal.android.sdk.payments.db */
final class C11924db implements OnClickListener {

    /* renamed from: a */
    private /* synthetic */ Activity f37527a;

    /* renamed from: b */
    private /* synthetic */ int f37528b;

    C11924db(Activity activity, int i) {
        this.f37527a = activity;
        this.f37528b = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f37527a.removeDialog(this.f37528b);
        this.f37527a.finish();
    }
}
