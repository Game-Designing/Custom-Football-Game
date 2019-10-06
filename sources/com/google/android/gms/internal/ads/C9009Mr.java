package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
/* renamed from: com.google.android.gms.internal.ads.Mr */
final class C9009Mr extends C8988Lr {

    /* renamed from: j */
    private final AudioTimestamp f21490j = new AudioTimestamp();

    /* renamed from: k */
    private long f21491k;

    /* renamed from: l */
    private long f21492l;

    /* renamed from: m */
    private long f21493m;

    public C9009Mr() {
        super(null);
    }

    /* renamed from: a */
    public final void mo28439a(AudioTrack audioTrack, boolean z) {
        super.mo28439a(audioTrack, z);
        this.f21491k = 0;
        this.f21492l = 0;
        this.f21493m = 0;
    }

    /* renamed from: d */
    public final boolean mo28442d() {
        boolean timestamp = this.f21445a.getTimestamp(this.f21490j);
        if (timestamp) {
            long j = this.f21490j.framePosition;
            if (this.f21492l > j) {
                this.f21491k++;
            }
            this.f21492l = j;
            this.f21493m = j + (this.f21491k << 32);
        }
        return timestamp;
    }

    /* renamed from: e */
    public final long mo28443e() {
        return this.f21490j.nanoTime;
    }

    /* renamed from: f */
    public final long mo28444f() {
        return this.f21493m;
    }
}
