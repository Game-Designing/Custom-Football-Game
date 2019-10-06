package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import okhttp3.MultipartBody.Part;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7.Interfaces;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.SetUserRequest.UserProperties;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.RequestBodyFactory;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.SetUserMultipartRequest */
public class SetUserMultipartRequest extends C0044V7<BaseV7Response, HashMapNotNull<String, RequestBody>> {
    private final Part multipartBody;

    private SetUserMultipartRequest(Part file, HashMapNotNull<String, RequestBody> body, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor bodyInterceptor, TokenInvalidator tokenInvalidator) {
        super(body, getHost(), httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
        this.multipartBody = file;
    }

    public static String getHost() {
        return "https://ws75-primary.aptoide.com/api/7/";
    }

    /* renamed from: of */
    public static SetUserMultipartRequest m7486of(String username, String userAvatar, BodyInterceptor<HashMapNotNull<String, RequestBody>> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, ObjectMapper serializer, TokenInvalidator tokenInvalidator) {
        RequestBodyFactory requestBodyFactory = new RequestBodyFactory();
        HashMapNotNull hashMapNotNull = new HashMapNotNull();
        try {
            String str = username;
            try {
                try {
                    hashMapNotNull.put("user_properties", requestBodyFactory.createBodyPartFromString(serializer.writeValueAsString(new UserProperties(username))));
                    String str2 = userAvatar;
                    SetUserMultipartRequest setUserMultipartRequest = new SetUserMultipartRequest(requestBodyFactory.createBodyPartFromFile("user_avatar", new File(userAvatar)), hashMapNotNull, httpClient, converterFactory, bodyInterceptor, tokenInvalidator);
                    return setUserMultipartRequest;
                } catch (JsonProcessingException e) {
                    e = e;
                    String str3 = userAvatar;
                    throw new RuntimeException(e);
                }
            } catch (JsonProcessingException e2) {
                e = e2;
                String str4 = userAvatar;
                ObjectMapper objectMapper = serializer;
                throw new RuntimeException(e);
            }
        } catch (JsonProcessingException e3) {
            e = e3;
            String str5 = username;
            String str42 = userAvatar;
            ObjectMapper objectMapper2 = serializer;
            throw new RuntimeException(e);
        }
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV7Response> loadDataFromNetwork(Interfaces interfaces, boolean bypassCache) {
        return interfaces.editUser(this.multipartBody, (HashMapNotNull) this.body);
    }
}
