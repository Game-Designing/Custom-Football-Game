package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;

public final class zzmz {

    /* renamed from: a */
    public byte[] f28928a;

    /* renamed from: b */
    private byte[] f28929b;

    /* renamed from: c */
    private int f28930c;

    /* renamed from: d */
    public int[] f28931d;

    /* renamed from: e */
    public int[] f28932e;

    /* renamed from: f */
    private int f28933f;

    /* renamed from: g */
    private int f28934g;

    /* renamed from: h */
    private int f28935h;

    /* renamed from: i */
    private final CryptoInfo f28936i;

    /* renamed from: j */
    private final C9180Ur f28937j;

    public zzmz() {
        CryptoInfo cryptoInfo;
        if (zzsy.f29345a >= 16) {
            cryptoInfo = new CryptoInfo();
        } else {
            cryptoInfo = null;
        }
        this.f28936i = cryptoInfo;
        this.f28937j = zzsy.f29345a >= 24 ? new C9180Ur(this.f28936i) : null;
    }

    /* renamed from: a */
    public final void mo32020a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f28933f = i;
        this.f28931d = iArr;
        this.f28932e = iArr2;
        this.f28929b = bArr;
        this.f28928a = bArr2;
        this.f28930c = i2;
        this.f28934g = 0;
        this.f28935h = 0;
        int i3 = zzsy.f29345a;
        if (i3 >= 16) {
            CryptoInfo cryptoInfo = this.f28936i;
            cryptoInfo.numSubSamples = this.f28933f;
            cryptoInfo.numBytesOfClearData = this.f28931d;
            cryptoInfo.numBytesOfEncryptedData = this.f28932e;
            cryptoInfo.key = this.f28929b;
            cryptoInfo.iv = this.f28928a;
            cryptoInfo.mode = this.f28930c;
            if (i3 >= 24) {
                this.f28937j.m23130a(0, 0);
            }
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    public final CryptoInfo mo32019a() {
        return this.f28936i;
    }
}
