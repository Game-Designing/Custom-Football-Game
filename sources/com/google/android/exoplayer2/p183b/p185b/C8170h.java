package com.google.android.exoplayer2.p183b.p185b;

import com.google.android.exoplayer2.p183b.C8261h;
import com.google.android.exoplayer2.util.C8535t;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.b.h */
/* compiled from: Sniffer */
final class C8170h {

    /* renamed from: a */
    private final C8535t f16990a = new C8535t(8);

    /* renamed from: b */
    private int f16991b;

    /* renamed from: a */
    public boolean mo25231a(C8261h input) throws IOException, InterruptedException {
        C8261h hVar = input;
        long inputLength = input.getLength();
        long j = 1024;
        if (inputLength != -1 && inputLength <= 1024) {
            j = inputLength;
        }
        int bytesToSearch = (int) j;
        boolean z = false;
        hVar.mo25241a(this.f16990a.f18861a, 0, 4);
        this.f16991b = 4;
        for (long tag = this.f16990a.mo26133s(); tag != 440786851; tag = ((tag << 8) & -256) | ((long) (this.f16990a.f18861a[0] & 255))) {
            int i = this.f16991b + 1;
            this.f16991b = i;
            if (i == bytesToSearch) {
                return false;
            }
            hVar.mo25241a(this.f16990a.f18861a, 0, 1);
        }
        long headerSize = m18722b(input);
        long headerStart = (long) this.f16991b;
        if (headerSize == Long.MIN_VALUE) {
        } else if (inputLength == -1 || headerStart + headerSize < inputLength) {
            while (true) {
                int i2 = this.f16991b;
                if (((long) i2) >= headerStart + headerSize) {
                    return ((long) i2) == headerStart + headerSize;
                } else if (m18722b(input) == Long.MIN_VALUE) {
                    return z;
                } else {
                    int bytesToSearch2 = bytesToSearch;
                    long size = m18722b(input);
                    if (size >= 0 && size <= 2147483647L) {
                        if (size != 0) {
                            int sizeInt = (int) size;
                            hVar.mo25240a(sizeInt);
                            this.f16991b += sizeInt;
                        }
                        hVar = input;
                        bytesToSearch = bytesToSearch2;
                        z = false;
                    }
                }
            }
            return false;
        } else {
            int i3 = bytesToSearch;
        }
        return false;
    }

    /* renamed from: b */
    private long m18722b(C8261h input) throws IOException, InterruptedException {
        input.mo25241a(this.f16990a.f18861a, 0, 1);
        int value = this.f16990a.f18861a[0] & 255;
        if (value == 0) {
            return Long.MIN_VALUE;
        }
        int mask = 128;
        int length = 0;
        while ((value & mask) == 0) {
            mask >>= 1;
            length++;
        }
        int value2 = value & (mask ^ -1);
        input.mo25241a(this.f16990a.f18861a, 1, length);
        for (int i = 0; i < length; i++) {
            value2 = (value2 << 8) + (this.f16990a.f18861a[i + 1] & 255);
        }
        this.f16991b += length + 1;
        return (long) value2;
    }
}
