package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.PostDeleteRequest */
public class PostDeleteRequest extends C0044V7<BaseV7Response, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.PostDeleteRequest$Body */
    public static class Body extends BaseBody {
        @JsonProperty("card_uid")
        private String postId;

        public Body(String postId2) {
            this.postId = postId2;
        }

        public String getPostId() {
            return this.postId;
        }

        public void setPostId(String postId2) {
            this.postId = postId2;
        }
    }

    protected PostDeleteRequest(Body body, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static PostDeleteRequest m7481of(String postId, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient okhttp, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        PostDeleteRequest postDeleteRequest = new PostDeleteRequest(new Body(postId), okhttp, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        return postDeleteRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.deletePost((Body) this.body, bypassCache);
    }
}
