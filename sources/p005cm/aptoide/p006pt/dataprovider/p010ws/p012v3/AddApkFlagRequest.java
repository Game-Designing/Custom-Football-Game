package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p011v2.GenericResponseV2;
import p005cm.aptoide.p006pt.deprecated.tables.Updates;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.AddApkFlagRequest */
public class AddApkFlagRequest extends C2847V3<GenericResponseV2> {
    protected AddApkFlagRequest(BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* renamed from: of */
    public static AddApkFlagRequest m7442of(String storeName, String appMd5sum, String flag, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        BaseBody args = new BaseBody();
        args.put(Updates.COLUMN_REPO, storeName);
        args.put("md5sum", appMd5sum);
        args.put("flag", flag);
        args.put("mode", "json");
        AddApkFlagRequest addApkFlagRequest = new AddApkFlagRequest(args, bodyInterceptor, httpClient, WebService.getDefaultConverter(), tokenInvalidator, sharedPreferences);
        return addApkFlagRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<GenericResponseV2> loadDataFromNetwork(Service service, boolean bypassCache) {
        return service.addApkFlag(this.map, bypassCache);
    }
}
