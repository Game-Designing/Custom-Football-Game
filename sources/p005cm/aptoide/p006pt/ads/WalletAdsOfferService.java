package p005cm.aptoide.p006pt.ads;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.WalletAdsOfferRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.WalletAdsOfferResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home.WalletAdsOfferResponse.WalletAdOffer;
import p026rx.C0120S;
import p026rx.Single;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.ads.WalletAdsOfferService */
public class WalletAdsOfferService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    private final Factory converterFactory;
    private final OkHttpClient okHttpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1164613638894009922L, "cm/aptoide/pt/ads/WalletAdsOfferService", 8);
        $jacocoData = probes;
        return probes;
    }

    public WalletAdsOfferService(BodyInterceptor<BaseBody> bodyInterceptorPoolV72, OkHttpClient okHttpClient2, TokenInvalidator tokenInvalidator2, Factory converterFactory2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyInterceptorPoolV7 = bodyInterceptorPoolV72;
        this.okHttpClient = okHttpClient2;
        this.tokenInvalidator = tokenInvalidator2;
        this.converterFactory = converterFactory2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public Single<Boolean> isWalletOfferActive() {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAdsOfferRequest of = WalletAdsOfferRequest.m7552of(this.bodyInterceptorPoolV7, this.okHttpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[1] = true;
        C0120S observe = of.observe(false);
        $jacocoInit[2] = true;
        Single n = observe.mo3678n();
        C1646C c = C1646C.f4594a;
        $jacocoInit[3] = true;
        Single<Boolean> d = n.mo3698d(c);
        $jacocoInit[4] = true;
        return d;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m6408a(WalletAdsOfferResponse walletAdsOfferResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        WalletAdOffer data = walletAdsOfferResponse.getData();
        $jacocoInit[5] = true;
        boolean isOfferActive = data.isOfferActive();
        $jacocoInit[6] = true;
        Boolean valueOf = Boolean.valueOf(isOfferActive);
        $jacocoInit[7] = true;
        return valueOf;
    }
}
