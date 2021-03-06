package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.BaseV3Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.UpdateTermsAndConditionsRequest */
public class UpdateTermsAndConditionsRequest extends C2847V3<BaseV3Response> {
    private UpdateTermsAndConditionsRequest(BaseBody baseBody, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* renamed from: of */
    public static UpdateTermsAndConditionsRequest m7454of(BodyInterceptor<BaseBody> bodyInterceptor, Factory converterFactory, OkHttpClient httpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        UpdateTermsAndConditionsRequest updateTermsAndConditionsRequest = new UpdateTermsAndConditionsRequest(new BaseBody(), httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        return updateTermsAndConditionsRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<BaseV3Response> loadDataFromNetwork(Service service, boolean bypassCache) {
        return service.updateTermsAndConditions(this.map, bypassCache);
    }
}
