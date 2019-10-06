package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

public final class zzaaj extends zzaah {

    /* renamed from: b */
    private final MuteThisAdListener f23793b;

    public zzaaj(MuteThisAdListener muteThisAdListener) {
        this.f23793b = muteThisAdListener;
    }

    public final void onAdMuted() {
        this.f23793b.onAdMuted();
    }
}
