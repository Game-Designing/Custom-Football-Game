package com.flurry.sdk;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

/* renamed from: com.flurry.sdk.Kb */
class C7407Kb implements ComponentCallbacks2 {

    /* renamed from: a */
    final /* synthetic */ C7412Lb f14521a;

    C7407Kb(C7412Lb lb) {
        this.f14521a = lb;
    }

    public final void onConfigurationChanged(Configuration configuration) {
    }

    public final void onLowMemory() {
    }

    public final void onTrimMemory(int i) {
        if (i == 20) {
            C7412Lb.m16400a(false);
        }
    }
}
