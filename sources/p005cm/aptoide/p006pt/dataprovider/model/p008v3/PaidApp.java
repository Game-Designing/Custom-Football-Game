package p005cm.aptoide.p006pt.dataprovider.model.p008v3;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/* renamed from: cm.aptoide.pt.dataprovider.model.v3.PaidApp */
public class PaidApp extends BaseV3Response {
    @JsonProperty("meta")
    private App app;
    @JsonProperty("apk")
    public Path path;
    @JsonProperty("payment")
    private Payment payment;

    /* renamed from: cm.aptoide.pt.dataprovider.model.v3.PaidApp$App */
    public static class App {
        @JsonProperty("description")
        private String description;
        @JsonProperty("title")
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name2) {
            this.name = name2;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description2) {
            this.description = description2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof App;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof App)) {
                return false;
            }
            App other = (App) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String name2 = getName();
            Object other$name = other.getName();
            if (name2 != null ? !name2.equals(other$name) : other$name != null) {
                return false;
            }
            String description2 = getDescription();
            Object other$description = other.getDescription();
            if (description2 != null ? description2.equals(other$description) : other$description == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String name2 = getName();
            int i = 43;
            int result = (1 * 59) + (name2 == null ? 43 : name2.hashCode());
            String description2 = getDescription();
            int i2 = result * 59;
            if (description2 != null) {
                i = description2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PaidApp.App(name=");
            sb.append(getName());
            sb.append(", description=");
            sb.append(getDescription());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v3.PaidApp$Metadata */
    public static class Metadata {
        @JsonProperty("id")
        private int productId;

        public int getProductId() {
            return this.productId;
        }

        public void setProductId(int productId2) {
            this.productId = productId2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Metadata;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Metadata)) {
                return false;
            }
            Metadata other = (Metadata) o;
            if (other.canEqual(this) && getProductId() == other.getProductId()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (1 * 59) + getProductId();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PaidApp.Metadata(productId=");
            sb.append(getProductId());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v3.PaidApp$Path */
    public static class Path {
        @JsonProperty("icon")
        private String alternativeIcon;
        @JsonProperty("id")
        private int appId;
        @JsonProperty("icon_hd")
        private String icon;
        @JsonProperty("repo")
        private String storeName;
        @JsonProperty("path")
        private String stringPath;
        @JsonProperty("vercode")
        private int versionCode;

        public String getStringPath() {
            return this.stringPath;
        }

        public void setStringPath(String stringPath2) {
            this.stringPath = stringPath2;
        }

        public int getAppId() {
            return this.appId;
        }

        public void setAppId(int appId2) {
            this.appId = appId2;
        }

        public String getStoreName() {
            return this.storeName;
        }

        public void setStoreName(String storeName2) {
            this.storeName = storeName2;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String icon2) {
            this.icon = icon2;
        }

        public int getVersionCode() {
            return this.versionCode;
        }

        public void setVersionCode(int versionCode2) {
            this.versionCode = versionCode2;
        }

        public String getAlternativeIcon() {
            return this.alternativeIcon;
        }

        public void setAlternativeIcon(String alternativeIcon2) {
            this.alternativeIcon = alternativeIcon2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Path;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Path)) {
                return false;
            }
            Path other = (Path) o;
            if (!other.canEqual(this)) {
                return false;
            }
            String stringPath2 = getStringPath();
            Object other$stringPath = other.getStringPath();
            if (stringPath2 != null ? !stringPath2.equals(other$stringPath) : other$stringPath != null) {
                return false;
            }
            if (getAppId() != other.getAppId()) {
                return false;
            }
            String storeName2 = getStoreName();
            Object other$storeName = other.getStoreName();
            if (storeName2 != null ? !storeName2.equals(other$storeName) : other$storeName != null) {
                return false;
            }
            String icon2 = getIcon();
            Object other$icon = other.getIcon();
            if (icon2 != null ? !icon2.equals(other$icon) : other$icon != null) {
                return false;
            }
            if (getVersionCode() != other.getVersionCode()) {
                return false;
            }
            String alternativeIcon2 = getAlternativeIcon();
            Object other$alternativeIcon = other.getAlternativeIcon();
            if (alternativeIcon2 != null ? alternativeIcon2.equals(other$alternativeIcon) : other$alternativeIcon == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String stringPath2 = getStringPath();
            int i = 43;
            int result = (((1 * 59) + (stringPath2 == null ? 43 : stringPath2.hashCode())) * 59) + getAppId();
            String storeName2 = getStoreName();
            int result2 = (result * 59) + (storeName2 == null ? 43 : storeName2.hashCode());
            String icon2 = getIcon();
            int result3 = (((result2 * 59) + (icon2 == null ? 43 : icon2.hashCode())) * 59) + getVersionCode();
            String alternativeIcon2 = getAlternativeIcon();
            int i2 = result3 * 59;
            if (alternativeIcon2 != null) {
                i = alternativeIcon2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PaidApp.Path(stringPath=");
            sb.append(getStringPath());
            sb.append(", appId=");
            sb.append(getAppId());
            sb.append(", storeName=");
            sb.append(getStoreName());
            sb.append(", icon=");
            sb.append(getIcon());
            sb.append(", versionCode=");
            sb.append(getVersionCode());
            sb.append(", alternativeIcon=");
            sb.append(getAlternativeIcon());
            sb.append(")");
            return sb.toString();
        }
    }

    /* renamed from: cm.aptoide.pt.dataprovider.model.v3.PaidApp$Payment */
    public static class Payment {
        @JsonProperty("amount")
        private Double amount;
        @JsonProperty("metadata")
        private Metadata metadata;
        @JsonProperty("payment_services")
        private List<PaymentServiceResponse> paymentServices;
        @JsonProperty("status")
        private String status;
        @JsonProperty("currency_symbol")
        private String symbol;

        public boolean isPaid() {
            return this.status.equalsIgnoreCase("OK");
        }

        public Double getAmount() {
            return this.amount;
        }

        public void setAmount(Double amount2) {
            this.amount = amount2;
        }

        public String getSymbol() {
            return this.symbol;
        }

        public void setSymbol(String symbol2) {
            this.symbol = symbol2;
        }

        public Metadata getMetadata() {
            return this.metadata;
        }

        public void setMetadata(Metadata metadata2) {
            this.metadata = metadata2;
        }

        public List<PaymentServiceResponse> getPaymentServices() {
            return this.paymentServices;
        }

        public void setPaymentServices(List<PaymentServiceResponse> paymentServices2) {
            this.paymentServices = paymentServices2;
        }

        public String getStatus() {
            return this.status;
        }

        public void setStatus(String status2) {
            this.status = status2;
        }

        public int hashCode() {
            Double amount2 = getAmount();
            int i = 43;
            int result = (1 * 59) + (amount2 == null ? 43 : amount2.hashCode());
            String symbol2 = getSymbol();
            int result2 = (result * 59) + (symbol2 == null ? 43 : symbol2.hashCode());
            Metadata metadata2 = getMetadata();
            int result3 = (result2 * 59) + (metadata2 == null ? 43 : metadata2.hashCode());
            Object $paymentServices = getPaymentServices();
            int result4 = (result3 * 59) + ($paymentServices == null ? 43 : $paymentServices.hashCode());
            String status2 = getStatus();
            int i2 = result4 * 59;
            if (status2 != null) {
                i = status2.hashCode();
            }
            return i2 + i;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object other) {
            return other instanceof Payment;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Payment)) {
                return false;
            }
            Payment other = (Payment) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Double amount2 = getAmount();
            Object other$amount = other.getAmount();
            if (amount2 != null ? !amount2.equals(other$amount) : other$amount != null) {
                return false;
            }
            String symbol2 = getSymbol();
            Object other$symbol = other.getSymbol();
            if (symbol2 != null ? !symbol2.equals(other$symbol) : other$symbol != null) {
                return false;
            }
            Metadata metadata2 = getMetadata();
            Object other$metadata = other.getMetadata();
            if (metadata2 != null ? !metadata2.equals(other$metadata) : other$metadata != null) {
                return false;
            }
            Object this$paymentServices = getPaymentServices();
            Object other$paymentServices = other.getPaymentServices();
            if (this$paymentServices != null ? !this$paymentServices.equals(other$paymentServices) : other$paymentServices != null) {
                return false;
            }
            String status2 = getStatus();
            Object other$status = other.getStatus();
            if (status2 != null ? status2.equals(other$status) : other$status == null) {
                return true;
            }
            return false;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("PaidApp.Payment(amount=");
            sb.append(getAmount());
            sb.append(", symbol=");
            sb.append(getSymbol());
            sb.append(", metadata=");
            sb.append(getMetadata());
            sb.append(", paymentServices=");
            sb.append(getPaymentServices());
            sb.append(", status=");
            sb.append(getStatus());
            sb.append(")");
            return sb.toString();
        }
    }

    public boolean isPaid() {
        Payment payment2 = this.payment;
        return (payment2 == null || payment2.getAmount() == null || this.payment.getAmount().floatValue() <= 0.0f) ? false : true;
    }

    public Path getPath() {
        return this.path;
    }

    public void setPath(Path path2) {
        this.path = path2;
    }

    public Payment getPayment() {
        return this.payment;
    }

    public void setPayment(Payment payment2) {
        this.payment = payment2;
    }

    public App getApp() {
        return this.app;
    }

    public void setApp(App app2) {
        this.app = app2;
    }

    public int hashCode() {
        int result = (1 * 59) + super.hashCode();
        Path path2 = getPath();
        int i = 43;
        int result2 = (result * 59) + (path2 == null ? 43 : path2.hashCode());
        Payment payment2 = getPayment();
        int result3 = (result2 * 59) + (payment2 == null ? 43 : payment2.hashCode());
        App app2 = getApp();
        int i2 = result3 * 59;
        if (app2 != null) {
            i = app2.hashCode();
        }
        return i2 + i;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PaidApp)) {
            return false;
        }
        PaidApp other = (PaidApp) o;
        if (!other.canEqual(this) || !super.equals(o)) {
            return false;
        }
        Path path2 = getPath();
        Object other$path = other.getPath();
        if (path2 != null ? !path2.equals(other$path) : other$path != null) {
            return false;
        }
        Payment payment2 = getPayment();
        Object other$payment = other.getPayment();
        if (payment2 != null ? !payment2.equals(other$payment) : other$payment != null) {
            return false;
        }
        App app2 = getApp();
        Object other$app = other.getApp();
        if (app2 != null ? app2.equals(other$app) : other$app == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaidApp(path=");
        sb.append(getPath());
        sb.append(", payment=");
        sb.append(getPayment());
        sb.append(", app=");
        sb.append(getApp());
        sb.append(")");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object other) {
        return other instanceof PaidApp;
    }
}
