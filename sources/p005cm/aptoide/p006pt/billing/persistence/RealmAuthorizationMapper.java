package p005cm.aptoide.p006pt.billing.persistence;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.billing.Price;
import p005cm.aptoide.p006pt.billing.authorization.AdyenAuthorization;
import p005cm.aptoide.p006pt.billing.authorization.Authorization;
import p005cm.aptoide.p006pt.billing.authorization.Authorization.Status;
import p005cm.aptoide.p006pt.billing.authorization.AuthorizationFactory;
import p005cm.aptoide.p006pt.billing.authorization.MetadataAuthorization;
import p005cm.aptoide.p006pt.billing.authorization.PayPalAuthorization;
import p005cm.aptoide.p006pt.database.realm.RealmAuthorization;

/* renamed from: cm.aptoide.pt.billing.persistence.RealmAuthorizationMapper */
public class RealmAuthorizationMapper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final AuthorizationFactory authorizationFactory;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8840315816236973819L, "cm/aptoide/pt/billing/persistence/RealmAuthorizationMapper", 31);
        $jacocoData = probes;
        return probes;
    }

    public RealmAuthorizationMapper(AuthorizationFactory authorizationFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.authorizationFactory = authorizationFactory2;
        $jacocoInit[0] = true;
    }

    public RealmAuthorization map(Authorization authorization) {
        String currencySymbol;
        String currency;
        double amount;
        Authorization authorization2 = authorization;
        boolean[] $jacocoInit = $jacocoInit();
        String type = null;
        String metadata = null;
        if (!(authorization2 instanceof MetadataAuthorization)) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            metadata = ((MetadataAuthorization) authorization2).getMetadata();
            $jacocoInit[3] = true;
        }
        if (!(authorization2 instanceof AdyenAuthorization)) {
            $jacocoInit[4] = true;
        } else {
            type = AuthorizationFactory.ADYEN_SDK;
            $jacocoInit[5] = true;
        }
        String description = null;
        double amount2 = 0.0d;
        String currency2 = null;
        String currencySymbol2 = null;
        if (!(authorization2 instanceof PayPalAuthorization)) {
            $jacocoInit[6] = true;
            amount = 0.0d;
            currency = null;
            currencySymbol = null;
        } else {
            $jacocoInit[7] = true;
            description = ((PayPalAuthorization) authorization2).getDescription();
            $jacocoInit[8] = true;
            if (((PayPalAuthorization) authorization2).getPrice() == null) {
                $jacocoInit[9] = true;
            } else {
                $jacocoInit[10] = true;
                Price price = ((PayPalAuthorization) authorization2).getPrice();
                $jacocoInit[11] = true;
                amount2 = price.getAmount();
                $jacocoInit[12] = true;
                Price price2 = ((PayPalAuthorization) authorization2).getPrice();
                $jacocoInit[13] = true;
                currency2 = price2.getCurrency();
                $jacocoInit[14] = true;
                Price price3 = ((PayPalAuthorization) authorization2).getPrice();
                $jacocoInit[15] = true;
                currencySymbol2 = price3.getCurrencySymbol();
                $jacocoInit[16] = true;
            }
            type = AuthorizationFactory.PAYPAL_SDK;
            $jacocoInit[17] = true;
            amount = amount2;
            currency = currency2;
            currencySymbol = currencySymbol2;
        }
        if (type != null) {
            String id = authorization.getId();
            String customerId = authorization.getCustomerId();
            $jacocoInit[20] = true;
            Status status = authorization.getStatus();
            $jacocoInit[21] = true;
            RealmAuthorization realmAuthorization = new RealmAuthorization(id, customerId, status.name(), authorization.getTransactionId(), metadata, description, amount, currency, currencySymbol, type);
            $jacocoInit[22] = true;
            return realmAuthorization;
        }
        $jacocoInit[18] = true;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported Authorization. Can not map to RealmAuthorization");
        $jacocoInit[19] = true;
        throw illegalArgumentException;
    }

    public Authorization map(RealmAuthorization realmAuthorization) {
        boolean[] $jacocoInit = $jacocoInit();
        AuthorizationFactory authorizationFactory2 = this.authorizationFactory;
        String id = realmAuthorization.getId();
        $jacocoInit[23] = true;
        String customerId = realmAuthorization.getCustomerId();
        String type = realmAuthorization.getType();
        $jacocoInit[24] = true;
        Status valueOf = Status.valueOf(realmAuthorization.getStatus());
        $jacocoInit[25] = true;
        String metadata = realmAuthorization.getMetadata();
        $jacocoInit[26] = true;
        double amount = realmAuthorization.getAmount();
        String currency = realmAuthorization.getCurrency();
        $jacocoInit[27] = true;
        Price price = new Price(amount, currency, realmAuthorization.getCurrencySymbol());
        String description = realmAuthorization.getDescription();
        $jacocoInit[28] = true;
        String transactionId = realmAuthorization.getTransactionId();
        $jacocoInit[29] = true;
        Authorization create = authorizationFactory2.create(id, customerId, type, valueOf, null, null, metadata, price, description, transactionId, null);
        $jacocoInit[30] = true;
        return create;
    }
}
