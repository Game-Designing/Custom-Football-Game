package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcuv implements zzcuz<Bundle> {

    /* renamed from: a */
    private final boolean f27421a;

    /* renamed from: b */
    private final boolean f27422b;

    /* renamed from: c */
    private final String f27423c;

    /* renamed from: d */
    private final boolean f27424d;

    /* renamed from: e */
    private final int f27425e;

    /* renamed from: f */
    private final int f27426f;

    public zzcuv(boolean z, boolean z2, String str, boolean z3, int i, int i2) {
        this.f27421a = z;
        this.f27422b = z2;
        this.f27423c = str;
        this.f27424d = z3;
        this.f27425e = i;
        this.f27426f = i2;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("js", this.f27423c);
        bundle.putBoolean("is_nonagon", true);
        String str = "extra_caps";
        bundle.putString(str, (String) zzyt.m31536e().mo29599a(zzacu.f23899Ac));
        bundle.putInt("target_api", this.f27425e);
        bundle.putInt("dv", this.f27426f);
        String str2 = "sdk_env";
        Bundle a = zzcxz.m28989a(bundle, str2);
        String str3 = "mf";
        a.putBoolean(str3, ((Boolean) zzyt.m31536e().mo29599a(zzacu.f23911Cc)).booleanValue());
        a.putBoolean("instant_app", this.f27421a);
        a.putBoolean("lite", this.f27422b);
        a.putBoolean("is_privileged_process", this.f27424d);
        bundle.putBundle(str2, a);
        String str4 = "build_meta";
        Bundle a2 = zzcxz.m28989a(a, str4);
        a2.putString("cl", "248613007");
        a2.putString("rapid_rc", "dev");
        a2.putString("rapid_rollup", "HEAD");
        a.putBundle(str4, a2);
    }
}
