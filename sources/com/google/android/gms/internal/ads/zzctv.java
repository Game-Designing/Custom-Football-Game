package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.mopub.common.AdType;
import java.util.Set;

public final class zzctv implements zzcuz<Bundle> {

    /* renamed from: a */
    private final String f27374a;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m28869b(Set<String> set) {
        if (set.contains("rewarded") || set.contains(AdType.INTERSTITIAL) || set.contains("native") || set.contains("banner")) {
            return true;
        }
        return false;
    }

    public zzctv(String str) {
        this.f27374a = str;
    }

    /* renamed from: a */
    public final /* synthetic */ void mo28065a(Object obj) {
        zzcxz.m28993a((Bundle) obj, "omid_v", this.f27374a);
    }
}
