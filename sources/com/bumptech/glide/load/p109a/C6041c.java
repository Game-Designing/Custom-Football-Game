package com.bumptech.glide.load.p109a;

import com.bumptech.glide.load.engine.p120a.C6245b;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.bumptech.glide.load.a.c */
/* compiled from: BufferedOutputStream */
public final class C6041c extends OutputStream {

    /* renamed from: a */
    private final OutputStream f10712a;

    /* renamed from: b */
    private byte[] f10713b;

    /* renamed from: c */
    private C6245b f10714c;

    /* renamed from: d */
    private int f10715d;

    public C6041c(OutputStream out, C6245b arrayPool) {
        this(out, arrayPool, 65536);
    }

    C6041c(OutputStream out, C6245b arrayPool, int bufferSize) {
        this.f10712a = out;
        this.f10714c = arrayPool;
        this.f10713b = (byte[]) arrayPool.mo19127a(bufferSize, byte[].class);
    }

    public void write(int b) throws IOException {
        byte[] bArr = this.f10713b;
        int i = this.f10715d;
        this.f10715d = i + 1;
        bArr[i] = (byte) b;
        m11343b();
    }

    public void write(byte[] b) throws IOException {
        write(b, 0, b.length);
    }

    public void write(byte[] b, int initialOffset, int length) throws IOException {
        int writtenSoFar = 0;
        do {
            int remainingToWrite = length - writtenSoFar;
            int currentOffset = initialOffset + writtenSoFar;
            if (this.f10715d != 0 || remainingToWrite < this.f10713b.length) {
                int totalBytesToWriteToBuffer = Math.min(remainingToWrite, this.f10713b.length - this.f10715d);
                System.arraycopy(b, currentOffset, this.f10713b, this.f10715d, totalBytesToWriteToBuffer);
                this.f10715d += totalBytesToWriteToBuffer;
                writtenSoFar += totalBytesToWriteToBuffer;
                m11343b();
            } else {
                this.f10712a.write(b, currentOffset, remainingToWrite);
                return;
            }
        } while (writtenSoFar < length);
    }

    public void flush() throws IOException {
        m11342a();
        this.f10712a.flush();
    }

    /* renamed from: a */
    private void m11342a() throws IOException {
        int i = this.f10715d;
        if (i > 0) {
            this.f10712a.write(this.f10713b, 0, i);
            this.f10715d = 0;
        }
    }

    /* renamed from: b */
    private void m11343b() throws IOException {
        if (this.f10715d == this.f10713b.length) {
            m11342a();
        }
    }

    /* JADX INFO: finally extract failed */
    public void close() throws IOException {
        try {
            flush();
            this.f10712a.close();
            m11344c();
        } catch (Throwable th) {
            this.f10712a.close();
            throw th;
        }
    }

    /* renamed from: c */
    private void m11344c() {
        byte[] bArr = this.f10713b;
        if (bArr != null) {
            this.f10714c.put(bArr);
            this.f10713b = null;
        }
    }
}
