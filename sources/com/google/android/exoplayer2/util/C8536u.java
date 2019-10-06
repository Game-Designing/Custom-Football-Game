package com.google.android.exoplayer2.util;

/* renamed from: com.google.android.exoplayer2.util.u */
/* compiled from: ParsableNalUnitBitArray */
public final class C8536u {

    /* renamed from: a */
    private byte[] f18864a;

    /* renamed from: b */
    private int f18865b;

    /* renamed from: c */
    private int f18866c;

    /* renamed from: d */
    private int f18867d;

    public C8536u(byte[] data, int offset, int limit) {
        mo26140a(data, offset, limit);
    }

    /* renamed from: a */
    public void mo26140a(byte[] data, int offset, int limit) {
        this.f18864a = data;
        this.f18866c = offset;
        this.f18865b = limit;
        this.f18867d = 0;
        m20615f();
    }

    /* renamed from: e */
    public void mo26148e() {
        int i = 1;
        int i2 = this.f18867d + 1;
        this.f18867d = i2;
        if (i2 == 8) {
            this.f18867d = 0;
            int i3 = this.f18866c;
            if (m20614d(i3 + 1)) {
                i = 2;
            }
            this.f18866c = i3 + i;
        }
        m20615f();
    }

    /* renamed from: c */
    public void mo26146c(int numBits) {
        int oldByteOffset = this.f18866c;
        int numBytes = numBits / 8;
        this.f18866c += numBytes;
        this.f18867d += numBits - (numBytes * 8);
        int i = this.f18867d;
        if (i > 7) {
            this.f18866c++;
            this.f18867d = i - 8;
        }
        int i2 = oldByteOffset + 1;
        while (i2 <= this.f18866c) {
            if (m20614d(i2)) {
                this.f18866c++;
                i2 += 2;
            }
            i2++;
        }
        m20615f();
    }

    /* renamed from: a */
    public boolean mo26142a(int numBits) {
        int oldByteOffset = this.f18866c;
        int numBytes = numBits / 8;
        int newByteOffset = this.f18866c + numBytes;
        int newBitOffset = (this.f18867d + numBits) - (numBytes * 8);
        if (newBitOffset > 7) {
            newByteOffset++;
            newBitOffset -= 8;
        }
        int i = oldByteOffset + 1;
        while (i <= newByteOffset && newByteOffset < this.f18865b) {
            if (m20614d(i)) {
                newByteOffset++;
                i += 2;
            }
            i++;
        }
        int i2 = this.f18865b;
        if (newByteOffset < i2) {
            return true;
        }
        if (newByteOffset == i2 && newBitOffset == 0) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo26144b() {
        boolean returnValue = (this.f18864a[this.f18866c] & (128 >> this.f18867d)) != 0;
        mo26148e();
        return returnValue;
    }

    /* renamed from: b */
    public int mo26143b(int numBits) {
        int i;
        int i2;
        int returnValue = 0;
        this.f18867d += numBits;
        while (true) {
            i = this.f18867d;
            i2 = 2;
            if (i <= 8) {
                break;
            }
            this.f18867d = i - 8;
            byte[] bArr = this.f18864a;
            int i3 = this.f18866c;
            returnValue |= (bArr[i3] & 255) << this.f18867d;
            if (!m20614d(i3 + 1)) {
                i2 = 1;
            }
            this.f18866c = i3 + i2;
        }
        byte[] bArr2 = this.f18864a;
        int i4 = this.f18866c;
        int returnValue2 = (returnValue | ((bArr2[i4] & 255) >> (8 - i))) & (-1 >>> (32 - numBits));
        if (i == 8) {
            this.f18867d = 0;
            if (!m20614d(i4 + 1)) {
                i2 = 1;
            }
            this.f18866c = i4 + i2;
        }
        m20615f();
        return returnValue2;
    }

    /* renamed from: a */
    public boolean mo26141a() {
        int initialByteOffset = this.f18866c;
        int initialBitOffset = this.f18867d;
        int leadingZeros = 0;
        while (this.f18866c < this.f18865b && !mo26144b()) {
            leadingZeros++;
        }
        boolean hitLimit = this.f18866c == this.f18865b;
        this.f18866c = initialByteOffset;
        this.f18867d = initialBitOffset;
        if (hitLimit || !mo26142a((leadingZeros * 2) + 1)) {
            return false;
        }
        return true;
    }

    /* renamed from: d */
    public int mo26147d() {
        return m20616g();
    }

    /* renamed from: c */
    public int mo26145c() {
        int codeNum = m20616g();
        return (codeNum % 2 == 0 ? -1 : 1) * ((codeNum + 1) / 2);
    }

    /* renamed from: g */
    private int m20616g() {
        int leadingZeros = 0;
        while (!mo26144b()) {
            leadingZeros++;
        }
        return ((1 << leadingZeros) - 1) + (leadingZeros > 0 ? mo26143b(leadingZeros) : 0);
    }

    /* renamed from: d */
    private boolean m20614d(int offset) {
        if (2 <= offset && offset < this.f18865b) {
            byte[] bArr = this.f18864a;
            if (bArr[offset] == 3 && bArr[offset - 2] == 0 && bArr[offset - 1] == 0) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    private void m20615f() {
        boolean z;
        int i = this.f18866c;
        if (i >= 0) {
            int i2 = this.f18865b;
            if (i < i2 || (i == i2 && this.f18867d == 0)) {
                z = true;
                C8514e.m20490b(z);
            }
        }
        z = false;
        C8514e.m20490b(z);
    }
}
