package com.google.android.gms.internal.ads;

import org.jacoco.agent.p025rt.internal_8ff85ea.core.data.ExecutionDataWriter;

public final class zzkm {

    /* renamed from: a */
    public byte[] f28743a;

    /* renamed from: b */
    private int f28744b;

    /* renamed from: c */
    private int f28745c;

    public zzkm() {
    }

    public zzkm(int i) {
        this.f28743a = new byte[i];
        this.f28745c = this.f28743a.length;
    }

    public zzkm(byte[] bArr) {
        this.f28743a = bArr;
        this.f28745c = bArr.length;
    }

    /* renamed from: a */
    public final void mo31891a(byte[] bArr, int i) {
        this.f28743a = bArr;
        this.f28745c = i;
        this.f28744b = 0;
    }

    /* renamed from: b */
    public final int mo31893b() {
        return this.f28745c;
    }

    /* renamed from: a */
    public final int mo31889a() {
        return this.f28744b;
    }

    /* renamed from: a */
    public final void mo31890a(int i) {
        zzkh.m30535a(i >= 0 && i <= this.f28745c);
        this.f28744b = i;
    }

    /* renamed from: b */
    public final void mo31894b(int i) {
        mo31890a(this.f28744b + i);
    }

    /* renamed from: a */
    public final void mo31892a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f28743a, this.f28744b, bArr, i, i2);
        this.f28744b += i2;
    }

    /* renamed from: e */
    public final int mo31897e() {
        byte[] bArr = this.f28743a;
        int i = this.f28744b;
        this.f28744b = i + 1;
        return bArr[i] & 255;
    }

    /* renamed from: f */
    public final int mo31898f() {
        byte[] bArr = this.f28743a;
        int i = this.f28744b;
        this.f28744b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.f28744b;
        this.f28744b = i3 + 1;
        return (bArr[i3] & 255) | i2;
    }

    /* renamed from: g */
    public final long mo31899g() {
        byte[] bArr = this.f28743a;
        int i = this.f28744b;
        this.f28744b = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        int i2 = this.f28744b;
        this.f28744b = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16);
        int i3 = this.f28744b;
        this.f28744b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        int i4 = this.f28744b;
        this.f28744b = i4 + 1;
        return j3 | (255 & ((long) bArr[i4]));
    }

    /* renamed from: c */
    public final int mo31895c() {
        byte[] bArr = this.f28743a;
        int i = this.f28744b;
        this.f28744b = i + 1;
        int i2 = (bArr[i] & 255) << 24;
        int i3 = this.f28744b;
        this.f28744b = i3 + 1;
        byte b = i2 | ((bArr[i3] & 255) << ExecutionDataWriter.BLOCK_SESSIONINFO);
        int i4 = this.f28744b;
        this.f28744b = i4 + 1;
        byte b2 = b | ((bArr[i4] & 255) << 8);
        int i5 = this.f28744b;
        this.f28744b = i5 + 1;
        return (bArr[i5] & 255) | b2;
    }

    /* renamed from: d */
    public final long mo31896d() {
        byte[] bArr = this.f28743a;
        int i = this.f28744b;
        this.f28744b = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        int i2 = this.f28744b;
        this.f28744b = i2 + 1;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48);
        int i3 = this.f28744b;
        this.f28744b = i3 + 1;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 40);
        int i4 = this.f28744b;
        this.f28744b = i4 + 1;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 32);
        int i5 = this.f28744b;
        this.f28744b = i5 + 1;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i6 = this.f28744b;
        this.f28744b = i6 + 1;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 16);
        int i7 = this.f28744b;
        this.f28744b = i7 + 1;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 8);
        int i8 = this.f28744b;
        this.f28744b = i8 + 1;
        return j7 | (255 & ((long) bArr[i8]));
    }

    /* renamed from: h */
    public final int mo31900h() {
        byte[] bArr = this.f28743a;
        int i = this.f28744b;
        this.f28744b = i + 1;
        int i2 = (bArr[i] & 255) << 8;
        int i3 = this.f28744b;
        this.f28744b = i3 + 1;
        byte b = (bArr[i3] & 255) | i2;
        this.f28744b += 2;
        return b;
    }

    /* renamed from: i */
    public final int mo31901i() {
        int c = mo31895c();
        if (c >= 0) {
            return c;
        }
        StringBuilder sb = new StringBuilder(29);
        sb.append("Top bit not zero: ");
        sb.append(c);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: j */
    public final long mo31902j() {
        long d = mo31896d();
        if (d >= 0) {
            return d;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(d);
        throw new IllegalStateException(sb.toString());
    }
}
