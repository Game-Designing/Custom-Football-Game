package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.util.C8509F;

/* renamed from: com.google.android.exoplayer2.b.c */
/* compiled from: ConstantBitrateSeekMap */
public class C8172c implements C8268o {

    /* renamed from: a */
    private final long f16996a;

    /* renamed from: b */
    private final long f16997b;

    /* renamed from: c */
    private final int f16998c;

    /* renamed from: d */
    private final long f16999d;

    /* renamed from: e */
    private final int f17000e;

    /* renamed from: f */
    private final long f17001f;

    public C8172c(long inputLength, long firstFrameBytePosition, int bitrate, int frameSize) {
        this.f16996a = inputLength;
        this.f16997b = firstFrameBytePosition;
        this.f16998c = frameSize == -1 ? 1 : frameSize;
        this.f17000e = bitrate;
        if (inputLength == -1) {
            this.f16999d = -1;
            this.f17001f = -9223372036854775807L;
            return;
        }
        this.f16999d = inputLength - firstFrameBytePosition;
        this.f17001f = m18729a(inputLength, firstFrameBytePosition, bitrate);
    }

    /* renamed from: d */
    public boolean mo25195d() {
        return this.f16999d != -1;
    }

    /* renamed from: a */
    public C8269a mo25192a(long timeUs) {
        if (this.f16999d == -1) {
            return new C8269a(new C8271p(0, this.f16997b));
        }
        long seekFramePosition = m18730d(timeUs);
        long seekTimeUs = mo25235c(seekFramePosition);
        C8271p seekPoint = new C8271p(seekTimeUs, seekFramePosition);
        if (seekTimeUs < timeUs) {
            int i = this.f16998c;
            if (((long) i) + seekFramePosition < this.f16996a) {
                long secondSeekPosition = ((long) i) + seekFramePosition;
                return new C8269a(seekPoint, new C8271p(mo25235c(secondSeekPosition), secondSeekPosition));
            }
        }
        return new C8269a(seekPoint);
    }

    /* renamed from: b */
    public long mo25193b() {
        return this.f17001f;
    }

    /* renamed from: c */
    public long mo25235c(long position) {
        return m18729a(position, this.f16997b, this.f17000e);
    }

    /* renamed from: a */
    private static long m18729a(long position, long firstFrameBytePosition, int bitrate) {
        return ((Math.max(0, position - firstFrameBytePosition) * 8) * 1000000) / ((long) bitrate);
    }

    /* renamed from: d */
    private long m18730d(long timeUs) {
        long positionOffset = (((long) this.f17000e) * timeUs) / 8000000;
        int i = this.f16998c;
        return this.f16997b + C8509F.m20467b((positionOffset / ((long) i)) * ((long) i), 0, this.f16999d - ((long) i));
    }
}
