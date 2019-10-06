package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.C8509F;
import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.extractor.mp4.q */
/* compiled from: TrackSampleTable */
final class C8317q {

    /* renamed from: a */
    public final C8314n f17897a;

    /* renamed from: b */
    public final int f17898b;

    /* renamed from: c */
    public final long[] f17899c;

    /* renamed from: d */
    public final int[] f17900d;

    /* renamed from: e */
    public final int f17901e;

    /* renamed from: f */
    public final long[] f17902f;

    /* renamed from: g */
    public final int[] f17903g;

    /* renamed from: h */
    public final long f17904h;

    public C8317q(C8314n track, long[] offsets, int[] sizes, int maximumSize, long[] timestampsUs, int[] flags, long durationUs) {
        boolean z = false;
        C8514e.m20488a(sizes.length == timestampsUs.length);
        C8514e.m20488a(offsets.length == timestampsUs.length);
        if (flags.length == timestampsUs.length) {
            z = true;
        }
        C8514e.m20488a(z);
        this.f17897a = track;
        this.f17899c = offsets;
        this.f17900d = sizes;
        this.f17901e = maximumSize;
        this.f17902f = timestampsUs;
        this.f17903g = flags;
        this.f17904h = durationUs;
        this.f17898b = offsets.length;
        if (flags.length > 0) {
            int length = flags.length - 1;
            flags[length] = flags[length] | 536870912;
        }
    }

    /* renamed from: a */
    public int mo25457a(long timeUs) {
        for (int i = C8509F.m20465b(this.f17902f, timeUs, true, false); i >= 0; i--) {
            if ((this.f17903g[i] & 1) != 0) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: b */
    public int mo25458b(long timeUs) {
        for (int i = C8509F.m20437a(this.f17902f, timeUs, true, false); i < this.f17902f.length; i++) {
            if ((this.f17903g[i] & 1) != 0) {
                return i;
            }
        }
        return -1;
    }
}
