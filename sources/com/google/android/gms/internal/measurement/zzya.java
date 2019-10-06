package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public final class zzya {

    /* renamed from: a */
    private final ByteBuffer f30411a;

    private zzya(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private zzya(ByteBuffer byteBuffer) {
        this.f30411a = byteBuffer;
        this.f30411a.order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: a */
    public static zzya m32599a(byte[] bArr) {
        return m32600a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public static zzya m32600a(byte[] bArr, int i, int i2) {
        return new zzya(bArr, 0, i2);
    }

    /* renamed from: a */
    public final void mo32949a(zzyi zzyi) throws IOException {
        mo32951c(zzyi.mo32966d());
        zzyi.mo32953a(this);
    }

    /* renamed from: a */
    public static int m32598a(int i, zzyi zzyi) {
        int a = m32597a(i);
        int b = zzyi.mo32965b();
        return a + m32601b(b) + b;
    }

    /* renamed from: d */
    private final void m32602d(int i) throws IOException {
        byte b = (byte) i;
        if (this.f30411a.hasRemaining()) {
            this.f30411a.put(b);
            return;
        }
        throw new zzyb(this.f30411a.position(), this.f30411a.limit());
    }

    /* renamed from: b */
    public final void mo32950b(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f30411a.remaining() >= length) {
            this.f30411a.put(bArr, 0, length);
            return;
        }
        throw new zzyb(this.f30411a.position(), this.f30411a.limit());
    }

    /* renamed from: a */
    public final void mo32948a(int i, int i2) throws IOException {
        mo32951c((i << 3) | i2);
    }

    /* renamed from: a */
    public static int m32597a(int i) {
        return m32601b(i << 3);
    }

    /* renamed from: c */
    public final void mo32951c(int i) throws IOException {
        while ((i & -128) != 0) {
            m32602d((i & Opcodes.LAND) | 128);
            i >>>= 7;
        }
        m32602d(i);
    }

    /* renamed from: b */
    public static int m32601b(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((i & -268435456) == 0) {
            return 4;
        }
        return 5;
    }
}
