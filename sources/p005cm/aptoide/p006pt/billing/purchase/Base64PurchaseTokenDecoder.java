package p005cm.aptoide.p006pt.billing.purchase;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.PurchaseTokenDecoder;
import p362h.C14195j;

/* renamed from: cm.aptoide.pt.billing.purchase.Base64PurchaseTokenDecoder */
public class Base64PurchaseTokenDecoder implements PurchaseTokenDecoder {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(844103342177142500L, "cm/aptoide/pt/billing/purchase/Base64PurchaseTokenDecoder", 3);
        $jacocoData = probes;
        return probes;
    }

    public Base64PurchaseTokenDecoder() {
        $jacocoInit()[0] = true;
    }

    public String decode(String purchaseToken) {
        boolean[] $jacocoInit = $jacocoInit();
        C14195j a = C14195j.m45645a(purchaseToken);
        $jacocoInit[1] = true;
        String v = a.mo44289v();
        $jacocoInit[2] = true;
        return v;
    }
}
