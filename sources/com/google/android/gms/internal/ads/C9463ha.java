package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ha */
final class C9463ha implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f22398a;

    /* renamed from: b */
    private final /* synthetic */ zzajy f22399b;

    C9463ha(zzajy zzajy, String str) {
        this.f22399b = zzajy;
        this.f22398a = str;
    }

    public final void run() {
        this.f22399b.f24378a.loadUrl(this.f22398a);
    }
}
