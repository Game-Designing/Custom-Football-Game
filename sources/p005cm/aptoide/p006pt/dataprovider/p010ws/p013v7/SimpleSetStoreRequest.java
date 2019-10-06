package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mopub.common.Constants;
import java.util.List;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SimpleSetStoreRequest */
public class SimpleSetStoreRequest extends C0044V7<BaseV7Response, Body> {

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SimpleSetStoreRequest$Body */
    public static class Body extends BaseBody {
        @JsonProperty("store_del_links")
        private List<SocialChannelType> storeDeleteSocialLinksList;
        @JsonProperty("store_links")
        private List<StoreLinks> storeLinksList;
        private String storeName;
        private StoreProperties storeProperties;

        public Body(String storeName2, String storeTheme, String storeDescription, List<StoreLinks> storeLinksList2, List<SocialChannelType> storeDeleteSocialLinksList2) {
            this.storeName = storeName2;
            this.storeLinksList = storeLinksList2;
            this.storeDeleteSocialLinksList = storeDeleteSocialLinksList2;
            this.storeProperties = new StoreProperties(storeTheme, storeDescription);
        }

        public StoreProperties getStoreProperties() {
            return this.storeProperties;
        }

        public void setStoreProperties(StoreProperties storeProperties2) {
            this.storeProperties = storeProperties2;
        }

        public String getStoreName() {
            return this.storeName;
        }

        public void setStoreName(String storeName2) {
            this.storeName = storeName2;
        }

        public List<StoreLinks> getStoreLinksList() {
            return this.storeLinksList;
        }

        public void setStoreLinksList(List<StoreLinks> storeLinksList2) {
            this.storeLinksList = storeLinksList2;
        }

        public List<SocialChannelType> getStoreDeleteSocialLinksList() {
            return this.storeDeleteSocialLinksList;
        }

        public void setStoreDeleteSocialLinksList(List<SocialChannelType> storeDeleteSocialLinksList2) {
            this.storeDeleteSocialLinksList = storeDeleteSocialLinksList2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SimpleSetStoreRequest$StoreProperties */
    public static class StoreProperties {
        @JsonProperty("description")
        private String description;
        @JsonProperty("theme")
        private String theme;

        public StoreProperties(String theme2, String description2) {
            this.theme = theme2;
            this.description = description2;
        }

        public String getTheme() {
            return this.theme;
        }

        public void setTheme(String theme2) {
            this.theme = theme2;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description2) {
            this.description = description2;
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SimpleSetStoreRequest$StoreLinks */
    public static class StoreLinks {
        SocialChannelType type;
        String url;

        public StoreLinks() {
        }

        public StoreLinks(SocialChannelType type2, String url2) {
            this.type = type2;
            this.url = url2;
        }

        public String getUrl() {
            return this.url;
        }

        public void setUrl(String url2) {
            this.url = url2;
        }

        public SocialChannelType getType() {
            return this.type;
        }

        public void setType(SocialChannelType type2) {
            this.type = type2;
        }
    }

    private SimpleSetStoreRequest(Body body, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, List<SocialChannelType> list) {
        super(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_WRITE_V7_HOST);
        sb.append("/api/7/");
        return sb.toString();
    }

    /* renamed from: of */
    public static SimpleSetStoreRequest m7489of(String storeName, String storeTheme, String storeDescription, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, List<StoreLinks> storeLinksList, List<SocialChannelType> storeDeleteSocialLinksList) {
        Body body = new Body(storeName, storeTheme, storeDescription, storeLinksList, storeDeleteSocialLinksList);
        SimpleSetStoreRequest simpleSetStoreRequest = new SimpleSetStoreRequest(body, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences, storeDeleteSocialLinksList);
        return simpleSetStoreRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.editStore((Body) this.body);
    }
}
