package p005cm.aptoide.p006pt.billing.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationFactory;

/* renamed from: cm.aptoide.pt.billing.networking.AuthorizationMapperV3 */
public class AuthorizationMapperV3 {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthorizationFactory authorizationFactory;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3144788192199756698L, "cm/aptoide/pt/billing/networking/AuthorizationMapperV3", 53);
        $jacocoData = probes;
        return probes;
    }

    public AuthorizationMapperV3(AuthorizationFactory authorizationFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authorizationFactory = authorizationFactory2;
        $jacocoInit[0] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p005cm.aptoide.p006pt.billing.authorization.Authorization map(java.lang.String r20, java.lang.String r21, java.lang.String r22, p005cm.aptoide.p006pt.dataprovider.model.p008v3.TransactionResponse r23, p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaidApp r24) {
        /*
            r19 = this;
            boolean[] r0 = $jacocoInit()
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$App r1 = r24.getApp()
            r2 = 1
            r0[r2] = r2
            java.lang.String r1 = r1.getName()
            r3 = 2
            r0[r3] = r2
            cm.aptoide.pt.dataprovider.model.v3.PaidApp$Payment r4 = r24.getPayment()
            r5 = 3
            r0[r5] = r2
            java.util.List r15 = r4.getPaymentServices()
            r4 = 0
            r6 = 4
            r0[r6] = r2
            r7 = 6
            r8 = 0
            r9 = 5
            if (r15 != 0) goto L_0x0029
            r0[r9] = r2
            goto L_0x0031
        L_0x0029:
            boolean r10 = r15.isEmpty()
            if (r10 == 0) goto L_0x0034
            r0[r7] = r2
        L_0x0031:
            r17 = r4
            goto L_0x005d
        L_0x0034:
            r10 = 7
            r0[r10] = r2
            java.lang.Object r10 = r15.get(r8)
            cm.aptoide.pt.dataprovider.model.v3.PaymentServiceResponse r10 = (p005cm.aptoide.p006pt.dataprovider.model.p008v3.PaymentServiceResponse) r10
            r11 = 8
            r0[r11] = r2
            cm.aptoide.pt.billing.Price r11 = new cm.aptoide.pt.billing.Price
            double r12 = r10.getPrice()
            java.lang.String r14 = r10.getCurrency()
            r16 = 9
            r0[r16] = r2
            java.lang.String r7 = r10.getSign()
            r11.<init>(r12, r14, r7)
            r4 = r11
            r7 = 10
            r0[r7] = r2
            r17 = r4
        L_0x005d:
            boolean r4 = r23.hasErrors()
            if (r4 == 0) goto L_0x0081
            r3 = 11
            r0[r3] = r2
            java.util.List r4 = r23.getErrors()
            java.lang.String r8 = "PAYPAL_SDK"
            r3 = r19
            r5 = r20
            r6 = r22
            r7 = r21
            r9 = r1
            r10 = r17
            cm.aptoide.pt.billing.authorization.Authorization r3 = r3.getErrorAuthorization(r4, r5, r6, r7, r8, r9, r10)
            r4 = 12
            r0[r4] = r2
            return r3
        L_0x0081:
            java.lang.String r4 = r23.getTransactionStatus()
            r7 = -1
            int r10 = r4.hashCode()
            switch(r10) {
                case -1375705427: goto L_0x0108;
                case 35394935: goto L_0x00f5;
                case 659453081: goto L_0x00e2;
                case 907287315: goto L_0x00cf;
                case 1383663147: goto L_0x00bc;
                case 1746537160: goto L_0x00a8;
                case 2066319421: goto L_0x0093;
                default: goto L_0x008d;
            }
        L_0x008d:
            r4 = 13
            r0[r4] = r2
            goto L_0x011a
        L_0x0093:
            java.lang.String r8 = "FAILED"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00a1
            r4 = 24
            r0[r4] = r2
            goto L_0x011a
        L_0x00a1:
            r4 = 25
            r0[r4] = r2
            r7 = 5
            goto L_0x011a
        L_0x00a8:
            java.lang.String r8 = "CREATED"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00b6
            r4 = 18
            r0[r4] = r2
            goto L_0x011a
        L_0x00b6:
            r4 = 19
            r0[r4] = r2
            r7 = 2
            goto L_0x011a
        L_0x00bc:
            java.lang.String r9 = "COMPLETED"
            boolean r4 = r4.equals(r9)
            if (r4 != 0) goto L_0x00c9
            r4 = 14
            r0[r4] = r2
            goto L_0x011a
        L_0x00c9:
            r4 = 15
            r0[r4] = r2
            r7 = 0
            goto L_0x011a
        L_0x00cf:
            java.lang.String r8 = "PROCESSING"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00dc
            r4 = 20
            r0[r4] = r2
            goto L_0x011a
        L_0x00dc:
            r4 = 21
            r0[r4] = r2
            r7 = 3
            goto L_0x011a
        L_0x00e2:
            java.lang.String r8 = "CANCELED"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00ef
            r4 = 26
            r0[r4] = r2
            goto L_0x011a
        L_0x00ef:
            r4 = 27
            r0[r4] = r2
            r7 = 6
            goto L_0x011a
        L_0x00f5:
            java.lang.String r8 = "PENDING"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0102
            r4 = 22
            r0[r4] = r2
            goto L_0x011a
        L_0x0102:
            r4 = 23
            r0[r4] = r2
            r7 = 4
            goto L_0x011a
        L_0x0108:
            java.lang.String r8 = "PENDING_USER_AUTHORIZATION"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x0115
            r4 = 16
            r0[r4] = r2
            goto L_0x011a
        L_0x0115:
            r4 = 17
            r0[r4] = r2
            r7 = 1
        L_0x011a:
            if (r7 == 0) goto L_0x013f
            if (r7 == r2) goto L_0x0136
            if (r7 == r3) goto L_0x0136
            if (r7 == r5) goto L_0x012d
            if (r7 == r6) goto L_0x012d
            cm.aptoide.pt.billing.authorization.Authorization$Status r3 = p005cm.aptoide.p006pt.billing.authorization.Authorization.Status.FAILED
            r4 = 31
            r0[r4] = r2
            r16 = r3
            goto L_0x0147
        L_0x012d:
            cm.aptoide.pt.billing.authorization.Authorization$Status r3 = p005cm.aptoide.p006pt.billing.authorization.Authorization.Status.PROCESSING
            r4 = 30
            r0[r4] = r2
            r16 = r3
            goto L_0x0147
        L_0x0136:
            cm.aptoide.pt.billing.authorization.Authorization$Status r3 = p005cm.aptoide.p006pt.billing.authorization.Authorization.Status.PENDING
            r4 = 29
            r0[r4] = r2
            r16 = r3
            goto L_0x0147
        L_0x013f:
            cm.aptoide.pt.billing.authorization.Authorization$Status r3 = p005cm.aptoide.p006pt.billing.authorization.Authorization.Status.REDEEMED
            r4 = 28
            r0[r4] = r2
            r16 = r3
        L_0x0147:
            r14 = r19
            cm.aptoide.pt.billing.authorization.AuthorizationFactory r3 = r14.authorizationFactory
            r8 = 0
            r9 = 0
            r10 = 0
            r18 = 0
            java.lang.String r6 = "PAYPAL_SDK"
            r4 = r20
            r5 = r21
            r7 = r16
            r11 = r17
            r12 = r1
            r13 = r22
            r14 = r18
            cm.aptoide.pt.billing.authorization.Authorization r3 = r3.create(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r4 = 32
            r0[r4] = r2
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.networking.AuthorizationMapperV3.map(java.lang.String, java.lang.String, java.lang.String, cm.aptoide.pt.dataprovider.model.v3.TransactionResponse, cm.aptoide.pt.dataprovider.model.v3.PaidApp):cm.aptoide.pt.billing.authorization.Authorization");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00e9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p005cm.aptoide.p006pt.billing.authorization.Authorization getErrorAuthorization(java.util.List<p005cm.aptoide.p006pt.dataprovider.model.p008v3.ErrorResponse> r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, p005cm.aptoide.p006pt.billing.Price r35) {
        /*
            r28 = this;
            r0 = r28
            r1 = r29
            boolean[] r2 = $jacocoInit()
            cm.aptoide.pt.billing.authorization.AuthorizationFactory r3 = r0.authorizationFactory
            cm.aptoide.pt.billing.authorization.Authorization$Status r7 = p005cm.aptoide.p006pt.billing.authorization.Authorization.Status.FAILED
            r15 = 1
            r4 = 33
            r2[r4] = r15
            r8 = 0
            r9 = 0
            r10 = 0
            r14 = 0
            r4 = r30
            r5 = r32
            r6 = r33
            r11 = r35
            r12 = r34
            r13 = r31
            cm.aptoide.pt.billing.authorization.Authorization r3 = r3.create(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r4 = 34
            r2[r4] = r15
            if (r1 != 0) goto L_0x0030
            r4 = 35
            r2[r4] = r15
            goto L_0x003a
        L_0x0030:
            boolean r4 = r29.isEmpty()
            if (r4 == 0) goto L_0x003f
            r4 = 36
            r2[r4] = r15
        L_0x003a:
            r4 = 37
            r2[r4] = r15
            return r3
        L_0x003f:
            r4 = 0
            java.lang.Object r4 = r1.get(r4)
            cm.aptoide.pt.dataprovider.model.v3.ErrorResponse r4 = (p005cm.aptoide.p006pt.dataprovider.model.p008v3.ErrorResponse) r4
            r5 = 38
            r2[r5] = r15
            java.lang.String r5 = r4.code
            java.lang.String r6 = "PRODUCT-204"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x0059
            r5 = 39
            r2[r5] = r15
            goto L_0x0083
        L_0x0059:
            java.lang.String r5 = r4.code
            r6 = 40
            r2[r6] = r15
            java.lang.String r6 = "PRODUCT-209"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x006c
            r5 = 41
            r2[r5] = r15
            goto L_0x0083
        L_0x006c:
            java.lang.String r5 = r4.code
            r6 = 42
            r2[r6] = r15
            java.lang.String r6 = "PRODUCT-214"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x007f
            r5 = 43
            r2[r5] = r15
            goto L_0x00a5
        L_0x007f:
            r5 = 44
            r2[r5] = r15
        L_0x0083:
            cm.aptoide.pt.billing.authorization.AuthorizationFactory r5 = r0.authorizationFactory
            cm.aptoide.pt.billing.authorization.Authorization$Status r20 = p005cm.aptoide.p006pt.billing.authorization.Authorization.Status.PENDING
            r21 = 0
            r22 = 0
            r23 = 0
            r27 = 0
            r16 = r5
            r17 = r30
            r18 = r32
            r19 = r33
            r24 = r35
            r25 = r34
            r26 = r31
            cm.aptoide.pt.billing.authorization.Authorization r3 = r16.create(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r5 = 45
            r2[r5] = r15
        L_0x00a5:
            java.lang.String r5 = r4.code
            java.lang.String r6 = "PRODUCT-200"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x00b4
            r5 = 46
            r2[r5] = r15
            goto L_0x00da
        L_0x00b4:
            r5 = 47
            r2[r5] = r15
            cm.aptoide.pt.billing.authorization.AuthorizationFactory r5 = r0.authorizationFactory
            cm.aptoide.pt.billing.authorization.Authorization$Status r20 = p005cm.aptoide.p006pt.billing.authorization.Authorization.Status.ACTIVE
            r21 = 0
            r22 = 0
            r23 = 0
            r27 = 0
            r16 = r5
            r17 = r30
            r18 = r32
            r19 = r33
            r24 = r35
            r25 = r34
            r26 = r31
            cm.aptoide.pt.billing.authorization.Authorization r3 = r16.create(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r5 = 48
            r2[r5] = r15
        L_0x00da:
            java.lang.String r5 = r4.code
            java.lang.String r6 = "PRODUCT-216"
            boolean r5 = r6.equals(r5)
            if (r5 != 0) goto L_0x00e9
            r5 = 49
            r2[r5] = r15
            goto L_0x010f
        L_0x00e9:
            r5 = 50
            r2[r5] = r15
            cm.aptoide.pt.billing.authorization.AuthorizationFactory r5 = r0.authorizationFactory
            cm.aptoide.pt.billing.authorization.Authorization$Status r20 = p005cm.aptoide.p006pt.billing.authorization.Authorization.Status.PROCESSING
            r21 = 0
            r22 = 0
            r23 = 0
            r27 = 0
            r16 = r5
            r17 = r30
            r18 = r32
            r19 = r33
            r24 = r35
            r25 = r34
            r26 = r31
            cm.aptoide.pt.billing.authorization.Authorization r3 = r16.create(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r5 = 51
            r2[r5] = r15
        L_0x010f:
            r5 = 52
            r2[r5] = r15
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.networking.AuthorizationMapperV3.getErrorAuthorization(java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, cm.aptoide.pt.billing.Price):cm.aptoide.pt.billing.authorization.Authorization");
    }
}
