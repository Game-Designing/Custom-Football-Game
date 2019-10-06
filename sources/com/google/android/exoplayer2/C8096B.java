package com.google.android.exoplayer2;

import com.google.android.exoplayer2.util.C8514e;

/* renamed from: com.google.android.exoplayer2.B */
/* compiled from: SeekParameters */
public final class C8096B {

    /* renamed from: a */
    public static final C8096B f16472a = new C8096B(0, 0);

    /* renamed from: b */
    public static final C8096B f16473b = new C8096B(Long.MAX_VALUE, Long.MAX_VALUE);

    /* renamed from: c */
    public static final C8096B f16474c = new C8096B(Long.MAX_VALUE, 0);

    /* renamed from: d */
    public static final C8096B f16475d = new C8096B(0, Long.MAX_VALUE);

    /* renamed from: e */
    public static final C8096B f16476e = f16472a;

    /* renamed from: f */
    public final long f16477f;

    /* renamed from: g */
    public final long f16478g;

    public C8096B(long toleranceBeforeUs, long toleranceAfterUs) {
        boolean z = true;
        C8514e.m20488a(toleranceBeforeUs >= 0);
        if (toleranceAfterUs < 0) {
            z = false;
        }
        C8514e.m20488a(z);
        this.f16477f = toleranceBeforeUs;
        this.f16478g = toleranceAfterUs;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C8096B other = (C8096B) obj;
        if (!(this.f16477f == other.f16477f && this.f16478g == other.f16478g)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (((int) this.f16477f) * 31) + ((int) this.f16478g);
    }
}
