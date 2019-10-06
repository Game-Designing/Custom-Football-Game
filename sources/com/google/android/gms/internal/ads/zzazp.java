package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.Map;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@zzard
public final class zzazp {

    /* renamed from: a */
    private final BroadcastReceiver f25027a = new C8805Dc(this);

    /* renamed from: b */
    private final Map<BroadcastReceiver, IntentFilter> f25028b = new WeakHashMap();

    /* renamed from: c */
    private boolean f25029c = false;

    /* renamed from: d */
    private boolean f25030d;

    /* renamed from: e */
    private Context f25031e;

    /* renamed from: a */
    public final synchronized void mo30304a(Context context) {
        if (!this.f25029c) {
            this.f25031e = context.getApplicationContext();
            if (this.f25031e == null) {
                this.f25031e = context;
            }
            zzacu.m24782a(this.f25031e);
            this.f25030d = ((Boolean) zzyt.m31536e().mo29599a(zzacu.f23983Oc)).booleanValue();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.f25031e.registerReceiver(this.f25027a, intentFilter);
            this.f25029c = true;
        }
    }

    /* renamed from: a */
    public final synchronized void mo30306a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (this.f25030d) {
            this.f25028b.put(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    /* renamed from: a */
    public final synchronized void mo30305a(Context context, BroadcastReceiver broadcastReceiver) {
        if (this.f25030d) {
            this.f25028b.remove(broadcastReceiver);
        } else {
            context.unregisterReceiver(broadcastReceiver);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final synchronized void m26287a(Context context, Intent intent) {
        for (Entry entry : this.f25028b.entrySet()) {
            if (((IntentFilter) entry.getValue()).hasAction(intent.getAction())) {
                ((BroadcastReceiver) entry.getKey()).onReceive(context, intent);
            }
        }
    }
}
