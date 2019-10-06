package com.google.android.gms.internal.ads;

public final class zzcji {

    /* renamed from: a */
    private int f26698a = 0;

    /* renamed from: b */
    private long f26699b = 0;

    /* renamed from: c */
    private long f26700c = 0;

    /* renamed from: d */
    private long f26701d = 0;

    /* renamed from: e */
    private final Object f26702e = new Object();

    /* renamed from: f */
    private final Object f26703f = new Object();

    /* renamed from: g */
    private final Object f26704g = new Object();

    /* renamed from: h */
    private final Object f26705h = new Object();

    /* renamed from: a */
    public final void mo31175a(int i) {
        synchronized (this.f26702e) {
            this.f26698a = i;
        }
    }

    /* renamed from: a */
    public final int mo31174a() {
        int i;
        synchronized (this.f26702e) {
            i = this.f26698a;
        }
        return i;
    }

    /* renamed from: a */
    public final void mo31176a(long j) {
        synchronized (this.f26703f) {
            this.f26699b = j;
        }
    }

    /* renamed from: b */
    public final long mo31177b() {
        long j;
        synchronized (this.f26703f) {
            j = this.f26699b;
        }
        return j;
    }

    /* renamed from: c */
    public final synchronized void mo31180c(long j) {
        synchronized (this.f26704g) {
            this.f26700c = j;
        }
    }

    /* renamed from: c */
    public final synchronized long mo31179c() {
        long j;
        synchronized (this.f26704g) {
            j = this.f26700c;
        }
        return j;
    }

    /* renamed from: b */
    public final synchronized void mo31178b(long j) {
        synchronized (this.f26705h) {
            this.f26701d = j;
        }
    }

    /* renamed from: d */
    public final synchronized long mo31181d() {
        long j;
        synchronized (this.f26705h) {
            j = this.f26701d;
        }
        return j;
    }
}
