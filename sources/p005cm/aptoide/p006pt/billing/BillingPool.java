package p005cm.aptoide.p006pt.billing;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.AptoideAccountManager;
import p005cm.aptoide.analytics.implementation.CrashLogger;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationFactory;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationPersistence;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationRepository;
import p005cm.aptoide.p006pt.billing.authorization.LocalIdGenerator;
import p005cm.aptoide.p006pt.billing.customer.AccountCustomer;
import p005cm.aptoide.p006pt.billing.external.ExternalBillingSerializer;
import p005cm.aptoide.p006pt.billing.networking.AuthorizationMapperV3;
import p005cm.aptoide.p006pt.billing.networking.AuthorizationMapperV7;
import p005cm.aptoide.p006pt.billing.networking.AuthorizationServiceV3;
import p005cm.aptoide.p006pt.billing.networking.AuthorizationServiceV7;
import p005cm.aptoide.p006pt.billing.networking.BillingIdManagerV3;
import p005cm.aptoide.p006pt.billing.networking.BillingIdManagerV7;
import p005cm.aptoide.p006pt.billing.networking.BillingServiceV3;
import p005cm.aptoide.p006pt.billing.networking.BillingServiceV7;
import p005cm.aptoide.p006pt.billing.networking.PaymentServiceMapper;
import p005cm.aptoide.p006pt.billing.networking.ProductMapperV3;
import p005cm.aptoide.p006pt.billing.networking.ProductMapperV7;
import p005cm.aptoide.p006pt.billing.networking.PurchaseMapperV3;
import p005cm.aptoide.p006pt.billing.networking.PurchaseMapperV7;
import p005cm.aptoide.p006pt.billing.networking.TransactionMapperV3;
import p005cm.aptoide.p006pt.billing.networking.TransactionMapperV7;
import p005cm.aptoide.p006pt.billing.networking.TransactionServiceV3;
import p005cm.aptoide.p006pt.billing.networking.TransactionServiceV7;
import p005cm.aptoide.p006pt.billing.payment.Adyen;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.payment.SharedPreferencesPaymentServiceSelector;
import p005cm.aptoide.p006pt.billing.persistence.InMemoryTransactionPersistence;
import p005cm.aptoide.p006pt.billing.persistence.RealmAuthorizationMapper;
import p005cm.aptoide.p006pt.billing.persistence.RealmAuthorizationPersistence;
import p005cm.aptoide.p006pt.billing.purchase.Base64PurchaseTokenDecoder;
import p005cm.aptoide.p006pt.billing.purchase.PurchaseFactory;
import p005cm.aptoide.p006pt.billing.sync.BillingSyncFactory;
import p005cm.aptoide.p006pt.billing.sync.BillingSyncManager;
import p005cm.aptoide.p006pt.billing.transaction.TransactionFactory;
import p005cm.aptoide.p006pt.billing.transaction.TransactionPersistence;
import p005cm.aptoide.p006pt.billing.transaction.TransactionRepository;
import p005cm.aptoide.p006pt.billing.transaction.TransactionService;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.database.accessors.Database;
import p005cm.aptoide.p006pt.dataprovider.WebService;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p005cm.aptoide.p006pt.networking.AuthenticationPersistence;
import p005cm.aptoide.p006pt.preferences.Preferences;
import p005cm.aptoide.p006pt.sync.SyncScheduler;
import p019d.p022i.p023b.C0100e;
import p026rx.C0126V;
import p026rx.schedulers.Schedulers;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.billing.BillingPool */
public class BillingPool {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AptoideAccountManager accountManager;
    private final BodyInterceptor<BaseBody> accountSettingsBodyInterceptorPoolV7;

    /* renamed from: adyen reason: collision with root package name */
    private final Adyen f44398adyen;
    private final AuthenticationPersistence authenticationPersistence;
    private AuthorizationFactory authorizationFactory;
    private AuthorizationPersistence authorizationPersistence;
    private BillingIdManager billingIdManagerV3;
    private BillingIdManager billingIdManagerV7;
    private BillingService billingServiceV3;
    private BillingServiceV7 billingServiceV7;
    private BillingSyncScheduler billingSyncSchedulerV3;
    private BillingSyncScheduler billingSyncSchedulerV7;
    private final BodyInterceptor<BaseBody> bodyInterceptorPoolV7;
    private final BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV3;
    private final Factory converterFactory;
    private final CrashLogger crashLogger;
    private Customer customer;
    private final Database database;
    private final ExternalBillingSerializer externalBillingSerializer;
    private final OkHttpClient httpClient;
    private AuthorizationRepository inAppAuthorizationRepository;
    private TransactionRepository inAppTransactionRepository;
    private LocalIdGenerator localIdGenerator;
    private final int minimumAPILevelAdyen;
    private final int minimumAPILevelPayPal;
    private final PackageRepository packageRepository;
    private AuthorizationRepository paidAppAuthorizationRepository;
    private TransactionRepository paidAppTransactionRepository;
    private final Map<String, Billing> pool;
    private final Preferences preferences;
    private final PurchaseFactory purchaseFactory;
    private PurchaseTokenDecoder purchaseTokenDecoder;
    private final Resources resources;
    private PaymentServiceSelector serviceSelector;
    private final SharedPreferences sharedPreferences;
    private final SyncScheduler syncScheduler;
    private final TokenInvalidator tokenInvalidator;
    private TransactionFactory transactionFactory;
    private TransactionMapperV3 transactionMapperV3;
    private TransactionPersistence transactionPersistence;
    private TransactionService transactionServiceV3;
    private TransactionService transactionServiceV7;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(541555553058339637L, "cm/aptoide/pt/billing/BillingPool", 128);
        $jacocoData = probes;
        return probes;
    }

    public BillingPool(SharedPreferences sharedPreferences2, BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptorV32, OkHttpClient httpClient2, AptoideAccountManager accountManager2, Database database2, Resources resources2, PackageRepository packageRepository2, TokenInvalidator tokenInvalidator2, SyncScheduler syncScheduler2, ExternalBillingSerializer externalBillingSerializer2, BodyInterceptor<BaseBody> bodyInterceptorPoolV72, BodyInterceptor<BaseBody> accountSettingsBodyInterceptorPoolV72, HashMap<String, Billing> poll, Factory converterFactory2, CrashReport crashLogger2, Adyen adyen2, PurchaseFactory purchaseFactory2, int minimumAPILevelPayPal2, int minimumAPILevelAdyen2, AuthenticationPersistence authenticationPersistence2, Preferences preferences2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.sharedPreferences = sharedPreferences2;
        this.pool = poll;
        this.bodyInterceptorV3 = bodyInterceptorV32;
        this.httpClient = httpClient2;
        this.accountManager = accountManager2;
        this.database = database2;
        this.resources = resources2;
        this.packageRepository = packageRepository2;
        this.tokenInvalidator = tokenInvalidator2;
        this.syncScheduler = syncScheduler2;
        this.externalBillingSerializer = externalBillingSerializer2;
        this.bodyInterceptorPoolV7 = bodyInterceptorPoolV72;
        this.accountSettingsBodyInterceptorPoolV7 = accountSettingsBodyInterceptorPoolV72;
        this.converterFactory = converterFactory2;
        this.crashLogger = crashLogger2;
        this.f44398adyen = adyen2;
        this.purchaseFactory = purchaseFactory2;
        this.minimumAPILevelPayPal = minimumAPILevelPayPal2;
        this.minimumAPILevelAdyen = minimumAPILevelAdyen2;
        this.authenticationPersistence = authenticationPersistence2;
        this.preferences = preferences2;
        $jacocoInit[0] = true;
    }

    public Billing get(String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.pool.containsKey(merchantName)) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            this.pool.put(merchantName, create(merchantName));
            $jacocoInit[3] = true;
        }
        Billing billing = (Billing) this.pool.get(merchantName);
        $jacocoInit[4] = true;
        return billing;
    }

    public BillingIdManager getIdResolver(String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (merchantName.equals("cm.aptoide.pt")) {
            $jacocoInit[5] = true;
            BillingIdManager billingIdManagerV32 = getBillingIdManagerV3();
            $jacocoInit[6] = true;
            return billingIdManagerV32;
        }
        BillingIdManager billingIdManagerV72 = getBillingIdManagerV7();
        $jacocoInit[7] = true;
        return billingIdManagerV72;
    }

    private Billing create(String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        if (merchantName.equals("cm.aptoide.pt")) {
            $jacocoInit[8] = true;
            BillingService billingServiceV32 = getBillingServiceV3();
            TransactionRepository paidAppTransactionRepository2 = getPaidAppTransactionRepository();
            $jacocoInit[9] = true;
            AuthorizationRepository paidAppAuthorizationRepository2 = getPaidAppAuthorizationRepository();
            PaymentServiceSelector serviceSelector2 = getServiceSelector();
            Customer customer2 = getCustomer();
            $jacocoInit[10] = true;
            Billing billing = new Billing(merchantName, billingServiceV32, paidAppTransactionRepository2, paidAppAuthorizationRepository2, serviceSelector2, customer2, getPurchaseTokenDecoder(), getBillingSyncSchedulerV3());
            $jacocoInit[11] = true;
            return billing;
        }
        BillingService billingServiceV72 = getBillingServiceV7();
        TransactionRepository inAppTransactionRepository2 = getInAppTransactionRepository();
        $jacocoInit[12] = true;
        AuthorizationRepository inAppAuthorizationRepository2 = getInAppAuthorizationRepository();
        PaymentServiceSelector serviceSelector3 = getServiceSelector();
        Customer customer3 = getCustomer();
        $jacocoInit[13] = true;
        Billing billing2 = new Billing(merchantName, billingServiceV72, inAppTransactionRepository2, inAppAuthorizationRepository2, serviceSelector3, customer3, getPurchaseTokenDecoder(), getBillingSyncSchedulerV7());
        $jacocoInit[14] = true;
        return billing2;
    }

    private TransactionRepository getPaidAppTransactionRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.paidAppAuthorizationRepository != null) {
            $jacocoInit[15] = true;
        } else {
            $jacocoInit[16] = true;
            TransactionPersistence transactionPersistence2 = getTransactionPersistence();
            BillingSyncScheduler billingSyncSchedulerV32 = getBillingSyncSchedulerV3();
            $jacocoInit[17] = true;
            this.paidAppTransactionRepository = new TransactionRepository(transactionPersistence2, billingSyncSchedulerV32, getCustomer(), getTransactionServiceV3());
            $jacocoInit[18] = true;
        }
        TransactionRepository transactionRepository = this.paidAppTransactionRepository;
        $jacocoInit[19] = true;
        return transactionRepository;
    }

    private AuthorizationRepository getPaidAppAuthorizationRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.paidAppAuthorizationRepository != null) {
            $jacocoInit[20] = true;
        } else {
            $jacocoInit[21] = true;
            BillingSyncScheduler billingSyncSchedulerV32 = getBillingSyncSchedulerV3();
            Customer customer2 = getCustomer();
            $jacocoInit[22] = true;
            this.paidAppAuthorizationRepository = new AuthorizationRepository(billingSyncSchedulerV32, customer2, getAuthorizationPersistence(), this.authorizationFactory);
            $jacocoInit[23] = true;
        }
        AuthorizationRepository authorizationRepository = this.paidAppAuthorizationRepository;
        $jacocoInit[24] = true;
        return authorizationRepository;
    }

    private BillingService getBillingServiceV3() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.billingServiceV3 != null) {
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptor = this.bodyInterceptorV3;
            OkHttpClient okHttpClient = this.httpClient;
            Factory factory = this.converterFactory;
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            PurchaseMapperV3 purchaseMapperV3 = new PurchaseMapperV3(this.purchaseFactory);
            $jacocoInit[27] = true;
            ProductMapperV3 productMapperV3 = new ProductMapperV3(getBillingIdManagerV3());
            Resources resources2 = this.resources;
            $jacocoInit[28] = true;
            PaymentService paymentService = new PaymentService(getBillingIdManagerV3().generateServiceId(1), "PAYPAL", "PayPal", null, "");
            $jacocoInit[29] = true;
            BillingServiceV3 billingServiceV32 = new BillingServiceV3(bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, purchaseMapperV3, productMapperV3, resources2, paymentService, getBillingIdManagerV3(), VERSION.SDK_INT, this.minimumAPILevelPayPal);
            this.billingServiceV3 = billingServiceV32;
            $jacocoInit[30] = true;
        }
        BillingService billingService = this.billingServiceV3;
        $jacocoInit[31] = true;
        return billingService;
    }

    private BillingService getBillingServiceV7() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = true;
        if (this.billingServiceV7 != null) {
            $jacocoInit[32] = true;
        } else {
            BodyInterceptor<BaseBody> bodyInterceptor = this.accountSettingsBodyInterceptorPoolV7;
            OkHttpClient okHttpClient = this.httpClient;
            Factory factory = this.converterFactory;
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            ExternalBillingSerializer externalBillingSerializer2 = this.externalBillingSerializer;
            $jacocoInit[33] = true;
            PurchaseMapperV7 purchaseMapperV7 = new PurchaseMapperV7(externalBillingSerializer2, getBillingIdManagerV7(), this.purchaseFactory);
            $jacocoInit[34] = true;
            ProductMapperV7 productMapperV7 = new ProductMapperV7(getBillingIdManagerV7());
            PackageRepository packageRepository2 = this.packageRepository;
            CrashLogger crashLogger2 = this.crashLogger;
            $jacocoInit[35] = true;
            BillingIdManager billingIdManagerV72 = getBillingIdManagerV7();
            Adyen adyen2 = this.f44398adyen;
            Adyen adyen3 = adyen2;
            PaymentServiceMapper paymentServiceMapper = new PaymentServiceMapper(crashLogger2, billingIdManagerV72, adyen3, VERSION.SDK_INT, this.minimumAPILevelAdyen, this.minimumAPILevelPayPal);
            $jacocoInit[36] = true;
            BillingServiceV7 billingServiceV72 = new BillingServiceV7(bodyInterceptor, okHttpClient, factory, tokenInvalidator2, sharedPreferences2, purchaseMapperV7, productMapperV7, packageRepository2, paymentServiceMapper, getBillingIdManagerV7(), this.purchaseFactory);
            this.billingServiceV7 = billingServiceV72;
            z = true;
            $jacocoInit[37] = true;
        }
        BillingServiceV7 billingServiceV73 = this.billingServiceV7;
        $jacocoInit[38] = z;
        return billingServiceV73;
    }

    private AuthorizationRepository getInAppAuthorizationRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.inAppAuthorizationRepository != null) {
            $jacocoInit[39] = true;
        } else {
            $jacocoInit[40] = true;
            BillingSyncScheduler billingSyncSchedulerV72 = getBillingSyncSchedulerV7();
            Customer customer2 = getCustomer();
            $jacocoInit[41] = true;
            this.inAppAuthorizationRepository = new AuthorizationRepository(billingSyncSchedulerV72, customer2, getAuthorizationPersistence(), this.authorizationFactory);
            $jacocoInit[42] = true;
        }
        AuthorizationRepository authorizationRepository = this.inAppAuthorizationRepository;
        $jacocoInit[43] = true;
        return authorizationRepository;
    }

    private TransactionRepository getInAppTransactionRepository() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.inAppTransactionRepository != null) {
            $jacocoInit[44] = true;
        } else {
            $jacocoInit[45] = true;
            TransactionPersistence transactionPersistence2 = getTransactionPersistence();
            BillingSyncScheduler billingSyncSchedulerV72 = getBillingSyncSchedulerV7();
            $jacocoInit[46] = true;
            this.inAppTransactionRepository = new TransactionRepository(transactionPersistence2, billingSyncSchedulerV72, getCustomer(), getTransactionServiceV7());
            $jacocoInit[47] = true;
        }
        TransactionRepository transactionRepository = this.inAppTransactionRepository;
        $jacocoInit[48] = true;
        return transactionRepository;
    }

    private PurchaseTokenDecoder getPurchaseTokenDecoder() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.purchaseTokenDecoder != null) {
            $jacocoInit[49] = true;
        } else {
            $jacocoInit[50] = true;
            this.purchaseTokenDecoder = new Base64PurchaseTokenDecoder();
            $jacocoInit[51] = true;
        }
        PurchaseTokenDecoder purchaseTokenDecoder2 = this.purchaseTokenDecoder;
        $jacocoInit[52] = true;
        return purchaseTokenDecoder2;
    }

    private PaymentServiceSelector getServiceSelector() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.serviceSelector != null) {
            $jacocoInit[53] = true;
        } else {
            $jacocoInit[54] = true;
            this.serviceSelector = new SharedPreferencesPaymentServiceSelector("PAYPAL", this.preferences);
            $jacocoInit[55] = true;
        }
        PaymentServiceSelector paymentServiceSelector = this.serviceSelector;
        $jacocoInit[56] = true;
        return paymentServiceSelector;
    }

    private BillingSyncScheduler getBillingSyncSchedulerV7() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.billingSyncSchedulerV7 != null) {
            $jacocoInit[57] = true;
        } else {
            $jacocoInit[58] = true;
            Customer customer2 = getCustomer();
            TransactionService transactionServiceV72 = getTransactionServiceV7();
            $jacocoInit[59] = true;
            AuthorizationMapperV7 authorizationMapperV7 = new AuthorizationMapperV7(getAuthorizationFactory(), getBillingIdManagerV7());
            OkHttpClient okHttpClient = this.httpClient;
            $jacocoInit[60] = true;
            Factory defaultConverter = WebService.getDefaultConverter();
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorPoolV7;
            $jacocoInit[61] = true;
            AuthorizationServiceV7 authorizationServiceV7 = new AuthorizationServiceV7(authorizationMapperV7, okHttpClient, defaultConverter, tokenInvalidator2, sharedPreferences2, bodyInterceptor, getBillingIdManagerV7(), getAuthorizationFactory(), this.authenticationPersistence);
            $jacocoInit[62] = true;
            TransactionPersistence transactionPersistence2 = getTransactionPersistence();
            $jacocoInit[63] = true;
            BillingSyncFactory billingSyncFactory = new BillingSyncFactory(customer2, transactionServiceV72, authorizationServiceV7, transactionPersistence2, getAuthorizationPersistence(), getLocalIdGenerator());
            this.billingSyncSchedulerV7 = new BillingSyncManager(billingSyncFactory, this.syncScheduler, new HashSet(), new HashMap());
            $jacocoInit[64] = true;
        }
        BillingSyncScheduler billingSyncScheduler = this.billingSyncSchedulerV7;
        $jacocoInit[65] = true;
        return billingSyncScheduler;
    }

    private BillingSyncScheduler getBillingSyncSchedulerV3() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.billingSyncSchedulerV3 != null) {
            $jacocoInit[66] = true;
        } else {
            $jacocoInit[67] = true;
            Customer customer2 = getCustomer();
            TransactionService transactionServiceV32 = getTransactionServiceV3();
            $jacocoInit[68] = true;
            AuthorizationFactory authorizationFactory2 = getAuthorizationFactory();
            $jacocoInit[69] = true;
            AuthorizationMapperV3 authorizationMapperV3 = new AuthorizationMapperV3(getAuthorizationFactory());
            TransactionMapperV3 transactionMapperV32 = getTransactionMapperV3();
            $jacocoInit[70] = true;
            TransactionPersistence transactionPersistence2 = getTransactionPersistence();
            BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptor = this.bodyInterceptorV3;
            OkHttpClient okHttpClient = this.httpClient;
            $jacocoInit[71] = true;
            Factory defaultConverter = WebService.getDefaultConverter();
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            Customer customer3 = this.customer;
            Resources resources2 = this.resources;
            $jacocoInit[72] = true;
            BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptor2 = bodyInterceptor;
            OkHttpClient okHttpClient2 = okHttpClient;
            TokenInvalidator tokenInvalidator3 = tokenInvalidator2;
            SharedPreferences sharedPreferences3 = sharedPreferences2;
            AuthorizationServiceV3 authorizationServiceV3 = new AuthorizationServiceV3(authorizationFactory2, authorizationMapperV3, transactionMapperV32, transactionPersistence2, bodyInterceptor2, okHttpClient2, defaultConverter, tokenInvalidator3, sharedPreferences3, customer3, resources2, getBillingIdManagerV3());
            TransactionPersistence transactionPersistence3 = getTransactionPersistence();
            $jacocoInit[73] = true;
            BillingSyncFactory billingSyncFactory = new BillingSyncFactory(customer2, transactionServiceV32, authorizationServiceV3, transactionPersistence3, getAuthorizationPersistence(), getLocalIdGenerator());
            BillingSyncManager billingSyncManager = new BillingSyncManager(billingSyncFactory, this.syncScheduler, new HashSet(), new HashMap());
            this.billingSyncSchedulerV3 = billingSyncManager;
            $jacocoInit[74] = true;
        }
        BillingSyncScheduler billingSyncScheduler = this.billingSyncSchedulerV3;
        $jacocoInit[75] = true;
        return billingSyncScheduler;
    }

    private TransactionService getTransactionServiceV7() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.transactionServiceV7 != null) {
            $jacocoInit[76] = true;
        } else {
            $jacocoInit[77] = true;
            TransactionMapperV7 transactionMapperV7 = new TransactionMapperV7(getTransactionFactory(), getBillingIdManagerV7());
            BodyInterceptor<BaseBody> bodyInterceptor = this.bodyInterceptorPoolV7;
            $jacocoInit[78] = true;
            Factory defaultConverter = WebService.getDefaultConverter();
            OkHttpClient okHttpClient = this.httpClient;
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            $jacocoInit[79] = true;
            TransactionServiceV7 transactionServiceV72 = new TransactionServiceV7(transactionMapperV7, bodyInterceptor, defaultConverter, okHttpClient, tokenInvalidator2, sharedPreferences2, getBillingIdManagerV7(), getTransactionFactory(), this.authenticationPersistence);
            this.transactionServiceV7 = transactionServiceV72;
            $jacocoInit[80] = true;
        }
        TransactionService transactionService = this.transactionServiceV7;
        $jacocoInit[81] = true;
        return transactionService;
    }

    private TransactionService getTransactionServiceV3() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.transactionServiceV3 != null) {
            $jacocoInit[82] = true;
        } else {
            $jacocoInit[83] = true;
            TransactionMapperV3 transactionMapperV32 = getTransactionMapperV3();
            BodyInterceptor<p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody> bodyInterceptor = this.bodyInterceptorV3;
            $jacocoInit[84] = true;
            Factory defaultConverter = WebService.getDefaultConverter();
            OkHttpClient okHttpClient = this.httpClient;
            TokenInvalidator tokenInvalidator2 = this.tokenInvalidator;
            SharedPreferences sharedPreferences2 = this.sharedPreferences;
            $jacocoInit[85] = true;
            TransactionServiceV3 transactionServiceV32 = new TransactionServiceV3(transactionMapperV32, bodyInterceptor, defaultConverter, okHttpClient, tokenInvalidator2, sharedPreferences2, getTransactionFactory(), this.resources, getBillingIdManagerV3());
            this.transactionServiceV3 = transactionServiceV32;
            $jacocoInit[86] = true;
        }
        TransactionService transactionService = this.transactionServiceV3;
        $jacocoInit[87] = true;
        return transactionService;
    }

    private TransactionMapperV3 getTransactionMapperV3() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.transactionMapperV3 != null) {
            $jacocoInit[88] = true;
        } else {
            $jacocoInit[89] = true;
            this.transactionMapperV3 = new TransactionMapperV3(getTransactionFactory(), getBillingIdManagerV3());
            $jacocoInit[90] = true;
        }
        TransactionMapperV3 transactionMapperV32 = this.transactionMapperV3;
        $jacocoInit[91] = true;
        return transactionMapperV32;
    }

    private AuthorizationPersistence getAuthorizationPersistence() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.authorizationPersistence != null) {
            $jacocoInit[92] = true;
        } else {
            $jacocoInit[93] = true;
            HashMap hashMap = new HashMap();
            $jacocoInit[94] = true;
            C0100e o = C0100e.m565o();
            Database database2 = this.database;
            $jacocoInit[95] = true;
            RealmAuthorizationMapper realmAuthorizationMapper = new RealmAuthorizationMapper(getAuthorizationFactory());
            C0126V io = Schedulers.m776io();
            $jacocoInit[96] = true;
            RealmAuthorizationPersistence realmAuthorizationPersistence = new RealmAuthorizationPersistence(hashMap, o, database2, realmAuthorizationMapper, io, getAuthorizationFactory(), getLocalIdGenerator());
            this.authorizationPersistence = realmAuthorizationPersistence;
            $jacocoInit[97] = true;
        }
        AuthorizationPersistence authorizationPersistence2 = this.authorizationPersistence;
        $jacocoInit[98] = true;
        return authorizationPersistence2;
    }

    private LocalIdGenerator getLocalIdGenerator() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.localIdGenerator != null) {
            $jacocoInit[99] = true;
        } else {
            $jacocoInit[100] = true;
            this.localIdGenerator = new LocalIdGenerator();
            $jacocoInit[101] = true;
        }
        LocalIdGenerator localIdGenerator2 = this.localIdGenerator;
        $jacocoInit[102] = true;
        return localIdGenerator2;
    }

    private TransactionPersistence getTransactionPersistence() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.transactionPersistence != null) {
            $jacocoInit[103] = true;
        } else {
            $jacocoInit[104] = true;
            HashMap hashMap = new HashMap();
            $jacocoInit[105] = true;
            this.transactionPersistence = new InMemoryTransactionPersistence(hashMap, C0100e.m565o());
            $jacocoInit[106] = true;
        }
        TransactionPersistence transactionPersistence2 = this.transactionPersistence;
        $jacocoInit[107] = true;
        return transactionPersistence2;
    }

    private AuthorizationFactory getAuthorizationFactory() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.authorizationFactory != null) {
            $jacocoInit[108] = true;
        } else {
            $jacocoInit[109] = true;
            this.authorizationFactory = new AuthorizationFactory();
            $jacocoInit[110] = true;
        }
        AuthorizationFactory authorizationFactory2 = this.authorizationFactory;
        $jacocoInit[111] = true;
        return authorizationFactory2;
    }

    private Customer getCustomer() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.customer != null) {
            $jacocoInit[112] = true;
        } else {
            $jacocoInit[113] = true;
            this.customer = new AccountCustomer(this.accountManager);
            $jacocoInit[114] = true;
        }
        Customer customer2 = this.customer;
        $jacocoInit[115] = true;
        return customer2;
    }

    private TransactionFactory getTransactionFactory() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.transactionFactory != null) {
            $jacocoInit[116] = true;
        } else {
            $jacocoInit[117] = true;
            this.transactionFactory = new TransactionFactory();
            $jacocoInit[118] = true;
        }
        TransactionFactory transactionFactory2 = this.transactionFactory;
        $jacocoInit[119] = true;
        return transactionFactory2;
    }

    private BillingIdManager getBillingIdManagerV7() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.billingIdManagerV7 != null) {
            $jacocoInit[120] = true;
        } else {
            $jacocoInit[121] = true;
            this.billingIdManagerV7 = new BillingIdManagerV7(getLocalIdGenerator());
            $jacocoInit[122] = true;
        }
        BillingIdManager billingIdManager = this.billingIdManagerV7;
        $jacocoInit[123] = true;
        return billingIdManager;
    }

    private BillingIdManager getBillingIdManagerV3() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.billingIdManagerV3 != null) {
            $jacocoInit[124] = true;
        } else {
            $jacocoInit[125] = true;
            this.billingIdManagerV3 = new BillingIdManagerV3(getLocalIdGenerator());
            $jacocoInit[126] = true;
        }
        BillingIdManager billingIdManager = this.billingIdManagerV3;
        $jacocoInit[127] = true;
        return billingIdManager;
    }
}
