package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.oa */
final /* synthetic */ class C9617oa implements Runnable {

    /* renamed from: a */
    private final zzajw f22828a;

    private C9617oa(zzajw zzajw) {
        this.f22828a = zzajw;
    }

    /* renamed from: a */
    static Runnable m23992a(zzajw zzajw) {
        return new C9617oa(zzajw);
    }

    public final void run() {
        this.f22828a.destroy();
    }
}
