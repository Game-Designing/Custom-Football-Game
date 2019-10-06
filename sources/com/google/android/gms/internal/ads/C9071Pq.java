package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.Pq */
final class C9071Pq implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f21595a;

    /* renamed from: b */
    private final /* synthetic */ long f21596b;

    /* renamed from: c */
    private final /* synthetic */ long f21597c;

    /* renamed from: d */
    private final /* synthetic */ zzgr f21598d;

    C9071Pq(zzgr zzgr, String str, long j, long j2) {
        this.f21598d = zzgr;
        this.f21595a = str;
        this.f21596b = j;
        this.f21597c = j2;
    }

    public final void run() {
        this.f21598d.f28466j.mo28256a(this.f21595a, this.f21596b, this.f21597c);
    }
}
