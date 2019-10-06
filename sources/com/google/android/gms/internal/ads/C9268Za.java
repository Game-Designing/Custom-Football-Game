package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.ads.Za */
final class C9268Za extends FilterInputStream {

    /* renamed from: a */
    private final long f22013a;

    /* renamed from: b */
    private long f22014b;

    C9268Za(InputStream inputStream, long j) {
        super(inputStream);
        this.f22013a = j;
    }

    public final int read() throws IOException {
        int read = super.read();
        if (read != -1) {
            this.f22014b++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f22014b += (long) read;
        }
        return read;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final long mo28807a() {
        return this.f22013a - this.f22014b;
    }
}
