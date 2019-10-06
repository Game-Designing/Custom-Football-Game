package com.google.zxing.p198b;

import java.util.Arrays;

/* renamed from: com.google.zxing.b.a */
/* compiled from: BitArray */
public final class C10208a implements Cloneable {

    /* renamed from: a */
    private int[] f30927a;

    /* renamed from: b */
    private int f30928b;

    public C10208a() {
        this.f30928b = 0;
        this.f30927a = new int[1];
    }

    C10208a(int[] bits, int size) {
        this.f30927a = bits;
        this.f30928b = size;
    }

    /* renamed from: a */
    public int mo33519a() {
        return this.f30928b;
    }

    /* renamed from: b */
    public int mo33525b() {
        return (this.f30928b + 7) / 8;
    }

    /* renamed from: b */
    private void m33236b(int size) {
        if (size > (this.f30927a.length << 5)) {
            int[] newBits = m33237c(size);
            int[] iArr = this.f30927a;
            System.arraycopy(iArr, 0, newBits, 0, iArr.length);
            this.f30927a = newBits;
        }
    }

    /* renamed from: a */
    public boolean mo33524a(int i) {
        return (this.f30927a[i / 32] & (1 << (i & 31))) != 0;
    }

    /* renamed from: a */
    public void mo33523a(boolean bit) {
        m33236b(this.f30928b + 1);
        if (bit) {
            int[] iArr = this.f30927a;
            int i = this.f30928b;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f30928b++;
    }

    /* renamed from: a */
    public void mo33520a(int value, int numBits) {
        if (numBits < 0 || numBits > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m33236b(this.f30928b + numBits);
        for (int numBitsLeft = numBits; numBitsLeft > 0; numBitsLeft--) {
            boolean z = true;
            if (((value >> (numBitsLeft - 1)) & 1) != 1) {
                z = false;
            }
            mo33523a(z);
        }
    }

    /* renamed from: a */
    public void mo33522a(C10208a other) {
        int otherSize = other.f30928b;
        m33236b(this.f30928b + otherSize);
        for (int i = 0; i < otherSize; i++) {
            mo33523a(other.mo33524a(i));
        }
    }

    /* renamed from: b */
    public void mo33526b(C10208a other) {
        if (this.f30928b == other.f30928b) {
            int i = 0;
            while (true) {
                int[] iArr = this.f30927a;
                if (i < iArr.length) {
                    iArr[i] = iArr[i] ^ other.f30927a[i];
                    i++;
                } else {
                    return;
                }
            }
        } else {
            throw new IllegalArgumentException("Sizes don't match");
        }
    }

    /* renamed from: a */
    public void mo33521a(int bitOffset, byte[] array, int offset, int numBytes) {
        for (int i = 0; i < numBytes; i++) {
            int theByte = 0;
            for (int j = 0; j < 8; j++) {
                if (mo33524a(bitOffset)) {
                    theByte |= 1 << (7 - j);
                }
                bitOffset++;
            }
            array[offset + i] = (byte) theByte;
        }
    }

    /* renamed from: c */
    private static int[] m33237c(int size) {
        return new int[((size + 31) / 32)];
    }

    public boolean equals(Object o) {
        boolean z = false;
        if (!(o instanceof C10208a)) {
            return false;
        }
        C10208a other = (C10208a) o;
        if (this.f30928b == other.f30928b && Arrays.equals(this.f30927a, other.f30927a)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (this.f30928b * 31) + Arrays.hashCode(this.f30927a);
    }

    public String toString() {
        StringBuilder result = new StringBuilder(this.f30928b);
        for (int i = 0; i < this.f30928b; i++) {
            if ((i & 7) == 0) {
                result.append(' ');
            }
            result.append(mo33524a(i) ? 'X' : '.');
        }
        return result.toString();
    }

    public C10208a clone() {
        return new C10208a((int[]) this.f30927a.clone(), this.f30928b);
    }
}
