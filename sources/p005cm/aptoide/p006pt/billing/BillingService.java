package p005cm.aptoide.p006pt.billing;

import java.util.List;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.billing.product.Product;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p026rx.C0117M;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.billing.BillingService */
public interface BillingService {
    C0117M deletePurchase(String str);

    Single<Merchant> getMerchant(String str);

    Single<List<PaymentService>> getPaymentServices();

    Single<Product> getProduct(String str, String str2);

    Single<List<Product>> getProducts(String str, List<String> list);

    Single<Purchase> getPurchase(String str);

    Single<List<Purchase>> getPurchases(String str);
}
