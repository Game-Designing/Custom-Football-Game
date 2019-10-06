package p005cm.aptoide.p006pt.billing.authorization;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Price;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;

/* renamed from: cm.aptoide.pt.billing.authorization.AuthorizationFactory */
public class AuthorizationFactory {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String ADYEN_SDK = "ADYEN_SDK";
    public static final String PAYPAL_SDK = "PAYPAL_SDK";

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4694144830761982877L, "cm/aptoide/pt/billing/authorization/AuthorizationFactory", 14);
        $jacocoData = probes;
        return probes;
    }

    public AuthorizationFactory() {
        $jacocoInit()[0] = true;
    }

    public Authorization create(String id, String customerId, String type, Status status, String url, String redirectUrl, String metadata, Price price, String description, String transactionId, String session) {
        String str = id;
        String str2 = customerId;
        String str3 = type;
        Status status2 = status;
        String str4 = transactionId;
        boolean[] $jacocoInit = $jacocoInit();
        if (str3 == null) {
            $jacocoInit[1] = true;
            Authorization authorization = new Authorization(str, str2, status2, str4);
            $jacocoInit[2] = true;
            return authorization;
        }
        char c = 65535;
        int hashCode = type.hashCode();
        if (hashCode != 349507790) {
            if (hashCode != 460369818) {
                $jacocoInit[3] = true;
            } else if (!str3.equals(ADYEN_SDK)) {
                $jacocoInit[6] = true;
            } else {
                $jacocoInit[7] = true;
                c = 1;
            }
        } else if (!str3.equals(PAYPAL_SDK)) {
            $jacocoInit[4] = true;
        } else {
            c = 0;
            $jacocoInit[5] = true;
        }
        if (c == 0) {
            PayPalAuthorization payPalAuthorization = new PayPalAuthorization(id, customerId, status, transactionId, metadata, price, description);
            $jacocoInit[8] = true;
            return payPalAuthorization;
        } else if (c != 1) {
            Authorization authorization2 = new Authorization(str, str2, status2, str4);
            $jacocoInit[10] = true;
            return authorization2;
        } else {
            AdyenAuthorization adyenAuthorization = new AdyenAuthorization(id, customerId, status, transactionId, session, metadata);
            $jacocoInit[9] = true;
            return adyenAuthorization;
        }
    }

    public String getType(Authorization authorization) {
        boolean[] $jacocoInit = $jacocoInit();
        if (authorization instanceof AdyenAuthorization) {
            $jacocoInit[11] = true;
            return ADYEN_SDK;
        } else if (authorization instanceof PayPalAuthorization) {
            $jacocoInit[12] = true;
            return PAYPAL_SDK;
        } else {
            $jacocoInit[13] = true;
            return null;
        }
    }
}
