package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListAppCoinsCampaigns;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetAppCoinsCampaignsRequest */
public class GetAppCoinsCampaignsRequest extends C0044V7<ListAppCoinsCampaigns, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetAppCoinsCampaignsRequest$Body */
    public static class Body extends BaseBody implements Endless {
        private int limit;
        private int offset;
        private String packageName;
        private Integer vercode;

        public Body(int offset2, int limit2) {
            this.offset = offset2;
            this.limit = limit2;
        }

        public Body(String packageName2, int vercode2) {
            this.packageName = packageName2;
            this.vercode = Integer.valueOf(vercode2);
            this.limit = 5;
            this.offset = 0;
        }

        public int getOffset() {
            return this.offset;
        }

        public void setOffset(int offset2) {
            this.offset = offset2;
        }

        public Integer getLimit() {
            return Integer.valueOf(this.limit);
        }

        public String getPackageName() {
            return this.packageName;
        }

        public Integer getVercode() {
            return this.vercode;
        }
    }

    public GetAppCoinsCampaignsRequest(Body body, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* access modifiers changed from: protected */
    public C0120S<ListAppCoinsCampaigns> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        B b = this.body;
        return interfaces.getAppCoinsAds((Body) b, bypassCache, ((Body) b).getLimit().intValue());
    }
}
