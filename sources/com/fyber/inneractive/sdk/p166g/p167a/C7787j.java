package com.fyber.inneractive.sdk.p166g.p167a;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.fyber.inneractive.sdk.g.a.j */
final class C7787j implements Closeable {

    /* renamed from: a */
    final Charset f15661a;

    /* renamed from: b */
    int f15662b;

    /* renamed from: c */
    private final InputStream f15663c;

    /* renamed from: d */
    private byte[] f15664d;

    /* renamed from: e */
    private int f15665e;

    public C7787j(InputStream inputStream, Charset charset) {
        this(inputStream, charset, 0);
    }

    private C7787j(InputStream inputStream, Charset charset, byte b) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (charset.equals(C7789k.f15667a)) {
            this.f15663c = inputStream;
            this.f15661a = charset;
            this.f15664d = new byte[Opcodes.ACC_ANNOTATION];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public final void close() throws IOException {
        synchronized (this.f15663c) {
            if (this.f15664d != null) {
                this.f15664d = null;
                this.f15663c.close();
            }
        }
    }

    /* renamed from: a */
    public final String mo24409a() throws IOException {
        int i;
        int i2;
        synchronized (this.f15663c) {
            if (this.f15664d != null) {
                if (this.f15665e >= this.f15662b) {
                    m17286b();
                }
                for (int i3 = this.f15665e; i3 != this.f15662b; i3++) {
                    if (this.f15664d[i3] == 10) {
                        if (i3 != this.f15665e) {
                            i2 = i3 - 1;
                            if (this.f15664d[i2] == 13) {
                                String str = new String(this.f15664d, this.f15665e, i2 - this.f15665e, this.f15661a.name());
                                this.f15665e = i3 + 1;
                                return str;
                            }
                        }
                        i2 = i3;
                        String str2 = new String(this.f15664d, this.f15665e, i2 - this.f15665e, this.f15661a.name());
                        this.f15665e = i3 + 1;
                        return str2;
                    }
                }
                C77881 r1 = new ByteArrayOutputStream((this.f15662b - this.f15665e) + 80) {
                    public final String toString() {
                        int i = this.count;
                        try {
                            return new String(this.buf, 0, (i <= 0 || this.buf[i + -1] != 13) ? this.count : i - 1, C7787j.this.f15661a.name());
                        } catch (UnsupportedEncodingException e) {
                            throw new AssertionError(e);
                        }
                    }
                };
                loop1:
                while (true) {
                    r1.write(this.f15664d, this.f15665e, this.f15662b - this.f15665e);
                    this.f15662b = -1;
                    m17286b();
                    i = this.f15665e;
                    while (true) {
                        if (i != this.f15662b) {
                            if (this.f15664d[i] == 10) {
                                break loop1;
                            }
                            i++;
                        }
                    }
                }
                if (i != this.f15665e) {
                    r1.write(this.f15664d, this.f15665e, i - this.f15665e);
                }
                this.f15665e = i + 1;
                String r12 = r1.toString();
                return r12;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    private void m17286b() throws IOException {
        InputStream inputStream = this.f15663c;
        byte[] bArr = this.f15664d;
        int read = inputStream.read(bArr, 0, bArr.length);
        if (read != -1) {
            this.f15665e = 0;
            this.f15662b = read;
            return;
        }
        throw new EOFException();
    }
}
