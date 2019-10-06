package com.google.android.gms.internal.ads;

import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzdmh {

    /* renamed from: a */
    private final byte[] f27968a = new byte[Opcodes.ACC_NATIVE];

    /* renamed from: b */
    private int f27969b;

    /* renamed from: c */
    private int f27970c;

    public zzdmh(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f27968a[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr2 = this.f27968a;
            b = (b + bArr2[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = bArr2[i2];
            bArr2[i2] = bArr2[b];
            bArr2[b] = b2;
        }
        this.f27969b = 0;
        this.f27970c = 0;
    }

    /* renamed from: a */
    public final void mo31529a(byte[] bArr) {
        int i = this.f27969b;
        int i2 = this.f27970c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.f27968a;
            i2 = (i2 + bArr2[i]) & 255;
            byte b = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        this.f27969b = i;
        this.f27970c = i2;
    }
}
