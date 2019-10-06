package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.home;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.Endless;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.WSWidgetsUtils;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.WidgetsArgs;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.home.GetHomeBundlesRequest */
public class GetHomeBundlesRequest extends C0044V7<GetStoreWidgets, Body> {
    private final boolean accountMature;
    private boolean bypassServerCache;
    private final String clientUniqueId;
    private final ConnectivityManager connectivityManager;
    private final String filters;
    private final boolean isGooglePlayServicesAvailable;
    private final List<String> packageNames;
    private final String partnerId;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentials storeCredentials;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;
    private final WSWidgetsUtils widgetsUtils;
    private final WindowManager windowManager;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.home.GetHomeBundlesRequest$Body */
    public static class Body extends BaseBody implements Endless {
        private StoreContext context = StoreContext.home;
        private Integer limit;
        private int offset;
        private long storeId = 15;
        private WidgetsArgs widgetsArgs;

        public Body(Integer limit2, int offset2, WidgetsArgs widgetsArgs2) {
            this.limit = limit2;
            this.offset = offset2;
            this.widgetsArgs = widgetsArgs2;
        }

        public StoreContext getContext() {
            return this.context;
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

        public long getStoreId() {
            return this.storeId;
        }

        public void setStoreId(long storeId2) {
            this.storeId = storeId2;
        }

        public WidgetsArgs getWidgetsArgs() {
            return this.widgetsArgs;
        }

        public void setWidgetsArgs(WidgetsArgs widgetsArgs2) {
            this.widgetsArgs = widgetsArgs2;
        }
    }

    private GetHomeBundlesRequest(Body body, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences2, WSWidgetsUtils widgetsUtils2, StoreCredentials storeCredentials2, String clientUniqueId2, boolean isGooglePlayServicesAvailable2, String partnerId2, boolean accountMature2, String filters2, Resources resources2, WindowManager windowManager2, ConnectivityManager connectivityManager2, AdsApplicationVersionCodeProvider versionCodeProvider2, List<String> packageNames2) {
        super(body, C0044V7.getHost(sharedPreferences2), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.widgetsUtils = widgetsUtils2;
        this.storeCredentials = storeCredentials2;
        this.clientUniqueId = clientUniqueId2;
        this.isGooglePlayServicesAvailable = isGooglePlayServicesAvailable2;
        this.partnerId = partnerId2;
        this.accountMature = accountMature2;
        this.filters = filters2;
        this.sharedPreferences = sharedPreferences2;
        this.resources = resources2;
        this.windowManager = windowManager2;
        this.connectivityManager = connectivityManager2;
        this.versionCodeProvider = versionCodeProvider2;
        this.packageNames = packageNames2;
    }

    /* renamed from: of */
    public static GetHomeBundlesRequest m7549of(int limit, int offset, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences2, WSWidgetsUtils widgetsUtils2, StoreCredentials storeCredentials2, String clientUniqueId2, boolean isGooglePlayServicesAvailable2, String partnerId2, boolean accountMature2, String filters2, Resources resources2, WindowManager windowManager2, ConnectivityManager connectivityManager2, AdsApplicationVersionCodeProvider versionCodeProvider2, List<String> packageNames2) {
        BodyInterceptor bodyInterceptor2 = bodyInterceptor;
        TokenInvalidator tokenInvalidator2 = tokenInvalidator;
        SharedPreferences sharedPreferences3 = sharedPreferences2;
        WSWidgetsUtils wSWidgetsUtils = widgetsUtils2;
        StoreCredentials storeCredentials3 = storeCredentials2;
        String str = clientUniqueId2;
        boolean z = isGooglePlayServicesAvailable2;
        String str2 = partnerId2;
        boolean z2 = accountMature2;
        String str3 = filters2;
        Resources resources3 = resources2;
        WindowManager windowManager3 = windowManager2;
        ConnectivityManager connectivityManager3 = connectivityManager2;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = versionCodeProvider2;
        List<String> list = packageNames2;
        Body body = r3;
        OkHttpClient okHttpClient = httpClient;
        Factory factory = converterFactory;
        Body body2 = new Body(Integer.valueOf(limit), offset, WidgetsArgs.createDefault(resources2, windowManager2));
        GetHomeBundlesRequest getHomeBundlesRequest = new GetHomeBundlesRequest(body, okHttpClient, factory, bodyInterceptor2, tokenInvalidator2, sharedPreferences3, wSWidgetsUtils, storeCredentials3, str, z, str2, z2, str3, resources3, windowManager3, connectivityManager3, adsApplicationVersionCodeProvider, list);
        return getHomeBundlesRequest;
    }

    private C0120S<List<WSWidget>> loadAppsInBundles(GetStoreWidgets getStoreWidgets, boolean bypassCache) {
        return C0120S.m629a((Iterable<? extends T>) getStoreWidgets.getDataList().getList()).mo3616a(Schedulers.m776io()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2884a<Object,Object>(this, bypassCache)).mo3675m().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) new C2885b<Object,Object>(getStoreWidgets)).mo3675m().mo3647d();
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13389a(boolean bypassCache, WSWidget wsWidget) {
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
        return wSWidgetsUtils2.loadWidgetNode(wSWidget, storeCredentials2, z, str, z2, str2, z3, bodyInterceptor, httpClient, factory, str3, tokenInvalidator, sharedPreferences2, resources2, windowManager2, this.connectivityManager, this.versionCodeProvider, this.bypassServerCache, Type.ADS.getPerLineCount(resources3, windowManager2) * 3, this.packageNames);
    }

    public C0120S<GetStoreWidgets> observe(boolean bypassCache, boolean bypassServerCache2) {
        this.bypassServerCache = bypassServerCache2;
        return super.observe(bypassCache, bypassServerCache2);
    }

    /* access modifiers changed from: protected */
    public C0120S<GetStoreWidgets> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getHomeBundles((Body) this.body, bypassCache).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2886c<Object,Object>(this, bypassCache));
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13390a(boolean bypassCache, GetStoreWidgets getStoreWidgets) {
        return loadAppsInBundles(getStoreWidgets, bypassCache).mo3669j(new C2887d(getStoreWidgets));
    }

    /* renamed from: b */
    static /* synthetic */ GetStoreWidgets m7548b(GetStoreWidgets getStoreWidgets, List wsWidgets) {
        return getStoreWidgets;
    }
}
