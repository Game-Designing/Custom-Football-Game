package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

public class MediationConfiguration {

    /* renamed from: a */
    private final AdFormat f19177a;

    /* renamed from: b */
    private final Bundle f19178b;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.f19177a = adFormat;
        this.f19178b = bundle;
    }

    public AdFormat getFormat() {
        return this.f19177a;
    }

    public Bundle getServerParameters() {
        return this.f19178b;
    }
}
