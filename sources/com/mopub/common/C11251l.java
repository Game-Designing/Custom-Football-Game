package com.mopub.common;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.mopub.common.l */
/* compiled from: DiskLruCacheStrictLineReader */
class C11251l implements Closeable {

    /* renamed from: a */
    private final InputStream f34406a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Charset f34407b;

    /* renamed from: c */
    private byte[] f34408c;

    /* renamed from: d */
    private int f34409d;

    /* renamed from: e */
    private int f34410e;

    public C11251l(InputStream in, Charset charset) {
        this(in, Opcodes.ACC_ANNOTATION, charset);
    }

    public C11251l(InputStream in, int capacity, Charset charset) {
        if (in == null || charset == null) {
            throw new NullPointerException();
        } else if (capacity < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(DiskLruCacheUtil.f34312a)) {
            this.f34406a = in;
            this.f34407b = charset;
            this.f34408c = new byte[capacity];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f34406a) {
            if (this.f34408c != null) {
                this.f34408c = null;
                this.f34406a.close();
            }
        }
    }

    public String readLine() throws IOException {
        int i;
        synchronized (this.f34406a) {
            if (this.f34408c != null) {
                if (this.f34409d >= this.f34410e) {
                    m37073a();
                }
                int i2 = this.f34409d;
                while (i2 != this.f34410e) {
                    if (this.f34408c[i2] == 10) {
                        String res = new String(this.f34408c, this.f34409d, ((i2 == this.f34409d || this.f34408c[i2 + -1] != 13) ? i2 : i2 - 1) - this.f34409d, this.f34407b.name());
                        this.f34409d = i2 + 1;
                        return res;
                    }
                    i2++;
                }
                C11250k kVar = new C11250k(this, (this.f34410e - this.f34409d) + 80);
                loop1:
                while (true) {
                    kVar.write(this.f34408c, this.f34409d, this.f34410e - this.f34409d);
                    this.f34410e = -1;
                    m37073a();
                    i = this.f34409d;
                    while (i != this.f34410e) {
                        if (this.f34408c[i] == 10) {
                            break loop1;
                        }
                        i++;
                    }
                }
                if (i != this.f34409d) {
                    kVar.write(this.f34408c, this.f34409d, i - this.f34409d);
                }
                this.f34409d = i + 1;
                String kVar2 = kVar.toString();
                return kVar2;
            }
            throw new IOException("LineReader is closed");
        }
    }

    /* renamed from: a */
    private void m37073a() throws IOException {
        InputStream inputStream = this.f34406a;
        byte[] bArr = this.f34408c;
        int result = inputStream.read(bArr, 0, bArr.length);
        if (result != -1) {
            this.f34409d = 0;
            this.f34410e = result;
            return;
        }
        throw new EOFException();
    }
}
