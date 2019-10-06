package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.Callable;

public final class zzcsh implements zzcva<zzcsg> {

    /* renamed from: a */
    private final zzbbl f27327a;

    /* renamed from: b */
    private final Context f27328b;

    public zzcsh(zzbbl zzbbl, Context context) {
        this.f27327a = zzbbl;
        this.f27328b = context;
    }

    /* renamed from: a */
    public final zzbbh<zzcsg> mo28586a() {
        return this.f27327a.mo30326a((Callable<T>) new C9650pl<T>(this));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final /* synthetic */ zzcsg mo31255b() throws Exception {
        double d;
        Intent registerReceiver = this.f27328b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            double intExtra2 = (double) registerReceiver.getIntExtra("level", -1);
            double intExtra3 = (double) registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d = -1.0d;
        }
        return new zzcsg(d, z);
    }
}
