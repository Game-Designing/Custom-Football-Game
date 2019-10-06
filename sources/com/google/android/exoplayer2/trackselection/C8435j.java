package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.C8573z;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.upstream.C8482e;
import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.trackselection.j */
/* compiled from: TrackSelector */
public abstract class C8435j {

    /* renamed from: a */
    private C8436a f18476a;

    /* renamed from: b */
    private C8482e f18477b;

    /* renamed from: com.google.android.exoplayer2.trackselection.j$a */
    /* compiled from: TrackSelector */
    public interface C8436a {
    }

    /* renamed from: a */
    public abstract C8437k mo25846a(C8573z[] zVarArr, TrackGroupArray trackGroupArray) throws ExoPlaybackException;

    /* renamed from: a */
    public abstract void mo25847a(Object obj);

    /* renamed from: a */
    public final void mo25860a(C8436a listener, C8482e bandwidthMeter) {
        this.f18476a = listener;
        this.f18477b = bandwidthMeter;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C8482e mo25859a() {
        C8482e eVar = this.f18477b;
        C8514e.m20486a(eVar);
        return eVar;
    }
}
