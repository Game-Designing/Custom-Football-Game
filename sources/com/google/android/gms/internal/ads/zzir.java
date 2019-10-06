package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzir extends C9436fr {

    /* renamed from: ba */
    public final long f28618ba;

    /* renamed from: ca */
    public final List<zzis> f28619ca = new ArrayList();

    /* renamed from: da */
    public final List<zzir> f28620da = new ArrayList();

    public zzir(int i, long j) {
        super(i);
        this.f28618ba = j;
    }

    /* renamed from: c */
    public final zzis mo31865c(int i) {
        int size = this.f28619ca.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzis zzis = (zzis) this.f28619ca.get(i2);
            if (zzis.f22357aa == i) {
                return zzis;
            }
        }
        return null;
    }

    /* renamed from: d */
    public final zzir mo31866d(int i) {
        int size = this.f28620da.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzir zzir = (zzir) this.f28620da.get(i2);
            if (zzir.f22357aa == i) {
                return zzir;
            }
        }
        return null;
    }

    public final String toString() {
        String b = C9436fr.m23620b(this.f22357aa);
        String valueOf = String.valueOf(Arrays.toString(this.f28619ca.toArray(new zzis[0])));
        String valueOf2 = String.valueOf(Arrays.toString(this.f28620da.toArray(new zzir[0])));
        StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 22 + String.valueOf(valueOf).length() + String.valueOf(valueOf2).length());
        sb.append(b);
        sb.append(" leaves: ");
        sb.append(valueOf);
        sb.append(" containers: ");
        sb.append(valueOf2);
        return sb.toString();
    }
}
