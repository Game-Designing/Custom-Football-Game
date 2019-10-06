package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBodyWithStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.V7Url;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.WSWidgetsUtils;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreWidgetsRequest */
public class GetStoreWidgetsRequest extends BaseRequestWithStore<GetStoreWidgets, Body> {
    private final boolean accountMature;
    private boolean bypassServerCache;
    private final String clientUniqueId;
    private final ConnectivityManager connectivityManager;
    private final String filters;
    private final boolean isGooglePlayServicesAvailable;
    private final String partnerId;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentials storeCredentials;
    private final String url;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;
    private final WSWidgetsUtils widgetsUtils;
    private final WindowManager windowManager;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetStoreWidgetsRequest$Body */
    public static class Body extends BaseBodyWithStore implements Endless {
        private StoreContext context;
        private Integer limit;
        private int offset;
        private String storeName;
        private WidgetsArgs widgetsArgs;

        public Body(StoreCredentials storeCredentials, WidgetsArgs widgetsArgs2) {
            super(storeCredentials);
            this.widgetsArgs = widgetsArgs2;
            this.limit = Integer.valueOf(5);
        }

        public Body(StoreCredentials storeCredentials, WidgetsArgs widgetsArgs2, int limit2) {
            super(storeCredentials);
            this.widgetsArgs = widgetsArgs2;
            this.limit = Integer.valueOf(limit2);
        }

        public Body(StoreCredentials storeCredentials, WidgetsArgs widgetsArgs2, StoreContext storeContext, String storeName2) {
            super(storeCredentials);
            this.widgetsArgs = widgetsArgs2;
            this.context = storeContext;
            this.storeName = storeName2;
        }

        public WidgetsArgs getWidgetsArgs() {
            return this.widgetsArgs;
        }

        public StoreContext getContext() {
            return this.context;
        }

        public String getStoreName() {
            return this.storeName;
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

    public GetStoreWidgetsRequest(String url2, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences2, StoreCredentials storeCredentials2, String clientUniqueId2, boolean isGooglePlayServicesAvailable2, String partnerId2, boolean accountMature2, String filters2, Resources resources2, WindowManager windowManager2, ConnectivityManager connectivityManager2, AdsApplicationVersionCodeProvider versionCodeProvider2, WSWidgetsUtils widgetsUtils2) {
        super(body, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences2);
        this.url = url2;
        this.storeCredentials = storeCredentials2;
        this.clientUniqueId = clientUniqueId2;
        this.isGooglePlayServicesAvailable = isGooglePlayServicesAvailable2;
        this.partnerId = partnerId2;
        this.accountMature = accountMature2;
        this.filters = filters2;
        this.resources = resources2;
        this.windowManager = windowManager2;
        this.connectivityManager = connectivityManager2;
        this.versionCodeProvider = versionCodeProvider2;
        this.sharedPreferences = sharedPreferences2;
        this.widgetsUtils = widgetsUtils2;
    }

    public static GetStoreWidgetsRequest ofAction(String url2, StoreCredentials storeCredentials2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences2, Resources resources2, WindowManager windowManager2, String clientUniqueId2, boolean isGooglePlayServicesAvailable2, String partnerId2, boolean accountMature2, String filters2, ConnectivityManager connectivityManager2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        StoreCredentials storeCredentials3 = storeCredentials2;
        BodyInterceptor<BaseBody> bodyInterceptor2 = bodyInterceptor;
        OkHttpClient okHttpClient = httpClient;
        Factory factory = converterFactory;
        TokenInvalidator tokenInvalidator2 = tokenInvalidator;
        SharedPreferences sharedPreferences3 = sharedPreferences2;
        Resources resources3 = resources2;
        WindowManager windowManager3 = windowManager2;
        String str = clientUniqueId2;
        boolean z = isGooglePlayServicesAvailable2;
        String str2 = partnerId2;
        boolean z2 = accountMature2;
        String str3 = filters2;
        ConnectivityManager connectivityManager3 = connectivityManager2;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = versionCodeProvider2;
        Body body = new Body(storeCredentials2, WidgetsArgs.createDefault(resources2, windowManager2));
        String str4 = new V7Url(url2).remove("getStoreWidgets").get();
        WSWidgetsUtils wSWidgetsUtils = r0;
        WSWidgetsUtils wSWidgetsUtils2 = new WSWidgetsUtils();
        GetStoreWidgetsRequest getStoreWidgetsRequest = new GetStoreWidgetsRequest(str4, body, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, sharedPreferences3, storeCredentials3, str, z, str2, z2, str3, resources3, windowManager3, connectivityManager3, adsApplicationVersionCodeProvider, wSWidgetsUtils);
        return getStoreWidgetsRequest;
    }

    public static GetStoreWidgetsRequest ofAction(String url2, StoreCredentials storeCredentials2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences2, Resources resources2, WindowManager windowManager2, String clientUniqueId2, boolean isGooglePlayServicesAvailable2, String partnerId2, boolean accountMature2, String filters2, ConnectivityManager connectivityManager2, AdsApplicationVersionCodeProvider versionCodeProvider2, String storeName, StoreContext storeContext) {
        StoreCredentials storeCredentials3 = storeCredentials2;
        Factory factory = converterFactory;
        TokenInvalidator tokenInvalidator2 = tokenInvalidator;
        SharedPreferences sharedPreferences3 = sharedPreferences2;
        Resources resources3 = resources2;
        WindowManager windowManager3 = windowManager2;
        String str = clientUniqueId2;
        boolean z = isGooglePlayServicesAvailable2;
        String str2 = partnerId2;
        boolean z2 = accountMature2;
        String str3 = filters2;
        ConnectivityManager connectivityManager3 = connectivityManager2;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = versionCodeProvider2;
        BodyInterceptor<BaseBody> bodyInterceptor2 = bodyInterceptor;
        OkHttpClient okHttpClient = httpClient;
        Body body = new Body(storeCredentials2, WidgetsArgs.createDefault(resources2, windowManager2), storeContext, storeName);
        String str4 = new V7Url(url2).remove("getStoreWidgets").get();
        WSWidgetsUtils wSWidgetsUtils = r0;
        WSWidgetsUtils wSWidgetsUtils2 = new WSWidgetsUtils();
        GetStoreWidgetsRequest getStoreWidgetsRequest = new GetStoreWidgetsRequest(str4, body, bodyInterceptor2, okHttpClient, factory, tokenInvalidator2, sharedPreferences3, storeCredentials3, str, z, str2, z2, str3, resources3, windowManager3, connectivityManager3, adsApplicationVersionCodeProvider, wSWidgetsUtils);
        return getStoreWidgetsRequest;
    }

    public String getUrl() {
        return this.url;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetStoreWidgets> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getStoreWidgets(this.url, (Body) this.body, bypassCache).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2916d<Object,Object>(this, bypassCache));
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13523a(boolean bypassCache, GetStoreWidgets getStoreWidgets) {
        return loadGetStoreWidgets(getStoreWidgets, bypassCache).mo3669j(new C2914b(getStoreWidgets));
    }

    /* renamed from: b */
    static /* synthetic */ GetStoreWidgets m7585b(GetStoreWidgets getStoreWidgets, List wsWidgets) {
        return getStoreWidgets;
    }

    public C0120S<GetStoreWidgets> observe(boolean bypassCache, boolean bypassServerCache2) {
        this.bypassServerCache = bypassServerCache2;
        return super.observe(bypassCache, bypassServerCache2);
    }

    private C0120S<List<WSWidget>> loadGetStoreWidgets(GetStoreWidgets getStoreWidgets, boolean bypassCache) {
        return C0120S.m629a((Iterable<? extends T>) getStoreWidgets.getDataList().getList()).mo3616a(Schedulers.m776io()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2913a<Object,Object>(this, bypassCache)).mo3675m().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) new C2915c<Object,Object>(getStoreWidgets)).mo3675m().mo3647d();
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13522a(boolean bypassCache, WSWidget wsWidget) {
        boolean z = bypassCache;
        WSWidget wSWidget = wsWidget;
        WSWidgetsUtils wSWidgetsUtils = this.widgetsUtils;
        StoreCredentials storeCredentials2 = this.storeCredentials;
        String str = this.clientUniqueId;
        boolean z2 = this.isGooglePlayServicesAvailable;
        String str2 = this.partnerId;
        boolean z3 = this.accountMature;
        BodyInterceptor bodyInterceptor = this.bodyInterceptor;
        OkHttpClient httpClient = getHttpClient();
        Factory factory = this.converterFactory;
        String str3 = this.filters;
        TokenInvalidator tokenInvalidator = getTokenInvalidator();
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        Resources resources2 = this.resources;
        Resources resources3 = resources2;
        WSWidgetsUtils wSWidgetsUtils2 = wSWidgetsUtils;
        WindowManager windowManager2 = this.windowManager;
        return wSWidgetsUtils2.loadWidgetNode(wSWidget, storeCredentials2, z, str, z2, str2, z3, bodyInterceptor, httpClient, factory, str3, tokenInvalidator, sharedPreferences2, resources2, windowManager2, this.connectivityManager, this.versionCodeProvider, this.bypassServerCache, Type.ADS.getPerLineCount(resources3, windowManager2), Collections.emptyList());
    }
}
