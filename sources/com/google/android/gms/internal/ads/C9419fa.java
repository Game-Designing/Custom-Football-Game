package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.fa */
final class C9419fa implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f22279a;

    /* renamed from: b */
    private final /* synthetic */ zzajy f22280b;

    C9419fa(zzajy zzajy, String str) {
        this.f22280b = zzajy;
        this.f22279a = str;
    }

    public final void run() {
        this.f22280b.f24378a.loadData(this.f22279a, "text/html", "UTF-8");
    }
}
