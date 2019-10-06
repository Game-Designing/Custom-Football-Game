package com.bumptech.glide.p107h;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.h.c */
/* compiled from: ContentLengthInputStream */
public final class C6018c extends FilterInputStream {

    /* renamed from: a */
    private final long f10650a;

    /* renamed from: b */
    private int f10651b;

    /* renamed from: a */
    public static InputStream m11244a(InputStream other, long contentLength) {
        return new C6018c(other, contentLength);
    }

    private C6018c(InputStream in, long contentLength) {
        super(in);
        this.f10650a = contentLength;
    }

    public synchronized int available() throws IOException {
        return (int) Math.max(this.f10650a - ((long) this.f10651b), (long) this.in.available());
    }

    public synchronized int read() throws IOException {
        int value;
        value = super.read();
        m11243a(value >= 0 ? 1 : -1);
        return value;
    }

    public int read(byte[] buffer) throws IOException {
        return read(buffer, 0, buffer.length);
    }

    public synchronized int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int read;
        read = super.read(buffer, byteOffset, byteCount);
        m11243a(read);
        return read;
    }

    /* renamed from: a */
    private int m11243a(int read) throws IOException {
        if (read >= 0) {
            this.f10651b += read;
        } else if (this.f10650a - ((long) this.f10651b) > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to read all expected data, expected: ");
            sb.append(this.f10650a);
            sb.append(", but read: ");
            sb.append(this.f10651b);
            throw new IOException(sb.toString());
        }
        return read;
    }
}
