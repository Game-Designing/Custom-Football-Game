package org.jacoco.agent.p025rt.internal_8ff85ea.asm;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.ByteVector */
public class ByteVector {
    byte[] data;
    int length;

    public ByteVector() {
        this.data = new byte[64];
    }

    public ByteVector(int initialSize) {
        this.data = new byte[initialSize];
    }

    public ByteVector putByte(int b) {
        int length2 = this.length;
        if (length2 + 1 > this.data.length) {
            enlarge(1);
        }
        int length3 = length2 + 1;
        this.data[length2] = (byte) b;
        this.length = length3;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public ByteVector put11(int b1, int b2) {
        int length2 = this.length;
        if (length2 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] data2 = this.data;
        int length3 = length2 + 1;
        data2[length2] = (byte) b1;
        int length4 = length3 + 1;
        data2[length3] = (byte) b2;
        this.length = length4;
        return this;
    }

    public ByteVector putShort(int s) {
        int length2 = this.length;
        if (length2 + 2 > this.data.length) {
            enlarge(2);
        }
        byte[] data2 = this.data;
        int length3 = length2 + 1;
        data2[length2] = (byte) (s >>> 8);
        int length4 = length3 + 1;
        data2[length3] = (byte) s;
        this.length = length4;
        return this;
    }

    /* access modifiers changed from: 0000 */
    public ByteVector put12(int b, int s) {
        int length2 = this.length;
        if (length2 + 3 > this.data.length) {
            enlarge(3);
        }
        byte[] data2 = this.data;
        int length3 = length2 + 1;
        data2[length2] = (byte) b;
        int length4 = length3 + 1;
        data2[length3] = (byte) (s >>> 8);
        int length5 = length4 + 1;
        data2[length4] = (byte) s;
        this.length = length5;
        return this;
    }

    public ByteVector putInt(int i) {
        int length2 = this.length;
        if (length2 + 4 > this.data.length) {
            enlarge(4);
        }
        byte[] data2 = this.data;
        int length3 = length2 + 1;
        data2[length2] = (byte) (i >>> 24);
        int length4 = length3 + 1;
        data2[length3] = (byte) (i >>> 16);
        int length5 = length4 + 1;
        data2[length4] = (byte) (i >>> 8);
        int length6 = length5 + 1;
        data2[length5] = (byte) i;
        this.length = length6;
        return this;
    }

    public ByteVector putLong(long l) {
        int length2 = this.length;
        if (length2 + 8 > this.data.length) {
            enlarge(8);
        }
        byte[] data2 = this.data;
        int i = (int) (l >>> 32);
        int length3 = length2 + 1;
        data2[length2] = (byte) (i >>> 24);
        int length4 = length3 + 1;
        data2[length3] = (byte) (i >>> 16);
        int length5 = length4 + 1;
        data2[length4] = (byte) (i >>> 8);
        int length6 = length5 + 1;
        data2[length5] = (byte) i;
        int i2 = (int) l;
        int i3 = length6 + 1;
        data2[length6] = (byte) (i2 >>> 24);
        int length7 = i3 + 1;
        data2[i3] = (byte) (i2 >>> 16);
        int length8 = length7 + 1;
        data2[length7] = (byte) (i2 >>> 8);
        int length9 = length8 + 1;
        data2[length8] = (byte) i2;
        this.length = length9;
        return this;
    }

    public ByteVector putUTF8(String s) {
        int charLength = s.length();
        if (charLength <= 65535) {
            int len = this.length;
            if (len + 2 + charLength > this.data.length) {
                enlarge(charLength + 2);
            }
            byte[] data2 = this.data;
            int len2 = len + 1;
            data2[len] = (byte) (charLength >>> 8);
            int len3 = len2 + 1;
            data2[len2] = (byte) charLength;
            int i = 0;
            while (i < charLength) {
                char c = s.charAt(i);
                if (c < 1 || c > 127) {
                    this.length = len3;
                    return encodeUTF8(s, i, 65535);
                }
                int len4 = len3 + 1;
                data2[len3] = (byte) c;
                i++;
                len3 = len4;
            }
            this.length = len3;
            return this;
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: 0000 */
    public ByteVector encodeUTF8(String s, int i, int maxByteLength) {
        int charLength = s.length();
        int byteLength = i;
        for (int j = i; j < charLength; j++) {
            char c = s.charAt(j);
            if (c >= 1 && c <= 127) {
                byteLength++;
            } else if (c > 2047) {
                byteLength += 3;
            } else {
                byteLength += 2;
            }
        }
        if (byteLength <= maxByteLength) {
            int start = (this.length - i) - 2;
            if (start >= 0) {
                byte[] bArr = this.data;
                bArr[start] = (byte) (byteLength >>> 8);
                bArr[start + 1] = (byte) byteLength;
            }
            if ((this.length + byteLength) - i > this.data.length) {
                enlarge(byteLength - i);
            }
            int len = this.length;
            for (int j2 = i; j2 < charLength; j2++) {
                char c2 = s.charAt(j2);
                if (c2 >= 1 && c2 <= 127) {
                    int len2 = len + 1;
                    this.data[len] = (byte) c2;
                    len = len2;
                } else if (c2 > 2047) {
                    byte[] bArr2 = this.data;
                    int len3 = len + 1;
                    bArr2[len] = (byte) (((c2 >> 12) & 15) | 224);
                    int len4 = len3 + 1;
                    bArr2[len3] = (byte) (((c2 >> 6) & 63) | 128);
                    int len5 = len4 + 1;
                    bArr2[len4] = (byte) ((c2 & '?') | 128);
                    len = len5;
                } else {
                    byte[] bArr3 = this.data;
                    int len6 = len + 1;
                    bArr3[len] = (byte) (((c2 >> 6) & 31) | Opcodes.CHECKCAST);
                    len = len6 + 1;
                    bArr3[len6] = (byte) ((c2 & '?') | 128);
                }
            }
            this.length = len;
            return this;
        }
        throw new IllegalArgumentException();
    }

    public ByteVector putByteArray(byte[] b, int off, int len) {
        if (this.length + len > this.data.length) {
            enlarge(len);
        }
        if (b != null) {
            System.arraycopy(b, off, this.data, this.length, len);
        }
        this.length += len;
        return this;
    }

    private void enlarge(int size) {
        int length1 = this.data.length * 2;
        int length2 = this.length + size;
        byte[] newData = new byte[(length1 > length2 ? length1 : length2)];
        System.arraycopy(this.data, 0, newData, 0, this.length);
        this.data = newData;
    }
}
