package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;

public class RtbSignalData {

    /* renamed from: a */
    private final Context f19233a;

    /* renamed from: b */
    private final MediationConfiguration f19234b;

    /* renamed from: c */
    private final Bundle f19235c;

    /* renamed from: d */
    private final AdSize f19236d;

    public RtbSignalData(Context context, MediationConfiguration mediationConfiguration, Bundle bundle, AdSize adSize) {
        this.f19233a = context;
        this.f19234b = mediationConfiguration;
        this.f19235c = bundle;
        this.f19236d = adSize;
    }

    public Context getContext() {
        return this.f19233a;
    }

    public MediationConfiguration getConfiguration() {
        return this.f19234b;
    }

    public Bundle getNetworkExtras() {
        return this.f19235c;
    }

    public AdSize getAdSize() {
        return this.f19236d;
    }
}
