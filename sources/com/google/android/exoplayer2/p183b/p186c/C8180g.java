package com.google.android.exoplayer2.p183b.p186c;

import com.google.android.exoplayer2.p183b.C8266m;
import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.p183b.C8271p;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.b.c.g */
/* compiled from: XingSeeker */
final class C8180g implements C8178a {

    /* renamed from: a */
    private final long f17030a;

    /* renamed from: b */
    private final int f17031b;

    /* renamed from: c */
    private final long f17032c;

    /* renamed from: d */
    private final long f17033d;

    /* renamed from: e */
    private final long f17034e;

    /* renamed from: f */
    private final long[] f17035f;

    /* renamed from: a */
    public static C8180g m18769a(long inputLength, long position, C8266m mpegAudioHeader, C8535t frame) {
        long j = inputLength;
        C8266m mVar = mpegAudioHeader;
        int samplesPerFrame = mVar.f17509n;
        int sampleRate = mVar.f17506k;
        int flags = frame.mo26119f();
        if ((flags & 1) == 1) {
            int u = frame.mo26135u();
            int frameCount = u;
            if (u != 0) {
                long durationUs = C8509F.m20471c((long) frameCount, ((long) samplesPerFrame) * 1000000, (long) sampleRate);
                if ((flags & 6) != 6) {
                    C8180g gVar = new C8180g(position, mVar.f17505j, durationUs);
                    return gVar;
                }
                long dataSize = (long) frame.mo26135u();
                long[] tableOfContents = new long[100];
                for (int i = 0; i < 100; i++) {
                    tableOfContents[i] = (long) frame.mo26131q();
                }
                if (!(j == -1 || j == position + dataSize)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("XING data size mismatch: ");
                    sb.append(j);
                    sb.append(", ");
                    sb.append(position + dataSize);
                    C8526n.m20534d("XingSeeker", sb.toString());
                }
                long j2 = dataSize;
                long[] jArr = tableOfContents;
                C8180g gVar2 = new C8180g(position, mVar.f17505j, durationUs, dataSize, tableOfContents);
                return gVar2;
            }
        }
        return null;
    }

    private C8180g(long dataStartPosition, int xingFrameSize, long durationUs) {
        this(dataStartPosition, xingFrameSize, durationUs, -1, null);
    }

    private C8180g(long dataStartPosition, int xingFrameSize, long durationUs, long dataSize, long[] tableOfContents) {
        this.f17030a = dataStartPosition;
        this.f17031b = xingFrameSize;
        this.f17032c = durationUs;
        this.f17035f = tableOfContents;
        this.f17033d = dataSize;
        long j = -1;
        if (dataSize != -1) {
            j = dataStartPosition + dataSize;
        }
        this.f17034e = j;
    }

    /* renamed from: d */
    public boolean mo25195d() {
        return this.f17035f != null;
    }

    /* renamed from: a */
    public C8269a mo25192a(long timeUs) {
        double scaledPosition;
        if (!mo25195d()) {
            return new C8269a(new C8271p(0, this.f17030a + ((long) this.f17031b)));
        }
        long timeUs2 = C8509F.m20467b(timeUs, 0, this.f17032c);
        double d = (double) timeUs2;
        Double.isNaN(d);
        double d2 = d * 100.0d;
        double d3 = (double) this.f17032c;
        Double.isNaN(d3);
        double percent = d2 / d3;
        if (percent <= 0.0d) {
            scaledPosition = 0.0d;
        } else if (percent >= 100.0d) {
            scaledPosition = 256.0d;
        } else {
            int prevTableIndex = (int) percent;
            long[] jArr = this.f17035f;
            C8514e.m20486a(jArr);
            long[] tableOfContents = jArr;
            double prevScaledPosition = (double) tableOfContents[prevTableIndex];
            double nextScaledPosition = prevTableIndex == 99 ? 256.0d : (double) tableOfContents[prevTableIndex + 1];
            double d4 = (double) prevTableIndex;
            Double.isNaN(d4);
            double interpolateFraction = percent - d4;
            Double.isNaN(prevScaledPosition);
            double d5 = (nextScaledPosition - prevScaledPosition) * interpolateFraction;
            Double.isNaN(prevScaledPosition);
            scaledPosition = prevScaledPosition + d5;
        }
        double prevScaledPosition2 = scaledPosition / 256.0d;
        double d6 = (double) this.f17033d;
        Double.isNaN(d6);
        return new C8269a(new C8271p(timeUs2, this.f17030a + C8509F.m20467b(Math.round(prevScaledPosition2 * d6), (long) this.f17031b, this.f17033d - 1)));
    }

    /* renamed from: b */
    public long mo25237b(long position) {
        double interpolateFraction;
        long positionOffset = position - this.f17030a;
        if (!mo25195d()) {
        } else if (positionOffset <= ((long) this.f17031b)) {
            long j = positionOffset;
        } else {
            long[] jArr = this.f17035f;
            C8514e.m20486a(jArr);
            long[] tableOfContents = jArr;
            double d = (double) positionOffset;
            Double.isNaN(d);
            double d2 = d * 256.0d;
            double d3 = (double) this.f17033d;
            Double.isNaN(d3);
            double scaledPosition = d2 / d3;
            int prevTableIndex = C8509F.m20465b(tableOfContents, (long) scaledPosition, true, true);
            long prevTimeUs = m18768a(prevTableIndex);
            long prevScaledPosition = tableOfContents[prevTableIndex];
            long nextTimeUs = m18768a(prevTableIndex + 1);
            long nextScaledPosition = prevTableIndex == 99 ? 256 : tableOfContents[prevTableIndex + 1];
            if (prevScaledPosition == nextScaledPosition) {
                long[] jArr2 = tableOfContents;
                interpolateFraction = 0.0d;
                long j2 = positionOffset;
            } else {
                long j3 = positionOffset;
                double d4 = (double) prevScaledPosition;
                Double.isNaN(d4);
                double d5 = scaledPosition - d4;
                long[] jArr3 = tableOfContents;
                double d6 = (double) (nextScaledPosition - prevScaledPosition);
                Double.isNaN(d6);
                interpolateFraction = d5 / d6;
            }
            double d7 = (double) (nextTimeUs - prevTimeUs);
            Double.isNaN(d7);
            return Math.round(d7 * interpolateFraction) + prevTimeUs;
        }
        return 0;
    }

    /* renamed from: b */
    public long mo25193b() {
        return this.f17032c;
    }

    /* renamed from: c */
    public long mo25238c() {
        return this.f17034e;
    }

    /* renamed from: a */
    private long m18768a(int tableIndex) {
        return (this.f17032c * ((long) tableIndex)) / 100;
    }
}
