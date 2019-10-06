package com.google.android.gms.internal.ads;

import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

public final class zzst {

    /* renamed from: a */
    public byte[] f29334a;

    /* renamed from: b */
    private int f29335b;

    /* renamed from: c */
    private int f29336c;

    public zzst() {
    }

    public zzst(int i) {
        this.f29334a = new byte[i];
        this.f29336c = i;
    }

    public zzst(byte[] bArr) {
        this.f29334a = bArr;
        this.f29336c = bArr.length;
    }

    /* renamed from: a */
    public final void mo32195a(int i) {
        mo32196a(mo32194a() < i ? new byte[i] : this.f29334a, i);
    }

    /* renamed from: a */
    public final void mo32196a(byte[] bArr, int i) {
        this.f29334a = bArr;
        this.f29336c = i;
        this.f29335b = 0;
    }

    /* renamed from: i */
    public final void mo32209i() {
        this.f29335b = 0;
        this.f29336c = 0;
    }

    /* renamed from: n */
    public final int mo32214n() {
        return this.f29336c - this.f29335b;
    }

    /* renamed from: c */
    public final int mo32200c() {
        return this.f29336c;
    }

    /* renamed from: d */
    public final void mo32203d(int i) {
        zzsk.m31080a(i >= 0 && i <= this.f29334a.length);
        this.f29336c = i;
    }

    /* renamed from: b */
    public final int mo32198b() {
        return this.f29335b;
    }

    /* renamed from: a */
    public final int mo32194a() {
        byte[] bArr = this.f29334a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    /* renamed from: b */
    public final void mo32199b(int i) {
        zzsk.m31080a(i >= 0 && i <= this.f29336c);
        this.f29335b = i;
    }

    /* renamed from: c */
    public final void mo32201c(int i) {
        mo32199b(this.f29335b + i);
    }

    /* renamed from: a */
    public final void mo32197a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f29334a, this.f29335b, bArr, i, i2);
        this.f29335b += i2;
    }

    /* renamed from: g */
    public final int mo32207g() {
        byte[] bArr = this.f29334a;
        int i = this.f29335b;
        this.f29335b = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: h */
    public final int mo32208h() {
        byte[] bArr = this.f29334a;
        int i = this.f29335b;
        this.f29335b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.f29335b;
        this.f29335b = i3 + 1;
        return (bArr[i3] & 255) | i2;
    }

    /* renamed from: o */
    public final int mo32215o() {
        byte[] bArr = this.f29334a;
        int i = this.f29335b;
        this.f29335b = i + 1;
        byte b = bArr[i] & 255;
        int i2 = this.f29335b;
        this.f29335b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | b;
    }

    /* renamed from: f */
    public final short mo32206f() {
        byte[] bArr = this.f29334a;
        int i = this.f29335b;
        this.f29335b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.f29335b;
        this.f29335b = i3 + 1;
        return (short) ((bArr[i3] & 255) | i2);
    }

    /* renamed from: j */
    public final long mo32210j() {
        byte[] bArr = this.f29334a;
        int i = this.f29335b;
        this.f29335b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        int i2 = this.f29335b;
        this.f29335b = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16);
        int i3 = this.f29335b;
        this.f29335b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.f29335b;
        this.f29335b = i4 + 1;
        return j3 | (255 & ((long) bArr[i4]));
    }

    /* renamed from: p */
    public final long mo32216p() {
        byte[] bArr = this.f29334a;
        int i = this.f29335b;
        this.f29335b = i + 1;
        long j = ((long) bArr[i]) & 255;
        int i2 = this.f29335b;
        this.f29335b = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i3 = this.f29335b;
        this.f29335b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        int i4 = this.f29335b;
        this.f29335b = i4 + 1;
        return j3 | ((255 & ((long) bArr[i4])) << 24);
    }

    /* renamed from: d */
    public final int mo32202d() {
        byte[] bArr = this.f29334a;
        int i = this.f29335b;
        this.f29335b = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        int i3 = this.f29335b;
        this.f29335b = i3 + 1;
        byte b = i2 | ((bArr[i3] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO);
        int i4 = this.f29335b;
        this.f29335b = i4 + 1;
        byte b2 = b | ((bArr[i4] & 255) << 8);
        int i5 = this.f29335b;
        this.f29335b = i5 + 1;
        return (bArr[i5] & 255) | b2;
    }

    /* renamed from: e */
    public final long mo32204e() {
        byte[] bArr = this.f29334a;
        int i = this.f29335b;
        this.f29335b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i2 = this.f29335b;
        this.f29335b = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48);
        int i3 = this.f29335b;
        this.f29335b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 40);
        int i4 = this.f29335b;
        this.f29335b = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 32);
        int i5 = this.f29335b;
        this.f29335b = i5 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i6 = this.f29335b;
        this.f29335b = i6 + 1;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 16);
        int i7 = this.f29335b;
        this.f29335b = i7 + 1;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 8);
        int i8 = this.f29335b;
        this.f29335b = i8 + 1;
        return j7 | (255 & ((long) bArr[i8]));
    }

    /* renamed from: k */
    public final int mo32211k() {
        byte[] bArr = this.f29334a;
        int i = this.f29335b;
        this.f29335b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.f29335b;
        this.f29335b = i3 + 1;
        byte b = (bArr[i3] & 255) | i2;
        this.f29335b += 2;
        return b;
    }

    /* renamed from: l */
    public final int mo32212l() {
        int d = mo32202d();
        if (d >= 0) {
            return d;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(d);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: m */
    public final long mo32213m() {
        long e = mo32204e();
        if (e >= 0) {
            return e;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(e);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: e */
    public final String mo32205e(int i) {
        int i2;
        if (i == 0) {
            return "";
        }
        int i3 = (this.f29335b + i) - 1;
        if (i3 >= this.f29336c || this.f29334a[i3] != 0) {
            i2 = i;
        } else {
            i2 = i - 1;
        }
        String str = new String(this.f29334a, this.f29335b, i2);
        this.f29335b += i;
        return str;
    }
}
