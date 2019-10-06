package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C8098D;
import com.google.android.exoplayer2.C8320g;
import com.google.android.exoplayer2.upstream.C8481d;
import com.google.android.exoplayer2.upstream.C8502v;
import java.io.IOException;

/* renamed from: com.google.android.exoplayer2.source.r */
/* compiled from: MediaSource */
public interface C8395r {

    /* renamed from: com.google.android.exoplayer2.source.r$a */
    /* compiled from: MediaSource */
    public static final class C8396a {

        /* renamed from: a */
        public final Object f18288a;

        /* renamed from: b */
        public final int f18289b;

        /* renamed from: c */
        public final int f18290c;

        /* renamed from: d */
        public final long f18291d;

        /* renamed from: e */
        public final long f18292e;

        public C8396a(Object periodUid) {
            this(periodUid, -1);
        }

        public C8396a(Object periodUid, long windowSequenceNumber) {
            this(periodUid, -1, -1, windowSequenceNumber, Long.MIN_VALUE);
        }

        public C8396a(Object periodUid, long windowSequenceNumber, long endPositionUs) {
            this(periodUid, -1, -1, windowSequenceNumber, endPositionUs);
        }

        public C8396a(Object periodUid, int adGroupIndex, int adIndexInAdGroup, long windowSequenceNumber) {
            this(periodUid, adGroupIndex, adIndexInAdGroup, windowSequenceNumber, Long.MIN_VALUE);
        }

        private C8396a(Object periodUid, int adGroupIndex, int adIndexInAdGroup, long windowSequenceNumber, long endPositionUs) {
            this.f18288a = periodUid;
            this.f18289b = adGroupIndex;
            this.f18290c = adIndexInAdGroup;
            this.f18291d = windowSequenceNumber;
            this.f18292e = endPositionUs;
        }

        /* renamed from: a */
        public boolean mo25724a() {
            return this.f18289b != -1;
        }

        public boolean equals(Object obj) {
            boolean z = true;
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C8396a periodId = (C8396a) obj;
            if (!(this.f18288a.equals(periodId.f18288a) && this.f18289b == periodId.f18289b && this.f18290c == periodId.f18290c && this.f18291d == periodId.f18291d && this.f18292e == periodId.f18292e)) {
                z = false;
            }
            return z;
        }

        public int hashCode() {
            return (((((((((17 * 31) + this.f18288a.hashCode()) * 31) + this.f18289b) * 31) + this.f18290c) * 31) + ((int) this.f18291d)) * 31) + ((int) this.f18292e);
        }
    }

    /* renamed from: com.google.android.exoplayer2.source.r$b */
    /* compiled from: MediaSource */
    public interface C8397b {
        /* renamed from: a */
        void mo25489a(C8395r rVar, C8098D d, Object obj);
    }

    /* renamed from: a */
    C8393q mo25719a(C8396a aVar, C8481d dVar, long j);

    /* renamed from: a */
    void mo25720a() throws IOException;

    /* renamed from: a */
    void mo25677a(C8320g gVar, boolean z, C8397b bVar, C8502v vVar);

    /* renamed from: a */
    void mo25721a(C8393q qVar);

    /* renamed from: a */
    void mo25679a(C8397b bVar);
}
