package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.WindowInsets;

/* renamed from: com.google.android.gms.internal.ads.kc */
final /* synthetic */ class C9531kc implements OnApplyWindowInsetsListener {

    /* renamed from: a */
    private final zzaxy f22639a;

    /* renamed from: b */
    private final Activity f22640b;

    C9531kc(zzaxy zzaxy, Activity activity) {
        this.f22639a = zzaxy;
        this.f22640b = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzaxy.m26204a(this.f22640b, view, windowInsets);
    }
}
