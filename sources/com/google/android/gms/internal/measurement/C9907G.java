package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.measurement.G */
final class C9907G extends C9911I {

    /* renamed from: a */
    private int f29998a = 0;

    /* renamed from: b */
    private final int f29999b = this.f30000c.size();

    /* renamed from: c */
    private final /* synthetic */ zzte f30000c;

    C9907G(zzte zzte) {
        this.f30000c = zzte;
    }

    public final boolean hasNext() {
        return this.f29998a < this.f29999b;
    }

    public final byte nextByte() {
        int i = this.f29998a;
        if (i < this.f29999b) {
            this.f29998a = i + 1;
            return this.f30000c.mo32583h(i);
        }
        throw new NoSuchElementException();
    }
}
