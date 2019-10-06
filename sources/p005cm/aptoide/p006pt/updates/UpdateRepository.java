package p005cm.aptoide.p006pt.updates;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.accessors.UpdateAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Malware.Rank;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Obb.ObbItem;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.File;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.listapp.ListAppsUpdates;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppcAppsUpgradesRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.listapps.ListAppsUpdatesRequest;
import p005cm.aptoide.p006pt.logger.Logger;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0128a;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.updates.UpdateRepository */
public class UpdateRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = UpdateRepository.class.getName();
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final IdsRepository idsRepository;
    private final PackageManager packageManager;
    private final SharedPreferences sharedPreferences;
    private final StoreAccessor storeAccessor;
    private final TokenInvalidator tokenInvalidator;
    private final UpdateAccessor updateAccessor;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8678948234224467174L, "cm/aptoide/pt/updates/UpdateRepository", Opcodes.D2F);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[143] = true;
    }

    public UpdateRepository(UpdateAccessor updateAccessor2, StoreAccessor storeAccessor2, IdsRepository idsRepository2, BodyInterceptor<BaseBody> bodyInterceptor2, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, PackageManager packageManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateAccessor = updateAccessor2;
        this.storeAccessor = storeAccessor2;
        this.idsRepository = idsRepository2;
        this.bodyInterceptor = bodyInterceptor2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.packageManager = packageManager2;
        $jacocoInit[0] = true;
    }

    public C0117M sync(boolean bypassCache, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = this.storeAccessor.getAll();
        $jacocoInit[1] = true;
        C0120S d = all.mo3647d();
        $jacocoInit[2] = true;
        C0120S a = d.mo3616a(Schedulers.m776io());
        C5131c cVar = C5131c.f8868a;
        $jacocoInit[3] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) cVar);
        C5137i iVar = new C5137i(this, bypassCache, bypassServerCache);
        $jacocoInit[4] = true;
        C0120S f2 = f.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) iVar);
        $jacocoInit[5] = true;
        Single n = f2.mo3678n();
        C5145q qVar = new C5145q(this);
        $jacocoInit[6] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) qVar);
        $jacocoInit[7] = true;
        C0117M a2 = b.mo3580a(saveAppcUpgrades(bypassCache, bypassServerCache));
        $jacocoInit[8] = true;
        return a2;
    }

    /* renamed from: h */
    static /* synthetic */ C0120S m515h(List stores) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) stores);
        C5133e eVar = C5133e.f8870a;
        $jacocoInit[139] = true;
        C0120S j = a.mo3669j(eVar);
        $jacocoInit[140] = true;
        C0120S m = j.mo3675m();
        $jacocoInit[141] = true;
        return m;
    }

    /* renamed from: a */
    static /* synthetic */ Long m508a(Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        Long valueOf = Long.valueOf(store.getStoreId());
        $jacocoInit[142] = true;
        return valueOf;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo2368a(boolean bypassCache, boolean bypassServerCache, List storeIds) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S networkUpdates = getNetworkUpdates(storeIds, bypassCache, bypassServerCache);
        $jacocoInit[138] = true;
        return networkUpdates;
    }

    /* renamed from: i */
    public /* synthetic */ C0117M mo2384i(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = removeAllNonExcluded().mo3580a(saveNewUpdates(updates));
        $jacocoInit[137] = true;
        return a;
    }

    private C0117M saveAppcUpgrades(boolean bypassCache, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        Single n = getNetworkAppcUpgrades(bypassCache, bypassServerCache).mo3678n();
        C5141m mVar = new C5141m(this);
        $jacocoInit[9] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) mVar);
        $jacocoInit[10] = true;
        return b;
    }

    /* renamed from: e */
    public /* synthetic */ C0117M mo2377e(List upgrades) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M saveNewUpgrades = saveNewUpgrades(upgrades);
        $jacocoInit[136] = true;
        return saveNewUpgrades;
    }

    private C0120S<List<App>> getNetworkAppcUpgrades(boolean bypassCache, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        ListAppcAppsUpgradesRequest of = ListAppcAppsUpgradesRequest.m7560of(this.idsRepository.getUniqueIdentifier(), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.packageManager);
        $jacocoInit[11] = true;
        C0120S observe = of.observe(bypassCache, bypassServerCache);
        C5150v vVar = C5150v.f8890a;
        $jacocoInit[12] = true;
        C0120S<List<App>> j = observe.mo3669j(vVar);
        $jacocoInit[13] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ List m509a(ListAppsUpdates result) {
        boolean[] $jacocoInit = $jacocoInit();
        if (result == null) {
            $jacocoInit[131] = true;
        } else if (!result.isOk()) {
            $jacocoInit[132] = true;
        } else {
            $jacocoInit[133] = true;
            List list = result.getList();
            $jacocoInit[134] = true;
            return list;
        }
        List emptyList = Collections.emptyList();
        $jacocoInit[135] = true;
        return emptyList;
    }

    private C0120S<List<App>> getNetworkUpdates(List<Long> storeIds, boolean bypassCache, boolean bypassServerCache) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[14] = true;
        instance.mo2136d(str, String.format("getNetworkUpdates() -> using %d stores", new Object[]{Integer.valueOf(storeIds.size())}));
        $jacocoInit[15] = true;
        ListAppsUpdatesRequest of = ListAppsUpdatesRequest.m7568of(storeIds, this.idsRepository.getUniqueIdentifier(), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.packageManager);
        $jacocoInit[16] = true;
        C0120S observe = of.observe(bypassCache, bypassServerCache);
        C5132d dVar = C5132d.f8869a;
        $jacocoInit[17] = true;
        C0120S<List<App>> j = observe.mo3669j(dVar);
        $jacocoInit[18] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ List m513b(ListAppsUpdates result) {
        boolean[] $jacocoInit = $jacocoInit();
        if (result == null) {
            $jacocoInit[126] = true;
        } else if (!result.isOk()) {
            $jacocoInit[127] = true;
        } else {
            $jacocoInit[128] = true;
            List list = result.getList();
            $jacocoInit[129] = true;
            return list;
        }
        List emptyList = Collections.emptyList();
        $jacocoInit[130] = true;
        return emptyList;
    }

    public C0117M removeAllNonExcluded() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = this.updateAccessor.getAll(false);
        $jacocoInit[19] = true;
        C0120S d = all.mo3647d();
        $jacocoInit[20] = true;
        Single n = d.mo3678n();
        C5138j jVar = new C5138j(this);
        $jacocoInit[21] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) jVar);
        $jacocoInit[22] = true;
        return b;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo2376d(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeAll = removeAll(updates);
        $jacocoInit[125] = true;
        return removeAll;
    }

    private C0117M saveNewUpdates(List<App> updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) updates);
        C5136h hVar = new C5136h(this);
        $jacocoInit[23] = true;
        C0120S j = a.mo3669j(hVar);
        $jacocoInit[24] = true;
        C0120S m = j.mo3675m();
        $jacocoInit[25] = true;
        Single n = m.mo3678n();
        C5134f fVar = new C5134f(this);
        $jacocoInit[26] = true;
        Single a2 = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) fVar);
        $jacocoInit[27] = true;
        C0117M b = C0117M.m593b(a2);
        $jacocoInit[28] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Update mo2366a(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        Update mapAppUpdate = mapAppUpdate(app, false);
        $jacocoInit[124] = true;
        return mapAppUpdate;
    }

    /* renamed from: f */
    public /* synthetic */ Single mo2379f(List updateList) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[120] = true;
        Object[] objArr = {Integer.valueOf(updateList.size())};
        $jacocoInit[121] = true;
        instance.mo2136d(str, String.format("filter %d updates for non excluded and save the remainder", objArr));
        $jacocoInit[122] = true;
        Single saveNonExcludedUpdates = saveNonExcludedUpdates(updateList);
        $jacocoInit[123] = true;
        return saveNonExcludedUpdates;
    }

    private C0117M saveNewUpgrades(List<App> upgrades) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) upgrades);
        C5135g gVar = new C5135g(this);
        $jacocoInit[29] = true;
        C0120S j = a.mo3669j(gVar);
        $jacocoInit[30] = true;
        C0120S m = j.mo3675m();
        $jacocoInit[31] = true;
        Single n = m.mo3678n();
        C5140l lVar = new C5140l(this);
        $jacocoInit[32] = true;
        Single a2 = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) lVar);
        $jacocoInit[33] = true;
        C0117M b = C0117M.m593b(a2);
        $jacocoInit[34] = true;
        return b;
    }

    /* renamed from: b */
    public /* synthetic */ Update mo2370b(App app) {
        boolean[] $jacocoInit = $jacocoInit();
        Update mapAppUpdate = mapAppUpdate(app, true);
        $jacocoInit[119] = true;
        return mapAppUpdate;
    }

    /* renamed from: g */
    public /* synthetic */ Single mo2380g(List updateList) {
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        String str = TAG;
        $jacocoInit[115] = true;
        Object[] objArr = {Integer.valueOf(updateList.size())};
        $jacocoInit[116] = true;
        instance.mo2136d(str, String.format("filter %d updates for non excluded and save the remainder", objArr));
        $jacocoInit[117] = true;
        Single saveNonExcludedUpdates = saveNonExcludedUpdates(updateList);
        $jacocoInit[118] = true;
        return saveNonExcludedUpdates;
    }

    private Update mapAppUpdate(App app, boolean isAppcUpgrade) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        Obb obb = app.getObb();
        String mainObbFileName = null;
        String mainObbPath = null;
        String mainObbMd5 = null;
        String patchObbFileName = null;
        String patchObbPath = null;
        String patchObbMd5 = null;
        if (obb == null) {
            $jacocoInit[35] = true;
        } else {
            $jacocoInit[36] = true;
            ObbItem mainObb = obb.getMain();
            $jacocoInit[37] = true;
            ObbItem patchObb = obb.getPatch();
            if (mainObb == null) {
                $jacocoInit[38] = true;
            } else {
                $jacocoInit[39] = true;
                mainObbFileName = mainObb.getFilename();
                $jacocoInit[40] = true;
                mainObbPath = mainObb.getPath();
                $jacocoInit[41] = true;
                mainObbMd5 = mainObb.getMd5sum();
                $jacocoInit[42] = true;
            }
            if (patchObb == null) {
                $jacocoInit[43] = true;
            } else {
                $jacocoInit[44] = true;
                patchObbFileName = patchObb.getFilename();
                $jacocoInit[45] = true;
                patchObbPath = patchObb.getPath();
                $jacocoInit[46] = true;
                patchObbMd5 = patchObb.getMd5sum();
                $jacocoInit[47] = true;
            }
        }
        long id = app.getId();
        String name = app.getName();
        String icon = app.getIcon();
        String packageName = app.getPackageName();
        File file = app.getFile();
        $jacocoInit[48] = true;
        String md5sum = file.getMd5sum();
        File file2 = app.getFile();
        $jacocoInit[49] = true;
        String path = file2.getPath();
        long size = app.getSize();
        File file3 = app.getFile();
        $jacocoInit[50] = true;
        String vername = file3.getVername();
        File file4 = app.getFile();
        $jacocoInit[51] = true;
        String pathAlt = file4.getPathAlt();
        File file5 = app.getFile();
        $jacocoInit[52] = true;
        int vercode = file5.getVercode();
        File file6 = app.getFile();
        $jacocoInit[53] = true;
        Malware malware = file6.getMalware();
        $jacocoInit[54] = true;
        Rank rank = malware.getRank();
        $jacocoInit[55] = true;
        String name2 = rank.name();
        $jacocoInit[56] = true;
        if (app.hasAdvertising()) {
            $jacocoInit[57] = true;
        } else if (app.hasBilling()) {
            $jacocoInit[58] = true;
        } else {
            $jacocoInit[60] = true;
            z = false;
            Update update = new Update(id, name, icon, packageName, md5sum, path, size, vername, pathAlt, vercode, name2, mainObbFileName, mainObbPath, mainObbMd5, patchObbFileName, patchObbPath, patchObbMd5, isAppcUpgrade, z);
            $jacocoInit[61] = true;
            return update;
        }
        $jacocoInit[59] = true;
        z = true;
        Update update2 = new Update(id, name, icon, packageName, md5sum, path, size, vername, pathAlt, vercode, name2, mainObbFileName, mainObbPath, mainObbMd5, patchObbFileName, patchObbPath, patchObbMd5, isAppcUpgrade, z);
        $jacocoInit[61] = true;
        return update2;
    }

    public C0117M removeAll(List<Update> updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) updates);
        C5143o oVar = C5143o.f8882a;
        $jacocoInit[62] = true;
        C0120S j = a.mo3669j(oVar);
        $jacocoInit[63] = true;
        C0120S m = j.mo3675m();
        C5139k kVar = new C5139k(this);
        $jacocoInit[64] = true;
        C0120S f = m.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) kVar);
        $jacocoInit[65] = true;
        C0117M l = f.mo3673l();
        $jacocoInit[66] = true;
        return l;
    }

    /* renamed from: d */
    static /* synthetic */ String m514d(Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = update.getPackageName();
        $jacocoInit[114] = true;
        return packageName;
    }

    /* renamed from: c */
    public /* synthetic */ C0120S mo2372c(List updatesAsPackageNames) {
        boolean[] $jacocoInit = $jacocoInit();
        if (updatesAsPackageNames == null) {
            $jacocoInit[109] = true;
        } else if (updatesAsPackageNames.isEmpty()) {
            $jacocoInit[110] = true;
        } else {
            $jacocoInit[111] = true;
            this.updateAccessor.removeAll(updatesAsPackageNames);
            $jacocoInit[112] = true;
        }
        $jacocoInit[113] = true;
        return null;
    }

    private Single<List<Update>> saveNonExcludedUpdates(List<Update> updateList) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) updateList);
        C5157w wVar = new C5157w(this);
        $jacocoInit[67] = true;
        C0120S f = a.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) wVar);
        $jacocoInit[68] = true;
        C0120S m = f.mo3675m();
        $jacocoInit[69] = true;
        Single n = m.mo3678n();
        C5144p pVar = new C5144p(this, updateList);
        $jacocoInit[70] = true;
        Single<List<Update>> b = n.mo3695b((C0129b<? super T>) pVar);
        $jacocoInit[71] = true;
        return b;
    }

    /* renamed from: e */
    public /* synthetic */ C0120S mo2378e(Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S isExcluded = this.updateAccessor.isExcluded(update.getPackageName());
        C5146r rVar = new C5146r(update);
        $jacocoInit[104] = true;
        C0120S f = isExcluded.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) rVar);
        $jacocoInit[105] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m510a(Update update, Boolean excluded) {
        boolean[] $jacocoInit = $jacocoInit();
        if (excluded.booleanValue()) {
            $jacocoInit[106] = true;
            C0120S c = C0120S.m651c();
            $jacocoInit[107] = true;
            return c;
        }
        C0120S c2 = C0120S.m652c(update);
        $jacocoInit[108] = true;
        return c2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2369a(List updateList, List updateListFiltered) {
        boolean[] $jacocoInit = $jacocoInit();
        if (updateListFiltered == null) {
            $jacocoInit[99] = true;
        } else if (updateList.isEmpty()) {
            $jacocoInit[100] = true;
        } else {
            $jacocoInit[101] = true;
            this.updateAccessor.saveAll(updateListFiltered);
            $jacocoInit[102] = true;
        }
        $jacocoInit[103] = true;
    }

    public C0120S<List<Update>> getAll(boolean isExcluded) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Update>> allSorted = this.updateAccessor.getAllSorted(isExcluded);
        $jacocoInit[72] = true;
        return allSorted;
    }

    public C0120S<Update> get(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Update> s = this.updateAccessor.get(packageName);
        $jacocoInit[73] = true;
        return s;
    }

    public C0117M remove(List<Update> updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) updates);
        C5147s sVar = C5147s.f8887a;
        $jacocoInit[74] = true;
        C0120S j = a.mo3669j(sVar);
        $jacocoInit[75] = true;
        C0120S m = j.mo3675m();
        C5148t tVar = new C5148t(this);
        $jacocoInit[76] = true;
        C0120S b = m.mo3636b((C0129b<? super T>) tVar);
        $jacocoInit[77] = true;
        C0117M l = b.mo3673l();
        $jacocoInit[78] = true;
        return l;
    }

    /* renamed from: b */
    static /* synthetic */ String m512b(Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        String packageName = update.getPackageName();
        $jacocoInit[98] = true;
        return packageName;
    }

    /* renamed from: b */
    public /* synthetic */ void mo2371b(List updatesAsPackages) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateAccessor.removeAll(updatesAsPackages);
        $jacocoInit[97] = true;
    }

    /* renamed from: c */
    public /* synthetic */ void mo2373c(Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateAccessor.remove(update.getPackageName());
        $jacocoInit[96] = true;
    }

    public C0117M remove(Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M c = C0117M.m597c((C0128a) new C5129a(this, update));
        $jacocoInit[79] = true;
        return c;
    }

    public void remove(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        this.updateAccessor.remove(packageName);
        $jacocoInit[80] = true;
    }

    public C0120S<List<Update>> getNonExcludedUpdates() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = this.updateAccessor.getAll();
        C5142n nVar = C5142n.f8881a;
        $jacocoInit[81] = true;
        C0120S<List<Update>> f = all.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) nVar);
        $jacocoInit[82] = true;
        return f;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m511a(List updates) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) updates);
        C5149u uVar = C5149u.f8889a;
        $jacocoInit[90] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) uVar);
        $jacocoInit[91] = true;
        C0120S m = d.mo3675m();
        $jacocoInit[92] = true;
        return m;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m507a(Update update) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!update.isExcluded()) {
            $jacocoInit[93] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[94] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[95] = true;
        return valueOf;
    }

    public C0120S<Void> setExcluded(String packageName, boolean excluded) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.updateAccessor.get(packageName);
        $jacocoInit[83] = true;
        C0120S d = s.mo3647d();
        C5130b bVar = new C5130b(this, excluded);
        $jacocoInit[84] = true;
        C0120S<Void> j = d.mo3669j(bVar);
        $jacocoInit[85] = true;
        return j;
    }

    /* renamed from: a */
    public /* synthetic */ Void mo2367a(boolean excluded, Update update) {
        boolean[] $jacocoInit = $jacocoInit();
        update.setExcluded(excluded);
        $jacocoInit[88] = true;
        this.updateAccessor.insert(update);
        $jacocoInit[89] = true;
        return null;
    }

    public C0120S<Boolean> contains(String packageName, boolean isExcluded) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> contains = this.updateAccessor.contains(packageName, isExcluded);
        $jacocoInit[86] = true;
        return contains;
    }

    public C0120S<Boolean> contains(String packageName, boolean isExcluded, boolean isAppcUpgrade) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> contains = this.updateAccessor.contains(packageName, isExcluded, isAppcUpgrade);
        $jacocoInit[87] = true;
        return contains;
    }
}
