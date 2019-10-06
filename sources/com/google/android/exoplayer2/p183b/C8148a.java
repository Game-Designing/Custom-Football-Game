package com.google.android.exoplayer2.p183b;

import com.google.android.exoplayer2.p183b.C8268o.C8269a;
import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.b.a */
/* compiled from: BinarySearchSeeker */
public abstract class C8148a {

    /* renamed from: a */
    protected final C8149a f16816a;

    /* renamed from: b */
    protected final C8155g f16817b;

    /* renamed from: c */
    protected C8152d f16818c;

    /* renamed from: d */
    private final int f16819d;

    /* renamed from: com.google.android.exoplayer2.b.a$a */
    /* compiled from: BinarySearchSeeker */
    public static class C8149a implements C8268o {

        /* renamed from: a */
        private final C8153e f16820a;

        /* renamed from: b */
        private final long f16821b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final long f16822c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final long f16823d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public final long f16824e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public final long f16825f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public final long f16826g;

        public C8149a(C8153e seekTimestampConverter, long durationUs, long floorTimePosition, long ceilingTimePosition, long floorBytePosition, long ceilingBytePosition, long approxBytesPerFrame) {
            this.f16820a = seekTimestampConverter;
            this.f16821b = durationUs;
            this.f16822c = floorTimePosition;
            this.f16823d = ceilingTimePosition;
            this.f16824e = floorBytePosition;
            this.f16825f = ceilingBytePosition;
            this.f16826g = approxBytesPerFrame;
        }

        /* renamed from: d */
        public boolean mo25195d() {
            return true;
        }

        /* renamed from: a */
        public C8269a mo25192a(long timeUs) {
            this.f16820a.mo25196a(timeUs);
            return new C8269a(new C8271p(timeUs, C8152d.m18610a(timeUs, this.f16822c, this.f16823d, this.f16824e, this.f16825f, this.f16826g)));
        }

        /* renamed from: b */
        public long mo25193b() {
            return this.f16821b;
        }

        /* renamed from: c */
        public long mo25194c(long timeUs) {
            this.f16820a.mo25196a(timeUs);
            return timeUs;
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.a$b */
    /* compiled from: BinarySearchSeeker */
    public static final class C8150b implements C8153e {
        /* renamed from: a */
        public long mo25196a(long timeUs) {
            return timeUs;
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.a$c */
    /* compiled from: BinarySearchSeeker */
    public static final class C8151c {
    }

    /* renamed from: com.google.android.exoplayer2.b.a$d */
    /* compiled from: BinarySearchSeeker */
    protected static class C8152d {

        /* renamed from: a */
        private final long f16827a;

        /* renamed from: b */
        private final long f16828b;

        /* renamed from: c */
        private final long f16829c;

        /* renamed from: d */
        private long f16830d;

        /* renamed from: e */
        private long f16831e;

        /* renamed from: f */
        private long f16832f;

        /* renamed from: g */
        private long f16833g;

        /* renamed from: h */
        private long f16834h;

        /* renamed from: a */
        protected static long m18610a(long targetTimePosition, long floorTimePosition, long ceilingTimePosition, long floorBytePosition, long ceilingBytePosition, long approxBytesPerFrame) {
            if (floorBytePosition + 1 >= ceilingBytePosition || floorTimePosition + 1 >= ceilingTimePosition) {
                return floorBytePosition;
            }
            long bytesToSkip = (long) (((float) (targetTimePosition - floorTimePosition)) * (((float) (ceilingBytePosition - floorBytePosition)) / ((float) (ceilingTimePosition - floorTimePosition))));
            return C8509F.m20467b(((floorBytePosition + bytesToSkip) - approxBytesPerFrame) - (bytesToSkip / 20), floorBytePosition, ceilingBytePosition - 1);
        }

        protected C8152d(long seekTimeUs, long targetTimePosition, long floorTimePosition, long ceilingTimePosition, long floorBytePosition, long ceilingBytePosition, long approxBytesPerFrame) {
            this.f16827a = seekTimeUs;
            this.f16828b = targetTimePosition;
            this.f16830d = floorTimePosition;
            this.f16831e = ceilingTimePosition;
            this.f16832f = floorBytePosition;
            this.f16833g = ceilingBytePosition;
            this.f16829c = approxBytesPerFrame;
            this.f16834h = m18610a(targetTimePosition, floorTimePosition, ceilingTimePosition, floorBytePosition, ceilingBytePosition, approxBytesPerFrame);
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public long m18614b() {
            return this.f16832f;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public long m18609a() {
            return this.f16833g;
        }

        /* access modifiers changed from: private */
        /* renamed from: e */
        public long m18622e() {
            return this.f16828b;
        }

        /* access modifiers changed from: private */
        /* renamed from: d */
        public long m18620d() {
            return this.f16827a;
        }

        /* access modifiers changed from: private */
        /* renamed from: b */
        public void m18616b(long floorTimePosition, long floorBytePosition) {
            this.f16830d = floorTimePosition;
            this.f16832f = floorBytePosition;
            m18624f();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m18612a(long ceilingTimePosition, long ceilingBytePosition) {
            this.f16831e = ceilingTimePosition;
            this.f16833g = ceilingBytePosition;
            m18624f();
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public long m18618c() {
            return this.f16834h;
        }

        /* renamed from: f */
        private void m18624f() {
            this.f16834h = m18610a(this.f16828b, this.f16830d, this.f16831e, this.f16832f, this.f16833g, this.f16829c);
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.a$e */
    /* compiled from: BinarySearchSeeker */
    protected interface C8153e {
        /* renamed from: a */
        long mo25196a(long j);
    }

    /* renamed from: com.google.android.exoplayer2.b.a$f */
    /* compiled from: BinarySearchSeeker */
    public static final class C8154f {

        /* renamed from: a */
        public static final C8154f f16835a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public final int f16836b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public final long f16837c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final long f16838d;

        static {
            C8154f fVar = new C8154f(-3, -9223372036854775807L, -1);
            f16835a = fVar;
        }

        private C8154f(int type, long timestampToUpdate, long bytePositionToUpdate) {
            this.f16836b = type;
            this.f16837c = timestampToUpdate;
            this.f16838d = bytePositionToUpdate;
        }

        /* renamed from: a */
        public static C8154f m18628a(long newCeilingTimestamp, long newCeilingBytePosition) {
            C8154f fVar = new C8154f(-1, newCeilingTimestamp, newCeilingBytePosition);
            return fVar;
        }

        /* renamed from: b */
        public static C8154f m18630b(long newFloorTimestamp, long newCeilingBytePosition) {
            C8154f fVar = new C8154f(-2, newFloorTimestamp, newCeilingBytePosition);
            return fVar;
        }

        /* renamed from: a */
        public static C8154f m18627a(long resultBytePosition) {
            C8154f fVar = new C8154f(0, -9223372036854775807L, resultBytePosition);
            return fVar;
        }
    }

    /* renamed from: com.google.android.exoplayer2.b.a$g */
    /* compiled from: BinarySearchSeeker */
    protected interface C8155g {
        /* renamed from: a */
        C8154f mo25197a(C8261h hVar, long j, C8151c cVar) throws IOException, InterruptedException;

        /* renamed from: a */
        void mo25198a();
    }

    protected C8148a(C8153e seekTimestampConverter, C8155g timestampSeeker, long durationUs, long floorTimePosition, long ceilingTimePosition, long floorBytePosition, long ceilingBytePosition, long approxBytesPerFrame, int minimumSearchRange) {
        this.f16817b = timestampSeeker;
        this.f16819d = minimumSearchRange;
        C8149a aVar = r3;
        C8149a aVar2 = new C8149a(seekTimestampConverter, durationUs, floorTimePosition, ceilingTimePosition, floorBytePosition, ceilingBytePosition, approxBytesPerFrame);
        this.f16816a = aVar;
    }

    /* renamed from: a */
    public final C8268o mo25186a() {
        return this.f16816a;
    }

    /* renamed from: b */
    public final void mo25189b(long timeUs) {
        C8152d dVar = this.f16818c;
        if (dVar == null || dVar.m18620d() != timeUs) {
            this.f16818c = mo25185a(timeUs);
        }
    }

    /* renamed from: b */
    public final boolean mo25191b() {
        return this.f16818c != null;
    }

    /* renamed from: a */
    public int mo25184a(C8261h input, C8267n seekPositionHolder, C8151c outputFrameHolder) throws InterruptedException, IOException {
        C8261h hVar = input;
        C8267n nVar = seekPositionHolder;
        C8155g gVar = this.f16817b;
        C8514e.m20486a(gVar);
        C8155g timestampSeeker = gVar;
        while (true) {
            C8152d dVar = this.f16818c;
            C8514e.m20486a(dVar);
            C8152d seekOperationParams = dVar;
            long floorPosition = seekOperationParams.m18614b();
            long ceilingPosition = seekOperationParams.m18609a();
            long searchPosition = seekOperationParams.m18618c();
            if (ceilingPosition - floorPosition <= ((long) this.f16819d)) {
                mo25187a(false, floorPosition);
                return mo25183a(hVar, floorPosition, nVar);
            } else if (!mo25188a(hVar, searchPosition)) {
                return mo25183a(hVar, searchPosition, nVar);
            } else {
                input.mo25239a();
                C8154f timestampSearchResult = timestampSeeker.mo25197a(hVar, seekOperationParams.m18622e(), outputFrameHolder);
                int a = timestampSearchResult.f16836b;
                if (a == -3) {
                    long j = floorPosition;
                    mo25187a(false, searchPosition);
                    return mo25183a(hVar, searchPosition, nVar);
                } else if (a == -2) {
                    seekOperationParams.m18616b(timestampSearchResult.f16837c, timestampSearchResult.f16838d);
                } else if (a == -1) {
                    long j2 = floorPosition;
                    seekOperationParams.m18612a(timestampSearchResult.f16837c, timestampSearchResult.f16838d);
                } else if (a == 0) {
                    mo25187a(true, timestampSearchResult.f16838d);
                    mo25188a(hVar, timestampSearchResult.f16838d);
                    return mo25183a(hVar, timestampSearchResult.f16838d, nVar);
                } else {
                    throw new IllegalStateException("Invalid case");
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C8152d mo25185a(long timeUs) {
        this.f16816a.mo25194c(timeUs);
        C8152d dVar = new C8152d(timeUs, timeUs, this.f16816a.f16822c, this.f16816a.f16823d, this.f16816a.f16824e, this.f16816a.f16825f, this.f16816a.f16826g);
        return dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo25187a(boolean foundTargetFrame, long resultPosition) {
        this.f16818c = null;
        this.f16817b.mo25198a();
        mo25190b(foundTargetFrame, resultPosition);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo25190b(boolean foundTargetFrame, long resultPosition) {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo25188a(C8261h input, long position) throws IOException, InterruptedException {
        long bytesToSkip = position - input.getPosition();
        if (bytesToSkip < 0 || bytesToSkip > 262144) {
            return false;
        }
        input.mo25248c((int) bytesToSkip);
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final int mo25183a(C8261h input, long position, C8267n seekPositionHolder) {
        if (position == input.getPosition()) {
            return 0;
        }
        seekPositionHolder.f17510a = position;
        return 1;
    }
}
