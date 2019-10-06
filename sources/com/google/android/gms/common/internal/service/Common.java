package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;

public final class Common {
    @KeepForSdk

    /* renamed from: a */
    public static final ClientKey<zai> f20168a = new ClientKey<>();

    /* renamed from: b */
    private static final AbstractClientBuilder<zai, NoOptions> f20169b = new C8712a();
    @KeepForSdk

    /* renamed from: c */
    public static final Api<NoOptions> f20170c = new Api<>("Common.API", f20169b, f20168a);

    /* renamed from: d */
    public static final zac f20171d = new zad();
}
