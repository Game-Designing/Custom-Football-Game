package com.google.android.gms.internal.ads;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.io.IOException;

public abstract class zzdnd {

    /* renamed from: a */
    int f27976a;

    /* renamed from: b */
    int f27977b;

    /* renamed from: c */
    private int f27978c;

    /* renamed from: d */
    C8817Do f27979d;

    /* renamed from: e */
    private boolean f27980e;

    /* renamed from: a */
    static zzdnd m29671a(byte[] bArr, int i, int i2, boolean z) {
        C8796Co co = new C8796Co(bArr, i, i2, z);
        try {
            co.mo28084c(i2);
            return co;
        } catch (zzdok e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public abstract double mo28080a() throws IOException;

    /* renamed from: a */
    public abstract void mo28081a(int i) throws zzdok;

    /* renamed from: b */
    public abstract float mo28082b() throws IOException;

    /* renamed from: b */
    public abstract boolean mo28083b(int i) throws IOException;

    /* renamed from: c */
    public abstract int mo28084c(int i) throws zzdok;

    /* renamed from: c */
    public abstract String mo28085c() throws IOException;

    /* renamed from: d */
    public abstract int mo28086d() throws IOException;

    /* renamed from: d */
    public abstract void mo28087d(int i);

    /* renamed from: e */
    public abstract long mo28088e() throws IOException;

    /* renamed from: f */
    public abstract long mo28089f() throws IOException;

    /* renamed from: g */
    public abstract int mo28090g() throws IOException;

    /* renamed from: h */
    public abstract long mo28091h() throws IOException;

    /* renamed from: i */
    public abstract int mo28092i() throws IOException;

    /* renamed from: j */
    public abstract boolean mo28093j() throws IOException;

    /* renamed from: k */
    public abstract String mo28094k() throws IOException;

    /* renamed from: l */
    public abstract zzdmr mo28095l() throws IOException;

    /* renamed from: m */
    public abstract int mo28096m() throws IOException;

    /* renamed from: n */
    public abstract int mo28097n() throws IOException;

    /* renamed from: o */
    public abstract int mo28098o() throws IOException;

    /* renamed from: p */
    public abstract long mo28099p() throws IOException;

    /* renamed from: q */
    public abstract int mo28100q() throws IOException;

    /* renamed from: r */
    public abstract long mo28101r() throws IOException;

    /* renamed from: s */
    public abstract boolean mo28102s() throws IOException;

    /* renamed from: t */
    public abstract int mo28103t();

    private zzdnd() {
        this.f27977b = 100;
        this.f27978c = MoPubClientPositioning.NO_REPEAT;
        this.f27980e = false;
    }

    /* renamed from: e */
    public static int m29672e(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    /* renamed from: a */
    public static long m29670a(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }
}
