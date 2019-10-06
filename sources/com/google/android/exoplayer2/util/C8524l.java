package com.google.android.exoplayer2.util;

/* renamed from: com.google.android.exoplayer2.util.l */
/* compiled from: FlacStreamInfo */
public final class C8524l {

    /* renamed from: a */
    public final int f18821a;

    /* renamed from: b */
    public final int f18822b;

    /* renamed from: c */
    public final int f18823c;

    /* renamed from: d */
    public final int f18824d;

    /* renamed from: e */
    public final int f18825e;

    /* renamed from: f */
    public final int f18826f;

    /* renamed from: g */
    public final int f18827g;

    /* renamed from: h */
    public final long f18828h;

    public C8524l(byte[] data, int offset) {
        C8534s scratch = new C8534s(data);
        scratch.mo26099b(offset * 8);
        this.f18821a = scratch.mo26092a(16);
        this.f18822b = scratch.mo26092a(16);
        this.f18823c = scratch.mo26092a(24);
        this.f18824d = scratch.mo26092a(24);
        this.f18825e = scratch.mo26092a(20);
        this.f18826f = scratch.mo26092a(3) + 1;
        this.f18827g = scratch.mo26092a(5) + 1;
        this.f18828h = ((((long) scratch.mo26092a(4)) & 15) << 32) | (((long) scratch.mo26092a(32)) & 4294967295L);
    }

    /* renamed from: a */
    public int mo26086a() {
        return this.f18827g * this.f18825e;
    }

    /* renamed from: b */
    public long mo26087b() {
        return (this.f18828h * 1000000) / ((long) this.f18825e);
    }
}
