package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzic implements zzip {

    /* renamed from: a */
    private final C9348br f28577a;

    /* renamed from: b */
    private final zzhm f28578b = new zzhm(0);

    /* renamed from: c */
    private boolean f28579c = true;

    /* renamed from: d */
    private long f28580d = Long.MIN_VALUE;

    /* renamed from: e */
    private long f28581e = Long.MIN_VALUE;

    /* renamed from: f */
    private volatile long f28582f = Long.MIN_VALUE;

    /* renamed from: g */
    private volatile zzhj f28583g;

    public zzic(zzjl zzjl) {
        this.f28577a = new C9348br(zzjl);
    }

    /* renamed from: a */
    public final void mo31845a() {
        this.f28577a.mo28877a();
        this.f28579c = true;
        this.f28580d = Long.MIN_VALUE;
        this.f28581e = Long.MIN_VALUE;
        this.f28582f = Long.MIN_VALUE;
    }

    /* renamed from: c */
    public final boolean mo31852c() {
        return this.f28583g != null;
    }

    /* renamed from: d */
    public final zzhj mo31853d() {
        return this.f28583g;
    }

    /* renamed from: e */
    public final long mo31854e() {
        return this.f28582f;
    }

    /* renamed from: b */
    public final boolean mo31850b() {
        return !m30425f();
    }

    /* renamed from: a */
    public final boolean mo31849a(zzhm zzhm) {
        if (!m30425f()) {
            return false;
        }
        this.f28577a.mo28883b(zzhm);
        this.f28579c = false;
        this.f28580d = zzhm.f28528e;
        return true;
    }

    /* renamed from: a */
    public final void mo31846a(long j) {
        while (this.f28577a.mo28881a(this.f28578b) && this.f28578b.f28528e < j) {
            this.f28577a.mo28882b();
            this.f28579c = true;
        }
        this.f28580d = Long.MIN_VALUE;
    }

    /* renamed from: b */
    public final boolean mo31851b(long j) {
        return this.f28577a.mo28880a(j);
    }

    /* renamed from: f */
    private final boolean m30425f() {
        boolean a = this.f28577a.mo28881a(this.f28578b);
        if (this.f28579c) {
            while (a && !this.f28578b.mo31811b()) {
                this.f28577a.mo28882b();
                a = this.f28577a.mo28881a(this.f28578b);
            }
        }
        if (!a) {
            return false;
        }
        long j = this.f28581e;
        if (j == Long.MIN_VALUE || this.f28578b.f28528e < j) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final void mo31847a(zzhj zzhj) {
        this.f28583g = zzhj;
    }

    /* renamed from: a */
    public final int mo31844a(zzie zzie, int i) throws IOException, InterruptedException {
        return this.f28577a.mo28876a(zzie, i);
    }

    /* renamed from: a */
    public final void mo31848a(zzkm zzkm, int i) {
        this.f28577a.mo28879a(zzkm, i);
    }

    /* renamed from: a */
    public void mo28863a(long j, int i, int i2, int i3, byte[] bArr) {
        long j2 = j;
        this.f28582f = Math.max(this.f28582f, j);
        C9348br brVar = this.f28577a;
        int i4 = i2;
        brVar.mo28878a(j2, i, (brVar.mo28884c() - ((long) i4)) - ((long) i3), i4, bArr);
    }
}
