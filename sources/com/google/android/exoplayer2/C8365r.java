package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.C8395r.C8396a;

/* renamed from: com.google.android.exoplayer2.r */
/* compiled from: MediaPeriodInfo */
final class C8365r {

    /* renamed from: a */
    public final C8396a f18133a;

    /* renamed from: b */
    public final long f18134b;

    /* renamed from: c */
    public final long f18135c;

    /* renamed from: d */
    public final long f18136d;

    /* renamed from: e */
    public final boolean f18137e;

    /* renamed from: f */
    public final boolean f18138f;

    C8365r(C8396a id, long startPositionUs, long contentPositionUs, long durationUs, boolean isLastInTimelinePeriod, boolean isFinal) {
        this.f18133a = id;
        this.f18134b = startPositionUs;
        this.f18135c = contentPositionUs;
        this.f18136d = durationUs;
        this.f18137e = isLastInTimelinePeriod;
        this.f18138f = isFinal;
    }

    /* renamed from: a */
    public C8365r mo25623a(long startPositionUs) {
        C8365r rVar = new C8365r(this.f18133a, startPositionUs, this.f18135c, this.f18136d, this.f18137e, this.f18138f);
        return rVar;
    }
}
