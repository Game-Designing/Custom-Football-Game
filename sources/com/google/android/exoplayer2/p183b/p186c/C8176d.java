package com.google.android.exoplayer2.p183b.p186c;

import android.util.Pair;
import com.google.android.exoplayer2.C8275d;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.p183b.C8271p;
import com.google.android.exoplayer2.util.C8509F;

/* renamed from: com.google.android.exoplayer2.b.c.d */
/* compiled from: MlltSeeker */
final class C8176d implements C8178a {

    /* renamed from: a */
    private final long[] f17004a;

    /* renamed from: b */
    private final long[] f17005b;

    /* renamed from: c */
    private final long f17006c;

    /* renamed from: a */
    public static C8176d m18739a(long firstFramePosition, MlltFrame mlltFrame) {
        int referenceCount = mlltFrame.f18102e.length;
        long[] referencePositions = new long[(referenceCount + 1)];
        long[] referenceTimesMs = new long[(referenceCount + 1)];
        referencePositions[0] = firstFramePosition;
        referenceTimesMs[0] = 0;
        long position = firstFramePosition;
        long timeMs = 0;
        for (int i = 1; i <= referenceCount; i++) {
            position += (long) (mlltFrame.f18100c + mlltFrame.f18102e[i - 1]);
            timeMs += (long) (mlltFrame.f18101d + mlltFrame.f18103f[i - 1]);
            referencePositions[i] = position;
            referenceTimesMs[i] = timeMs;
        }
        return new C8176d(referencePositions, referenceTimesMs);
    }

    private C8176d(long[] referencePositions, long[] referenceTimesMs) {
        this.f17004a = referencePositions;
        this.f17005b = referenceTimesMs;
        this.f17006c = C8275d.m19230a(referenceTimesMs[referenceTimesMs.length - 1]);
    }

    /* renamed from: d */
    public boolean mo25195d() {
        return true;
    }

    /* renamed from: a */
    public C8269a mo25192a(long timeUs) {
        Pair<Long, Long> timeMsAndPosition = m18738a(C8275d.m19231b(C8509F.m20467b(timeUs, 0, this.f17006c)), this.f17005b, this.f17004a);
        return new C8269a(new C8271p(C8275d.m19230a(((Long) timeMsAndPosition.first).longValue()), ((Long) timeMsAndPosition.second).longValue()));
    }

    /* renamed from: b */
    public long mo25237b(long position) {
        return C8275d.m19230a(((Long) m18738a(position, this.f17004a, this.f17005b).second).longValue());
    }

    /* renamed from: b */
    public long mo25193b() {
        return this.f17006c;
    }

    /* renamed from: a */
    private static Pair<Long, Long> m18738a(long x, long[] xReferences, long[] yReferences) {
        double d;
        long j = x;
        long[] jArr = xReferences;
        int previousReferenceIndex = C8509F.m20465b(jArr, j, true, true);
        long xPreviousReference = jArr[previousReferenceIndex];
        long yPreviousReference = yReferences[previousReferenceIndex];
        int nextReferenceIndex = previousReferenceIndex + 1;
        if (nextReferenceIndex == jArr.length) {
            return Pair.create(Long.valueOf(xPreviousReference), Long.valueOf(yPreviousReference));
        }
        long xNextReference = jArr[nextReferenceIndex];
        long yNextReference = yReferences[nextReferenceIndex];
        if (xNextReference == xPreviousReference) {
            d = 0.0d;
        } else {
            double d2 = (double) j;
            double d3 = (double) xPreviousReference;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = d2 - d3;
            double d5 = (double) (xNextReference - xPreviousReference);
            Double.isNaN(d5);
            d = d4 / d5;
        }
        double proportion = d;
        double d6 = (double) (yNextReference - yPreviousReference);
        Double.isNaN(d6);
        double d7 = proportion;
        return Pair.create(Long.valueOf(x), Long.valueOf(((long) (d6 * proportion)) + yPreviousReference));
    }

    /* renamed from: c */
    public long mo25238c() {
        return -1;
    }
}
