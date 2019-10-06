package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* renamed from: com.google.android.gms.internal.measurement.nb */
final class C9992nb {

    /* renamed from: a */
    final int f30148a;

    /* renamed from: b */
    final byte[] f30149b;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C9992nb)) {
            return false;
        }
        C9992nb nbVar = (C9992nb) obj;
        if (this.f30148a != nbVar.f30148a || !Arrays.equals(this.f30149b, nbVar.f30149b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((this.f30148a + 527) * 31) + Arrays.hashCode(this.f30149b);
    }
}
