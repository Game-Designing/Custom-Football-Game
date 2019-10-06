package com.asf.appcoins.sdk.contractproxy;

import com.asf.appcoins.sdk.contractproxy.proxy.WalletAddressProvider;
import com.asf.appcoins.sdk.contractproxy.proxy.Web3jProxyContract;
import java.util.Map;
import p320f.p321a.C13810v;
import p320f.p321a.p326c.C13212n;
import p320f.p321a.p344h.C13777b;

public class ContractAddressProvider implements AppCoinsAddressProxySdk {
    static final String ADVERTISEMENT_CONTRACT_ID = "advertisement";
    static final String APPCOINS_CONTRACT_ID = "appcoins";
    static final String IAB_CONTRACT_ID = "appcoinsiab";
    private int NETWORK_ROPSTEN = 3;
    private final Map<String, String> cache;
    private final WalletAddressProvider walletProvider;
    private final Web3jProxyContract web3jProxyContract;

    public ContractAddressProvider(WalletAddressProvider walletProvider2, Web3jProxyContract web3jProxyContract2, Map<String, String> cache2) {
        this.walletProvider = walletProvider2;
        this.web3jProxyContract = web3jProxyContract2;
        this.cache = cache2;
    }

    public C13810v<String> getAppCoinsAddress(int chainId) {
        return getAddress(chainId, APPCOINS_CONTRACT_ID);
    }

    public C13810v<String> getIabAddress(int chainId) {
        return getAddress(chainId, IAB_CONTRACT_ID);
    }

    public C13810v<String> getAdsAddress(int chainId) {
        return getAddress(chainId, ADVERTISEMENT_CONTRACT_ID);
    }

    private C13810v<String> getAddress(int chainId, String contractId) {
        return this.walletProvider.get().mo43155a(C13777b.m43847b()).mo43154a((C13212n<? super T, ? extends R>) new C5868b<Object,Object>(this, chainId, contractId));
    }

    /* access modifiers changed from: private */
    /* renamed from: syncGetContractAddress */
    public synchronized String mo18332a(int chainId, String wallet, String contractId) {
        String key;
        StringBuilder sb = new StringBuilder();
        sb.append(contractId);
        sb.append(chainId);
        key = sb.toString();
        if (this.cache.get(key) == null) {
            this.cache.put(key, this.web3jProxyContract.getContractAddressById(wallet, chainId, contractId));
        }
        return (String) this.cache.get(key);
    }
}
