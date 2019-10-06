package com.asf.appcoins.sdk.contractproxy;

import com.asf.appcoins.sdk.contractproxy.repository.RemoteRepository;
import com.asf.appcoins.sdk.contractproxy.repository.RemoteRepository.Contracts;
import p320f.p321a.C13810v;

public class BdsAppCoinsAddressProxySdk implements AppCoinsAddressProxySdk {
    private final RemoteRepository repository;

    public BdsAppCoinsAddressProxySdk(RemoteRepository repository2) {
        this.repository = repository2;
    }

    public C13810v<String> getAppCoinsAddress(int chainId) {
        return this.repository.getAddress(Contracts.APPCOINS, chainId);
    }

    public C13810v<String> getIabAddress(int chainId) {
        return this.repository.getAddress(Contracts.APPCOINS_IAB, chainId);
    }

    public C13810v<String> getAdsAddress(int chainId) {
        return this.repository.getAddress(Contracts.APPCOINS_ADS, chainId);
    }
}
