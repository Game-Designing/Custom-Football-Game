package com.google.android.exoplayer2.util;

/* renamed from: com.google.android.exoplayer2.util.D */
/* compiled from: TimestampAdjuster */
public final class C8506D {

    /* renamed from: a */
    private long f18782a;

    /* renamed from: b */
    private long f18783b;

    /* renamed from: c */
    private volatile long f18784c = -9223372036854775807L;

    public C8506D(long firstSampleTimestampUs) {
        mo26055d(firstSampleTimestampUs);
    }

    /* renamed from: d */
    public synchronized void mo26055d(long firstSampleTimestampUs) {
        C8514e.m20490b(this.f18784c == -9223372036854775807L);
        this.f18782a = firstSampleTimestampUs;
    }

    /* renamed from: a */
    public long mo26049a() {
        return this.f18782a;
    }

    /* renamed from: b */
    public long mo26051b() {
        if (this.f18784c != -9223372036854775807L) {
            return this.f18783b + this.f18784c;
        }
        long j = this.f18782a;
        if (j != Long.MAX_VALUE) {
            return j;
        }
        return -9223372036854775807L;
    }

    /* renamed from: c */
    public long mo26053c() {
        if (this.f18782a == Long.MAX_VALUE) {
            return 0;
        }
        if (this.f18784c == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.f18783b;
    }

    /* renamed from: d */
    public void mo26054d() {
        this.f18784c = -9223372036854775807L;
    }

    /* renamed from: b */
    public long mo26052b(long pts90Khz) {
        if (pts90Khz == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f18784c != -9223372036854775807L) {
            long lastPts = m20408e(this.f18784c);
            long closestWrapCount = (4294967296L + lastPts) / 8589934592L;
            long ptsWrapBelow = ((closestWrapCount - 1) * 8589934592L) + pts90Khz;
            long ptsWrapAbove = (8589934592L * closestWrapCount) + pts90Khz;
            pts90Khz = Math.abs(ptsWrapBelow - lastPts) < Math.abs(ptsWrapAbove - lastPts) ? ptsWrapBelow : ptsWrapAbove;
        }
        return mo26050a(m20407c(pts90Khz));
    }

    /* renamed from: a */
    public long mo26050a(long timeUs) {
        if (timeUs == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f18784c != -9223372036854775807L) {
            this.f18784c = timeUs;
        } else {
            long j = this.f18782a;
            if (j != Long.MAX_VALUE) {
                this.f18783b = j - timeUs;
            }
            synchronized (this) {
                this.f18784c = timeUs;
                notifyAll();
            }
        }
        return this.f18783b + timeUs;
    }

    /* renamed from: c */
    public static long m20407c(long pts) {
        return (1000000 * pts) / 90000;
    }

    /* renamed from: e */
    public static long m20408e(long us) {
        return (90000 * us) / 1000000;
    }
}
