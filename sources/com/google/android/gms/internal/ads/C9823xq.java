package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.xq */
final class C9823xq implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ zzr f23479a;

    /* renamed from: b */
    private final /* synthetic */ zzd f23480b;

    C9823xq(zzd zzd, zzr zzr) {
        this.f23480b = zzd;
        this.f23479a = zzr;
    }

    public final void run() {
        try {
            this.f23480b.f27711c.put(this.f23479a);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
