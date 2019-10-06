package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Bk */
final class C8771Bk implements zzbsn {

    /* renamed from: a */
    private final /* synthetic */ zzbbr f20517a;

    /* renamed from: b */
    private final /* synthetic */ zzcjy f20518b;

    C8771Bk(zzcoe zzcoe, zzbbr zzbbr, zzcjy zzcjy) {
        this.f20517a = zzbbr;
        this.f20518b = zzcjy;
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24135me)).booleanValue()) {
            i = 3;
        }
        zzbbr zzbbr = this.f20517a;
        String str = this.f20518b.f26728a;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 23);
        sb.append("adapter ");
        sb.append(str);
        sb.append(" failed to load");
        zzbbr.mo30337a(new zzcmw(sb.toString(), i));
    }

    public final synchronized void onAdLoaded() {
        this.f20517a.mo30338b(null);
    }
}
