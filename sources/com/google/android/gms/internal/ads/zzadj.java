package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
public final class zzadj extends zzadm {

    /* renamed from: b */
    private final zzf f24240b;

    /* renamed from: c */
    private final String f24241c;

    /* renamed from: d */
    private final String f24242d;

    public zzadj(zzf zzf, String str, String str2) {
        this.f24240b = zzf;
        this.f24241c = str;
        this.f24242d = str2;
    }

    /* renamed from: qa */
    public final String mo29625qa() {
        return this.f24241c;
    }

    public final String getContent() {
        return this.f24242d;
    }

    /* renamed from: f */
    public final void mo29623f(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.f24240b.zzg((View) ObjectWrapper.m22187H(iObjectWrapper));
        }
    }

    public final void recordClick() {
        this.f24240b.zzky();
    }

    public final void recordImpression() {
        this.f24240b.zzkz();
    }
}
