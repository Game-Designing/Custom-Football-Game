package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzro {

    /* renamed from: a */
    public final int f29253a;

    /* renamed from: b */
    private final zzrm[] f29254b;

    /* renamed from: c */
    private int f29255c;

    public zzro(zzrm... zzrmArr) {
        this.f29254b = zzrmArr;
        this.f29253a = zzrmArr.length;
    }

    /* renamed from: a */
    public final zzrm mo32162a(int i) {
        return this.f29254b[i];
    }

    /* renamed from: a */
    public final zzrm[] mo32163a() {
        return (zzrm[]) this.f29254b.clone();
    }

    public final int hashCode() {
        if (this.f29255c == 0) {
            this.f29255c = Arrays.hashCode(this.f29254b) + 527;
        }
        return this.f29255c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzro.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f29254b, ((zzro) obj).f29254b);
    }
}
