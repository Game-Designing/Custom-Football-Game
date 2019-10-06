package p005cm.aptoide.p006pt.store.view.recommended;

import android.content.Context;
import android.support.p000v4.app.Fragment;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.repository.StoreRepository;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p005cm.aptoide.p006pt.store.StoreUtils;
import p005cm.aptoide.p006pt.store.StoreUtilsProxy;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.store.view.recommended.RecommendedStoreDisplayable */
public class RecommendedStoreDisplayable extends DisplayablePojo<Store> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private AptoideAccountManager accountManager;
    private String origin = "";
    private StoreCredentialsProvider storeCredentialsProvider;
    private StoreRepository storeRepository;
    private StoreUtilsProxy storeUtilsProxy;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-457811092792583762L, "cm/aptoide/pt/store/view/recommended/RecommendedStoreDisplayable", 24);
        $jacocoData = probes;
        return probes;
    }

    public RecommendedStoreDisplayable() {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[0] = true;
    }

    public RecommendedStoreDisplayable(Store pojo, StoreRepository storeRepository2, AptoideAccountManager accountManager2, StoreUtilsProxy storeUtilsProxy2, StoreCredentialsProvider storeCredentialsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.storeRepository = storeRepository2;
        this.accountManager = accountManager2;
        this.storeUtilsProxy = storeUtilsProxy2;
        this.storeCredentialsProvider = storeCredentialsProvider2;
        $jacocoInit[1] = true;
    }

    public RecommendedStoreDisplayable(Store store, StoreRepository storeRepository2, AptoideAccountManager accountManager2, StoreUtilsProxy storeUtilsProxy2, StoreCredentialsProvider storeCredentialsProvider2, String origin2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(store);
        this.storeRepository = storeRepository2;
        this.accountManager = accountManager2;
        this.storeUtilsProxy = storeUtilsProxy2;
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.origin = origin2;
        $jacocoInit[2] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, false);
        $jacocoInit[3] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[4] = true;
        return C1375R.layout.displayable_recommended_store;
    }

    /* access modifiers changed from: 0000 */
    public C0120S<Boolean> isFollowing() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Boolean> isSubscribed = this.storeRepository.isSubscribed(((Store) getPojo()).getId());
        $jacocoInit[5] = true;
        return isSubscribed;
    }

    public void subscribeStore() {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeUtilsProxy.subscribeStore(((Store) getPojo()).getName());
        $jacocoInit[6] = true;
    }

    /* access modifiers changed from: 0000 */
    public void unsubscribeStore(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        if (!this.accountManager.isLoggedIn()) {
            $jacocoInit[7] = true;
        } else {
            $jacocoInit[8] = true;
            AptoideAccountManager aptoideAccountManager = this.accountManager;
            String name = ((Store) getPojo()).getName();
            StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
            $jacocoInit[9] = true;
            StoreCredentials storeCredentials = storeCredentialsProvider2.get(((Store) getPojo()).getName());
            $jacocoInit[10] = true;
            String name2 = storeCredentials.getName();
            StoreCredentials storeCredentials2 = this.storeCredentialsProvider.get(((Store) getPojo()).getName());
            $jacocoInit[11] = true;
            String passwordSha1 = storeCredentials2.getPasswordSha1();
            $jacocoInit[12] = true;
            aptoideAccountManager.unsubscribeStore(name, name2, passwordSha1);
            $jacocoInit[13] = true;
        }
        String name3 = ((Store) getPojo()).getName();
        AptoideAccountManager aptoideAccountManager2 = this.accountManager;
        StoreCredentialsProvider storeCredentialsProvider3 = this.storeCredentialsProvider;
        $jacocoInit[14] = true;
        $jacocoInit[15] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) context.getApplicationContext()).getDatabase(), p005cm.aptoide.p006pt.database.realm.Store.class);
        $jacocoInit[16] = true;
        StoreUtils.unSubscribeStore(name3, aptoideAccountManager2, storeCredentialsProvider3, storeAccessor);
        $jacocoInit[17] = true;
    }

    /* access modifiers changed from: 0000 */
    public void openStoreFragment(FragmentNavigator navigator) {
        boolean[] $jacocoInit = $jacocoInit();
        FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
        $jacocoInit[18] = true;
        String name = ((Store) getPojo()).getName();
        Appearance appearance = ((Store) getPojo()).getAppearance();
        $jacocoInit[19] = true;
        String theme = appearance.getTheme();
        $jacocoInit[20] = true;
        Fragment newStoreFragment = fragmentProvider.newStoreFragment(name, theme);
        $jacocoInit[21] = true;
        navigator.navigateTo(newStoreFragment, true);
        $jacocoInit[22] = true;
    }

    public String getOrigin() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.origin;
        $jacocoInit[23] = true;
        return str;
    }
}
