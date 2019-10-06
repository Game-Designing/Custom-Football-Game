package p005cm.aptoide.p006pt.repository.request;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp.AppCoinsCampaignInfo;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp.AppCoinsCampaignInfo.ClickUrls;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp.Stats;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.AppCoinsCampaign.CampaignApp.Stats.Rating;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListAppCoinsCampaigns;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetAppCoinsCampaignsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.GetAppCoinsCampaignsRequest.Body;
import p005cm.aptoide.p006pt.home.RewardApp;
import p005cm.aptoide.p006pt.install.InstallManager;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.repository.request.RewardAppCoinsAppsRepository */
public class RewardAppCoinsAppsRepository {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int APPCOINS_REWARD_LIMIT = 30;
    private BodyInterceptor<BaseBody> bodyInterceptor;
    private Factory converterFactory;
    private OkHttpClient httpClient;
    private InstallManager installManager;
    private SharedPreferences sharedPreferences;
    private TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8533426442028440574L, "cm/aptoide/pt/repository/request/RewardAppCoinsAppsRepository", 25);
        $jacocoData = probes;
        return probes;
    }

    public RewardAppCoinsAppsRepository(OkHttpClient httpClient2, Factory converterFactory2, BodyInterceptor<BaseBody> bodyInterceptor2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, InstallManager installManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.bodyInterceptor = bodyInterceptor2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.installManager = installManager2;
        $jacocoInit[0] = true;
    }

    public C0120S<List<RewardApp>> getAppCoinsRewardAppsFromHomeMore(boolean refresh, String tag) {
        boolean[] $jacocoInit = $jacocoInit();
        GetAppCoinsCampaignsRequest getAppCoinsCampaignsRequest = new GetAppCoinsCampaignsRequest(new Body(0, 30), this.httpClient, this.converterFactory, this.bodyInterceptor, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[1] = true;
        C0120S observe = getAppCoinsCampaignsRequest.observe(refresh);
        C4624a aVar = new C4624a(this, tag);
        $jacocoInit[2] = true;
        C0120S<List<RewardApp>> f = observe.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aVar);
        $jacocoInit[3] = true;
        return f;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo15947a(String tag, ListAppCoinsCampaigns response) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S map = map(response.getList(), tag);
        $jacocoInit[24] = true;
        return map;
    }

    private C0120S<List<RewardApp>> map(List<AppCoinsCampaign> list, String tag) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        List<RewardApp> rewardAppsList = new ArrayList<>();
        $jacocoInit[4] = true;
        $jacocoInit[5] = true;
        for (AppCoinsCampaign campaign : list) {
            $jacocoInit[6] = true;
            CampaignApp app = campaign.getApp();
            $jacocoInit[7] = true;
            if (this.installManager.wasAppEverInstalled(app.getPackageName())) {
                $jacocoInit[8] = true;
            } else {
                $jacocoInit[9] = true;
                String name = app.getName();
                String icon = app.getIcon();
                Stats stats = app.getStats();
                $jacocoInit[10] = true;
                Rating rating = stats.getRating();
                $jacocoInit[11] = true;
                float avg = rating.getAvg();
                Stats stats2 = app.getStats();
                $jacocoInit[12] = true;
                int pdownloads = stats2.getPdownloads();
                String packageName = app.getPackageName();
                long id = app.getId();
                if (app.getAppcoins() != null) {
                    $jacocoInit[13] = true;
                    z = true;
                } else {
                    $jacocoInit[14] = true;
                    z = false;
                }
                $jacocoInit[15] = true;
                AppCoinsCampaignInfo appcoins = app.getAppcoins();
                $jacocoInit[16] = true;
                ClickUrls clicks = appcoins.getClicks();
                $jacocoInit[17] = true;
                String click = clicks.getClick();
                AppCoinsCampaignInfo appcoins2 = app.getAppcoins();
                $jacocoInit[18] = true;
                ClickUrls clicks2 = appcoins2.getClicks();
                $jacocoInit[19] = true;
                RewardApp rewardApp = new RewardApp(name, icon, avg, pdownloads, packageName, id, tag, z, click, clicks2.getDownload(), Float.parseFloat(campaign.getReward()));
                $jacocoInit[20] = true;
                rewardAppsList.add(rewardApp);
                $jacocoInit[21] = true;
            }
            $jacocoInit[22] = true;
        }
        C0120S<List<RewardApp>> c = C0120S.m652c(rewardAppsList);
        $jacocoInit[23] = true;
        return c;
    }
}
