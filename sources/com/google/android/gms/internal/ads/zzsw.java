package com.google.android.gms.internal.ads;

import android.os.SystemClock;

public final class zzsw implements zzso {

    /* renamed from: a */
    private boolean f29341a;

    /* renamed from: b */
    private long f29342b;

    /* renamed from: c */
    private long f29343c;

    /* renamed from: d */
    private zzln f29344d = zzln.f28809a;

    /* renamed from: b */
    public final void mo32224b() {
        if (!this.f29341a) {
            this.f29343c = SystemClock.elapsedRealtime();
            this.f29341a = true;
        }
    }

    /* renamed from: c */
    public final void mo32225c() {
        if (this.f29341a) {
            mo32222a(mo31998a());
            this.f29341a = false;
        }
    }

    /* renamed from: a */
    public final void mo32222a(long j) {
        this.f29342b = j;
        if (this.f29341a) {
            this.f29343c = SystemClock.elapsedRealtime();
        }
    }

    /* renamed from: a */
    public final void mo32223a(zzso zzso) {
        mo32222a(zzso.mo31998a());
        this.f29344d = zzso.mo32006i();
    }

    /* renamed from: a */
    public final long mo31998a() {
        long j = this.f29342b;
        if (!this.f29341a) {
            return j;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f29343c;
        zzln zzln = this.f29344d;
        if (zzln.f28810b == 1.0f) {
            return j + zzkt.m30597b(elapsedRealtime);
        }
        return j + zzln.mo31949a(elapsedRealtime);
    }

    /* renamed from: a */
    public final zzln mo31999a(zzln zzln) {
        if (this.f29341a) {
            mo32222a(mo31998a());
        }
        this.f29344d = zzln;
        return zzln;
    }

    /* renamed from: i */
    public final zzln mo32006i() {
        return this.f29344d;
    }
}
