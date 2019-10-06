package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.GetTransactionRequest */
public class GetTransactionRequest extends C2847V3<TransactionResponse> {
    public GetTransactionRequest(BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* renamed from: of */
    public static GetTransactionRequest m7450of(long productId, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        BaseBody args = new BaseBody();
        args.put("reqtype", "apkpurchasestatus");
        args.put("mode", "json");
        args.put("payreqtype", "rest");
        args.put("productid", String.valueOf(productId));
        GetTransactionRequest getTransactionRequest = new GetTransactionRequest(args, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return getTransactionRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<TransactionResponse> loadDataFromNetwork(Service service, boolean bypassCache) {
        return service.getTransaction(this.map);
    }
}
