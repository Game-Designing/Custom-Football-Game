package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import android.text.TextUtils;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.ListStores;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.ListStoresRequest */
public class ListStoresRequest extends C0044V7<ListStores, Body> {
    static final String STORT_BY_DOWNLOADS = "downloads7d";
    private String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.ListStoresRequest$Body */
    public static class Body extends BaseBody implements Endless {
        /* access modifiers changed from: private */
        public Integer limit;
        private int offset;

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

    private ListStoresRequest(String url2, Body body, String baseHost, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator) {
        this(body, baseHost, bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        this.url = url2;
    }

    private ListStoresRequest(Body body, String baseHost, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator) {
        super(body, baseHost, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static ListStoresRequest ofTopStores(int offset, int limit, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        Body baseBody = new Body();
        baseBody.setOffset(offset);
        baseBody.limit = Integer.valueOf(limit);
        ListStoresRequest listStoresRequest = new ListStoresRequest(baseBody, C0044V7.getHost(sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return listStoresRequest;
    }

    public static ListStoresRequest ofAction(String url2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        String url3 = url2.replace("listStores", "");
        String str = "/";
        if (!url3.startsWith(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(url3);
            url3 = sb.toString();
        }
        ListStoresRequest listStoresRequest = new ListStoresRequest(url3, new Body(), C0044V7.getHost(sharedPreferences), bodyInterceptor, httpClient, converterFactory, tokenInvalidator);
        return listStoresRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<ListStores> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        if (!TextUtils.isEmpty(this.url)) {
            return interfaces.listStores(this.url, (Body) this.body, bypassCache);
        }
        return interfaces.listTopStores(STORT_BY_DOWNLOADS, 10, (Body) this.body, bypassCache);
    }
}
