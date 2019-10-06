package p005cm.aptoide.p006pt.billing.networking;

import android.content.SharedPreferences;
import android.content.res.Resources;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.transaction.SimpleTransaction;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p005cm.aptoide.p006pt.billing.transaction.Transaction.Status;
import p005cm.aptoide.p006pt.billing.transaction.TransactionFactory;
import p005cm.aptoide.p006pt.billing.transaction.TransactionService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.Metadata;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.Payment;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GetApkInfoRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GetTransactionRequest;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.billing.networking.TransactionServiceV3 */
public class TransactionServiceV3 implements TransactionService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BillingIdManager billingIdManager;
    private final BodyInterceptor<BaseBody> bodyInterceptorV3;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;
    private final TransactionFactory transactionFactory;
    private final TransactionMapperV3 transactionMapper;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-7892233762502249057L, "cm/aptoide/pt/billing/networking/TransactionServiceV3", 39);
        $jacocoData = probes;
        return probes;
    }

    public TransactionServiceV3(TransactionMapperV3 transactionMapper2, BodyInterceptor<BaseBody> bodyInterceptorV32, Factory converterFactory2, OkHttpClient httpClient2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, TransactionFactory transactionFactory2, Resources resources2, BillingIdManager billingIdManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.transactionMapper = transactionMapper2;
        this.bodyInterceptorV3 = bodyInterceptorV32;
        this.converterFactory = converterFactory2;
        this.httpClient = httpClient2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.transactionFactory = transactionFactory2;
        this.resources = resources2;
        this.billingIdManager = billingIdManager2;
        $jacocoInit[0] = true;
    }

    public Single<Transaction> getTransaction(String customerId, String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        GetApkInfoRequest of = GetApkInfoRequest.m7448of(this.billingIdManager.resolveProductId(productId), this.bodyInterceptorV3, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.resources);
        $jacocoInit[1] = true;
        C0120S observe = of.observe(false);
        $jacocoInit[2] = true;
        Single n = observe.mo3678n();
        C2328u uVar = new C2328u(this, customerId, productId);
        $jacocoInit[3] = true;
        Single<Transaction> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) uVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo11175b(String customerId, String productId, PaidApp response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[20] = true;
            if (response.isPaid()) {
                $jacocoInit[21] = true;
                Payment payment = response.getPayment();
                $jacocoInit[22] = true;
                Metadata metadata = payment.getMetadata();
                $jacocoInit[23] = true;
                long productId2 = (long) metadata.getProductId();
                BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorV3;
                OkHttpClient okHttpClient = this.httpClient;
                Factory factory = this.converterFactory;
                TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
                SharedPreferences sharedPreferences2 = this.sharedPreferences;
                $jacocoInit[24] = true;
                GetTransactionRequest of = GetTransactionRequest.m7450of(productId2, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2);
                $jacocoInit[25] = true;
                C0120S observe = of.observe(true);
                $jacocoInit[26] = true;
                Single n = observe.mo3678n();
                C2327t tVar = new C2327t(this, customerId, productId);
                $jacocoInit[27] = true;
                Single d = n.mo3698d(tVar);
                $jacocoInit[28] = true;
                return d;
            }
            TransactionFactory transactionFactory2 = this.transactionFactory;
            BillingIdManager billingIdManager2 = this.billingIdManager;
            $jacocoInit[29] = true;
            long resolveProductId = billingIdManager2.resolveProductId(productId);
            $jacocoInit[30] = true;
            Single a = Single.m734a(transactionFactory2.create(billingIdManager2.generateTransactionId(resolveProductId), customerId, productId, Status.COMPLETED));
            $jacocoInit[31] = true;
            return a;
        }
        TransactionFactory transactionFactory3 = this.transactionFactory;
        BillingIdManager billingIdManager3 = this.billingIdManager;
        $jacocoInit[32] = true;
        String generateTransactionId = billingIdManager3.generateTransactionId(billingIdManager3.resolveProductId(productId));
        Status status = Status.FAILED;
        $jacocoInit[33] = true;
        Single a2 = Single.m734a(transactionFactory3.create(generateTransactionId, customerId, productId, status));
        $jacocoInit[34] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ Transaction mo11174a(String customerId, String productId, TransactionResponse transactionResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        TransactionMapperV3 transactionMapperV3 = this.transactionMapper;
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[35] = true;
        long resolveProductId = billingIdManager2.resolveProductId(productId);
        $jacocoInit[36] = true;
        String generateTransactionId = billingIdManager2.generateTransactionId(resolveProductId);
        $jacocoInit[37] = true;
        Transaction map = transactionMapperV3.map(customerId, generateTransactionId, transactionResponse, productId);
        $jacocoInit[38] = true;
        return map;
    }

    public Single<Transaction> createTransaction(String customerId, String productId, String serviceId, String payload) {
        boolean[] $jacocoInit = $jacocoInit();
        GetApkInfoRequest of = GetApkInfoRequest.m7448of(this.billingIdManager.resolveProductId(productId), this.bodyInterceptorV3, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.resources);
        $jacocoInit[5] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[6] = true;
        Single n = observe.mo3678n();
        C2326s sVar = new C2326s(this, productId, customerId);
        $jacocoInit[7] = true;
        Single<Transaction> d = n.mo3698d(sVar);
        $jacocoInit[8] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Transaction mo11173a(String productId, String customerId, PaidApp response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[10] = true;
            if (response.isPaid()) {
                TransactionFactory transactionFactory2 = this.transactionFactory;
                BillingIdManager billingIdManager2 = this.billingIdManager;
                $jacocoInit[11] = true;
                long resolveProductId = billingIdManager2.resolveProductId(productId);
                $jacocoInit[12] = true;
                SimpleTransaction create = transactionFactory2.create(billingIdManager2.generateTransactionId(resolveProductId), customerId, productId, Status.PENDING_SERVICE_AUTHORIZATION);
                $jacocoInit[13] = true;
                return create;
            }
            TransactionFactory transactionFactory3 = this.transactionFactory;
            BillingIdManager billingIdManager3 = this.billingIdManager;
            $jacocoInit[14] = true;
            long resolveProductId2 = billingIdManager3.resolveProductId(productId);
            $jacocoInit[15] = true;
            SimpleTransaction create2 = transactionFactory3.create(billingIdManager3.generateTransactionId(resolveProductId2), customerId, productId, Status.COMPLETED);
            $jacocoInit[16] = true;
            return create2;
        }
        TransactionFactory transactionFactory4 = this.transactionFactory;
        BillingIdManager billingIdManager4 = this.billingIdManager;
        $jacocoInit[17] = true;
        String generateTransactionId = billingIdManager4.generateTransactionId(billingIdManager4.resolveProductId(productId));
        Status status = Status.FAILED;
        $jacocoInit[18] = true;
        SimpleTransaction create3 = transactionFactory4.create(generateTransactionId, customerId, productId, status);
        $jacocoInit[19] = true;
        return create3;
    }

    public Single<Transaction> createTransaction(String customerId, String productId, String serviceId, String payload, String token) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Transaction> a = Single.m735a((Throwable) new IllegalStateException("Not implemented!"));
        $jacocoInit[9] = true;
        return a;
    }
}
