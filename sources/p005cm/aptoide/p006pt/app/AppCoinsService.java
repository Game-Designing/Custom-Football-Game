package p005cm.aptoide.p006pt.app;

import android.content.SharedPreferences;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListAppCoinsCampaigns;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetAppCoinsCampaignsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetAppCoinsCampaignsRequest.Body;
import p026rx.C0120S;
import p026rx.Single;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.app.AppCoinsService */
public class AppCoinsService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences preferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3063762198498262335L, "cm/aptoide/pt/app/AppCoinsService", 12);
        $jacocoData = probes;
        return probes;
    }

    public AppCoinsService(OkHttpClient httpClient2, TokenInvalidator tokenInvalidator2, SharedPreferences preferences2, BodyInterceptor<BaseBody> bodyInterceptor2, Factory converterFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.httpClient = httpClient2;
        this.tokenInvalidator = tokenInvalidator2;
        this.preferences = preferences2;
        this.bodyInterceptor = bodyInterceptor2;
        this.converterFactory = converterFactory2;
        $jacocoInit[0] = true;
    }

    public Single<AppCoinsAdvertisingModel> getValidCampaign(String packageName, int versionCode) {
        boolean[] $jacocoInit = $jacocoInit();
        GetAppCoinsCampaignsRequest getAppCoinsCampaignsRequest = new GetAppCoinsCampaignsRequest(new Body(packageName, versionCode), this.httpClient, this.converterFactory, this.bodyInterceptor, this.tokenInvalidator, this.preferences);
        $jacocoInit[1] = true;
        C0120S observe = getAppCoinsCampaignsRequest.observe();
        $jacocoInit[2] = true;
        Single n = observe.mo3678n();
        C1724c cVar = new C1724c(this);
        $jacocoInit[3] = true;
        Single<AppCoinsAdvertisingModel> d = n.mo3698d(cVar);
        $jacocoInit[4] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ AppCoinsAdvertisingModel mo10091a(ListAppCoinsCampaigns listAppCoinsCampaigns) {
        boolean[] $jacocoInit = $jacocoInit();
        AppCoinsAdvertisingModel mapAdvertising = mapAdvertising(listAppCoinsCampaigns);
        $jacocoInit[11] = true;
        return mapAdvertising;
    }

    private AppCoinsAdvertisingModel mapAdvertising(ListAppCoinsCampaigns listAppCoinsCampaigns) {
        boolean[] $jacocoInit = $jacocoInit();
        List list = listAppCoinsCampaigns.getList();
        $jacocoInit[5] = true;
        if (list.isEmpty()) {
            $jacocoInit[6] = true;
            AppCoinsAdvertisingModel appCoinsAdvertisingModel = new AppCoinsAdvertisingModel();
            $jacocoInit[7] = true;
            return appCoinsAdvertisingModel;
        }
        List list2 = listAppCoinsCampaigns.getList();
        $jacocoInit[8] = true;
        AppCoinsCampaign appCoinsCampaign = (AppCoinsCampaign) list2.get(0);
        $jacocoInit[9] = true;
        AppCoinsAdvertisingModel appCoinsAdvertisingModel2 = new AppCoinsAdvertisingModel(appCoinsCampaign.getReward(), true);
        $jacocoInit[10] = true;
        return appCoinsAdvertisingModel2;
    }
}
