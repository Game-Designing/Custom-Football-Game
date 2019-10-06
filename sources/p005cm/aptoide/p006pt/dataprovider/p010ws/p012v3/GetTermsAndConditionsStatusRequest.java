package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TermsAndConditionsResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.GetTermsAndConditionsStatusRequest */
public class GetTermsAndConditionsStatusRequest extends C2847V3<TermsAndConditionsResponse> {
    private GetTermsAndConditionsStatusRequest(BaseBody baseBody, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor<BaseBody> bodyInterceptor, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* renamed from: of */
    public static GetTermsAndConditionsStatusRequest m7449of(BodyInterceptor<BaseBody> bodyInterceptor, Factory converterFactory, OkHttpClient httpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        GetTermsAndConditionsStatusRequest getTermsAndConditionsStatusRequest = new GetTermsAndConditionsStatusRequest(new BaseBody(), httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
        return getTermsAndConditionsStatusRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<TermsAndConditionsResponse> loadDataFromNetwork(Service service, boolean bypassCache) {
        return service.getTermsAndConditionsStatus(this.map, bypassCache);
    }
}
