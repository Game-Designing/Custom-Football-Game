package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.post;

import android.content.SharedPreferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.PostRequest */
public class PostRequest extends C0044V7<PostInTimelineResponse, PostRequestBody> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.post.PostRequest$PostRequestBody */
    public static class PostRequestBody extends BaseBody {
        private String content;
        @JsonProperty("package_name")
        private String packageName;
        private String url;

        public PostRequestBody(String url2, String content2, String packageName2) {
            this.url = url2;
            this.content = content2;
            this.packageName = packageName2;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url2) {
            this.url = url2;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content2) {
            this.content = content2;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }
    }

    public PostRequest(String baseHost, PostRequestBody body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static PostRequest m7571of(String url, String content, String packageName, SharedPreferences sharedPreferences, BodyInterceptor bodyInterceptor, OkHttpClient okHttpClient, Factory converter, TokenInvalidator tokenInvalidator) {
        PostRequest postRequest = new PostRequest(C0044V7.getHost(sharedPreferences), new PostRequestBody(url, content, packageName), bodyInterceptor, okHttpClient, converter, tokenInvalidator);
        return postRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<PostInTimelineResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.postInTimeline(bypassCache, (PostRequestBody) this.body);
    }
}
