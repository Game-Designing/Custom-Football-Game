package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcsg implements zzcuz<Bundle> {

    /* renamed from: a */
    private final double f27325a;

    /* renamed from: b */
    private final boolean f27326b;

    public zzcsg(double d, boolean z) {
        this.f27325a = d;
        this.f27326b = z;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = "device";
        Bundle a = zzcxz.m28989a(bundle, str);
        bundle.putBundle(str, a);
        String str2 = "battery";
        Bundle a2 = zzcxz.m28989a(a, str2);
        a.putBundle(str2, a2);
        a2.putBoolean("is_charging", this.f27326b);
        a2.putDouble("battery_level", this.f27325a);
    }
}
