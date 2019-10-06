package com.google.android.gms.internal.ads;

import java.util.Random;

@zzard
public final class zzyu extends zzzz {

    /* renamed from: b */
    private final Random f29799b = new Random();

    /* renamed from: c */
    private long f29800c;

    /* renamed from: d */
    private final Object f29801d = new Object();

    public zzyu() {
        mo32392ib();
    }

    /* renamed from: ib */
    public final void mo32392ib() {
        synchronized (this.f29801d) {
            int i = 3;
            long j = 0;
            while (true) {
                i--;
                if (i <= 0) {
                    break;
                }
                j = ((long) this.f29799b.nextInt()) + 2147483648L;
                if (j != this.f29800c && j != 0) {
                    break;
                }
            }
            this.f29800c = j;
        }
    }

    public final long getValue() {
        return this.f29800c;
    }
}
