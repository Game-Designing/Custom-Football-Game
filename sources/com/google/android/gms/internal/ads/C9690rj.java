package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzwt.zzg;
import com.google.android.gms.internal.ads.zzwt.zzi.zzc;
import java.util.ArrayList;

/* renamed from: com.google.android.gms.internal.ads.rj */
final class C9690rj implements zzban<Bundle> {

    /* renamed from: a */
    private final /* synthetic */ boolean f22938a;

    /* renamed from: b */
    final /* synthetic */ zzcjm f22939b;

    C9690rj(zzcjm zzcjm, boolean z) {
        this.f22939b = zzcjm;
        this.f22938a = z;
    }

    /* renamed from: a */
    public final void mo27999a(Throwable th) {
        zzbad.m26355b("Failed to get signals bundle");
    }

    /* renamed from: a */
    public final /* synthetic */ void mo27998a(Object obj) {
        Bundle bundle = (Bundle) obj;
        ArrayList a = zzcjm.m28499c(bundle);
        zzc b = zzcjm.m28495b(bundle);
        zzg c = this.f22939b.m28491a(bundle);
        zzcjc a2 = this.f22939b.f26714f;
        C9711sj sjVar = new C9711sj(this, this.f22938a, a, c, b);
        a2.mo31173a(sjVar);
    }
}
