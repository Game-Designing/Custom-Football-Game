package com.google.android.exoplayer2.util;

import java.nio.charset.Charset;
import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

/* renamed from: com.google.android.exoplayer2.util.t */
/* compiled from: ParsableByteArray */
public final class C8535t {

    /* renamed from: a */
    public byte[] f18861a;

    /* renamed from: b */
    private int f18862b;

    /* renamed from: c */
    private int f18863c;

    public C8535t() {
        this.f18861a = C8509F.f18798f;
    }

    public C8535t(int limit) {
        this.f18861a = new byte[limit];
        this.f18863c = limit;
    }

    public C8535t(byte[] data) {
        this.f18861a = data;
        this.f18863c = data.length;
    }

    public C8535t(byte[] data, int limit) {
        this.f18861a = data;
        this.f18863c = limit;
    }

    /* renamed from: y */
    public void mo26139y() {
        this.f18862b = 0;
        this.f18863c = 0;
    }

    /* renamed from: c */
    public void mo26114c(int limit) {
        mo26109a(mo26111b() < limit ? new byte[limit] : this.f18861a, limit);
    }

    /* renamed from: a */
    public void mo26108a(byte[] data) {
        mo26109a(data, data.length);
    }

    /* renamed from: a */
    public void mo26109a(byte[] data, int limit) {
        this.f18861a = data;
        this.f18863c = limit;
        this.f18862b = 0;
    }

    /* renamed from: a */
    public int mo26104a() {
        return this.f18863c - this.f18862b;
    }

    /* renamed from: d */
    public int mo26115d() {
        return this.f18863c;
    }

    /* renamed from: d */
    public void mo26116d(int limit) {
        C8514e.m20488a(limit >= 0 && limit <= this.f18861a.length);
        this.f18863c = limit;
    }

    /* renamed from: c */
    public int mo26113c() {
        return this.f18862b;
    }

    /* renamed from: b */
    public int mo26111b() {
        return this.f18861a.length;
    }

    /* renamed from: e */
    public void mo26118e(int position) {
        C8514e.m20488a(position >= 0 && position <= this.f18863c);
        this.f18862b = position;
    }

    /* renamed from: f */
    public void mo26120f(int bytes) {
        mo26118e(this.f18862b + bytes);
    }

    /* renamed from: a */
    public void mo26107a(C8534s bitArray, int length) {
        mo26110a(bitArray.f18857a, 0, length);
        bitArray.mo26099b(0);
    }

    /* renamed from: a */
    public void mo26110a(byte[] buffer, int offset, int length) {
        System.arraycopy(this.f18861a, this.f18862b, buffer, offset, length);
        this.f18862b += length;
    }

    /* renamed from: q */
    public int mo26131q() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: w */
    public int mo26137w() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        return (bArr[i3] & 255) | i2;
    }

    /* renamed from: l */
    public int mo26126l() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        byte b = bArr[i] & 255;
        int i2 = this.f18862b;
        this.f18862b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | b;
    }

    /* renamed from: o */
    public short mo26129o() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        return (short) ((bArr[i3] & 255) | i2);
    }

    /* renamed from: t */
    public int mo26134t() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        int i2 = (bArr[i] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO;
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        byte b = i2 | ((bArr[i3] & 255) << 8);
        int i4 = this.f18862b;
        this.f18862b = i4 + 1;
        return (bArr[i4] & 255) | b;
    }

    /* renamed from: g */
    public int mo26121g() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        int i2 = ((bArr[i] & 255) << 24) >> 8;
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        byte b = i2 | ((bArr[i3] & 255) << 8);
        int i4 = this.f18862b;
        this.f18862b = i4 + 1;
        return (bArr[i4] & 255) | b;
    }

    /* renamed from: s */
    public long mo26133s() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        int i2 = this.f18862b;
        this.f18862b = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16);
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.f18862b;
        this.f18862b = i4 + 1;
        return j3 | (255 & ((long) bArr[i4]));
    }

    /* renamed from: j */
    public long mo26124j() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i2 = this.f18862b;
        this.f18862b = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.f18862b;
        this.f18862b = i4 + 1;
        return j3 | ((255 & ((long) bArr[i4])) << 24);
    }

    /* renamed from: f */
    public int mo26119f() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        byte b = i2 | ((bArr[i3] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO);
        int i4 = this.f18862b;
        this.f18862b = i4 + 1;
        byte b2 = b | ((bArr[i4] & 255) << 8);
        int i5 = this.f18862b;
        this.f18862b = i5 + 1;
        return (bArr[i5] & 255) | b2;
    }

    /* renamed from: h */
    public int mo26122h() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        byte b = bArr[i] & 255;
        int i2 = this.f18862b;
        this.f18862b = i2 + 1;
        byte b2 = b | ((bArr[i2] & 255) << 8);
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        byte b3 = b2 | ((bArr[i3] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO);
        int i4 = this.f18862b;
        this.f18862b = i4 + 1;
        return ((bArr[i4] & 255) << 24) | b3;
    }

    /* renamed from: m */
    public long mo26127m() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i2 = this.f18862b;
        this.f18862b = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48);
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 40);
        int i4 = this.f18862b;
        this.f18862b = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 32);
        int i5 = this.f18862b;
        this.f18862b = i5 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i6 = this.f18862b;
        this.f18862b = i6 + 1;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 16);
        int i7 = this.f18862b;
        this.f18862b = i7 + 1;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 8);
        int i8 = this.f18862b;
        this.f18862b = i8 + 1;
        return j7 | (255 & ((long) bArr[i8]));
    }

    /* renamed from: i */
    public long mo26123i() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i2 = this.f18862b;
        this.f18862b = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.f18862b;
        this.f18862b = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 24);
        int i5 = this.f18862b;
        this.f18862b = i5 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 32);
        int i6 = this.f18862b;
        this.f18862b = i6 + 1;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 40);
        int i7 = this.f18862b;
        this.f18862b = i7 + 1;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 48);
        int i8 = this.f18862b;
        this.f18862b = i8 + 1;
        return j7 | ((255 & ((long) bArr[i8])) << 56);
    }

    /* renamed from: r */
    public int mo26132r() {
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        this.f18862b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.f18862b;
        this.f18862b = i3 + 1;
        int result = (bArr[i3] & 255) | i2;
        this.f18862b += 2;
        return result;
    }

    /* renamed from: p */
    public int mo26130p() {
        return (mo26131q() << 21) | (mo26131q() << 14) | (mo26131q() << 7) | mo26131q();
    }

    /* renamed from: u */
    public int mo26135u() {
        int result = mo26119f();
        if (result >= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Top bit not zero: ");
        sb.append(result);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: k */
    public int mo26125k() {
        int result = mo26122h();
        if (result >= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Top bit not zero: ");
        sb.append(result);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: v */
    public long mo26136v() {
        long result = mo26127m();
        if (result >= 0) {
            return result;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Top bit not zero: ");
        sb.append(result);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: e */
    public double mo26117e() {
        return Double.longBitsToDouble(mo26127m());
    }

    /* renamed from: b */
    public String mo26112b(int length) {
        return mo26106a(length, Charset.forName("UTF-8"));
    }

    /* renamed from: a */
    public String mo26106a(int length, Charset charset) {
        String result = new String(this.f18861a, this.f18862b, length, charset);
        this.f18862b += length;
        return result;
    }

    /* renamed from: a */
    public String mo26105a(int length) {
        if (length == 0) {
            return "";
        }
        int stringLength = length;
        int lastIndex = (this.f18862b + length) - 1;
        if (lastIndex < this.f18863c && this.f18861a[lastIndex] == 0) {
            stringLength--;
        }
        String result = C8509F.m20447a(this.f18861a, this.f18862b, stringLength);
        this.f18862b += length;
        return result;
    }

    /* renamed from: n */
    public String mo26128n() {
        if (mo26104a() == 0) {
            return null;
        }
        int stringLimit = this.f18862b;
        while (stringLimit < this.f18863c && this.f18861a[stringLimit] != 0) {
            stringLimit++;
        }
        byte[] bArr = this.f18861a;
        int i = this.f18862b;
        String string = C8509F.m20447a(bArr, i, stringLimit - i);
        this.f18862b = stringLimit;
        int i2 = this.f18862b;
        if (i2 < this.f18863c) {
            this.f18862b = i2 + 1;
        }
        return string;
    }

    /* renamed from: x */
    public long mo26138x() {
        int length = 0;
        long value = (long) this.f18861a[this.f18862b];
        int j = 7;
        while (true) {
            if (j < 0) {
                break;
            } else if ((((long) (1 << j)) & value) != 0) {
                j--;
            } else if (j < 6) {
                value &= (long) ((1 << j) - 1);
                length = 7 - j;
            } else if (j == 7) {
                length = 1;
            }
        }
        if (length != 0) {
            int i = 1;
            while (i < length) {
                byte x = this.f18861a[this.f18862b + i];
                if ((x & 192) == 128) {
                    value = (value << 6) | ((long) (x & 63));
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Invalid UTF-8 sequence continuation byte: ");
                    sb.append(value);
                    throw new NumberFormatException(sb.toString());
                }
            }
            this.f18862b += length;
            return value;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Invalid UTF-8 sequence first byte: ");
        sb2.append(value);
        throw new NumberFormatException(sb2.toString());
    }
}
