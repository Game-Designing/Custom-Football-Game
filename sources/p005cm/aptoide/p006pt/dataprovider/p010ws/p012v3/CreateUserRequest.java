package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.MultipartBody.Part;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.BaseV3Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.util.HashMapNotNull;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.CreateUserRequest */
public class CreateUserRequest extends C2847V3<BaseV3Response> {
    private final Part multipartBodyFile;
    private final HashMapNotNull<String, RequestBody> multipartRequestBody;

    public CreateUserRequest(Part file, BaseBody baseBody, OkHttpClient httpClient, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, WebService.getDefaultConverter(), bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.multipartBodyFile = file;
        this.multipartRequestBody = null;
    }

    public CreateUserRequest(Part file, HashMapNotNull<String, RequestBody> body, OkHttpClient okHttpClient, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(okHttpClient, WebService.getDefaultConverter(), bodyInterceptor, tokenInvalidator, sharedPreferences);
        this.multipartBodyFile = file;
        this.multipartRequestBody = body;
    }

    /* renamed from: of */
    public static CreateUserRequest m7446of(String email, String password, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String extraId) {
        String str = email;
        BaseBody body = new BaseBody();
        String passhash = AlgorithmU.computeSha1(password);
        addBaseParameters(email, body, passhash, extraId);
        StringBuilder sb = new StringBuilder();
        sb.append(email);
        sb.append(passhash);
        body.put("hmac", AlgorithmU.computeHmacSha1(sb.toString(), "bazaar_hmac"));
        CreateUserRequest createUserRequest = new CreateUserRequest((Part) null, body, httpClient, bodyInterceptor, tokenInvalidator, sharedPreferences);
        return createUserRequest;
    }

    private static void addBaseParameters(String email, BaseBody parameters, String passhash, String extraId) {
        parameters.put("mode", "json");
        parameters.put("email", email);
        parameters.put("passhash", passhash);
        if (!TextUtils.isEmpty(extraId)) {
            parameters.put("oem_id", extraId);
        }
        parameters.put("accepts", "tos,privacy");
    }

    /* renamed from: of */
    public static CreateUserRequest m7447of(String email, String name, String password, String userAvatarPath, String accessToken, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, OkHttpClient longTimeoutHttpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, String extraId) {
        String str = email;
        String str2 = name;
        BaseBody body = new BaseBody();
        String passhash = AlgorithmU.computeSha1(password);
        String str3 = "name";
        String str4 = "update";
        String str5 = "bazaar_hmac";
        String str6 = "hmac";
        String str7 = "true";
        if (!TextUtils.isEmpty(userAvatarPath)) {
            if (!TextUtils.isEmpty(extraId)) {
                body.put("oem_id", createBodyPartFromString(extraId));
            }
            HashMapNotNull<String, RequestBody> multipartBody = new HashMapNotNull<>();
            multipartBody.put("mode", createBodyPartFromString("json"));
            multipartBody.put("email", createBodyPartFromString(email));
            multipartBody.put("passhash", createBodyPartFromString(passhash));
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(passhash);
            sb.append(str2);
            sb.append(str7);
            multipartBody.put(str6, createBodyPartFromString(AlgorithmU.computeHmacSha1(sb.toString(), str5)));
            multipartBody.put(str3, createBodyPartFromString(name));
            multipartBody.put(str4, createBodyPartFromString(str7));
            File file = new File(userAvatarPath);
            String str8 = "user_avatar";
            CreateUserRequest createUserRequest = new CreateUserRequest(Part.createFormData(str8, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file)), multipartBody, longTimeoutHttpClient, bodyInterceptor, tokenInvalidator, sharedPreferences);
            return createUserRequest;
        }
        String str9 = userAvatarPath;
        if (userAvatarPath.isEmpty()) {
            body.put(str4, str7);
            body.put(str3, str2);
        }
        addBaseParameters(str, body, passhash, extraId);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(passhash);
        sb2.append(str2);
        sb2.append(str7);
        body.put(str6, AlgorithmU.computeHmacSha1(sb2.toString(), str5));
        CreateUserRequest createUserRequest2 = new CreateUserRequest((Part) null, body, httpClient, bodyInterceptor, tokenInvalidator, sharedPreferences);
        return createUserRequest2;
    }

    private static RequestBody createBodyPartFromString(String string) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), string);
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV3Response> loadDataFromNetwork(Service service, boolean bypassCache) {
        Part part = this.multipartBodyFile;
        if (part != null) {
            return service.createUserWithFile(part, this.multipartRequestBody, bypassCache);
        }
        return service.createUser(this.map, bypassCache);
    }
}
