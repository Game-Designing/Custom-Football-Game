package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.trackselection.C8432h.C8433a;
import com.google.android.exoplayer2.upstream.C8482e;
import com.google.android.exoplayer2.util.C8517g;

/* renamed from: com.google.android.exoplayer2.trackselection.a */
/* compiled from: AdaptiveTrackSelection */
public class C8422a extends C8425c {

    /* renamed from: g */
    private final C8482e f18437g;

    /* renamed from: h */
    private final long f18438h;

    /* renamed from: i */
    private final long f18439i;

    /* renamed from: j */
    private final long f18440j;

    /* renamed from: k */
    private final float f18441k;

    /* renamed from: l */
    private final float f18442l;

    /* renamed from: m */
    private final long f18443m;

    /* renamed from: n */
    private final C8517g f18444n;

    /* renamed from: o */
    private float f18445o = 1.0f;

    /* renamed from: p */
    private int f18446p = m20050a(Long.MIN_VALUE);

    /* renamed from: q */
    private int f18447q = 1;

    /* renamed from: r */
    private long f18448r = -9223372036854775807L;

    /* renamed from: com.google.android.exoplayer2.trackselection.a$a */
    /* compiled from: AdaptiveTrackSelection */
    public static final class C8423a implements C8433a {

        /* renamed from: a */
        private final C8482e f18449a;

        /* renamed from: b */
        private final int f18450b;

        /* renamed from: c */
        private final int f18451c;

        /* renamed from: d */
        private final int f18452d;

        /* renamed from: e */
        private final float f18453e;

        /* renamed from: f */
        private final float f18454f;

        /* renamed from: g */
        private final long f18455g;

        /* renamed from: h */
        private final C8517g f18456h;

        public C8423a() {
            this(10000, 25000, 25000, 0.75f, 0.75f, 2000, C8517g.f18812a);
        }

        public C8423a(int minDurationForQualityIncreaseMs, int maxDurationForQualityDecreaseMs, int minDurationToRetainAfterDiscardMs, float bandwidthFraction, float bufferedFractionToLiveEdgeForQualityIncrease, long minTimeBetweenBufferReevaluationMs, C8517g clock) {
            this(null, minDurationForQualityIncreaseMs, maxDurationForQualityDecreaseMs, minDurationToRetainAfterDiscardMs, bandwidthFraction, bufferedFractionToLiveEdgeForQualityIncrease, minTimeBetweenBufferReevaluationMs, clock);
        }

        @Deprecated
        public C8423a(C8482e bandwidthMeter, int minDurationForQualityIncreaseMs, int maxDurationForQualityDecreaseMs, int minDurationToRetainAfterDiscardMs, float bandwidthFraction, float bufferedFractionToLiveEdgeForQualityIncrease, long minTimeBetweenBufferReevaluationMs, C8517g clock) {
            this.f18449a = bandwidthMeter;
            this.f18450b = minDurationForQualityIncreaseMs;
            this.f18451c = maxDurationForQualityDecreaseMs;
            this.f18452d = minDurationToRetainAfterDiscardMs;
            this.f18453e = bandwidthFraction;
            this.f18454f = bufferedFractionToLiveEdgeForQualityIncrease;
            this.f18455g = minTimeBetweenBufferReevaluationMs;
            this.f18456h = clock;
        }

        /* renamed from: a */
        public C8422a m20055a(TrackGroup group, C8482e bandwidthMeter, int... tracks) {
            C8482e bandwidthMeter2;
            if (this.f18449a != null) {
                bandwidthMeter2 = this.f18449a;
            } else {
                bandwidthMeter2 = bandwidthMeter;
            }
            C8422a aVar = new C8422a(group, tracks, bandwidthMeter2, (long) this.f18450b, (long) this.f18451c, (long) this.f18452d, this.f18453e, this.f18454f, this.f18455g, this.f18456h);
            return aVar;
        }
    }

    public C8422a(TrackGroup group, int[] tracks, C8482e bandwidthMeter, long minDurationForQualityIncreaseMs, long maxDurationForQualityDecreaseMs, long minDurationToRetainAfterDiscardMs, float bandwidthFraction, float bufferedFractionToLiveEdgeForQualityIncrease, long minTimeBetweenBufferReevaluationMs, C8517g clock) {
        super(group, tracks);
        this.f18437g = bandwidthMeter;
        this.f18438h = minDurationForQualityIncreaseMs * 1000;
        this.f18439i = maxDurationForQualityDecreaseMs * 1000;
        this.f18440j = 1000 * minDurationToRetainAfterDiscardMs;
        this.f18441k = bandwidthFraction;
        this.f18442l = bufferedFractionToLiveEdgeForQualityIncrease;
        this.f18443m = minTimeBetweenBufferReevaluationMs;
        this.f18444n = clock;
    }

    /* renamed from: d */
    public void mo25829d() {
        this.f18448r = -9223372036854775807L;
    }

    /* renamed from: a */
    public void mo25828a(float playbackSpeed) {
        this.f18445o = playbackSpeed;
    }

    /* renamed from: a */
    public int mo25827a() {
        return this.f18446p;
    }

    /* renamed from: a */
    private int m20050a(long nowMs) {
        long effectiveBitrate = (long) (((float) this.f18437g.mo26010b()) * this.f18441k);
        int lowestBitrateNonBlacklistedIndex = 0;
        for (int i = 0; i < this.f18458b; i++) {
            if (nowMs == Long.MIN_VALUE || !mo25832a(i, nowMs)) {
                if (((long) Math.round(((float) mo25831a(i).f16503c) * this.f18445o)) <= effectiveBitrate) {
                    return i;
                }
                lowestBitrateNonBlacklistedIndex = i;
            }
        }
        return lowestBitrateNonBlacklistedIndex;
    }
}
