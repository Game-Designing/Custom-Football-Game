package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* renamed from: com.google.android.gms.internal.ads.Yq */
class C9263Yq {

    /* renamed from: a */
    protected AudioTrack f21999a;

    /* renamed from: b */
    private boolean f22000b;

    /* renamed from: c */
    private int f22001c;

    /* renamed from: d */
    private long f22002d;

    /* renamed from: e */
    private long f22003e;

    /* renamed from: f */
    private long f22004f;

    private C9263Yq() {
    }

    /* renamed from: a */
    public void mo28794a(AudioTrack audioTrack, boolean z) {
        this.f21999a = audioTrack;
        this.f22000b = z;
        this.f22002d = 0;
        this.f22003e = 0;
        this.f22004f = 0;
        if (audioTrack != null) {
            this.f22001c = audioTrack.getSampleRate();
        }
    }

    /* renamed from: a */
    public final boolean mo28795a() {
        return zzkq.f28747a <= 22 && this.f22000b && this.f21999a.getPlayState() == 2 && this.f21999a.getPlaybackHeadPosition() == 0;
    }

    /* renamed from: b */
    public final long mo28796b() {
        long playbackHeadPosition = ((long) this.f21999a.getPlaybackHeadPosition()) & 4294967295L;
        if (zzkq.f28747a <= 22 && this.f22000b) {
            if (this.f21999a.getPlayState() == 1) {
                this.f22002d = playbackHeadPosition;
            } else if (this.f21999a.getPlayState() == 2 && playbackHeadPosition == 0) {
                this.f22004f = this.f22002d;
            }
            playbackHeadPosition += this.f22004f;
        }
        if (this.f22002d > playbackHeadPosition) {
            this.f22003e++;
        }
        this.f22002d = playbackHeadPosition;
        return playbackHeadPosition + (this.f22003e << 32);
    }

    /* renamed from: c */
    public final long mo28797c() {
        return (mo28796b() * 1000000) / ((long) this.f22001c);
    }

    /* renamed from: d */
    public boolean mo28798d() {
        return false;
    }

    /* renamed from: e */
    public long mo28799e() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: f */
    public long mo28800f() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ C9263Yq(C9242Xq xq) {
        this();
    }
}
