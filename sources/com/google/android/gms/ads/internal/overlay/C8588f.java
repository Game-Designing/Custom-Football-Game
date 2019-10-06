package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxo;

@zzard
/* renamed from: com.google.android.gms.ads.internal.overlay.f */
final class C8588f extends zzawv {

    /* renamed from: d */
    final /* synthetic */ zzd f19082d;

    private C8588f(zzd zzd) {
        this.f19082d = zzd;
    }

    /* renamed from: a */
    public final void mo26663a() {
        Bitmap a = zzk.zzlz().mo30299a(Integer.valueOf(this.f19082d.f19094d.zzdkt.zzbrj));
        if (a != null) {
            zzaxo zzli = zzk.zzli();
            zzd zzd = this.f19082d;
            Activity activity = zzd.f19093c;
            zzh zzh = zzd.f19094d.zzdkt;
            zzaxi.f24961a.post(new C8589g(this, zzli.mo30245a(activity, a, zzh.zzbrh, zzh.zzbri)));
        }
    }
}
