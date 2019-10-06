package com.bumptech.glide.p107h;

import android.support.p001v7.widget.LinearLayoutManager;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.h.g */
/* compiled from: MarkEnforcingInputStream */
public class C6022g extends FilterInputStream {

    /* renamed from: a */
    private int f10660a = LinearLayoutManager.INVALID_OFFSET;

    public C6022g(InputStream in) {
        super(in);
    }

    public synchronized void mark(int readLimit) {
        super.mark(readLimit);
        this.f10660a = readLimit;
    }

    public int read() throws IOException {
        if (m11260h(1) == -1) {
            return -1;
        }
        int result = super.read();
        m11261i(1);
        return result;
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int toRead = (int) m11260h((long) byteCount);
        if (toRead == -1) {
            return -1;
        }
        int read = super.read(buffer, byteOffset, toRead);
        m11261i((long) read);
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        this.f10660a = LinearLayoutManager.INVALID_OFFSET;
    }

    public long skip(long byteCount) throws IOException {
        long toSkip = m11260h(byteCount);
        if (toSkip == -1) {
            return 0;
        }
        long read = super.skip(toSkip);
        m11261i(read);
        return read;
    }

    public int available() throws IOException {
        int i = this.f10660a;
        if (i == Integer.MIN_VALUE) {
            return super.available();
        }
        return Math.min(i, super.available());
    }

    /* renamed from: h */
    private long m11260h(long targetByteCount) {
        int i = this.f10660a;
        if (i == 0) {
            return -1;
        }
        if (i == Integer.MIN_VALUE || targetByteCount <= ((long) i)) {
            return targetByteCount;
        }
        return (long) i;
    }

    /* renamed from: i */
    private void m11261i(long bytesRead) {
        int i = this.f10660a;
        if (i != Integer.MIN_VALUE && bytesRead != -1) {
            this.f10660a = (int) (((long) i) - bytesRead);
        }
    }
}
