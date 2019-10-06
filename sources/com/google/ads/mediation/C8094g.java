package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* renamed from: com.google.ads.mediation.g */
final class C8094g extends AdMetadataListener {

    /* renamed from: a */
    private final /* synthetic */ AbstractAdViewAdapter f16469a;

    C8094g(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.f16469a = abstractAdViewAdapter;
    }

    public final void onAdMetadataChanged() {
        if (this.f16469a.zzmh != null && this.f16469a.zzmi != null) {
            this.f16469a.zzmi.zzb(this.f16469a.zzmh.getAdMetadata());
        }
    }
}
