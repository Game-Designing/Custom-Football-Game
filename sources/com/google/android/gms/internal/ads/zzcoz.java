package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;

public final class zzcoz implements zzf {

    /* renamed from: a */
    private zzf f27150a;

    /* renamed from: a */
    public final synchronized void mo31221a(zzf zzf) {
        this.f27150a = zzf;
    }

    public final synchronized void zzg(View view) {
        if (this.f27150a != null) {
            this.f27150a.zzg(view);
        }
    }

    public final synchronized void zzky() {
        if (this.f27150a != null) {
            this.f27150a.zzky();
        }
    }

    public final synchronized void zzkz() {
        if (this.f27150a != null) {
            this.f27150a.zzkz();
        }
    }
}
