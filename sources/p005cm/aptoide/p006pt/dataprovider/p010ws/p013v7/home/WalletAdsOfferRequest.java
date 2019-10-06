package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.home.WalletAdsOfferRequest */
public class WalletAdsOfferRequest extends C0044V7<WalletAdsOfferResponse, BaseBody> {
    protected WalletAdsOfferRequest(BaseBody body, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static WalletAdsOfferRequest m7552of(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        WalletAdsOfferRequest walletAdsOfferRequest = new WalletAdsOfferRequest(new BaseBody(), httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        return walletAdsOfferRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<WalletAdsOfferResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.isWalletOfferActive((BaseBody) this.body, bypassCache);
    }
}
