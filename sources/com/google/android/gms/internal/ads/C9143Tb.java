package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads.Tb */
final class C9143Tb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ Context f21766a;

    /* renamed from: b */
    private final /* synthetic */ zzbbr f21767b;

    C9143Tb(zzawg zzawg, Context context, zzbbr zzbbr) {
        this.f21766a = context;
        this.f21767b = zzbbr;
    }

    public final void run() {
        try {
            this.f21767b.mo30338b(AdvertisingIdClient.getAdvertisingIdInfo(this.f21766a));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.f21767b.mo30337a(e);
            zzbad.m26356b("Exception while getting advertising Id info", e);
        }
    }
}
