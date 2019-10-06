package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetRecommendedRequest */
public class GetRecommendedRequest extends C0044V7<ListApps, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetRecommendedRequest$Body */
    public static class Body extends BaseBody implements Endless {
        private Integer limit;
        private int offset;
        private String packageName;
        private String section;

        public Body(int limit2, String packageName2) {
            this.limit = Integer.valueOf(limit2);
            this.packageName = packageName2;
        }

        public Body(int limit2, String packageName2, String section2) {
            this.limit = Integer.valueOf(limit2);
            this.packageName = packageName2;
            this.section = section2;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setOffset(int offset2) {
            this.offset = offset2;
        }

        public Integer getLimit() {
            return this.limit;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public void setPackageName(String packageName2) {
            this.packageName = packageName2;
        }

        public String getSection() {
            return this.section;
        }

        public void setSection(String section2) {
            this.section = section2;
        }
    }

    public GetRecommendedRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* access modifiers changed from: protected */
    public C0120S<ListApps> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getRecommended((Body) this.body, bypassCache);
    }
}
