package com.bumptech.glide.load.p109a;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.load.a.h */
/* compiled from: ExifOrientationStream */
public final class C6049h extends FilterInputStream {

    /* renamed from: a */
    private static final byte[] f10719a = {-1, -31, 0, 28, 69, 120, 105, 102, 0, 0, 77, 77, 0, 0, 0, 0, 0, 8, 0, 1, 1, 18, 0, 2, 0, 0, 0, 1, 0};

    /* renamed from: b */
    private static final int f10720b = f10719a.length;

    /* renamed from: c */
    private static final int f10721c = (f10720b + 2);

    /* renamed from: d */
    private final byte f10722d;

    /* renamed from: e */
    private int f10723e;

    public C6049h(InputStream in, int orientation) {
        super(in);
        if (orientation < -1 || orientation > 8) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot add invalid orientation: ");
            sb.append(orientation);
            throw new IllegalArgumentException(sb.toString());
        }
        this.f10722d = (byte) orientation;
    }

    public boolean markSupported() {
        return false;
    }

    public void mark(int readLimit) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int read() throws java.io.IOException {
        /*
            r3 = this;
            int r0 = r3.f10723e
            r1 = 2
            if (r0 < r1) goto L_0x0017
            int r2 = f10721c
            if (r0 <= r2) goto L_0x000a
            goto L_0x0017
        L_0x000a:
            if (r0 != r2) goto L_0x000f
            byte r0 = r3.f10722d
            goto L_0x001b
        L_0x000f:
            byte[] r2 = f10719a
            int r0 = r0 - r1
            byte r0 = r2[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            goto L_0x001b
        L_0x0017:
            int r0 = super.read()
        L_0x001b:
            r1 = -1
            if (r0 == r1) goto L_0x0024
            int r1 = r3.f10723e
            int r1 = r1 + 1
            r3.f10723e = r1
        L_0x0024:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.p109a.C6049h.read():int");
    }

    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException {
        int read;
        int read2 = this.f10723e;
        int i = f10721c;
        if (read2 > i) {
            read = super.read(buffer, byteOffset, byteCount);
        } else if (read2 == i) {
            buffer[byteOffset] = this.f10722d;
            read = 1;
        } else if (read2 < 2) {
            read = super.read(buffer, byteOffset, 2 - read2);
        } else {
            read = Math.min(i - read2, byteCount);
            System.arraycopy(f10719a, this.f10723e - 2, buffer, byteOffset, read);
        }
        if (read > 0) {
            this.f10723e += read;
        }
        return read;
    }

    public long skip(long byteCount) throws IOException {
        long skipped = super.skip(byteCount);
        if (skipped > 0) {
            this.f10723e = (int) (((long) this.f10723e) + skipped);
        }
        return skipped;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
