package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* renamed from: com.google.android.gms.internal.ads.Ql */
final /* synthetic */ class C9087Ql implements Runnable {

    /* renamed from: a */
    private final zzcva f21619a;

    /* renamed from: b */
    private final long f21620b;

    C9087Ql(zzcva zzcva, long j) {
        this.f21619a = zzcva;
        this.f21620b = j;
    }

    public final void run() {
        zzcva zzcva = this.f21619a;
        long j = this.f21620b;
        String canonicalName = zzcva.getClass().getCanonicalName();
        long a = zzk.zzln().mo27934a() - j;
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 40);
        sb.append("Signal runtime : ");
        sb.append(canonicalName);
        sb.append(" = ");
        sb.append(a);
        zzawz.m26003f(sb.toString());
    }
}
