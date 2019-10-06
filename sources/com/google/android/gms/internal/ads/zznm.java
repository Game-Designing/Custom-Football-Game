package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zznm implements zzno {

    /* renamed from: a */
    private static final byte[] f28968a = new byte[Opcodes.ACC_SYNTHETIC];

    /* renamed from: b */
    private final zzrv f28969b;

    /* renamed from: c */
    private final long f28970c;

    /* renamed from: d */
    private long f28971d;

    /* renamed from: e */
    private byte[] f28972e = new byte[65536];

    /* renamed from: f */
    private int f28973f;

    /* renamed from: g */
    private int f28974g;

    public zznm(zzrv zzrv, long j, long j2) {
        this.f28969b = zzrv;
        this.f28971d = j;
        this.f28970c = j2;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        int b = m30800b(bArr, i, i2);
        if (b == 0) {
            b = m30798a(bArr, i, i2, 0, true);
        }
        m30803f(b);
        return b;
    }

    /* renamed from: a */
    public final boolean mo32047a(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int b = m30800b(bArr, i, i2);
        while (b < i2 && b != -1) {
            b = m30798a(bArr, i, i2, b, z);
        }
        m30803f(b);
        return b != -1;
    }

    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        mo32047a(bArr, i, i2, false);
    }

    /* renamed from: b */
    public final int mo32048b(int i) throws IOException, InterruptedException {
        int d = m30801d(i);
        if (d == 0) {
            byte[] bArr = f28968a;
            d = m30798a(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        m30803f(d);
        return d;
    }

    /* renamed from: a */
    public final void mo32045a(int i) throws IOException, InterruptedException {
        int d = m30801d(i);
        while (d < i && d != -1) {
            byte[] bArr = f28968a;
            d = m30798a(bArr, -d, Math.min(i, bArr.length + d), d, false);
        }
        m30803f(d);
    }

    /* renamed from: a */
    public final void mo32046a(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        if (m30799a(i2, false)) {
            System.arraycopy(this.f28972e, this.f28973f - i2, bArr, i, i2);
        }
    }

    /* renamed from: a */
    private final boolean m30799a(int i, boolean z) throws IOException, InterruptedException {
        int i2 = this.f28973f + i;
        byte[] bArr = this.f28972e;
        if (i2 > bArr.length) {
            this.f28972e = Arrays.copyOf(this.f28972e, zzsy.m31146a(bArr.length << 1, 65536 + i2, i2 + 524288));
        }
        int min = Math.min(this.f28974g - this.f28973f, i);
        while (min < i) {
            min = m30798a(this.f28972e, this.f28973f, i, min, false);
            if (min == -1) {
                return false;
            }
        }
        this.f28973f += i;
        this.f28974g = Math.max(this.f28974g, this.f28973f);
        return true;
    }

    /* renamed from: c */
    public final void mo32049c(int i) throws IOException, InterruptedException {
        m30799a(i, false);
    }

    /* renamed from: a */
    public final void mo32044a() {
        this.f28973f = 0;
    }

    public final long getPosition() {
        return this.f28971d;
    }

    public final long getLength() {
        return this.f28970c;
    }

    /* renamed from: d */
    private final int m30801d(int i) {
        int min = Math.min(this.f28974g, i);
        m30802e(min);
        return min;
    }

    /* renamed from: b */
    private final int m30800b(byte[] bArr, int i, int i2) {
        int i3 = this.f28974g;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.f28972e, 0, bArr, i, min);
        m30802e(min);
        return min;
    }

    /* renamed from: e */
    private final void m30802e(int i) {
        this.f28974g -= i;
        this.f28973f = 0;
        byte[] bArr = this.f28972e;
        int i2 = this.f28974g;
        if (i2 < bArr.length - 524288) {
            bArr = new byte[(i2 + 65536)];
        }
        System.arraycopy(this.f28972e, i, bArr, 0, this.f28974g);
        this.f28972e = bArr;
    }

    /* renamed from: a */
    private final int m30798a(byte[] bArr, int i, int i2, int i3, boolean z) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int read = this.f28969b.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    /* renamed from: f */
    private final void m30803f(int i) {
        if (i != -1) {
            this.f28971d += (long) i;
        }
    }
}
