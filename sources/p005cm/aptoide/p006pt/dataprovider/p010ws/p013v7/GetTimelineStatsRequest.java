package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetTimelineStatsRequest */
public class GetTimelineStatsRequest extends C0044V7<TimelineStats, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetTimelineStatsRequest$Body */
    public static class Body extends BaseBody {
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
    }

    protected GetTimelineStatsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static GetTimelineStatsRequest m7466of(BodyInterceptor<BaseBody> bodyInterceptor, Long userId, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetTimelineStatsRequest getTimelineStatsRequest = new GetTimelineStatsRequest(new Body(userId), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getTimelineStatsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<TimelineStats> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getTimelineStats((Body) this.body, bypassCache);
    }
}
