package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.view.WindowManager;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetStoreWidgets.WSWidget;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.Type;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.GetStore;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords.AdsApplicationVersionCodeProvider;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.V7Url;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.WSWidgetsUtils;
import p026rx.C0120S;
import p026rx.p027b.C0132p;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetUserRequest */
public class GetUserRequest extends C0044V7<GetStore, Body> {
    private final boolean accountMature;
    private boolean bypassServerCache;
    private final String clientUniqueId;
    private final ConnectivityManager connectivityManager;
    private final String filters;
    private final OkHttpClient httpClient;
    private final boolean isGooglePlayServicesAvailable;
    private final String partnerId;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final StoreCredentials storeCredentials;
    private final TokenInvalidator tokenInvalidator;
    private String url;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;
    private final WindowManager windowManager;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.store.GetUserRequest$Body */
    public static class Body extends BaseBody {
        private WidgetsArgs widgetsArgs;

        public Body(WidgetsArgs widgetsArgs2) {
            this.widgetsArgs = widgetsArgs2;
        }

        public WidgetsArgs getWidgetsArgs() {
            return this.widgetsArgs;
        }
    }

    public GetUserRequest(String url2, Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient2, Factory converterFactory, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, StoreCredentials storeCredentials2, String clientUniqueId2, boolean isGooglePlayServicesAvailable2, String partnerId2, boolean accountMature2, String filters2, SharedPreferences sharedPreferences1, Resources resources2, WindowManager windowManager2, ConnectivityManager connectivityManager2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        super(body, C0044V7.getHost(sharedPreferences2), httpClient2, converterFactory, bodyInterceptor, tokenInvalidator2);
        this.url = url2;
        this.httpClient = httpClient2;
        this.tokenInvalidator = tokenInvalidator2;
        this.storeCredentials = storeCredentials2;
        this.clientUniqueId = clientUniqueId2;
        this.isGooglePlayServicesAvailable = isGooglePlayServicesAvailable2;
        this.partnerId = partnerId2;
        this.accountMature = accountMature2;
        this.filters = filters2;
        this.sharedPreferences = sharedPreferences1;
        this.resources = resources2;
        this.windowManager = windowManager2;
        this.connectivityManager = connectivityManager2;
        this.versionCodeProvider = versionCodeProvider2;
    }

    /* renamed from: of */
    public static GetUserRequest m7590of(String url2, StoreCredentials storeCredentials2, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient2, Factory converterFactory, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, Resources resources2, WindowManager windowManager2, String clientUniqueId2, boolean isGooglePlayServicesAvailable2, String partnerId2, boolean accountMature2, String filters2, ConnectivityManager connectivityManager2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        StoreCredentials storeCredentials3 = storeCredentials2;
        BodyInterceptor<BaseBody> bodyInterceptor2 = bodyInterceptor;
        OkHttpClient okHttpClient = httpClient2;
        Factory factory = converterFactory;
        TokenInvalidator tokenInvalidator3 = tokenInvalidator2;
        SharedPreferences sharedPreferences3 = sharedPreferences2;
        SharedPreferences sharedPreferences4 = sharedPreferences2;
        Resources resources3 = resources2;
        WindowManager windowManager3 = windowManager2;
        String str = clientUniqueId2;
        boolean z = isGooglePlayServicesAvailable2;
        String str2 = partnerId2;
        boolean z2 = accountMature2;
        String str3 = filters2;
        ConnectivityManager connectivityManager3 = connectivityManager2;
        AdsApplicationVersionCodeProvider adsApplicationVersionCodeProvider = versionCodeProvider2;
        GetUserRequest getUserRequest = new GetUserRequest(new V7Url(url2).remove("user/get").get(), new Body(WidgetsArgs.createDefault(resources2, windowManager2)), bodyInterceptor2, okHttpClient, factory, tokenInvalidator3, sharedPreferences3, storeCredentials3, str, z, str2, z2, str3, sharedPreferences4, resources3, windowManager3, connectivityManager3, adsApplicationVersionCodeProvider);
        return getUserRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetStore> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.getUser(this.url, (Body) this.body, bypassCache).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2918f<Object,Object>(this));
    }

    /* renamed from: b */
    static /* synthetic */ GetStore m7589b(GetStore getStore, List wsWidgets) {
        return getStore;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13529a(GetStore getStore) {
        return loadGetStoreWidgets(getStore).mo3669j(new C2920h(getStore));
    }

    public C0120S<GetStore> observe(boolean bypassCache, boolean bypassServerCache2) {
        this.bypassServerCache = bypassServerCache2;
        return super.observe(bypassCache, bypassServerCache2);
    }

    /* access modifiers changed from: protected */
    public C0120S<List<WSWidget>> loadGetStoreWidgets(GetStore getStoreWidgets) {
        return C0120S.m629a((Iterable<? extends T>) getStoreWidgets.getNodes().getWidgets().getDataList().getList()).mo3616a(Schedulers.m776io()).mo3660f((C0132p<? super T, ? extends C0120S<? extends R>>) new C2917e<Object,Object>(this)).mo3675m().mo3666h((C0132p<? super T, ? extends Iterable<? extends R>>) new C2919g<Object,Object>(getStoreWidgets)).mo3675m().mo3647d();
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo13528a(WSWidget wsWidget) {
        WSWidget wSWidget = wsWidget;
        WSWidgetsUtils widgetsUtils = new WSWidgetsUtils();
        StoreCredentials storeCredentials2 = this.storeCredentials;
        String str = this.clientUniqueId;
        boolean z = this.isGooglePlayServicesAvailable;
        String str2 = this.partnerId;
        boolean z2 = this.accountMature;
        BodyInterceptor bodyInterceptor = this.bodyInterceptor;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        String str3 = this.filters;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        Resources resources2 = this.resources;
        Resources resources3 = resources2;
        WSWidgetsUtils widgetsUtils2 = widgetsUtils;
        WindowManager windowManager2 = this.windowManager;
        return widgetsUtils2.loadWidgetNode(wSWidget, storeCredentials2, false, str, z, str2, z2, bodyInterceptor, okHttpClient, factory, str3, tokenInvalidator2, sharedPreferences2, resources3, windowManager2, this.connectivityManager, this.versionCodeProvider, this.bypassServerCache, Type.ADS.getPerLineCount(resources2, windowManager2), Collections.emptyList());
    }
}
