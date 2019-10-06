package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

public final class zzcuh implements zzcva<zzcuz<Bundle>> {

    /* renamed from: a */
    private final Context f27393a;

    /* renamed from: b */
    private final String f27394b;

    zzcuh(Context context, String str) {
        this.f27393a = context;
        this.f27394b = str;
    }

    /* renamed from: a */
    public final zzbbh<zzcuz<Bundle>> mo28586a() {
        C8919Il il;
        if (this.f27394b == null) {
            il = null;
        } else {
            il = new C8919Il(this);
        }
        return zzbar.m26376a(il);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final /* synthetic */ void mo31263a(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.f27393a.getPackageName());
    }
}
