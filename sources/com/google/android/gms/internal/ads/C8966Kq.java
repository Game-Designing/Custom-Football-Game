package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* renamed from: com.google.android.gms.internal.ads.Kq */
final class C8966Kq {

    /* renamed from: a */
    private boolean f21411a;

    /* renamed from: b */
    private long f21412b;

    /* renamed from: c */
    private long f21413c;

    C8966Kq() {
    }

    /* renamed from: a */
    public final void mo28409a() {
        if (!this.f21411a) {
            this.f21411a = true;
            this.f21413c = m22765b(this.f21412b);
        }
    }

    /* renamed from: b */
    public final void mo28411b() {
        if (this.f21411a) {
            this.f21412b = m22765b(this.f21413c);
            this.f21411a = false;
        }
    }

    /* renamed from: a */
    public final void mo28410a(long j) {
        this.f21412b = j;
        this.f21413c = m22765b(j);
    }

    /* renamed from: c */
    public final long mo28412c() {
        return this.f21411a ? m22765b(this.f21413c) : this.f21412b;
    }

    /* renamed from: b */
    private static long m22765b(long j) {
        return (SystemClock.elapsedRealtime() * 1000) - j;
    }
}
