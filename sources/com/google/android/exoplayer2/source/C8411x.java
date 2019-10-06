package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C8098D;
import com.google.android.exoplayer2.C8098D.C8099a;
import com.google.android.exoplayer2.C8098D.C8100b;
import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.source.x */
/* compiled from: SinglePeriodTimeline */
public final class C8411x extends C8098D {

    /* renamed from: b */
    private static final Object f18354b = new Object();

    /* renamed from: c */
    private final long f18355c;

    /* renamed from: d */
    private final long f18356d;

    /* renamed from: e */
    private final long f18357e;

    /* renamed from: f */
    private final long f18358f;

    /* renamed from: g */
    private final long f18359g;

    /* renamed from: h */
    private final long f18360h;

    /* renamed from: i */
    private final boolean f18361i;

    /* renamed from: j */
    private final boolean f18362j;

    /* renamed from: k */
    private final Object f18363k;

    public C8411x(long durationUs, boolean isSeekable, boolean isDynamic, Object tag) {
        this(durationUs, durationUs, 0, 0, isSeekable, isDynamic, tag);
    }

    public C8411x(long periodDurationUs, long windowDurationUs, long windowPositionInPeriodUs, long windowDefaultStartPositionUs, boolean isSeekable, boolean isDynamic, Object tag) {
        this(-9223372036854775807L, -9223372036854775807L, periodDurationUs, windowDurationUs, windowPositionInPeriodUs, windowDefaultStartPositionUs, isSeekable, isDynamic, tag);
    }

    public C8411x(long presentationStartTimeMs, long windowStartTimeMs, long periodDurationUs, long windowDurationUs, long windowPositionInPeriodUs, long windowDefaultStartPositionUs, boolean isSeekable, boolean isDynamic, Object tag) {
        this.f18355c = presentationStartTimeMs;
        this.f18356d = windowStartTimeMs;
        this.f18357e = periodDurationUs;
        this.f18358f = windowDurationUs;
        this.f18359g = windowPositionInPeriodUs;
        this.f18360h = windowDefaultStartPositionUs;
        this.f18361i = isSeekable;
        this.f18362j = isDynamic;
        this.f18363k = tag;
    }

    /* renamed from: b */
    public int mo24974b() {
        return 1;
    }

    /* renamed from: a */
    public C8100b mo24972a(int windowIndex, C8100b window, boolean setTag, long defaultPositionProjectionUs) {
        C8514e.m20485a(windowIndex, 0, 1);
        Object tag = setTag ? this.f18363k : null;
        long windowDefaultStartPositionUs = this.f18360h;
        if (this.f18362j && defaultPositionProjectionUs != 0) {
            long j = this.f18358f;
            if (j == -9223372036854775807L) {
                windowDefaultStartPositionUs = -9223372036854775807L;
            } else {
                windowDefaultStartPositionUs += defaultPositionProjectionUs;
                if (windowDefaultStartPositionUs > j) {
                    windowDefaultStartPositionUs = -9223372036854775807L;
                }
            }
        }
        window.mo25003a(tag, this.f18355c, this.f18356d, this.f18361i, this.f18362j, windowDefaultStartPositionUs, this.f18358f, 0, 0, this.f18359g);
        return window;
    }

    /* renamed from: a */
    public int mo24969a() {
        return 1;
    }

    /* renamed from: a */
    public C8099a mo24971a(int periodIndex, C8099a period, boolean setIds) {
        C8514e.m20485a(periodIndex, 0, 1);
        period.mo24991a(null, setIds ? f18354b : null, 0, this.f18357e, -this.f18359g);
        return period;
    }

    /* renamed from: a */
    public int mo24970a(Object uid) {
        return f18354b.equals(uid) ? 0 : -1;
    }

    /* renamed from: a */
    public Object mo24973a(int periodIndex) {
        C8514e.m20485a(periodIndex, 0, 1);
        return f18354b;
    }
}
