package p005cm.aptoide.p006pt.billing.payment;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.billing.payment.AdyenPaymentService */
public class AdyenPaymentService extends PaymentService {
    private static transient /* synthetic */ boolean[] $jacocoData;

    /* renamed from: adyen reason: collision with root package name */
    private final Adyen f44400adyen;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-966410908677889518L, "cm/aptoide/pt/billing/payment/AdyenPaymentService", 2);
        $jacocoData = probes;
        return probes;
    }

    public AdyenPaymentService(String id, String type, String name, String description, String icon, Adyen adyen2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(id, type, name, description, icon);
        this.f44400adyen = adyen2;
        $jacocoInit[0] = true;
    }

    public Single<String> getToken() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<String> createToken = this.f44400adyen.createToken();
        $jacocoInit[1] = true;
        return createToken;
    }
}
