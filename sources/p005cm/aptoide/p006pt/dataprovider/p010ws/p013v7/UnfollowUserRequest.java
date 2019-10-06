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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.UnfollowUserRequest */
public class UnfollowUserRequest extends C0044V7<BaseV7Response, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.UnfollowUserRequest$Body */
    public static class Body extends BaseBody {
        private String action = "UNSUBSCRIBE";
        private Long userId;

        public Body(Long userId2) {
            this.userId = userId2;
        }

        public Long getUserId() {
            return this.userId;
        }

        public void setUserId(Long userId2) {
            this.userId = userId2;
        }

        public String getAction() {
            return this.action;
        }

        public void setAction(String action2) {
            this.action = action2;
        }
    }

    private UnfollowUserRequest(Body body, OkHttpClient okhttp, Factory converterFactory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, getHost(sharedPreferences), okhttp, converterFactory, bodyInterceptor, tokenInvalidator);
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
    public static UnfollowUserRequest m7490of(Long userId, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okhttp, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        UnfollowUserRequest unfollowUserRequest = new UnfollowUserRequest(new Body(userId), okhttp, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        return unfollowUserRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.unfollowUser((Body) this.body, bypassCache);
    }
}
