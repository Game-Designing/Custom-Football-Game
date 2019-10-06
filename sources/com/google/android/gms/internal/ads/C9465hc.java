package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.google.android.gms.internal.ads.hc */
final class C9465hc extends BroadcastReceiver {

    /* renamed from: a */
    private final /* synthetic */ zzaxi f22401a;

    private C9465hc(zzaxi zzaxi) {
        this.f22401a = zzaxi;
    }

    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.f22401a.f24964d = true;
            return;
        }
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.f22401a.f24964d = false;
        }
    }

    /* synthetic */ C9465hc(zzaxi zzaxi, C9377dc dcVar) {
        this(zzaxi);
    }
}
