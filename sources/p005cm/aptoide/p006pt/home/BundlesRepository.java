package p005cm.aptoide.p006pt.home;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0117M;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0131o;

/* renamed from: cm.aptoide.pt.home.BundlesRepository */
public class BundlesRepository {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final String HOME_BUNDLE_KEY = "Home_Bundle";
    private Map<String, List<HomeBundle>> cachedBundles;
    private int limit;
    private Map<String, Integer> offset;
    private final BundleDataSource remoteBundleDataSource;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-221310704453392828L, "cm/aptoide/pt/home/BundlesRepository", 54);
        $jacocoData = probes;
        return probes;
    }

    public BundlesRepository(BundleDataSource remoteBundleDataSource2, Map<String, List<HomeBundle>> cachedBundles2, Map<String, Integer> offset2, int limit2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.remoteBundleDataSource = remoteBundleDataSource2;
        this.cachedBundles = cachedBundles2;
        this.offset = offset2;
        this.limit = limit2;
        $jacocoInit[0] = true;
    }

    public Single<HomeBundlesModel> loadHomeBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Map<String, List<HomeBundle>> map = this.cachedBundles;
        String str = HOME_BUNDLE_KEY;
        if (!map.containsKey(str)) {
            $jacocoInit[1] = true;
            Single<HomeBundlesModel> loadNextHomeBundles = loadNextHomeBundles();
            $jacocoInit[2] = true;
            return loadNextHomeBundles;
        }
        Map<String, List<HomeBundle>> map2 = this.cachedBundles;
        $jacocoInit[3] = true;
        List list = (List) map2.put(str, new ArrayList((Collection) map2.get(str)));
        $jacocoInit[4] = true;
        HomeBundlesModel homeBundlesModel = new HomeBundlesModel(list, false, getOffset(str));
        $jacocoInit[5] = true;
        Single<HomeBundlesModel> a = Single.m734a(homeBundlesModel);
        $jacocoInit[6] = true;
        return a;
    }

    public Single<HomeBundlesModel> loadFreshHomeBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshHomeBundles = this.remoteBundleDataSource.loadFreshHomeBundles(HOME_BUNDLE_KEY);
        C3903o oVar = new C3903o(this);
        $jacocoInit[7] = true;
        Single b = loadFreshHomeBundles.mo3695b((C0129b<? super T>) oVar);
        C3885l lVar = new C3885l(this);
        $jacocoInit[8] = true;
        Single<HomeBundlesModel> d = b.mo3698d(lVar);
        $jacocoInit[9] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14237a(HomeBundlesModel homeBundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        updateCache(homeBundlesModel, true, HOME_BUNDLE_KEY);
        $jacocoInit[53] = true;
    }

    /* access modifiers changed from: private */
    public HomeBundlesModel cloneList(HomeBundlesModel homeBundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        if (homeBundlesModel.hasErrors()) {
            $jacocoInit[10] = true;
        } else if (homeBundlesModel.isLoading()) {
            $jacocoInit[11] = true;
        } else {
            ArrayList arrayList = new ArrayList(homeBundlesModel.getList());
            $jacocoInit[13] = true;
            HomeBundlesModel homeBundlesModel2 = new HomeBundlesModel(arrayList, homeBundlesModel.isLoading(), homeBundlesModel.getOffset());
            $jacocoInit[14] = true;
            return homeBundlesModel2;
        }
        $jacocoInit[12] = true;
        return homeBundlesModel;
    }

    public Single<HomeBundlesModel> loadNextHomeBundles() {
        boolean[] $jacocoInit = $jacocoInit();
        BundleDataSource bundleDataSource = this.remoteBundleDataSource;
        String str = HOME_BUNDLE_KEY;
        Single loadNextHomeBundles = bundleDataSource.loadNextHomeBundles(getOffset(str), this.limit, str);
        C3873j jVar = new C3873j(this);
        $jacocoInit[15] = true;
        Single b = loadNextHomeBundles.mo3695b((C0129b<? super T>) jVar);
        C3885l lVar = new C3885l(this);
        $jacocoInit[16] = true;
        Single<HomeBundlesModel> d = b.mo3698d(lVar);
        $jacocoInit[17] = true;
        return d;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14239b(HomeBundlesModel homeBundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        updateCache(homeBundlesModel, false, HOME_BUNDLE_KEY);
        $jacocoInit[52] = true;
    }

    private void updateCache(HomeBundlesModel homeBundles, boolean cacheIsDirty, String bundleKey) {
        boolean[] $jacocoInit = $jacocoInit();
        if (homeBundles.hasErrors()) {
            $jacocoInit[18] = true;
        } else if (homeBundles.isLoading()) {
            $jacocoInit[19] = true;
        } else {
            $jacocoInit[20] = true;
            this.offset.put(bundleKey, Integer.valueOf(homeBundles.getOffset()));
            $jacocoInit[21] = true;
            if (cacheIsDirty) {
                $jacocoInit[22] = true;
            } else if (!this.cachedBundles.containsKey(bundleKey)) {
                $jacocoInit[23] = true;
            } else {
                List<HomeBundle> homeBundleList = (List) this.cachedBundles.get(bundleKey);
                $jacocoInit[25] = true;
                homeBundleList.addAll(homeBundles.getList());
                $jacocoInit[26] = true;
                this.cachedBundles.put(bundleKey, homeBundleList);
                $jacocoInit[27] = true;
            }
            this.cachedBundles.put(bundleKey, new ArrayList(homeBundles.getList()));
            $jacocoInit[24] = true;
        }
        $jacocoInit[28] = true;
    }

    public boolean hasMore() {
        boolean[] $jacocoInit = $jacocoInit();
        BundleDataSource bundleDataSource = this.remoteBundleDataSource;
        String str = HOME_BUNDLE_KEY;
        boolean hasMore = bundleDataSource.hasMore(Integer.valueOf(getOffset(str)), str);
        $jacocoInit[29] = true;
        return hasMore;
    }

    public boolean hasMore(String title) {
        boolean[] $jacocoInit = $jacocoInit();
        boolean hasMore = this.remoteBundleDataSource.hasMore(Integer.valueOf(getOffset(title)), title);
        $jacocoInit[30] = true;
        return hasMore;
    }

    public Single<HomeBundlesModel> loadBundles(String title, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.cachedBundles.containsKey(title)) {
            $jacocoInit[31] = true;
            Single<HomeBundlesModel> loadNextBundles = loadNextBundles(title, url);
            $jacocoInit[32] = true;
            return loadNextBundles;
        }
        Map<String, List<HomeBundle>> map = this.cachedBundles;
        $jacocoInit[33] = true;
        List list = (List) map.put(title, new ArrayList((Collection) map.get(title)));
        $jacocoInit[34] = true;
        HomeBundlesModel homeBundlesModel = new HomeBundlesModel(list, false, getOffset(title));
        $jacocoInit[35] = true;
        Single<HomeBundlesModel> a = Single.m734a(homeBundlesModel);
        $jacocoInit[36] = true;
        return a;
    }

    public Single<HomeBundlesModel> loadNextBundles(String title, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadNextBundleForEvent = this.remoteBundleDataSource.loadNextBundleForEvent(url, getOffset(title), title, this.limit);
        C3897n nVar = new C3897n(this, title);
        $jacocoInit[37] = true;
        Single b = loadNextBundleForEvent.mo3695b((C0129b<? super T>) nVar);
        C3885l lVar = new C3885l(this);
        $jacocoInit[38] = true;
        Single<HomeBundlesModel> d = b.mo3698d(lVar);
        $jacocoInit[39] = true;
        return d;
    }

    /* renamed from: b */
    public /* synthetic */ void mo14240b(String title, HomeBundlesModel homeBundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        updateCache(homeBundlesModel, false, title);
        $jacocoInit[51] = true;
    }

    public Single<HomeBundlesModel> loadFreshBundles(String title, String url) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshBundleForEvent = this.remoteBundleDataSource.loadFreshBundleForEvent(url, title);
        C3879k kVar = new C3879k(this, title);
        $jacocoInit[40] = true;
        Single b = loadFreshBundleForEvent.mo3695b((C0129b<? super T>) kVar);
        C3885l lVar = new C3885l(this);
        $jacocoInit[41] = true;
        Single<HomeBundlesModel> d = b.mo3698d(lVar);
        $jacocoInit[42] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo14238a(String title, HomeBundlesModel homeBundlesModel) {
        boolean[] $jacocoInit = $jacocoInit();
        updateCache(homeBundlesModel, true, title);
        $jacocoInit[50] = true;
    }

    private int getOffset(String bundleKey) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.offset.containsKey(bundleKey)) {
            $jacocoInit[43] = true;
            return 0;
        }
        int intValue = ((Integer) this.offset.get(bundleKey)).intValue();
        $jacocoInit[44] = true;
        return intValue;
    }

    public C0117M remove(HomeBundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C3891m<Object>(this, bundle));
        $jacocoInit[45] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo14236a(HomeBundle bundle) {
        boolean[] $jacocoInit = $jacocoInit();
        List list = (List) this.cachedBundles.get(HOME_BUNDLE_KEY);
        $jacocoInit[47] = true;
        list.remove(bundle);
        $jacocoInit[48] = true;
        C0117M b = C0117M.m590b();
        $jacocoInit[49] = true;
        return b;
    }

    public void updateCache(List<HomeBundle> homeBundles) {
        boolean[] $jacocoInit = $jacocoInit();
        this.cachedBundles.put(HOME_BUNDLE_KEY, homeBundles);
        $jacocoInit[46] = true;
    }
}
