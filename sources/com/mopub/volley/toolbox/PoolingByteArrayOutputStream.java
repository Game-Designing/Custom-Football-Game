package com.mopub.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class PoolingByteArrayOutputStream extends ByteArrayOutputStream {

    /* renamed from: a */
    private final ByteArrayPool f36542a;

    public PoolingByteArrayOutputStream(ByteArrayPool pool) {
        this(pool, Opcodes.ACC_NATIVE);
    }

    public PoolingByteArrayOutputStream(ByteArrayPool pool, int size) {
        this.f36542a = pool;
        this.buf = this.f36542a.getBuf(Math.max(size, Opcodes.ACC_NATIVE));
    }

    public void close() throws IOException {
        this.f36542a.returnBuf(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f36542a.returnBuf(this.buf);
    }

    /* renamed from: a */
    private void m38674a(int i) {
        int i2 = this.count;
        if (i2 + i > this.buf.length) {
            byte[] newbuf = this.f36542a.getBuf((i2 + i) * 2);
            System.arraycopy(this.buf, 0, newbuf, 0, this.count);
            this.f36542a.returnBuf(this.buf);
            this.buf = newbuf;
        }
    }

    public synchronized void write(byte[] buffer, int offset, int len) {
        m38674a(len);
        super.write(buffer, offset, len);
    }

    public synchronized void write(int oneByte) {
        m38674a(1);
        super.write(oneByte);
    }
}
