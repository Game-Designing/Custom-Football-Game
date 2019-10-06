package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.ads.qo */
final class C9674qo extends C9716so {

    /* renamed from: a */
    private int f22909a = 0;

    /* renamed from: b */
    private final int f22910b = this.f22911c.size();

    /* renamed from: c */
    private final /* synthetic */ zzdmr f22911c;

    C9674qo(zzdmr zzdmr) {
        this.f22911c = zzdmr;
    }

    public final boolean hasNext() {
        return this.f22909a < this.f22910b;
    }

    public final byte nextByte() {
        int i = this.f22909a;
        if (i < this.f22910b) {
            this.f22909a = i + 1;
            return this.f22911c.mo29212h(i);
        }
        throw new NoSuchElementException();
    }
}
