package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* renamed from: com.google.android.gms.ads.internal.overlay.g */
final /* synthetic */ class C8589g implements Runnable {

    /* renamed from: a */
    private final C8588f f19083a;

    /* renamed from: b */
    private final Drawable f19084b;

    C8589g(C8588f fVar, Drawable drawable) {
        this.f19083a = fVar;
        this.f19084b = drawable;
    }

    public final void run() {
        C8588f fVar = this.f19083a;
        fVar.f19082d.f19093c.getWindow().setBackgroundDrawable(this.f19084b);
    }
}
