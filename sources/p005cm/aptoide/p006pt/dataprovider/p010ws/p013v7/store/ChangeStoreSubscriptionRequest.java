package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ChangeStoreSubscriptionResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.ChangeStoreSubscriptionResponse.StoreSubscriptionState;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.ChangeStoreSubscriptionRequest */
public class ChangeStoreSubscriptionRequest extends C0044V7<ChangeStoreSubscriptionResponse, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.ChangeStoreSubscriptionRequest$Body */
    public static class Body extends BaseBody {
        private final StoreSubscriptionState status;
        private final String storeName;
        private String storePassSha1;
        private String storeUser;

        public Body(String storeName2, StoreSubscriptionState status2) {
            this.storeName = storeName2;
            this.status = status2;
        }

        public Body(String storeName2, StoreSubscriptionState status2, String storeUser2, String storePassSha12) {
            this.storeName = storeName2;
            this.storePassSha1 = storePassSha12;
            this.status = status2;
            this.storeUser = storeUser2;
        }

        public String getStoreName() {
            return this.storeName;
        }

        public StoreSubscriptionState getStatus() {
            return this.status;
        }

        public String getStorePassSha1() {
            return this.storePassSha1;
        }

        public String getStoreUser() {
            return this.storeUser;
        }
    }

    protected ChangeStoreSubscriptionRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_WRITE_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    /* renamed from: of */
    public static ChangeStoreSubscriptionRequest m7577of(String storeName, StoreSubscriptionState storeSubscription, String storeUser, String sha1PassWord, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        String str = storeName;
        StoreSubscriptionState storeSubscriptionState = storeSubscription;
        String str2 = storeUser;
        String str3 = sha1PassWord;
        ChangeStoreSubscriptionRequest changeStoreSubscriptionRequest = new ChangeStoreSubscriptionRequest(new Body(storeName, storeSubscription, storeUser, sha1PassWord), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return changeStoreSubscriptionRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ChangeStoreSubscriptionResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.changeStoreSubscription(bypassCache, (Body) this.body);
    }
}
