package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import p005cm.aptoide.p006pt.BuildConfig;

@zzard
public final class zzawt {

    /* renamed from: a */
    private BigInteger f24920a = BigInteger.ONE;

    /* renamed from: b */
    private String f24921b = BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;

    /* renamed from: a */
    public final synchronized String mo30186a() {
        String bigInteger;
        bigInteger = this.f24920a.toString();
        this.f24920a = this.f24920a.add(BigInteger.ONE);
        this.f24921b = bigInteger;
        return bigInteger;
    }

    /* renamed from: b */
    public final synchronized String mo30187b() {
        return this.f24921b;
    }
}
