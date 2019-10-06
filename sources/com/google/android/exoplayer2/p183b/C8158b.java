package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.util.C8509F;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.b.b */
/* compiled from: ChunkIndex */
public final class C8158b implements C8268o {

    /* renamed from: a */
    public final int f16861a;

    /* renamed from: b */
    public final int[] f16862b;

    /* renamed from: c */
    public final long[] f16863c;

    /* renamed from: d */
    public final long[] f16864d;

    /* renamed from: e */
    public final long[] f16865e;

    /* renamed from: f */
    private final long f16866f;

    public C8158b(int[] sizes, long[] offsets, long[] durationsUs, long[] timesUs) {
        this.f16862b = sizes;
        this.f16863c = offsets;
        this.f16864d = durationsUs;
        this.f16865e = timesUs;
        this.f16861a = sizes.length;
        int i = this.f16861a;
        if (i > 0) {
            this.f16866f = durationsUs[i - 1] + timesUs[i - 1];
        } else {
            this.f16866f = 0;
        }
    }

    /* renamed from: c */
    public int mo25205c(long timeUs) {
        return C8509F.m20465b(this.f16865e, timeUs, true, true);
    }

    /* renamed from: d */
    public boolean mo25195d() {
        return true;
    }

    /* renamed from: b */
    public long mo25193b() {
        return this.f16866f;
    }

    /* renamed from: a */
    public C8269a mo25192a(long timeUs) {
        int chunkIndex = mo25205c(timeUs);
        C8271p seekPoint = new C8271p(this.f16865e[chunkIndex], this.f16863c[chunkIndex]);
        if (seekPoint.f17516b >= timeUs || chunkIndex == this.f16861a - 1) {
            return new C8269a(seekPoint);
        }
        return new C8269a(seekPoint, new C8271p(this.f16865e[chunkIndex + 1], this.f16863c[chunkIndex + 1]));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChunkIndex(length=");
        sb.append(this.f16861a);
        sb.append(", sizes=");
        sb.append(Arrays.toString(this.f16862b));
        sb.append(", offsets=");
        sb.append(Arrays.toString(this.f16863c));
        sb.append(", timeUs=");
        sb.append(Arrays.toString(this.f16865e));
        sb.append(", durationsUs=");
        sb.append(Arrays.toString(this.f16864d));
        sb.append(")");
        return sb.toString();
    }
}
