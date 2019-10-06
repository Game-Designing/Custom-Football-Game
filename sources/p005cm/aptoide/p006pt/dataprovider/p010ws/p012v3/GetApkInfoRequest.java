package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import android.content.res.Resources;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.GetApkInfoRequest */
public class GetApkInfoRequest extends C2847V3<PaidApp> {
    protected GetApkInfoRequest(BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* renamed from: of */
    public static GetApkInfoRequest m7448of(long appId, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, Resources resources) {
        BaseBody args = new BaseBody();
        StringBuilder sb = new StringBuilder();
        sb.append("id:");
        long j = appId;
        sb.append(appId);
        args.put("identif", sb.toString());
        args.put("mode", "json");
        addOptions(args, resources);
        GetApkInfoRequest getApkInfoRequest = new GetApkInfoRequest(args, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getApkInfoRequest;
    }

    private static void addOptions(BaseBody args, Resources resources) {
        BaseBody options = new BaseBody();
        options.put("cmtlimit", "5");
        options.put("payinfo", "true");
        options.put("lang", SystemU.getCountryCode(resources));
        StringBuilder optionsBuilder = new StringBuilder();
        optionsBuilder.append("(");
        for (String optionKey : options.keySet()) {
            optionsBuilder.append(optionKey);
            optionsBuilder.append("=");
            optionsBuilder.append(options.get(optionKey));
            optionsBuilder.append(";");
        }
        optionsBuilder.append(")");
        args.put("options", optionsBuilder.toString());
    }

    /* access modifiers changed from: protected */
    public C0120S<PaidApp> loadDataFromNetwork(Service service, boolean bypassCache) {
        return service.getApkInfo(this.map, bypassCache);
    }
}
