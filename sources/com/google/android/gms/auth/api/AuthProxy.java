package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzar;

@KeepForSdk
public final class AuthProxy {

    /* renamed from: a */
    private static final ClientKey<zzak> f19292a = new ClientKey<>();

    /* renamed from: b */
    private static final AbstractClientBuilder<zzak, AuthProxyOptions> f19293b = new C8604a();
    @KeepForSdk

    /* renamed from: c */
    public static final Api<AuthProxyOptions> f19294c = new Api<>("Auth.PROXY_API", f19293b, f19292a);
    @KeepForSdk

    /* renamed from: d */
    public static final ProxyApi f19295d = new zzar();
}
