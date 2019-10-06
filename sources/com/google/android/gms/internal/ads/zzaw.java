package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzaw extends ByteArrayOutputStream {

    /* renamed from: a */
    private final zzal f24872a;

    public zzaw(zzal zzal, int i) {
        this.f24872a = zzal;
        this.buf = this.f24872a.mo29800a(Math.max(i, Opcodes.ACC_NATIVE));
    }

    public final void close() throws IOException {
        this.f24872a.mo29799a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.f24872a.mo29799a(this.buf);
    }

    /* renamed from: a */
    private final void m25934a(int i) {
        int i2 = this.count;
        if (i2 + i > this.buf.length) {
            byte[] a = this.f24872a.mo29800a((i2 + i) << 1);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f24872a.mo29799a(this.buf);
            this.buf = a;
        }
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        m25934a(i2);
        super.write(bArr, i, i2);
    }

    public final synchronized void write(int i) {
        m25934a(1);
        super.write(i);
    }
}
