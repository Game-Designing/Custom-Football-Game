package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;

public final class zzchy extends zzars {

    /* renamed from: b */
    private final /* synthetic */ zzchx f26655b;

    protected zzchy(zzchx zzchx) {
        this.f26655b = zzchx;
    }

    /* renamed from: a */
    public final void mo30025a(ParcelFileDescriptor parcelFileDescriptor) {
        this.f26655b.f26649a.mo30338b(new AutoCloseInputStream(parcelFileDescriptor));
    }

    /* renamed from: a */
    public final void mo30026a(zzaym zzaym) {
        this.f26655b.f26649a.mo30337a(new zzayn(zzaym.f24990a, zzaym.f24991b));
    }
}
