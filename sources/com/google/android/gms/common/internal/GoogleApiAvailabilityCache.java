package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api.Client;

public class GoogleApiAvailabilityCache {

    /* renamed from: a */
    private final SparseIntArray f20111a;

    /* renamed from: b */
    private GoogleApiAvailabilityLight f20112b;

    public GoogleApiAvailabilityCache() {
        this(GoogleApiAvailability.getInstance());
    }

    public GoogleApiAvailabilityCache(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.f20111a = new SparseIntArray();
        Preconditions.m21857a(googleApiAvailabilityLight);
        this.f20112b = googleApiAvailabilityLight;
    }

    /* renamed from: a */
    public int mo27800a(Context context, Client client) {
        Preconditions.m21857a(context);
        Preconditions.m21857a(client);
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int i = this.f20111a.get(minApkVersion, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.f20111a.size()) {
                break;
            }
            int keyAt = this.f20111a.keyAt(i2);
            if (keyAt > minApkVersion && this.f20111a.get(keyAt) == 0) {
                i = 0;
                break;
            }
            i2++;
        }
        if (i == -1) {
            i = this.f20112b.mo27294a(context, minApkVersion);
        }
        this.f20111a.put(minApkVersion, i);
        return i;
    }

    /* renamed from: a */
    public void mo27801a() {
        this.f20111a.clear();
    }
}
