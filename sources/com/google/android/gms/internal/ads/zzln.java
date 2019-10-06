package com.google.android.gms.internal.ads;

public final class zzln {

    /* renamed from: a */
    public static final zzln f28809a = new zzln(1.0f, 1.0f);

    /* renamed from: b */
    public final float f28810b;

    /* renamed from: c */
    public final float f28811c;

    /* renamed from: d */
    private final int f28812d;

    public zzln(float f, float f2) {
        this.f28810b = f;
        this.f28811c = f2;
        this.f28812d = Math.round(f * 1000.0f);
    }

    /* renamed from: a */
    public final long mo31949a(long j) {
        return j * ((long) this.f28812d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzln.class != obj.getClass()) {
            return false;
        }
        zzln zzln = (zzln) obj;
        if (this.f28810b == zzln.f28810b && this.f28811c == zzln.f28811c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToRawIntBits(this.f28810b) + 527) * 31) + Float.floatToRawIntBits(this.f28811c);
    }
}
