package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zabq extends BroadcastReceiver {

    /* renamed from: a */
    private Context f19856a;

    /* renamed from: b */
    private final zabr f19857b;

    public zabq(zabr zabr) {
        this.f19857b = zabr;
    }

    /* renamed from: a */
    public final void mo27612a(Context context) {
        this.f19856a = context;
    }

    /* renamed from: a */
    public final synchronized void mo27611a() {
        if (this.f19856a != null) {
            this.f19856a.unregisterReceiver(this);
        }
        this.f19856a = null;
    }

    public final void onReceive(Context context, Intent intent) {
        String str;
        Uri data = intent.getData();
        if (data != null) {
            str = data.getSchemeSpecificPart();
        } else {
            str = null;
        }
        if ("com.google.android.gms".equals(str)) {
            this.f19857b.mo27539a();
            mo27611a();
        }
    }
}
