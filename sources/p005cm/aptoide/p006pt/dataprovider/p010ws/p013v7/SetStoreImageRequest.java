package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import android.content.SharedPreferences;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mopub.common.Constants;
import java.io.File;
import java.util.List;
import okhttp3.MultipartBody.Part;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SimpleSetStoreRequest.StoreLinks;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SimpleSetStoreRequest.StoreProperties;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.RequestBodyFactory;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SetStoreImageRequest */
public class SetStoreImageRequest extends C0044V7<BaseV7Response, HashMapNotNull<String, RequestBody>> {
    private final Part multipartBody;

    private SetStoreImageRequest(HashMapNotNull<String, RequestBody> body, Part multipartBody2, BodyInterceptor<HashMapNotNull<String, RequestBody>> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator) {
        super(body, getHost(sharedPreferences), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.multipartBody = multipartBody2;
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
    public static SetStoreImageRequest m7485of(String storeName, String storeTheme, String storeDescription, String storeImagePath, BodyInterceptor<HashMapNotNull<String, RequestBody>> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, RequestBodyFactory requestBodyFactory, ObjectMapper serializer, SharedPreferences sharedPreferences, TokenInvalidator tokenInvalidator, List<StoreLinks> storeLinksList, List<SocialChannelType> storeDeleteLinksList) {
        RequestBodyFactory requestBodyFactory2 = requestBodyFactory;
        ObjectMapper objectMapper = serializer;
        HashMapNotNull<String, RequestBody> body = new HashMapNotNull<>();
        body.put("store_name", requestBodyFactory2.createBodyPartFromString(storeName));
        addStoreProperties(storeTheme, storeDescription, requestBodyFactory2, objectMapper, body);
        addStoreLinks(storeLinksList, body, objectMapper, requestBodyFactory2);
        addStoreDeleteLinks(storeDeleteLinksList, body, objectMapper, requestBodyFactory2);
        SetStoreImageRequest setStoreImageRequest = new SetStoreImageRequest(body, requestBodyFactory2.createBodyPartFromFile("store_avatar", new File(storeImagePath)), bodyInterceptor, httpClient, converterFactory, sharedPreferences, tokenInvalidator);
        return setStoreImageRequest;
    }

    private static void addStoreDeleteLinks(List<SocialChannelType> storeDeleteLinksList, HashMapNotNull<String, RequestBody> body, ObjectMapper serializer, RequestBodyFactory requestBodyFactory) {
        try {
            body.put("store_del_links", requestBodyFactory.createBodyPartFromString(serializer.writeValueAsString(storeDeleteLinksList)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addStoreLinks(List<StoreLinks> storeLinksList, HashMapNotNull<String, RequestBody> body, ObjectMapper serializer, RequestBodyFactory requestBodyFactory) {
        try {
            body.put("store_links", requestBodyFactory.createBodyPartFromString(serializer.writeValueAsString(storeLinksList)));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addStoreProperties(String storeTheme, String storeDescription, RequestBodyFactory requestBodyFactory, ObjectMapper serializer, HashMapNotNull<String, RequestBody> body) {
        try {
            body.put("store_properties", requestBodyFactory.createBodyPartFromString(serializer.writeValueAsString(new StoreProperties(storeTheme, storeDescription))));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.editStore(this.multipartBody, (HashMapNotNull) this.body);
    }
}
