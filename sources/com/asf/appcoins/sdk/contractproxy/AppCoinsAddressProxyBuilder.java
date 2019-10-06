package com.asf.appcoins.sdk.contractproxy;

import com.asf.appcoins.sdk.contractproxy.repository.RemoteRepository;
import com.asf.appcoins.sdk.contractproxy.repository.RemoteRepository.Api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit.Builder;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public final class AppCoinsAddressProxyBuilder {
    public AppCoinsAddressProxySdk createAddressProxySdk() {
        return new BdsAppCoinsAddressProxySdk(new RemoteRepository(new C5867a(this)));
    }

    /* access modifiers changed from: private */
    public Api provideApi(int chainId) {
        String baseHost;
        if (chainId != 3) {
            baseHost = BuildConfig.MAIN_NETWORK_BACKEND_BASE_HOST;
        } else {
            baseHost = BuildConfig.ROPSTEN_NETWORK_BACKEND_BASE_HOST;
        }
        return (Api) new Builder().baseUrl(baseHost).client(new OkHttpClient.Builder().build()).addConverterFactory(JacksonConverterFactory.create()).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build().create(Api.class);
    }
}
