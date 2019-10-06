package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzib implements zzie {

    /* renamed from: a */
    private static final byte[] f28573a = new byte[Opcodes.ACC_SYNTHETIC];

    /* renamed from: b */
    private final zzjp f28574b;

    /* renamed from: c */
    private long f28575c;

    /* renamed from: d */
    private long f28576d;

    public zzib(zzjp zzjp, long j, long j2) {
        this.f28574b = zzjp;
        this.f28575c = j;
        this.f28576d = j2;
    }

    /* renamed from: a */
    public final boolean mo31841a(byte[] bArr, int i, int i2, boolean z) throws IOException, InterruptedException {
        int i3 = i;
        int i4 = i2;
        while (i4 > 0) {
            if (!Thread.interrupted()) {
                int read = this.f28574b.read(bArr, i3, i4);
                if (read != -1) {
                    i3 += read;
                    i4 -= read;
                } else if (z && i4 == i2) {
                    return false;
                } else {
                    throw new EOFException();
                }
            } else {
                throw new InterruptedException();
            }
        }
        this.f28575c += (long) i2;
        return true;
    }

    public final void readFully(byte[] bArr, int i, int i2) throws IOException, InterruptedException {
        mo31841a(bArr, i, i2, false);
    }

    /* renamed from: a */
    public final void mo31840a(int i) throws IOException, InterruptedException {
        int i2 = i;
        while (i2 > 0) {
            if (!Thread.interrupted()) {
                zzjp zzjp = this.f28574b;
                byte[] bArr = f28573a;
                int read = zzjp.read(bArr, 0, Math.min(bArr.length, i2));
                if (read != -1) {
                    i2 -= read;
                } else {
                    throw new EOFException();
                }
            } else {
                throw new InterruptedException();
            }
        }
        this.f28575c += (long) i;
    }

    public final long getPosition() {
        return this.f28575c;
    }
}
