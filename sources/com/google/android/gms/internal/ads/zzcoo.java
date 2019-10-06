package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzcoo implements zzf {

    /* renamed from: a */
    private final zzbri f27128a;

    /* renamed from: b */
    private final zzbrt f27129b;

    /* renamed from: c */
    private final zzbvd f27130c;

    /* renamed from: d */
    private final zzbva f27131d;

    /* renamed from: e */
    private final zzbmn f27132e;

    /* renamed from: f */
    private AtomicBoolean f27133f = new AtomicBoolean(false);

    zzcoo(zzbri zzbri, zzbrt zzbrt, zzbvd zzbvd, zzbva zzbva, zzbmn zzbmn) {
        this.f27128a = zzbri;
        this.f27129b = zzbrt;
        this.f27130c = zzbvd;
        this.f27131d = zzbva;
        this.f27132e = zzbmn;
    }

    public final synchronized void zzg(View view) {
        if (this.f27133f.compareAndSet(false, true)) {
            this.f27132e.onAdImpression();
            this.f27131d.mo30923a(view);
        }
    }

    public final void zzky() {
        if (this.f27133f.get()) {
            this.f27128a.onAdClicked();
        }
    }

    public final void zzkz() {
        if (this.f27133f.get()) {
            this.f27129b.mo30877G();
            this.f27130c.mo30925G();
        }
    }
}
