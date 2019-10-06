package com.google.android.exoplayer2.p183b.p185b;

import com.google.android.exoplayer2.p183b.C8261h;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.b.i */
/* compiled from: VarintReader */
final class C8171i {

    /* renamed from: a */
    private static final long[] f16992a = {128, 64, 32, 16, 8, 4, 2, 1};

    /* renamed from: b */
    private final byte[] f16993b = new byte[8];

    /* renamed from: c */
    private int f16994c;

    /* renamed from: d */
    private int f16995d;

    /* renamed from: b */
    public void mo25234b() {
        this.f16994c = 0;
        this.f16995d = 0;
    }

    /* renamed from: a */
    public long mo25233a(C8261h input, boolean allowEndOfInput, boolean removeLengthMask, int maximumAllowedLength) throws IOException, InterruptedException {
        if (this.f16994c == 0) {
            if (!input.mo25247b(this.f16993b, 0, 1, allowEndOfInput)) {
                return -1;
            }
            this.f16995d = m18724a(this.f16993b[0] & 255);
            if (this.f16995d != -1) {
                this.f16994c = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int firstByte = this.f16995d;
        if (firstByte > maximumAllowedLength) {
            this.f16994c = 0;
            return -2;
        }
        if (firstByte != 1) {
            input.readFully(this.f16993b, 1, firstByte - 1);
        }
        this.f16994c = 0;
        return m18725a(this.f16993b, this.f16995d, removeLengthMask);
    }

    /* renamed from: a */
    public int mo25232a() {
        return this.f16995d;
    }

    /* renamed from: a */
    public static int m18724a(int firstByte) {
        int i = 0;
        while (true) {
            long[] jArr = f16992a;
            if (i >= jArr.length) {
                return -1;
            }
            if ((jArr[i] & ((long) firstByte)) != 0) {
                return i + 1;
            }
            i++;
        }
    }

    /* renamed from: a */
    public static long m18725a(byte[] varintBytes, int varintLength, boolean removeLengthMask) {
        long varint = ((long) varintBytes[0]) & 255;
        if (removeLengthMask) {
            varint &= f16992a[varintLength - 1] ^ -1;
        }
        for (int i = 1; i < varintLength; i++) {
            varint = (varint << 8) | (((long) varintBytes[i]) & 255);
        }
        return varint;
    }
}
