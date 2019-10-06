package com.google.android.gms.internal.measurement;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

/* renamed from: com.google.android.gms.internal.measurement.S */
final class C9930S extends zztq {

    /* renamed from: d */
    private final byte[] f30031d;

    /* renamed from: e */
    private final boolean f30032e;

    /* renamed from: f */
    private int f30033f;

    /* renamed from: g */
    private int f30034g;

    /* renamed from: h */
    private int f30035h;

    /* renamed from: i */
    private int f30036i;

    /* renamed from: j */
    private int f30037j;

    private C9930S(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f30037j = MoPubClientPositioning.NO_REPEAT;
        this.f30031d = bArr;
        this.f30033f = i2 + i;
        this.f30035h = i;
        this.f30036i = this.f30035h;
        this.f30032e = z;
    }

    /* renamed from: a */
    public final int mo32618a(int i) throws zzuv {
        if (i >= 0) {
            int a = i + mo32617a();
            int i2 = this.f30037j;
            if (a <= i2) {
                this.f30037j = a;
                m31880b();
                return i2;
            }
            throw zzuv.m32550a();
        }
        throw zzuv.m32551b();
    }

    /* renamed from: b */
    private final void m31880b() {
        this.f30033f += this.f30034g;
        int i = this.f30033f;
        int i2 = i - this.f30036i;
        int i3 = this.f30037j;
        if (i2 > i3) {
            this.f30034g = i2 - i3;
            this.f30033f = i - this.f30034g;
            return;
        }
        this.f30034g = 0;
    }

    /* renamed from: a */
    public final int mo32617a() {
        return this.f30035h - this.f30036i;
    }
}
