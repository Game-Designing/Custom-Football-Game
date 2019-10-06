package com.bumptech.glide.p098a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.bumptech.glide.a.d */
/* compiled from: StrictLineReader */
class C5917d implements Closeable {

    /* renamed from: a */
    private final InputStream f10374a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Charset f10375b;

    /* renamed from: c */
    private byte[] f10376c;

    /* renamed from: d */
    private int f10377d;

    /* renamed from: e */
    private int f10378e;

    public C5917d(InputStream in, Charset charset) {
        this(in, Opcodes.ACC_ANNOTATION, charset);
    }

    public C5917d(InputStream in, int capacity, Charset charset) {
        if (in == null || charset == null) {
            throw new NullPointerException();
        } else if (capacity < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C5918e.f10379a)) {
            this.f10374a = in;
            this.f10375b = charset;
            this.f10376c = new byte[capacity];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f10374a) {
            if (this.f10376c != null) {
                this.f10376c = null;
                this.f10374a.close();
            }
        }
    }

    /* renamed from: b */
    public String mo18548b() throws IOException {
        int i;
        synchronized (this.f10374a) {
            if (this.f10376c != null) {
                if (this.f10377d >= this.f10378e) {
                    m10859c();
                }
                int i2 = this.f10377d;
                while (i2 != this.f10378e) {
                    if (this.f10376c[i2] == 10) {
                        String res = new String(this.f10376c, this.f10377d, ((i2 == this.f10377d || this.f10376c[i2 + -1] != 13) ? i2 : i2 - 1) - this.f10377d, this.f10375b.name());
                        this.f10377d = i2 + 1;
                        return res;
                    }
                    i2++;
                }
                C5916c cVar = new C5916c(this, (this.f10378e - this.f10377d) + 80);
                loop1:
                while (true) {
                    cVar.write(this.f10376c, this.f10377d, this.f10378e - this.f10377d);
                    this.f10378e = -1;
                    m10859c();
                    i = this.f10377d;
                    while (i != this.f10378e) {
                        if (this.f10376c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f10377d) {
                    cVar.write(this.f10376c, this.f10377d, i - this.f10377d);
                }
                this.f10377d = i + 1;
                String cVar2 = cVar.toString();
                return cVar2;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: a */
    public boolean mo18547a() {
        return this.f10378e == -1;
    }

    /* renamed from: c */
    private void m10859c() throws IOException {
        InputStream inputStream = this.f10374a;
        byte[] bArr = this.f10376c;
        int result = inputStream.read(bArr, 0, bArr.length);
        if (result != -1) {
            this.f10377d = 0;
            this.f10378e = result;
            return;
        }
        throw new EOFException();
    }
}
