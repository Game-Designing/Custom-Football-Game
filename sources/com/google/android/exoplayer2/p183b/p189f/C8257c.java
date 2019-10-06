package com.google.android.exoplayer2.p183b.p189f;

import com.google.android.exoplayer2.p183b.C8268o;
import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.p183b.C8271p;
import com.google.android.exoplayer2.util.C8509F;

/* renamed from: com.google.android.exoplayer2.b.f.c */
/* compiled from: WavHeader */
final class C8257c implements C8268o {

    /* renamed from: a */
    private final int f17482a;

    /* renamed from: b */
    private final int f17483b;

    /* renamed from: c */
    private final int f17484c;

    /* renamed from: d */
    private final int f17485d;

    /* renamed from: e */
    private final int f17486e;

    /* renamed from: f */
    private final int f17487f;

    /* renamed from: g */
    private long f17488g;

    /* renamed from: h */
    private long f17489h;

    public C8257c(int numChannels, int sampleRateHz, int averageBytesPerSecond, int blockAlignment, int bitsPerSample, int encoding) {
        this.f17482a = numChannels;
        this.f17483b = sampleRateHz;
        this.f17484c = averageBytesPerSecond;
        this.f17485d = blockAlignment;
        this.f17486e = bitsPerSample;
        this.f17487f = encoding;
    }

    /* renamed from: a */
    public void mo25343a(long dataStartPosition, long dataSize) {
        this.f17488g = dataStartPosition;
        this.f17489h = dataSize;
    }

    /* renamed from: f */
    public long mo25346f() {
        if (mo25350j()) {
            return this.f17488g + this.f17489h;
        }
        return -1;
    }

    /* renamed from: j */
    public boolean mo25350j() {
        return (this.f17488g == 0 || this.f17489h == 0) ? false : true;
    }

    /* renamed from: d */
    public boolean mo25195d() {
        return true;
    }

    /* renamed from: b */
    public long mo25193b() {
        return (1000000 * (this.f17489h / ((long) this.f17485d))) / ((long) this.f17483b);
    }

    /* renamed from: a */
    public C8269a mo25192a(long timeUs) {
        long positionOffset = (((long) this.f17484c) * timeUs) / 1000000;
        int i = this.f17485d;
        long positionOffset2 = C8509F.m20467b((positionOffset / ((long) i)) * ((long) i), 0, this.f17489h - ((long) i));
        long seekPosition = this.f17488g + positionOffset2;
        long seekTimeUs = mo25344b(seekPosition);
        C8271p seekPoint = new C8271p(seekTimeUs, seekPosition);
        if (seekTimeUs < timeUs) {
            long j = this.f17489h;
            int i2 = this.f17485d;
            if (positionOffset2 != j - ((long) i2)) {
                long secondSeekPosition = ((long) i2) + seekPosition;
                return new C8269a(seekPoint, new C8271p(mo25344b(secondSeekPosition), secondSeekPosition));
            }
        }
        return new C8269a(seekPoint);
    }

    /* renamed from: b */
    public long mo25344b(long position) {
        return (1000000 * Math.max(0, position - this.f17488g)) / ((long) this.f17484c);
    }

    /* renamed from: e */
    public int mo25345e() {
        return this.f17485d;
    }

    /* renamed from: a */
    public int mo25342a() {
        return this.f17483b * this.f17486e * this.f17482a;
    }

    /* renamed from: i */
    public int mo25349i() {
        return this.f17483b;
    }

    /* renamed from: h */
    public int mo25348h() {
        return this.f17482a;
    }

    /* renamed from: g */
    public int mo25347g() {
        return this.f17487f;
    }
}
