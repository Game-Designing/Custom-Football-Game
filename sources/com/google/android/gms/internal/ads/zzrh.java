package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;

public final class zzrh {

    /* renamed from: a */
    public final String f29229a;

    /* renamed from: b */
    public final String f29230b;

    /* renamed from: c */
    public final boolean f29231c;

    /* renamed from: d */
    public final boolean f29232d;

    /* renamed from: e */
    public final int f29233e;

    /* renamed from: f */
    public final int f29234f;

    /* renamed from: g */
    public final int f29235g;

    /* renamed from: h */
    public final boolean f29236h;

    /* renamed from: i */
    public final boolean f29237i;

    /* renamed from: j */
    public final int f29238j;

    /* renamed from: k */
    public final int f29239k;

    /* renamed from: l */
    public final boolean f29240l;

    public zzrh() {
        this(null, null, false, true, MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT, true, true, MoPubClientPositioning.NO_REPEAT, MoPubClientPositioning.NO_REPEAT, true);
    }

    private zzrh(String str, String str2, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, int i4, int i5, boolean z5) {
        this.f29229a = null;
        this.f29230b = null;
        this.f29231c = false;
        this.f29232d = true;
        this.f29233e = MoPubClientPositioning.NO_REPEAT;
        this.f29234f = MoPubClientPositioning.NO_REPEAT;
        this.f29235g = MoPubClientPositioning.NO_REPEAT;
        this.f29236h = true;
        this.f29237i = true;
        this.f29238j = MoPubClientPositioning.NO_REPEAT;
        this.f29239k = MoPubClientPositioning.NO_REPEAT;
        this.f29240l = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzrh.class != obj.getClass()) {
            return false;
        }
        zzrh zzrh = (zzrh) obj;
        if (this.f29232d == zzrh.f29232d && this.f29233e == zzrh.f29233e && this.f29234f == zzrh.f29234f && this.f29236h == zzrh.f29236h && this.f29237i == zzrh.f29237i && this.f29240l == zzrh.f29240l && this.f29238j == zzrh.f29238j && this.f29239k == zzrh.f29239k && this.f29235g == zzrh.f29235g && TextUtils.equals(null, null) && TextUtils.equals(null, null)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        String str = null;
        return (((((((((((((((((((str.hashCode() * 31) + str.hashCode()) * 31 * 31) + (this.f29232d ? 1 : 0)) * 31) + this.f29233e) * 31) + this.f29234f) * 31) + this.f29235g) * 31) + (this.f29236h ? 1 : 0)) * 31) + (this.f29237i ? 1 : 0)) * 31) + (this.f29240l ? 1 : 0)) * 31) + this.f29238j) * 31) + this.f29239k;
    }
}
