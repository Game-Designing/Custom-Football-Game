package com.google.android.exoplayer2.util;

/* renamed from: com.google.android.exoplayer2.util.s */
/* compiled from: ParsableBitArray */
public final class C8534s {

    /* renamed from: a */
    public byte[] f18857a;

    /* renamed from: b */
    private int f18858b;

    /* renamed from: c */
    private int f18859c;

    /* renamed from: d */
    private int f18860d;

    public C8534s() {
        this.f18857a = C8509F.f18798f;
    }

    public C8534s(byte[] data) {
        this(data, data.length);
    }

    public C8534s(byte[] data, int limit) {
        this.f18857a = data;
        this.f18860d = limit;
    }

    /* renamed from: a */
    public void mo26095a(byte[] data) {
        mo26096a(data, data.length);
    }

    /* renamed from: a */
    public void mo26094a(C8535t parsableByteArray) {
        mo26096a(parsableByteArray.f18861a, parsableByteArray.mo26115d());
        mo26099b(parsableByteArray.mo26113c() * 8);
    }

    /* renamed from: a */
    public void mo26096a(byte[] data, int limit) {
        this.f18857a = data;
        this.f18858b = 0;
        this.f18859c = 0;
        this.f18860d = limit;
    }

    /* renamed from: a */
    public int mo26091a() {
        return ((this.f18860d - this.f18858b) * 8) - this.f18859c;
    }

    /* renamed from: c */
    public int mo26100c() {
        return (this.f18858b * 8) + this.f18859c;
    }

    /* renamed from: b */
    public void mo26099b(int position) {
        this.f18858b = position / 8;
        this.f18859c = position - (this.f18858b * 8);
        m20564f();
    }

    /* renamed from: e */
    public void mo26103e() {
        int i = this.f18859c + 1;
        this.f18859c = i;
        if (i == 8) {
            this.f18859c = 0;
            this.f18858b++;
        }
        m20564f();
    }

    /* renamed from: c */
    public void mo26101c(int numBits) {
        int numBytes = numBits / 8;
        this.f18858b += numBytes;
        this.f18859c += numBits - (numBytes * 8);
        int i = this.f18859c;
        if (i > 7) {
            this.f18858b++;
            this.f18859c = i - 8;
        }
        m20564f();
    }

    /* renamed from: d */
    public boolean mo26102d() {
        boolean returnValue = (this.f18857a[this.f18858b] & (128 >> this.f18859c)) != 0;
        mo26103e();
        return returnValue;
    }

    /* renamed from: a */
    public int mo26092a(int numBits) {
        int i;
        if (numBits == 0) {
            return 0;
        }
        int returnValue = 0;
        this.f18859c += numBits;
        while (true) {
            i = this.f18859c;
            if (i <= 8) {
                break;
            }
            this.f18859c = i - 8;
            byte[] bArr = this.f18857a;
            int i2 = this.f18858b;
            this.f18858b = i2 + 1;
            returnValue |= (bArr[i2] & 255) << this.f18859c;
        }
        byte[] bArr2 = this.f18857a;
        int i3 = this.f18858b;
        int returnValue2 = (returnValue | ((bArr2[i3] & 255) >> (8 - i))) & (-1 >>> (32 - numBits));
        if (i == 8) {
            this.f18859c = 0;
            this.f18858b = i3 + 1;
        }
        m20564f();
        return returnValue2;
    }

    /* renamed from: a */
    public void mo26097a(byte[] buffer, int offset, int numBits) {
        int to = (numBits >> 3) + offset;
        for (int i = offset; i < to; i++) {
            byte[] bArr = this.f18857a;
            int i2 = this.f18858b;
            this.f18858b = i2 + 1;
            byte b = bArr[i2];
            int i3 = this.f18859c;
            buffer[i] = (byte) (b << i3);
            buffer[i] = (byte) (((255 & bArr[this.f18858b]) >> (8 - i3)) | buffer[i]);
        }
        int bitsLeft = numBits & 7;
        if (bitsLeft != 0) {
            buffer[to] = (byte) (buffer[to] & (255 >> bitsLeft));
            int i4 = this.f18859c;
            if (i4 + bitsLeft > 8) {
                byte b2 = buffer[to];
                byte[] bArr2 = this.f18857a;
                int i5 = this.f18858b;
                this.f18858b = i5 + 1;
                buffer[to] = (byte) (b2 | ((bArr2[i5] & 255) << i4));
                this.f18859c = i4 - 8;
            }
            this.f18859c += bitsLeft;
            byte[] bArr3 = this.f18857a;
            int i6 = this.f18858b;
            byte b3 = 255 & bArr3[i6];
            int i7 = this.f18859c;
            buffer[to] = (byte) (buffer[to] | ((byte) ((b3 >> (8 - i7)) << (8 - bitsLeft))));
            if (i7 == 8) {
                this.f18859c = 0;
                this.f18858b = i6 + 1;
            }
            m20564f();
        }
    }

    /* renamed from: b */
    public void mo26098b() {
        if (this.f18859c != 0) {
            this.f18859c = 0;
            this.f18858b++;
            m20564f();
        }
    }

    /* renamed from: a */
    public void mo26093a(int value, int numBits) {
        int remainingBitsToRead = numBits;
        if (numBits < 32) {
            value &= (1 << numBits) - 1;
        }
        int firstByteReadSize = Math.min(8 - this.f18859c, numBits);
        int i = this.f18859c;
        int firstByteRightPaddingSize = (8 - i) - firstByteReadSize;
        int firstByteBitmask = (65280 >> i) | ((1 << firstByteRightPaddingSize) - 1);
        byte[] bArr = this.f18857a;
        int i2 = this.f18858b;
        bArr[i2] = (byte) (bArr[i2] & firstByteBitmask);
        bArr[i2] = (byte) (bArr[i2] | ((value >>> (numBits - firstByteReadSize)) << firstByteRightPaddingSize));
        int remainingBitsToRead2 = remainingBitsToRead - firstByteReadSize;
        int currentByteIndex = i2 + 1;
        while (remainingBitsToRead2 > 8) {
            int currentByteIndex2 = currentByteIndex + 1;
            this.f18857a[currentByteIndex] = (byte) (value >>> (remainingBitsToRead2 - 8));
            remainingBitsToRead2 -= 8;
            currentByteIndex = currentByteIndex2;
        }
        int lastByteRightPaddingSize = 8 - remainingBitsToRead2;
        byte[] bArr2 = this.f18857a;
        bArr2[currentByteIndex] = (byte) (bArr2[currentByteIndex] & ((1 << lastByteRightPaddingSize) - 1));
        bArr2[currentByteIndex] = (byte) (bArr2[currentByteIndex] | ((value & ((1 << remainingBitsToRead2) - 1)) << lastByteRightPaddingSize));
        mo26101c(numBits);
        m20564f();
    }

    /* renamed from: f */
    private void m20564f() {
        boolean z;
        int i = this.f18858b;
        if (i >= 0) {
            int i2 = this.f18860d;
            if (i < i2 || (i == i2 && this.f18859c == 0)) {
                z = true;
                C8514e.m20490b(z);
            }
        }
        z = false;
        C8514e.m20490b(z);
    }
}
