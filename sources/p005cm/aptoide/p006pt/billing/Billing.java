package p005cm.aptoide.p006pt.billing;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationRepository;
import p005cm.aptoide.p006pt.billing.exception.PaymentFailureException;
import p005cm.aptoide.p006pt.billing.exception.ServiceNotAuthorizedException;
import p005cm.aptoide.p006pt.billing.payment.AdyenPaymentService;
import p005cm.aptoide.p006pt.billing.payment.Payment;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.billing.transaction.AuthorizedTransaction;
import p005cm.aptoide.p006pt.billing.transaction.Transaction;
import p005cm.aptoide.p006pt.billing.transaction.TransactionRepository;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0131o;
import p026rx.p027b.C0132p;
import p026rx.p027b.C14541q;

/* renamed from: cm.aptoide.pt.billing.Billing */
public class Billing {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthorizationRepository authorizationRepository;
    private final BillingService billingService;
    private final Customer customer;
    private final String merchantName;
    private final PaymentServiceSelector paymentServiceSelector;
    private final BillingSyncScheduler syncScheduler;
    private final PurchaseTokenDecoder tokenDecoder;
    private final TransactionRepository transactionRepository;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2166509049774917872L, "cm/aptoide/pt/billing/Billing", 82);
        $jacocoData = probes;
        return probes;
    }

    public Billing(String merchantName2, BillingService billingService2, TransactionRepository transactionRepository2, AuthorizationRepository authorizationRepository2, PaymentServiceSelector paymentServiceSelector2, Customer customer2, PurchaseTokenDecoder tokenDecoder2, BillingSyncScheduler syncScheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.transactionRepository = transactionRepository2;
        this.billingService = billingService2;
        this.authorizationRepository = authorizationRepository2;
        this.paymentServiceSelector = paymentServiceSelector2;
        this.customer = customer2;
        this.tokenDecoder = tokenDecoder2;
        this.merchantName = merchantName2;
        this.syncScheduler = syncScheduler2;
        $jacocoInit[0] = true;
    }

    public Customer getCustomer() {
        boolean[] $jacocoInit = $jacocoInit();
        Customer customer2 = this.customer;
        $jacocoInit[1] = true;
        return customer2;
    }

    public Single<Merchant> getMerchant() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Merchant> merchant = this.billingService.getMerchant(this.merchantName);
        $jacocoInit[2] = true;
        return merchant;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo827a(String sku, List services) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = getProduct(sku).mo3697c(new C2304k(this, services));
        $jacocoInit[76] = true;
        return c;
    }

    public C0120S<Payment> getPayment(String sku) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<Payment> c = getPaymentServices().mo3697c(new C2334p(this, sku));
        $jacocoInit[3] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo829a(List services, Product product) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S n = getAuthorizedTransaction(product).mo3677n(new C2290b(this, product, services));
        $jacocoInit[77] = true;
        return n;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo824a(Product product, List services, AuthorizedTransaction authorizedTransaction) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S selectedService = getSelectedService();
        $jacocoInit[78] = true;
        C0120S purchase = getPurchase(product);
        C2306m mVar = new C2306m(product, authorizedTransaction, services);
        $jacocoInit[79] = true;
        C0120S a = C0120S.m641a(selectedService, purchase, (C14541q<? super T1, ? super T2, ? extends R>) mVar);
        $jacocoInit[80] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ Payment m152a(Product product, AuthorizedTransaction authorizedTransaction, List services, PaymentService paymentService, Purchase purchase) {
        boolean[] $jacocoInit = $jacocoInit();
        Payment payment = new Payment(product, paymentService, authorizedTransaction, purchase, services);
        $jacocoInit[81] = true;
        return payment;
    }

    public Single<List<Product>> getProducts(List<String> skus) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<List<Product>> products = this.billingService.getProducts(this.merchantName, skus);
        $jacocoInit[4] = true;
        return products;
    }

    public Single<List<Purchase>> getPurchases() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<List<Purchase>> purchases = this.billingService.getPurchases(this.merchantName);
        $jacocoInit[5] = true;
        return purchases;
    }

    public C0117M consumePurchase(String purchaseToken) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M deletePurchase = this.billingService.deletePurchase(this.tokenDecoder.decode(purchaseToken));
        $jacocoInit[6] = true;
        return deletePurchase;
    }

    public C0117M processPayment(String sku, String payload) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getPayment(sku).mo3647d();
        $jacocoInit[7] = true;
        Single n = d.mo3678n();
        C2307n nVar = new C2307n(this, payload);
        $jacocoInit[8] = true;
        Single a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) nVar);
        C2305l lVar = new C2305l(this);
        $jacocoInit[9] = true;
        C0117M b = a.mo3693b((C0132p<? super T, ? extends C0117M>) lVar);
        $jacocoInit[10] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo831a(String payload, Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        if (payment.getSelectedPaymentService() instanceof AdyenPaymentService) {
            $jacocoInit[65] = true;
            Single token = ((AdyenPaymentService) payment.getSelectedPaymentService()).getToken();
            C2299f fVar = new C2299f(this, payment, payload);
            $jacocoInit[66] = true;
            Single a = token.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) fVar);
            $jacocoInit[67] = true;
            return a;
        }
        TransactionRepository transactionRepository2 = this.transactionRepository;
        Product product = payment.getProduct();
        $jacocoInit[68] = true;
        String id = product.getId();
        PaymentService selectedPaymentService = payment.getSelectedPaymentService();
        $jacocoInit[69] = true;
        String id2 = selectedPaymentService.getId();
        $jacocoInit[70] = true;
        Single createTransaction = transactionRepository2.createTransaction(id, id2, payload);
        $jacocoInit[71] = true;
        return createTransaction;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo830a(Payment payment, String payload, String token) {
        boolean[] $jacocoInit = $jacocoInit();
        TransactionRepository transactionRepository2 = this.transactionRepository;
        Product product = payment.getProduct();
        $jacocoInit[72] = true;
        String id = product.getId();
        PaymentService selectedPaymentService = payment.getSelectedPaymentService();
        $jacocoInit[73] = true;
        String id2 = selectedPaymentService.getId();
        $jacocoInit[74] = true;
        Single createTransaction = transactionRepository2.createTransaction(id, id2, payload, token);
        $jacocoInit[75] = true;
        return createTransaction;
    }

    /* renamed from: c */
    public /* synthetic */ C0117M mo833c(Transaction transaction) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = removeOldTransactions(transaction).mo3580a(C0117M.m586a((C0131o<? extends C0117M>) new C2333o<Object>(transaction)));
        $jacocoInit[59] = true;
        return a;
    }

    /* renamed from: b */
    static /* synthetic */ C0117M m156b(Transaction transaction) {
        boolean[] $jacocoInit = $jacocoInit();
        if (transaction.isPendingAuthorization()) {
            $jacocoInit[60] = true;
            C0117M b = C0117M.m591b((Throwable) new ServiceNotAuthorizedException("Pending service authorization."));
            $jacocoInit[61] = true;
            return b;
        } else if (transaction.isFailed()) {
            $jacocoInit[62] = true;
            C0117M b2 = C0117M.m591b((Throwable) new PaymentFailureException("Payment failed."));
            $jacocoInit[63] = true;
            return b2;
        } else {
            C0117M b3 = C0117M.m590b();
            $jacocoInit[64] = true;
            return b3;
        }
    }

    public C0117M authorize(String sku, String metadata) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S d = getPayment(sku).mo3647d();
        C2368r rVar = C2368r.f5521a;
        $jacocoInit[11] = true;
        $jacocoInit[12] = true;
        C0120S a = d.mo3669j(rVar).mo3611a(AuthorizedTransaction.class);
        $jacocoInit[13] = true;
        Single n = a.mo3678n();
        C2294d dVar = new C2294d(this, metadata);
        $jacocoInit[14] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) dVar);
        $jacocoInit[15] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ Transaction m153a(Payment payment) {
        boolean[] $jacocoInit = $jacocoInit();
        Transaction transaction = payment.getTransaction();
        $jacocoInit[58] = true;
        return transaction;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo823a(String metadata, AuthorizedTransaction authorizedTransaction) {
        boolean[] $jacocoInit = $jacocoInit();
        AuthorizationRepository authorizationRepository2 = this.authorizationRepository;
        $jacocoInit[54] = true;
        Authorization authorization = authorizedTransaction.getAuthorization();
        $jacocoInit[55] = true;
        String id = authorization.getId();
        Status status = Status.PENDING_SYNC;
        $jacocoInit[56] = true;
        C0117M updateAuthorization = authorizationRepository2.updateAuthorization(id, metadata, status);
        $jacocoInit[57] = true;
        return updateAuthorization;
    }

    public C0117M selectService(String serviceId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M b = getService(serviceId).mo3693b((C0132p<? super T, ? extends C0117M>) new C2301h<Object,Object>(this));
        $jacocoInit[16] = true;
        C0117M d = b.mo3602d();
        $jacocoInit[17] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo822a(PaymentService service) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M selectService = this.paymentServiceSelector.selectService(service);
        $jacocoInit[53] = true;
        return selectService;
    }

    public void stopSync() {
        boolean[] $jacocoInit = $jacocoInit();
        this.syncScheduler.stopSyncs();
        $jacocoInit[18] = true;
    }

    private C0120S<Purchase> getPurchase(Product product) {
        boolean[] $jacocoInit = $jacocoInit();
        Single purchase = this.billingService.getPurchase(product.getId());
        $jacocoInit[19] = true;
        C0120S<Purchase> c = purchase.mo3696c();
        $jacocoInit[20] = true;
        return c;
    }

    private Single<Product> getProduct(String sku) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Product> product = this.billingService.getProduct(sku, this.merchantName);
        $jacocoInit[21] = true;
        return product;
    }

    private C0120S<Authorization> getAuthorization(Transaction transaction) {
        boolean[] $jacocoInit = $jacocoInit();
        if (transaction.isNew()) {
            $jacocoInit[22] = true;
            Single createAuthorization = this.authorizationRepository.createAuthorization(transaction.getId(), Status.NEW);
            C2302i iVar = new C2302i(this, transaction);
            $jacocoInit[23] = true;
            C0120S<Authorization> c = createAuthorization.mo3697c(iVar);
            $jacocoInit[24] = true;
            return c;
        }
        C0120S<Authorization> authorization = this.authorizationRepository.getAuthorization(transaction.getId());
        $jacocoInit[25] = true;
        return authorization;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo826a(Transaction transaction, Authorization __) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S authorization = this.authorizationRepository.getAuthorization(transaction.getId());
        $jacocoInit[52] = true;
        return authorization;
    }

    private C0120S<AuthorizedTransaction> getAuthorizedTransaction(Product product) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S transaction = this.transactionRepository.getTransaction(product.getId());
        C2283a aVar = new C2283a(this);
        $jacocoInit[26] = true;
        C0120S<AuthorizedTransaction> n = transaction.mo3677n(aVar);
        $jacocoInit[27] = true;
        return n;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo825a(Transaction transaction) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S j = getAuthorization(transaction).mo3669j(new C2300g(transaction));
        $jacocoInit[50] = true;
        return j;
    }

    /* renamed from: b */
    static /* synthetic */ AuthorizedTransaction m155b(Transaction transaction, Authorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        AuthorizedTransaction authorizedTransaction = new AuthorizedTransaction(transaction, authorization);
        $jacocoInit[51] = true;
        return authorizedTransaction;
    }

    private C0120S<PaymentService> getSelectedService() {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S<PaymentService> c = getPaymentServices().mo3697c(new C2303j(this));
        $jacocoInit[28] = true;
        return c;
    }

    /* renamed from: a */
    public /* synthetic */ C0120S mo828a(List services) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S selectedService = this.paymentServiceSelector.getSelectedService(services);
        $jacocoInit[49] = true;
        return selectedService;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m157b(String serviceId, List payments) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) payments);
        C2367q qVar = new C2367q(serviceId);
        $jacocoInit[42] = true;
        C0120S d = a.mo3653d((C0132p<? super T, Boolean>) qVar);
        StringBuilder sb = new StringBuilder();
        sb.append("Payment ");
        sb.append(serviceId);
        sb.append(" not found.");
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(sb.toString());
        $jacocoInit[43] = true;
        C0120S a2 = C0120S.m631a((Throwable) illegalArgumentException);
        $jacocoInit[44] = true;
        C0120S f = d.mo3659f(a2);
        $jacocoInit[45] = true;
        return f;
    }

    private Single<PaymentService> getService(String serviceId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S c = getPaymentServices().mo3697c(new C2295e(serviceId));
        $jacocoInit[29] = true;
        C0120S d = c.mo3647d();
        $jacocoInit[30] = true;
        Single<PaymentService> n = d.mo3678n();
        $jacocoInit[31] = true;
        return n;
    }

    /* renamed from: a */
    static /* synthetic */ Boolean m154a(String serviceId, PaymentService payment) {
        boolean[] $jacocoInit = $jacocoInit();
        String id = payment.getId();
        $jacocoInit[46] = true;
        boolean equals = id.equals(serviceId);
        $jacocoInit[47] = true;
        Boolean valueOf = Boolean.valueOf(equals);
        $jacocoInit[48] = true;
        return valueOf;
    }

    private Single<List<PaymentService>> getPaymentServices() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<List<PaymentService>> paymentServices = this.billingService.getPaymentServices();
        $jacocoInit[32] = true;
        return paymentServices;
    }

    private C0117M removeOldTransactions(Transaction transaction) {
        boolean[] $jacocoInit = $jacocoInit();
        TransactionRepository transactionRepository2 = this.transactionRepository;
        String customerId = transaction.getCustomerId();
        $jacocoInit[33] = true;
        String productId = transaction.getProductId();
        String id = transaction.getId();
        $jacocoInit[34] = true;
        Single otherTransactions = transactionRepository2.getOtherTransactions(customerId, productId, id);
        C2291c cVar = C2291c.f5377a;
        $jacocoInit[35] = true;
        C0120S c = otherTransactions.mo3697c(cVar);
        C2369s sVar = new C2369s(this);
        $jacocoInit[36] = true;
        C0120S g = c.mo3663g((C0132p<? super T, ? extends C0117M>) sVar);
        $jacocoInit[37] = true;
        C0117M l = g.mo3673l();
        $jacocoInit[38] = true;
        return l;
    }

    /* renamed from: b */
    static /* synthetic */ C0120S m158b(List otherTransactions) {
        boolean[] $jacocoInit = $jacocoInit();
        C0120S a = C0120S.m629a((Iterable<? extends T>) otherTransactions);
        $jacocoInit[41] = true;
        return a;
    }

    /* renamed from: d */
    public /* synthetic */ C0117M mo835d(Transaction otherTransaction) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M removeTransaction = this.transactionRepository.removeTransaction(otherTransaction.getId());
        AuthorizationRepository authorizationRepository2 = this.authorizationRepository;
        $jacocoInit[39] = true;
        C0117M a = removeTransaction.mo3580a(authorizationRepository2.removeAuthorization(otherTransaction.getId()));
        $jacocoInit[40] = true;
        return a;
    }
}
