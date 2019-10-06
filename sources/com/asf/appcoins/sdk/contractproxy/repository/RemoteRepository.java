package com.asf.appcoins.sdk.contractproxy.repository;

import p320f.p321a.C13810v;
import p320f.p321a.p326c.C13212n;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RemoteRepository {
    private final ApiProvider apiProvider;

    public interface Api {
        @GET("appc/proxyaddress")
        C13810v<ProxyResponse> getAddress(@Query("contract") String str);
    }

    public enum Contracts {
        APPCOINS_IAB("appcoinsiab"),
        APPCOINS("appcoins"),
        APPCOINS_ADS("advertisement");
        
        /* access modifiers changed from: private */
        public final String value;

        private Contracts(String value2) {
            this.value = value2;
        }
    }

    private static class ProxyResponse {
        private String wallet;

        public String getWallet() {
            return this.wallet;
        }

        public void setWallet(String wallet2) {
            this.wallet = wallet2;
        }
    }

    public RemoteRepository(ApiProvider apiProvider2) {
        this.apiProvider = apiProvider2;
    }

    public C13810v<String> getAddress(Contracts contract, int chainId) {
        return this.apiProvider.getApi(chainId).getAddress(contract.value).mo43154a((C13212n<? super T, ? extends R>) C5870a.f10210a);
    }
}
