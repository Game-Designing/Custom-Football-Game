package com.google.android.exoplayer2.p183b.p186c;

import com.google.android.exoplayer2.p183b.C8266m;
import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.p183b.C8271p;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8526n;
import com.google.android.exoplayer2.util.C8535t;

/* renamed from: com.google.android.exoplayer2.b.c.f */
/* compiled from: VbriSeeker */
final class C8179f implements C8178a {

    /* renamed from: a */
    private final long[] f17026a;

    /* renamed from: b */
    private final long[] f17027b;

    /* renamed from: c */
    private final long f17028c;

    /* renamed from: d */
    private final long f17029d;

    /* renamed from: a */
    public static C8179f m18762a(long inputLength, long position, C8266m mpegAudioHeader, C8535t frame) {
        int segmentSize;
        long j = inputLength;
        C8266m mVar = mpegAudioHeader;
        C8535t tVar = frame;
        tVar.mo26120f(10);
        int numFrames = frame.mo26119f();
        if (numFrames <= 0) {
            return null;
        }
        int sampleRate = mVar.f17506k;
        long durationUs = C8509F.m20471c((long) numFrames, 1000000 * ((long) (sampleRate >= 32000 ? 1152 : 576)), (long) sampleRate);
        int entryCount = frame.mo26137w();
        int scale = frame.mo26137w();
        int entrySize = frame.mo26137w();
        tVar.mo26120f(2);
        int i = sampleRate;
        long minPosition = position + ((long) mVar.f17505j);
        long[] timesUs = new long[entryCount];
        long[] positions = new long[entryCount];
        int index = 0;
        long position2 = position;
        while (index < entryCount) {
            long durationUs2 = durationUs;
            timesUs[index] = (((long) index) * durationUs) / ((long) entryCount);
            positions[index] = Math.max(position2, minPosition);
            if (entrySize == 1) {
                segmentSize = frame.mo26131q();
            } else if (entrySize == 2) {
                segmentSize = frame.mo26137w();
            } else if (entrySize == 3) {
                segmentSize = frame.mo26134t();
            } else if (entrySize != 4) {
                return null;
            } else {
                segmentSize = frame.mo26135u();
            }
            position2 += (long) (segmentSize * scale);
            index++;
            C8266m mVar2 = mpegAudioHeader;
            C8535t tVar2 = frame;
            durationUs = durationUs2;
        }
        long durationUs3 = durationUs;
        if (!(j == -1 || j == position2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("VBRI data size mismatch: ");
            sb.append(j);
            sb.append(", ");
            sb.append(position2);
            C8526n.m20534d("VbriSeeker", sb.toString());
        }
        long position3 = position2;
        long[] jArr = timesUs;
        C8179f fVar = new C8179f(timesUs, positions, durationUs3, position3);
        return fVar;
    }

    private C8179f(long[] timesUs, long[] positions, long durationUs, long dataEndPosition) {
        this.f17026a = timesUs;
        this.f17027b = positions;
        this.f17028c = durationUs;
        this.f17029d = dataEndPosition;
    }

    /* renamed from: d */
    public boolean mo25195d() {
        return true;
    }

    /* renamed from: a */
    public C8269a mo25192a(long timeUs) {
        int tableIndex = C8509F.m20465b(this.f17026a, timeUs, true, true);
        C8271p seekPoint = new C8271p(this.f17026a[tableIndex], this.f17027b[tableIndex]);
        if (seekPoint.f17516b < timeUs) {
            long[] jArr = this.f17026a;
            if (tableIndex != jArr.length - 1) {
                return new C8269a(seekPoint, new C8271p(jArr[tableIndex + 1], this.f17027b[tableIndex + 1]));
            }
        }
        return new C8269a(seekPoint);
    }

    /* renamed from: b */
    public long mo25237b(long position) {
        return this.f17026a[C8509F.m20465b(this.f17027b, position, true, true)];
    }

    /* renamed from: b */
    public long mo25193b() {
        return this.f17028c;
    }

    /* renamed from: c */
    public long mo25238c() {
        return this.f17029d;
    }
}
