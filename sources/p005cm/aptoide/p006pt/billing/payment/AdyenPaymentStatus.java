package p005cm.aptoide.p006pt.billing.payment;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p019d.p135a.p136a.C6919k;
import p019d.p135a.p136a.p137a.C6846b;
import p019d.p135a.p136a.p137a.C6847c;
import p019d.p135a.p136a.p137a.C6849e;
import p019d.p135a.p136a.p137a.C6854i;
import p019d.p135a.p136a.p139c.C6889d;
import p019d.p135a.p136a.p139c.C6896i;

/* renamed from: cm.aptoide.pt.billing.payment.AdyenPaymentStatus */
public class AdyenPaymentStatus {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final C6846b dataCallback;
    private final C6847c detailsCallback;
    private final C6919k paymentRequest;
    private final List<C6889d> recurringServices;
    private final String redirectUrl;
    private final C6896i result;
    private final C6849e serviceCallback;
    private final List<C6889d> services;
    private final String token;
    private final C6854i uriCallback;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(4241877175020932L, "cm/aptoide/pt/billing/payment/AdyenPaymentStatus", 11);
        $jacocoData = probes;
        return probes;
    }

    public AdyenPaymentStatus(String token2, C6846b dataCallback2, C6896i result2, C6849e serviceCallback2, List<C6889d> recurringServices2, List<C6889d> services2, C6847c detailsCallback2, C6919k paymentRequest2, String redirectUrl2, C6854i uriCallback2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.token = token2;
        this.dataCallback = dataCallback2;
        this.result = result2;
        this.serviceCallback = serviceCallback2;
        this.recurringServices = recurringServices2;
        this.services = services2;
        this.detailsCallback = detailsCallback2;
        this.paymentRequest = paymentRequest2;
        this.redirectUrl = redirectUrl2;
        this.uriCallback = uriCallback2;
        $jacocoInit[0] = true;
    }

    public List<C6889d> getServices() {
        boolean[] $jacocoInit = $jacocoInit();
        List<C6889d> list = this.services;
        $jacocoInit[1] = true;
        return list;
    }

    public String getToken() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.token;
        $jacocoInit[2] = true;
        return str;
    }

    public String getRedirectUrl() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.redirectUrl;
        $jacocoInit[3] = true;
        return str;
    }

    public C6846b getDataCallback() {
        boolean[] $jacocoInit = $jacocoInit();
        C6846b bVar = this.dataCallback;
        $jacocoInit[4] = true;
        return bVar;
    }

    public C6896i getResult() {
        boolean[] $jacocoInit = $jacocoInit();
        C6896i iVar = this.result;
        $jacocoInit[5] = true;
        return iVar;
    }

    public C6849e getServiceCallback() {
        boolean[] $jacocoInit = $jacocoInit();
        C6849e eVar = this.serviceCallback;
        $jacocoInit[6] = true;
        return eVar;
    }

    public C6847c getDetailsCallback() {
        boolean[] $jacocoInit = $jacocoInit();
        C6847c cVar = this.detailsCallback;
        $jacocoInit[7] = true;
        return cVar;
    }

    public C6919k getPaymentRequest() {
        boolean[] $jacocoInit = $jacocoInit();
        C6919k kVar = this.paymentRequest;
        $jacocoInit[8] = true;
        return kVar;
    }

    public List<C6889d> getRecurringServices() {
        boolean[] $jacocoInit = $jacocoInit();
        List<C6889d> list = this.recurringServices;
        $jacocoInit[9] = true;
        return list;
    }

    public C6854i getUriCallback() {
        boolean[] $jacocoInit = $jacocoInit();
        C6854i iVar = this.uriCallback;
        $jacocoInit[10] = true;
        return iVar;
    }
}
