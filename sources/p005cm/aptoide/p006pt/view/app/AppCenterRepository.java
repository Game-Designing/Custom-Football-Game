package p005cm.aptoide.p006pt.view.app;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.view.app.AppCenterRepository */
public class AppCenterRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AppService appService;
    private final Map<Long, SimpleEntry<Integer, List<Application>>> cachedStoreApplications;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5954474172957723546L, "cm/aptoide/pt/view/app/AppCenterRepository", 76);
        $jacocoData = probes;
        return probes;
    }

    public AppCenterRepository(AppService appService2, Map<Long, SimpleEntry<Integer, List<Application>>> cachedStoreApplications2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appService = appService2;
        this.cachedStoreApplications = cachedStoreApplications2;
        $jacocoInit[0] = true;
    }

    public Single<AppsList> loadNextApps(long storeId, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<Long, SimpleEntry<Integer, List<Application>>> map = this.cachedStoreApplications;
        $jacocoInit[1] = true;
        SimpleEntry<Integer, List<Application>> cache = (SimpleEntry) map.get(Long.valueOf(storeId));
        int offset = 0;
        if (cache == null) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            offset = ((Integer) cache.getKey()).intValue();
            $jacocoInit[4] = true;
        }
        Single loadApps = this.appService.loadApps(storeId, offset, limit);
        C5278k kVar = new C5278k(this, storeId);
        $jacocoInit[5] = true;
        Single b = loadApps.mo3695b((C0129b<? super T>) kVar);
        C5270g gVar = new C5270g(this);
        $jacocoInit[6] = true;
        Single<AppsList> d = b.mo3698d(gVar);
        $jacocoInit[7] = true;
        return d;
    }

    /* renamed from: b */
    public /* synthetic */ void mo16933b(long storeId, AppsList applications) {
        boolean[] $jacocoInit = $jacocoInit();
        updateCache(storeId, applications, false);
        $jacocoInit[75] = true;
    }

    /* renamed from: b */
    public /* synthetic */ AppsList mo16932b(AppsList appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsList cloneList = cloneList(appsList);
        $jacocoInit[74] = true;
        return cloneList;
    }

    public Single<AppsList> loadFreshApps(long storeId, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadFreshApps = this.appService.loadFreshApps(storeId, limit);
        C5276j jVar = new C5276j(this, storeId);
        $jacocoInit[8] = true;
        Single b = loadFreshApps.mo3695b((C0129b<? super T>) jVar);
        C5260b bVar = new C5260b(this);
        $jacocoInit[9] = true;
        Single<AppsList> d = b.mo3698d(bVar);
        $jacocoInit[10] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ void mo16931a(long storeId, AppsList applications) {
        boolean[] $jacocoInit = $jacocoInit();
        updateCache(storeId, applications, true);
        $jacocoInit[73] = true;
    }

    /* renamed from: a */
    public /* synthetic */ AppsList mo16930a(AppsList appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsList cloneList = cloneList(appsList);
        $jacocoInit[72] = true;
        return cloneList;
    }

    private AppsList cloneList(AppsList appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        if (appsList.hasErrors()) {
            $jacocoInit[11] = true;
        } else if (appsList.isLoading()) {
            $jacocoInit[12] = true;
        } else {
            ArrayList arrayList = new ArrayList(appsList.getList());
            boolean isLoading = appsList.isLoading();
            $jacocoInit[14] = true;
            AppsList appsList2 = new AppsList(arrayList, isLoading, appsList.getOffset());
            $jacocoInit[15] = true;
            return appsList2;
        }
        $jacocoInit[13] = true;
        return appsList;
    }

    private void updateCache(long storeId, AppsList applications, boolean isFresh) {
        boolean[] $jacocoInit = $jacocoInit();
        if (applications.hasErrors()) {
            $jacocoInit[16] = true;
        } else if (applications.isLoading()) {
            $jacocoInit[17] = true;
        } else {
            Map<Long, SimpleEntry<Integer, List<Application>>> map = this.cachedStoreApplications;
            $jacocoInit[18] = true;
            SimpleEntry<Integer, List<Application>> cache = (SimpleEntry) map.get(Long.valueOf(storeId));
            if (cache == null) {
                $jacocoInit[19] = true;
            } else if (isFresh) {
                $jacocoInit[20] = true;
            } else {
                List<Application> list = (List) cache.getValue();
                $jacocoInit[24] = true;
                list.addAll(applications.getList());
                $jacocoInit[25] = true;
                Map<Long, SimpleEntry<Integer, List<Application>>> map2 = this.cachedStoreApplications;
                Long valueOf = Long.valueOf(storeId);
                $jacocoInit[26] = true;
                SimpleEntry simpleEntry = new SimpleEntry(Integer.valueOf(applications.getOffset()), list);
                $jacocoInit[27] = true;
                map2.put(valueOf, simpleEntry);
                $jacocoInit[28] = true;
            }
            Map<Long, SimpleEntry<Integer, List<Application>>> map3 = this.cachedStoreApplications;
            Long valueOf2 = Long.valueOf(storeId);
            $jacocoInit[21] = true;
            SimpleEntry simpleEntry2 = new SimpleEntry(Integer.valueOf(applications.getOffset()), applications.getList());
            $jacocoInit[22] = true;
            map3.put(valueOf2, simpleEntry2);
            $jacocoInit[23] = true;
        }
        $jacocoInit[29] = true;
    }

    public Single<AppsList> getApplications(long storeId, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        Map<Long, SimpleEntry<Integer, List<Application>>> map = this.cachedStoreApplications;
        $jacocoInit[30] = true;
        SimpleEntry<Integer, List<Application>> cache = (SimpleEntry) map.get(Long.valueOf(storeId));
        $jacocoInit[31] = true;
        if (cache == null) {
            $jacocoInit[32] = true;
        } else {
            List list = (List) cache.getValue();
            $jacocoInit[33] = true;
            if (list.isEmpty()) {
                $jacocoInit[34] = true;
            } else {
                $jacocoInit[36] = true;
                List list2 = (List) cache.getValue();
                $jacocoInit[37] = true;
                int appsLeft = limit - (list2.size() % limit);
                if (appsLeft == 0) {
                    $jacocoInit[38] = true;
                    Single<AppsList> a = Single.m734a(new AppsList(new ArrayList((Collection) cache.getValue()), false, ((Integer) cache.getKey()).intValue()));
                    $jacocoInit[39] = true;
                    return a;
                }
                Single<AppsList> d = loadNextApps(storeId, appsLeft).mo3698d(new C5266e(cache));
                $jacocoInit[40] = true;
                return d;
            }
        }
        Single<AppsList> loadNextApps = loadNextApps(storeId, limit);
        $jacocoInit[35] = true;
        return loadNextApps;
    }

    /* renamed from: a */
    static /* synthetic */ AppsList m9518a(SimpleEntry cache, AppsList appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsList appsList2 = new AppsList(new ArrayList((Collection) cache.getValue()), false, ((Integer) cache.getKey()).intValue());
        $jacocoInit[71] = true;
        return appsList2;
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(long appId, String storeName, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<DetailedAppRequestResult> loadDetailedApp = this.appService.loadDetailedApp(appId, storeName, packageName);
        $jacocoInit[41] = true;
        return loadDetailedApp;
    }

    public Single<DetailedAppRequestResult> loadDetailedApp(String packageName, String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<DetailedAppRequestResult> loadDetailedApp = this.appService.loadDetailedApp(packageName, storeName);
        $jacocoInit[42] = true;
        return loadDetailedApp;
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromMd5(String md5) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<DetailedAppRequestResult> loadDetailedAppFromMd5 = this.appService.loadDetailedAppFromMd5(md5);
        $jacocoInit[43] = true;
        return loadDetailedAppFromMd5;
    }

    public Single<DetailedAppRequestResult> loadDetailedAppFromUniqueName(String uniqueName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<DetailedAppRequestResult> loadDetailedAppFromUniqueName = this.appService.loadDetailedAppFromUniqueName(uniqueName);
        $jacocoInit[44] = true;
        return loadDetailedAppFromUniqueName;
    }

    public Single<AppsList> loadRecommendedApps(int limit, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadRecommendedApps = this.appService.loadRecommendedApps(limit, packageName);
        C5268f fVar = new C5268f(packageName);
        $jacocoInit[45] = true;
        C0120S c = loadRecommendedApps.mo3697c(fVar);
        $jacocoInit[46] = true;
        Single<AppsList> n = c.mo3678n();
        $jacocoInit[47] = true;
        return n;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m9523b(String packageName, AppsList appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(appsList);
        C5258a aVar = C5258a.f9035a;
        $jacocoInit[61] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) aVar);
        C5262c cVar = new C5262c(packageName);
        $jacocoInit[62] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) cVar);
        $jacocoInit[63] = true;
        C0120S m = d.mo3675m();
        C5274i iVar = new C5274i(appsList);
        $jacocoInit[64] = true;
        C0120S j = m.mo3669j(iVar);
        $jacocoInit[65] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m9519a(String packageName, Application application) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String packageName2 = application.getPackageName();
        $jacocoInit[67] = true;
        if (!packageName2.equals(packageName)) {
            $jacocoInit[68] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[69] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[70] = true;
        return valueOf;
    }

    /* renamed from: a */
    static /* synthetic */ AppsList m9517a(AppsList appsList, List apps) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsList appsList2 = new AppsList(apps, appsList.isLoading(), appsList.getOffset());
        $jacocoInit[66] = true;
        return appsList2;
    }

    public Single<AppsList> loadAppcRecommendedApps(int limit, String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single loadAppcRecommendedApps = this.appService.loadAppcRecommendedApps(limit, packageName);
        C5264d dVar = new C5264d(packageName);
        $jacocoInit[48] = true;
        C0120S c = loadAppcRecommendedApps.mo3697c(dVar);
        $jacocoInit[49] = true;
        Single<AppsList> n = c.mo3678n();
        $jacocoInit[50] = true;
        return n;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m9520a(String packageName, AppsList appsList) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = C0120S.m652c(appsList);
        C5258a aVar = C5258a.f9035a;
        $jacocoInit[51] = true;
        C0120S h = c.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) aVar);
        C5272h hVar = new C5272h(packageName);
        $jacocoInit[52] = true;
        C0120S d = h.mo3653d((C0132p<? super T, Boolean>) hVar);
        $jacocoInit[53] = true;
        C0120S m = d.mo3675m();
        C5280l lVar = new C5280l(appsList);
        $jacocoInit[54] = true;
        C0120S j = m.mo3669j(lVar);
        $jacocoInit[55] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m9522b(String packageName, Application application) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        String packageName2 = application.getPackageName();
        $jacocoInit[57] = true;
        if (!packageName2.equals(packageName)) {
            $jacocoInit[58] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[59] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[60] = true;
        return valueOf;
    }

    /* renamed from: b */
    static /* synthetic */ AppsList m9521b(AppsList appsList, List apps) {
        boolean[] $jacocoInit = $jacocoInit();
        AppsList appsList2 = new AppsList(apps, appsList.isLoading(), appsList.getOffset());
        $jacocoInit[56] = true;
        return appsList2;
    }
}
