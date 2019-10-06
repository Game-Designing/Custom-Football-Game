package com.facebook;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.facebook.j */
/* compiled from: CustomTabActivity */
class C6740j extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ CustomTabActivity f12336a;

    C6740j(CustomTabActivity this$0) {
        this.f12336a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        this.f12336a.finish();
    }
}
