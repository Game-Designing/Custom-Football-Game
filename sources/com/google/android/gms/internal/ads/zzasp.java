package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

@zzard
public final class zzasp extends zzass {

    /* renamed from: b */
    private final String f24803b;

    /* renamed from: c */
    private final int f24804c;

    public zzasp(String str, int i) {
        this.f24803b = str;
        this.f24804c = i;
    }

    public final String getType() {
        return this.f24803b;
    }

    public final int getAmount() {
        return this.f24804c;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzasp)) {
            return false;
        }
        zzasp zzasp = (zzasp) obj;
        if (!Objects.m21851a(this.f24803b, zzasp.f24803b) || !Objects.m21851a(Integer.valueOf(this.f24804c), Integer.valueOf(zzasp.f24804c))) {
            return false;
        }
        return true;
    }
}
