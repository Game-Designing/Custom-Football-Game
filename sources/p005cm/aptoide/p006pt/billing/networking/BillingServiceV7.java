package p005cm.aptoide.p006pt.billing.networking;

import android.content.SharedPreferences;
import java.util.Collections;
import java.util.List;
import okhttp3.OkHttpClient;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.BillingService;
import p005cm.aptoide.p006pt.billing.Merchant;
import p005cm.aptoide.p006pt.billing.exception.MerchantNotFoundException;
import p005cm.aptoide.p006pt.billing.exception.ProductNotFoundException;
import p005cm.aptoide.p006pt.billing.exception.PurchaseNotFoundException;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.billing.purchase.Purchase.Status;
import p005cm.aptoide.p006pt.billing.purchase.PurchaseFactory;
import p005cm.aptoide.p006pt.dataprovider.interfaces.TokenInvalidator;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.dataprovider.p010ws.BodyInterceptor;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.C0044V7;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.DeletePurchaseRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetMerchantRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetProductsRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetPurchaseRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetPurchasesRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetServicesRequest;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetServicesRequest.ResponseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.PurchaseResponse;
import p005cm.aptoide.p006pt.install.PackageRepository;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;
import retrofit2.Converter.Factory;
import retrofit2.Response;

/* renamed from: cm.aptoide.pt.billing.networking.BillingServiceV7 */
public class BillingServiceV7 implements BillingService {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BillingIdManager billingIdManager;
    private final BodyInterceptor<BaseBody> bodyInterceptorV7;
    private final Factory converterFactory;
    private final OkHttpClient httpClient;
    private final PackageRepository packageRepository;
    private final ProductMapperV7 productMapperV7;
    private final PurchaseFactory purchaseFactory;
    private final PurchaseMapperV7 purchaseMapper;
    private final PaymentServiceMapper serviceMapper;
    private final SharedPreferences sharedPreferences;
    private final TokenInvalidator tokenInvalidator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5580976764456295845L, "cm/aptoide/pt/billing/networking/BillingServiceV7", 89);
        $jacocoData = probes;
        return probes;
    }

    public BillingServiceV7(BodyInterceptor<BaseBody> bodyInterceptorV72, OkHttpClient httpClient2, Factory converterFactory2, TokenInvalidator tokenInvalidator2, SharedPreferences sharedPreferences2, PurchaseMapperV7 purchaseMapper2, ProductMapperV7 productMapperV72, PackageRepository packageRepository2, PaymentServiceMapper serviceMapper2, BillingIdManager billingIdManager2, PurchaseFactory purchaseFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.httpClient = httpClient2;
        this.converterFactory = converterFactory2;
        this.tokenInvalidator = tokenInvalidator2;
        this.sharedPreferences = sharedPreferences2;
        this.purchaseMapper = purchaseMapper2;
        this.productMapperV7 = productMapperV72;
        this.packageRepository = packageRepository2;
        this.serviceMapper = serviceMapper2;
        this.bodyInterceptorV7 = bodyInterceptorV72;
        this.billingIdManager = billingIdManager2;
        this.purchaseFactory = purchaseFactory2;
        $jacocoInit[0] = true;
    }

    public Single<List<PaymentService>> getPaymentServices() {
        boolean[] $jacocoInit = $jacocoInit();
        GetServicesRequest of = GetServicesRequest.m7544of(this.sharedPreferences, this.httpClient, this.converterFactory, this.bodyInterceptorV7, this.tokenInvalidator);
        $jacocoInit[1] = true;
        C0120S observe = of.observe(false, false);
        $jacocoInit[2] = true;
        Single n = observe.mo3678n();
        C2317j jVar = new C2317j(this);
        $jacocoInit[3] = true;
        Single<List<PaymentService>> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) jVar);
        $jacocoInit[4] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11159a(ResponseBody response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[84] = true;
        } else if (!response.isOk()) {
            $jacocoInit[85] = true;
        } else {
            $jacocoInit[86] = true;
            Single a = Single.m734a(this.serviceMapper.map(response.getList()));
            $jacocoInit[87] = true;
            return a;
        }
        Single a2 = Single.m735a((Throwable) new IllegalStateException(C0044V7.getErrorMessage(response)));
        $jacocoInit[88] = true;
        return a2;
    }

    public Single<Merchant> getMerchant(String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        GetMerchantRequest of = GetMerchantRequest.m7539of(merchantName, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[5] = true;
        C0120S observe = of.observe(false, false);
        $jacocoInit[6] = true;
        Single n = observe.mo3678n();
        C2318k kVar = C2318k.f5430a;
        $jacocoInit[7] = true;
        Single<Merchant> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) kVar);
        $jacocoInit[8] = true;
        return a;
    }

    /* renamed from: a */
    static /* synthetic */ Single m7006a(GetMerchantRequest.ResponseBody response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[76] = true;
        } else if (!response.isOk()) {
            $jacocoInit[77] = true;
        } else {
            $jacocoInit[78] = true;
            GetMerchantRequest.ResponseBody.Merchant data = response.getData();
            $jacocoInit[79] = true;
            long id = data.getId();
            GetMerchantRequest.ResponseBody.Merchant data2 = response.getData();
            $jacocoInit[80] = true;
            Merchant merchant = new Merchant(id, data2.getName());
            $jacocoInit[81] = true;
            Single a = Single.m734a(merchant);
            $jacocoInit[82] = true;
            return a;
        }
        Single a2 = Single.m735a((Throwable) new MerchantNotFoundException(C0044V7.getErrorMessage(response)));
        $jacocoInit[83] = true;
        return a2;
    }

    public C0117M deletePurchase(String purchaseId) {
        boolean[] $jacocoInit = $jacocoInit();
        DeletePurchaseRequest of = DeletePurchaseRequest.m7537of(this.billingIdManager.resolvePurchaseId(purchaseId), this.httpClient, this.converterFactory, this.bodyInterceptorV7, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[9] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[10] = true;
        C0120S d = observe.mo3647d();
        $jacocoInit[11] = true;
        Single n = d.mo3678n();
        C2320m mVar = C2320m.f5433a;
        $jacocoInit[12] = true;
        C0117M b = n.mo3693b((C0132p<? super T, ? extends C0117M>) mVar);
        $jacocoInit[13] = true;
        return b;
    }

    /* renamed from: a */
    static /* synthetic */ C0117M m7005a(BaseV7Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[71] = true;
        } else if (!response.isOk()) {
            $jacocoInit[72] = true;
        } else {
            $jacocoInit[73] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[74] = true;
            return b;
        }
        C0117M b2 = C0117M.m591b((Throwable) new PurchaseNotFoundException(C0044V7.getErrorMessage(response)));
        $jacocoInit[75] = true;
        return b2;
    }

    public Single<List<Purchase>> getPurchases(String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        GetPurchasesRequest of = GetPurchasesRequest.m7543of(merchantName, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[14] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[15] = true;
        Single n = observe.mo3678n();
        C2321n nVar = new C2321n(this);
        $jacocoInit[16] = true;
        Single<List<Purchase>> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) nVar);
        $jacocoInit[17] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11163a(Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isSuccessful()) {
            $jacocoInit[66] = true;
            PurchaseMapperV7 purchaseMapperV7 = this.purchaseMapper;
            GetPurchasesRequest.ResponseBody responseBody = (GetPurchasesRequest.ResponseBody) response.body();
            $jacocoInit[67] = true;
            List list = responseBody.getList();
            $jacocoInit[68] = true;
            Single a = Single.m734a(purchaseMapperV7.map(list));
            $jacocoInit[69] = true;
            return a;
        }
        Single a2 = Single.m734a(Collections.emptyList());
        $jacocoInit[70] = true;
        return a2;
    }

    public Single<Purchase> getPurchase(String productId) {
        boolean[] $jacocoInit = $jacocoInit();
        GetPurchaseRequest of = GetPurchaseRequest.m7542of(this.billingIdManager.resolveProductId(productId), this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[18] = true;
        C0120S observe = of.observe(true, false);
        $jacocoInit[19] = true;
        Single n = observe.mo3678n();
        C2319l lVar = new C2319l(this, productId);
        $jacocoInit[20] = true;
        Single<Purchase> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) lVar);
        $jacocoInit[21] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11162a(String productId, Response response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response.isSuccessful()) {
            $jacocoInit[56] = true;
            PurchaseMapperV7 purchaseMapperV7 = this.purchaseMapper;
            GetPurchaseRequest.ResponseBody responseBody = (GetPurchaseRequest.ResponseBody) response.body();
            $jacocoInit[57] = true;
            PurchaseResponse data = responseBody.getData();
            $jacocoInit[58] = true;
            Single a = Single.m734a(purchaseMapperV7.map(data));
            $jacocoInit[59] = true;
            return a;
        } else if (response.code() == 404) {
            PurchaseFactory purchaseFactory2 = this.purchaseFactory;
            Status status = Status.NEW;
            $jacocoInit[60] = true;
            Purchase create = purchaseFactory2.create(productId, null, null, status, null, null, null, null);
            $jacocoInit[61] = true;
            Single a2 = Single.m734a(create);
            $jacocoInit[62] = true;
            return a2;
        } else {
            PurchaseFactory purchaseFactory3 = this.purchaseFactory;
            Status status2 = Status.FAILED;
            $jacocoInit[63] = true;
            Purchase create2 = purchaseFactory3.create(productId, null, null, status2, null, null, null, null);
            $jacocoInit[64] = true;
            Single a3 = Single.m734a(create2);
            $jacocoInit[65] = true;
            return a3;
        }
    }

    public Single<List<Product>> getProducts(String merchantName, List<String> skus) {
        boolean[] $jacocoInit = $jacocoInit();
        GetProductsRequest of = GetProductsRequest.m7541of(merchantName, skus, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[22] = true;
        C0120S observe = of.observe(false, false);
        $jacocoInit[23] = true;
        C0120S d = observe.mo3647d();
        $jacocoInit[24] = true;
        Single n = d.mo3678n();
        C2324q qVar = new C2324q(this, merchantName);
        $jacocoInit[25] = true;
        Single<List<Product>> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) qVar);
        $jacocoInit[26] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11160a(String merchantName, GetProductsRequest.ResponseBody response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[49] = true;
        } else if (!response.isOk()) {
            $jacocoInit[50] = true;
        } else {
            $jacocoInit[51] = true;
            Single mapToProducts = mapToProducts(merchantName, response.getList());
            $jacocoInit[52] = true;
            return mapToProducts;
        }
        $jacocoInit[53] = true;
        IllegalStateException illegalStateException = new IllegalStateException(C0044V7.getErrorMessage(response));
        $jacocoInit[54] = true;
        Single a = Single.m735a((Throwable) illegalStateException);
        $jacocoInit[55] = true;
        return a;
    }

    public Single<Product> getProduct(String sku, String merchantName) {
        boolean[] $jacocoInit = $jacocoInit();
        GetProductsRequest of = GetProductsRequest.m7540of(merchantName, sku, this.bodyInterceptorV7, this.httpClient, this.converterFactory, this.tokenInvalidator, this.sharedPreferences);
        $jacocoInit[27] = true;
        C0120S observe = of.observe(false, false);
        $jacocoInit[28] = true;
        C0120S d = observe.mo3647d();
        $jacocoInit[29] = true;
        Single n = d.mo3678n();
        C2322o oVar = new C2322o(this, merchantName, sku);
        $jacocoInit[30] = true;
        Single<Product> a = n.mo3688a((C0132p<? super T, ? extends Single<? extends R>>) oVar);
        $jacocoInit[31] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Single mo11161a(String merchantName, String sku, GetProductsRequest.ResponseBody response) {
        boolean[] $jacocoInit = $jacocoInit();
        if (response == null) {
            $jacocoInit[44] = true;
        } else if (!response.isOk()) {
            $jacocoInit[45] = true;
        } else {
            $jacocoInit[46] = true;
            Single mapToProduct = mapToProduct(merchantName, response.getData());
            $jacocoInit[47] = true;
            return mapToProduct;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No product found for sku: ");
        sb.append(sku);
        Single a = Single.m735a((Throwable) new ProductNotFoundException(sb.toString()));
        $jacocoInit[48] = true;
        return a;
    }

    private Single<List<Product>> mapToProducts(String merchantName, List<GetProductsRequest.ResponseBody.Product> responseList) {
        boolean[] $jacocoInit = $jacocoInit();
        Single packageVersionCode = this.packageRepository.getPackageVersionCode(merchantName);
        PackageRepository packageRepository2 = this.packageRepository;
        $jacocoInit[32] = true;
        Single packageLabel = packageRepository2.getPackageLabel(merchantName);
        C2323p pVar = new C2323p(this, merchantName, responseList);
        $jacocoInit[33] = true;
        Single<List<Product>> a = Single.m740a(packageVersionCode, packageLabel, pVar);
        $jacocoInit[34] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ List mo11158a(String merchantName, List responseList, Integer packageVersionCode, String applicationName) {
        boolean[] $jacocoInit = $jacocoInit();
        ProductMapperV7 productMapperV72 = this.productMapperV7;
        $jacocoInit[41] = true;
        int intValue = packageVersionCode.intValue();
        $jacocoInit[42] = true;
        List map = productMapperV72.map(merchantName, responseList, intValue);
        $jacocoInit[43] = true;
        return map;
    }

    private Single<Product> mapToProduct(String merchantName, GetProductsRequest.ResponseBody.Product response) {
        boolean[] $jacocoInit = $jacocoInit();
        Single packageVersionCode = this.packageRepository.getPackageVersionCode(merchantName);
        PackageRepository packageRepository2 = this.packageRepository;
        $jacocoInit[35] = true;
        Single packageLabel = packageRepository2.getPackageLabel(merchantName);
        C2325r rVar = new C2325r(this, merchantName, response);
        $jacocoInit[36] = true;
        Single<Product> a = Single.m740a(packageVersionCode, packageLabel, rVar);
        $jacocoInit[37] = true;
        return a;
    }

    /* renamed from: a */
    public /* synthetic */ Product mo11157a(String merchantName, GetProductsRequest.ResponseBody.Product response, Integer packageVersionCode, String applicationName) {
        boolean[] $jacocoInit = $jacocoInit();
        ProductMapperV7 productMapperV72 = this.productMapperV7;
        $jacocoInit[38] = true;
        int intValue = packageVersionCode.intValue();
        $jacocoInit[39] = true;
        Product map = productMapperV72.map(merchantName, intValue, response);
        $jacocoInit[40] = true;
        return map;
    }
}
