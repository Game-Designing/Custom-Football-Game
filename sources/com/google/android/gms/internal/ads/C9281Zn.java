package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

/* renamed from: com.google.android.gms.internal.ads.Zn */
final class C9281Zn extends C9301_n {
    C9281Zn(byte[] bArr, int i) throws InvalidKeyException {
        super(bArr, i);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int[] mo28824a(int[] iArr, int i) {
        if (iArr.length == 3) {
            int[] iArr2 = new int[16];
            C9301_n.m23399a(iArr2, this.f22054b);
            iArr2[12] = i;
            System.arraycopy(iArr, 0, iArr2, 13, iArr.length);
            return iArr2;
        }
        throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", new Object[]{Integer.valueOf(iArr.length << 5)}));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final int mo28823a() {
        return 12;
    }
}
