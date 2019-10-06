package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ga */
final class C9441ga implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f22365a;

    /* renamed from: b */
    private final /* synthetic */ zzajy f22366b;

    C9441ga(zzajy zzajy, String str) {
        this.f22366b = zzajy;
        this.f22365a = str;
    }

    public final void run() {
        this.f22366b.f24378a.loadData(this.f22365a, "text/html", "UTF-8");
    }
}
