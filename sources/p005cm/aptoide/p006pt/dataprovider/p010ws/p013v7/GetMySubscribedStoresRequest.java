package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetMySubscribedStoresResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetMySubscribedStoresRequest */
public class GetMySubscribedStoresRequest extends C0044V7<GetMySubscribedStoresResponse, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetMySubscribedStoresRequest$Body */
    public static class Body extends BaseBody implements Endless {
        private Integer limit;
        private int offset;
        private Order order;
        private boolean refresh;
        Sort sort;

        /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.GetMySubscribedStoresRequest$Body$Sort */
        public enum Sort {
            added,
            latest,
            alpha,
            downloads,
            trending
        }

        public Sort getSort() {
            return this.sort;
        }

        public void setSort(Sort sort2) {
            this.sort = sort2;
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

        public void setLimit(Integer limit2) {
            this.limit = limit2;
        }

        public Order getOrder() {
            return this.order;
        }

        public void setOrder(Order order2) {
            this.order = order2;
        }

        public void setRefresh(boolean refresh2) {
            this.refresh = refresh2;
        }
    }

    public GetMySubscribedStoresRequest(BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(new Body(), C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* access modifiers changed from: protected */
    public C0120S<GetMySubscribedStoresResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getMySubscribedStores(bypassCache, (Body) this.body);
    }
}
