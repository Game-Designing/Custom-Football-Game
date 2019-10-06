package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaExtractor;

public final class zzgb {

    /* renamed from: a */
    public byte[] f28425a;

    /* renamed from: b */
    private byte[] f28426b;

    /* renamed from: c */
    private int f28427c;

    /* renamed from: d */
    public int[] f28428d;

    /* renamed from: e */
    public int[] f28429e;

    /* renamed from: f */
    private int f28430f;

    /* renamed from: g */
    private final CryptoInfo f28431g;

    public zzgb() {
        CryptoInfo cryptoInfo;
        if (zzkq.f28747a >= 16) {
            cryptoInfo = new CryptoInfo();
        } else {
            cryptoInfo = null;
        }
        this.f28431g = cryptoInfo;
    }

    /* renamed from: a */
    public final void mo31765a(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.f28430f = i;
        this.f28428d = iArr;
        this.f28429e = iArr2;
        this.f28426b = bArr;
        this.f28425a = bArr2;
        this.f28427c = 1;
        if (zzkq.f28747a >= 16) {
            this.f28431g.set(this.f28430f, this.f28428d, this.f28429e, this.f28426b, this.f28425a, this.f28427c);
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    public final void mo31766a(MediaExtractor mediaExtractor) {
        mediaExtractor.getSampleCryptoInfo(this.f28431g);
        CryptoInfo cryptoInfo = this.f28431g;
        this.f28430f = cryptoInfo.numSubSamples;
        this.f28428d = cryptoInfo.numBytesOfClearData;
        this.f28429e = cryptoInfo.numBytesOfEncryptedData;
        this.f28426b = cryptoInfo.key;
        this.f28425a = cryptoInfo.iv;
        this.f28427c = cryptoInfo.mode;
    }

    @TargetApi(16)
    /* renamed from: a */
    public final CryptoInfo mo31764a() {
        return this.f28431g;
    }
}
