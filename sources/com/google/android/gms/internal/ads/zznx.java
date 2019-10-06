package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zznx {

    /* renamed from: a */
    public final int f28981a = 1;

    /* renamed from: b */
    public final byte[] f28982b;

    public zznx(int i, byte[] bArr) {
        this.f28982b = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zznx.class != obj.getClass()) {
            return false;
        }
        zznx zznx = (zznx) obj;
        if (this.f28981a != zznx.f28981a || !Arrays.equals(this.f28982b, zznx.f28982b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (this.f28981a * 31) + Arrays.hashCode(this.f28982b);
    }
}
