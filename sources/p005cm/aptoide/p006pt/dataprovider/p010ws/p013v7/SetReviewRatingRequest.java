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

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SetReviewRatingRequest */
public class SetReviewRatingRequest extends C0044V7<BaseV7Response, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SetReviewRatingRequest$Body */
    public static class Body extends BaseBody {
        private long review_id;
        private String vote;

        public Body(long reviewId, String vote2) {
            this.review_id = reviewId;
            this.vote = vote2;
        }

        public long getReview_id() {
            return this.review_id;
        }

        public void setReview_id(long review_id2) {
            this.review_id = review_id2;
        }

        public String getVote() {
            return this.vote;
        }

        public void setVote(String vote2) {
            this.vote = vote2;
        }
    }

    protected SetReviewRatingRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
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
    public static SetReviewRatingRequest m7484of(long reviewId, boolean helpful, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        SetReviewRatingRequest setReviewRatingRequest = new SetReviewRatingRequest(new Body(reviewId, helpful ? "up" : "down"), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return setReviewRatingRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.setReviewVote((Body) this.body, true);
    }
}
