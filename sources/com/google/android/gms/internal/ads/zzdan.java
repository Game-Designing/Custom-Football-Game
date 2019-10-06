package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.ads.zzdap.zza;
import com.google.android.gms.internal.ads.zzdau.zzb;

@ShowFirstParty
public final class zzdan {

    /* renamed from: a */
    private final Context f27744a;

    /* renamed from: b */
    private final Looper f27745b;

    public zzdan(Context context, Looper looper) {
        this.f27744a = context;
        this.f27745b = looper;
    }

    /* renamed from: a */
    public final void mo31351a(String str) {
        new C8899Hm(this.f27744a, this.f27745b, (zzdau) zzdau.m29111l().mo31356a(this.f27744a.getPackageName()).mo31355a(zzb.BLOCKED_IMPRESSION).mo31354a(zzdap.m29097l().mo31353a(str).mo31352a(zza.BLOCKED_REASON_BACKGROUND)).mo31612g()).mo28320a();
    }
}
