package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.CheckUserCredentialsJson;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.deprecated.tables.Updates;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.CheckUserCredentialsRequest */
public class CheckUserCredentialsRequest extends C2847V3<CheckUserCredentialsJson> {
    private static final String CREATE_REPO_VALUE = "1";
    private static final String DEFAULT_AUTH_MODE = "aptoide";
    private static final String OAUTH_CREATE_REPO_VALUE = "true";
    private final boolean createStore;

    private CheckUserCredentialsRequest(BaseBody baseBody, boolean createStore2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.createStore = createStore2;
    }

    public static CheckUserCredentialsRequest toCreateStore(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String storeName) {
        BaseBody body = new BaseBody();
        body.put("createRepo", CREATE_REPO_VALUE);
        body.put("oauthCreateRepo", "true");
        body.put(Updates.COLUMN_REPO, storeName);
        body.setAuthMode(DEFAULT_AUTH_MODE);
        CheckUserCredentialsRequest checkUserCredentialsRequest = new CheckUserCredentialsRequest(body, true, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return checkUserCredentialsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<CheckUserCredentialsJson> loadDataFromNetwork(Service service, boolean bypassCache) {
        if (this.createStore) {
            return service.checkUserCredentials(this.map, bypassCache);
        }
        return service.getUserInfo(this.map, bypassCache);
    }
}
