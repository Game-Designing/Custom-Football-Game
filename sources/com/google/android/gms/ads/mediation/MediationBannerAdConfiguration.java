package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;

public class MediationBannerAdConfiguration extends MediationAdConfiguration {

    /* renamed from: j */
    private final AdSize f19176j;

    public MediationBannerAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, Location location, int i, int i2, String str2, AdSize adSize) {
        super(context, str, bundle, bundle2, z, location, i, i2, str2);
        this.f19176j = adSize;
    }

    public AdSize getAdSize() {
        return this.f19176j;
    }
}
