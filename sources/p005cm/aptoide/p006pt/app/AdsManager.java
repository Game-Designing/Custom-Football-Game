package p005cm.aptoide.p006pt.app;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.ads.AdsRepository;
import p005cm.aptoide.p006pt.ads.MinimalAdMapper;
import p005cm.aptoide.p006pt.database.accessors.StoredMinimalAdAccessor;
import p005cm.aptoide.p006pt.database.realm.MinimalAd;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;
import p005cm.aptoide.p006pt.search.model.SearchAdResult;
import p005cm.aptoide.p006pt.view.app.AppsList.Error;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.app.AdsManager */
public class AdsManager {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final MinimalAdMapper adMapper;
    private final AdsRepository adsRepository;
    private final StoredMinimalAdAccessor storedMinimalAdAccessor;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8205928988796498778L, "cm/aptoide/pt/app/AdsManager", 14);
        $jacocoData = probes;
        return probes;
    }

    public AdsManager(AdsRepository adsRepository2, StoredMinimalAdAccessor storedMinimalAdAccessor2, MinimalAdMapper adMapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.adsRepository = adsRepository2;
        this.storedMinimalAdAccessor = storedMinimalAdAccessor2;
        this.adMapper = adMapper2;
        $jacocoInit[0] = true;
    }

    public Single<MinimalAd> loadAds(String packageName, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadAdsFromAppView = this.adsRepository.loadAdsFromAppView(packageName, storeName);
        $jacocoInit[1] = true;
        Single<MinimalAd> n = loadAdsFromAppView.mo3678n();
        $jacocoInit[2] = true;
        return n;
    }

    public Single<MinimalAdRequestResult> loadAd(String packageName, List<String> keyWords) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S loadAdsFromAppviewSuggested = this.adsRepository.loadAdsFromAppviewSuggested(packageName, keyWords);
        C1720a aVar = C1720a.f4690a;
        $jacocoInit[3] = true;
        C0120S f = loadAdsFromAppviewSuggested.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) aVar);
        $jacocoInit[4] = true;
        Single n = f.mo3678n();
        C1722b bVar = new C1722b(this);
        $jacocoInit[5] = true;
        Single<MinimalAdRequestResult> f2 = n.mo3700f(bVar);
        $jacocoInit[6] = true;
        return f2;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m6420a(List minimalAds) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(new MinimalAdRequestResult((MinimalAd) minimalAds.get(0)));
        $jacocoInit[13] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ MinimalAdRequestResult mo10075a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        MinimalAdRequestResult createMinimalAdRequestResultError = createMinimalAdRequestResultError(throwable);
        $jacocoInit[12] = true;
        return createMinimalAdRequestResultError;
    }

    private MinimalAdRequestResult createMinimalAdRequestResultError(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        if (throwable instanceof NoNetworkConnectionException) {
            $jacocoInit[7] = true;
            MinimalAdRequestResult minimalAdRequestResult = new MinimalAdRequestResult(Error.NETWORK);
            $jacocoInit[8] = true;
            return minimalAdRequestResult;
        }
        MinimalAdRequestResult minimalAdRequestResult2 = new MinimalAdRequestResult(Error.GENERIC);
        $jacocoInit[9] = true;
        return minimalAdRequestResult2;
    }

    public void handleAdsLogic(SearchAdResult searchAdResult) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storedMinimalAdAccessor.insert(this.adMapper.map(searchAdResult, null));
        $jacocoInit[10] = true;
        AdNetworkUtils.knockCpc(this.adMapper.map(searchAdResult));
        $jacocoInit[11] = true;
    }
}
