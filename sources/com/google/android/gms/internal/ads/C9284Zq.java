package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
/* renamed from: com.google.android.gms.internal.ads.Zq */
final class C9284Zq extends C9263Yq {

    /* renamed from: g */
    private final AudioTimestamp f22032g = new AudioTimestamp();

    /* renamed from: h */
    private long f22033h;

    /* renamed from: i */
    private long f22034i;

    /* renamed from: j */
    private long f22035j;

    public C9284Zq() {
        super(null);
    }

    /* renamed from: a */
    public final void mo28794a(AudioTrack audioTrack, boolean z) {
        super.mo28794a(audioTrack, z);
        this.f22033h = 0;
        this.f22034i = 0;
        this.f22035j = 0;
    }

    /* renamed from: d */
    public final boolean mo28798d() {
        boolean timestamp = this.f21999a.getTimestamp(this.f22032g);
        if (timestamp) {
            long j = this.f22032g.framePosition;
            if (this.f22034i > j) {
                this.f22033h++;
            }
            this.f22034i = j;
            this.f22035j = j + (this.f22033h << 32);
        }
        return timestamp;
    }

    /* renamed from: e */
    public final long mo28799e() {
        return this.f22032g.nanoTime;
    }

    /* renamed from: f */
    public final long mo28800f() {
        return this.f22035j;
    }
}
