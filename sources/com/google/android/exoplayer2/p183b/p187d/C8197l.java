package com.google.android.exoplayer2.p183b.p187d;

import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.b.d.l */
/* compiled from: VorbisBitArray */
final class C8197l {

    /* renamed from: a */
    private final byte[] f17103a;

    /* renamed from: b */
    private final int f17104b;

    /* renamed from: c */
    private int f17105c;

    /* renamed from: d */
    private int f17106d;

    public C8197l(byte[] data) {
        this.f17103a = data;
        this.f17104b = data.length;
    }

    /* renamed from: b */
    public boolean mo25283b() {
        boolean returnValue = (((this.f17103a[this.f17105c] & 255) >> this.f17106d) & 1) == 1;
        mo25282b(1);
        return returnValue;
    }

    /* renamed from: a */
    public int mo25281a(int numBits) {
        int tempByteOffset = this.f17105c;
        int bitsRead = Math.min(numBits, 8 - this.f17106d);
        int tempByteOffset2 = tempByteOffset + 1;
        int returnValue = ((this.f17103a[tempByteOffset] & 255) >> this.f17106d) & (255 >> (8 - bitsRead));
        while (bitsRead < numBits) {
            returnValue |= (this.f17103a[tempByteOffset2] & 255) << bitsRead;
            bitsRead += 8;
            tempByteOffset2++;
        }
        int returnValue2 = returnValue & (-1 >>> (32 - numBits));
        mo25282b(numBits);
        return returnValue2;
    }

    /* renamed from: b */
    public void mo25282b(int numBits) {
        int numBytes = numBits / 8;
        this.f17105c += numBytes;
        this.f17106d += numBits - (numBytes * 8);
        int i = this.f17106d;
        if (i > 7) {
            this.f17105c++;
            this.f17106d = i - 8;
        }
        m18863c();
    }

    /* renamed from: a */
    public int mo25280a() {
        return (this.f17105c * 8) + this.f17106d;
    }

    /* renamed from: c */
    private void m18863c() {
        boolean z;
        int i = this.f17105c;
        if (i >= 0) {
            int i2 = this.f17104b;
            if (i < i2 || (i == i2 && this.f17106d == 0)) {
                z = true;
                C8514e.m20490b(z);
            }
        }
        z = false;
        C8514e.m20490b(z);
    }
}
