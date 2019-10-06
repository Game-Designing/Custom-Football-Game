package com.flurry.sdk;

/* renamed from: com.flurry.sdk.nc */
class C7566nc extends Thread {

    /* renamed from: a */
    final /* synthetic */ C7577pc f14963a;

    C7566nc(C7577pc pcVar) {
        this.f14963a = pcVar;
    }

    public final void run() {
        try {
            if (this.f14963a.f15010q != null) {
                this.f14963a.f15010q.disconnect();
            }
        } catch (Throwable th) {
        }
    }
}
