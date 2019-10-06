package com.google.android.exoplayer2;

public final class IllegalSeekPositionException extends IllegalStateException {

    /* renamed from: a */
    public final C8098D f16527a;

    /* renamed from: b */
    public final int f16528b;

    /* renamed from: c */
    public final long f16529c;

    public IllegalSeekPositionException(C8098D timeline, int windowIndex, long positionMs) {
        this.f16527a = timeline;
        this.f16528b = windowIndex;
        this.f16529c = positionMs;
    }
}
