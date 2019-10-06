package p005cm.aptoide.p006pt.database.realm;

import p024io.realm.C0106Z;
import p024io.realm.C13994H;
import p024io.realm.internal.C7344p;

/* renamed from: cm.aptoide.pt.database.realm.RealmAuthorization */
public class RealmAuthorization extends C0106Z implements C13994H {

    /* renamed from: ID */
    public static final String f6068ID = "id";
    private double amount;
    private String currency;
    private String currencySymbol;
    private String customerId;
    private String description;

    /* renamed from: id */
    private String f6069id;
    private String metadata;
    private String status;
    private String transactionId;
    private String type;

    public double realmGet$amount() {
        return this.amount;
    }

    public String realmGet$currency() {
        return this.currency;
    }

    public String realmGet$currencySymbol() {
        return this.currencySymbol;
    }

    public String realmGet$customerId() {
        return this.customerId;
    }

    public String realmGet$description() {
        return this.description;
    }

    public String realmGet$id() {
        return this.f6069id;
    }

    public String realmGet$metadata() {
        return this.metadata;
    }

    public String realmGet$status() {
        return this.status;
    }

    public String realmGet$transactionId() {
        return this.transactionId;
    }

    public String realmGet$type() {
        return this.type;
    }

    public void realmSet$amount(double d) {
        this.amount = d;
    }

    public void realmSet$currency(String str) {
        this.currency = str;
    }

    public void realmSet$currencySymbol(String str) {
        this.currencySymbol = str;
    }

    public void realmSet$customerId(String str) {
        this.customerId = str;
    }

    public void realmSet$description(String str) {
        this.description = str;
    }

    public void realmSet$id(String str) {
        this.f6069id = str;
    }

    public void realmSet$metadata(String str) {
        this.metadata = str;
    }

    public void realmSet$status(String str) {
        this.status = str;
    }

    public void realmSet$transactionId(String str) {
        this.transactionId = str;
    }

    public void realmSet$type(String str) {
        this.type = str;
    }

    public RealmAuthorization() {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
    }

    public RealmAuthorization(String id, String customerId2, String status2, String transactionId2, String metadata2, String description2, double amount2, String currency2, String currencySymbol2, String type2) {
        if (this instanceof C7344p) {
            ((C7344p) this).mo23792b();
        }
        realmSet$id(id);
        realmSet$transactionId(transactionId2);
        realmSet$metadata(metadata2);
        realmSet$status(status2);
        realmSet$customerId(customerId2);
        realmSet$description(description2);
        realmSet$amount(amount2);
        realmSet$currency(currency2);
        realmSet$currencySymbol(currencySymbol2);
        realmSet$type(type2);
    }

    public String getId() {
        return realmGet$id();
    }

    public String getCustomerId() {
        return realmGet$customerId();
    }

    public String getMetadata() {
        return realmGet$metadata();
    }

    public String getStatus() {
        return realmGet$status();
    }

    public String getTransactionId() {
        return realmGet$transactionId();
    }

    public double getAmount() {
        return realmGet$amount();
    }

    public String getCurrency() {
        return realmGet$currency();
    }

    public String getCurrencySymbol() {
        return realmGet$currencySymbol();
    }

    public String getDescription() {
        return realmGet$description();
    }

    public String getType() {
        return realmGet$type();
    }
}
