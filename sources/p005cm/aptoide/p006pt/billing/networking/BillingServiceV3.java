package p005cm.aptoide.p006pt.billing.networking;

import android.content.SharedPreferences;
import android.content.res.Resources;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.BillingService;
import p005cm.aptoide.p006pt.billing.Merchant;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GetApkInfoRequest;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import retrofit2.Converter.Factory;

/* renamed from: cm.aptoide.pt.billing.networking.BillingServiceV3 */
public class BillingServiceV3 implements BillingService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BillingIdManager billingIdManager;
    private final BodyInterceptor<BaseBody> bodyInterceptorV3;
    private final Factory converterFactory;
    private final int currentAPILevel;
    private final OkHttpClient httpClient;
    private final PaymentService paymentService;
    private final ProductMapperV3 productMapper;
    private final PurchaseMapperV3 purchaseMapper;
    private final Resources resources;
    private final int serviceMinimumAPILevel;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-113145065212078288L, "cm/aptoide/pt/billing/networking/BillingServiceV3", 16);
        $jacocoData = probes;
        return probes;
    }

    public BillingServiceV3(BodyInterceptor<BaseBody> bodyInterceptorV32, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, PurchaseMapperV3 purchaseMapper2, ProductMapperV3 productMapper2, Resources resources2, PaymentService paymentService2, BillingIdManager billingIdManager2, int currentAPILevel2, int serviceMinimumAPILevel2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.bodyInterceptorV3 = bodyInterceptorV32;
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.purchaseMapper = purchaseMapper2;
        this.productMapper = productMapper2;
        this.resources = resources2;
        this.paymentService = paymentService2;
        this.billingIdManager = billingIdManager2;
        this.currentAPILevel = currentAPILevel2;
        this.serviceMinimumAPILevel = serviceMinimumAPILevel2;
        $jacocoInit[0] = true;
    }

    public Single<List<PaymentService>> getPaymentServices() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.currentAPILevel >= this.serviceMinimumAPILevel) {
            $jacocoInit[1] = true;
            Single<List<PaymentService>> a = Single.m734a(Collections.singletonList(this.paymentService));
            $jacocoInit[2] = true;
            return a;
        }
        Single<List<PaymentService>> a2 = Single.m734a(Collections.emptyList());
        $jacocoInit[3] = true;
        return a2;
    }

    public Single<Merchant> getMerchant(String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Merchant> a = Single.m735a((Throwable) new IllegalStateException("Not implemented!"));
        $jacocoInit[4] = true;
        return a;
    }

    public C0117M deletePurchase(String purchaseId) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M b = C0117M.m591b((Throwable) new IllegalStateException("Not implemented!"));
        $jacocoInit[5] = true;
        return b;
    }

    public Single<List<Purchase>> getPurchases(String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<List<Purchase>> a = Single.m735a((Throwable) new IllegalStateException("Not implemented!"));
        $jacocoInit[6] = true;
        return a;
    }

    public Single<Purchase> getPurchase(String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Purchase> d = getServerPaidApp(true, this.billingIdManager.resolveProductId(productId)).mo3698d(new C2316i(this, productId));
        $jacocoInit[7] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Purchase mo11156a(String productId, PaidApp app) {
        boolean[] $jacocoInit = $jacocoInit();
        Purchase map = this.purchaseMapper.map(app, productId);
        $jacocoInit[15] = true;
        return map;
    }

    public Single<List<Product>> getProducts(String merchantName, List<String> list) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<List<Product>> a = Single.m735a((Throwable) new IllegalStateException("Not implemented!"));
        $jacocoInit[8] = true;
        return a;
    }

    public Single<Product> getProduct(String sku, String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        Single<Product> d = getServerPaidApp(false, this.billingIdManager.resolveProductId(sku)).mo3698d(new C2315h(this));
        $jacocoInit[9] = true;
        return d;
    }

    /* renamed from: a */
    public /* synthetic */ Product mo11155a(PaidApp paidApp) {
        boolean[] $jacocoInit = $jacocoInit();
        Product map = this.productMapper.map(paidApp);
        $jacocoInit[14] = true;
        return map;
    }

    private Single<PaidApp> getServerPaidApp(boolean bypassCache, long appId) {
        boolean[] $jacocoInit = $jacocoInit();
        GetApkInfoRequest of = GetApkInfoRequest.m7448of(appId, this.bodyInterceptorV3, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences, this.resources);
        $jacocoInit[10] = true;
        C0120S observe = of.observe(bypassCache);
        $jacocoInit[11] = true;
        C0120S d = observe.mo3647d();
        $jacocoInit[12] = true;
        Single<PaidApp> n = d.mo3678n();
        $jacocoInit[13] = true;
        return n;
    }
}
