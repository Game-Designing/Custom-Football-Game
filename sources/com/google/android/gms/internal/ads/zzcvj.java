package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

public final class zzcvj implements zzcuz<Bundle> {

    /* renamed from: a */
    private final String f27451a;

    /* renamed from: b */
    private final int f27452b;

    /* renamed from: c */
    private final int f27453c;

    /* renamed from: d */
    private final int f27454d;

    /* renamed from: e */
    private final boolean f27455e;

    /* renamed from: f */
    private final int f27456f;

    public zzcvj(String str, int i, int i2, int i3, boolean z, int i4) {
        this.f27451a = str;
        this.f27452b = i;
        this.f27453c = i2;
        this.f27454d = i3;
        this.f27455e = z;
        this.f27456f = i4;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = this.f27451a;
        boolean z = true;
        zzcxz.m28994a(bundle, "carrier", str, !TextUtils.isEmpty(str));
        Integer valueOf = Integer.valueOf(this.f27452b);
        if (this.f27452b == -2) {
            z = false;
        }
        zzcxz.m28992a(bundle, "cnt", valueOf, z);
        bundle.putInt("gnt", this.f27453c);
        bundle.putInt("pt", this.f27454d);
        String str2 = "device";
        Bundle a = zzcxz.m28989a(bundle, str2);
        bundle.putBundle(str2, a);
        String str3 = "network";
        Bundle a2 = zzcxz.m28989a(a, str3);
        a.putBundle(str3, a2);
        a2.putInt("active_network_state", this.f27456f);
        a2.putBoolean("active_network_metered", this.f27455e);
    }
}
