package com.google.android.gms.internal.ads;

public final class zzvi {

    /* renamed from: a */
    final long f29530a;

    /* renamed from: b */
    final String f29531b;

    /* renamed from: c */
    final int f29532c;

    zzvi(long j, String str, int i) {
        this.f29530a = j;
        this.f29531b = str;
        this.f29532c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzvi)) {
            return false;
        }
        zzvi zzvi = (zzvi) obj;
        if (zzvi.f29530a == this.f29530a && zzvi.f29532c == this.f29532c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.f29530a;
    }
}
