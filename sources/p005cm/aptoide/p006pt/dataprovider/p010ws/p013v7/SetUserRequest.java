package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SetUserRequest */
public class SetUserRequest extends C0044V7<BaseV7Response, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SetUserRequest$Body */
    public static class Body extends BaseBody {
        public UserProperties userProperties;
        public String user_access;

        public Body(String user_access2, String userName) {
            this.user_access = user_access2;
            this.userProperties = new UserProperties(userName);
        }

        public String getUser_access() {
            return this.user_access;
        }

        public void setUser_access(String user_access2) {
            this.user_access = user_access2;
        }

        public UserProperties getUserProperties() {
            return this.userProperties;
        }

        public void setUserProperties(UserProperties userProperties2) {
            this.userProperties = userProperties2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SetUserRequest$UserProperties */
    public static class UserProperties {
        private String name;

        public UserProperties(String name2) {
            this.name = name2;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }
    }

    protected SetUserRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
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
    public static SetUserRequest m7487of(String userAccess, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        SetUserRequest setUserRequest = new SetUserRequest(new Body(userAccess, null), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return setUserRequest;
    }

    public static SetUserRequest ofWithName(String userName, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        SetUserRequest setUserRequest = new SetUserRequest(new Body(null, userName), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return setUserRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.setUser((Body) this.body);
    }
}
