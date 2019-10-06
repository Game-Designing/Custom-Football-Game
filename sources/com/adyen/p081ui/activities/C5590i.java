package com.adyen.p081ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.adyen.ui.activities.i */
/* compiled from: TranslucentDialogActivity */
class C5590i extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ TranslucentDialogActivity f9419a;

    C5590i(TranslucentDialogActivity this$0) {
        this.f9419a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        this.f9419a.finish();
    }
}
