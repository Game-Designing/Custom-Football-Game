package p005cm.aptoide.p006pt.billing.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;

/* renamed from: cm.aptoide.pt.billing.networking.ProductMapperV3 */
public class ProductMapperV3 {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BillingIdManager billingIdManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1482799499347392452L, "cm/aptoide/pt/billing/networking/ProductMapperV3", 32);
        $jacocoData = probes;
        return probes;
    }

    public ProductMapperV3(BillingIdManager billingIdManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.billingIdManager = billingIdManager2;
        $jacocoInit[0] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p005cm.aptoide.p006pt.billing.product.Product map(p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp r17) {
        /*
            r16 = this;
            boolean[] r0 = $jacocoInit()
            boolean r1 = r17.isOk()
            r2 = 1
            if (r1 == 0) goto L_0x010d
            boolean r1 = r17.isPaid()
            if (r1 == 0) goto L_0x0109
            r1 = 3
            r0[r1] = r2
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$Path r1 = r17.getPath()
            r3 = 4
            r0[r3] = r2
            java.lang.String r1 = r1.getIcon()
            if (r1 != 0) goto L_0x0031
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$Path r1 = r17.getPath()
            r3 = 5
            r0[r3] = r2
            java.lang.String r1 = r1.getAlternativeIcon()
            r3 = 6
            r0[r3] = r2
            r6 = r1
            goto L_0x0041
        L_0x0031:
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$Path r1 = r17.getPath()
            r3 = 7
            r0[r3] = r2
            java.lang.String r1 = r1.getIcon()
            r3 = 8
            r0[r3] = r2
            r6 = r1
        L_0x0041:
            r1 = 9
            r0[r1] = r2
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$Payment r1 = r17.getPayment()
            r3 = 10
            r0[r3] = r2
            java.util.List r3 = r1.getPaymentServices()
            if (r3 != 0) goto L_0x0058
            r3 = 11
            r0[r3] = r2
            goto L_0x006a
        L_0x0058:
            java.util.List r3 = r1.getPaymentServices()
            r4 = 12
            r0[r4] = r2
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0070
            r3 = 13
            r0[r3] = r2
        L_0x006a:
            r3 = 0
            r4 = 16
            r0[r4] = r2
            goto L_0x0083
        L_0x0070:
            java.util.List r3 = r1.getPaymentServices()
            r4 = 0
            r5 = 14
            r0[r5] = r2
            java.lang.Object r3 = r3.get(r4)
            cm.aptoide.pt.dataprovider.model.v3.PaymentServiceResponse r3 = (p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaymentServiceResponse) r3
            r4 = 15
            r0[r4] = r2
        L_0x0083:
            r4 = 17
            r0[r4] = r2
            if (r3 == 0) goto L_0x0092
            java.lang.String r4 = r3.getCurrency()
            r5 = 18
            r0[r5] = r2
            goto L_0x0098
        L_0x0092:
            r4 = 19
            r0[r4] = r2
            java.lang.String r4 = ""
        L_0x0098:
            r5 = 20
            r0[r5] = r2
            r11 = r4
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$App r4 = r17.getApp()
            r5 = 21
            r0[r5] = r2
            java.lang.String r12 = r4.getName()
            r4 = 22
            r0[r4] = r2
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$App r4 = r17.getApp()
            r5 = 23
            r0[r5] = r2
            java.lang.String r13 = r4.getDescription()
            r4 = 24
            r0[r4] = r2
            cm.aptoide.pt.billing.Price r9 = new cm.aptoide.pt.billing.Price
            java.lang.Double r4 = r1.getAmount()
            double r4 = r4.doubleValue()
            java.lang.String r7 = r1.getSymbol()
            r9.<init>(r4, r11, r7)
            r4 = 25
            r0[r4] = r2
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$Path r4 = r17.getPath()
            r5 = 26
            r0[r5] = r2
            int r14 = r4.getVersionCode()
            r4 = 27
            r0[r4] = r2
            cm.aptoide.pt.billing.product.Product r15 = new cm.aptoide.pt.billing.product.Product
            r10 = r16
            cm.aptoide.pt.billing.BillingIdManager r4 = r10.billingIdManager
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$Path r5 = r17.getPath()
            r7 = 28
            r0[r7] = r2
            int r5 = r5.getAppId()
            long r7 = (long) r5
            r5 = 29
            r0[r5] = r2
            java.lang.String r5 = r4.generateProductId(r7)
            r4 = r15
            r7 = r12
            r8 = r13
            r10 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r4 = 30
            r0[r4] = r2
            return r15
        L_0x0109:
            r1 = 2
            r0[r1] = r2
            goto L_0x010f
        L_0x010d:
            r0[r2] = r2
        L_0x010f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r3 = p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.C2847V3.getErrorMessage(r17)
            r1.<init>(r3)
            r3 = 31
            r0[r3] = r2
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.networking.ProductMapperV3.map(cm.aptoide.pt.dataprovider.model.v3.PaidApp):cm.aptoide.pt.billing.product.Product");
    }
}
