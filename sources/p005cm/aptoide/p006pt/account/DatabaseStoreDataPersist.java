package p005cm.aptoide.p006pt.account;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.logger.Logger;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.account.DatabaseStoreDataPersist */
public class DatabaseStoreDataPersist {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final StoreAccessor accessor;
    private final DatabaseStoreMapper databaseStoreMapper;

    /* renamed from: cm.aptoide.pt.account.DatabaseStoreDataPersist$DatabaseStoreMapper */
    public static class DatabaseStoreMapper {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-3578520923398195045L, "cm/aptoide/pt/account/DatabaseStoreDataPersist$DatabaseStoreMapper", 11);
            $jacocoData = probes;
            return probes;
        }

        public DatabaseStoreMapper() {
            $jacocoInit()[0] = true;
        }

        public Store toDatabase(p005cm.aptoide.accountmanager.Store store) {
            boolean[] $jacocoInit = $jacocoInit();
            Store result = new Store();
            $jacocoInit[1] = true;
            result.setDownloads(store.getDownloadCount());
            $jacocoInit[2] = true;
            result.setIconPath(store.getAvatar());
            $jacocoInit[3] = true;
            result.setStoreId(store.getId());
            $jacocoInit[4] = true;
            result.setStoreName(store.getName());
            $jacocoInit[5] = true;
            result.setTheme(store.getTheme());
            $jacocoInit[6] = true;
            result.setUsername(store.getUsername());
            $jacocoInit[7] = true;
            result.setPasswordSha1(store.getPassword());
            $jacocoInit[8] = true;
            return result;
        }

        public p005cm.aptoide.accountmanager.Store fromDatabase(Store store) {
            boolean[] $jacocoInit = $jacocoInit();
            long downloads = store.getDownloads();
            String iconPath = store.getIconPath();
            long storeId = store.getStoreId();
            $jacocoInit[9] = true;
            p005cm.aptoide.accountmanager.Store store2 = new p005cm.aptoide.accountmanager.Store(downloads, iconPath, storeId, store.getStoreName(), store.getTheme(), store.getUsername(), store.getPasswordSha1(), true);
            $jacocoInit[10] = true;
            return store2;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3339684174122710720L, "cm/aptoide/pt/account/DatabaseStoreDataPersist", 21);
        $jacocoData = probes;
        return probes;
    }

    public DatabaseStoreDataPersist(StoreAccessor accessor2, DatabaseStoreMapper databaseStoreMapper2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accessor = accessor2;
        this.databaseStoreMapper = databaseStoreMapper2;
        $jacocoInit[0] = true;
    }

    public C0117M persist(List<p005cm.aptoide.accountmanager.Store> stores) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) stores);
        C1421T t = new C1421T(this);
        $jacocoInit[1] = true;
        C0120S j = a.mo3669j(t);
        $jacocoInit[2] = true;
        C0120S m = j.mo3675m();
        C1420S s = new C1420S(this);
        $jacocoInit[3] = true;
        C0120S b = m.mo3636b((C0129b<? super T>) s);
        $jacocoInit[4] = true;
        C0117M l = b.mo3673l();
        $jacocoInit[5] = true;
        return l;
    }

    /* renamed from: a */
    public /* synthetic */ Store mo9608a(p005cm.aptoide.accountmanager.Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        Store database = this.databaseStoreMapper.toDatabase(store);
        $jacocoInit[20] = true;
        return database;
    }

    /* renamed from: c */
    public /* synthetic */ void mo9609c(List storeList) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accessor.insertAll(storeList);
        $jacocoInit[19] = true;
    }

    public Single<List<p005cm.aptoide.accountmanager.Store>> get() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S all = this.accessor.getAll();
        $jacocoInit[6] = true;
        C0120S d = all.mo3647d();
        C1419Q q = C1419Q.f4335a;
        $jacocoInit[7] = true;
        C0120S h = d.mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) q);
        C1422U u = new C1422U(this);
        $jacocoInit[8] = true;
        C0120S j = h.mo3669j(u);
        $jacocoInit[9] = true;
        C0120S m = j.mo3675m();
        $jacocoInit[10] = true;
        Single n = m.mo3678n();
        C1418P p = C1418P.f4334a;
        $jacocoInit[11] = true;
        Single<List<p005cm.aptoide.accountmanager.Store>> b = n.mo3695b((C0129b<? super T>) p);
        $jacocoInit[12] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ Iterable m6211a(List list) {
        $jacocoInit()[18] = true;
        return list;
    }

    /* renamed from: a */
    public /* synthetic */ p005cm.aptoide.accountmanager.Store mo9607a(Store store) {
        boolean[] $jacocoInit = $jacocoInit();
        p005cm.aptoide.accountmanager.Store fromDatabase = this.databaseStoreMapper.fromDatabase(store);
        $jacocoInit[17] = true;
        return fromDatabase;
    }

    /* renamed from: b */
    static /* synthetic */ void m6212b(List stores) {
        int i;
        boolean[] $jacocoInit = $jacocoInit();
        Logger instance = Logger.getInstance();
        StringBuilder sb = new StringBuilder();
        sb.append("nr stores= ");
        if (stores != null) {
            $jacocoInit[13] = true;
            i = stores.size();
            $jacocoInit[14] = true;
        } else {
            i = 0;
            $jacocoInit[15] = true;
        }
        sb.append(i);
        instance.mo2136d("DatabaseStoreDataPersist", sb.toString());
        $jacocoInit[16] = true;
    }
}
