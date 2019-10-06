package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.deprecated.tables.Updates;
import p026rx.C0120S;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.CreateTransactionRequest */
public class CreateTransactionRequest extends C2847V3<TransactionResponse> {
    private CreateTransactionRequest(BaseBody baseBody, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences) {
        super(baseBody, httpClient, converterFactory, bodyInterceptor, tokenInvalidator, sharedPreferences);
    }

    /* renamed from: of */
    public static CreateTransactionRequest m7445of(int productId, int serviceId, String store, String metadata, BodyInterceptor<BaseBody> bodyInterceptor, OkHttpClient httpClient, Factory converterFactory, TokenInvalidator tokenInvalidator, SharedPreferences sharedPreferences, int versionCode, String productTitle) {
        BaseBody args = new BaseBody();
        args.put("productid", String.valueOf(productId));
        args.put("payType", String.valueOf(serviceId));
        args.put("reqType", "rest");
        args.put("product_name", productTitle);
        args.put("app_vercode", Integer.valueOf(versionCode));
        String str = metadata;
        args.put("paykey", metadata);
        String str2 = store;
        args.put(Updates.COLUMN_REPO, store);
        CreateTransactionRequest createTransactionRequest = new CreateTransactionRequest(args, bodyInterceptor, httpClient, converterFactory, tokenInvalidator, sharedPreferences);
        return createTransactionRequest;
    }

    /* access modifiers changed from: protected */
    public C0120S<TransactionResponse> loadDataFromNetwork(Service service, boolean bypassCache) {
        return service.createTransaction(this.map, bypassCache);
    }
}
