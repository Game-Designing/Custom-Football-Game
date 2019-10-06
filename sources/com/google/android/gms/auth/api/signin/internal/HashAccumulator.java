package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

public class HashAccumulator {
    @VisibleForTesting

    /* renamed from: a */
    private static int f19467a = 31;

    /* renamed from: b */
    private int f19468b = 1;

    @KeepForSdk
    /* renamed from: a */
    public HashAccumulator mo27220a(Object obj) {
        this.f19468b = (f19467a * this.f19468b) + (obj == null ? 0 : obj.hashCode());
        return this;
    }

    /* renamed from: a */
    public final HashAccumulator mo27221a(boolean z) {
        this.f19468b = (f19467a * this.f19468b) + (z ? 1 : 0);
        return this;
    }

    @KeepForSdk
    /* renamed from: a */
    public int mo27219a() {
        return this.f19468b;
    }
}
