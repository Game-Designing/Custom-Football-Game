package p005cm.aptoide.p006pt.view.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.WindowManager;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p005cm.aptoide.p006pt.repository.request.RequestFactory;
import p005cm.aptoide.p006pt.store.StoreCredentialsProviderImpl;
import p005cm.aptoide.p006pt.utils.p015q.QManager;
import p005cm.aptoide.p006pt.view.recycler.BaseAdapter;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.view.fragment.AptoideBaseFragment */
public abstract class AptoideBaseFragment<T extends BaseAdapter> extends GridRecyclerFragment<T> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    protected RequestFactory requestFactoryCdnPool;
    protected RequestFactory requestFactoryCdnWeb;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3262732387466671842L, "cm/aptoide/pt/view/fragment/AptoideBaseFragment", 39);
        $jacocoData = probes;
        return probes;
    }

    public AptoideBaseFragment() {
        $jacocoInit()[0] = true;
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        BodyInterceptor<BaseBody> baseBodyInterceptorV7Pool = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[2] = true;
        OkHttpClient httpClient = ((AptoideApplication) getContext().getApplicationContext()).getDefaultClient();
        $jacocoInit[3] = true;
        Factory converterFactory = WebService.getDefaultConverter();
        $jacocoInit[4] = true;
        AptoideApplication application = (AptoideApplication) getContext().getApplicationContext();
        $jacocoInit[5] = true;
        AptoideAccountManager accountManager = application.getAccountManager();
        $jacocoInit[6] = true;
        Context applicationContext = getContext().getApplicationContext();
        $jacocoInit[7] = true;
        $jacocoInit[8] = true;
        StoreCredentialsProviderImpl storeCredentialsProviderImpl = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[9] = true;
        TokenInvalidator tokenInvalidator = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[10] = true;
        SharedPreferences defaultSharedPreferences = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[11] = true;
        Resources resources = getContext().getResources();
        $jacocoInit[12] = true;
        String str = "window";
        WindowManager windowManager = (WindowManager) getContext().getSystemService(str);
        $jacocoInit[13] = true;
        IdsRepository idsRepository = application.getIdsRepository();
        $jacocoInit[14] = true;
        String uniqueIdentifier = idsRepository.getUniqueIdentifier();
        String partnerId = application.getPartnerId();
        $jacocoInit[15] = true;
        QManager qManager = application.getQManager();
        $jacocoInit[16] = true;
        SharedPreferences defaultSharedPreferences2 = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[17] = true;
        String filters = qManager.getFilters(ManagerPreferences.getHWSpecsFilter(defaultSharedPreferences2));
        $jacocoInit[18] = true;
        String str2 = "connectivity";
        ConnectivityManager connectivityManager = (ConnectivityManager) getContext().getSystemService(str2);
        $jacocoInit[19] = true;
        AdsApplicationVersionCodeProvider versionCodeProvider = application.getVersionCodeProvider();
        $jacocoInit[20] = true;
        String str3 = str2;
        String str4 = str;
        RequestFactory requestFactory = r4;
        RequestFactory requestFactory2 = new RequestFactory(storeCredentialsProviderImpl, baseBodyInterceptorV7Pool, httpClient, converterFactory, tokenInvalidator, defaultSharedPreferences, resources, windowManager, uniqueIdentifier, partnerId, accountManager, filters, connectivityManager, versionCodeProvider, AdNetworkUtils.isGooglePlayServicesAvailable(getContext()));
        this.requestFactoryCdnPool = requestFactory;
        $jacocoInit[21] = true;
        BodyInterceptor<BaseBody> baseBodyInterceptorV7Web = ((AptoideApplication) getContext().getApplicationContext()).getAccountSettingsBodyInterceptorWebV7();
        $jacocoInit[22] = true;
        Context applicationContext2 = getContext().getApplicationContext();
        $jacocoInit[23] = true;
        $jacocoInit[24] = true;
        StoreCredentialsProviderImpl storeCredentialsProviderImpl2 = new StoreCredentialsProviderImpl((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext2.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[25] = true;
        TokenInvalidator tokenInvalidator2 = ((AptoideApplication) getContext().getApplicationContext()).getTokenInvalidator();
        $jacocoInit[26] = true;
        SharedPreferences defaultSharedPreferences3 = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[27] = true;
        Resources resources2 = getContext().getResources();
        $jacocoInit[28] = true;
        WindowManager windowManager2 = (WindowManager) getContext().getSystemService(str4);
        $jacocoInit[29] = true;
        IdsRepository idsRepository2 = application.getIdsRepository();
        $jacocoInit[30] = true;
        String uniqueIdentifier2 = idsRepository2.getUniqueIdentifier();
        String partnerId2 = application.getPartnerId();
        $jacocoInit[31] = true;
        QManager qManager2 = application.getQManager();
        $jacocoInit[32] = true;
        SharedPreferences defaultSharedPreferences4 = ((AptoideApplication) getContext().getApplicationContext()).getDefaultSharedPreferences();
        $jacocoInit[33] = true;
        String filters2 = qManager2.getFilters(ManagerPreferences.getHWSpecsFilter(defaultSharedPreferences4));
        $jacocoInit[34] = true;
        ConnectivityManager connectivityManager2 = (ConnectivityManager) getContext().getSystemService(str3);
        $jacocoInit[35] = true;
        AdsApplicationVersionCodeProvider versionCodeProvider2 = application.getVersionCodeProvider();
        $jacocoInit[36] = true;
        RequestFactory requestFactory3 = r5;
        RequestFactory requestFactory4 = new RequestFactory(storeCredentialsProviderImpl2, baseBodyInterceptorV7Web, httpClient, converterFactory, tokenInvalidator2, defaultSharedPreferences3, resources2, windowManager2, uniqueIdentifier2, partnerId2, accountManager, filters2, connectivityManager2, versionCodeProvider2, AdNetworkUtils.isGooglePlayServicesAvailable(getContext()));
        this.requestFactoryCdnWeb = requestFactory3;
        $jacocoInit[37] = true;
        super.onCreate(savedInstanceState);
        $jacocoInit[38] = true;
    }
}
