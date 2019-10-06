package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.BaseV3Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.ChangeUserBirthdateRequest */
public class ChangeUserBirthdateRequest extends C2847V3<BaseV3Response> {
    private ChangeUserBirthdateRequest(BaseBody baseBody, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* renamed from: of */
    public static ChangeUserBirthdateRequest m7443of(String birthdate, BodyInterceptor<BaseBody> bodyInterceptor, Factory converterFactory, OkHttpClient httpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        BaseBody body = new BaseBody();
        body.put("birthdate", birthdate);
        body.put("mode", "json");
        ChangeUserBirthdateRequest changeUserBirthdateRequest = new ChangeUserBirthdateRequest(body, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        return changeUserBirthdateRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV3Response> loadDataFromNetwork(Service service, boolean bypassCache) {
        return service.changeUserBirthdate(this.map, bypassCache);
    }
}
