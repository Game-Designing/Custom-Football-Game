package com.crashlytics.android.p126c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.crashlytics.android.c.na */
/* compiled from: DevicePowerStateListener */
class C6507na extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C6509oa f11680a;

    C6507na(C6509oa this$0) {
        this.f11680a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        this.f11680a.f11690h = false;
    }
}
