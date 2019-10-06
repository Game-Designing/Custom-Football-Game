package p005cm.aptoide.p006pt.search.suggestions;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest.Body;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ListAppsRequest.Sort;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.search.suggestions.TrendingService */
public class TrendingService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentialsProvider storeCredentialsProvider;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3200921151367827288L, "cm/aptoide/pt/search/suggestions/TrendingService", 6);
        $jacocoData = probes;
        return probes;
    }

    public TrendingService(StoreCredentialsProvider storeCredentialsProvider2, BodyInterceptor<BaseBody> bodyInterceptor2, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeCredentialsProvider = storeCredentialsProvider2;
        this.bodyInterceptor = bodyInterceptor2;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public C0120S<ListApps> getTrendingApps(int limit, int storeId) {
        boolean[] $jacocoInit = $jacocoInit();
        StoreCredentialsProvider storeCredentialsProvider2 = this.storeCredentialsProvider;
        long j = (long) storeId;
        $jacocoInit[1] = true;
        Body body = new Body(storeCredentialsProvider2.get(j), limit, this.sharedPreferences, Sort.trending30d);
        $jacocoInit[2] = true;
        body.setStoreId((long) storeId);
        $jacocoInit[3] = true;
        ListAppsRequest listAppsRequest = new ListAppsRequest(body, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[4] = true;
        C0120S<ListApps> observe = listAppsRequest.observe(false);
        $jacocoInit[5] = true;
        return observe;
    }
}
