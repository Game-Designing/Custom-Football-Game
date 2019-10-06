package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzrz implements zzrt {

    /* renamed from: a */
    private final boolean f29275a;

    /* renamed from: b */
    private final int f29276b;

    /* renamed from: c */
    private final byte[] f29277c;

    /* renamed from: d */
    private final zzrs[] f29278d;

    /* renamed from: e */
    private int f29279e;

    /* renamed from: f */
    private int f29280f;

    /* renamed from: g */
    private int f29281g;

    /* renamed from: h */
    private zzrs[] f29282h;

    public zzrz(boolean z, int i) {
        this(true, 65536, 0);
    }

    private zzrz(boolean z, int i, int i2) {
        zzsk.m31080a(true);
        zzsk.m31080a(true);
        this.f29275a = true;
        this.f29276b = 65536;
        this.f29281g = 0;
        this.f29282h = new zzrs[100];
        this.f29277c = null;
        this.f29278d = new zzrs[1];
    }

    /* renamed from: d */
    public final synchronized void mo32178d() {
        if (this.f29275a) {
            mo32177a(0);
        }
    }

    /* renamed from: a */
    public final synchronized void mo32177a(int i) {
        boolean z = i < this.f29279e;
        this.f29279e = i;
        if (z) {
            mo32174c();
        }
    }

    /* renamed from: b */
    public final synchronized zzrs mo32173b() {
        zzrs zzrs;
        this.f29280f++;
        if (this.f29281g > 0) {
            zzrs[] zzrsArr = this.f29282h;
            int i = this.f29281g - 1;
            this.f29281g = i;
            zzrs = zzrsArr[i];
            this.f29282h[this.f29281g] = null;
        } else {
            zzrs = new zzrs(new byte[this.f29276b], 0);
        }
        return zzrs;
    }

    /* renamed from: a */
    public final synchronized void mo32171a(zzrs zzrs) {
        this.f29278d[0] = zzrs;
        mo32172a(this.f29278d);
    }

    /* renamed from: a */
    public final synchronized void mo32172a(zzrs[] zzrsArr) {
        boolean z;
        if (this.f29281g + zzrsArr.length >= this.f29282h.length) {
            this.f29282h = (zzrs[]) Arrays.copyOf(this.f29282h, Math.max(this.f29282h.length << 1, this.f29281g + zzrsArr.length));
        }
        for (zzrs zzrs : zzrsArr) {
            if (zzrs.f29261a != null) {
                if (zzrs.f29261a.length != this.f29276b) {
                    z = false;
                    zzsk.m31080a(z);
                    zzrs[] zzrsArr2 = this.f29282h;
                    int i = this.f29281g;
                    this.f29281g = i + 1;
                    zzrsArr2[i] = zzrs;
                }
            }
            z = true;
            zzsk.m31080a(z);
            zzrs[] zzrsArr22 = this.f29282h;
            int i2 = this.f29281g;
            this.f29281g = i2 + 1;
            zzrsArr22[i2] = zzrs;
        }
        this.f29280f -= zzrsArr.length;
        notifyAll();
    }

    /* renamed from: c */
    public final synchronized void mo32174c() {
        int max = Math.max(0, zzsy.m31145a(this.f29279e, this.f29276b) - this.f29280f);
        if (max < this.f29281g) {
            Arrays.fill(this.f29282h, max, this.f29281g, null);
            this.f29281g = max;
        }
    }

    /* renamed from: e */
    public final synchronized int mo32179e() {
        return this.f29280f * this.f29276b;
    }

    /* renamed from: a */
    public final int mo32170a() {
        return this.f29276b;
    }
}
