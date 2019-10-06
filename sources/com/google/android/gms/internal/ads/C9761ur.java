package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.ur */
final class C9761ur implements Runnable {

    /* renamed from: a */
    private final zzr f23235a;

    /* renamed from: b */
    private final zzy f23236b;

    /* renamed from: c */
    private final Runnable f23237c;

    public C9761ur(zzr zzr, zzy zzy, Runnable runnable) {
        this.f23235a = zzr;
        this.f23236b = zzy;
        this.f23237c = runnable;
    }

    public final void run() {
        this.f23235a.mo32132i();
        if (this.f23236b.f29746c == null) {
            this.f23235a.mo29242a(this.f23236b.f29744a);
        } else {
            this.f23235a.mo32124a(this.f23236b.f29746c);
        }
        if (this.f23236b.f29747d) {
            this.f23235a.mo32126a("intermediate-response");
        } else {
            this.f23235a.mo32128b("done");
        }
        Runnable runnable = this.f23237c;
        if (runnable != null) {
            runnable.run();
        }
    }
}
