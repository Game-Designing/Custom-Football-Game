package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.WindowManager;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.ListApps;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.managed.ManagerPreferences;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListAppsRequest */
public class ListAppsRequest extends C0044V7<ListApps, Body> {
    private static final int LINES_PER_REQUEST = 6;
    private String url;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListAppsRequest$Body */
    public static class Body extends BaseBody implements Endless {
        private Long groupId;
        private Integer limit;
        private String notApkTags;
        private int offset;
        private Sort sort;
        private Long storeId;
        private String storePassSha1;
        private String storeUser;

        public Body(StoreCredentials storeCredentials, SharedPreferences sharedPreferences) {
            this.storeUser = storeCredentials.getUsername();
            this.storePassSha1 = storeCredentials.getPasswordSha1();
            setNotApkTags(sharedPreferences);
        }

        public Body(StoreCredentials storeCredentials, int limit2, SharedPreferences sharedPreferences) {
            this.storeUser = storeCredentials.getUsername();
            this.storePassSha1 = storeCredentials.getPasswordSha1();
            this.limit = Integer.valueOf(limit2);
            setNotApkTags(sharedPreferences);
        }

        public Body(StoreCredentials storeCredentials, int limit2, SharedPreferences sharedPreferences, Sort sort2) {
            this.storeUser = storeCredentials.getUsername();
            this.storePassSha1 = storeCredentials.getPasswordSha1();
            this.limit = Integer.valueOf(limit2);
            this.sort = sort2;
            setNotApkTags(sharedPreferences);
        }

        public Body(StoreCredentials storeCredentials, Long groupId2, int limit2, SharedPreferences sharedPreferences, Sort sort2) {
            this.storeUser = storeCredentials.getUsername();
            this.storePassSha1 = storeCredentials.getPasswordSha1();
            this.groupId = groupId2;
            this.limit = Integer.valueOf(limit2);
            this.sort = sort2;
            setNotApkTags(sharedPreferences);
        }

        public Long getStoreId() {
            return this.storeId;
        }

        public void setStoreId(long storeId2) {
            this.storeId = Long.valueOf(storeId2);
        }

        public String getStoreUser() {
            return this.storeUser;
        }

        public String getStorePassSha1() {
            return this.storePassSha1;
        }

        public String getNotApkTags() {
            return this.notApkTags;
        }

        private void setNotApkTags(SharedPreferences sharedPreferences) {
            if (ManagerPreferences.getUpdatesFilterAlphaBetaKey(sharedPreferences)) {
                this.notApkTags = "alpha,beta";
            }
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

        public Long getGroupId() {
            return this.groupId;
        }

        public void setGroupId(Long groupId2) {
            this.groupId = groupId2;
        }

        public Sort getSort() {
            return this.sort;
        }

        public void setSort(Sort sort2) {
            this.sort = sort2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.ListAppsRequest$Sort */
    public enum Sort {
        latest,
        trending7d,
        trending30d
    }

    public ListAppsRequest(String url2, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.url = url2;
    }

    public ListAppsRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(body, C0044V7.getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static ListAppsRequest ofAction(String url2, StoreCredentials storeCredentials, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources, WindowManager windowManager) {
        StoreCredentials storeCredentials2 = storeCredentials;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        String str = url2;
        V7Url listAppsV7Url = new V7Url(url2).remove("listApps");
        if (listAppsV7Url.containsLimit()) {
            ListAppsRequest listAppsRequest = new ListAppsRequest(listAppsV7Url.get(), new Body(storeCredentials2, sharedPreferences2), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
            return listAppsRequest;
        }
        ListAppsRequest listAppsRequest2 = new ListAppsRequest(listAppsV7Url.get(), new Body(storeCredentials2, Type.APPS_GROUP.getPerLineCount(resources, windowManager) * 6, sharedPreferences2), bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return listAppsRequest2;
    }

    /* access modifiers changed from: protected */
    public C0120S<ListApps> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        String str = this.url;
        if (str == null) {
            str = "";
        }
        return interfaces.listApps(str, (Body) this.body, bypassCache);
    }
}
