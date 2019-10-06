package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.C8095A;
import com.google.android.exoplayer2.util.C8509F;

/* renamed from: com.google.android.exoplayer2.trackselection.k */
/* compiled from: TrackSelectorResult */
public final class C8437k {

    /* renamed from: a */
    public final int f18478a;

    /* renamed from: b */
    public final C8095A[] f18479b;

    /* renamed from: c */
    public final C8434i f18480c;

    /* renamed from: d */
    public final Object f18481d;

    public C8437k(C8095A[] rendererConfigurations, C8432h[] selections, Object info) {
        this.f18479b = rendererConfigurations;
        this.f18480c = new C8434i(selections);
        this.f18481d = info;
        this.f18478a = rendererConfigurations.length;
    }

    /* renamed from: a */
    public boolean mo25861a(int index) {
        return this.f18479b[index] != null;
    }

    /* renamed from: a */
    public boolean mo25862a(C8437k other) {
        if (other == null || other.f18480c.f18473a != this.f18480c.f18473a) {
            return false;
        }
        for (int i = 0; i < this.f18480c.f18473a; i++) {
            if (!mo25863a(other, i)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public boolean mo25863a(C8437k other, int index) {
        boolean z = false;
        if (other == null) {
            return false;
        }
        if (C8509F.m20455a((Object) this.f18479b[index], (Object) other.f18479b[index]) && C8509F.m20455a((Object) this.f18480c.mo25855a(index), (Object) other.f18480c.mo25855a(index))) {
            z = true;
        }
        return z;
    }
}
