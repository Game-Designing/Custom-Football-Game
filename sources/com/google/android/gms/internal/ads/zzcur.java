package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcur implements zzcuz<Bundle> {

    /* renamed from: a */
    private final String f27410a;

    /* renamed from: b */
    private final String f27411b;

    /* renamed from: c */
    private final String f27412c;

    /* renamed from: d */
    private final String f27413d;

    /* renamed from: e */
    private final Long f27414e;

    public zzcur(String str, String str2, String str3, String str4, Long l) {
        this.f27410a = str;
        this.f27411b = str2;
        this.f27412c = str3;
        this.f27413d = str4;
        this.f27414e = l;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzcxz.m28993a(bundle, "gmp_app_id", this.f27410a);
        zzcxz.m28993a(bundle, "fbs_aiid", this.f27411b);
        zzcxz.m28993a(bundle, "fbs_aeid", this.f27412c);
        zzcxz.m28993a(bundle, "apm_id_origin", this.f27413d);
        Long l = this.f27414e;
        if (l != null) {
            bundle.putLong("sai_timeout", l.longValue());
        }
    }
}
