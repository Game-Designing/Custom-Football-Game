package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.vc */
final class C9767vc implements zzz {

    /* renamed from: a */
    private final /* synthetic */ String f23255a;

    /* renamed from: b */
    private final /* synthetic */ C9809xc f23256b;

    C9767vc(zzayu zzayu, String str, C9809xc xcVar) {
        this.f23255a = str;
        this.f23256b = xcVar;
    }

    /* renamed from: a */
    public final void mo29229a(zzaf zzaf) {
        String str = this.f23255a;
        String exc = zzaf.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(exc).length());
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(exc);
        zzbad.m26359d(sb.toString());
        this.f23256b.mo29262a(null);
    }
}
