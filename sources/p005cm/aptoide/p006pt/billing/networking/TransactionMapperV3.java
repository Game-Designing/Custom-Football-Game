package p005cm.aptoide.p006pt.billing.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.transaction.TransactionFactory;

/* renamed from: cm.aptoide.pt.billing.networking.TransactionMapperV3 */
public class TransactionMapperV3 {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final BillingIdManager billingIdManager;
    private final TransactionFactory transactionFactory;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-734820984881763132L, "cm/aptoide/pt/billing/networking/TransactionMapperV3", 46);
        $jacocoData = probes;
        return probes;
    }

    public TransactionMapperV3(TransactionFactory transactionFactory2, BillingIdManager billingIdManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.transactionFactory = transactionFactory2;
        this.billingIdManager = billingIdManager2;
        $jacocoInit[0] = true;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p005cm.aptoide.p006pt.billing.transaction.Transaction map(java.lang.String r11, java.lang.String r12, p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse r13, java.lang.String r14) {
        /*
            r10 = this;
            boolean[] r6 = $jacocoInit()
            boolean r0 = r13.hasErrors()
            r7 = 4
            r1 = 3
            r2 = 2
            r8 = 1
            if (r0 == 0) goto L_0x002c
            r6[r8] = r8
            java.util.List r3 = r13.getErrors()
            cm.aptoide.pt.billing.BillingIdManager r0 = r10.billingIdManager
            r4 = 1
            r6[r2] = r8
            java.lang.String r4 = r0.generateServiceId(r4)
            r6[r1] = r8
            r0 = r10
            r1 = r3
            r2 = r11
            r3 = r12
            r5 = r14
            cm.aptoide.pt.billing.transaction.Transaction r0 = r0.getErrorTransaction(r1, r2, r3, r4, r5)
            r6[r7] = r8
            return r0
        L_0x002c:
            java.lang.String r0 = r13.getTransactionStatus()
            r3 = -1
            int r4 = r0.hashCode()
            r5 = 6
            r9 = 5
            switch(r4) {
                case -1375705427: goto L_0x00b0;
                case 35394935: goto L_0x009d;
                case 659453081: goto L_0x008a;
                case 907287315: goto L_0x0077;
                case 1383663147: goto L_0x0067;
                case 1746537160: goto L_0x0053;
                case 2066319421: goto L_0x003e;
                default: goto L_0x003a;
            }
        L_0x003a:
            r6[r9] = r8
            goto L_0x00c3
        L_0x003e:
            java.lang.String r4 = "FAILED"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x004c
            r0 = 16
            r6[r0] = r8
            goto L_0x00c3
        L_0x004c:
            r0 = 17
            r6[r0] = r8
            r0 = 5
            goto L_0x00c4
        L_0x0053:
            java.lang.String r4 = "CREATED"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0061
            r0 = 10
            r6[r0] = r8
            goto L_0x00c3
        L_0x0061:
            r0 = 11
            r6[r0] = r8
            r0 = 2
            goto L_0x00c4
        L_0x0067:
            java.lang.String r4 = "COMPLETED"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0072
            r6[r5] = r8
            goto L_0x00c3
        L_0x0072:
            r0 = 0
            r3 = 7
            r6[r3] = r8
            goto L_0x00c4
        L_0x0077:
            java.lang.String r4 = "PROCESSING"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0084
            r0 = 12
            r6[r0] = r8
            goto L_0x00c3
        L_0x0084:
            r0 = 13
            r6[r0] = r8
            r0 = 3
            goto L_0x00c4
        L_0x008a:
            java.lang.String r4 = "CANCELED"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x0097
            r0 = 18
            r6[r0] = r8
            goto L_0x00c3
        L_0x0097:
            r0 = 19
            r6[r0] = r8
            r0 = 6
            goto L_0x00c4
        L_0x009d:
            java.lang.String r4 = "PENDING"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00aa
            r0 = 14
            r6[r0] = r8
            goto L_0x00c3
        L_0x00aa:
            r0 = 15
            r6[r0] = r8
            r0 = 4
            goto L_0x00c4
        L_0x00b0:
            java.lang.String r4 = "PENDING_USER_AUTHORIZATION"
            boolean r0 = r0.equals(r4)
            if (r0 != 0) goto L_0x00bd
            r0 = 8
            r6[r0] = r8
            goto L_0x00c3
        L_0x00bd:
            r0 = 9
            r6[r0] = r8
            r0 = 1
            goto L_0x00c4
        L_0x00c3:
            r0 = -1
        L_0x00c4:
            if (r0 == 0) goto L_0x00e3
            if (r0 == r8) goto L_0x00dc
            if (r0 == r2) goto L_0x00dc
            if (r0 == r1) goto L_0x00d5
            if (r0 == r7) goto L_0x00d5
            cm.aptoide.pt.billing.transaction.Transaction$Status r0 = p005cm.aptoide.p006pt.billing.transaction.Transaction.Status.FAILED
            r1 = 23
            r6[r1] = r8
            goto L_0x00e9
        L_0x00d5:
            cm.aptoide.pt.billing.transaction.Transaction$Status r0 = p005cm.aptoide.p006pt.billing.transaction.Transaction.Status.PROCESSING
            r1 = 22
            r6[r1] = r8
            goto L_0x00e9
        L_0x00dc:
            cm.aptoide.pt.billing.transaction.Transaction$Status r0 = p005cm.aptoide.p006pt.billing.transaction.Transaction.Status.PENDING_SERVICE_AUTHORIZATION
            r1 = 21
            r6[r1] = r8
            goto L_0x00e9
        L_0x00e3:
            cm.aptoide.pt.billing.transaction.Transaction$Status r0 = p005cm.aptoide.p006pt.billing.transaction.Transaction.Status.COMPLETED
            r1 = 20
            r6[r1] = r8
        L_0x00e9:
            cm.aptoide.pt.billing.transaction.TransactionFactory r1 = r10.transactionFactory
            cm.aptoide.pt.billing.transaction.SimpleTransaction r1 = r1.create(r12, r11, r14, r0)
            r5 = 24
            r6[r5] = r8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.networking.TransactionMapperV3.map(java.lang.String, java.lang.String, cm.aptoide.pt.dataprovider.model.v3.TransactionResponse, java.lang.String):cm.aptoide.pt.billing.transaction.Transaction");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p005cm.aptoide.p006pt.billing.transaction.Transaction getErrorTransaction(java.util.List<p005cm.aptoide.p006pt.dataprovider.model.p008v3.ErrorResponse> r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
            r6 = this;
            boolean[] r0 = $jacocoInit()
            cm.aptoide.pt.billing.transaction.TransactionFactory r1 = r6.transactionFactory
            cm.aptoide.pt.billing.transaction.Transaction$Status r2 = p005cm.aptoide.p006pt.billing.transaction.Transaction.Status.FAILED
            r3 = 1
            r4 = 25
            r0[r4] = r3
            cm.aptoide.pt.billing.transaction.SimpleTransaction r1 = r1.create(r9, r8, r11, r2)
            r2 = 26
            r0[r2] = r3
            if (r7 != 0) goto L_0x001c
            r2 = 27
            r0[r2] = r3
            goto L_0x0026
        L_0x001c:
            boolean r2 = r7.isEmpty()
            if (r2 == 0) goto L_0x002b
            r2 = 28
            r0[r2] = r3
        L_0x0026:
            r2 = 29
            r0[r2] = r3
            return r1
        L_0x002b:
            r2 = 0
            java.lang.Object r2 = r7.get(r2)
            cm.aptoide.pt.dataprovider.model.v3.ErrorResponse r2 = (p005cm.aptoide.p006pt.dataprovider.model.p008v3.ErrorResponse) r2
            r4 = 30
            r0[r4] = r3
            java.lang.String r4 = r2.code
            java.lang.String r5 = "PRODUCT-204"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0045
            r4 = 31
            r0[r4] = r3
            goto L_0x006f
        L_0x0045:
            java.lang.String r4 = r2.code
            r5 = 32
            r0[r5] = r3
            java.lang.String r5 = "PRODUCT-209"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x0058
            r4 = 33
            r0[r4] = r3
            goto L_0x006f
        L_0x0058:
            java.lang.String r4 = r2.code
            r5 = 34
            r0[r5] = r3
            java.lang.String r5 = "PRODUCT-214"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x006b
            r4 = 35
            r0[r4] = r3
            goto L_0x007b
        L_0x006b:
            r4 = 36
            r0[r4] = r3
        L_0x006f:
            cm.aptoide.pt.billing.transaction.TransactionFactory r4 = r6.transactionFactory
            cm.aptoide.pt.billing.transaction.Transaction$Status r5 = p005cm.aptoide.p006pt.billing.transaction.Transaction.Status.PENDING_SERVICE_AUTHORIZATION
            cm.aptoide.pt.billing.transaction.SimpleTransaction r1 = r4.create(r9, r8, r11, r5)
            r4 = 37
            r0[r4] = r3
        L_0x007b:
            java.lang.String r4 = r2.code
            java.lang.String r5 = "PRODUCT-200"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x008a
            r4 = 38
            r0[r4] = r3
            goto L_0x009a
        L_0x008a:
            r4 = 39
            r0[r4] = r3
            cm.aptoide.pt.billing.transaction.TransactionFactory r4 = r6.transactionFactory
            cm.aptoide.pt.billing.transaction.Transaction$Status r5 = p005cm.aptoide.p006pt.billing.transaction.Transaction.Status.COMPLETED
            cm.aptoide.pt.billing.transaction.SimpleTransaction r1 = r4.create(r9, r8, r11, r5)
            r4 = 40
            r0[r4] = r3
        L_0x009a:
            java.lang.String r4 = r2.code
            java.lang.String r5 = "PRODUCT-216"
            boolean r4 = r5.equals(r4)
            if (r4 == 0) goto L_0x00a9
            r4 = 41
            r0[r4] = r3
            goto L_0x00bc
        L_0x00a9:
            java.lang.String r4 = r2.code
            java.lang.String r5 = "SYS-1"
            boolean r4 = r5.equals(r4)
            if (r4 != 0) goto L_0x00b8
            r4 = 42
            r0[r4] = r3
            goto L_0x00c8
        L_0x00b8:
            r4 = 43
            r0[r4] = r3
        L_0x00bc:
            cm.aptoide.pt.billing.transaction.TransactionFactory r4 = r6.transactionFactory
            cm.aptoide.pt.billing.transaction.Transaction$Status r5 = p005cm.aptoide.p006pt.billing.transaction.Transaction.Status.PROCESSING
            cm.aptoide.pt.billing.transaction.SimpleTransaction r1 = r4.create(r9, r8, r11, r5)
            r4 = 44
            r0[r4] = r3
        L_0x00c8:
            r4 = 45
            r0[r4] = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.networking.TransactionMapperV3.getErrorTransaction(java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String):cm.aptoide.pt.billing.transaction.Transaction");
    }
}
