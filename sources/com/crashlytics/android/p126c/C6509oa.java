package com.crashlytics.android.p126c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.crashlytics.android.c.oa */
/* compiled from: DevicePowerStateListener */
class C6509oa {

    /* renamed from: a */
    private static final IntentFilter f11683a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: b */
    private static final IntentFilter f11684b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");

    /* renamed from: c */
    private static final IntentFilter f11685c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");

    /* renamed from: d */
    private final AtomicBoolean f11686d = new AtomicBoolean(false);

    /* renamed from: e */
    private final Context f11687e;

    /* renamed from: f */
    private final BroadcastReceiver f11688f = new C6507na(this);

    /* renamed from: g */
    private final BroadcastReceiver f11689g = new C6503ma(this);
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f11690h;

    public C6509oa(Context context) {
        this.f11687e = context;
    }

    /* renamed from: b */
    public void mo19592b() {
        boolean z = true;
        if (!this.f11686d.getAndSet(true)) {
            Intent statusIntent = this.f11687e.registerReceiver(null, f11683a);
            int status = -1;
            if (statusIntent != null) {
                status = statusIntent.getIntExtra("status", -1);
            }
            if (!(status == 2 || status == 5)) {
                z = false;
            }
            this.f11690h = z;
            this.f11687e.registerReceiver(this.f11689g, f11684b);
            this.f11687e.registerReceiver(this.f11688f, f11685c);
        }
    }

    /* renamed from: c */
    public boolean mo19593c() {
        return this.f11690h;
    }

    /* renamed from: a */
    public void mo19591a() {
        if (this.f11686d.getAndSet(false)) {
            this.f11687e.unregisterReceiver(this.f11689g);
            this.f11687e.unregisterReceiver(this.f11688f);
        }
    }
}
