package p005cm.aptoide.p006pt.repository.request;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.WindowManager;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest.Body;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest.Sort;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.repository.request.ListAppsRequestFactory */
class ListAppsRequestFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;
    private final WindowManager windowManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6846783054706014732L, "cm/aptoide/pt/repository/request/ListAppsRequestFactory", 4);
        $jacocoData = probes;
        return probes;
    }

    public ListAppsRequestFactory(BodyInterceptor<BaseBody> bodyInterceptor2, StoreCredentialsProvider storeCredentialsProvider2, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, Resources resources2, WindowManager windowManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.bodyInterceptor = bodyInterceptor2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.resources = resources2;
        this.windowManager = windowManager2;
        $jacocoInit[0] = true;
    }

    public ListAppsRequest newListAppsRequest(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        ListAppsRequest ofAction = ListAppsRequest.ofAction(url, this.storeCredentialsProvider.fromUrl(url), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.resources, this.windowManager);
        $jacocoInit[1] = true;
        return ofAction;
    }

    public ListAppsRequest newListAppsRequest(int storeId, Long groupId, int limit, Sort sort) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        long j = (long) storeId;
        $jacocoInit[2] = true;
        Body body = new Body(storeCredentialsProvider2.get(j), groupId, limit, this.sharedPreferences, sort);
        ListAppsRequest listAppsRequest = new ListAppsRequest(body, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[3] = true;
        return listAppsRequest;
    }
}
