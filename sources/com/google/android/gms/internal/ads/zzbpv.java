package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbpv implements zzo {

    /* renamed from: a */
    private final zzbse f25767a;

    /* renamed from: b */
    private AtomicBoolean f25768b = new AtomicBoolean(false);

    public zzbpv(zzbse zzbse) {
        this.f25767a = zzbse;
    }

    public final void zzsz() {
        this.f25768b.set(true);
        this.f25767a.mo30882G();
    }

    public final void onPause() {
    }

    public final void onResume() {
    }

    public final void zzta() {
        this.f25767a.mo30884I();
    }

    /* renamed from: a */
    public final boolean mo30863a() {
        return this.f25768b.get();
    }
}
