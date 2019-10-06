package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Ge */
final class C8870Ge implements zzbdo {

    /* renamed from: a */
    private final /* synthetic */ zzbgl f20889a;

    C8870Ge(zzbgl zzbgl) {
        this.f20889a = zzbgl;
    }

    /* renamed from: a */
    public final void mo28257a(String str, String str2) {
        zzbgl zzbgl = this.f20889a;
        String valueOf = String.valueOf(str);
        String str3 = "ExoPlayer caching failed. Type: ";
        zzbgl.f25309f = valueOf.length() != 0 ? str3.concat(valueOf) : new String(str3);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(str2).length());
        sb.append("ExoPlayer failed during precache: ");
        sb.append(str);
        sb.append(" Exception: ");
        sb.append(str2);
        zzbad.m26359d(sb.toString());
        this.f20889a.mo30549b();
    }
}
