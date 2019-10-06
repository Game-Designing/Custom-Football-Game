package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C8275d;
import com.google.android.exoplayer2.C8438u;

/* renamed from: com.google.android.exoplayer2.util.z */
/* compiled from: StandaloneMediaClock */
public final class C8542z implements C8528p {

    /* renamed from: a */
    private final C8517g f18881a;

    /* renamed from: b */
    private boolean f18882b;

    /* renamed from: c */
    private long f18883c;

    /* renamed from: d */
    private long f18884d;

    /* renamed from: e */
    private C8438u f18885e = C8438u.f18482a;

    public C8542z(C8517g clock) {
        this.f18881a = clock;
    }

    /* renamed from: b */
    public void mo26154b() {
        if (!this.f18882b) {
            this.f18884d = this.f18881a.mo26036a();
            this.f18882b = true;
        }
    }

    /* renamed from: c */
    public void mo26155c() {
        if (this.f18882b) {
            mo26153a(mo25145a());
            this.f18882b = false;
        }
    }

    /* renamed from: a */
    public void mo26153a(long positionUs) {
        this.f18883c = positionUs;
        if (this.f18882b) {
            this.f18884d = this.f18881a.mo26036a();
        }
    }

    /* renamed from: a */
    public long mo25145a() {
        long positionUs = this.f18883c;
        if (!this.f18882b) {
            return positionUs;
        }
        long elapsedSinceBaseMs = this.f18881a.mo26036a() - this.f18884d;
        C8438u uVar = this.f18885e;
        if (uVar.f18483b == 1.0f) {
            return positionUs + C8275d.m19230a(elapsedSinceBaseMs);
        }
        return positionUs + uVar.mo25864a(elapsedSinceBaseMs);
    }

    /* renamed from: a */
    public C8438u mo25147a(C8438u playbackParameters) {
        if (this.f18882b) {
            mo26153a(mo25145a());
        }
        this.f18885e = playbackParameters;
        return playbackParameters;
    }

    /* renamed from: e */
    public C8438u mo25164e() {
        return this.f18885e;
    }
}
