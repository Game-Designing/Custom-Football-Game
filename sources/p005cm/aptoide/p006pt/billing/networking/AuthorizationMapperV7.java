package p005cm.aptoide.p006pt.billing.networking;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.BillingIdManager;
import p005cm.aptoide.p006pt.billing.Price;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationFactory;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetAuthorizationRequest.ResponseBody;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetAuthorizationRequest.ResponseBody.Authorization.Metadata;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.billing.GetAuthorizationRequest.ResponseBody.Authorization.User;

/* renamed from: cm.aptoide.pt.billing.networking.AuthorizationMapperV7 */
public class AuthorizationMapperV7 {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthorizationFactory authorizationFactory;
    private final BillingIdManager billingIdManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5649935098392646444L, "cm/aptoide/pt/billing/networking/AuthorizationMapperV7", 20);
        $jacocoData = probes;
        return probes;
    }

    public AuthorizationMapperV7(AuthorizationFactory authorizationFactory2, BillingIdManager billingIdManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authorizationFactory = authorizationFactory2;
        this.billingIdManager = billingIdManager2;
        $jacocoInit[0] = true;
    }

    public Authorization map(ResponseBody.Authorization response, String transactionId) {
        String session;
        String description;
        String redirectUrl;
        String url;
        boolean[] $jacocoInit = $jacocoInit();
        Price price = null;
        $jacocoInit[1] = true;
        if (response.getPrice() == null) {
            $jacocoInit[2] = true;
        } else {
            $jacocoInit[3] = true;
            ResponseBody.Authorization.Price price2 = response.getPrice();
            $jacocoInit[4] = true;
            double amount = price2.getAmount();
            ResponseBody.Authorization.Price price3 = response.getPrice();
            $jacocoInit[5] = true;
            String currency = price3.getCurrency();
            ResponseBody.Authorization.Price price4 = response.getPrice();
            $jacocoInit[6] = true;
            price = new Price(amount, currency, price4.getCurrencySymbol());
            $jacocoInit[7] = true;
        }
        Metadata metadata = response.getData();
        if (metadata == null) {
            $jacocoInit[8] = true;
            url = null;
            redirectUrl = null;
            description = null;
            session = null;
        } else {
            $jacocoInit[9] = true;
            String url2 = metadata.getUrl();
            $jacocoInit[10] = true;
            String redirectUrl2 = metadata.getRedirectUrl();
            $jacocoInit[11] = true;
            String description2 = metadata.getDescription();
            $jacocoInit[12] = true;
            String session2 = metadata.getSession();
            $jacocoInit[13] = true;
            url = url2;
            redirectUrl = redirectUrl2;
            description = description2;
            session = session2;
        }
        AuthorizationFactory authorizationFactory2 = this.authorizationFactory;
        String generateAuthorizationId = this.billingIdManager.generateAuthorizationId(response.getId());
        $jacocoInit[14] = true;
        User user = response.getUser();
        $jacocoInit[15] = true;
        long id = user.getId();
        $jacocoInit[16] = true;
        String valueOf = String.valueOf(id);
        $jacocoInit[17] = true;
        String type = response.getType();
        Status valueOf2 = Status.valueOf(response.getStatus());
        $jacocoInit[18] = true;
        Authorization create = authorizationFactory2.create(generateAuthorizationId, valueOf, type, valueOf2, url, redirectUrl, null, price, description, transactionId, session);
        $jacocoInit[19] = true;
        return create;
    }
}
