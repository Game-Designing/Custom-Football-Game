package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;

/* renamed from: com.google.android.gms.internal.ads.vh */
final class C9772vh implements zzadx {

    /* renamed from: a */
    private final /* synthetic */ zzcab f23328a;

    /* renamed from: b */
    private final /* synthetic */ ViewGroup f23329b;

    /* renamed from: c */
    private final /* synthetic */ zzbzl f23330c;

    C9772vh(zzbzl zzbzl, zzcab zzcab, ViewGroup viewGroup) {
        this.f23330c = zzbzl;
        this.f23328a = zzcab;
        this.f23329b = viewGroup;
    }

    /* renamed from: a */
    public final void mo28870a() {
        if (zzbzl.m28120a(this.f23328a, zzbzj.f26183b)) {
            this.f23328a.onClick(this.f23329b);
        }
    }

    /* renamed from: a */
    public final void mo28871a(MotionEvent motionEvent) {
        this.f23328a.onTouch(null, motionEvent);
    }
}
