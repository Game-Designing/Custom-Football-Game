package com.google.android.exoplayer2.p183b.p188e;

import com.google.android.exoplayer2.util.C8514e;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.b.e.t */
/* compiled from: NalUnitTargetBuffer */
final class C8245t {

    /* renamed from: a */
    private final int f17428a;

    /* renamed from: b */
    private boolean f17429b;

    /* renamed from: c */
    private boolean f17430c;

    /* renamed from: d */
    public byte[] f17431d;

    /* renamed from: e */
    public int f17432e;

    public C8245t(int targetType, int initialCapacity) {
        this.f17428a = targetType;
        this.f17431d = new byte[(initialCapacity + 3)];
        this.f17431d[2] = 1;
    }

    /* renamed from: b */
    public void mo25330b() {
        this.f17429b = false;
        this.f17430c = false;
    }

    /* renamed from: a */
    public boolean mo25328a() {
        return this.f17430c;
    }

    /* renamed from: b */
    public void mo25331b(int type) {
        boolean z = true;
        C8514e.m20490b(!this.f17429b);
        if (type != this.f17428a) {
            z = false;
        }
        this.f17429b = z;
        if (this.f17429b) {
            this.f17432e = 3;
            this.f17430c = false;
        }
    }

    /* renamed from: a */
    public void mo25327a(byte[] data, int offset, int limit) {
        if (this.f17429b) {
            int readLength = limit - offset;
            byte[] bArr = this.f17431d;
            int length = bArr.length;
            int i = this.f17432e;
            if (length < i + readLength) {
                this.f17431d = Arrays.copyOf(bArr, (i + readLength) * 2);
            }
            System.arraycopy(data, offset, this.f17431d, this.f17432e, readLength);
            this.f17432e += readLength;
        }
    }

    /* renamed from: a */
    public boolean mo25329a(int discardPadding) {
        if (!this.f17429b) {
            return false;
        }
        this.f17432e -= discardPadding;
        this.f17429b = false;
        this.f17430c = true;
        return true;
    }
}
