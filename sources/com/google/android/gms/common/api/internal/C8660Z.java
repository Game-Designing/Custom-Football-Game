package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.Z */
final class C8660Z implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ LifecycleCallback f19740a;

    /* renamed from: b */
    private final /* synthetic */ String f19741b;

    /* renamed from: c */
    private final /* synthetic */ zzc f19742c;

    C8660Z(zzc zzc, LifecycleCallback lifecycleCallback, String str) {
        this.f19742c = zzc;
        this.f19740a = lifecycleCallback;
        this.f19741b = str;
    }

    public final void run() {
        if (this.f19742c.f19941c > 0) {
            this.f19740a.mo27515a(this.f19742c.f19942d != null ? this.f19742c.f19942d.getBundle(this.f19741b) : null);
        }
        if (this.f19742c.f19941c >= 2) {
            this.f19740a.mo27520d();
        }
        if (this.f19742c.f19941c >= 3) {
            this.f19740a.mo27519c();
        }
        if (this.f19742c.f19941c >= 4) {
            this.f19740a.mo27521e();
        }
        if (this.f19742c.f19941c >= 5) {
            this.f19740a.mo27517b();
        }
    }
}
