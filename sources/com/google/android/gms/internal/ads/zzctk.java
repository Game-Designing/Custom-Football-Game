package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzctk implements zzcuz<Bundle> {

    /* renamed from: a */
    private final zzcxk f27361a;

    public zzctk(zzcxk zzcxk) {
        this.f27361a = zzcxk;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzcxk zzcxk = this.f27361a;
        if (zzcxk != null) {
            bundle.putBoolean("render_in_browser", zzcxk.mo31282a());
            bundle.putBoolean("disable_ml", this.f27361a.mo31283b());
        }
    }
}
