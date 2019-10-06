package p005cm.aptoide.p006pt.repository;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.repository.StoreRepository */
public class StoreRepository {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final StoreAccessor storeAccessor;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8578930191770587325L, "cm/aptoide/pt/repository/StoreRepository", 19);
        $jacocoData = probes;
        return probes;
    }

    public StoreRepository(StoreAccessor storeAccessor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeAccessor = storeAccessor2;
        $jacocoInit[0] = true;
    }

    public C0120S<Boolean> isSubscribed(long storeId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S asList = this.storeAccessor.getAsList(storeId);
        C4622a aVar = C4622a.f8262a;
        $jacocoInit[1] = true;
        C0120S<Boolean> j = asList.mo3669j(aVar);
        $jacocoInit[2] = true;
        return j;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m8985a(List stores) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (stores == null) {
            $jacocoInit[14] = true;
        } else if (stores.size() <= 0) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            z = true;
            Boolean valueOf = Boolean.valueOf(z);
            $jacocoInit[18] = true;
            return valueOf;
        }
        z = false;
        $jacocoInit[17] = true;
        Boolean valueOf2 = Boolean.valueOf(z);
        $jacocoInit[18] = true;
        return valueOf2;
    }

    public C0120S<Boolean> isSubscribed(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S asList = this.storeAccessor.getAsList(storeName);
        C4623b bVar = C4623b.f8263a;
        $jacocoInit[3] = true;
        C0120S<Boolean> j = asList.mo3669j(bVar);
        $jacocoInit[4] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ Boolean m8986b(List stores) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!stores.isEmpty()) {
            $jacocoInit[11] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[12] = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        $jacocoInit[13] = true;
        return valueOf;
    }

    public C0120S<Long> count() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Long> count = this.storeAccessor.count();
        $jacocoInit[5] = true;
        return count;
    }

    public C0120S<List<Store>> getAll() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<List<Store>> all = this.storeAccessor.getAll();
        $jacocoInit[6] = true;
        return all;
    }

    public void save(Store entity) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeAccessor.insert(entity);
        $jacocoInit[7] = true;
    }

    public C0120S<Store> get(Integer id) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Store> s = this.storeAccessor.get((long) id.intValue());
        $jacocoInit[8] = true;
        return s;
    }

    public C0120S<Store> getByName(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Store> s = this.storeAccessor.get(storeName);
        $jacocoInit[9] = true;
        return s;
    }

    public void saveAll(List<Store> stores) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeAccessor.insertAll(stores);
        $jacocoInit[10] = true;
    }
}
