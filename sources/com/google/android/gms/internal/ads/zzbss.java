package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbss extends zzbts<AdMetadataListener> implements zzagv {

    /* renamed from: b */
    private Bundle f25846b = new Bundle();

    public zzbss(Set<zzbuz<AdMetadataListener>> set) {
        super(set);
    }

    /* renamed from: a */
    public final synchronized void mo29003a(String str, Bundle bundle) {
        this.f25846b.putAll(bundle);
        mo30895a(C8767Bg.f20510a);
    }

    /* renamed from: G */
    public final synchronized Bundle mo30889G() {
        return new Bundle(this.f25846b);
    }
}
