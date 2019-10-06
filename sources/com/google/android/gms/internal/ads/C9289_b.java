package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

/* renamed from: com.google.android.gms.internal.ads._b */
final class C9289_b extends zzawv {

    /* renamed from: d */
    private Context f22039d;

    C9289_b(Context context) {
        this.f22039d = context;
    }

    /* renamed from: a */
    public final void mo26663a() {
        boolean z;
        try {
            z = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.f22039d);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzbad.m26356b("Fail to get isAdIdFakeForDebugLogging", e);
            z = false;
        }
        zzazx.m26332a(z);
        StringBuilder sb = new StringBuilder(43);
        sb.append("Update ad debug logging enablement as ");
        sb.append(z);
        zzbad.m26359d(sb.toString());
    }
}
