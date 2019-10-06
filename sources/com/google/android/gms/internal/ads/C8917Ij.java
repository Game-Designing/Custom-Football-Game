package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.Ij */
final /* synthetic */ class C8917Ij implements zzbwz {

    /* renamed from: a */
    private final zzbbr f21260a;

    C8917Ij(zzbbr zzbbr) {
        this.f21260a = zzbbr;
    }

    /* renamed from: a */
    public final void mo28355a(boolean z, Context context) {
        zzbbr zzbbr = this.f21260a;
        try {
            zzk.zzlf();
            zzm.zza(context, (AdOverlayInfoParcel) zzbbr.get(), true);
        } catch (Exception e) {
        }
    }
}
