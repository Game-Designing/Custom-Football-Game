package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedInputStream extends InputStream {

    /* renamed from: _b */
    protected final ByteBuffer f12557_b;

    public ByteBufferBackedInputStream(ByteBuffer buf) {
        this.f12557_b = buf;
    }

    public int available() {
        return this.f12557_b.remaining();
    }

    public int read() throws IOException {
        if (this.f12557_b.hasRemaining()) {
            return this.f12557_b.get() & 255;
        }
        return -1;
    }

    public int read(byte[] bytes, int off, int len) throws IOException {
        if (!this.f12557_b.hasRemaining()) {
            return -1;
        }
        int len2 = Math.min(len, this.f12557_b.remaining());
        this.f12557_b.get(bytes, off, len2);
        return len2;
    }
}
