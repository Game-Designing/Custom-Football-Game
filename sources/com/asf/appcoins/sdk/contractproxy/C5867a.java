package com.asf.appcoins.sdk.contractproxy;

import com.asf.appcoins.sdk.contractproxy.repository.ApiProvider;
import com.asf.appcoins.sdk.contractproxy.repository.RemoteRepository.Api;

/* renamed from: com.asf.appcoins.sdk.contractproxy.a */
/* compiled from: lambda */
public final /* synthetic */ class C5867a implements ApiProvider {

    /* renamed from: a */
    private final /* synthetic */ AppCoinsAddressProxyBuilder f10206a;

    public /* synthetic */ C5867a(AppCoinsAddressProxyBuilder appCoinsAddressProxyBuilder) {
        this.f10206a = appCoinsAddressProxyBuilder;
    }

    public final Api getApi(int i) {
        return this.f10206a.provideApi(i);
    }
}
