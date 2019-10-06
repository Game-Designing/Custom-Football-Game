package com.crashlytics.android.p124a;

import p024io.fabric.sdk.android.services.concurrency.p354a.C13936e;

/* renamed from: com.crashlytics.android.a.E */
/* compiled from: RetryManager */
class C6363E {

    /* renamed from: a */
    long f11347a;

    /* renamed from: b */
    private C13936e f11348b;

    public C6363E(C13936e retryState) {
        if (retryState != null) {
            this.f11348b = retryState;
            return;
        }
        throw new NullPointerException("retryState must not be null");
    }

    /* renamed from: a */
    public boolean mo19345a(long timeNanos) {
        return timeNanos - this.f11347a >= this.f11348b.mo43367a() * 1000000;
    }

    /* renamed from: b */
    public void mo19346b(long timeNanos) {
        this.f11347a = timeNanos;
        this.f11348b = this.f11348b.mo43369c();
    }

    /* renamed from: a */
    public void mo19344a() {
        this.f11347a = 0;
        this.f11348b = this.f11348b.mo43368b();
    }
}
