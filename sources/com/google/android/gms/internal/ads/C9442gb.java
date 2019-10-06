package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.gb */
final class C9442gb implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ AdOverlayInfoParcel f22367a;

    /* renamed from: b */
    private final /* synthetic */ zzapl f22368b;

    C9442gb(zzapl zzapl, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.f22368b = zzapl;
        this.f22367a = adOverlayInfoParcel;
    }

    public final void run() {
        zzk.zzlf();
        zzm.zza(this.f22368b.f24524a, this.f22367a, true);
    }
}
