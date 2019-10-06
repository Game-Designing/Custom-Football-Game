package p005cm.aptoide.p006pt.billing.networking;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.external.ExternalBillingSerializer;
import p005cm.aptoide.p006pt.billing.purchase.Purchase;
import p005cm.aptoide.p006pt.billing.purchase.Purchase.Status;
import p005cm.aptoide.p006pt.billing.purchase.PurchaseFactory;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.PurchaseResponse;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.PurchaseResponse.Data;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.PurchaseResponse.Data.DeveloperPurchase;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.PurchaseResponse.Product;

/* renamed from: cm.aptoide.pt.billing.networking.PurchaseMapperV7 */
public class PurchaseMapperV7 {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BillingIdManager billingIdManager;
    private final PurchaseFactory purchaseFactory;
    private final ExternalBillingSerializer serializer;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1912530068383504326L, "cm/aptoide/pt/billing/networking/PurchaseMapperV7", 22);
        $jacocoData = probes;
        return probes;
    }

    public PurchaseMapperV7(ExternalBillingSerializer serializer2, BillingIdManager billingIdManager2, PurchaseFactory purchaseFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.serializer = serializer2;
        this.billingIdManager = billingIdManager2;
        this.purchaseFactory = purchaseFactory2;
        $jacocoInit[0] = true;
    }

    public List<Purchase> map(List<PurchaseResponse> responseList) {
        boolean[] $jacocoInit = $jacocoInit();
        List<Purchase> purchases = new ArrayList<>(responseList.size());
        $jacocoInit[1] = true;
        $jacocoInit[2] = true;
        for (PurchaseResponse response : responseList) {
            $jacocoInit[3] = true;
            purchases.add(map(response));
            $jacocoInit[4] = true;
        }
        $jacocoInit[5] = true;
        return purchases;
    }

    public Purchase map(PurchaseResponse response) {
        Status status;
        boolean[] $jacocoInit = $jacocoInit();
        try {
            PurchaseFactory purchaseFactory2 = this.purchaseFactory;
            BillingIdManager billingIdManager2 = this.billingIdManager;
            Product product = response.getProduct();
            $jacocoInit[6] = true;
            long id = product.getId();
            $jacocoInit[7] = true;
            String generatePurchaseId = billingIdManager2.generatePurchaseId(id);
            $jacocoInit[8] = true;
            String signature = response.getSignature();
            ExternalBillingSerializer externalBillingSerializer = this.serializer;
            Data data = response.getData();
            $jacocoInit[9] = true;
            DeveloperPurchase developerPurchase = data.getDeveloperPurchase();
            $jacocoInit[10] = true;
            String serializePurchase = externalBillingSerializer.serializePurchase(developerPurchase);
            $jacocoInit[11] = true;
            Data data2 = response.getData();
            $jacocoInit[12] = true;
            DeveloperPurchase developerPurchase2 = data2.getDeveloperPurchase();
            $jacocoInit[13] = true;
            if (developerPurchase2.getPurchaseState() == 0) {
                status = Status.COMPLETED;
                $jacocoInit[14] = true;
            } else {
                status = Status.NEW;
                $jacocoInit[15] = true;
            }
            $jacocoInit[16] = true;
            Product product2 = response.getProduct();
            $jacocoInit[17] = true;
            String sku = product2.getSku();
            String str = PurchaseFactory.IN_APP;
            $jacocoInit[18] = true;
            Purchase create = purchaseFactory2.create(generatePurchaseId, signature, serializePurchase, status, sku, str, null, null);
            $jacocoInit[19] = true;
            return create;
        } catch (JsonProcessingException e) {
            $jacocoInit[20] = true;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(e);
            $jacocoInit[21] = true;
            throw illegalArgumentException;
        }
    }
}
