package com.fasterxml.jackson.core.p134io;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.fasterxml.jackson.core.io.MergedStream */
public final class MergedStream extends InputStream {

    /* renamed from: _b */
    private byte[] f12552_b;
    private final IOContext _ctxt;
    private final int _end;
    private final InputStream _in;
    private int _ptr;

    public MergedStream(IOContext ctxt, InputStream in, byte[] buf, int start, int end) {
        this._ctxt = ctxt;
        this._in = in;
        this.f12552_b = buf;
        this._ptr = start;
        this._end = end;
    }

    public int available() throws IOException {
        if (this.f12552_b != null) {
            return this._end - this._ptr;
        }
        return this._in.available();
    }

    public void close() throws IOException {
        _free();
        this._in.close();
    }

    public void mark(int readlimit) {
        if (this.f12552_b == null) {
            this._in.mark(readlimit);
        }
    }

    public boolean markSupported() {
        return this.f12552_b == null && this._in.markSupported();
    }

    public int read() throws IOException {
        byte[] bArr = this.f12552_b;
        if (bArr == null) {
            return this._in.read();
        }
        int i = this._ptr;
        this._ptr = i + 1;
        int c = bArr[i] & 255;
        if (this._ptr >= this._end) {
            _free();
        }
        return c;
    }

    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    public int read(byte[] b, int off, int len) throws IOException {
        if (this.f12552_b == null) {
            return this._in.read(b, off, len);
        }
        int avail = this._end - this._ptr;
        if (len > avail) {
            len = avail;
        }
        System.arraycopy(this.f12552_b, this._ptr, b, off, len);
        this._ptr += len;
        if (this._ptr >= this._end) {
            _free();
        }
        return len;
    }

    public void reset() throws IOException {
        if (this.f12552_b == null) {
            this._in.reset();
        }
    }

    public long skip(long n) throws IOException {
        long count = 0;
        if (this.f12552_b != null) {
            int i = this._end;
            int i2 = this._ptr;
            int amount = i - i2;
            if (((long) amount) > n) {
                this._ptr = i2 + ((int) n);
                return n;
            }
            _free();
            count = 0 + ((long) amount);
            n -= (long) amount;
        }
        if (n > 0) {
            count += this._in.skip(n);
        }
        return count;
    }

    private void _free() {
        byte[] buf = this.f12552_b;
        if (buf != null) {
            this.f12552_b = null;
            IOContext iOContext = this._ctxt;
            if (iOContext != null) {
                iOContext.releaseReadIOBuffer(buf);
            }
        }
    }
}
