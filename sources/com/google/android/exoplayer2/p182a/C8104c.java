package com.google.android.exoplayer2.p182a;

import android.annotation.TargetApi;
import android.media.MediaCodec.CryptoInfo;
import android.media.MediaCodec.CryptoInfo.Pattern;
import com.google.android.exoplayer2.util.C8509F;

/* renamed from: com.google.android.exoplayer2.a.c */
/* compiled from: CryptoInfo */
public final class C8104c {

    /* renamed from: a */
    public byte[] f16533a;

    /* renamed from: b */
    public byte[] f16534b;

    /* renamed from: c */
    public int f16535c;

    /* renamed from: d */
    public int[] f16536d;

    /* renamed from: e */
    public int[] f16537e;

    /* renamed from: f */
    public int f16538f;

    /* renamed from: g */
    public int f16539g;

    /* renamed from: h */
    public int f16540h;

    /* renamed from: i */
    private final CryptoInfo f16541i;

    /* renamed from: j */
    private final C8105a f16542j;

    @TargetApi(24)
    /* renamed from: com.google.android.exoplayer2.a.c$a */
    /* compiled from: CryptoInfo */
    private static final class C8105a {

        /* renamed from: a */
        private final CryptoInfo f16543a;

        /* renamed from: b */
        private final Pattern f16544b;

        private C8105a(CryptoInfo frameworkCryptoInfo) {
            this.f16543a = frameworkCryptoInfo;
            this.f16544b = new Pattern(0, 0);
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m18273a(int encryptedBlocks, int clearBlocks) {
            this.f16544b.set(encryptedBlocks, clearBlocks);
            this.f16543a.setPattern(this.f16544b);
        }
    }

    public C8104c() {
        this.f16541i = C8509F.f18793a >= 16 ? m18269b() : null;
        this.f16542j = C8509F.f18793a >= 24 ? new C8105a(this.f16541i) : null;
    }

    /* renamed from: a */
    public void mo25028a(int numSubSamples, int[] numBytesOfClearData, int[] numBytesOfEncryptedData, byte[] key, byte[] iv, int mode, int encryptedBlocks, int clearBlocks) {
        this.f16538f = numSubSamples;
        this.f16536d = numBytesOfClearData;
        this.f16537e = numBytesOfEncryptedData;
        this.f16534b = key;
        this.f16533a = iv;
        this.f16535c = mode;
        this.f16539g = encryptedBlocks;
        this.f16540h = clearBlocks;
        if (C8509F.f18793a >= 16) {
            m18270c();
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    public CryptoInfo mo25027a() {
        return this.f16541i;
    }

    @TargetApi(16)
    /* renamed from: b */
    private CryptoInfo m18269b() {
        return new CryptoInfo();
    }

    @TargetApi(16)
    /* renamed from: c */
    private void m18270c() {
        CryptoInfo cryptoInfo = this.f16541i;
        cryptoInfo.numSubSamples = this.f16538f;
        cryptoInfo.numBytesOfClearData = this.f16536d;
        cryptoInfo.numBytesOfEncryptedData = this.f16537e;
        cryptoInfo.key = this.f16534b;
        cryptoInfo.iv = this.f16533a;
        cryptoInfo.mode = this.f16535c;
        if (C8509F.f18793a >= 24) {
            this.f16542j.m18273a(this.f16539g, this.f16540h);
        }
    }
}
