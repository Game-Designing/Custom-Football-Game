package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.support.p000v4.app.C0014p;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class LifecycleActivity {

    /* renamed from: a */
    private final Object f19695a;

    @KeepForSdk
    /* renamed from: c */
    public boolean mo27511c() {
        return this.f19695a instanceof C0014p;
    }

    /* renamed from: d */
    public final boolean mo27512d() {
        return this.f19695a instanceof Activity;
    }

    @KeepForSdk
    /* renamed from: a */
    public Activity mo27509a() {
        return (Activity) this.f19695a;
    }

    @KeepForSdk
    /* renamed from: b */
    public C0014p mo27510b() {
        return (C0014p) this.f19695a;
    }
}
