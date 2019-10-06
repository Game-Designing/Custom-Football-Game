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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.PostReviewRequest */
public class PostReviewRequest extends C0044V7<BaseV7Response, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.PostReviewRequest$Body */
    public static class Body extends BaseBody {
        private final boolean appInstalled;
        private String body;
        private String packageName;
        private Integer rating;
        private String storeName;

        public Body(String packageName2, String body2, Integer rating2, boolean appInstalled2) {
            this.packageName = packageName2;
            this.body = body2;
            this.rating = rating2;
            this.appInstalled = appInstalled2;
        }

        public Body(String storeName2, String packageName2, String body2, Integer rating2, boolean appInstalled2) {
            this.storeName = storeName2;
            this.packageName = packageName2;
            this.body = body2;
            this.rating = rating2;
            this.appInstalled = appInstalled2;
        }

        public String getStoreName() {
            return this.storeName;
        }

        public void setStoreName(String storeName2) {
            this.storeName = storeName2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        public String getBody() {
            return this.body;
        }

        public void setBody(String body2) {
            this.body = body2;
        }

        public Integer getRating() {
            return this.rating;
        }

        public void setRating(Integer rating2) {
            this.rating = rating2;
        }

        public boolean isAppInstalled() {
            return this.appInstalled;
        }
    }

    protected PostReviewRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
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
    public static PostReviewRequest m7483of(String storeName, String packageName, String textBody, Integer rating, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, boolean appInstalled, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body body = new Body(storeName, packageName, textBody, rating, appInstalled);
        PostReviewRequest postReviewRequest = new PostReviewRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return postReviewRequest;
    }

    /* renamed from: of */
    public static PostReviewRequest m7482of(String packageName, String textBody, Integer rating, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, boolean appInstalled, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        String str = packageName;
        String str2 = textBody;
        Integer num = rating;
        PostReviewRequest postReviewRequest = new PostReviewRequest(new Body(packageName, textBody, rating, appInstalled), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return postReviewRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.postReview((Body) this.body, true);
    }
}
