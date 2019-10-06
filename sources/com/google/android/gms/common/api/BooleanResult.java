package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class BooleanResult implements Result {

    /* renamed from: a */
    private final Status f19553a;

    /* renamed from: b */
    private final boolean f19554b;

    @KeepForSdk
    public Status getStatus() {
        return this.f19553a;
    }

    @KeepForSdk
    public final int hashCode() {
        return ((this.f19553a.hashCode() + 527) * 31) + (this.f19554b ? 1 : 0);
    }

    @KeepForSdk
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        if (!this.f19553a.equals(booleanResult.f19553a) || this.f19554b != booleanResult.f19554b) {
            return false;
        }
        return true;
    }
}
