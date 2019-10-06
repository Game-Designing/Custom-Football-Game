package com.crashlytics.android.p126c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.crashlytics.android.c.ma */
/* compiled from: DevicePowerStateListener */
class C6503ma extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C6509oa f11675a;

    C6503ma(C6509oa this$0) {
        this.f11675a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        this.f11675a.f11690h = true;
    }
}
