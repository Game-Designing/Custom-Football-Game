package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

/* renamed from: com.google.android.gms.internal.ads.hf */
final class C9468hf implements OnAttachStateChangeListener {

    /* renamed from: a */
    private final /* synthetic */ zzavb f22406a;

    /* renamed from: b */
    private final /* synthetic */ zzbio f22407b;

    C9468hf(zzbio zzbio, zzavb zzavb) {
        this.f22407b = zzbio;
        this.f22406a = zzavb;
    }

    public final void onViewAttachedToWindow(View view) {
        this.f22407b.m27023a(view, this.f22406a, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
