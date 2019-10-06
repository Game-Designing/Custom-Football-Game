package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mopub.common.Constants;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.SetComment;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.PostCommentForStore */
public class PostCommentForStore extends C0044V7<SetComment, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.PostCommentForStore$Body */
    public static class Body extends BaseBody {
        private String body;
        @JsonProperty("comment_id")
        private Long previousCommentId;
        private long storeId;

        public Body(long storeId2, String text, long previousCommentId2) {
            this(storeId2, text);
            this.previousCommentId = Long.valueOf(previousCommentId2);
        }

        public Body(long storeId2, String text) {
            this.storeId = storeId2;
            this.body = text;
        }

        public long getStoreId() {
            return this.storeId;
        }

        public void setStoreId(long storeId2) {
            this.storeId = storeId2;
        }

        public Long getPreviousCommentId() {
            return this.previousCommentId;
        }

        public void setPreviousCommentId(Long previousCommentId2) {
            this.previousCommentId = previousCommentId2;
        }

        public String getBody() {
            return this.body;
        }

        public void setBody(String body2) {
            this.body = body2;
        }
    }

    private PostCommentForStore(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
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
    public static PostCommentForStore m7594of(long storeId, String text, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        PostCommentForStore postCommentForStore = new PostCommentForStore(new Body(storeId, text), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return postCommentForStore;
    }

    /* renamed from: of */
    public static PostCommentForStore m7593of(long storeId, long previousCommentId, String text, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body body = new Body(storeId, text, previousCommentId);
        PostCommentForStore postCommentForStore = new PostCommentForStore(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return postCommentForStore;
    }

    /* access modifiers changed from: protected */
    public C0120S<SetComment> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.postStoreComment((Body) this.body, true);
    }
}
