package p005cm.aptoide.p006pt.billing.networking;

import android.content.SharedPreferences;
import android.content.res.Resources;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.Customer;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationFactory;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationService;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p005cm.aptoide.p006pt.billing.transaction.TransactionPersistence;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.App;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.Metadata;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.Path;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp.Payment;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.CreateTransactionRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GetApkInfoRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GetTransactionRequest;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.billing.networking.AuthorizationServiceV3 */
public class AuthorizationServiceV3 implements AuthorizationService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthorizationFactory authorizationFactory;
    private final AuthorizationMapperV3 authorizationMapper;
    private final BillingIdManager billingIdManager;
    private final BodyInterceptor<BaseBody> bodyInterceptorV3;
    private final Factory converterFactory;
    private final Customer customer;
    private final OkHttpClient httpClient;
    private final Resources resources;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;
    private final TransactionMapperV3 transactionMapper;
    private final TransactionPersistence transactionPersistence;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-217164414076698626L, "cm/aptoide/pt/billing/networking/AuthorizationServiceV3", 50);
        $jacocoData = probes;
        return probes;
    }

    public AuthorizationServiceV3(AuthorizationFactory authorizationFactory2, AuthorizationMapperV3 authorizationMapper2, TransactionMapperV3 transactionMapper2, TransactionPersistence transactionPersistence2, BodyInterceptor<BaseBody> bodyInterceptorV32, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, Customer customer2, Resources resources2, BillingIdManager billingIdManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authorizationFactory = authorizationFactory2;
        this.authorizationMapper = authorizationMapper2;
        this.transactionMapper = transactionMapper2;
        this.transactionPersistence = transactionPersistence2;
        this.bodyInterceptorV3 = bodyInterceptorV32;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.customer = customer2;
        this.resources = resources2;
        this.billingIdManager = billingIdManager2;
        $jacocoInit[0] = true;
    }

    public Single<Authorization> getAuthorization(String transactionId, String customerId) {
        boolean[] $jacocoInit = $jacocoInit();
        GetApkInfoRequest of = GetApkInfoRequest.m7448of(this.billingIdManager.resolveTransactionId(transactionId), this.bodyInterceptorV3, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.resources);
        $jacocoInit[1] = true;
        C0120S observe = of.observe(false);
        $jacocoInit[2] = true;
        Single n = observe.mo3678n();
        C2308a aVar = new C2308a(this, customerId, transactionId);
        $jacocoInit[3] = true;
        Single<Authorization> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) aVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11149a(String customerId, String transactionId, PaidApp response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isOk()) {
            $jacocoInit[32] = true;
            if (response.isPaid()) {
                $jacocoInit[33] = true;
                Payment payment = response.getPayment();
                $jacocoInit[34] = true;
                Metadata metadata = payment.getMetadata();
                $jacocoInit[35] = true;
                long productId = (long) metadata.getProductId();
                BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorV3;
                OkHttpClient okHttpClient = this.httpClient;
                Factory factory = this.converterFactory;
                TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
                SharedPreferences sharedPreferences2 = this.sharedPreferences;
                $jacocoInit[36] = true;
                GetTransactionRequest of = GetTransactionRequest.m7450of(productId, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2);
                $jacocoInit[37] = true;
                C0120S observe = of.observe(true);
                $jacocoInit[38] = true;
                Single n = observe.mo3678n();
                C2309b bVar = new C2309b(this, customerId, transactionId, response);
                $jacocoInit[39] = true;
                Single d = n.mo3698d(bVar);
                $jacocoInit[40] = true;
                return d;
            }
            String str = customerId;
            String str2 = transactionId;
            PaidApp paidApp = response;
            AuthorizationFactory authorizationFactory2 = this.authorizationFactory;
            BillingIdManager billingIdManager2 = this.billingIdManager;
            $jacocoInit[41] = true;
            String str3 = customerId;
            Authorization create = authorizationFactory2.create(billingIdManager2.generateAuthorizationId(1), str3, AuthorizationFactory.PAYPAL_SDK, Status.REDEEMED, null, null, null, null, null, transactionId, null);
            $jacocoInit[42] = true;
            Single a = Single.m734a(create);
            $jacocoInit[43] = true;
            return a;
        }
        AuthorizationFactory authorizationFactory3 = this.authorizationFactory;
        BillingIdManager billingIdManager3 = this.billingIdManager;
        $jacocoInit[44] = true;
        String str4 = customerId;
        Authorization create2 = authorizationFactory3.create(billingIdManager3.generateAuthorizationId(1), str4, AuthorizationFactory.PAYPAL_SDK, Status.FAILED, null, null, null, null, null, transactionId, null);
        $jacocoInit[45] = true;
        Single a2 = Single.m734a(create2);
        $jacocoInit[46] = true;
        return a2;
    }

    /* renamed from: a */
    public /* synthetic */ Authorization mo11148a(String customerId, String transactionId, PaidApp response, TransactionResponse transactionResponse) {
        boolean[] $jacocoInit = $jacocoInit();
        AuthorizationMapperV3 authorizationMapperV3 = this.authorizationMapper;
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[47] = true;
        String generateAuthorizationId = billingIdManager2.generateAuthorizationId(1);
        $jacocoInit[48] = true;
        Authorization map = authorizationMapperV3.map(generateAuthorizationId, customerId, transactionId, transactionResponse, response);
        $jacocoInit[49] = true;
        return map;
    }

    public Single<Authorization> updateAuthorization(String customerId, String transactionId, String metadata) {
        boolean[] $jacocoInit = $jacocoInit();
        GetApkInfoRequest of = GetApkInfoRequest.m7448of(this.billingIdManager.resolveTransactionId(transactionId), this.bodyInterceptorV3, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.resources);
        $jacocoInit[5] = true;
        C0120S observe = of.observe(true);
        $jacocoInit[6] = true;
        Single n = observe.mo3678n();
        C2310c cVar = new C2310c(this, metadata, customerId, transactionId);
        $jacocoInit[7] = true;
        Single<Authorization> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) cVar);
        $jacocoInit[8] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11150a(String metadata, String customerId, String transactionId, PaidApp paidApp) {
        boolean[] $jacocoInit = $jacocoInit();
        if (paidApp.isOk()) {
            $jacocoInit[9] = true;
            Payment payment = paidApp.getPayment();
            $jacocoInit[10] = true;
            Metadata metadata2 = payment.getMetadata();
            $jacocoInit[11] = true;
            int productId = metadata2.getProductId();
            Path path = paidApp.getPath();
            $jacocoInit[12] = true;
            String storeName = path.getStoreName();
            BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorV3;
            OkHttpClient okHttpClient = this.httpClient;
            Factory factory = this.converterFactory;
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            $jacocoInit[13] = true;
            App app = paidApp.getApp();
            $jacocoInit[14] = true;
            String name = app.getName();
            $jacocoInit[15] = true;
            CreateTransactionRequest of = CreateTransactionRequest.m7445of(productId, 1, storeName, metadata, bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, 3, name);
            $jacocoInit[16] = true;
            C0120S observe = of.observe(true);
            $jacocoInit[17] = true;
            Single n = observe.mo3678n();
            C2311d dVar = new C2311d(this, customerId, transactionId, paidApp);
            $jacocoInit[18] = true;
            Single a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) dVar);
            $jacocoInit[19] = true;
            return a;
        }
        String str = customerId;
        String str2 = transactionId;
        PaidApp paidApp2 = paidApp;
        AuthorizationFactory authorizationFactory2 = this.authorizationFactory;
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[20] = true;
        String str3 = customerId;
        Authorization create = authorizationFactory2.create(billingIdManager2.generateAuthorizationId(1), str3, AuthorizationFactory.PAYPAL_SDK, Status.FAILED, null, null, null, null, null, transactionId, null);
        $jacocoInit[21] = true;
        Single a2 = Single.m734a(create);
        $jacocoInit[22] = true;
        return a2;
    }

    /* renamed from: b */
    public /* synthetic */ Single mo11151b(String customerId, String transactionId, PaidApp paidApp, TransactionResponse response) {
        boolean[] $jacocoInit = $jacocoInit();
        AuthorizationMapperV3 authorizationMapperV3 = this.authorizationMapper;
        BillingIdManager billingIdManager2 = this.billingIdManager;
        $jacocoInit[23] = true;
        Authorization authorization = authorizationMapperV3.map(billingIdManager2.generateAuthorizationId(1), customerId, transactionId, response, paidApp);
        $jacocoInit[24] = true;
        if (authorization.isActive()) {
            TransactionPersistence transactionPersistence2 = this.transactionPersistence;
            TransactionMapperV3 transactionMapperV3 = this.transactionMapper;
            BillingIdManager billingIdManager3 = this.billingIdManager;
            $jacocoInit[25] = true;
            long resolveTransactionId = billingIdManager3.resolveTransactionId(transactionId);
            $jacocoInit[26] = true;
            String generateProductId = billingIdManager3.generateProductId(resolveTransactionId);
            $jacocoInit[27] = true;
            Transaction map = transactionMapperV3.map(customerId, transactionId, response, generateProductId);
            $jacocoInit[28] = true;
            C0117M saveTransaction = transactionPersistence2.saveTransaction(map);
            $jacocoInit[29] = true;
            Single a = saveTransaction.mo3587a(Single.m734a(authorization));
            $jacocoInit[30] = true;
            return a;
        }
        Single a2 = Single.m734a(authorization);
        $jacocoInit[31] = true;
        return a2;
    }
}
