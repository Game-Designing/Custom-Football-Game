package p005cm.aptoide.p006pt.billing.networking;

import android.content.SharedPreferences;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.transaction.SimpleTransaction;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p005cm.aptoide.p006pt.billing.transaction.Transaction.Status;
import p005cm.aptoide.p006pt.billing.transaction.TransactionFactory;
import p005cm.aptoide.p006pt.billing.transaction.TransactionService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.CreateTransactionRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetTransactionRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetTransactionRequest.ResponseBody;
import p005cm.aptoide.p006pt.networking.Authentication;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;
import retrofit2.Response;

/* renamed from: cm.aptoide.pt.billing.networking.TransactionServiceV7 */
public class TransactionServiceV7 implements TransactionService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthenticationPersistence authenticationPersistence;
    private final BillingIdManager billingIdManager;
    private final BodyInterceptor<BaseBody> bodyInterceptorV7;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;
    private final TransactionFactory transactionFactory;
    private final TransactionMapperV7 transactionMapper;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-695090296504969822L, "cm/aptoide/pt/billing/networking/TransactionServiceV7", 56);
        $jacocoData = probes;
        return probes;
    }

    public TransactionServiceV7(TransactionMapperV7 transactionMapper2, BodyInterceptor<BaseBody> bodyInterceptorV72, Factory converterFactory2, OkHttpClient httpClient2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, BillingIdManager billingIdManager2, TransactionFactory transactionFactory2, AuthenticationPersistence authenticationPersistence2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.transactionMapper = transactionMapper2;
        this.bodyInterceptorV7 = bodyInterceptorV72;
        this.converterFactory = converterFactory2;
        this.httpClient = httpClient2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.billingIdManager = billingIdManager2;
        this.transactionFactory = transactionFactory2;
        this.authenticationPersistence = authenticationPersistence2;
        $jacocoInit[0] = true;
    }

    public Single<Transaction> getTransaction(String customerId, String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single authentication = this.authenticationPersistence.getAuthentication();
        C2332y yVar = new C2332y(this, productId, customerId);
        $jacocoInit[1] = true;
        C0120S c = authentication.mo3697c(yVar);
        $jacocoInit[2] = true;
        Single n = c.mo3678n();
        C2331x xVar = new C2331x(this, productId, customerId);
        $jacocoInit[3] = true;
        Single<Transaction> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) xVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo11179a(String productId, String customerId, Authentication authentication) {
        boolean[] $jacocoInit = $jacocoInit();
        BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorV7;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[52] = true;
        long resolveProductId = billingIdManager2.resolveProductId(productId);
        String accessToken = authentication.getAccessToken();
        $jacocoInit[53] = true;
        GetTransactionRequest of = GetTransactionRequest.m7545of(bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, resolveProductId, accessToken, customerId);
        $jacocoInit[54] = true;
        C0120S observe = of.observe();
        $jacocoInit[55] = true;
        return observe;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11181a(String productId, String customerId, Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        okhttp3.Response raw = response.raw();
        $jacocoInit[31] = true;
        if (raw.networkResponse() == null) {
            $jacocoInit[32] = true;
        } else {
            $jacocoInit[33] = true;
            okhttp3.Response raw2 = response.raw();
            $jacocoInit[34] = true;
            okhttp3.Response networkResponse = raw2.networkResponse();
            $jacocoInit[35] = true;
            if (networkResponse.code() != 304) {
                $jacocoInit[36] = true;
            } else {
                $jacocoInit[37] = true;
                StringBuilder sb = new StringBuilder();
                sb.append("Stale transaction for product ");
                sb.append(productId);
                Single a = Single.m735a((Throwable) new IllegalStateException(sb.toString()));
                $jacocoInit[38] = true;
                return a;
            }
        }
        if (response.isSuccessful()) {
            $jacocoInit[39] = true;
            ResponseBody responseBody = (ResponseBody) response.body();
            $jacocoInit[40] = true;
            if (responseBody == null) {
                $jacocoInit[41] = true;
            } else if (!responseBody.isOk()) {
                $jacocoInit[42] = true;
            } else {
                $jacocoInit[43] = true;
                Single a2 = Single.m734a(this.transactionMapper.map(responseBody.getData()));
                $jacocoInit[44] = true;
                return a2;
            }
            Single a3 = Single.m735a((Throwable) new IllegalArgumentException(C0044V7.getErrorMessage(responseBody)));
            $jacocoInit[45] = true;
            return a3;
        } else if (response.code() == 404) {
            TransactionFactory transactionFactory2 = this.transactionFactory;
            BillingIdManager billingIdManager2 = this.billingIdManager;
            $jacocoInit[46] = true;
            SimpleTransaction create = transactionFactory2.create(billingIdManager2.generateTransactionId(), customerId, productId, Status.NEW);
            $jacocoInit[47] = true;
            Single a4 = Single.m734a(create);
            $jacocoInit[48] = true;
            return a4;
        } else {
            TransactionFactory transactionFactory3 = this.transactionFactory;
            BillingIdManager billingIdManager3 = this.billingIdManager;
            $jacocoInit[49] = true;
            SimpleTransaction create2 = transactionFactory3.create(billingIdManager3.generateTransactionId(), customerId, productId, Status.FAILED);
            $jacocoInit[50] = true;
            Single a5 = Single.m734a(create2);
            $jacocoInit[51] = true;
            return a5;
        }
    }

    public Single<Transaction> createTransaction(String customerId, String productId, String serviceId, String payload) {
        String str = productId;
        boolean[] $jacocoInit = $jacocoInit();
        long resolveProductId = this.billingIdManager.resolveProductId(str);
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[5] = true;
        long resolveServiceId = billingIdManager2.resolveServiceId(serviceId);
        BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorV7;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[6] = true;
        CreateTransactionRequest of = CreateTransactionRequest.m7535of(resolveProductId, resolveServiceId, payload, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2);
        $jacocoInit[7] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[8] = true;
        Single n = observe.mo3678n();
        C2330w wVar = new C2330w(this, customerId, str);
        $jacocoInit[9] = true;
        Single<Transaction> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) wVar);
        $jacocoInit[10] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11180a(String customerId, String productId, CreateTransactionRequest.ResponseBody response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[24] = true;
        } else if (!response.isOk()) {
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            Single a = Single.m734a(this.transactionMapper.map(response.getData()));
            $jacocoInit[27] = true;
            return a;
        }
        TransactionFactory transactionFactory2 = this.transactionFactory;
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[28] = true;
        SimpleTransaction create = transactionFactory2.create(billingIdManager2.generateTransactionId(), customerId, productId, Status.FAILED);
        $jacocoInit[29] = true;
        Single a2 = Single.m734a(create);
        $jacocoInit[30] = true;
        return a2;
    }

    public Single<Transaction> createTransaction(String customerId, String productId, String serviceId, String payload, String token) {
        String str = productId;
        boolean[] $jacocoInit = $jacocoInit();
        long resolveProductId = this.billingIdManager.resolveProductId(str);
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[11] = true;
        long resolveServiceId = billingIdManager2.resolveServiceId(serviceId);
        BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorV7;
        OkHttpClient okHttpClient = this.httpClient;
        Factory factory = this.converterFactory;
        TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
        SharedPreferences sharedPreferences2 = this.sharedPreferences;
        $jacocoInit[12] = true;
        CreateTransactionRequest of = CreateTransactionRequest.m7536of(resolveProductId, resolveServiceId, payload, token, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2);
        $jacocoInit[13] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[14] = true;
        Single n = observe.mo3678n();
        C2329v vVar = new C2329v(this, customerId, str);
        $jacocoInit[15] = true;
        Single<Transaction> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) vVar);
        $jacocoInit[16] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo11182b(String customerId, String productId, CreateTransactionRequest.ResponseBody response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[17] = true;
        } else if (!response.isOk()) {
            $jacocoInit[18] = true;
        } else {
            $jacocoInit[19] = true;
            Single a = Single.m734a(this.transactionMapper.map(response.getData()));
            $jacocoInit[20] = true;
            return a;
        }
        TransactionFactory transactionFactory2 = this.transactionFactory;
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[21] = true;
        SimpleTransaction create = transactionFactory2.create(billingIdManager2.generateTransactionId(), customerId, productId, Status.FAILED);
        $jacocoInit[22] = true;
        Single a2 = Single.m734a(create);
        $jacocoInit[23] = true;
        return a2;
    }
}
