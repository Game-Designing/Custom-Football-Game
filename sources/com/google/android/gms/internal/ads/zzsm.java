package com.google.android.gms.internal.ads;

public final class zzsm {

    /* renamed from: a */
    private boolean f29313a;

    /* renamed from: b */
    public final synchronized boolean mo32188b() {
        if (this.f29313a) {
            return false;
        }
        this.f29313a = true;
        notifyAll();
        return true;
    }

    /* renamed from: c */
    public final synchronized boolean mo32189c() {
        boolean z;
        z = this.f29313a;
        this.f29313a = false;
        return z;
    }

    /* renamed from: a */
    public final synchronized void mo32187a() throws InterruptedException {
        while (!this.f29313a) {
            wait();
        }
    }
}
