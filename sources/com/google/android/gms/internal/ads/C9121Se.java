package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;

/* renamed from: com.google.android.gms.internal.ads.Se */
final class C9121Se implements OnAttachStateChangeListener {

    /* renamed from: a */
    private final /* synthetic */ zzavb f21690a;

    /* renamed from: b */
    private final /* synthetic */ zzbha f21691b;

    C9121Se(zzbha zzbha, zzavb zzavb) {
        this.f21691b = zzbha;
        this.f21690a = zzavb;
    }

    public final void onViewAttachedToWindow(View view) {
        this.f21691b.m26840a(view, this.f21690a, 10);
    }

    public final void onViewDetachedFromWindow(View view) {
    }
}
