package com.google.android.gms.common.api.internal;

/* renamed from: com.google.android.gms.common.api.internal.Y */
final class C8659Y implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ LifecycleCallback f19737a;

    /* renamed from: b */
    private final /* synthetic */ String f19738b;

    /* renamed from: c */
    private final /* synthetic */ zza f19739c;

    C8659Y(zza zza, LifecycleCallback lifecycleCallback, String str) {
        this.f19739c = zza;
        this.f19737a = lifecycleCallback;
        this.f19738b = str;
    }

    public final void run() {
        if (this.f19739c.f19937c > 0) {
            this.f19737a.mo27515a(this.f19739c.f19938d != null ? this.f19739c.f19938d.getBundle(this.f19738b) : null);
        }
        if (this.f19739c.f19937c >= 2) {
            this.f19737a.mo27520d();
        }
        if (this.f19739c.f19937c >= 3) {
            this.f19737a.mo27519c();
        }
        if (this.f19739c.f19937c >= 4) {
            this.f19737a.mo27521e();
        }
        if (this.f19739c.f19937c >= 5) {
            this.f19737a.mo27517b();
        }
    }
}
