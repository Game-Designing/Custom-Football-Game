package p005cm.aptoide.p006pt.home;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.home.HomeBundle.BundleType;
import p005cm.aptoide.p006pt.view.app.Application;
import p005cm.aptoide.p006pt.view.app.FeatureGraphicApplication;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.home.FakeBundleDataSource */
public class FakeBundleDataSource implements BundleDataSource {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6046659453768141730L, "cm/aptoide/pt/home/FakeBundleDataSource", 42);
        $jacocoData = probes;
        return probes;
    }

    public FakeBundleDataSource() {
        $jacocoInit()[0] = true;
    }

    public Single<HomeBundlesModel> loadFreshHomeBundles(String key) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> homeBundles = getHomeBundles();
        $jacocoInit[1] = true;
        return homeBundles;
    }

    public Single<HomeBundlesModel> loadNextHomeBundles(int offset, int limit, String key) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> loadFreshHomeBundles = loadFreshHomeBundles(key);
        $jacocoInit[2] = true;
        return loadFreshHomeBundles;
    }

    public boolean hasMore(Integer offset, String title) {
        $jacocoInit()[3] = true;
        return true;
    }

    public Single<HomeBundlesModel> loadFreshBundleForEvent(String url, String key) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> homeBundles = getHomeBundles();
        $jacocoInit[4] = true;
        return homeBundles;
    }

    public Single<HomeBundlesModel> loadNextBundleForEvent(String url, int offset, String key, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> homeBundles = getHomeBundles();
        $jacocoInit[5] = true;
        return homeBundles;
    }

    private Single<HomeBundlesModel> getHomeBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<HomeBundlesModel> a = Single.m734a(new HomeBundlesModel(getFakeBundles(), false, 0));
        $jacocoInit[6] = true;
        return a;
    }

    public List<HomeBundle> getFakeBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        ArrayList arrayList = new ArrayList();
        String icon = "https://placeimg.com/640/480/any";
        $jacocoInit[7] = true;
        String str = icon;
        Application application = new Application(BuildConfig.MARKET_NAME, str, 0.0f, 1000, "cm.aptoide.pt", 300, "", false);
        $jacocoInit[8] = true;
        Application aptoide = application;
        arrayList.add(aptoide);
        $jacocoInit[9] = true;
        Application application2 = new Application("Facebook", str, 4.2f, 1000, "katana.facebook.com", 30, "", false);
        $jacocoInit[10] = true;
        arrayList.add(application2);
        $jacocoInit[11] = true;
        arrayList.add(aptoide);
        $jacocoInit[12] = true;
        arrayList.add(application2);
        $jacocoInit[13] = true;
        arrayList.add(aptoide);
        $jacocoInit[14] = true;
        arrayList.add(application2);
        $jacocoInit[15] = true;
        arrayList.add(aptoide);
        $jacocoInit[16] = true;
        arrayList.add(application2);
        $jacocoInit[17] = true;
        ArrayList arrayList2 = new ArrayList();
        $jacocoInit[18] = true;
        String str2 = icon;
        ArrayList arrayList3 = arrayList2;
        Application application3 = application2;
        Application application4 = aptoide;
        FeatureGraphicApplication featureGraphicApplication = new FeatureGraphicApplication(BuildConfig.MARKET_NAME, str, 0.0f, 1000, "cm.aptoide.pt", 300, str2, "", false, false);
        $jacocoInit[19] = true;
        FeatureGraphicApplication aptoideFeatureGraphic = featureGraphicApplication;
        arrayList.add(aptoideFeatureGraphic);
        $jacocoInit[20] = true;
        FeatureGraphicApplication aptoideFeatureGraphic2 = aptoideFeatureGraphic;
        FeatureGraphicApplication featureGraphicApplication2 = new FeatureGraphicApplication("Facebook", str, 4.2f, 1000, "katana.facebook.com", 30, str2, "", false, false);
        $jacocoInit[21] = true;
        FeatureGraphicApplication facebookFeatureGraphic = featureGraphicApplication2;
        ArrayList arrayList4 = arrayList3;
        arrayList4.add(facebookFeatureGraphic);
        $jacocoInit[22] = true;
        FeatureGraphicApplication aptoideFeatureGraphic3 = aptoideFeatureGraphic2;
        arrayList4.add(aptoideFeatureGraphic3);
        $jacocoInit[23] = true;
        arrayList4.add(facebookFeatureGraphic);
        $jacocoInit[24] = true;
        arrayList4.add(aptoideFeatureGraphic3);
        $jacocoInit[25] = true;
        arrayList4.add(facebookFeatureGraphic);
        $jacocoInit[26] = true;
        arrayList4.add(aptoideFeatureGraphic3);
        $jacocoInit[27] = true;
        arrayList4.add(facebookFeatureGraphic);
        $jacocoInit[28] = true;
        arrayList4.add(aptoideFeatureGraphic3);
        $jacocoInit[29] = true;
        arrayList4.add(facebookFeatureGraphic);
        $jacocoInit[30] = true;
        AppBundle appBundle = new AppBundle("As escolhas do filipe", arrayList4, BundleType.EDITORS, null, "");
        $jacocoInit[31] = true;
        AppBundle appBundle2 = appBundle;
        ArrayList arrayList5 = arrayList;
        AppBundle appBundle22 = new AppBundle("piores apps locais", arrayList5, BundleType.APPS, null, "");
        $jacocoInit[32] = true;
        AppBundle appBundle3 = new AppBundle("um pouco melhor apps", arrayList5, BundleType.APPS, null, "");
        $jacocoInit[33] = true;
        AppBundle appBundle23 = appBundle3;
        List<HomeBundle> appBundles = new ArrayList<>();
        $jacocoInit[34] = true;
        appBundles.add(appBundle2);
        $jacocoInit[35] = true;
        appBundles.add(appBundle22);
        $jacocoInit[36] = true;
        appBundles.add(appBundle23);
        $jacocoInit[37] = true;
        String str3 = "";
        AdBundle adBundle = new AdBundle("Highlighted", new AdsTagWrapper(Collections.emptyList(), str3), null, str3);
        $jacocoInit[38] = true;
        appBundles.add(adBundle);
        $jacocoInit[39] = true;
        List<Application> apps = new ArrayList<>();
        $jacocoInit[40] = true;
        Application application5 = new Application("asf wallet", "http://pool.img.aptoide.com/asf-store/ace60f6352f6dd9289843b5b0b2ab3d4_icon.png", 5.0f, 1000000, "asf.wallet.android.com", 36057221, "", false);
        apps.add(application5);
        $jacocoInit[41] = true;
        return appBundles;
    }
}
