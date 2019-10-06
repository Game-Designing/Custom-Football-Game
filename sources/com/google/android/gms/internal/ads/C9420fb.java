package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* renamed from: com.google.android.gms.internal.ads.fb */
final class C9420fb implements zzo {

    /* renamed from: a */
    private final /* synthetic */ zzapl f22281a;

    C9420fb(zzapl zzapl) {
        this.f22281a = zzapl;
    }

    public final void zzsz() {
        zzbad.m26352a("AdMobCustomTabsAdapter overlay is closed.");
        this.f22281a.f24525b.onAdClosed(this.f22281a);
    }

    public final void onPause() {
        zzbad.m26352a("AdMobCustomTabsAdapter overlay is paused.");
    }

    public final void onResume() {
        zzbad.m26352a("AdMobCustomTabsAdapter overlay is resumed.");
    }

    public final void zzta() {
        zzbad.m26352a("Opening AdMobCustomTabsAdapter overlay.");
        this.f22281a.f24525b.onAdOpened(this.f22281a);
    }
}
