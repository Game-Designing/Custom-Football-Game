package p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.aptwords;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.mopub.network.ImpressionData;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.ads.AdNetworkUtils;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p007v2.GetAdsResponse.C2842Ad;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.dataprovider.util.referrer.ReferrerUtils;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v2.aptwords.GetAdsRequest */
public class GetAdsRequest extends Aptwords<GetAdsResponse> {
    private static String forcedCountry = null;
    private String categories;
    private final String clientUniqueId;
    private ConnectivityManager connectivityManager;
    private String excludedNetworks;
    private String excludedPackage;
    private final boolean googlePlayServicesAvailable;
    private String groupPackageName;
    private String keyword;
    private Integer limit;
    private Location location;
    private boolean mature;
    private final String oemid;
    private String packageName;

    /* renamed from: q */
    private final String f6093q;
    private String repo;
    private Resources resources;
    private final SharedPreferences sharedPreferences;
    private final AdsApplicationVersionCodeProvider versionCodeProvider;

    private GetAdsRequest(String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, Factory converterFactory, OkHttpClient httpClient, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        super(httpClient, converterFactory, sharedPreferences2);
        this.clientUniqueId = clientUniqueId2;
        this.googlePlayServicesAvailable = googlePlayServicesAvailable2;
        this.oemid = oemid2;
        this.mature = mature2;
        this.f6093q = q;
        this.sharedPreferences = sharedPreferences2;
        this.connectivityManager = connectivityManager2;
        this.resources = resources2;
        this.versionCodeProvider = versionCodeProvider2;
    }

    public static String getForcedCountry() {
        return forcedCountry;
    }

    public static void setForcedCountry(String forcedCountry2) {
        forcedCountry = forcedCountry2;
    }

    public static GetAdsRequest ofHomepage(String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, Resources resources2, ConnectivityManager connectivityManager2, AdsApplicationVersionCodeProvider versionCodeProvider2, int limit2) {
        return m7437of(Location.homepage, Integer.valueOf(limit2), clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
    }

    /* renamed from: of */
    private static GetAdsRequest m7437of(Location location2, Integer limit2, String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        return m7438of(location2, "__NULL__", limit2, clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
    }

    /* renamed from: of */
    public static GetAdsRequest m7438of(Location location2, String keyword2, Integer limit2, String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        GetAdsRequest adsRequest = new GetAdsRequest(clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, converterFactory, httpClient, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
        Location location3 = location2;
        adsRequest.setLocation(location2);
        String str = keyword2;
        adsRequest.setKeyword(keyword2);
        Integer num = limit2;
        adsRequest.setLimit(limit2);
        return adsRequest;
    }

    public static GetAdsRequest ofHomepageMore(String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        return m7437of(Location.homepage, Integer.valueOf(50), clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
    }

    public static GetAdsRequest ofAppviewOrganic(String packageName2, String storeName, String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        GetAdsRequest getAdsRequest = ofPackageName(Location.appview, packageName2, clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
        String str = storeName;
        getAdsRequest.setRepo(storeName);
        String str2 = packageName2;
        getAdsRequest.setGroupPackageName(packageName2);
        return getAdsRequest;
    }

    private static GetAdsRequest ofPackageName(Location location2, String packageName2, String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        String str = packageName2;
        GetAdsRequest getAdsRequest = m7437of(location2, Integer.valueOf(1), clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
        getAdsRequest.setPackageName(str);
        if (ReferrerUtils.excludedNetworks.containsKey(str)) {
            getAdsRequest.excludedNetworks = StringU.commaSeparatedValues((List) ReferrerUtils.excludedNetworks.get(str));
        }
        return getAdsRequest;
    }

    public static GetAdsRequest ofAppviewSuggested(List<String> keywords, String clientUniqueId2, boolean googlePlayServicesAvailable2, String excludedPackage2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        String str = excludedPackage2;
        GetAdsRequest getAdsRequest = m7437of(Location.middleappview, Integer.valueOf(1), clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
        getAdsRequest.setExcludedPackage(str);
        StringBuilder sb = new StringBuilder();
        List<String> list = keywords;
        sb.append(StringU.join((Iterable<?>) keywords, ","));
        sb.append(",__null__");
        getAdsRequest.setKeyword(sb.toString());
        getAdsRequest.setGroupPackageName(str);
        return getAdsRequest;
    }

    public static GetAdsRequest ofSearch(String query, String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        return m7438of(Location.search, query, Integer.valueOf(1), clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
    }

    public static GetAdsRequest ofSecondInstall(String packageName2, String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        return ofPackageName(Location.secondinstall, packageName2, clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
    }

    public static GetAdsRequest ofSecondTry(String packageName2, String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        return ofPackageName(Location.secondtry, packageName2, clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
    }

    public static GetAdsRequest ofFirstInstall(String clientUniqueId2, boolean googlePlayServicesAvailable2, String oemid2, int numberOfAds, boolean mature2, OkHttpClient httpClient, Factory converterFactory, String q, SharedPreferences sharedPreferences2, ConnectivityManager connectivityManager2, Resources resources2, AdsApplicationVersionCodeProvider versionCodeProvider2) {
        return m7437of(Location.firstinstall, Integer.valueOf(numberOfAds), clientUniqueId2, googlePlayServicesAvailable2, oemid2, mature2, httpClient, converterFactory, q, sharedPreferences2, connectivityManager2, resources2, versionCodeProvider2);
    }

    public String getClientUniqueId() {
        return this.clientUniqueId;
    }

    public boolean isGooglePlayServicesAvailable() {
        return this.googlePlayServicesAvailable;
    }

    public String getOemid() {
        return this.oemid;
    }

    public String getQ() {
        return this.f6093q;
    }

    public SharedPreferences getSharedPreferences() {
        return this.sharedPreferences;
    }

    public String getExcludedPackage() {
        return this.excludedPackage;
    }

    public void setExcludedPackage(String excludedPackage2) {
        this.excludedPackage = excludedPackage2;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location2) {
        this.location = location2;
    }

    public String getKeyword() {
        return this.keyword;
    }

    public void setKeyword(String keyword2) {
        this.keyword = keyword2;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public void setLimit(Integer limit2) {
        this.limit = limit2;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName2) {
        this.packageName = packageName2;
    }

    public String getRepo() {
        return this.repo;
    }

    public void setRepo(String repo2) {
        this.repo = repo2;
    }

    public String getCategories() {
        return this.categories;
    }

    public void setCategories(String categories2) {
        this.categories = categories2;
    }

    public String getExcludedNetworks() {
        return this.excludedNetworks;
    }

    public void setExcludedNetworks(String excludedNetworks2) {
        this.excludedNetworks = excludedNetworks2;
    }

    public boolean isMature() {
        return this.mature;
    }

    public void setMature(boolean mature2) {
        this.mature = mature2;
    }

    public ConnectivityManager getConnectivityManager() {
        return this.connectivityManager;
    }

    public void setConnectivityManager(ConnectivityManager connectivityManager2) {
        this.connectivityManager = connectivityManager2;
    }

    public Resources getResources() {
        return this.resources;
    }

    public void setResources(Resources resources2) {
        this.resources = resources2;
    }

    private String getGroupPackageName() {
        return this.groupPackageName;
    }

    private void setGroupPackageName(String groupPackageName2) {
        this.groupPackageName = groupPackageName2;
    }

    public AdsApplicationVersionCodeProvider getVersionCodeProvider() {
        return this.versionCodeProvider;
    }

    /* access modifiers changed from: protected */
    public C0120S<GetAdsResponse> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        HashMapNotNull<String, String> parameters = new HashMapNotNull<>();
        parameters.put("q", this.f6093q);
        parameters.put("lang", SystemU.getCountryCode(this.resources));
        parameters.put("cpuid", this.clientUniqueId);
        parameters.put("location", this.location.toString());
        parameters.put("type", "1-3");
        parameters.put("partners", "1-3,5-10");
        parameters.put("keywords", this.keyword);
        parameters.put("oem_id", this.oemid);
        String str = forcedCountry;
        String str2 = ImpressionData.COUNTRY;
        parameters.put(str2, str);
        parameters.put("group_package_name", this.groupPackageName);
        String forceCountry = ToolboxManager.getForceCountry(this.sharedPreferences);
        if (!TextUtils.isEmpty(forceCountry)) {
            parameters.put(str2, forceCountry);
        }
        if (this.googlePlayServicesAvailable) {
            parameters.put("flag", "gms");
        }
        parameters.put("excluded_pkg", getExcludedPackages());
        parameters.put("limit", String.valueOf(this.limit));
        parameters.put("get_mature", Integer.toString(this.mature ? 1 : 0));
        parameters.put("app_pkg", this.packageName);
        parameters.put("app_store", this.repo);
        parameters.put("filter_pkg", "true");
        parameters.put("conn_type", SystemU.getConnectionType(this.connectivityManager));
        parameters.put("excluded_partners", this.excludedNetworks);
        return this.versionCodeProvider.getApplicationVersionCode().mo3697c(new C2844b(parameters, interfaces, bypassCache));
    }

    /* renamed from: a */
    static /* synthetic */ void m7436a(GetAdsResponse getAdsResponse) {
        for (C2842Ad ad : getAdsResponse.getAds()) {
            AdNetworkUtils.knockImpression(ad);
        }
    }

    private String getExcludedPackages() {
        return this.excludedPackage;
    }
}
