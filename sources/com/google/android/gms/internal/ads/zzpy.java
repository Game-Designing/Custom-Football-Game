package com.google.android.gms.internal.ads;

public final class zzpy implements zzqx {

    /* renamed from: a */
    private final zzqx[] f29150a;

    public zzpy(zzqx[] zzqxArr) {
        this.f29150a = zzqxArr;
    }

    /* renamed from: c */
    public final long mo28297c() {
        long j = Long.MAX_VALUE;
        for (zzqx c : this.f29150a) {
            long c2 = c.mo28297c();
            if (c2 != Long.MIN_VALUE) {
                j = Math.min(j, c2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    /* renamed from: b */
    public final boolean mo28296b(long j) {
        zzqx[] zzqxArr;
        boolean z;
        boolean z2 = false;
        do {
            long c = mo28297c();
            if (c == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzqx zzqx : this.f29150a) {
                if (zzqx.mo28297c() == c) {
                    z |= zzqx.mo28296b(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }
}
