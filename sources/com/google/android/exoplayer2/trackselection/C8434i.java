package com.google.android.exoplayer2.trackselection;

import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.trackselection.i */
/* compiled from: TrackSelectionArray */
public final class C8434i {

    /* renamed from: a */
    public final int f18473a;

    /* renamed from: b */
    private final C8432h[] f18474b;

    /* renamed from: c */
    private int f18475c;

    public C8434i(C8432h... trackSelections) {
        this.f18474b = trackSelections;
        this.f18473a = trackSelections.length;
    }

    /* renamed from: a */
    public C8432h mo25855a(int index) {
        return this.f18474b[index];
    }

    /* renamed from: a */
    public C8432h[] mo25856a() {
        return (C8432h[]) this.f18474b.clone();
    }

    public int hashCode() {
        if (this.f18475c == 0) {
            this.f18475c = (17 * 31) + Arrays.hashCode(this.f18474b);
        }
        return this.f18475c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f18474b, ((C8434i) obj).f18474b);
    }
}
