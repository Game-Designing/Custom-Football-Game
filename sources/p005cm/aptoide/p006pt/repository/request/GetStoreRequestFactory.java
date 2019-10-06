package p005cm.aptoide.p006pt.repository.request;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.WindowManager;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.GetStoreRequest;
import p005cm.aptoide.p006pt.store.StoreCredentialsProvider;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.repository.request.GetStoreRequestFactory */
class GetStoreRequestFactory {
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
        boolean[] probes = Offline.getProbes(1200046012580506916L, "cm/aptoide/pt/repository/request/GetStoreRequestFactory", 2);
        $jacocoData = probes;
        return probes;
    }

    public GetStoreRequestFactory(StoreCredentialsProvider storeCredentialsProvider2, BodyInterceptor<BaseBody> bodyInterceptor2, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, Resources resources2, WindowManager windowManager2) {
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

    public GetStoreRequest newStore(String url) {
        boolean[] $jacocoInit = $jacocoInit();
        GetStoreRequest ofAction = GetStoreRequest.ofAction(url, this.storeCredentialsProvider.fromUrl(url), this.bodyInterceptor, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.resources, this.windowManager);
        $jacocoInit[1] = true;
        return ofAction;
    }
}
