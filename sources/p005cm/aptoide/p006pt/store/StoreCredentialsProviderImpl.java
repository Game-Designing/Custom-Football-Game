package p005cm.aptoide.p006pt.store;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.V7Url;
import p026rx.C0120S;
import p026rx.p398d.C14906b;

/* renamed from: cm.aptoide.pt.store.StoreCredentialsProviderImpl */
public class StoreCredentialsProviderImpl implements StoreCredentialsProvider {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final StoreAccessor storeAccessor;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5457568688292925067L, "cm/aptoide/pt/store/StoreCredentialsProviderImpl", 22);
        $jacocoData = probes;
        return probes;
    }

    public StoreCredentialsProviderImpl(StoreAccessor storeAccessor2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeAccessor = storeAccessor2;
        $jacocoInit[0] = true;
    }

    public StoreCredentials get(long storeId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.storeAccessor.get(storeId);
        $jacocoInit[1] = true;
        C14906b k = s.mo3672k();
        $jacocoInit[2] = true;
        Store store = (Store) k.mo46110a();
        if (store != null) {
            $jacocoInit[3] = true;
            String username = store.getUsername();
            $jacocoInit[4] = true;
            String passwordSha1 = store.getPasswordSha1();
            $jacocoInit[5] = true;
            StoreCredentials storeCredentials = new StoreCredentials(storeId, store.getStoreName(), username, passwordSha1);
            $jacocoInit[6] = true;
            return storeCredentials;
        }
        StoreCredentials storeCredentials2 = new StoreCredentials(storeId, (String) null, (String) null);
        $jacocoInit[7] = true;
        return storeCredentials2;
    }

    public StoreCredentials get(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S s = this.storeAccessor.get(storeName);
        $jacocoInit[8] = true;
        C14906b k = s.mo3672k();
        $jacocoInit[9] = true;
        Store store = (Store) k.mo46110a();
        if (store != null) {
            $jacocoInit[10] = true;
            String username = store.getUsername();
            $jacocoInit[11] = true;
            String passwordSha1 = store.getPasswordSha1();
            $jacocoInit[12] = true;
            StoreCredentials storeCredentials = new StoreCredentials(store.getStoreId(), storeName, username, passwordSha1);
            $jacocoInit[13] = true;
            return storeCredentials;
        }
        StoreCredentials storeCredentials2 = new StoreCredentials(storeName, (String) null, (String) null);
        $jacocoInit[14] = true;
        return storeCredentials2;
    }

    public StoreCredentials fromUrl(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        V7Url v7Url = new V7Url(url);
        $jacocoInit[15] = true;
        Long storeId = v7Url.getStoreId();
        $jacocoInit[16] = true;
        String storeName = v7Url.getStoreName();
        if (storeId != null) {
            $jacocoInit[17] = true;
            StoreCredentials storeCredentials = get(storeId.longValue());
            $jacocoInit[18] = true;
            return storeCredentials;
        } else if (storeName != null) {
            $jacocoInit[19] = true;
            StoreCredentials storeCredentials2 = get(storeName);
            $jacocoInit[20] = true;
            return storeCredentials2;
        } else {
            StoreCredentials storeCredentials3 = new StoreCredentials();
            $jacocoInit[21] = true;
            return storeCredentials3;
        }
    }
}
