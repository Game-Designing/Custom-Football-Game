package com.adyen.p081ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.p000v4.content.C0515e;

/* renamed from: com.adyen.ui.activities.g */
/* compiled from: RedirectHandlerActivity */
class C5588g extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ RedirectHandlerActivity f9417a;

    C5588g(RedirectHandlerActivity this$0) {
        this.f9417a = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        C0515e.m2597a(this.f9417a.getApplicationContext()).mo5312a((BroadcastReceiver) this);
        this.f9417a.finish();
    }
}
