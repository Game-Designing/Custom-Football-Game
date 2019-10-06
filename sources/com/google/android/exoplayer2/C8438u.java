package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.u */
/* compiled from: PlaybackParameters */
public final class C8438u {

    /* renamed from: a */
    public static final C8438u f18482a = new C8438u(1.0f);

    /* renamed from: b */
    public final float f18483b;

    /* renamed from: c */
    public final float f18484c;

    /* renamed from: d */
    public final boolean f18485d;

    /* renamed from: e */
    private final int f18486e;

    public C8438u(float speed) {
        this(speed, 1.0f, false);
    }

    public C8438u(float speed, float pitch, boolean skipSilence) {
        boolean z = true;
        C8514e.m20488a(speed > 0.0f);
        if (pitch <= 0.0f) {
            z = false;
        }
        C8514e.m20488a(z);
        this.f18483b = speed;
        this.f18484c = pitch;
        this.f18485d = skipSilence;
        this.f18486e = Math.round(1000.0f * speed);
    }

    /* renamed from: a */
    public long mo25864a(long timeMs) {
        return ((long) this.f18486e) * timeMs;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C8438u other = (C8438u) obj;
        if (!(this.f18483b == other.f18483b && this.f18484c == other.f18484c && this.f18485d == other.f18485d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((((17 * 31) + Float.floatToRawIntBits(this.f18483b)) * 31) + Float.floatToRawIntBits(this.f18484c)) * 31) + (this.f18485d ? 1 : 0);
    }
}
