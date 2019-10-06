package p005cm.aptoide.p006pt.store;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.dataprovider.interfaces.ErrorRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.SuccessRequestListener;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Info;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response.Info.Status;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStoreMeta;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Stats;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetHomeMetaRequest.Body;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreMetaRequest;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.p027b.C0129b;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.store.StoreUtilsProxy */
public class StoreUtilsProxy {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final StoreAccessor storeAccessor;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-493049161310043408L, "cm/aptoide/pt/store/StoreUtilsProxy", 59);
        $jacocoData = probes;
        return probes;
    }

    public StoreUtilsProxy(AptoideAccountManager accountManager2, BodyInterceptor<BaseBody> bodyInterceptor2, StoreCredentialsProvider storeCredentialsProvider2, StoreAccessor storeAccessor2, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.accountManager = accountManager2;
        this.bodyInterceptor = bodyInterceptor2;
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.storeAccessor = storeAccessor2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public void subscribeStore(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[1] = true;
        GetStoreMetaRequest of = GetStoreMetaRequest.m264of(StoreUtils.getStoreCredentials(storeName, storeCredentialsProvider2), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        $jacocoInit[2] = true;
        subscribeStore(of, null, null, storeName, aptoideAccountManager);
        $jacocoInit[3] = true;
    }

    public C0120S<GetStoreMeta> subscribeStoreObservable(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[4] = true;
        GetStoreMetaRequest of = GetStoreMetaRequest.m264of(StoreUtils.getStoreCredentials(storeName, storeCredentialsProvider2), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        AptoideAccountManager aptoideAccountManager = this.accountManager;
        StoreAccessor storeAccessor2 = this.storeAccessor;
        $jacocoInit[5] = true;
        C0120S<GetStoreMeta> subscribeStore = StoreUtils.subscribeStore(of, aptoideAccountManager, null, null, storeAccessor2);
        $jacocoInit[6] = true;
        return subscribeStore;
    }

    public void subscribeStore(GetStoreMetaRequest getStoreMetaRequest, SuccessRequestListener<GetStoreMeta> successRequestListener, ErrorRequestListener errorRequestListener, String storeName, AptoideAccountManager accountManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        subscribeStore(getStoreMetaRequest, successRequestListener, errorRequestListener, storeName, accountManager2, null, null);
        $jacocoInit[7] = true;
    }

    public void subscribeStore(GetStoreMetaRequest getStoreMetaRequest, SuccessRequestListener<GetStoreMeta> successRequestListener, ErrorRequestListener errorRequestListener, String storeName, AptoideAccountManager accountManager2, String storeUserName, String storePassword) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreUtils.subscribeStore(getStoreMetaRequest, successRequestListener, errorRequestListener, accountManager2, storeUserName, storePassword, this.storeAccessor);
        $jacocoInit[8] = true;
    }

    public void subscribeStore(String storeName, SuccessRequestListener<GetStoreMeta> successRequestListener, ErrorRequestListener errorRequestListener, AptoideAccountManager accountManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        $jacocoInit[9] = true;
        GetStoreMetaRequest of = GetStoreMetaRequest.m264of(StoreUtils.getStoreCredentials(storeName, storeCredentialsProvider2), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[10] = true;
        subscribeStore(of, successRequestListener, errorRequestListener, storeName, accountManager2);
        $jacocoInit[11] = true;
    }

    public void unSubscribeStore(String storeName, StoreCredentialsProvider storeCredentialsProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreUtils.unSubscribeStore(storeName, this.accountManager, storeCredentialsProvider2, this.storeAccessor);
        $jacocoInit[12] = true;
    }

    public void unSubscribeStore(String storeName) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreUtils.unSubscribeStore(storeName, this.accountManager, this.storeCredentialsProvider, this.storeAccessor);
        $jacocoInit[13] = true;
    }

    public C0117M addDefaultStore(GetStoreMetaRequest getStoreMetaRequest, AptoideAccountManager accountManager2, StoreCredentials storeCredentials) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S observe = getStoreMetaRequest.observe();
        C4935h hVar = new C4935h(accountManager2, storeCredentials);
        $jacocoInit[14] = true;
        C0120S f = observe.mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) hVar);
        C4937j jVar = new C4937j(this, getStoreMetaRequest);
        $jacocoInit[15] = true;
        C0120S b = f.mo3636b((C0129b<? super T>) jVar);
        C4936i iVar = C4936i.f8587a;
        $jacocoInit[16] = true;
        C0120S a = b.mo3621a((C0129b<? super Throwable>) iVar);
        $jacocoInit[17] = true;
        C0117M l = a.mo3673l();
        $jacocoInit[18] = true;
        return l;
    }

    /* renamed from: a */
    static /* synthetic */ C0120S m498a(AptoideAccountManager accountManager2, StoreCredentials storeCredentials, GetStoreMeta getStoreMeta) {
        boolean[] $jacocoInit = $jacocoInit();
        Status status = Status.OK;
        Info info = getStoreMeta.getInfo();
        $jacocoInit[49] = true;
        Status status2 = info.getStatus();
        $jacocoInit[50] = true;
        if (status.equals(status2)) {
            $jacocoInit[51] = true;
            if (accountManager2.isLoggedIn()) {
                $jacocoInit[52] = true;
                Store data = getStoreMeta.getData();
                $jacocoInit[53] = true;
                String name = data.getName();
                String username = storeCredentials.getUsername();
                String passwordSha1 = storeCredentials.getPasswordSha1();
                $jacocoInit[54] = true;
                C0117M subscribeStore = accountManager2.subscribeStore(name, username, passwordSha1);
                $jacocoInit[55] = true;
                C0120S a = subscribeStore.mo3586a(C0120S.m652c(getStoreMeta));
                $jacocoInit[56] = true;
                return a;
            }
            C0120S c = C0120S.m652c(getStoreMeta);
            $jacocoInit[57] = true;
            return c;
        }
        C0120S a2 = C0120S.m631a((Throwable) new Exception("Something went wrong while getting store meta"));
        $jacocoInit[58] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ void mo2346a(GetStoreMetaRequest getStoreMetaRequest, GetStoreMeta getStoreMeta) {
        boolean[] $jacocoInit = $jacocoInit();
        saveStore(getStoreMeta.getData(), getStoreMetaRequest, this.storeAccessor);
        $jacocoInit[48] = true;
    }

    /* renamed from: a */
    static /* synthetic */ void m499a(Throwable throwable) {
        boolean[] $jacocoInit = $jacocoInit();
        CrashReport instance = CrashReport.getInstance();
        $jacocoInit[46] = true;
        instance.log(throwable);
        $jacocoInit[47] = true;
    }

    private void saveStore(Store storeData, GetStoreMetaRequest getStoreMetaRequest, StoreAccessor storeAccessor2) {
        boolean[] $jacocoInit = $jacocoInit();
        p005cm.aptoide.p006pt.database.realm.Store store = new p005cm.aptoide.p006pt.database.realm.Store();
        $jacocoInit[19] = true;
        store.setStoreId(storeData.getId());
        $jacocoInit[20] = true;
        store.setStoreName(storeData.getName());
        $jacocoInit[21] = true;
        Stats stats = storeData.getStats();
        $jacocoInit[22] = true;
        long downloads = stats.getDownloads();
        $jacocoInit[23] = true;
        store.setDownloads(downloads);
        $jacocoInit[24] = true;
        store.setIconPath(storeData.getAvatar());
        $jacocoInit[25] = true;
        Appearance appearance = storeData.getAppearance();
        $jacocoInit[26] = true;
        String theme = appearance.getTheme();
        $jacocoInit[27] = true;
        store.setTheme(theme);
        $jacocoInit[28] = true;
        if (!isPrivateCredentialsSet(getStoreMetaRequest)) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            Body body = (Body) getStoreMetaRequest.getBody();
            $jacocoInit[31] = true;
            String storeUser = body.getStoreUser();
            $jacocoInit[32] = true;
            store.setUsername(storeUser);
            $jacocoInit[33] = true;
            Body body2 = (Body) getStoreMetaRequest.getBody();
            $jacocoInit[34] = true;
            String storePassSha1 = body2.getStorePassSha1();
            $jacocoInit[35] = true;
            store.setPasswordSha1(storePassSha1);
            $jacocoInit[36] = true;
        }
        storeAccessor2.save(store);
        $jacocoInit[37] = true;
    }

    private boolean isPrivateCredentialsSet(GetStoreMetaRequest getStoreMetaRequest) {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        Body body = (Body) getStoreMetaRequest.getBody();
        $jacocoInit[38] = true;
        if (body.getStoreUser() == null) {
            $jacocoInit[39] = true;
        } else {
            $jacocoInit[40] = true;
            Body body2 = (Body) getStoreMetaRequest.getBody();
            $jacocoInit[41] = true;
            if (body2.getStorePassSha1() == null) {
                $jacocoInit[42] = true;
            } else {
                $jacocoInit[43] = true;
                z = true;
                $jacocoInit[45] = true;
                return z;
            }
        }
        z = false;
        $jacocoInit[44] = true;
        $jacocoInit[45] = true;
        return z;
    }
}
