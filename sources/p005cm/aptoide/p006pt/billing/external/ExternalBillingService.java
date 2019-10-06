package p005cm.aptoide.p006pt.billing.external;

import java.util.List;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p026rx.C0117M;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.billing.external.ExternalBillingService */
public interface ExternalBillingService {
    C0117M consumeInAppPurchase(int i, String str, String str2);

    Single<List<Purchase>> getInAppPurchases(int i, String str, String str2);
}
