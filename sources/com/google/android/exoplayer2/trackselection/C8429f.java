package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;

/* renamed from: com.google.android.exoplayer2.trackselection.f */
/* compiled from: FixedTrackSelection */
public final class C8429f extends C8425c {

    /* renamed from: g */
    private final int f18463g;

    /* renamed from: h */
    private final Object f18464h;

    public C8429f(TrackGroup group, int track) {
        this(group, track, 0, null);
    }

    public C8429f(TrackGroup group, int track, int reason, Object data) {
        super(group, track);
        this.f18463g = reason;
        this.f18464h = data;
    }

    /* renamed from: a */
    public int mo25827a() {
        return 0;
    }
}
