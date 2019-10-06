package p005cm.aptoide.p006pt.repository.request;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.ListStoresRequest;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.repository.request.ListStoresRequestFactory */
class ListStoresRequestFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(160821721162811006L, "cm/aptoide/pt/repository/request/ListStoresRequestFactory", 3);
        $jacocoData = probes;
        return probes;
    }

    public ListStoresRequestFactory(BodyInterceptor<BaseBody> baseBodyInterceptor, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyInterceptor = baseBodyInterceptor;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        $jacocoInit[0] = true;
    }

    public ListStoresRequest newListStoresRequest(int offset, int limit) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoresRequest ofTopStores = ListStoresRequest.ofTopStores(offset, limit, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[1] = true;
        return ofTopStores;
    }

    public ListStoresRequest newListStoresRequest(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        ListStoresRequest ofAction = ListStoresRequest.ofAction(url, this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[2] = true;
        return ofAction;
    }
}
