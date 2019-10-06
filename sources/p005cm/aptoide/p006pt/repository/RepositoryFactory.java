package p005cm.aptoide.p006pt.repository;

import android.content.Context;
import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.database.AccessorFactory;
import p005cm.aptoide.p006pt.database.accessors.InstalledAccessor;
import p005cm.aptoide.p006pt.database.accessors.StoreAccessor;
import p005cm.aptoide.p006pt.database.accessors.UpdateAccessor;
import p005cm.aptoide.p006pt.database.realm.Installed;
import p005cm.aptoide.p006pt.database.realm.Store;
import p005cm.aptoide.p006pt.database.realm.Update;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.install.InstalledRepository;
import p005cm.aptoide.p006pt.networking.IdsRepository;
import p005cm.aptoide.p006pt.updates.UpdateRepository;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.repository.RepositoryFactory */
public final class RepositoryFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4993829264250973309L, "cm/aptoide/pt/repository/RepositoryFactory", 21);
        $jacocoData = probes;
        return probes;
    }

    public RepositoryFactory() {
        $jacocoInit()[0] = true;
    }

    public static UpdateRepository getUpdateRepository(Context context, SharedPreferences sharedPreferences) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[1] = true;
        Context applicationContext = context.getApplicationContext();
        $jacocoInit[2] = true;
        $jacocoInit[3] = true;
        UpdateAccessor updateAccessor = (UpdateAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext.getApplicationContext()).getDatabase(), Update.class);
        $jacocoInit[4] = true;
        Context applicationContext2 = context.getApplicationContext();
        $jacocoInit[5] = true;
        $jacocoInit[6] = true;
        StoreAccessor storeAccessor = (StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) applicationContext2.getApplicationContext()).getDatabase(), Store.class);
        $jacocoInit[7] = true;
        IdsRepository idsRepository = getIdsRepository(context);
        $jacocoInit[8] = true;
        BodyInterceptor baseBodyInterceptorV7 = getBaseBodyInterceptorV7(context);
        OkHttpClient httpClient = getHttpClient(context);
        Factory defaultConverter = WebService.getDefaultConverter();
        $jacocoInit[9] = true;
        UpdateRepository updateRepository = new UpdateRepository(updateAccessor, storeAccessor, idsRepository, baseBodyInterceptorV7, httpClient, defaultConverter, getTokenInvalidator(context), sharedPreferences, context.getPackageManager());
        $jacocoInit[10] = true;
        return updateRepository;
    }

    private static IdsRepository getIdsRepository(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        IdsRepository idsRepository = ((AptoideApplication) context.getApplicationContext()).getIdsRepository();
        $jacocoInit[11] = true;
        return idsRepository;
    }

    private static OkHttpClient getHttpClient(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        OkHttpClient defaultClient = ((AptoideApplication) context.getApplicationContext()).getDefaultClient();
        $jacocoInit[12] = true;
        return defaultClient;
    }

    public static InstalledRepository getInstalledRepository(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[13] = true;
        $jacocoInit[14] = true;
        InstalledRepository installedRepository = new InstalledRepository((InstalledAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) context.getApplicationContext()).getDatabase(), Installed.class));
        $jacocoInit[15] = true;
        return installedRepository;
    }

    public static StoreRepository getStoreRepository(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[16] = true;
        $jacocoInit[17] = true;
        StoreRepository storeRepository = new StoreRepository((StoreAccessor) AccessorFactory.getAccessorFor(((AptoideApplication) context.getApplicationContext()).getDatabase(), Store.class));
        $jacocoInit[18] = true;
        return storeRepository;
    }

    private static BodyInterceptor<BaseBody> getBaseBodyInterceptorV7(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> accountSettingsBodyInterceptorPoolV7 = ((AptoideApplication) context.getApplicationContext()).getAccountSettingsBodyInterceptorPoolV7();
        $jacocoInit[19] = true;
        return accountSettingsBodyInterceptorPoolV7;
    }

    private static TokenInvalidator getTokenInvalidator(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        TokenInvalidator tokenInvalidator = ((AptoideApplication) context.getApplicationContext()).getTokenInvalidator();
        $jacocoInit[20] = true;
        return tokenInvalidator;
    }
}
