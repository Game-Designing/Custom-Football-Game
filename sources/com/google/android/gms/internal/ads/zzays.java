package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

public final class zzays {

    /* renamed from: a */
    public final String f24998a;

    /* renamed from: b */
    private final double f24999b;

    /* renamed from: c */
    private final double f25000c;

    /* renamed from: d */
    public final double f25001d;

    /* renamed from: e */
    public final int f25002e;

    public zzays(String str, double d, double d2, double d3, int i) {
        this.f24998a = str;
        this.f25000c = d;
        this.f24999b = d2;
        this.f25001d = d3;
        this.f25002e = i;
    }

    public final String toString() {
        return Objects.m21850a((Object) this).mo27810a("name", this.f24998a).mo27810a("minBound", Double.valueOf(this.f25000c)).mo27810a("maxBound", Double.valueOf(this.f24999b)).mo27810a("percent", Double.valueOf(this.f25001d)).mo27810a("count", Integer.valueOf(this.f25002e)).toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzays)) {
            return false;
        }
        zzays zzays = (zzays) obj;
        if (Objects.m21851a(this.f24998a, zzays.f24998a) && this.f24999b == zzays.f24999b && this.f25000c == zzays.f25000c && this.f25002e == zzays.f25002e && Double.compare(this.f25001d, zzays.f25001d) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.m21849a(this.f24998a, Double.valueOf(this.f24999b), Double.valueOf(this.f25000c), Double.valueOf(this.f25001d), Integer.valueOf(this.f25002e));
    }
}
