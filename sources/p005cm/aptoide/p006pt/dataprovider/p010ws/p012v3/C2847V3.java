package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import com.mopub.common.Constants;
import java.io.IOException;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.BuildConfig;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV3Exception;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.BaseV3Response;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.ErrorResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.preferences.toolbox.ToolboxManager;
import p026rx.C0120S;
import retrofit2.Converter.Factory;
import retrofit2.adapter.rxjava.HttpException;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.V3 */
public abstract class C2847V3<U> extends WebService<Service, U> {
    protected static final String BASE_HOST = "https://webservices.aptoide.com/webservices/3/";
    private final String INVALID_ACCESS_TOKEN_CODE;
    private boolean accessTokenRetry;
    private final BodyInterceptor<BaseBody> bodyInterceptor;
    protected final BaseBody map;
    private final TokenInvalidator tokenInvalidator;

    protected C2847V3(String baseHost, BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor2, TokenInvalidator tokenInvalidator2) {
        super(Service.class, new OkHttpClient(), WebService.getDefaultConverter(), baseHost);
        this.INVALID_ACCESS_TOKEN_CODE = "invalid_token";
        this.accessTokenRetry = false;
        this.map = baseBody;
        this.bodyInterceptor = bodyInterceptor2;
        this.tokenInvalidator = tokenInvalidator2;
    }

    protected C2847V3(BaseBody baseBody, OkHttpClient httpClient, Factory converterFactory, BodyInterceptor<BaseBody> bodyInterceptor2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences) {
        super(Service.class, httpClient, converterFactory, getHost(sharedPreferences));
        this.INVALID_ACCESS_TOKEN_CODE = "invalid_token";
        this.accessTokenRetry = false;
        this.map = baseBody;
        this.bodyInterceptor = bodyInterceptor2;
        this.tokenInvalidator = tokenInvalidator2;
    }

    protected C2847V3(OkHttpClient okHttpClient, Factory converterFactory, BodyInterceptor<BaseBody> bodyInterceptor2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences) {
        this(new BaseBody(), okHttpClient, converterFactory, bodyInterceptor2, tokenInvalidator2, sharedPreferences);
    }

    public static String getHost(SharedPreferences sharedPreferences) {
        StringBuilder sb = new StringBuilder();
        sb.append(ToolboxManager.isToolboxEnableHttpScheme(sharedPreferences) ? Constants.HTTP : "https");
        sb.append("://");
        sb.append(BuildConfig.APTOIDE_WEB_SERVICES_HOST);
        sb.append("/webservices/3/");
        return sb.toString();
    }

    public static String getErrorMessage(BaseV3Response response) {
        StringBuilder builder = new StringBuilder();
        if (response == null || response.getErrors() == null) {
            builder.append("Server returned null response.");
        } else {
            for (ErrorResponse error : response.getErrors()) {
                builder.append(error.msg);
                builder.append(". ");
            }
            if (builder.length() == 0) {
                builder.append("Server failed with empty error list.");
            }
        }
        return builder.toString();
    }

    public C0120S<U> observe(boolean bypassCache) {
        return this.bodyInterceptor.intercept(this.map).mo3697c(new C2849b(this, bypassCache));
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo12976a(boolean bypassCache, BaseBody body) {
        return super.observe(bypassCache).mo3671k(new C2848a(this, bypassCache));
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo12977a(boolean bypassCache, Throwable throwable) {
        if (throwable instanceof HttpException) {
            try {
                GenericResponseV3 genericResponseV3 = (GenericResponseV3) this.converterFactory.responseBodyConverter(GenericResponseV3.class, null, null).convert(((HttpException) throwable).response().errorBody());
                if (!"invalid_token".equals(genericResponseV3.getError())) {
                    AptoideWsV3Exception exception = new AptoideWsV3Exception(throwable);
                    exception.setBaseResponse(genericResponseV3);
                    return C0120S.m631a((Throwable) exception);
                } else if (!this.accessTokenRetry) {
                    this.accessTokenRetry = true;
                    return this.tokenInvalidator.invalidateAccessToken().mo3586a(observe(bypassCache));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return C0120S.m631a(throwable);
    }
}
