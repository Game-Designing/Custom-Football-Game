package com.google.android.gms.ads.mediation.admob;

import android.os.Bundle;
import com.google.ads.mediation.C8092e;

@Deprecated
public final class AdMobExtras implements C8092e {

    /* renamed from: a */
    private final Bundle f19220a;

    public AdMobExtras(Bundle bundle) {
        this.f19220a = bundle != null ? new Bundle(bundle) : null;
    }

    public final Bundle getExtras() {
        return this.f19220a;
    }
}
