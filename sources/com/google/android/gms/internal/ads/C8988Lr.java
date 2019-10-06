package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* renamed from: com.google.android.gms.internal.ads.Lr */
class C8988Lr {

    /* renamed from: a */
    protected AudioTrack f21445a;

    /* renamed from: b */
    private boolean f21446b;

    /* renamed from: c */
    private int f21447c;

    /* renamed from: d */
    private long f21448d;

    /* renamed from: e */
    private long f21449e;

    /* renamed from: f */
    private long f21450f;

    /* renamed from: g */
    private long f21451g;

    /* renamed from: h */
    private long f21452h;

    /* renamed from: i */
    private long f21453i;

    private C8988Lr() {
    }

    /* renamed from: a */
    public void mo28439a(AudioTrack audioTrack, boolean z) {
        this.f21445a = audioTrack;
        this.f21446b = z;
        this.f21451g = -9223372036854775807L;
        this.f21448d = 0;
        this.f21449e = 0;
        this.f21450f = 0;
        if (audioTrack != null) {
            this.f21447c = audioTrack.getSampleRate();
        }
    }

    /* renamed from: a */
    public final void mo28438a(long j) {
        this.f21452h = mo28441c();
        this.f21451g = SystemClock.elapsedRealtime() * 1000;
        this.f21453i = j;
        this.f21445a.stop();
    }

    /* renamed from: a */
    public final void mo28437a() {
        if (this.f21451g == -9223372036854775807L) {
            this.f21445a.pause();
        }
    }

    /* renamed from: c */
    public final long mo28441c() {
        if (this.f21451g != -9223372036854775807L) {
            return Math.min(this.f21453i, this.f21452h + ((((SystemClock.elapsedRealtime() * 1000) - this.f21451g) * ((long) this.f21447c)) / 1000000));
        }
        int playState = this.f21445a.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.f21445a.getPlaybackHeadPosition());
        if (this.f21446b) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f21450f = this.f21448d;
            }
            playbackHeadPosition += this.f21450f;
        }
        if (this.f21448d > playbackHeadPosition) {
            this.f21449e++;
        }
        this.f21448d = playbackHeadPosition;
        return playbackHeadPosition + (this.f21449e << 32);
    }

    /* renamed from: b */
    public final long mo28440b() {
        return (mo28441c() * 1000000) / ((long) this.f21447c);
    }

    /* renamed from: d */
    public boolean mo28442d() {
        return false;
    }

    /* renamed from: e */
    public long mo28443e() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: f */
    public long mo28444f() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ C8988Lr(C8967Kr kr) {
        this();
    }
}
