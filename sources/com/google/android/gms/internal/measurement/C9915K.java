package com.google.android.gms.internal.measurement;

/* renamed from: com.google.android.gms.internal.measurement.K */
final class C9915K extends C9923O {

    /* renamed from: f */
    private final int f30012f;

    /* renamed from: g */
    private final int f30013g;

    C9915K(byte[] bArr, int i, int i2) {
        super(bArr);
        zzte.m32391b(i, i + i2, bArr.length);
        this.f30012f = i;
        this.f30013g = i2;
    }

    /* renamed from: a */
    public final byte mo32581a(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.f30022e[this.f30012f + i];
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
    public final byte mo32583h(int i) {
        return this.f30022e[this.f30012f + i];
    }

    public final int size() {
        return this.f30013g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public final int mo32582d() {
        return this.f30012f;
    }
}
