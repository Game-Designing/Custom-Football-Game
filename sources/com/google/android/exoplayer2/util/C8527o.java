package com.google.android.exoplayer2.util;

import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.util.o */
/* compiled from: LongArray */
public final class C8527o {

    /* renamed from: a */
    private int f18831a;

    /* renamed from: b */
    private long[] f18832b;

    public C8527o() {
        this(32);
    }

    public C8527o(int initialCapacity) {
        this.f18832b = new long[initialCapacity];
    }

    /* renamed from: a */
    public void mo26090a(long value) {
        int i = this.f18831a;
        long[] jArr = this.f18832b;
        if (i == jArr.length) {
            this.f18832b = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f18832b;
        int i2 = this.f18831a;
        this.f18831a = i2 + 1;
        jArr2[i2] = value;
    }

    /* renamed from: a */
    public long mo26089a(int index) {
        if (index >= 0 && index < this.f18831a) {
            return this.f18832b[index];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid index ");
        sb.append(index);
        sb.append(", size is ");
        sb.append(this.f18831a);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    /* renamed from: a */
    public int mo26088a() {
        return this.f18831a;
    }
}
