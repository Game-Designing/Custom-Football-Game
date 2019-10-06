package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzctg implements zzcuz<Bundle> {

    /* renamed from: a */
    private final Bundle f27358a;

    public zzctg(Bundle bundle) {
        this.f27358a = bundle;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        String str = "device";
        Bundle a = zzcxz.m28989a(bundle, str);
        a.putBundle("android_mem_info", this.f27358a);
        bundle.putBundle(str, a);
    }
}
