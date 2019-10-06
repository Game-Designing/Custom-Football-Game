package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.search.ListSearchApps;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListSearchAppsRequest */
public class ListSearchAppsRequest extends C0044V7<ListSearchApps, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListSearchAppsRequest$Body */
    public static class Body extends BaseBodyWithAlphaBetaKey implements Endless {
        private Integer limit;
        private int offset;
        private String query;
        private List<Long> storeIds;
        private List<String> storeNames;
        private HashMapNotNull<String, List<String>> storesAuthMap;
        private Boolean trusted;

        public Body(Integer limit2, int offset2, String query2, List<Long> storeIds2, HashMapNotNull<String, List<String>> storesAuthMap2, Boolean trusted2, SharedPreferences sharedPreferences) {
            super(sharedPreferences);
            this.limit = limit2;
            this.offset = offset2;
            this.query = query2;
            this.storeIds = storeIds2;
            this.storesAuthMap = storesAuthMap2;
            this.trusted = trusted2;
        }

        public Body(Integer limit2, int offset2, String query2, List<Long> storeIds2, HashMapNotNull<String, List<String>> storesAuthMap2, Boolean trusted2, SharedPreferences sharedPreferences, Boolean isMature) {
            super(sharedPreferences);
            this.limit = limit2;
            this.offset = offset2;
            this.query = query2;
            this.storeIds = storeIds2;
            this.storesAuthMap = storesAuthMap2;
            this.trusted = trusted2;
            setMature(isMature.booleanValue());
        }

        public Body(Integer limit2, int offset2, String query2, List<String> storeNames2, Boolean trusted2, SharedPreferences sharedPreferences) {
            super(sharedPreferences);
            this.limit = limit2;
            this.offset = offset2;
            this.query = query2;
            this.storeNames = storeNames2;
            this.trusted = trusted2;
        }

        public Body(Integer limit2, int offset2, String query2, HashMapNotNull<String, List<String>> storesAuthMap2, List<String> storeNames2, Boolean trusted2, SharedPreferences sharedPreferences) {
            super(sharedPreferences);
            this.limit = limit2;
            this.offset = offset2;
            this.query = query2;
            this.storesAuthMap = storesAuthMap2;
            this.storeNames = storeNames2;
            this.trusted = trusted2;
        }

        public Body(Integer limit2, int offset2, String query2, Boolean trusted2, SharedPreferences sharedPreferences) {
            super(sharedPreferences);
            this.limit = limit2;
            this.offset = offset2;
            this.query = query2;
            this.trusted = trusted2;
        }

        public Body(Integer limit2, int offset2, String query2, Boolean trusted2, SharedPreferences sharedPreferences, Boolean isMature) {
            super(sharedPreferences);
            this.limit = limit2;
            this.offset = offset2;
            this.query = query2;
            this.trusted = trusted2;
            setMature(isMature.booleanValue());
        }

        public String getQuery() {
            return this.query;
        }

        public List<Long> getStoreIds() {
            return this.storeIds;
        }

        public List<String> getStoreNames() {
            return this.storeNames;
        }

        public HashMapNotNull<String, List<String>> getStoresAuthMap() {
            return this.storesAuthMap;
        }

        public Boolean getTrusted() {
            return this.trusted;
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
    }

    private ListSearchAppsRequest(Body body, String baseHost, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    /* renamed from: of */
    public static ListSearchAppsRequest m7479of(String query, String storeName, int offset, HashMapNotNull<String, List<String>> subscribedStoresAuthMap, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body body;
        HashMapNotNull<String, List<String>> hashMapNotNull = subscribedStoresAuthMap;
        List<String> stores = null;
        if (storeName != null) {
            stores = Collections.singletonList(storeName);
        }
        if (hashMapNotNull == null || !hashMapNotNull.containsKey(storeName)) {
            body = new Body(Integer.valueOf(10), offset, query, stores, Boolean.valueOf(false), sharedPreferences);
        } else {
            HashMapNotNull hashMapNotNull2 = new HashMapNotNull();
            hashMapNotNull2.put(storeName, hashMapNotNull.get(storeName));
            body = new Body(Integer.valueOf(10), offset, query, hashMapNotNull2, stores, Boolean.valueOf(false), sharedPreferences);
        }
        ListSearchAppsRequest listSearchAppsRequest = new ListSearchAppsRequest(body, C0044V7.getHost(sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return listSearchAppsRequest;
    }

    /* renamed from: of */
    public static ListSearchAppsRequest m7477of(String query, int offset, boolean addSubscribedStores, List<Long> subscribedStoresIds, HashMapNotNull<String, List<String>> subscribedStoresAuthMap, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Boolean valueOf = Boolean.valueOf(false);
        Integer valueOf2 = Integer.valueOf(10);
        if (addSubscribedStores) {
            Body body = new Body(valueOf2, offset, query, subscribedStoresIds, subscribedStoresAuthMap, valueOf, sharedPreferences);
            ListSearchAppsRequest listSearchAppsRequest = new ListSearchAppsRequest(body, C0044V7.getHost(sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
            return listSearchAppsRequest;
        }
        Body body2 = new Body(valueOf2, offset, query, valueOf, sharedPreferences);
        ListSearchAppsRequest listSearchAppsRequest2 = new ListSearchAppsRequest(body2, C0044V7.getHost(sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return listSearchAppsRequest2;
    }

    /* renamed from: of */
    public static ListSearchAppsRequest m7478of(String query, int offset, boolean addSubscribedStores, boolean trustedOnly, List<Long> subscribedStoresIds, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Boolean isMature) {
        Integer valueOf = Integer.valueOf(10);
        if (addSubscribedStores) {
            Body body = new Body(valueOf, offset, query, subscribedStoresIds, null, Boolean.valueOf(trustedOnly), sharedPreferences, isMature);
            ListSearchAppsRequest listSearchAppsRequest = new ListSearchAppsRequest(body, C0044V7.getHost(sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
            return listSearchAppsRequest;
        }
        Body body2 = new Body(valueOf, offset, query, Boolean.valueOf(trustedOnly), sharedPreferences, isMature);
        ListSearchAppsRequest listSearchAppsRequest2 = new ListSearchAppsRequest(body2, C0044V7.getHost(sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return listSearchAppsRequest2;
    }

    /* access modifiers changed from: protected */
    public C0120S<ListSearchApps> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.listSearchApps((Body) this.body, bypassCache);
    }
}
