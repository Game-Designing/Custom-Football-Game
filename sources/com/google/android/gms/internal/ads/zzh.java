package com.google.android.gms.internal.ads;

import com.mopub.volley.DefaultRetryPolicy;

public final class zzh implements zzac {

    /* renamed from: a */
    private int f28488a;

    /* renamed from: b */
    private int f28489b;

    /* renamed from: c */
    private final int f28490c;

    /* renamed from: d */
    private final float f28491d;

    public zzh() {
        this(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, 1, 1.0f);
    }

    private zzh(int i, int i2, float f) {
        this.f28488a = DefaultRetryPolicy.DEFAULT_TIMEOUT_MS;
        this.f28490c = 1;
        this.f28491d = 1.0f;
    }

    /* renamed from: G */
    public final int mo29576G() {
        return this.f28488a;
    }

    /* renamed from: h */
    public final int mo29578h() {
        return this.f28489b;
    }

    /* renamed from: a */
    public final void mo29577a(zzaf zzaf) throws zzaf {
        boolean z = true;
        this.f28489b++;
        int i = this.f28488a;
        this.f28488a = i + ((int) (((float) i) * this.f28491d));
        if (this.f28489b > this.f28490c) {
            z = false;
        }
        if (!z) {
            throw zzaf;
        }
    }
}
