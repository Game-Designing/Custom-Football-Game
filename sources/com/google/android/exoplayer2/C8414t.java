package com.google.android.exoplayer2;

import com.google.android.exoplayer2.C8098D.C8100b;
import com.google.android.exoplayer2.source.C8395r.C8396a;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.C8437k;

/* renamed from: com.google.android.exoplayer2.t */
/* compiled from: PlaybackInfo */
final class C8414t {

    /* renamed from: a */
    private static final C8396a f18364a = new C8396a(new Object());

    /* renamed from: b */
    public final C8098D f18365b;

    /* renamed from: c */
    public final Object f18366c;

    /* renamed from: d */
    public final C8396a f18367d;

    /* renamed from: e */
    public final long f18368e;

    /* renamed from: f */
    public final long f18369f;

    /* renamed from: g */
    public final int f18370g;

    /* renamed from: h */
    public final boolean f18371h;

    /* renamed from: i */
    public final TrackGroupArray f18372i;

    /* renamed from: j */
    public final C8437k f18373j;

    /* renamed from: k */
    public final C8396a f18374k;

    /* renamed from: l */
    public volatile long f18375l;

    /* renamed from: m */
    public volatile long f18376m;

    /* renamed from: n */
    public volatile long f18377n;

    /* renamed from: a */
    public static C8414t m19998a(long startPositionUs, C8437k emptyTrackSelectorResult) {
        C8437k kVar = emptyTrackSelectorResult;
        C8414t tVar = new C8414t(C8098D.f16479a, null, f18364a, startPositionUs, -9223372036854775807L, 1, false, TrackGroupArray.f18154a, kVar, f18364a, startPositionUs, 0, startPositionUs);
        return tVar;
    }

    public C8414t(C8098D timeline, Object manifest, C8396a periodId, long startPositionUs, long contentPositionUs, int playbackState, boolean isLoading, TrackGroupArray trackGroups, C8437k trackSelectorResult, C8396a loadingMediaPeriodId, long bufferedPositionUs, long totalBufferedDurationUs, long positionUs) {
        this.f18365b = timeline;
        this.f18366c = manifest;
        this.f18367d = periodId;
        this.f18368e = startPositionUs;
        this.f18369f = contentPositionUs;
        this.f18370g = playbackState;
        this.f18371h = isLoading;
        this.f18372i = trackGroups;
        this.f18373j = trackSelectorResult;
        this.f18374k = loadingMediaPeriodId;
        this.f18375l = bufferedPositionUs;
        this.f18376m = totalBufferedDurationUs;
        this.f18377n = positionUs;
    }

    /* renamed from: a */
    public C8396a mo25796a(boolean shuffleModeEnabled, C8100b window) {
        if (this.f18365b.mo24986c()) {
            return f18364a;
        }
        C8098D d = this.f18365b;
        return new C8396a(this.f18365b.mo24973a(d.mo24982a(d.mo24977a(shuffleModeEnabled), window).f16491f));
    }

    /* renamed from: a */
    public C8414t mo25801a(C8396a periodId, long startPositionUs, long contentPositionUs) {
        C8414t tVar = new C8414t(this.f18365b, this.f18366c, periodId, startPositionUs, periodId.mo25724a() ? contentPositionUs : -9223372036854775807L, this.f18370g, this.f18371h, this.f18372i, this.f18373j, periodId, startPositionUs, 0, startPositionUs);
        return tVar;
    }

    /* renamed from: a */
    public C8414t mo25802a(C8396a periodId, long positionUs, long contentPositionUs, long totalBufferedDurationUs) {
        C8414t tVar = new C8414t(this.f18365b, this.f18366c, periodId, positionUs, periodId.mo25724a() ? contentPositionUs : -9223372036854775807L, this.f18370g, this.f18371h, this.f18372i, this.f18373j, this.f18374k, this.f18375l, totalBufferedDurationUs, positionUs);
        return tVar;
    }

    /* renamed from: a */
    public C8414t mo25798a(C8098D timeline, Object manifest) {
        C8414t tVar = new C8414t(timeline, manifest, this.f18367d, this.f18368e, this.f18369f, this.f18370g, this.f18371h, this.f18372i, this.f18373j, this.f18374k, this.f18375l, this.f18376m, this.f18377n);
        return tVar;
    }

    /* renamed from: a */
    public C8414t mo25797a(int playbackState) {
        int i = playbackState;
        C8414t tVar = new C8414t(this.f18365b, this.f18366c, this.f18367d, this.f18368e, this.f18369f, i, this.f18371h, this.f18372i, this.f18373j, this.f18374k, this.f18375l, this.f18376m, this.f18377n);
        return tVar;
    }

    /* renamed from: a */
    public C8414t mo25803a(boolean isLoading) {
        boolean z = isLoading;
        C8414t tVar = new C8414t(this.f18365b, this.f18366c, this.f18367d, this.f18368e, this.f18369f, this.f18370g, z, this.f18372i, this.f18373j, this.f18374k, this.f18375l, this.f18376m, this.f18377n);
        return tVar;
    }

    /* renamed from: a */
    public C8414t mo25799a(TrackGroupArray trackGroups, C8437k trackSelectorResult) {
        TrackGroupArray trackGroupArray = trackGroups;
        C8437k kVar = trackSelectorResult;
        C8414t tVar = new C8414t(this.f18365b, this.f18366c, this.f18367d, this.f18368e, this.f18369f, this.f18370g, this.f18371h, trackGroupArray, kVar, this.f18374k, this.f18375l, this.f18376m, this.f18377n);
        return tVar;
    }

    /* renamed from: a */
    public C8414t mo25800a(C8396a loadingMediaPeriodId) {
        C8396a aVar = loadingMediaPeriodId;
        C8414t tVar = new C8414t(this.f18365b, this.f18366c, this.f18367d, this.f18368e, this.f18369f, this.f18370g, this.f18371h, this.f18372i, this.f18373j, aVar, this.f18375l, this.f18376m, this.f18377n);
        return tVar;
    }
}
