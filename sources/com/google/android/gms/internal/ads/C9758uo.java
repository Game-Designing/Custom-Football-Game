package com.google.android.gms.internal.ads;

/* renamed from: com.google.android.gms.internal.ads.uo */
final class C9758uo extends C9863zo {

    /* renamed from: f */
    private final int f23229f;

    /* renamed from: g */
    private final int f23230g;

    C9758uo(byte[] bArr, int i, int i2) {
        super(bArr);
        zzdmr.m29655b(i, i + i2, bArr.length);
        this.f23229f = i;
        this.f23230g = i2;
    }

    /* renamed from: a */
    public final byte mo29209a(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.f23750e[this.f23229f + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: h */
    public final byte mo29212h(int i) {
        return this.f23750e[this.f23229f + i];
    }

    public final int size() {
        return this.f23230g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public final int mo29211f() {
        return this.f23229f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo29210a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f23750e, mo29211f(), bArr, 0, i3);
    }
}
