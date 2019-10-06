package com.asf.appcoins.sdk.contractproxy.repository;

import com.asf.appcoins.sdk.contractproxy.repository.RemoteRepository.Api;

public interface ApiProvider {
    Api getApi(int i);
}
