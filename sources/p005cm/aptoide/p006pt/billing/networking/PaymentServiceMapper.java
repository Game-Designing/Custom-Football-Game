package p005cm.aptoide.p006pt.billing.networking;

import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.analytics.implementation.CrashLogger;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.payment.Adyen;
import p005cm.aptoide.p006pt.billing.payment.PaymentService;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetServicesRequest.ResponseBody.Service;

/* renamed from: cm.aptoide.pt.billing.networking.PaymentServiceMapper */
public class PaymentServiceMapper {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ADYEN = "ADYEN";
    public static final String PAYPAL = "PAYPAL";

    /* renamed from: adyen reason: collision with root package name */
    private final Adyen f44399adyen;
    private final BillingIdManager billingIdManager;
    private final CrashLogger crashLogger;
    private final int currentAPILevel;
    private final int minimumAPILevelAdyen;
    private final int minimumAPILevelPayPal;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-5936394111257736541L, "cm/aptoide/pt/billing/networking/PaymentServiceMapper", 25);
        $jacocoData = probes;
        return probes;
    }

    public PaymentServiceMapper(CrashLogger crashLogger2, BillingIdManager billingIdManager2, Adyen adyen2, int currentAPILevel2, int minimumAPILevelAdyen2, int minimumAPILevelPayPal2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.crashLogger = crashLogger2;
        this.billingIdManager = billingIdManager2;
        this.f44399adyen = adyen2;
        this.currentAPILevel = currentAPILevel2;
        this.minimumAPILevelAdyen = minimumAPILevelAdyen2;
        this.minimumAPILevelPayPal = minimumAPILevelPayPal2;
        $jacocoInit[0] = true;
    }

    public List<PaymentService> map(List<Service> responseList) {
        boolean[] $jacocoInit = $jacocoInit();
        List<PaymentService> paymentServices = new ArrayList<>(responseList.size());
        $jacocoInit[1] = true;
        $jacocoInit[2] = true;
        for (Service service : responseList) {
            try {
                $jacocoInit[3] = true;
                try {
                    paymentServices.add(map(service));
                    $jacocoInit[4] = true;
                } catch (IllegalArgumentException e) {
                    exception = e;
                    $jacocoInit[5] = true;
                    this.crashLogger.log(exception);
                    $jacocoInit[6] = true;
                    $jacocoInit[7] = true;
                }
            } catch (IllegalArgumentException e2) {
                exception = e2;
                $jacocoInit[5] = true;
                this.crashLogger.log(exception);
                $jacocoInit[6] = true;
                $jacocoInit[7] = true;
            }
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
        return paymentServices;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private p005cm.aptoide.p006pt.billing.payment.PaymentService map(p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetServicesRequest.ResponseBody.Service r13) {
        /*
            r12 = this;
            boolean[] r0 = $jacocoInit()
            java.lang.String r1 = r13.getName()
            int r2 = r1.hashCode()
            r3 = -1941875981(0xffffffff8c4152f3, float:-1.4893141E-31)
            r4 = 1
            if (r2 == r3) goto L_0x002f
            r3 = 62142399(0x3b437bf, float:1.0592248E-36)
            if (r2 == r3) goto L_0x001c
            r1 = 9
            r0[r1] = r4
            goto L_0x003b
        L_0x001c:
            java.lang.String r2 = "ADYEN"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x0029
            r1 = 12
            r0[r1] = r4
            goto L_0x003b
        L_0x0029:
            r1 = 13
            r0[r1] = r4
            r1 = 1
            goto L_0x0042
        L_0x002f:
            java.lang.String r2 = "PAYPAL"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x003d
            r1 = 10
            r0[r1] = r4
        L_0x003b:
            r1 = -1
            goto L_0x0042
        L_0x003d:
            r1 = 0
            r2 = 11
            r0[r2] = r4
        L_0x0042:
            if (r1 == 0) goto L_0x00bb
            if (r1 != r4) goto L_0x009c
            int r1 = r12.currentAPILevel
            int r2 = r12.minimumAPILevelAdyen
            if (r1 < r2) goto L_0x007f
            r1 = 19
            r0[r1] = r4
            cm.aptoide.pt.billing.payment.AdyenPaymentService r1 = new cm.aptoide.pt.billing.payment.AdyenPaymentService
            cm.aptoide.pt.billing.BillingIdManager r2 = r12.billingIdManager
            long r5 = r13.getId()
            java.lang.String r6 = r2.generateServiceId(r5)
            r2 = 20
            r0[r2] = r4
            java.lang.String r7 = r13.getName()
            java.lang.String r8 = r13.getLabel()
            java.lang.String r9 = r13.getDescription()
            r2 = 21
            r0[r2] = r4
            java.lang.String r10 = r13.getIcon()
            cm.aptoide.pt.billing.payment.Adyen r11 = r12.f44399adyen
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2 = 22
            r0[r2] = r4
            return r1
        L_0x007f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Adyen not supported in Android API lower than "
            r2.append(r3)
            int r3 = r12.minimumAPILevelAdyen
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 23
            r0[r2] = r4
            throw r1
        L_0x009c:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Payment service not supported: "
            r2.append(r3)
            java.lang.String r3 = r13.getName()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 24
            r0[r2] = r4
            throw r1
        L_0x00bb:
            int r1 = r12.currentAPILevel
            int r2 = r12.minimumAPILevelPayPal
            if (r1 < r2) goto L_0x00f2
            r1 = 14
            r0[r1] = r4
            cm.aptoide.pt.billing.payment.PaymentService r1 = new cm.aptoide.pt.billing.payment.PaymentService
            cm.aptoide.pt.billing.BillingIdManager r2 = r12.billingIdManager
            long r5 = r13.getId()
            java.lang.String r6 = r2.generateServiceId(r5)
            r2 = 15
            r0[r2] = r4
            java.lang.String r7 = r13.getName()
            java.lang.String r8 = r13.getLabel()
            java.lang.String r9 = r13.getDescription()
            r2 = 16
            r0[r2] = r4
            java.lang.String r10 = r13.getIcon()
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10)
            r2 = 17
            r0[r2] = r4
            return r1
        L_0x00f2:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "PayPal not supported in Android API lower than "
            r2.append(r3)
            int r3 = r12.minimumAPILevelPayPal
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            r2 = 18
            r0[r2] = r4
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.billing.networking.PaymentServiceMapper.map(cm.aptoide.pt.dataprovider.ws.v7.billing.GetServicesRequest$ResponseBody$Service):cm.aptoide.pt.billing.payment.PaymentService");
    }
}
