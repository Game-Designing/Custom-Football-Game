package com.smaato.soma.p261j.p262a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.smaato.soma.j.a.g */
/* compiled from: DiskLruCacheStrictLineReader */
class C12459g implements Closeable {

    /* renamed from: a */
    private final InputStream f38901a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Charset f38902b;

    /* renamed from: c */
    private byte[] f38903c;

    /* renamed from: d */
    private int f38904d;

    /* renamed from: e */
    private int f38905e;

    public C12459g(InputStream in, Charset charset) {
        this(in, Opcodes.ACC_ANNOTATION, charset);
    }

    public C12459g(InputStream in, int capacity, Charset charset) {
        if (in == null || charset == null) {
            throw new NullPointerException();
        } else if (capacity < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(C12460h.f38906a)) {
            this.f38901a = in;
            this.f38902b = charset;
            this.f38903c = new byte[capacity];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f38901a) {
            if (this.f38903c != null) {
                this.f38903c = null;
                this.f38901a.close();
            }
        }
    }

    /* renamed from: a */
    public String mo39996a() throws IOException {
        int i;
        synchronized (this.f38901a) {
            if (this.f38903c != null) {
                if (this.f38904d >= this.f38905e) {
                    m40983b();
                }
                int i2 = this.f38904d;
                while (i2 != this.f38905e) {
                    if (this.f38903c[i2] == 10) {
                        String res = new String(this.f38903c, this.f38904d, ((i2 == this.f38904d || this.f38903c[i2 + -1] != 13) ? i2 : i2 - 1) - this.f38904d, this.f38902b.name());
                        this.f38904d = i2 + 1;
                        return res;
                    }
                    i2++;
                }
                C12458f fVar = new C12458f(this, (this.f38905e - this.f38904d) + 80);
                loop1:
                while (true) {
                    fVar.write(this.f38903c, this.f38904d, this.f38905e - this.f38904d);
                    this.f38905e = -1;
                    m40983b();
                    i = this.f38904d;
                    while (i != this.f38905e) {
                        if (this.f38903c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f38904d) {
                    fVar.write(this.f38903c, this.f38904d, i - this.f38904d);
                }
                this.f38904d = i + 1;
                String fVar2 = fVar.toString();
                return fVar2;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: b */
    private void m40983b() throws IOException {
        InputStream inputStream = this.f38901a;
        byte[] bArr = this.f38903c;
        int result = inputStream.read(bArr, 0, bArr.length);
        if (result != -1) {
            this.f38904d = 0;
            this.f38905e = result;
            return;
        }
        throw new EOFException();
    }
}
